
import java.util.Scanner;

public class BankManagement {

    // main function to call other class
    public static void main(String[] args) {
        
        BankingSystem bankingSystem = new BankingSystem();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        // Entering the value for the transaction to be Done
        do {
            System.out.println("*****Welcome to the Banking System******");
            System.out.println("1. Create Account\n" +
                    "2. Deposit\n" +
                    "3. Withdraw\n" +
                    "4. Transfer\n" +
                    "5. Display Transaction Info\n" +
                    "6. Check Current Balance\n" +
                    "7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNum = sc.nextInt();
                    System.out.print("Enter Initial Balance: ");
                    int initBalance = sc.nextInt();
                    BankAccount newAcc = new BankAccount(accNum, initBalance);
                    bankingSystem.AddAccount(newAcc);
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccNum = sc.nextInt();
                    System.out.print("Enter Deposit Amount: ");
                    int depositAmount = sc.nextInt();
                    bankingSystem.Deposit(depositAccNum, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccNum = sc.nextInt();
                    System.out.print("Enter Withdrawal Amount: ");
                    int withdrawAmount = sc.nextInt();
                    bankingSystem.withdraw(withdrawAccNum, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter Source Account Number: ");
                    int fromAccNum = sc.nextInt();
                    System.out.print("Enter Destination Account Number: ");
                    int toAccNum = sc.nextInt();
                    System.out.print("Enter Transfer Amount: ");
                    int transferAmount = sc.nextInt();
                    bankingSystem.transfer(fromAccNum, toAccNum, transferAmount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    int displayAccNum = sc.nextInt();
                    bankingSystem.displayTransactionInfo(displayAccNum);
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    int balanceAccNum = sc.nextInt();
                    bankingSystem.currentBalance(balanceAccNum);
                    break;
                case 7:
                    flag = false;
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (flag);
        sc.close();
    }
}
