package Controller;

import Model.*;
import java.util.Scanner;

public class ShowMyRents implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {

        System.out.println("\n------ MY RENTS ------");

        database.getRents().stream()
                .filter(r -> r.getUser().getID() == user.getID())
                .forEach(r -> System.out.println(
                        "ID: " + r.getID() +
                                " | Car: " + r.getCar().getBrand() + " " + r.getCar().getModel() +
                                " | Hours: " + r.getHours() +
                                " | Total: " + r.getTotal() +
                                " | Status: " + r.getStatus()
                ));

        System.out.println("-----------------------");
    }
}
