import java.util.Scanner;
public class Bankingsystem {
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);

        //create initial accounts
        System.out.print("Number of Accounts do you want to input? ");
        int n = sc.nextInt();
        Account C[] = new Account[n];
        for (int i = 0; i < C.length; i++)
        {
            C[i] = new Account();
            C[i].openAccount();
        }
        // loop runs until number 5 is not pressed to exit
        int ch;
        do {
            System.out.println("\n *Banking System Application*");
            System.out.println(" 1. view the Account details \n 2. View the Account Balance\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Transfer money between accounts \n 6.pay bills \n 7.Exit ");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch)
            {
                case 1:
                    for (int i = 0; i < C.length; i++)
                    {
                        // C[i].showBalance();
                        System.out.println("****************");
                        System.out.println("Current account balance:" + C[i].showBalance());
                        System.out.println("****************");
                    }
                    break;
                case 2:
                    System.out.print("Enter account no. you want to search: ");
                    String ac_no = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++)
                    {
                        found = C[i].search(ac_no);
                        if (found)
                        {
                            System.out.println("Current Balance in Account = " +C[i].balance);
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account no. : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++)
                    {
                        found = C[i].search(ac_no);
                        if (found)
                        {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account No : ");
                    ac_no = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++)
                    {
                        found = C[i].search(ac_no);
                        if (found)
                        {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Search failed! Account doesn't exist..!!");
                    }
                    break;



                case 5:

                    System.out.println("Enter the amount of money you would like to transfer: $");
                    double moneyToTransfer = sc.nextDouble();

                    System.out.println("Enter the account number you would like to transfer money from:");
                    String fromAccount = sc.next();

                    boolean foundfrom = false;
                    for (int i = 0; i < C.length; i++)
                    {
                        //foundfrom = C[i].search(fromAccount);
                        //double from_balance = C[i].showBalance();
                        if (C[i].search(fromAccount))
                        {
                            if (C[i].showBalance() >= moneyToTransfer)
                            {
                                C[i].balance = (long) (C[i].balance - moneyToTransfer);
                                System.out.println("Updated Balance in account number " +fromAccount+ " is :" +C[i].balance);
                            }
                            else
                            {
                                System.out.println("Insufficient Funds");
                            }
                        }

                    }

                    System.out.println("Enter the account number you would like to transfer money to:");
                    String toAccount = sc.next();

                    //boolean foundto = false;

                    for (int i = 0; i < C.length; i++)
                    {
                        //foundto = C[i].search(fromAccount);
                        if (C[i].search(toAccount))
                        {
                            //double to_balance = C[i].showBalance();
                            C[i].balance = (long) (C[i].balance + moneyToTransfer);
                            System.out.println("Updated Balance in account number " +toAccount+ " is :" +C[i].balance);
                        }

                    }
                    moneytransfer(moneyToTransfer, fromAccount, toAccount);
                    break;
                case 6:
                    System.out.println("Enter the name of the company you want to pay the bill");
                    String companyName = sc.next();
                    System.out.println("enter the amount you want to pay");
                    double payment = sc.nextDouble();
                    System.out.println("Enter the account number you would like to pay money from:");
                    String paymentAccount = sc.next();

                    for (int i = 0; i < C.length; i++) {

                        if (C[i].search(paymentAccount)) {
                            if (C[i].showBalance() >= payment) {
                                C[i].balance = (long) (C[i].balance - payment);
                                System.out.println("your payment was successful.your current balance is" + C[i].balance);

                            } else {
                                System.out.println("Insufficient Funds");
                            }
                        }

                    } break;
                case 7:
                    System.out.println("See you soon...");
                    break;
            }


        }
        while (ch != 7);
    }

    private static void moneytransfer(double moneyToTransfer, String fromAccount, String toAccount)
    {
        System.out.println("Funds successfully transfered.");
    }

}

