package com.project.shoestore.product.domain.models;

public class Product {
  private String id;
  private String name;
  private float price;
  private int minStock;
  private int stock;
  private Brand brand;
  private Category category;
  private Size size;

  public Product() {}

  public Product(
    String id, String name, float price, int minStock, int stock, Brand brand, Category category, Size size) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.minStock = minStock;
    this.stock = stock;
    this.brand = brand;
    this.category = category;
    this.size = size;
  }

  public Product(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public int getMinStock() {
    return minStock;
  }

  public void setMinStock(int minStock) {
    this.minStock = minStock;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Size getSize() {
    return size;
  }

  public void setSize(Size size) {
    this.size = size;
  }
}
