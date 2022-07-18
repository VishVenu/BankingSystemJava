import java.util.Scanner;

public class Banking {
    static Scanner in = new Scanner(System.in);

    public static Client endUser;
    public static void main(String[] args) {
        showWelcomeScreen();
        if(endUser!=null){
            showPostLoginMenu();
        }else{
            showPreLoginMenu();
        }
        int input = in.nextInt();
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
