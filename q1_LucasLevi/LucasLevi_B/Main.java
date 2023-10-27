package q1_LucasLevi.LucasLevi_B;

import java.util.ArrayList;
import java.util.List;

class Company {
    private String name;
    private List<Employee> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void hires(Employee employee) {
        employees.add(employee);
        System.out.println("Funcionário contratado: " + employee.getName());
    }

    public void listEmployees() {
        System.out.println("Funcionários da empresa " + name + ":");
        for (Employee employee : employees) {
            System.out.println(employee.getName());
        }
    }
}

class Frame {
    private String type;

    public Frame(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Employee {
    private String name;
    private Vehicle vehicle;

    public Employee(String name) {
        this.name = name;
    }

    public void drives(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.out.println(name + " está dirigindo um(a) " + vehicle.getName());
    }

    public String getName() {
        return name;
    }

    public Vehicle getVehicle() {
        return vehicle;
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

    public String getTransmission() {
        return transmission;
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
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company("ABC Company");

        Frame frame = new Frame("Frame");
        Employee employee1 = new Employee("John Doe");
        Employee employee2 = new Employee("Jane Smith");

        Vehicle vehicle1 = new Vehicle("Vehicle", "12345");
        Truck truck = new Truck("Truck", "67890", 2000, "Manual");
        Car car = new Car("Car", "54321", "Automatic");

        company.hires(employee1);
        employee1.drives(vehicle1);
        employee1.drives(truck);

        company.hires(employee2);
        employee2.drives(car);

        company.listEmployees();
    }
}