package com.apiexample.Service;

import com.apiexample.Dto.EmployeeChangeDto;
import com.apiexample.Dto.EmployeeDto;
import com.apiexample.Entity.Employee;
import com.apiexample.Entity.EmployeeData;
import com.apiexample.GlobalExceptionHandler.ResourceNotFoundExceptions;
import com.apiexample.Repository.EmployeeDataRepository;
import com.apiexample.Repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public  String createEmployee(Employee employee){
            employeeRepository.save(employee);
        return "Done";
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    public EmployeeDto updateRegistration(EmployeeDto employeeDto, long id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(employeeDto.getName());
        employee.setEmailId(employeeDto.getEmailId());
        employee.setMobile(employeeDto.getMobile());
        Employee saved = employeeRepository.save(employee);
        BeanUtils.copyProperties(saved,employeeDto);
       return employeeDto;
    }

    public List<Employee> getAllEmp(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> emp = employeeRepository.findAll(pageable);
        List<Employee> content = emp.getContent();
        return content;
    }

    public Employee findById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () ->  new ResourceNotFoundExceptions("Record Not Found")
        );
        return employee;
    }

    public EmployeeChangeDto updateEmailAndName(EmployeeChangeDto employeeChangeDto, long id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setName(employeeChangeDto.getName());
        employee.setEmailId(employeeChangeDto.getEmailId());
        Employee saved = employeeRepository.save(employee);
        BeanUtils.copyProperties(saved,employeeChangeDto);
        return employeeChangeDto;
    }

    public Employee getNameAndMobile(long id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;

    }

    public EmployeeDto chnageMobile(EmployeeDto employeeDto, long id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setMobile(employeeDto.getMobile());
        Employee saved = employeeRepository.save(employee);
        BeanUtils.copyProperties(saved,employeeDto);
        return employeeDto;
    }

    @Autowired
    EmployeeDataRepository employeeDataRepository;
    public void createEmpData(EmployeeData employeeData) {
        employeeDataRepository.save(employeeData);

    }

    public List<EmployeeData> getEmployeeDataById() {
        List<EmployeeData> employeeData = employeeDataRepository.findAll();
        return employeeData;
    }

    public void delteDataById(long id) {
        employeeDataRepository.deleteById(id);
    }
}
