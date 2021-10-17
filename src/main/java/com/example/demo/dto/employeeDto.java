package com.example.demo.dto;

public class employeeDto {
  private Long employee_id;
  private String employee_name;
  private Long employee_sallary;
  private Long grade_id;
  private String grade_name;
  private int grade_bonus;

  public employeeDto(Long employee_id, String employee_name, Long employee_sallary, Long grade_id, String grade_name, int grade_bonus) {
    this.employee_id = employee_id;
    this.employee_name = employee_name;
    this.employee_sallary = employee_sallary;
    this.grade_id = grade_id;
    this.grade_name = grade_name;
    this.grade_bonus = grade_bonus;
  }

  public Long getEmployee_id() {
    return employee_id;
  }
  public void setEmployee_id(Long employee_id) {
    this.employee_id = employee_id;
  }
  public String getEmployee_name() {
    return employee_name;
  }
  public void setEmployee_name(String employee_name) {
    this.employee_name = employee_name;
  }
  public Long getEmployee_sallary() {
    return employee_sallary;
  }
  public void setEmployee_sallary(Long employee_sallary) {
    this.employee_sallary = employee_sallary;
  }
  public Long getGrade_id() {
    return grade_id;
  }
  public void setGrade_id(Long grade_id) {
    this.grade_id = grade_id;
  }
  public String getGrade_name() {
    return grade_name;
  }
  public void setGrade_name(String grade_name) {
    this.grade_name = grade_name;
  }
  public int getGrade_bonus() {
    return grade_bonus;
  }
  public void setGrade_bonus(int grade_bonus) {
    this.grade_bonus = grade_bonus;
  }
}
