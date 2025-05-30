package com.foodOrderingSystem.model;

import java.util.List;

public class Order {
    private List<CartItem> cartItems;
    private String specialInstructions;
    private double totalAmount;

    public Order(List<CartItem> cartItems, String specialInstructions, double totalAmount) {
        this.cartItems = cartItems;
        this.specialInstructions = specialInstructions;
        this.totalAmount = totalAmount;
    }

    public List<CartItem> getCartItems() { return cartItems; }
    public String getSpecialInstructions() { return specialInstructions; }
    public double getTotalAmount() { return totalAmount; }
}
