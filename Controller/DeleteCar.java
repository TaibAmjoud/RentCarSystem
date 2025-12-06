package Controller;

import Model.*;
import java.util.Scanner;

public class DeleteCar implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {
        System.out.print("Enter Car ID to delete: ");
        int id = scanner.nextInt();

        boolean removed = database.getCars()
                .removeIf(c -> c.getID() == id);

        if (removed)
            System.out.println("Car deleted successfully!");
        else
            System.out.println("Car not found.");
    }
}
