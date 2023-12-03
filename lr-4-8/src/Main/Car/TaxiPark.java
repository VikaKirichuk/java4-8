package Main.Car;
import java.util.*;

public  class TaxiPark  {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public double calculateCost() {
        double totalCost = 0;
        for (Car car : cars) {
            totalCost += car.getPrice();
        }
        return totalCost;
    }



    public List<Car> getCarsInSpeedRange(double minSpeed, double maxSpeed) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            double carSpeed = car.getSpeed();
            if (carSpeed >= minSpeed && carSpeed <= maxSpeed) {
                result.add(car);
            }
        }
        return result;
    }


    public List<Car> findCarsByYear(int year) {
        List<Car> matchingCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year) {
                matchingCars.add(car);
            }
        }
        return matchingCars;
    }


    public List<Car> findCarsByYearRange(int minYear, int maxYear) {
        List<Car> matchingCars = new ArrayList<>();
        for (Car car : cars) {
            int carYear = car.getYear();
            if (carYear >= minYear && carYear <= maxYear) {
                matchingCars.add(car);
            }
        }
        return matchingCars;
    }
    // Сортування автомобілів за витратою пального
    public void sortCarsByFuelConsumption() {
        cars.sort((car1, car2) -> {
            double fuelConsumption1 = car1.getFuelConsumption();
            double fuelConsumption2 = car2.getFuelConsumption();
            return Double.compare(fuelConsumption1, fuelConsumption2);
        });
    }

}