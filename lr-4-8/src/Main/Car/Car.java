package Main.Car;

public class Car {
    private String make;
    private int year;
    private double fuelConsumption;
    private double price;
    private double speed;

    public Car(String make, int year, double fuelConsumption, double price, double speed) {
        this.make = make;
        this.year = year;
        this.fuelConsumption = fuelConsumption;
        this.price = price;
        this.speed = speed;
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSpeed() {

        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


}
