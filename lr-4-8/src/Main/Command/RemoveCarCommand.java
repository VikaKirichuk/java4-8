package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveCarCommand implements Command {
    private TaxiPark taxiPark;

    public RemoveCarCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рік випуску автомобіля, який потрібно видалити:");
        int yearToDelete = scanner.nextInt();

        List<Car> carsToRemove = new ArrayList<>();
        for (Car car : taxiPark.getCars()) {
            if (car.getYear() == yearToDelete) {
                carsToRemove.add(car);
            }
        }

        if (carsToRemove.isEmpty()) {
            System.out.println("Не знайдено автомобілів з вказаним роком випуску.");
        } else {
            for (Car car : carsToRemove) {
                taxiPark.removeCar(car);
            }
            System.out.println("Автомобілі з роком випуску " + yearToDelete + " були видалені з таксопарку.");
        }
    }
    @Override
    public String getDescription() {
        return "Видалити автомобіль за критеріями";
    }
}
