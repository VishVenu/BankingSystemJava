import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Banking {
    static Scanner in = new Scanner(System.in);
    static Client currentUser = new Client();

    public static Client endUser;
    public static void main(String[] args) {
        showWelcomeScreen();
        if(endUser!=null){
            PostLoginMenu();
        }else {
            PreLoginMenu();
        }
    }

    private static void PreLoginMenu(){
        showPreLoginMenu();
        int input = in.nextInt();
        switch (input){
            case 1:
                NewRegistration();
            case 2:
                currentUser.loginUser();
                PostLoginMenu();
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
    private static void PostLoginMenu(){
        showPostLoginMenu();
        int input = in.nextInt();
        switch (input) {
            case 1:
                UpdateUserDetails();
                break;
        }
    }

    private static void NewRegistration() {
        try {
            currentUser.createUser();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private static void UpdateUserDetails(){
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
        System.out.println("4. Exit");
        System.out.println("***************************************************");
    }
}
