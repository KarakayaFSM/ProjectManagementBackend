# ProjectManagementBackend
Fictional Project Management Application Backend with Spring Boot and Spring Data JPA.
<br>Partial updates using json-patch api at @PatchMapping.

----------------

## getAllEmployees

```
GET http://localhost:8081/api/v1/employee/getAll
```

Get all employees in the database

<br>

## AddEmployee

```
POST http://localhost:8081/api/v1/employee/add
```

Add a new employee to the database

----------------

### Request

> **Body**
> 
 ```
 {
     "availability": 0,

     "workingHours": 8,

     "salary": 3500,

     "name": "Ahmet",

     "lastName": "Ak",

     "email": "ahmet.ak@gmail.com"
 }
``` 

## DeleteEmployee

```
DELETE http://localhost:8081/api/v1/employee/deleteById/1
```

Delete employee from database

----------------

## updateEmployee

```
PATCH http://localhost:8081/api/v1/employee/update/1
```

Partially update employee using json-patch

----------------

### Request

> 
> **Header**
> 
> |Key|Value|Description|
> |---|---|---|
> |Content-Type|application/json-patch+json||
> 
> **Body**
> 
>
```
 [
     {"op": "replace", "path" : "/name", "value": "Mehmet"},
     {"op": "replace", "path" : "/lastName", "value": "Ak"}
 ]
 ``` 

Built with [Postdown][PyPI] (with some tweaking though)

[PyPI]:    https://pypi.python.org/pypi/Postdown

