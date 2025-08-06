package com.project.shoestore.sales.domain.models;

import java.util.Date;

public class Refund {
  private String id;
  private Date date;
  private String reason;
  private String product;
  private String sale;
  private Status status;

  public Refund() {}

  public Refund(String id, Date date, String reason, String product, String sale, Status status) {
    this.id = id;
    this.date = date;
    this.reason = reason;
    this.product = product;
    this.sale = sale;
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

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public String getSale() {
    return sale;
  }

  public void setSale(String sale) {
    this.sale = sale;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
