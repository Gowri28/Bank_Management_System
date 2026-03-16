package KIT.bank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankService 
{
    private List<Account> accounts = new ArrayList<>();
    private List<Transection> transections = new ArrayList<>();
    private int transactionCounter = 1; 
    public  void createAccount(long accno, String accholder, double bal)
    {
        Account account = new Account(accno, accholder, bal);
        accounts.add(account);
        System.out.println("Account created: " + account);
    }

    public void getAccount(long accno)
    {
        for (Account account : accounts)
        {
            if (account.getAccno() == accno) 
            {
                System.out.println("Account found: " + account);
                return;
            }
        }
        System.out.println("Account not found with account number: " + accno);
    }

    public void deposit(long accno, double amount)
    {
        for (Account account : accounts)
        {
            if (account.getAccno() == accno)
            {
                account.setBal(account.getBal() + amount);
                System.out.println("Deposited " + amount + " into account " + accno);
                transections.add(new Transection(
                    generateTransactionId(), accno, amount, "Deposit", LocalDateTime.now()
                ));
                return;
            }
        }
        System.out.println("Account not found.");
    }
    public void withdraw(long accno, double amount)
    {
        for (Account account : accounts) 
        {
            if (account.getAccno() == accno) 
            {
                if (account.getBal() >= amount) 
                {
                    account.setBal(account.getBal() - amount);
                    System.out.println("Withdraw" + amount + " from account " + accno);
                    System.out.println("New balance:" + account.getBal());
                    transections.add(new Transection(
                        generateTransactionId(), accno, amount, "Withdraw", LocalDateTime.now()
                    ));
                    return;
                } 
                else 
                {
                    System.out.println("Insufficient balance.");
                    return;
                }
            }
        }
        System.out.println("Account not found with account number: " + accno);
    }
    public void transfer(long fromAccno, long toAccno, double amount) 
    {
        Account fromAccount = null;
        Account toAccount = null;
        for (Account account : accounts) 
        {
            if (account.getAccno() == fromAccno)
            {
                fromAccount = account;
            }
            if (account.getAccno() == toAccno)
            {
                toAccount = account;
            }
        }

        if (fromAccount != null && toAccount != null)
        {
            if (fromAccount.getBal() >= amount) {
                fromAccount.setBal(fromAccount.getBal() - amount);
                toAccount.setBal(toAccount.getBal() + amount);
                System.out.println("Transferred " + amount + " from account " + fromAccno + " to " + toAccno);
                transections.add(new Transection(
                    generateTransactionId(), fromAccno, amount, "Transfer Out", LocalDateTime.now() ));
                transections.add(new Transection(
                    generateTransactionId(), toAccno, amount, "Transfer In", LocalDateTime.now()));
            }
            else
            {
                System.out.println("Insufficient balance in source account.");
            }
        } 
        else 
        {
            System.out.println("One or both account numbers are invalid.");
        }
    }
    private int generateTransactionId()
    {
        return transactionCounter++;
    }
    public void viewTransactionHistory()
    {
        if (transections.isEmpty())
        {
            System.out.println("No transactions found.");
        } 
        else 
        {
            for (Transection t : transections)
            {
                System.out.println(t);
            }
        }
    }

	
}
