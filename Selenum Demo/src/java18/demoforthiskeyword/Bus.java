package java18.demoforthiskeyword;

//Use of this: this can be used to invoke current class method (implicitly)

public class Bus {

	// Instance variables to store the properties of the Bus
	int noOfWheel;
	String color;
	float maxSpeed;
	float currentFuelInLiters;
	int noOfSeats;

	public void addFuel(float currentFuelInLiters) {
		this.currentFuelInLiters += currentFuelInLiters;
	}

	public Bus start() {
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

	public static void main(String[] args) {
		Bus volvo = new Bus(); // Create a new Bus object named swift
		volvo.addFuel(10); // Add 10 liters of fuel to swift

		Bus myBus = volvo.start(); // Start the Bus and assign it to myBus
		myBus.drive(); // Drive myBus
	}

}
