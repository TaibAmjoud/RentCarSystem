package Controller;

import Model.*;
import java.util.Scanner;

public class ShowRents implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {
        System.out.println("\n------ ALL RENTS ------");

        if (database.getRents().isEmpty()) {
            System.out.println("No rents found.");
            return;
        }

        for (Rent r : database.getRents()) {
            System.out.println(
                    "Rent ID: " + r.getID() +
                            " | User: " + r.getUser().getFirstName() +
                            " | Car: " + r.getCar().getBrand() + " " + r.getCar().getModel() +
                            " | Hours: " + r.getHours() +
                            " | Total: " + r.getTotal() +
                            " | Date: " + r.getDateTime() +
                            " | Status: " + r.getStatus()
            );
        }

        System.out.println("------------------------");
    }
}
