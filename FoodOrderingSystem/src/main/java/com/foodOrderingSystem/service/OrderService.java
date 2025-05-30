package com.foodOrderingSystem.service;

import com.foodOrderingSystem.model.CartItem;
import com.foodOrderingSystem.model.Order;

import java.util.List;

public class OrderService {
    private static final double TAX_PERCENTAGE = 0.18;
    private static final double DELIVERY_CHARGES = 50.0;

    public Order createOrder(List<CartItem> cartItems, String specialInstructions) {
        double subTotal = cartItems.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
        double taxAmount = subTotal * TAX_PERCENTAGE;
        double totalAmount = subTotal + taxAmount + DELIVERY_CHARGES;

        return new Order(cartItems, specialInstructions, totalAmount);
    }

    public void displayOrderSummary(Order order) {
        System.out.println("----- ORDER SUMMARY -----");
        System.out.println();
        for (CartItem item : order.getCartItems()) {
            System.out.printf("%s x%d = ₹%.2f%n",
                    item.getFoodItem().getName(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }
        double subTotal = order.getCartItems().stream().mapToDouble(CartItem::getTotalPrice).sum();
        double taxAmount = subTotal * TAX_PERCENTAGE;

        System.out.println();
        System.out.printf("Subtotal: ₹%.2f%n", subTotal);
        System.out.printf("Tax (18%%): ₹%.2f%n", taxAmount);
        System.out.printf("Delivery Charges: ₹%.2f%n", DELIVERY_CHARGES);
        System.out.println();
        System.out.printf("Total Amount: ₹%.2f%n", order.getTotalAmount());
        if (order.getSpecialInstructions() != null && !order.getSpecialInstructions().trim().isEmpty()) {
            System.out.println("Special Instructions: " + order.getSpecialInstructions());
        }
        System.out.println();
        System.out.println("-------------------------");
    }
}
