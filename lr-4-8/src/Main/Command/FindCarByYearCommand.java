package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.List;
import java.util.Scanner;

public class FindCarByYearCommand implements Command {
    private TaxiPark taxiPark;

    public FindCarByYearCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть спосіб пошуку за роком випуску:");
        System.out.println("1. За конкретним роком");
        System.out.println("2. За діапазоном років");
        int searchChoice = scanner.nextInt();

        if (searchChoice == 1) {
            System.out.println("Введіть рік випуску для пошуку:");
            int searchYear = scanner.nextInt();
            List<Car> matchingCars = taxiPark.findCarsByYear(searchYear);
            displayMatchingCars(matchingCars);
        } else if (searchChoice == 2) {
            System.out.println("Введіть мінімальний рік:");
            int minYear = scanner.nextInt();
            System.out.println("Введіть максимальний рік:");
            int maxYear = scanner.nextInt();
            List<Car> matchingCars = taxiPark.findCarsByYearRange(minYear, maxYear);
            displayMatchingCars(matchingCars);
        } else {
            System.out.println("Невірний вибір.");
        }
    }

    public void displayMatchingCars(List<Car> matchingCars) {
        if (matchingCars.isEmpty()) {
            System.out.println("Автомобілі, які відповідають критеріям, відсутні.");
        } else {
            System.out.println("Знайдені автомобілі:");
            for (Car car : matchingCars) {
                System.out.println("Марка: " + car.getMake() + ", Рік: " + car.getYear());
            }
        }
    }
    @Override
    public String getDescription() {
        return "Знайти автомобіль за роком випуску";
    }
}
