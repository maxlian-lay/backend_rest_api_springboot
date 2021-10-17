package com.example.demo.models;

public class response {
  String code;
  String descString;

  public response(String code, String descString) {
    this.code = code;
    this.descString = descString;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getDescString() {
    return descString;
  }
  public void setDescString(String descString) {
    this.descString = descString;
  }

  
}
