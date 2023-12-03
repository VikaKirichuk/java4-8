
package Main.Command;

// Клас команди для виведення інформації про всі автомобілі
import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.List;
public class ShowAllCarsCommand implements Command {
    private TaxiPark taxiPark;

    public ShowAllCarsCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }
    @Override
    public void execute() {
        List<Car> cars = taxiPark.getCars();
        if (cars.isEmpty()) {
            System.out.println("Таксопарк порожній.");
        } else {
            System.out.println("Інформація про всі автомобілі у таксопарку:");
            for (Car car : cars) {
                System.out.println("Марка: " + car.getMake());
                System.out.println("Рік випуску: " + car.getYear());
                System.out.println("Витрата пального на 100 км: " + car.getFuelConsumption());
                System.out.println("Ціна: " + car.getPrice());
                System.out.println("Швидкість"+car.getSpeed());
                System.out.println("-----------");
            }
        }
    }
    @Override
    public String getDescription() {
        return "Вивести інформацію про всі автомобілі";
    }
}
