# Food Delivery Bill System

## Case Study 176: Java Programming

## Project Overview

The Food Delivery Bill System is a GUI-based Java application developed using Java Swing. It allows users to view a food menu, select items, enter quantities, and generate a final bill automatically.

The system calculates the total food cost, applies discounts based on the order amount, adds tax, and calculates delivery charges. It provides a simple graphical interface that makes the billing process easy to understand and use.

## Features

- Displays a food menu with item names and prices.
- Allows users to add multiple food items to an order.
- Accepts item numbers and quantities through dialog boxes.
- Calculates the total food cost automatically.
- Applies promotional discounts based on the order value.
- Calculates tax and delivery charges.
- Displays the final bill in the application window.
- Allows users to view and clear their current order.
- Handles invalid inputs and empty orders.

## Technologies Used

- Java
- Java Swing
- Java AWT

## Food Menu

| No. | Food Item | Price |
|---|---|---:|
| 1 | Burger | Rs. 120 |
| 2 | Pizza | Rs. 250 |
| 3 | Pasta | Rs. 180 |
| 4 | Sandwich | Rs. 100 |
| 5 | French Fries | Rs. 80 |
| 6 | Cold Drink | Rs. 60 |

## Billing Rules

### Discount

- Orders of Rs. 1000 or more receive a 20% discount.
- Orders from Rs. 500 to Rs. 999 receive a 10% discount.
- Orders below Rs. 500 receive no discount.

### Delivery Charges

- Free delivery for food costs of Rs. 500 or more.
- A delivery charge of Rs. 40 applies to food costs below Rs. 500.

### Tax

A tax of 5% is calculated on the food cost after deducting the discount.

### Final Bill Formula

Final Amount = Food Cost - Discount + Tax + Delivery Charge

## Java Concepts Used

- Arrays to store food items, prices, and quantities.
- Switch statements for food item selection.
- Loops to display menu items and calculate totals.
- If-else statements for discounts and delivery charges.
- Operators for arithmetic calculations and comparisons.
- Methods to organize the program into separate modules.
- Exception handling to manage invalid numeric input.
- Java Swing components to create the graphical user interface.

## Application Workflow

1. The application opens and displays the food menu.
2. The user selects the Add Item option.
3. The user enters a food item number and quantity.
4. The selected item is added to the order.
5. The user can view the current order or clear it.
6. When Final Bill is selected, the application calculates the food cost, discount, tax, and delivery charges.
7. The final amount is displayed in the application window.

## How to Run the Project

### Prerequisites

- Java Development Kit (JDK) installed.
- A Java-compatible IDE or terminal.

### Steps

1. Download or clone this repository.
2. Open the project folder in your preferred IDE or terminal.
3. Save the Java source code in a file named `FoodDeliveryBillSystem.java`.
4. Open the terminal in the directory containing the Java file.
5. Compile the program using:

   `javac FoodDeliveryBillSystem.java`

6. Run the program using:

   `java FoodDeliveryBillSystem`

7. The Food Delivery Bill System window will open.

## Limitations

- Food items and prices are predefined in the source code.
- The application does not store order history.
- Customer details are not collected.
- The interface uses fixed component positions, which limits resizing.
- The application does not use a database.

## Future Enhancements

- Add customer details such as name and address.
- Store menu items and prices in a database.
- Maintain customer order history.
- Add more food items and promotional offers.
- Improve the interface with responsive layouts.
- Add an option to save or print the final bill.

## Conclusion

The Food Delivery Bill System demonstrates the practical use of Java programming concepts through a simple graphical application. It automates food order calculations, applies discounts, calculates tax and delivery charges, and generates a final bill. The project provides a foundation for developing more advanced billing applications in the future.

## Project Details

- **Name:** Mohammed Saad Mulla
- **Roll Number:** 150096725112
- **Cohort:** Sam Altman
- **Program:** B.Tech CSE
- **Subject:** Java Programming
- **Case Study Number:** 176
