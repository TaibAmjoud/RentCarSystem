import Model.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        Admin defaultAdmin = new Admin();
        defaultAdmin.setID(1);
        defaultAdmin.setFirstName("Admin");
        defaultAdmin.setLastName("System");
        defaultAdmin.setEmail("admin@rentcar.com");
        defaultAdmin.setPhoneNumber("0000000000");
        defaultAdmin.setPassword("admin");
        database.addUser(defaultAdmin);

        while (true) {
            System.out.println("\n===== RENT CAR SYSTEM =====");
            System.out.println("1. Login");
            System.out.println("2. Register as Client");
            System.out.println("3. Quit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    login(database, scanner);
                    break;
                case 2:
                    registerClient(database, scanner);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void login(Database database, Scanner scanner) {
        System.out.println("Enter Email:");
        String email = scanner.next();
        System.out.println("Enter Password:");
        String password = scanner.next();

        User user = database.login(email, password);

        if (user == null) {
            System.out.println("Invalid Login!");
            return;
        }

        System.out.println("Welcome " + user.getFirstName());

        if (user instanceof Admin) adminMenu(database, scanner, user);
        if (user instanceof Client) clientMenu(database, scanner, user);
    }

    private static void registerClient(Database database, Scanner scanner) {
        Client client = new Client();

        client.setID(database.getUsers().size() + 1);
        System.out.println("First name:"); client.setFirstName(scanner.next());
        System.out.println("Last name:"); client.setLastName(scanner.next());
        System.out.println("Email:"); client.setEmail(scanner.next());
        System.out.println("Phone:"); client.setPhoneNumber(scanner.next());
        System.out.println("Password:"); client.setPassword(scanner.next());

        database.addUser(client);
        System.out.println("Client registered!");
    }

    private static void adminMenu(Database db, Scanner sc, User user) {
        Admin admin = (Admin) user;

        while (true) {
            admin.showList();
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 7) break;
            admin.execute(choice, db, sc);
        }
    }

    private static void clientMenu(Database db, Scanner sc, User user) {
        Client client = (Client) user;

        while (true) {
            client.showList();
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 6) break;
            client.execute(choice, db, sc);
        }
    }
}
