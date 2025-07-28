package com.project.shoestore.order.domain.models;

import com.project.shoestore.provider.domain.models.Provider;

import java.util.Date;
import java.util.List;

public class Order {
  String id;
  Date date;
  Float total;
  Provider provider;
  List<OrderDetail> details;

  public Order() {}

  public Order(String id, Date date, Float total, Provider provider, List<OrderDetail> details) {
    this.id = id;
    this.date = date;
    this.total = total;
    this.provider = provider;
    this.details = details;
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

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public List<OrderDetail> getDetails() {
    return details;
  }

  public void setDetails(List<OrderDetail> details) {
    this.details = details;
  }
}
