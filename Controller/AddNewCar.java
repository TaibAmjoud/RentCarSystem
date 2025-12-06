package Controller;

import Model.*;
import java.util.Scanner;

public class AddNewCar implements Operation {
    @Override
    public void operation(Database database, Scanner scanner, User user) {
        scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Model: ");
        String model = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Price per Hour: ");
        double price = scanner.nextDouble();

        int id = database.getCars().size() + 1;
        Car car = new Car(id, brand, model, color, year, price, true);

        database.addCar(car);
        System.out.println("Car added successfully (ID = " + id + ")");
    }
}
