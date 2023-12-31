package lpuapp;

import lpuapp.database.DBUtils;

import java.util.List;
import java.util.Scanner;

public class SignUp {
    private void printWelcomeMessage() {
        System.out.println("Welcome to LPU!");
        Admin.printAdmins();
        System.out.println();
    }

    private void signUp() {
        Admin admin = new Admin("Ivan", "Sidorov");
        Admin.addAdmin(admin);

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("Local Admins list");
        Admin.printAdmins();

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("DB Users list");
        List<Person> dbPersons = DBUtils.getTablePersonData();
        System.out.println(dbPersons);

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("DB Admins list");
        List<Admin> dbAdmins = DBUtils.getTableAdminData();
        System.out.println(dbAdmins);

        admin = new Admin("Anrey", "Sidorov");
        Admin.addAdmin(admin);

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("Local Admins list");
        Admin.printAdmins();

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("DB Users list");
        dbPersons = DBUtils.getTablePersonData();
        System.out.println(dbPersons);

        System.out.println();
        System.out.println("___________________________________________");
        System.out.println("DB Admins list");
        dbAdmins = DBUtils.getTableAdminData();
        System.out.println(dbAdmins);


        System.out.println();
        System.out.println("Enter 'Q' for quit OR");
        System.out.println();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter username: ");
        String input = in.nextLine();

        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }

        String username = input;

        System.out.print("Enter password: ");
        input = in.nextLine();
        if (input.equals("Q") || input.equals("q")) {
            System.out.println("Goodbye");
            System.exit(0);
        }
        String password = input;

        checkCredentials(username, password);

    }

    private void checkCredentials(String userName, String password) {
        List<Admin> adminsList = Admin.getAdmins();
        for (Admin admin : adminsList) {
            if (admin.getUserName().equals(userName) && admin.getPassword().equals(password)) {
                System.out.println("Welcome, " + admin.getFirstName() + " " + admin.getLastName() + "!");
                admin.runAdmin();
            } else {
                System.out.println("Sorry, we can't recognize you. Check your credentials and try again later.");
                System.out.println("Goodbye");
                System.exit(0);
                return;
            }
        }
    }

    public void runLPUApp() {
        printWelcomeMessage();
        signUp();

    }
}
