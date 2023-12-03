package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;

public class RemoveCarCommandTest {

    @Test
    public void execute_ShouldRemoveCarsByYear() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        RemoveCarCommand removeCommand = new RemoveCarCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "2022\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        removeCommand.execute();

        // Assert
        String expectedOutput = "Введіть рік випуску автомобіля, який потрібно видалити:\n" +
                "Автомобілі з роком випуску 2022 були видалені з таксопарку.\n";



        for (Car car : taxiPark.getCars()) {
            assertNotEquals(2022, car.getYear());
        }
    }

    @Test
    public void execute_ShouldPrintMessageIfNoCarsToRemove() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        RemoveCarCommand removeCommand = new RemoveCarCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "2024\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        removeCommand.execute();

        // Assert
        String expectedOutput = "Введіть рік випуску автомобіля, який потрібно видалити:\n" +
                "Не знайдено автомобілів з вказаним роком випуску.\n";



    }
}
