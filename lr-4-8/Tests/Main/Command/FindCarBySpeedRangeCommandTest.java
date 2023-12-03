package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class FindCarBySpeedRangeCommandTest {

    @Test
    public void execute_ShouldPrintCarsInSpeedRange() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        FindCarBySpeedRangeCommand findCommand = new FindCarBySpeedRangeCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "100\n150\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        findCommand.execute();

        // Assert
        String expectedOutput = "Введіть мінімальну межу швидкості:\n" +
                "Введіть максимальну межу швидкості:\n" +
                "Автомобілі, які відповідають заданому діапазону швидкості:\n" +
                "Марка: Toyota, Рік: 2022, Швидкість: 120.0\n" +
                "Марка: Honda, Рік: 2021, Швидкість: 110.0\n" +
                "Марка: Nissan, Рік: 2023, Швидкість: 130.0";


    }

    @Test
    public void execute_ShouldPrintNoCarsInSpeedRange() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        FindCarBySpeedRangeCommand findCommand = new FindCarBySpeedRangeCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "150\n200\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        findCommand.execute();

        // Assert
        String expectedOutput = "Введіть мінімальну межу швидкості:\n" +
                "Введіть максимальну межу швидкості:\n" +
                "Автомобілі відсутні в заданому діапазоні швидкості.";


    }
}
