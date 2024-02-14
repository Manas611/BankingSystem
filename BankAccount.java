import java.util.ArrayList;
class BankAccount {
    
    private final int AccountNumber;
    private int balance;
    // List to store the Transaction of a specific customer
    ArrayList<Transaction> transactionHistory;

    // Constructor of BankAccount
    public BankAccount(int accountNumber, int balance) {
        AccountNumber = accountNumber;
        this.balance = balance;
        transactionHistory = new ArrayList<>();
    }

    // Getters of the class
    public int getAccountNumber() {
        return AccountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }

    // Method to show all transactions of a customer
    public void showTransaction()
    {
        for(int i=0;i<transactionHistory.size();i++)
        {
            System.out.println("Transaction is done of type "+transactionHistory.get(i).getTransactionType() + " with amount "+transactionHistory.get(i).getAmount());
        }
    }  
}
