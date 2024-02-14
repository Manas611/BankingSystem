import java.util.ArrayList;
import java.util.HashMap;

class BankingSystem 
{
    // Hashmap for storing the Accounts of the Bank
    HashMap<Integer,BankAccount> accounts = new HashMap<>();

    // Map to store all the Trasaction History of the Person
    HashMap<Integer,ArrayList<Transaction>> history = new HashMap<>();
    public static int count = 0;

    // Adding account in the Bank of the customer
    public void AddAccount(BankAccount b)
    {
        int ac = b.getAccountNumber();
        try {
            if(accounts.containsKey(ac))
            {
                throw new BankException("Already exist account Number");
            }
            accounts.put(b.getAccountNumber(), b);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Method to deposit the Money in the customer account and handling exseptions if Account doesn't exit or amount is negative
    public void Deposit(int AC, int amt)
    {

        try {
            BankAccount bc = accounts.get(AC);
            if(bc == null)
            {
                throw new BankException("Account Not found");
            }
            if(amt<=0)
            {
                throw new BankException("Amount can not be added");
            }
            int val = bc.getBalance();
            val = val + amt;
            bc.setBalance(val);
            Transaction st = new Transaction(count+1, "Deposit", amt);
            bc.transactionHistory.add(st);
            history.put(AC, bc.transactionHistory);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    // Method to withdraw the mmoney from the customer account and handling exceptions
    public void withdraw(int Ac,int amt)
    {
        try {
            BankAccount bc = accounts.get(Ac);
            if(bc == null)
            {
                throw new BankException("Account Not found");
            }
            int val = bc.getBalance();
            int temp = val - amt;
            val = val - amt;

            // Checking if there is amount is larger than the present amount
            if(temp<0)
            {
                throw new BankException("Insuffient Amount to be drawn");
            }
            else
            {
                bc.setBalance(val);
        
                Transaction st = new Transaction(count+1, "Withdraw", amt);
                bc.transactionHistory.add(st);
        
                history.put(Ac, bc.transactionHistory);
            }
            
        }
         catch(Exception e)
        {
            System.out.println(e);
        }
    }

    // Method to display all the transactions of  the customer
    public void displayTransactionInfo(int act)
    {
        try {
            BankAccount b = accounts.get(act);
            System.out.println( b.transactionHistory.size());
            b.showTransaction();
            
        } catch (Exception e) {
            System.out.println("Account not Found");
        }
    }

    // Method to print the current balance of the customer
    public void currentBalance(int act)
    {
        try {
            BankAccount b = accounts.get(act);
            if(b == null)
            {
                throw new BankException("Account Not found");
            }
            int val = b.getBalance();
            System.out.println("The Current Balance is "+ val);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Transfering the amount from one customer to another customer with specific amount
    public void transfer(int FromAc,int ToAc,int amt)
    {
        try {
            BankAccount b1 = accounts.get(FromAc);
            BankAccount b2 = accounts.get(ToAc);

            if(b1 == null || b2 == null)
            {
                throw new BankException("Account Not found");
            }
    
            int val1 = b1.getBalance();
            int val2 = b2.getBalance();
    
            if(val1<=amt)
            {
                throw new BankException("Does not transfer the Amount, As AC balance is insufficient for withdraw");
            }
            else
            {
                val1 = val1 - amt;
                val2 = val2 + amt;    
                Transaction st = new Transaction(count+1, "Transfer", amt);
                b1.transactionHistory.add(st);
                b2.transactionHistory.add(st);
        
                b1.setBalance(val1);
                b2.setBalance(val2);
            }    
        } 
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
