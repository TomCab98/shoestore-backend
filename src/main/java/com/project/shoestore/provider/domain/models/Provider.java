package com.project.shoestore.provider.domain.models;

public class Provider {
  String id;
  String dni;
  String name;
  String lastName;
  Integer phone;
  String address;
  String email;

  public Provider() {}

  public Provider(String id) {
    this.id = id;
  }

  public Provider(String id, String dni, String name, String lastName, Integer phone, String address, String email) {
    this.id = id;
    this.dni = dni;
    this.name = name;
    this.lastName = lastName;
    this.phone = phone;
    this.address = address;
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getPhone() {
    return phone;
  }

  public void setPhone(Integer phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
