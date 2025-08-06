package com.project.shoestore.sales.domain.models;

public enum Status {
  COMPLETED(1),
  PENDING(2),
  CANCELED(3);

  private final int id;

  Status(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }
}
