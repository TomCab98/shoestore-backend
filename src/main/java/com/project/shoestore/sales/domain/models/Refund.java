package com.project.shoestore.sales.domain.models;

import java.util.Date;

public class Refund {
  private String id;
  private Date date;
  private String reason;
  private String product;
  private String sale;

  public Refund() {}

  public Refund(String id, Date date, String reason, String product, String sale) {
    this.id = id;
    this.date = date;
    this.reason = reason;
    this.product = product;
    this.sale = sale;
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
}
