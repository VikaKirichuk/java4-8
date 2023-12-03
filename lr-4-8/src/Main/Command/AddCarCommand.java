package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.Scanner;

public class AddCarCommand implements Command {
    private TaxiPark taxiPark;

    public AddCarCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть марку автомобіля:");
        String make = scanner.nextLine();
        System.out.println("Введіть рік випуску:");
        int year = scanner.nextInt();
        System.out.println("Введіть витрату пального на 100 км:");
        double fuelConsumption = scanner.nextDouble();
        System.out.println("Введіть ціну автомобіля:");
        double price = scanner.nextDouble();
        System.out.println("Введіть максимальну швидкість до якої розганяється автомобіль:");
        double speed = scanner.nextDouble();
        // Створюємо новий автомобіль з отриманими даними
        Car newCar = new Car(make, year, fuelConsumption, price, speed);
        // Додаємо автомобіль до таксопарку
        taxiPark.addCar(newCar);
        System.out.println("Автомобіль додано до таксопарку.") ;
    }
    public String getDescription() {
        return "Додати автомобіль";
    }
}