package Model;

import Controller.*;
import java.util.Scanner;

public class Client extends User {

    private Operation[] operations = new Operation[]{
            new ViewCars(),
            new RentCar(),
            new ReturnCar(),
            new ShowMyRents(),
            new EditMyData()
    };

    @Override
    public void showList() {
        System.out.println("\n----- CLIENT MENU -----");
        System.out.println("1. View Cars");
        System.out.println("2. Rent Car");
        System.out.println("3. Return Car");
        System.out.println("4. Show My Rents");
        System.out.println("5. Edit My Data");
        System.out.println("6. Quit\n");
    }

    public void execute(int choice, Database db, Scanner sc) {
        if (choice < 1 || choice > operations.length) {
            System.out.println("Invalid choice!");
            return;
        }
        operations[choice - 1].operation(db, sc, this);
    }
}
