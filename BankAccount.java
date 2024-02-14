import java.util.ArrayList;
class BankAccount {
    private final int AccountNumber;
    private int balance;
    ArrayList<Transaction> transactionHistory;
    
    public BankAccount(int accountNumber, int balance) {
        AccountNumber = accountNumber;
        this.balance = balance;
        transactionHistory = new ArrayList<>();
    }

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

    public void showTransaction()
    {
        for(int i=0;i<transactionHistory.size();i++)
        {
            System.out.println("Transaction is done of type "+transactionHistory.get(i).getTransactionType() + " with amount "+transactionHistory.get(i).getAmount());
        }
    }  
}
