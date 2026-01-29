package com.apiexample.Controller;

import com.apiexample.Dto.ApiResponce;
import com.apiexample.Dto.EmployeeChangeDto;
import com.apiexample.Dto.EmployeeDto;
import com.apiexample.Entity.Employee;
import com.apiexample.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //localhost:8080/api/v1/Employee/save


    @PostMapping("/save")
    public ResponseEntity<ApiResponce> createEmp(@RequestBody Employee emp) {
        String status = employeeService.createEmployee(emp);
        ApiResponce<String> responce = new ApiResponce();
        if (status.equals("Done")) {
            responce.setMsg("Transaction Completed");
            responce.setData("Done");
            responce.setStatus(201);
            return new ResponseEntity<>(responce, HttpStatus.CREATED);
        }
        responce.setMsg("Transaction Failed");
        responce.setData("Duplicate Value");
        responce.setStatus(500);
        return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);


    }

    //localhost:8080/api/v1/Employee/delete?id=1
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponce> deleteEmployee(@RequestParam long id) {
        employeeService.deleteEmployee(id);
        ApiResponce<String> responce = new ApiResponce();
        responce.setMsg("Transaction Completed");
        responce.setData("Delete");
        responce.setStatus(200);
        return new ResponseEntity<>(responce, HttpStatus.OK);

    }

    //localhost:8080/api/v1/Employee/update/{id}
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponce<EmployeeDto>> updateEmployee(
            @RequestBody EmployeeDto employeeDto,
            @PathVariable long id
    ) {
        EmployeeDto employeeDto1 = employeeService.updateRegistration(employeeDto, id);
        ApiResponce<EmployeeDto> responce = new ApiResponce();
        responce.setMsg("Update Record");
        responce.setData(employeeDto1);
        responce.setStatus(200);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

    //localhost:8080/api/v1/Employee/All
    @GetMapping("/All")
    public ResponseEntity<ApiResponce<List<Employee>>> getAllEmployee() {
        List<Employee> employee = employeeService.getAllEmp();
        ApiResponce<List<Employee>> responce = new ApiResponce();
        responce.setMsg("Transaction Completed");
        responce.setData(employee);
        responce.setStatus(200);
        return new ResponseEntity<>(responce, HttpStatus.OK);
    }

    //localhost:8080/api/v1/Employee/by/{id}
    @GetMapping("/by/{id}")
    public ResponseEntity<ApiResponce<Employee>> findByIdEmp(
            @PathVariable long id
    ) {
     Employee employee =employeeService.findById(id);
     ApiResponce<Employee> responce = new ApiResponce<>();
     responce.setMsg("Transaction Completed");
     responce.setData(employee);
     responce.setStatus(200);
     return new ResponseEntity<>(responce,HttpStatus.OK);

    }
    //localhost:8080/api/v1/Employee/updateLatest/{id}
    @PutMapping("/updateLatest/{id}")
    public ResponseEntity<ApiResponce<EmployeeChangeDto>> updateEmailAndName(
           @RequestBody EmployeeChangeDto employeeChangeDto,
           @PathVariable long id
    ){
        EmployeeChangeDto employeeChangeDto1 =employeeService.updateEmailAndName(employeeChangeDto,id);
        ApiResponce<EmployeeChangeDto> responce = new ApiResponce<>();
        responce.setMsg("Transaction Complete");
        responce.setData(employeeChangeDto);
        responce.setStatus(200);
        return new ResponseEntity<>(responce,HttpStatus.OK);
    }

    //http://localhost:8080/api/v1/Employee/byNameAndMobile/{id}
    @GetMapping("/byNameAndMobile/{id}")
    public ResponseEntity<ApiResponce<Employee>> getNameAndPhone(
            @PathVariable long id
    ){
        Employee employee = employeeService.getNameAndMobile(id);
        ApiResponce<Employee> responce = new ApiResponce<>();
        responce.setMsg("Transaction Completed");
        responce.setData(employee);
        responce.setStatus(200);
        return new ResponseEntity<>(responce,HttpStatus.OK);

    }


    //http://localhost:8080/api/v1/Employee/changeMobile/{id}
    @PutMapping("/changeMobile/{id}")
    public ResponseEntity<ApiResponce<EmployeeDto>> chnageMobile(
            @RequestBody EmployeeDto employeeDto,
            @PathVariable long id
    ){
        EmployeeDto employeeDto1 =employeeService.chnageMobile(employeeDto,id);
        ApiResponce<EmployeeDto> responce = new ApiResponce<>();
        responce.setMsg("Transaction Completed");
        responce.setData(employeeDto1);
        responce.setStatus(200);
        return new ResponseEntity<>(responce,HttpStatus.OK);


    }
}