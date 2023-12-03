package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.List;
import java.util.Scanner;

public class FindCarBySpeedRangeCommand implements Command {
    private TaxiPark taxiPark;

    public FindCarBySpeedRangeCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть мінімальну межу швидкості:");
        double minSpeed = scanner.nextDouble();

        System.out.println("Введіть максимальну межу швидкості:");
        double maxSpeed = scanner.nextDouble();

        List<Car> carsInSpeedRange = taxiPark.getCarsInSpeedRange(minSpeed, maxSpeed);

        if (!carsInSpeedRange.isEmpty()) {
            System.out.println("Автомобілі, які відповідають заданому діапазону швидкості:");
            for (Car car : carsInSpeedRange) {
                System.out.println("Марка: " + car.getMake() + ", Рік: " + car.getYear() + ", Швидкість: " + car.getSpeed());
            }
        } else {
            System.out.println("Автомобілі відсутні в заданому діапазоні швидкості.");
        }
    }
    public String getDescription() {
        return "Знайти автомобіль за діапазоном швидкості";
    }
}

