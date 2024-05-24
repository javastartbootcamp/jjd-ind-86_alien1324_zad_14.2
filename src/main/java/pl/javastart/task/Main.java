package pl.javastart.task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operation;
        VehicleQueue vehicleQueue = new VehicleQueue();
        vehicleQueue.getFromFile("Vehicles.txt");
        while (true) {
            System.out.println("Wpisz 1 by dodać pojazd do kolejki, " +
                    "2 by przeprowadzić przegląd pojazdu lub 0 by zakończyć program");
            operation = sc.nextInt();
            if (operation == 0) {
                vehicleQueue.makeFile("Vehicles.txt");
                return;
            } else if (operation == 1) {
                System.out.println("Wpisz typ pojazdu.");
                String type = sc.next();
                System.out.println("Wpisz markę pojazdu.");
                String brand = sc.next();
                System.out.println("Wpisz numer VIN pojazdu.");
                String vin = sc.next();
                System.out.println("Wpisz rocznik pojazdu.");
                int year = sc.nextInt();
                System.out.println("Wpisz przebieg pojazdu.");
                int mileage = sc.nextInt();
                Vehicle nextVehicle = new Vehicle(type, brand, vin, year, mileage);
                vehicleQueue.offer(nextVehicle);
            } else if (operation == 2) {
                if (vehicleQueue.isEmpty()) {
                    System.out.println("W kolejce nie ma żadnego pojazdu.");
                } else {
                    Vehicle checked = vehicleQueue.poll();
                    System.out.println("Pojazd " + checked.toString() + " sprawdzony.");
                }
            } else {
                System.out.println("Błędne wejście.");
            }
        }
    }
}
