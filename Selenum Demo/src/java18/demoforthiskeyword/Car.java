package java18.demoforthiskeyword;

//Use of this: this can be used to refer current class instance variable)

public class Car {

	// Instance variables to store the properties of the car
	int noOfWheel;
	String color;
	float maxSpeed;
	float currentFuelInLiters;
	int noOfSeats;

	public void addFuel(float fuel) {
		currentFuelInLiters += fuel;
	}

	public Car start() {
		if (currentFuelInLiters == 0) {
			System.out.println("Car is out of fuel, can't start...");
		} else if (currentFuelInLiters < 5) {
			System.out.println("Car is in reserved mode, please refuel...");
		} else {
			currentFuelInLiters--;
			System.out.println("Car started...bruh...");
		}
		return this; // Return the current instance of the Car
	}

	public void drive() {
		currentFuelInLiters--;
		System.out.println("Car is driving...");
	}

	public static void main(String[] args) {
		Car swift = new Car(); // Create a new Car object named swift
		swift.addFuel(10); // Add 10 liters of fuel to swift

		Car myCar = swift.start(); // Start the car and assign it to myCar
		myCar.drive(); // Drive myCar
	}
}
