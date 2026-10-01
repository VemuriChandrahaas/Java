import java.util.Scanner;

class Boarder {
    String name;
    int days;

    Boarder(String n, int d) { 
        name = n; 
        days = d; 
    }

    double bill() { 
        double amt = days * 85.0;
        if (days < 26) {
            amt = amt - (amt * 0.10);
        }
        return amt;
    }
}

public class MessBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Boarder[] list = new Boarder[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name and days: ");
            String name = sc.next();
            int days = sc.nextInt();
            list[i] = new Boarder(name, days);
        }

        double total = 0;
        Boarder highest = list[0];

        System.out.println("NAME       DAYS     BILL");
        for (Boarder b : list) {
            System.out.printf("%-10s %4d %8.2f%n", b.name, b.days, b.bill());
            total = total + b.bill();
            if (b.bill() > highest.bill()) {
                highest = b;
            }
        }

        System.out.printf("Total collection = Rs. %.2f%n", total);
        System.out.println("Highest bill: " + highest.name + " (Rs. " + highest.bill() + ")");
        sc.close();
    }
}
