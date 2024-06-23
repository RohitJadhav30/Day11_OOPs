//program2

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void debit(double amount) {
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        if (amount < 0.0) {
            System.out.println("Credit amount cannot be negative!!");
        }
        balance += amount;
    }
}

public class AccountTest {
    public static void main(String[] args) {
    
        Account account = new Account(100.00);

        account.debit(30.00);
        System.out.printf("balance: %.2f%n", account.getBalance());

        account.debit(70.00);
        System.out.printf("balance: %.2f%n", account.getBalance());

        account.debit(50.00);
        System.out.printf("balance: %.2f%n", account.getBalance());
    }
}

