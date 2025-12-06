package Controller;

import Model.*;
import java.util.Scanner;

public class RentCar implements Operation {

    @Override
    public void operation(Database database, Scanner scanner, User user) {

        System.out.println("\nAVAILABLE CARS:");
        for (Car c : database.getCars()) {
            if (c.getAvailable()) {
                System.out.println(c.getID() + " - " + c.getBrand() + " " + c.getModel());
            }
        }

        System.out.print("Choose Car ID: ");
        int id = scanner.nextInt();

        Car car = database.getCars().stream()
                .filter(c -> c.getID() == id && c.getAvailable())
                .findFirst()
                .orElse(null);

        if (car == null) {
            System.out.println("Car not available.");
            return;
        }

        System.out.print("Hours to rent: ");
        int hours = scanner.nextInt();

        Rent rent = new Rent();
        rent.setID(database.getRents().size() + 1);
        rent.setCar(car);
        rent.setUser(user);
        rent.setHours(hours);
        rent.setTotal(car.getPrice() * hours);
        rent.setStatus("Active");

        car.setAvailable(false);
        database.addRent(rent);

        System.out.println("Rent created successfully! Total = " + rent.getTotal());
    }
}
