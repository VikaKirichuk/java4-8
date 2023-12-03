package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculateCostCommandTest {
    public void testExecute() {
        // Create a TaxiPark with some sample cars
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2023, 9.0, 26000.0, 130.0));

        // Redirecting System.out.println to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Creating the CalculateCostCommand with the actual TaxiPark
        Command calculateCostCommand = new CalculateCostCommand(taxiPark);

        // Executing the command
        calculateCostCommand.execute();

        // Resetting System.out to print to console again
        System.setOut(System.out);

        // Verifying the printed output
        assertEquals("Вартість автопарку: 51000.0\n", outputStream.toString());
    }

    @Test
    public void testGetDescription() {
        TaxiPark taxiPark = new TaxiPark();
        Command calculateCostCommand = new CalculateCostCommand(taxiPark);

        assertEquals("Підрахувати вартість автопарку", calculateCostCommand.getDescription());
    }
}