import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a sample account
        Account account = new Account("Aman123", "4321", 5000.00);

        System.out.println("===== Welcome to ATM =====");
        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (!enteredId.equals(account.userId) || !account.validatePin(enteredPin)) {
            System.out.println("Invalid User ID or PIN. Access Denied!");
            sc.close();
            return;
        }

        int choice;
        do {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please enter a valid option!");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depAmount = sc.nextDouble();
                    account.deposit(depAmount);
                    System.out.println("Amount deposited successfully.");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withAmount = sc.nextDouble();
                    if (account.withdraw(withAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance or invalid amount.");
                    }
                    break;
                case 4:
                    System.out.println("\nTransaction History:");
                    if (account.getTransactionHistory().isEmpty()) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (String record : account.getTransactionHistory()) {
                            System.out.println(record);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thank you for using ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
