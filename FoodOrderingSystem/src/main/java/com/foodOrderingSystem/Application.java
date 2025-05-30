package com.foodOrderingSystem;

import com.foodOrderingSystem.model.FoodItem;
import com.foodOrderingSystem.model.Order;
import com.foodOrderingSystem.service.CartService;
import com.foodOrderingSystem.service.MenuService;
import com.foodOrderingSystem.service.OrderService;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		CartService cartService = new CartService();
		OrderService orderService = new OrderService();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Online Food Ordering System!");
		System.out.println();

		boolean ordering = true;
		while (ordering) {
			menuService.displayMenu();
			System.out.print("Enter item number to add to cart (0 to finish): ");
			int choice = scanner.nextInt();
			System.out.println();

			if (choice == 0) {
				ordering = false;
				break;
			}

			FoodItem selectedItem = menuService.getFoodItemById(choice);
			if (selectedItem == null) {
				System.out.println("Invalid item number. Please try again.");
				System.out.println();
				continue;
			}

			System.out.print("Enter quantity: ");
			int quantity = scanner.nextInt();
			System.out.println();

			if (quantity <= 0) {
				System.out.println("Quantity must be at least 1.");
				System.out.println();
				continue;
			}

			cartService.addToCart(selectedItem, quantity);
			System.out.println(quantity + " x " + selectedItem.getName() + " added to cart.");
			System.out.println();
			cartService.displayCart();
		}

		System.out.print("Any special instructions? (press Enter to skip): ");
		scanner.nextLine();  // consume leftover newline
		String specialInstructions = scanner.nextLine();
		System.out.println();

		Order order = orderService.createOrder(cartService.getCartItems(), specialInstructions);
		orderService.displayOrderSummary(order);

		System.out.println("Thank you for ordering!");
		System.out.println();
		scanner.close();
	}
}
