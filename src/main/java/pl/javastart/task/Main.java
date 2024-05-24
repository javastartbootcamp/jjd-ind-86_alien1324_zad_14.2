package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        File file = new File("Vehicles.txt");
        if (file.exists()) {
            try (Scanner fileScan = new Scanner(file)) {
                while (fileScan.hasNextLine()) {
                    fileScan.useDelimiter(";");
                    String type = fileScan.next();
                    String brand = fileScan.next();
                    String vin = fileScan.next();
                    int year = fileScan.nextInt();
                    int mileage = fileScan.nextInt();
                    fileScan.nextLine();
                    Vehicle newVehicle = new Vehicle(type, brand, vin, year, mileage);
                    vehicleQueue.offer(newVehicle);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            file.delete();
        }
        while (true) {
            System.out.println("Wpisz 1 by dodać pojazd do kolejki, " +
                    "2 by przeprowadzić przegląd pojazdu lub 0 by zakończyć program");
            operation = sc.nextInt();
            if (operation == 0) {
                if (!vehicleQueue.isEmpty()) {
                    try (FileWriter writer = new FileWriter(file);
                         BufferedWriter bufWriter = new BufferedWriter(writer)) {
                        file.createNewFile();
                        for (Vehicle vehicle : vehicleQueue) {
                            bufWriter.write(vehicle.getInfo());
                            bufWriter.newLine();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
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
