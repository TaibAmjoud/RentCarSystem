package Model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<Rent> rents = new ArrayList<>();

    public void addUser(User user) { users.add(user); }
    public void addCar(Car car) { cars.add(car); }
    public void addRent(Rent rent) { rents.add(rent); }

    public List<Car> getCars() { return cars; }
    public List<User> getUsers() { return users; }
    public List<Rent> getRents() { return rents; }

    public User login(String email, String password) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
