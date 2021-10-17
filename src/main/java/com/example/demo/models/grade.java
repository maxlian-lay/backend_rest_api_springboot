package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "grade")
public class grade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "grade_name")
  private String grade_name;

  @Column(name = "grade_bonus")
  private int grade_bonus;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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
