import java.util.*;

class Bank {
    private String bankName;
    private String bankDetails;
    public ATM(String bankName, String bankDetails) {
        this.bankName = bankName;
        this.bankDetails = bankDetails;
    }
    public String getBankName() {
        return bankName;
    }
    public String getBankDetails() {
        return bankDetails;
    }
}

class Customer {
    private String customerName;
    private String accountNumber;
    private int customerBalance;
    private int pin;
    public Customer(String customerName, String accountNumber, int customerBalance, int pin) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.customerBalance = customerBalance;
        this.pin = pin;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getCustomerBalance() {
        return customerBalance;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit successful. New available balance is Rs." + balance);
    }
    public void withdraw(int amount) {
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New available balance is Rs." + balance);
        }
        else System.out.println("Insufficient balance.");
    }
}

public class ATM {
    public static void main(String[] args) {
        private List<Bank> banks;
        private List<Customer> customers;
        
    }
}
