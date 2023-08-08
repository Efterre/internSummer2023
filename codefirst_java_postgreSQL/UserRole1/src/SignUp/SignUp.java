import javax.swing.*;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SignUp {

    public User admin;

    public insertData insertDB;
    public DataDB myDB;

    public int move = 0;


    public void signingUp() throws SQLException {   // create account method

        Scanner input = new Scanner(System.in);  // input method
        int command = 0;  // click method

        while (command == 0) { // sign up   // create account   // first loop
            command = 1;
            int jump=0; // counter

            System.out.println("Username : ");  // input username
            getAdmin().setUsername(input.next());
            System.out.println("1 : "+getInsertDB().controlUserName());

            while (getInsertDB().controlUserName()) {  // username already exist

                System.out.println("Username has been using");
                System.out.println("enter '0' for quit , '1' for continue");
                try {
                    command = input.nextInt();  // click method
                } catch (InputMismatchException e){
                    System.out.println(e.toString());
                }
                int trying = 0;

                if (command == 0){
                    break;
                }

                else {
                    System.out.println("Username has been using");
                    System.out.println("Again Username : ");
                    getInsertDB().getUser().setUsername(input.next());
                    trying++;
                    System.out.println("2 : " + getInsertDB().controlUserName());

                    if (trying % 3 != 0) {
                        System.out.println("enter '0' for quit , '1' for continue");
                        command = input.nextInt();
                        trying++;
                    }
                    if (command == 0)
                        break;
                }
            }
            if (command == 0)
                break;
            jump++;
            System.out.println("Password (min 8 char.) : ");
            getAdmin().setPassword(input.next());

            while (getAdmin().getPassword().length() < 8) {   // password is short
                System.out.println("your password must be at least 8 characters\nWrite again : ");
                getAdmin().setPassword(input.next());
            }
            jump++;

            System.out.println("Again Password : ");
            String tempPassword = input.next();

            while (!tempPassword.equals(getAdmin().getPassword()) || (command != 0 && command != 1)) {   // 2 passsword different
                System.out.println("Password is not same");
                System.out.println("Again Password : ");
                tempPassword = input.next();
                System.out.println("Enter '0' for quit first page, Enter '1' for signing up, Enter random integer for quit program");
                command = input.nextInt();
                this.move = command;
                if (command == 0)
                    break;
            }
            if (command != 0){
                jump++;
            }
            User tempUser = getInsertDB().getUser();
            getInsertDB().setUser(this.admin);
            jump++;
            System.out.println(jump);
            if (jump == 3 || jump == 4){
                getInsertDB().setUser(tempUser);
                getInsertDB().setUser(this.admin);
                System.out.println("User is created");
                getInsertDB().addDataToDB();
            }
            else {
                System.out.println("Something get wrong");
            }

            System.out.println("Enter '1' for quit first page, Enter '0' for signing up, Enter random integer for quit program");
            command = input.nextInt();

            if (command != 0) {
                command = 1;
            }else{
                command = 0;
            }
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

    public int getMove() {
        return move;
    }
}