import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Beverage order = null;

        System.out.println("Welcome to the Java Cafe!");
        System.out.println("--------------------------");

        // ========================
        // Step 1: Choose Beverage
        // ========================
        while (true) {
            try {
                System.out.println("Choose your beverage:");
                System.out.println("1. Espresso ($1.99)");
                System.out.println("2. Dark Roast ($1.49)");
                System.out.println("3. House Blend ($1.29)");
                System.out.print("Enter your choice (1–3): ");

                int choice = input.nextInt();
                switch (choice) {
                    case 1 -> order = new Espresso();
                    case 2 -> order = new DarkRoast();
                    case 3 -> order = new HouseBlend();
                    default -> {
                        System.out.println("❌ Invalid choice, please try again.\n");
                        continue;
                    }
                }
                break; // valid beverage selected → exit loop
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Please enter a number between 1 and 3.");
                input.nextLine(); // clear invalid input
            }
        }

        // ========================
        // Step 2: Add Condiments
        // ========================
        boolean addingCondiments = true;
        while (addingCondiments) {
            try {
                System.out.println("\nAdd a condiment?");
                System.out.println("1. Milk (+$0.10)");
                System.out.println("2. Mocha (+$0.20)");
                System.out.println("3. Whip (+$0.15)");
                System.out.println("4. Soy (+$0.18)");
                System.out.println("5. No more condiments");
                System.out.print("Enter your choice (1–5): ");

                int cond = input.nextInt();
                switch (cond) {
                    case 1 -> order = new Milk(order);
                    case 2 -> order = new Mocha(order);
                    case 3 -> order = new Whip(order);
                    case 4 -> order = new Soy(order);
                    case 5 -> addingCondiments = false;
                    default -> System.out.println("❌ Invalid choice, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Please enter a valid number (1–5).");
                input.nextLine(); // clear invalid input
            }
        }

        // ========================
        // Step 3: Display Summary
        // ========================
        System.out.println("\n🧾 Your Order Summary:");
        System.out.println(order.getDescription());
        System.out.printf("Total: $%.2f%n", order.cost());
        System.out.println("Thank you for visiting Java Cafe!");

        input.close();
    }
}
