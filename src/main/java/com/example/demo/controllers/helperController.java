package com.example.demo.controllers;

public class helperController {
  public boolean lengthChecker(String toCheck){
    boolean isTooLong = true;
    if(toCheck.length() <= 50){
      isTooLong = false;
    }
    System.out.println("Length check:" + isTooLong);
    return isTooLong;
  }
}
