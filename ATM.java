import java.util.*;

class Bank {
    private String bankName;
    private String bankDetails;

    public Bank(String bankName) {
        this.bankName = bankName;
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
        customerBalance += amount;
        System.out.println("Deposit successful. New available balance is Rs." + customerBalance);
    }
    public void withdraw(int amount) {
        if (customerBalance >= amount) {
            customerBalance -= amount;
            System.out.println("Withdrawal successful. New available balance is Rs." + customerBalance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class ATM {
    private List<Bank> banks;
    private List<Customer> customers;
    private Scanner sc;

    public ATM() {
        banks = new ArrayList<>();
        customers = new ArrayList<>();
        sc = new Scanner(System.in);
    }
    public void addBank(Bank bank) {
        banks.add(bank);
    }
    public void displayBanks() {
        System.out.println("Available Banks:");
        for (int i = 0; i < banks.size(); i++) {
            System.out.println((i + 1) + ". " + banks.get(i).getBankName());
        }
    }
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    public void displayCustomerBalance(Customer customer) {
        System.out.println("Balance of " + customer.getCustomerName() + " is Rs." + customer.getCustomerBalance());
    }
    public void adminMenu() {
        int adminOption;
        do {
            System.out.println("\nAdmin Operations");
            System.out.println("1. Display Banks");
            System.out.println("2. Add Customer");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            adminOption = sc.nextInt();
            switch(adminOption) {
                case 1:
                    displayBanks();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Provide valid option.");
            }
        }
        while(adminOption != 3);
    }
    public void addCustomer() {
        System.out.println("Customer Name: ");
        String customerName = sc.next();
        System.out.println("Account Number: ");
        String accountNumber = sc.next();
        System.out.println("Balance: ");
        int customerBalance = sc.nextInt();
        System.out.println("Pin: ");
        int pin = sc.nextInt();
        Customer newCustomer = new Customer(customerName, accountNumber, customerBalance, pin);
        customers.add(newCustomer);
        System.out.println("New customer added!");
    }
    public void customerMenu() {
        displayBanks();
        System.out.println("Select a bank: ");
        int bankNumber = sc.nextInt();
        Bank selectedBank = banks.get(bankNumber-1);
        System.out.println("\nCustomer Menu");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
        System.out.print("Select an option: ");
        int customerOption = sc.nextInt();
        System.out.println("Enter your Account Number: ");
        String accountNumber = sc.next();
        Customer customer = findCustomer(accountNumber);
        if(customer == null) {
            System.out.println("Customer with Account Number " + accountNumber + " is not found!");
            return;
        }
        switch(customerOption) {
            case 1:
                System.out.println("Enter amount to withdraw: ");
                int withdrawAmount = sc.nextInt();
                customer.withdraw(withdrawAmount);
                break;
            case 2:
                System.out.println("Enter amount to deposit: ");
                int depositAmount = sc.nextInt();
                customer.deposit(depositAmount);
                break;
            case 3:
                displayCustomerBalance(customer);
                break;
            case 4:
                System.out.println("Enter new pin: ");
                int newPin = sc.nextInt();
                customer.setPin(newPin);
                System.out.println("Pin changed successfully");
                break;
            case 5:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
    public Customer findCustomer(String accountNumber) {
        for (Customer customer : customers) {
            if (customer.getAccountNumber().equals(accountNumber)) {
                return customer;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.addBank(new Bank("KVB Bank"));
        atm.addBank(new Bank("HDFC Bank"));
        atm.addBank(new Bank("ICICI Bank"));
        while(true) {
            System.out.println("\nWelcome to ATM");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    atm.adminMenu();
                    break;
                case 2:
                    atm.customerMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
