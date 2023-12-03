package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShowAllCarsCommandTest {

    @Test
    public void execute_ShouldPrintAllCarsInformation() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        ShowAllCarsCommand showCommand = new ShowAllCarsCommand(taxiPark);

        // Redirect System.out
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Act
        showCommand.execute();

        // Assert
        String expectedOutput = "Інформація про всі автомобілі у таксопарку:\n" +
                "Марка: Toyota\n" +
                "Рік випуску: 2022\n" +
                "Витрата пального на 100 км: 8.5\n" +
                "Ціна: 25000.0\n" +
                "Швидкість: 120.0\n" +
                "-----------\n" +
                "Марка: Honda\n" +
                "Рік випуску: 2021\n" +
                "Витрата пального на 100 км: 9.0\n" +
                "Ціна: 22000.0\n" +
                "Швидкість: 110.0\n" +
                "-----------\n" +
                "Марка: Nissan\n" +
                "Рік випуску: 2023\n" +
                "Витрата пального на 100 км: 7.5\n" +
                "Ціна: 27000.0\n" +
                "Швидкість: 130.0\n" +
                "-----------\n";


    }
}
