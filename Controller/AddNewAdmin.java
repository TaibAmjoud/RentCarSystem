package Controller;

import Model.Admin;
import Model.Database;
import Model.Operation;
import Model.User;

import java.util.Scanner;

public class AddNewAdmin implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Email:");
        String email = scanner.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        Admin admin = new Admin();
        admin.setID(database.getUsers().size() + 1);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setPassword(password);

        database.addUser(admin);

        System.out.println("Admin added successfully!");


    }
}
