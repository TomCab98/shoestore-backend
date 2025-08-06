package com.project.shoestore.sales.domain.models;

import com.project.shoestore.client.domain.models.Client;
import com.project.shoestore.employee.domain.models.Employee;

import java.util.Date;
import java.util.List;

public class Sale {
  private String id;
  private Date date;
  private Float total;
  private Employee employee;
  private Client client;
  private List<SaleDetail> details;
  private Status status;

  public Sale() {}

  public Sale(String id, Date date, Float total, Employee employee, Client client, List<SaleDetail> details, Status status) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.employee = employee;
    this.client = client;
    this.details = details;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Float getTotal() {
    return total;
  }

  public void setTotal(Float total) {
    this.total = total;
  }

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public List<SaleDetail> getDetails() {
    return details;
  }

  public void setDetails(List<SaleDetail> details) {
    this.details = details;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Sale { id = " + id + ", date = " + date + ", total = " + total + ", employee = " + employee + ", client = " + client + ", details = " + details + ", status = " + status + " }";
  }
}
