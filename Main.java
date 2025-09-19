// Online Java - IDE, Code Editor, Compiler

// Online Java is a quick and easy tool that helps you to build, compile, test your programs online.

// Write your Java code here
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static final double PRICE_SOURPATCH = 1.25;
    public static final double PRICE_SWEDISHFISH = 1.29;
    public static final double PRICE_CHOCOLATE_PER_LB = 5.49;
    public static final double SALES_TAX_RATE = 0.05999;  // 5.999%

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to John's Store!");

        System.out.print("Enter quantity of Sour Patch Kids: ");
        int qtySourpatch = scanner.nextInt();

        System.out.print("Enter quantity of Swedish Fish: ");
        int qtySwedishfish = scanner.nextInt();

        System.out.print("Enter pounds of Chocolate: ");
        double lbsChocolate = scanner.nextDouble();

        double costSourpatch = qtySourpatch * PRICE_SOURPATCH;
        double costSwedishfish = qtySwedishfish * PRICE_SWEDISHFISH;
        double costChocolate = lbsChocolate * PRICE_CHOCOLATE_PER_LB;

        double subtotal = costSourpatch + costSwedishfish + costChocolate;

        double tax = subtotal * SALES_TAX_RATE;
        double totalBeforeDiscount = subtotal + tax;

        // Apply discount after tax
        double discountRate = 0.0;
       if (totalBeforeDiscount >= 50 && totalBeforeDiscount >= 30) {
    discountRate = 0.20;  // 20% discount
     } else if (totalBeforeDiscount >= 30) {
    discountRate = 0.10;  // 10% discount
     }


        double discountAmount = totalBeforeDiscount * discountRate;
        double totalAfterDiscount = totalBeforeDiscount - discountAmount;

        // Rounding to 2 decimal places
        subtotal = Math.round(subtotal * 100.0) / 100.0;
        tax = Math.round(tax * 100.0) / 100.0;
        totalBeforeDiscount = Math.round(totalBeforeDiscount * 100.0) / 100.0;
        discountAmount = Math.round(discountAmount * 100.0) / 100.0;
        totalAfterDiscount = Math.round(totalAfterDiscount * 100.0) / 100.0;

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        System.out.println("===================================");
        System.out.println("       John's Store Receipt        ");
        System.out.println("       Date: " + dtf.format(now));
        System.out.println("       Location: Parlin, NJ");
        System.out.println("       Rewards Points: 150          ");
        System.out.println("===================================");

        System.out.printf("Sour Patch Kids: %d x $%.2f = $%.2f%n", qtySourpatch, PRICE_SOURPATCH, costSourpatch);
        System.out.printf("Swedish Fish:    %d x $%.2f = $%.2f%n", qtySwedishfish, PRICE_SWEDISHFISH, costSwedishfish);
        System.out.printf("Chocolate:       %.2f lbs x $%.2f = $%.2f%n", lbsChocolate, PRICE_CHOCOLATE_PER_LB, costChocolate);

        System.out.println("-----------------------------------");
        System.out.printf("Subtotal:               $%.2f%n", subtotal);
        System.out.printf("Sales Tax (5.999%%):     $%.2f%n", tax);
        System.out.printf("Total before discount:  $%.2f%n", totalBeforeDiscount);

        if (discountRate > 0) {
            System.out.printf("Discount (%.0f%%):         -$%.2f%n", discountRate * 100, discountAmount);
        }

        System.out.printf("Total after discount:   $%.2f%n", totalAfterDiscount);
        System.out.println("===================================");
        System.out.println("Thank you for shopping with us!");

        scanner.close();
    }
}


