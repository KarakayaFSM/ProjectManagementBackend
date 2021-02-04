package com.example.fsm.Controller;

import com.example.fsm.Model.Employee.Employee;
import com.example.fsm.Service.EmployeeService;
import com.github.fge.jsonpatch.JsonPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getById/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
        var optionalEmployee =
                employeeService.getEmployeeById(employeeId);

        if (optionalEmployee.isEmpty()) {
            throw employeeService.error(HttpStatus.NOT_FOUND,
                    "Employee with id " + employeeId + " not found");
        }

        return employeeService.OK(optionalEmployee.get());
    }

    @GetMapping("/getAll")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {

        var optionalEmployee = employeeService.addEmployee(employee);

        if (optionalEmployee.isEmpty()) {
            throw employeeService.error(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "This email address has already been taken");
        }

        return employeeService.OK(optionalEmployee.get());
    }

    @DeleteMapping(path = "/deleteById/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        boolean success = employeeService.deleteEmployee(employeeId);

        if (!success) {
            throw employeeService.error(HttpStatus.NOT_FOUND,
                    "Employee with id " + employeeId + " not found");
        }

        return employeeService.OK();
    }

    @PatchMapping(path = "/update/{targetId}", consumes = "application/json-patch+json")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer targetId,
                                            @RequestBody JsonPatch updates) {

        var optionalUpdated = employeeService
                .updateEmployee(targetId, updates);

        if (optionalUpdated.isEmpty()) {
            throw employeeService.error(HttpStatus.NOT_FOUND,
                    "Employee with id " + targetId + " not found");
        }

        return employeeService.OK(optionalUpdated.get());
    }

}
