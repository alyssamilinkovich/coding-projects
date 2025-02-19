using System;
using static System.Console;

public class ConsoleDemo
{
	public static void Main()
	{
        Account[] accounts = new Account[] {
            new Account("12345", "loraliGilmore", "Bengals", 32000),
            new Account("6789", "lukeDanes", "Cheeseburger", 50000),
            new Account("9876", "RoryGilmore", "Yale", 1800),
            new Account("54321", "SukiStJames", "Cooking", 42000),
            new Account("1111", "LaneKim", "Drummer", 3200),
            new Account("0000", "admin", "password", 0)
        };

        ConsoleDemo demo = new ConsoleDemo();
        demo.StartTransaction(accounts);
    }

    public void StartTransaction(Account[] accounts)
    {
        string username, password, userEntry, userContinue;
        bool completeTransaction = true;
        bool validEntry = false;
        bool runningProgram = true;
        Account account = null;

        while (runningProgram)
        {
            validEntry = false;

            while (!validEntry)
            {
                WriteLine("Please enter your Username: ");
                username = ReadLine();
                WriteLine("Please enter your Password: ");
                password = ReadLine();

                account = Login(username, password, accounts);

                if (account == null)
                {
                    WriteLine("Invalid credentials");
                }
                else
                {
                    validEntry = true;
                }
            }
            ATM atm = new ATM();
            bool userAdmin = (account.username == "admin");

            while (completeTransaction)
            {
                WriteLine("ATM Menu");
                WriteLine("1. Deposit");
                WriteLine("2. Withdraw");
                WriteLine("3. Balance");
                WriteLine("4. Last 3 Transactions");
                WriteLine("5. Exit");
                WriteLine("6. Admin Use Only");
                WriteLine("Please choose an option: ");
                userEntry = ReadLine();

                switch (userEntry)
                {
                    case "1":
                        WriteLine("Enter amount to deposit: ");
                        double depositAmount = double.Parse(ReadLine());
                        atm.AccountTransactions(account, "deposit", depositAmount);
                        break;

                    case "2":
                        WriteLine("Enter amount to withdraw: ");
                        double withdrawAmount = double.Parse(ReadLine());
                        atm.AccountTransactions(account, "withdraw", withdrawAmount);
                        break;

                    case "3":
                        atm.AccountTransactions(account, "balance", 0);
                        break;

                    case "4":
                        atm.AccountTransactions(account, "transactions", 0);
                        break;

                    case "5":
                        completeTransaction = false;
                        WriteLine("Thank you for your business.");
                        break;
                    case "6":
                        if (userAdmin)
                        {
                            foreach (var acc in accounts)
                            {
                                WriteLine("Account: {0}, Balance: ${1}", acc.username, acc.balance);
                                WriteLine("Transactions: ");
                                foreach (var trans in acc.ShowTransactions())
                                {
                                    WriteLine(trans);
                                }
                                WriteLine();
                            }
                        }
                        else
                        {
                            WriteLine("Denied. Only for Administration");
                        }
                        break;
                    default:
                        WriteLine("Invalid choice. Please try again.");
                        break;
                }
            }

            WriteLine("Do you want to log in as another user? y or n: ");
            userContinue = ReadLine();
            if (userContinue == "n")
            {
                WriteLine("Thank you for your business!");
                runningProgram = false;
            }
            else
            {
                completeTransaction = true;
            }
        }
    }

    public Account Login(string username, string password, Account[] accounts)
    {
        for (int i = 0; i < accounts.Length; i++)
        {
            if (accounts[i].username == username && accounts[i].password == password)
            {
                return accounts[i];
            }
        }
        return null;
    }
}
