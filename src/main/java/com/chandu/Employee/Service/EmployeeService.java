package com.chandu.Employee.Service;


import com.chandu.Employee.EmpRepository.EmployeeRepo;
import com.chandu.Employee.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    @Autowired
    private EmployeeRepo emprepo;
    public List<Employee> gteall(){
        List<Employee> list=emprepo.findAll();
        return list;
    }
    public Optional<Employee> getbyid(@PathVariable Long id){
        Optional<Employee> emp=emprepo.findById(id);
        return emp;
    }
    public Employee addemp(@RequestBody Employee body){
         Employee emp=emprepo.save(body);
        return emp;
    }
    public  Employee update(@RequestBody Employee body,@PathVariable Long id){
        Optional<Employee> emp=emprepo.findById(id);
        Employee empo = null;
        if(emp.isPresent()){
            empo=emp.get();
            empo.setName(body.getName());
            empo.setLocation(body.getLocation());
            empo.setPreference(body.getPreference());
            emprepo.save(empo);
        }
        return  empo;
    }
    public void delete(@PathVariable Long id){
        emprepo.deleteById(id);
    }
}
