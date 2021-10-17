package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.dto.employeeDto;
import com.example.demo.models.employee;
import com.example.demo.models.response;
import com.example.demo.repositories.employeeRepo;

@RestController
@CrossOrigin
public class employeeController {
  @Autowired
	private employeeRepo employeeRepo;

  private helperController helper = new helperController();

  String code = "";
  String desc = "";

  @GetMapping("/getEmployees")
  public List<employee> getEmployees(){
    return employeeRepo.findAll();
  }

  @GetMapping("/getEmployeesInfo")
	public List<employeeDto> getEmployeeInfo(){
		return employeeRepo.getEmployeeInfo();
	}

  @PostMapping("/addEmployee")
  public response addEmployee(@RequestBody employee reqPayload){
    boolean isTooLong = helper.lengthChecker(reqPayload.getEmployee_name());
    if (isTooLong) {
      code = "ERR01";
      desc = "String too long";
    } else {
      try {
        employeeRepo.save(reqPayload);
        code = "00";
        desc = "Success";
      } catch (Exception e) {
        code = "ERR";
        desc = e.toString();
      }
    }
    return new response(code, desc);
  }

  @PostMapping("/editEmployee")
  public response editEmployee(@RequestBody employee reqPayload){
    boolean isTooLong = helper.lengthChecker(reqPayload.getEmployee_name());
    boolean isExist = employeeRepo.existsById(reqPayload.getId());
    if (isTooLong) {
      code = "ERR01";
      desc = "String too long";
    }else if(!isExist){
      code = "ERR02";
      desc = "Record not found";
    } else {
      try {
        employee employee = employeeRepo.findById(reqPayload.getId()).get();
        employee.setEmployee_name(reqPayload.getEmployee_name());
        employee.setEmployee_sallary(reqPayload.getEmployee_sallary());
        employee.setGrade_id(reqPayload.getGrade_id());
        employeeRepo.save(employee);
        code = "00";
        desc = "Success";
      } catch (Exception e) {
        code = "ERR";
        desc = e.toString();
      }
    }    
    return new response(code, desc);
  }
}
