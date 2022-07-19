import com.opencsv.bean.util.OpencsvUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Client {

    public int clientID;
    public ArrayList<Integer> accountID;
    public  String name;
    public String phoneNumber;
    public String email;
    public String password;
    public String securityQuestion;
    public String securityAnswer;
    public String postalCode;
    public Date dateOfBirth;

    Scanner in = new Scanner(System.in);

    public void createUser() throws ParseException {
        System.out.println("****Please follow the steps to register as a new user****");
        System.out.print("Enter fullname ");
        name = in.nextLine();
        System.out.print("Enter phone number: ");
        phoneNumber = in.nextLine();
        System.out.print("Enter emailID: ");
        email = in.nextLine();
        System.out.print("Enter postal code: ");
        postalCode = in.nextLine();
        System.out.print("Enter date of birth(dd/MM/yyyy): ");
        dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(in.nextLine());
        System.out.print("Enter password: ");
        password = in.nextLine();
        System.out.print("Enter security question: ");
        securityQuestion = in.nextLine();
        System.out.print("Enter security answer: ");
        securityAnswer = in.nextLine();

        System.out.println("Enter Y to proceed or any other key to return to home screen.");
        String choice = in.nextLine();
        //choice.toUpperCase() == "Y" ? setUserData() && Banking.main() : Banking.main();

    }

    public void updateUser(){

    }

    public void resetPassword(){

    }

    public void createAccount(){
        System.out.println("***************************************************");
        System.out.println("Please select one of the below account type:");
        System.out.println("1. Chequing");
        System.out.println("2. Savings");
        System.out.println("3. Exit");
        System.out.println("***************************************************");
        String accountTypeChoice = in.nextLine();
        switch (accountTypeChoice){
            case "1": //chequing
                System.out.println("Account created successfully.");

                //
                String accountNumber = Helper.updateAccountData("String"); // must generate a random
                //id and sent it back to user, also must append to the
                //list too
                System.out.printf("Account number: %S", accountNumber);
                break;
            case "2": //test
                break;
        }
    }

    public void loginUser(){

    }

    public void performBankingTransactions(){

    }

}
