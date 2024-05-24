package pl.javastart.task;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class VehicleQueue extends LinkedList<Vehicle> {
    public void makeFile(String fileName) {
        if (isEmpty()) {
            return;
        }
        File file = new File(fileName);
        try (FileWriter writer = new FileWriter(file);
             BufferedWriter bufWriter = new BufferedWriter(writer)) {
            file.createNewFile();
            for (Vehicle vehicle : this) {
                bufWriter.write(vehicle.getInfo());
                bufWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void getFromFile(String fileName) {
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
                    offer(newVehicle);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            file.delete();
        }
    }
}
