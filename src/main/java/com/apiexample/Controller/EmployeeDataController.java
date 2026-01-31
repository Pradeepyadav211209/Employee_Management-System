package com.apiexample.Controller;

import com.apiexample.Dto.ApiResponce;
import com.apiexample.Dto.EmployeeDataDto;
import com.apiexample.Entity.EmployeeData;
import com.apiexample.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //http://localhost:8080/api/v2/employee/AllEmployee
    @GetMapping("/AllEmployee")
public ResponseEntity<ApiResponce<List<EmployeeData>>> EmployeeData(){
    List<EmployeeData> emp = employeeService.getEmployeeDataById();
    ApiResponce<List<EmployeeData>> responce= new ApiResponce<>();
    responce.setMsg("Print Data");
    responce.setData(emp);
    responce.setStatus(200);
    return new ResponseEntity<>(responce,HttpStatus.OK);
}
}
