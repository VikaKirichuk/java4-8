package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;

import java.util.List;

public class SortCarsByFuelConsumptionCommand implements Command {
    private TaxiPark taxiPark;

    public SortCarsByFuelConsumptionCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }

    @Override
    public void execute() {
        taxiPark.sortCarsByFuelConsumption();
        List<Car> sortedCars = taxiPark.getCars();

        System.out.println("Автомобілі відсортовано за витратою пального:");
        for (Car car : sortedCars) {
            System.out.println("Марка: " + car.getMake());
            System.out.println("Витрата пального: " + car.getFuelConsumption());
            System.out.println("Рік: " + car.getYear());
            System.out.println();
        }
    }

    @Override
    public String getDescription() {
        return "Відсортувати автомобілі за витратою пального";
    }
}
