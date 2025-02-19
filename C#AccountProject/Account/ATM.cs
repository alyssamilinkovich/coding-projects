using System;
using static System.Console;

public class ATM { 
    public void AccountTransactions(Account account, string transactionType, double amount)
    {
        switch (transactionType)
        {
            case "deposit":
                account.Deposit(amount);
                break;
            case "withdraw":
                if (!account.Withdraw(amount))
                    WriteLine("Insufficient funds!");
                break;
            case "balance":
                WriteLine("Balance: ${0}", account.balance);
                break;
            case "transactions":
                WriteLine("Your last 3 Transactions: ");
                foreach (string trans in account.ShowTransactions())
                {
                    WriteLine(trans);
                }
                break;
            default:
                WriteLine("Invalid type.");
                break;
        }
    }
}

