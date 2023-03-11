package edu.umb.cs680.hw03;

public class Car {
    private String make;
    private String model;
    private int mileage;
    private int year;
    private float price;

    public Car(String makeOfTheCar, String modelOfTheCar, int mileageOfCar, int yearOfCar, float priceOfCar) {
        this.make = makeOfTheCar;
        this.model = modelOfTheCar;
        this.mileage = mileageOfCar;
        this.year = yearOfCar;
        this.price = priceOfCar;
    }

    public String getMake() {
        return make;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }

    public static void main(String[] args) {
        Car car1 = new Car("asdasdasd", "asdasdasdva", 454545, 6676, 40f);
    }
}