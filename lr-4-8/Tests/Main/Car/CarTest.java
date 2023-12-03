package Main.Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car("Toyota", 2022, 8.5, 25000.0, 120.0);

        assertEquals("Toyota", car.getMake());
        assertEquals(2022, car.getYear());
        assertEquals(8.5, car.getFuelConsumption(), 0.001); // 0.001 is the delta for double comparison
        assertEquals(25000.0, car.getPrice(), 0.001);
        assertEquals(120.0, car.getSpeed(), 0.001);
    }

    @Test
    public void testSettersAndGetters() {
        Car car = new Car("Honda", 2021, 9.0, 22000.0, 110.0);

        car.setMake("Nissan");
        car.setYear(2023);
        car.setFuelConsumption(7.5);
        car.setPrice(27000.0);
        car.setSpeed(130.0);

        assertEquals("Nissan", car.getMake());
        assertEquals(2023, car.getYear());
        assertEquals(7.5, car.getFuelConsumption(), 0.001);
        assertEquals(27000.0, car.getPrice(), 0.001);
        assertEquals(130.0, car.getSpeed(), 0.001);
    }
}