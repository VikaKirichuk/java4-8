package Main.Car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaxiParkTest {
    @Test
    public void testCalculateCost() {
        TaxiPark taxiPark = new TaxiPark();

        Car car1 = new Car("Toyota", 2022, 8.5, 25000.0, 120.0);
        Car car2 = new Car("Honda", 2023, 9.0, 26000.0, 130.0);

        taxiPark.addCar(car1);
        taxiPark.addCar(car2);

        double expectedCost = car1.getPrice() + car2.getPrice();
        assertEquals(expectedCost, taxiPark.calculateCost(), 0.01);
    }

    @Test
    public void testGetCarsInSpeedRange() {
        TaxiPark taxiPark = new TaxiPark();

        Car car1 = new Car("Toyota", 2022, 8.5, 25000.0, 120.0);
        Car car2 = new Car("Honda", 2023, 9.0, 26000.0, 130.0);

        taxiPark.addCar(car1);
        taxiPark.addCar(car2);

        // Test cars in speed range
        double minSpeed = 120.0;
        double maxSpeed = 130.0;
        assertEquals(2, taxiPark.getCarsInSpeedRange(minSpeed, maxSpeed).size());
    }

    @Test
    public void testFindCarsByYear() {
        TaxiPark taxiPark = new TaxiPark();

        Car car1 = new Car("Toyota", 2022, 8.5, 25000.0, 120.0);
        Car car2 = new Car("Honda", 2022, 9.0, 26000.0, 130.0);

        taxiPark.addCar(car1);
        taxiPark.addCar(car2);

        // Test cars by year
        int year = 2022;
        assertEquals(2, taxiPark.findCarsByYear(year).size());
    }

    @Test
    public void testFindCarsByYearRange() {
        TaxiPark taxiPark = new TaxiPark();

        Car car1 = new Car("Toyota", 2022, 8.5, 25000.0, 120.0);
        Car car2 = new Car("Honda", 2023, 9.0, 26000.0, 130.0);

        taxiPark.addCar(car1);
        taxiPark.addCar(car2);

        // Test cars in year range
        int minYear = 2022;
        int maxYear = 2023;
        assertEquals(2, taxiPark.findCarsByYearRange(minYear, maxYear).size());
    }

    @Test
    public void testSortCarsByFuelConsumption() {
        TaxiPark taxiPark = new TaxiPark();

        Car car1 = new Car("Toyota", 2022, 9.0, 25000.0, 120.0);
        Car car2 = new Car("Honda", 2023, 8.5, 26000.0, 130.0);

        taxiPark.addCar(car1);
        taxiPark.addCar(car2);

        taxiPark.sortCarsByFuelConsumption();

        // Check if the cars are sorted by fuel consumption in ascending order
        double firstCarFuelConsumption = taxiPark.getCars().get(0).getFuelConsumption();
        double secondCarFuelConsumption = taxiPark.getCars().get(1).getFuelConsumption();
        assertTrue(firstCarFuelConsumption <= secondCarFuelConsumption);
    }
}