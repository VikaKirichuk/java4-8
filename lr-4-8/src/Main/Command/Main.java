package Main.Command;
import Main.Car.TaxiPark;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandInvoker commandInvoker = new CommandInvoker();
        TaxiPark taxiPark = new TaxiPark();
        Scanner scanner = new Scanner(System.in);
        int choice;
        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new AddCarCommand(taxiPark));
        commands.put(2, new CalculateCostCommand(taxiPark));
        commands.put(3, new SortCarsByFuelConsumptionCommand(taxiPark));
        commands.put(4, new FindCarBySpeedRangeCommand(taxiPark));
        commands.put(5, new RemoveCarCommand(taxiPark));
        commands.put(6, new ShowAllCarsCommand(taxiPark));
        commands.put(7, new FindCarByYearCommand(taxiPark));

        do {
            System.out.println("Оберіть операцію:");
            for (var entry : commands.entrySet()) {
                System.out.println(entry.getKey() + ". " + entry.getValue().getDescription());
            }
            System.out.println("0. Вийти");
            choice = scanner.nextInt();

            if (commands.containsKey(choice)) {
                commandInvoker.executeCommand(commands.get(choice));
            } else if (choice == 0) {
                System.out.println("Програма завершена.");
            } else {
                System.out.println("Не правильно введено. Спробуйте ще раз.");
            }
        } while (choice != 0);
    }


}