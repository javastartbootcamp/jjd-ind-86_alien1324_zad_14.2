package pl.javastart.task;

public class Vehicle {
    String type;
    String brand;
    String vin;
    int year;
    int mileage;

    public Vehicle(String type, String brand, String vin, int year, int mileage) {
        this.type = type;
        this.brand = brand;
        this.vin = vin;
        this.year = year;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Pojazd{" +
                "typ - " + type +
                ", marka - " + brand +
                ", rocznik - " + year +
                ", przebieg - " + mileage +
                ", numer vin - " + vin +
                '}';
    }

    public String getInfo() {
        return type + ";" + brand + ";" + vin + ";" + year + ";" + mileage + ";";
    }
}
