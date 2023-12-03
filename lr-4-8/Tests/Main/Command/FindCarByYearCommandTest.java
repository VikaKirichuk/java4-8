package Main.Command;

import Main.Car.Car;
import Main.Car.TaxiPark;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class FindCarByYearCommandTest {

    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    void execute_ShouldFindCarsBySpecificYear() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        FindCarByYearCommand findCommand = new FindCarByYearCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "1\n2022\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Act
        findCommand.execute();

        // Assert
        String expectedOutput = "Знайдені автомобілі:\n" +
                "Марка: Toyota, Рік: 2022\n";

    }

    @Test
    void execute_ShouldFindCarsByYearRange() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        taxiPark.addCar(new Car("Toyota", 2022, 8.5, 25000.0, 120.0));
        taxiPark.addCar(new Car("Honda", 2021, 9.0, 22000.0, 110.0));
        taxiPark.addCar(new Car("Nissan", 2023, 7.5, 27000.0, 130.0));

        FindCarByYearCommand findCommand = new FindCarByYearCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "2\n2021\n2022\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Act
        findCommand.execute();

        // Assert
        String expectedOutput = "Знайдені автомобілі:\n" +
                "Марка: Toyota, Рік: 2022\n" +
                "Марка: Honda, Рік: 2021\n";

    }

    @Test
    void execute_ShouldHandleInvalidChoice() {
        // Arrange
        TaxiPark taxiPark = new TaxiPark();
        FindCarByYearCommand findCommand = new FindCarByYearCommand(taxiPark);

        // Redirect System.in to provide input
        String input = "3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Act
        findCommand.execute();

        // Assert
        String expectedOutput = "Невірний вибір.\n";

    }
}
