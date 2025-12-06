package Model;

import Controller.*;

public class Admin extends User {

    private Operation[] operations = new Operation[]{
            new AddNewCar(),
            new ViewCars(),
            new UpdateCar(),
            new DeleteCar(),
            new AddNewAdmin(),
            new ShowRents()
    };

    @Override
    public void showList() {
        System.out.println("\n----- ADMIN MENU -----");
        System.out.println("1. Add New Car");
        System.out.println("2. View Cars");
        System.out.println("3. Update Car");
        System.out.println("4. Delete Car");
        System.out.println("5. Add New Admin");
        System.out.println("6. Show Rents");
        System.out.println("7. Quit\n");
    }

    public void execute(int choice, Database db, java.util.Scanner sc) {
        if (choice < 1 || choice > operations.length) {
            System.out.println("Invalid choice!");
            return;
        }
        operations[choice - 1].operation(db, sc, this);
    }
}
