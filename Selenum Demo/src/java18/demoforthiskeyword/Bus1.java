package java18.demoforthiskeyword;

//Use of this: this can be used to invoke current class method (implicitly)

public class Bus1 {

	// Instance variables to store the properties of the Bus
	int noOfWheel;
	String color;
	float maxSpeed;
	float currentFuelInLiters;
	int noOfSeats;

	public void addFuel(float currentFuelInLiters) {
		this.currentFuelInLiters += currentFuelInLiters;
	}

	public Bus1 start() {
		if (currentFuelInLiters == 0) {
			System.out.println("Bus is out of fuel, can't start...");
		} else if (currentFuelInLiters < 5) {
			System.out.println("Bus is in reserved mode, please refuel...");
		} else {
			currentFuelInLiters--;
			System.out.println("Bus started...bruh...");
		}
		return this; // Return the current instance of the Bus
	}

	public void drive() {
		currentFuelInLiters--;
		System.out.println("Bus is driving...");
	}

	public void printDetails() {
		System.out.println("Bus Details: ");
		System.out.println("Number of Wheels: " + noOfWheel);
		System.out.println("Color: " + color);
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Current Fuel: " + currentFuelInLiters);
		System.out.println("Number of Seats: " + noOfSeats);
	}

	public static void main(String[] args) {
		Bus1 volvo = new Bus1(); // Create a new Bus object named swift
		volvo.noOfWheel = 6;
		volvo.color = "Red";
		volvo.maxSpeed = 120;
		volvo.noOfSeats = 40;
		volvo.addFuel(10);
		volvo.addFuel(10); // Add 10 liters of fuel to swift

		Bus1 myBus = volvo.start(); // Start the Bus and assign it to myBus
		myBus.drive(); // Drive myBus
		
		// Create a new Mechanic object
        Mechanic mechanic = new Mechanic();
        mechanic.inspectBus(volvo); // Pass the current bus instance to the mechanic for inspection
	}
	

}

