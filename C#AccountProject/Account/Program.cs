using System;

public class Account
{
    public string accountNumber { get; set; }
    public string username { get; set; }
    public string password { get; set; }
    public double balance { get; set; }
    private string transactionOne;
    private string transactionTwo;
    private string transactionThree;

    public Account(string accountNumber, string username, string password, double initialBalance = 0)
    {
        this.accountNumber = accountNumber;
        this.username = username;
        this.password = password;
        this.balance = initialBalance;
        transactionOne = "";
        transactionTwo = "";
        transactionThree = "";
    }

    public void Deposit(double amount)
    {
        if (amount > 0)
        {
            balance += amount;
            UpdateTransactions("Deposited: $" + amount);
        }
    }

    public bool Withdraw(double amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
            UpdateTransactions("Withdrew: $" + amount);
            return true;
        }
        return false;
    }

    private void UpdateTransactions(string transaction)
    {
        transactionThree = transactionTwo;
        transactionTwo = transactionOne;
        transactionOne = transaction;
    }

    public string[] ShowTransactions()
    {
        return new string[] { transactionOne, transactionTwo, transactionThree };
    }

    public bool ValidLogin(string username, string password)
    {
        return username == this.username && this.password == password;
    }
}