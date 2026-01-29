package com.apiexample.Controller;

import com.apiexample.Dto.ApiResponce;
import com.apiexample.Entity.EmployeeData;
import com.apiexample.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeDataController {
    
    @Autowired
    EmployeeService employeeService;

    //http://localhost:8080/api/v2/employee/save
    @PostMapping("/save")
    public ResponseEntity<ApiResponce<String>> setEmployeeData(
            @Valid @RequestBody EmployeeData employeeData,
            BindingResult result
    ){
        ApiResponce<String> responce =new ApiResponce<>();
        if(result.hasErrors()){
            responce.setMsg("Invalid Data");
            responce.setData(result.getFieldError().getDefaultMessage());
            responce.setStatus(500);
            return new ResponseEntity<>(responce, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }
        employeeService.createEmpData(employeeData);
        responce.setMsg("Data Added");
        responce.setData("Done");
        responce.setStatus(400);
        return new ResponseEntity<>(responce, HttpStatus.OK);

    }
}
