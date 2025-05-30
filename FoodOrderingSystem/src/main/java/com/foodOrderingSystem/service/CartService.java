package com.foodOrderingSystem.service;

import com.foodOrderingSystem.model.CartItem;
import com.foodOrderingSystem.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private final List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(FoodItem foodItem, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getFoodItem().getId() == foodItem.getId()) {
                // update quantity
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(foodItem, quantity));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void displayCart() {
        System.out.println("---- YOUR CART ----");
        System.out.println();
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            System.out.println();
            return;
        }
        for (CartItem item : cartItems) {
            System.out.printf("%s x%d = ₹%.2f%n",
                    item.getFoodItem().getName(),
                    item.getQuantity(),
                    item.getTotalPrice());
            System.out.println();
        }
        System.out.println("-------------------");
        System.out.println();
    }
}
