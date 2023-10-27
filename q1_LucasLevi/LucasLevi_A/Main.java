package q1_LucasLevi.LucasLevi_A;

class Company {
    public void hires(Employee employee) {
        System.out.println("Contratando funcionário...");
    }
}

class Frame {
    private String hires;

    public Frame(String hires) {
        this.hires = hires;
    }

    public String getHires() {
        return hires;
    }

    public void setHires(String hires) {
        this.hires = hires;
    }
}

class Employee {
    private Vehicle vehicle;

    public void drives(Vehicle vehicle) {
        System.out.println("Dirigindo " + vehicle.getName());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

class Vehicle {
    private String name;
    private String registrationNumber;

    public Vehicle(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}

class Truck extends Vehicle {
    private int mass;
    private String transmission;

    public Truck(String name, String registrationNumber, int mass, String transmission) {
        super(name, registrationNumber);
        this.mass = mass;
        this.transmission = transmission;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}

class Car extends Vehicle {
    private String transmission;

    public Car(String name, String registrationNumber, String transmission) {
        super(name, registrationNumber);
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}

public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame("Frame");
        Company company = new Company();
        Employee employee = new Employee();
        Vehicle vehicle = new Vehicle("Vehicle", "12345");
        Truck truck = new Truck("Truck", "67890", 2000, "Manual");
        Car car = new Car("Car", "54321", "Automatic");

        company.hires(employee);
        employee.setVehicle(vehicle);
        employee.drives(employee.getVehicle());
        employee.setVehicle(truck);
        employee.drives(employee.getVehicle());
        employee.setVehicle(car);
        employee.drives(employee.getVehicle());
    }
}