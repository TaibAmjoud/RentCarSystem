package Controller;

import Model.*;
import java.util.Scanner;

public class ReturnCar implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {

        Rent rent = database.getRents().stream()
                .filter(r -> r.getUser().getID() == user.getID() && r.getStatus().equals("Active"))
                .findFirst()
                .orElse(null);

        if (rent == null) {
            System.out.println("No active rent found.");
            return;
        }

        rent.setStatus("Finished");
        rent.getCar().setAvailable(true);

        System.out.println("Car returned successfully!");
    }
}
