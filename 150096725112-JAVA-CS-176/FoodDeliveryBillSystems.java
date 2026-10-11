import java.awt.*;
import javax.swing.*;

public class FoodDeliveryBillSystems {

    // Arrays to store menu items, prices and ordered quantities
    static String[] items = {"Burger", "Pizza", "Pasta", "Sandwich", "French Fries", "Cold Drink"};
    static int[] prices = {120, 250, 180, 100, 80, 60};
    static int[] quantities = new int[items.length];

    static JFrame frame;
    static JTextArea area;

    public static void main(String[] args) {

        // GUI Setup using Swing
        frame = new JFrame("Food Delivery Bill System");
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel("FOOD DELIVERY BILL SYSTEM", JLabel.CENTER);
        titleLabel.setBounds(30, 15, 830, 30);
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        frame.add(titleLabel);

        // Buttons (6 buttons x 125 wide + 5 gaps x 16 = 830)
        JButton menuButton = createButton("Show Menu", 30, 55, 125, 35);
        JButton addButton = createButton("Add Item", 171, 55, 125, 35);
        JButton orderButton = createButton("Show Order", 312, 55, 125, 35);
        JButton billButton = createButton("Final Bill", 453, 55, 125, 35);
        JButton clearButton = createButton("Clear Order", 594, 55, 125, 35);
        JButton exitButton = createButton("Exit", 735, 55, 125, 35);

        // Text area to show output
        area = new JTextArea();
        area.setEditable(false);
        area.setBackground(Color.WHITE);
        area.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(30, 105, 830, 400);

        frame.add(menuButton);
        frame.add(addButton);
        frame.add(orderButton);
        frame.add(billButton);
        frame.add(clearButton);
        frame.add(exitButton);
        frame.add(scroll);

        // Button actions
        menuButton.addActionListener(e -> showMenu());
        addButton.addActionListener(e -> addItem());
        orderButton.addActionListener(e -> showOrder());
        billButton.addActionListener(e -> showBill());
        clearButton.addActionListener(e -> clearOrder());
        exitButton.addActionListener(e -> System.exit(0));

        frame.setSize(900, 580);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        showMenu();
    }

    // Helper method to create plain buttons (default look, no colors)
    static JButton createButton(String text, int x, int y, int w, int h) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, w, h);
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        return btn;
    }

    // Helper method to read a number from the user (returns -1 if cancelled or invalid)
    static int readNumber(String message) {
        String input = JOptionPane.showInputDialog(frame, message);
        if (input == null) {
            return -1;
        }
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    // Module 1: Menu Display
    static void showMenu() {
        String text = "=========== MENU ===========\n";
        for (int i = 0; i < items.length; i++) {
            text += (i + 1) + ". " + items[i] + " - Rs. " + prices[i] + "\n";
        }
        text += "============================\n";
        area.setText(text);
    }

    // Module 2: Food Selection (switch statement)
    static int selectFood(int choice) {
        switch (choice) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return -1;
        }
    }

    // Take order from the customer
    static void addItem() {
        showMenu();

        int choice = readNumber("Enter item number (1-6):");
        if (choice == -1) {
            return;
        }

        int index = selectFood(choice);
        if (index == -1) {
            JOptionPane.showMessageDialog(frame, "Invalid choice. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int qty = readNumber("Enter quantity for " + items[index] + ":");
        if (qty == -1) {
            return;
        }
        if (qty <= 0) {
            JOptionPane.showMessageDialog(frame, "Quantity must be at least 1.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        quantities[index] += qty;
        showOrder();
    }

    // Module 3: Order Calculation
    static int calculateFoodCost() {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            total += prices[i] * quantities[i];
        }
        return total;
    }

    // Module 4: Discount (if-else)
    static double calculateDiscount(int foodCost) {
        if (foodCost >= 1000) {
            return foodCost * 0.20;
        } else if (foodCost >= 500) {
            return foodCost * 0.10;
        } else {
            return 0;
        }
    }

    // Delivery charge (if-else)
    static int calculateDeliveryCharge(int foodCost) {
        if (foodCost >= 500) {
            return 0;
        } else {
            return 40;
        }
    }

    // Tax is 5%
    static double calculateTax(double amount) {
        return amount * 0.05;
    }

    // Show the current order
    static void showOrder() {
        if (calculateFoodCost() == 0) {
            area.setText("No items ordered yet.");
            return;
        }

        String text = "=========== YOUR ORDER ===========\n";
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                text += String.format("%-14s x %d = Rs. %d\n", items[i], quantities[i], prices[i] * quantities[i]);
            }
        }
        text += "----------------------------------\n";
        text += "Food Cost so far: Rs. " + calculateFoodCost() + "\n";
        area.setText(text);
    }

    // Module 5: Final Bill
    static void showBill() {
        int foodCost = calculateFoodCost();
        if (foodCost == 0) {
            area.setText("No items ordered yet.");
            return;
        }

        double discount = calculateDiscount(foodCost);
        double afterDiscount = foodCost - discount;
        double tax = calculateTax(afterDiscount);
        int delivery = calculateDeliveryCharge(foodCost);
        double finalAmount = afterDiscount + tax + delivery;

        String text = "============== FINAL BILL ==============\n";
        for (int i = 0; i < items.length; i++) {
            if (quantities[i] > 0) {
                text += String.format("%-14s x %d = Rs. %d\n", items[i], quantities[i], prices[i] * quantities[i]);
            }
        }
        text += "----------------------------------------\n";
        text += String.format("%-18s Rs. %d\n", "Food Cost", foodCost);
        text += String.format("%-18s Rs. %.2f\n", "Discount (-)", discount);
        text += String.format("%-18s Rs. %.2f\n", "Tax 5% (+)", tax);
        text += String.format("%-18s Rs. %d\n", "Delivery (+)", delivery);
        text += "----------------------------------------\n";
        text += String.format("%-18s Rs. %.2f\n", "TOTAL TO PAY", finalAmount);
        text += "========================================\n";
        text += "Thank you for ordering!\n";
        area.setText(text);
    }

    // Clear the order
    static void clearOrder() {
        for (int i = 0; i < quantities.length; i++) {
            quantities[i] = 0;
        }
        area.setText("Order cleared.");
    }
}