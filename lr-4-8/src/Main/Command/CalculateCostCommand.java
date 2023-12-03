package Main.Command;

import Main.Car.TaxiPark;

// Клас команди для підрахунку вартості автопарку
public class CalculateCostCommand implements Command {
    private TaxiPark taxiPark;

    public CalculateCostCommand(TaxiPark taxiPark) {
        this.taxiPark = taxiPark;
    }
    @Override
    public void execute() {
        double cost = taxiPark.calculateCost(); // для обчислення вартості
        System.out.println("Вартість автопарку: " + cost);
    }
    public String getDescription() {
        return "Підрахувати вартість автопарку";
    }
}

