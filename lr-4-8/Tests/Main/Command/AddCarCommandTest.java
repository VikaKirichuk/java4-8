package Main.Command;

import Main.Car.TaxiPark;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class AddCarCommandTest {
    public void testExecute() {
        // Save the original System.in and System.out
        InputStream originalSystemIn = System.in;
        PrintStream originalSystemOut = System.out;

        // Create a TaxiPark
        TaxiPark taxiPark = new TaxiPark();
        Command addCarCommand = new AddCarCommand(taxiPark);

        try {
            // Redirect System.in to provide input
            String input = "Toyota\n2022\n8.5\n25000.0\n120.0\n";
            ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
            System.setIn(inContent);

            // Redirect System.out to capture output
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            // Execute the command
            addCarCommand.execute();

            // Reset System.in and System.out
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);

            // Verify the car is added to the taxi park
            assertEquals("Автомобіль додано до таксопарку.\n", outContent.toString());
            assertEquals(1, taxiPark.getCars().size());
        } finally {
            // Reset System.in and System.out in case of an exception
            System.setIn(originalSystemIn);
            System.setOut(originalSystemOut);
        }
    }

    @Test
    public void testGetDescription() {
        TaxiPark taxiPark = new TaxiPark();
        Command addCarCommand = new AddCarCommand(taxiPark);

        assertEquals("Додати автомобіль", addCarCommand.getDescription());
    }

}