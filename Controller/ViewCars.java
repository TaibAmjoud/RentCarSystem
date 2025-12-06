package Controller;

import Model.*;
import java.util.Scanner;

public class ViewCars implements Operation {
    @Override
    public void operation(Database database, Scanner scanner, User user) {
        System.out.println("\n------ CAR LIST ------");

        if (database.getCars().isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        for (Car c : database.getCars()) {
            System.out.println("ID: " + c.getID() +
                    " | " + c.getBrand() +
                    " " + c.getModel() +
                    " | " + c.getColor() +
                    " | Year: " + c.getYear() +
                    " | Price/h: " + c.getPrice() +
                    " | Available: " + c.getAvailable());
        }
        System.out.println("-----------------------");
    }
}
