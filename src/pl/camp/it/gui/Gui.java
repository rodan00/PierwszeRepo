package pl.camp.it.gui;

import pl.camp.it.db.CarRepository;
import pl.camp.it.model.Bus;
import pl.camp.it.model.Car;
import pl.camp.it.model.Truck;
import pl.camp.it.model.Vehicle;

import java.util.Scanner;

public class Gui {
    public static void showMainMenu() {
        System.out.println("1. Wyświetl dostępne pojazdy");
        System.out.println("2. Wyświetl dostępne samochody");
        System.out.println("3. Wyświetl dostępne busy");
        System.out.println("4. Wyświetl dostępne ciężarówki");
        System.out.println("5. Wypożycz pojazd");
        System.out.println("6. Wyjdź");

        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                showAllVehicles();
                showMainMenu();
                break;
            case "2":
                showAllCars();
                showMainMenu();
                break;
            case "3":
                showAllBuses();
                showMainMenu();
                break;
            case "4":
                showAllTrucks();
                showMainMenu();
                break;
            case "5":
                showRentScreen();
                showMainMenu();
                break;
            case "6":
                System.exit(0);
                break;
                default:
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Zła wartość !!");
                    showMainMenu();
                    break;
        }
    }

    private static void showAllVehicles() {
        Vehicle[] availableVehicles = CarRepository.getBaza().getAvailableVehicles();
        for (Vehicle availableVehicle : availableVehicles) {
            if(availableVehicle != null) {
                System.out.println(availableVehicle);
            }
        }
    }

    private static void showAllCars() {
        Car[] availableCars = CarRepository.getBaza().getAvailableCars();
        for (Car availableCar : availableCars) {
            if(availableCar != null) {
                System.out.println(availableCar);
            }
        }
    }

    private static void showAllBuses() {
        Bus[] availableBuses = CarRepository.getBaza().getAvailableBuses();
        for (Bus availableBus : availableBuses) {
            if(availableBus != null) {
                System.out.println(availableBus);
            }
        }
    }

    private static void showAllTrucks() {
        Truck[] availableTrucks = CarRepository.getBaza().getAvailableTrucks();
        for (Truck availableTruck : availableTrucks) {
            if(availableTruck != null) {
                System.out.println(availableTruck);
            }
        }
    }

    private static void showRentScreen() {
        System.out.println("Wpisz VIN:");

        Scanner scanner = new Scanner(System.in);
        String vin = scanner.nextLine();

        CarRepository.getBaza().rentVehicle(vin);
    }
}
