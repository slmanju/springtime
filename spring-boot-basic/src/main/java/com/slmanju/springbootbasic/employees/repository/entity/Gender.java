package com.slmanju.springbootbasic.employees.repository.entity;

public enum Gender {
  MALE("Male"), FEMALE("Female");

  private final String gender;

  Gender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return gender;
  }
}
