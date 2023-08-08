import java.util.InputMismatchException;
import java.util.Scanner;

public class LogIn {

    public User admin;

    public insertData insertDB;
    public DataDB myDB;


    public void logingIn(){

        Scanner input = new Scanner(System.in);
        int command = 0;

        while (command == 0) {
            System.out.println("enter integer except 0 for quit");
            try {
                command = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("input mismatch exception");
            }
            if (command == 0) { // for quit before rewrite
                command = 2;
            }

            System.out.println("Username : ");    // log in method 1. for username
            getAdmin().setUsername(input.next());
            System.out.println("Password");      // 2. for password
            getAdmin().setPassword(input.next());
            System.out.println("Press 1 for check"); //3. for ok}
            try {
                command = input.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("input mismatch exception");
            }
            while (!getInsertDB().checkUserInDB() && command == 1){
                System.out.println("Username or password false");
                System.out.println("enter integer except 0 for quit");
                try {
                    command = input.nextInt();
                }
                catch (InputMismatchException e){
                    System.out.println("input mismatch exception");
                }
                if (command == 0){
                    command = 2;
                }
                else if (command != 2 && command != 3){
                    System.out.println("Username : ");    // log in method 1. for username
                    getAdmin().setUsername(input.next());
                    System.out.println("Password");      // 2. for password
                    getAdmin().setPassword(input.next());
                    System.out.println("checking");
                }
            }
            System.out.println("WELCOME USER");
//            System.out.println("Enter '3' for delete your account");
//            command = input.nextInt();
//            while (command == 3){
//                System.out.println("enter integer except 0 for quit");
//                command = input.nextInt();
//                if (command != 3){
//                    System.out.println("Are you sure to delete your accuont \n[YES] = 1\n[NO] = 0");
//                    command = input.nextInt();
//                    if (command == 1){
//                        getMyDB().deleteUserInDB(getInsertDB().getUser());
//                    }
//                }
//            }
        }
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public insertData getInsertDB() {
        return insertDB;
    }

    public void setInsertDB(insertData insertDB) {
        this.insertDB = insertDB;
    }

    public DataDB getMyDB() {
        return myDB;
    }

    public void setMyDB(DataDB myDB) {
        this.myDB = myDB;
    }

}