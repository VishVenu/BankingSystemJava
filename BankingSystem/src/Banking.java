import java.text.ParseException;
import java.util.Scanner;

public class Banking {
    static Scanner in = new Scanner(System.in);
    static Client currentUser = new Client();

    public static Client endUser;
    public static void main(String[] args) {
        try{
            showWelcomeScreen();
            if(endUser!=null){
                postLoginMenu();
            }else {
                preLoginMenu();
            }
        } catch (Exception ex){
            System.out.println(ex);
        }

    }

    private static void preLoginMenu() throws ParseException {
        showPreLoginMenu();
        int input = in.nextInt();
        switch (input){
            case 1:
                newRegistration();
            case 2:
                currentUser.loginUser();

                postLoginMenu();
                break;
            case 3:
                currentUser.resetPassword();
                break;
            case 4:
                System.exit(0);
            default:
                //TO DO ask user to reenter
        }

    }
    private static void postLoginMenu() throws ParseException {
        int input = 0;
        while(input!=4) {
            showPostLoginMenu();
            input = in.nextInt();
            switch (input) {
                case 1:
                    updateUserDetails();
                    break;
                case 2:
                    currentUser.createAccount();
                    break;
                case 3:
                    if(currentUser.accounts==null){
                        System.out.println("Please create an account to proceed with banking transactions.");
                        currentUser.createAccount();
                    }else {
                        currentUser.performBankingTransactions();
                    }
                    break;
                case 4:
                    preLoginMenu();
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    break;
            }
        }
    }

    private static void newRegistration() {
        try {
            currentUser.createUser();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private static void updateUserDetails(){
        try {
            currentUser.updateUser();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void showWelcomeScreen(){
        System.out.println("///////////////////////////////////////////");
        System.out.println("--------Welcome to Banking System-----------");
        System.out.println("///////////////////////////////////////////");
    }

    public static void showPreLoginMenu(){
        System.out.println("***************************************************");
        System.out.println("Please select one of the below options:");
        System.out.println("1. New user registration");
        System.out.println("2. Login user");
        System.out.println("3. Reset password");
        System.out.println("4. Exit");
        System.out.println("***************************************************");
    }

    public static void showPostLoginMenu(){
        System.out.println("***************************************************");
        System.out.println("Please select one of the below options:");
        System.out.println("1. Update user details");
        System.out.println("2. Create new banking account");
        System.out.println("3. Perform banking transactions");
        System.out.println("4. Go back to previous menu");
        System.out.println("***************************************************");
    }
}
