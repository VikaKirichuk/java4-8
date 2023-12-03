package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.Test;

public class SortCarsByFuelConsumptionCommandTest {

    @Test
    public void execute_ShouldSortCarsByFuelConsumption() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        SortCarsByFuelConsumptionCommand sortCommand = new SortCarsByFuelConsumptionCommand(taxiPark);

        // Act
        sortCommand.execute();

        // Assert
        String expectedOutput = "Автомобілі відсортовано за витратою пального:\n" +
                "Марка: Nissan\n" +
                "Витрата пального: 7.5\n" +
                "Рік: 2023\n" +
                "\n" +
                "Марка: Toyota\n" +
                "Витрата пального: 8.5\n" +
                "Рік: 2022\n" +
                "\n" +
                "Марка: Honda\n" +
                "Витрата пального: 9.0\n" +
                "Рік: 2021\n";


    }
}
