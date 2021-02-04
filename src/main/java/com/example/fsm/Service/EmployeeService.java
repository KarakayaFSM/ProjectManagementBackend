package com.example.fsm.Service;

import com.example.fsm.Model.Employee.Employee;
import com.example.fsm.Repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public EmployeeService(EmployeeRepository repository,
                           ObjectMapper objectMapper, ObjectMapper objectMapper1) {
        this.repository = repository;
        this.objectMapper = objectMapper1;
    }

    public Optional<Employee> getEmployeeById(int employeeId) {
        return repository.findById(employeeId);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Optional<Employee> addEmployee(Employee employee) {

        Optional<Employee> optionalEmployee =
                repository.getEmployeeByEmail(employee.getEmail());

        if (optionalEmployee.isPresent()) {
            return Optional.empty();
        }

        Employee saved = repository.save(employee);

        return Optional.of(saved);
    }

    public boolean deleteEmployee(Integer employeeId) {
        boolean employeeExists = repository.existsById(employeeId);

        if (!employeeExists) {
            return false;
        }

        repository.deleteById(employeeId);
        return true;
    }

    public Optional<Employee> updateEmployee(int targetId, JsonPatch patch) {

        var optionalTarget = getEmployeeById(targetId);
        if (optionalTarget.isEmpty()) return Optional.empty();

        Employee patchedEmployee;

        try {
            patchedEmployee = applyPatchToEmployee(patch, optionalTarget.get());
        } catch (JsonPatchException | JsonProcessingException e) {
            e.printStackTrace();
            throw error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        repository.save(patchedEmployee);
        return Optional.of(patchedEmployee);
    }

    private Employee applyPatchToEmployee(JsonPatch patch, Employee employee)
            throws JsonPatchException, JsonProcessingException {
        JsonNode employeeNode = objectMapper.convertValue(employee, JsonNode.class);
        JsonNode patched = patch.apply(employeeNode);
        return objectMapper.treeToValue(patched, Employee.class);
    }

    public ResponseStatusException error(HttpStatus status) {
        return new ResponseStatusException(status);
    }

    public ResponseStatusException error(HttpStatus status, String message) {
        return new ResponseStatusException(status, message);
    }

    public ResponseEntity<?> OK(Employee employee) {
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    public ResponseEntity<?> OK() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
