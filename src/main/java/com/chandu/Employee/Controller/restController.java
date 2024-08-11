package com.chandu.Employee.Controller;


import com.chandu.Employee.Model.Employee;
import com.chandu.Employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class restController {
    @Autowired
    private EmployeeService empservice;


    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAll(){
       return new ResponseEntity<>(empservice.gteall(), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Optional<Employee> emp=empservice.getbyid(id);
        return new ResponseEntity<>(emp.get(),HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> Add(@RequestBody Employee body){
        return new ResponseEntity<>(empservice.addemp(body),HttpStatus.OK);
    }

    @PostMapping("/employee/update/{id}")
    public ResponseEntity<Employee> UpdateById(@RequestBody Employee body,@PathVariable Long id){
        return new ResponseEntity<>(empservice.update(body,id),HttpStatus.OK);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> Delete(@PathVariable Long id){
        empservice.delete(id);
        return new ResponseEntity<>("Successfully deleted record",HttpStatus.OK);
    }


}
