package Controller;

import Model.*;
import java.util.Scanner;

public class EditMyData implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {
        scanner.nextLine();

        System.out.print("New First Name (" + user.getFirstName() + "): ");
        String fn = scanner.nextLine();
        if (!fn.isEmpty()) user.setFirstName(fn);

        System.out.print("New Last Name (" + user.getLastName() + "): ");
        String ln = scanner.nextLine();
        if (!ln.isEmpty()) user.setLastName(ln);

        System.out.print("New Email (" + user.getEmail() + "): ");
        String em = scanner.nextLine();
        if (!em.isEmpty()) user.setEmail(em);

        System.out.print("New Phone (" + user.getPhoneNumber() + "): ");
        String ph = scanner.nextLine();
        if (!ph.isEmpty()) user.setPhoneNumber(ph);

        System.out.print("New Password: ");
        String pw = scanner.nextLine();
        if (!pw.isEmpty()) user.setPassword(pw);

        System.out.println("Data updated successfully!");
    }
}
