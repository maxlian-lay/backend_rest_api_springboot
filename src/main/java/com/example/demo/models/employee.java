package com.example.demo.models;

import javax.persistence.*;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name = "employee")
@EnableJpaRepositories
public class employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "employee_name")
  private String employee_name;

  @Column(name = "employee_sallary")
  private long employee_sallary;

  @Column(name = "grade_id")
  private long grade_id;

  // @ManyToOne()
	// @JoinColumn(name = "grade_id",insertable = false, updatable = false)
	// private grade grade;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmployee_name() {
    return employee_name;
  }

  public void setEmployee_name(String employee_name) {
    this.employee_name = employee_name;
  }

  public long getEmployee_sallary() {
    return employee_sallary;
  }

  public void setEmployee_sallary(long employee_sallary) {
    this.employee_sallary = employee_sallary;
  }

  // public grade getGrade() {
  //   return grade;
  // }

  // public void setGrade(grade grade) {
  //   this.grade = grade;
  // }

  public long getGrade_id() {
    return grade_id;
  }

  public void setGrade_id(long grade_id) {
    this.grade_id = grade_id;
  }

  
}
