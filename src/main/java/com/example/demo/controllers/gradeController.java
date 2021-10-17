package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.models.grade;
import com.example.demo.models.response;
import com.example.demo.repositories.gradeRepo;

@RestController
@CrossOrigin
public class gradeController {
  @Autowired
  private gradeRepo gradeRepo;

  private helperController helper = new helperController();

  String code = "";
  String desc = "";

  @GetMapping("/getGrades")
  public List<grade> getGrades(){
    return gradeRepo.findAll();
  }

  @PostMapping("/addGrade")
  public response addGrade(@RequestBody grade reqPayload){
    boolean isTooLong = helper.lengthChecker(reqPayload.getGrade_name());
    if (isTooLong) {
      code = "ERR01";
      desc = "String too long";
    } else {
      try {
        gradeRepo.save(reqPayload);
        code = "00";
        desc = "Success";
      } catch (Exception e) {
        code = "ERR";
        desc = e.toString();
      }
    }
    return new response(code, desc);
  }

  @PostMapping("/editGrade")
  public response editGrade(@RequestBody grade reqPayload){
    boolean isTooLong = helper.lengthChecker(reqPayload.getGrade_name());
    boolean isExist = gradeRepo.existsById(reqPayload.getId());
    if (isTooLong) {
      code = "ERR01";
      desc = "String too long";
    }else if(!isExist){
      code = "ERR02";
      desc = "Record not found";
    } else {
      try {
        grade grade = gradeRepo.findById(reqPayload.getId()).get();
        grade.setGrade_name(reqPayload.getGrade_name());
        grade.setGrade_bonus(reqPayload.getGrade_bonus());
        gradeRepo.save(grade);
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
