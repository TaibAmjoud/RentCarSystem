package Controller;

import Model.*;
import java.util.Scanner;

public class UpdateCar implements Operation {
    @Override
    public void operation(Database database, Scanner scanner, User user) {
        System.out.print("Enter Car ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Car car = database.getCars().stream()
                .filter(c -> c.getID() == id)
                .findFirst()
                .orElse(null);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        System.out.print("New Brand (" + car.getBrand() + "): ");
        String brand = scanner.nextLine();
        if (!brand.isEmpty()) car.setBrand(brand);

        System.out.print("New Model (" + car.getModel() + "): ");
        String model = scanner.nextLine();
        if (!model.isEmpty()) car.setModel(model);

        System.out.print("New Color (" + car.getColor() + "): ");
        String color = scanner.nextLine();
        if (!color.isEmpty()) car.setColor(color);

        System.out.print("New Year (" + car.getYear() + "): ");
        String yearStr = scanner.nextLine();
        if (!yearStr.isEmpty()) car.setYear(Integer.parseInt(yearStr));

        System.out.print("New Price (" + car.getPrice() + "): ");
        String priceStr = scanner.nextLine();
        if (!priceStr.isEmpty()) car.setPrice(Double.parseDouble(priceStr));

        System.out.print("Available (true/false) (" + car.getAvailable() + "): ");
        String availStr = scanner.nextLine();
        if (!availStr.isEmpty()) car.setAvailable(Boolean.parseBoolean(availStr));

        System.out.println("Car updated successfully!");
    }
}
