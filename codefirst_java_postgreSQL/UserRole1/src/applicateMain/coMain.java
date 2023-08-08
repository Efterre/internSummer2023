//import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Scanner;

//@Service
public class coMain {

    public void someApp() throws SQLException {
        DataDB myDB = new DataDB();
        if (myDB.getRowCount() == 0) {
            try {
                myDB.createDB();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("PSQLException");
            }
        }


        User admin = new User("admin", "admin1234");
        admin.setMyDB(myDB);

        retrieveData rDB = new retrieveData();

        insertData insertDB = new insertData(myDB.connectionDB(), admin);
        insertDB.setMyDB(myDB);

        LogIn login = new LogIn();
        login.setMyDB(myDB);
        login.setInsertDB(insertDB);
        login.setAdmin(admin);

        SignUp signUp = new SignUp();
        signUp.setMyDB(myDB);
        signUp.setInsertDB(insertDB);
        signUp.setAdmin(admin);

        int firstPage = 0;

        Scanner inCommand = new Scanner(System.in);
        int command = 0;

        while (firstPage == 0) {

            System.out.println("Now, You are in my MainPage\nEnter 0 for quit\nEnter another integer to continue");
            command = inCommand.nextInt();

            int checkCommand = 0;

            if (command == 0) {
                break;
            }

            if (myDB.getRowCount() == 0) {
                System.out.println("There is no user");
                System.out.println("Please sign up");
                System.out.println("Enter '1' for sign up , '0' for quit");
                command = inCommand.nextInt();
                if (command == 0) {
                    firstPage = 1; // ends first while
                } else {
                    signUp.signingUp();
                }
            }
            System.out.println("Enter '1' for sign up , '2' for log in");
            command = inCommand.nextInt();
            if (command == 1) {
                signUp.signingUp();
                command = signUp.getMove();
                while (command == 1) {
                    signUp.signingUp();
                    command = signUp.getMove();
                }
            } else if (command == 2) {
                login.logingIn();
            } else {
                firstPage = 1;
            }
        }
        myDB.printDBtoAL();
        rDB.setMyDB(myDB);
        rDB.DBprinter();

    }
}