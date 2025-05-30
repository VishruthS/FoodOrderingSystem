package com.foodOrderingSystem.service;

import com.foodOrderingSystem.model.FoodItem;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private final List<FoodItem> menu = new ArrayList<>();

    public MenuService() {
        menu.add(new FoodItem(1, "Burger", 120));
        menu.add(new FoodItem(2, "Pizza", 250));
        menu.add(new FoodItem(3, "Pasta", 200));
        menu.add(new FoodItem(4, "French Fries", 80));
        menu.add(new FoodItem(5, "Coke", 50));
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public FoodItem getFoodItemById(int id) {
        return menu.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void displayMenu() {
        System.out.println("---- MENU ----");
        System.out.println();
        for (FoodItem item : menu) {
            System.out.printf("%d. %s - ₹%.2f%n", item.getId(), item.getName(), item.getPrice());
        }
        System.out.println("--------------");
        System.out.println();
    }
}
