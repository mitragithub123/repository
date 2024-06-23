package java18.demoforthiskeyword;

//Use of this: this can be used to return the current class instance from the method
public class Bus2 {

	int noOfWheel;
	String color;
	float maxSpeed;
	float currentFuelInLiters;
	int noOfSeats;

	public Bus2 setNoOfWheels(int noOfWheel) {
		this.noOfWheel = noOfWheel;
		return this; // Return the current instance of Bus2
	}

	public Bus2 setColor(String color) {
		this.color = color;
		return this;
	}

	public Bus2 setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
		return this;
	}

	public Bus2 setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
		return this;
	}

	public Bus2 addFuel(float currentFuelInLiters) {
		this.currentFuelInLiters += currentFuelInLiters;
		return this;
	}

	public Bus2 start() {
		if (currentFuelInLiters == 0) {
			System.out.println("Bus2 is out of fuel, can't start...");
		} else if (currentFuelInLiters < 5) {
			System.out.println("Bus2 is in reserved mode, please refuel...");
		} else {
			currentFuelInLiters--;
			System.out.println("Bus2 started...bruh...");
		}
		return this;
	}

	public Bus2 drive() {
		if (currentFuelInLiters > 0) {
			currentFuelInLiters--;
			System.out.println("Bus2 is driving...");
		} else {
			System.out.println("Bus2 is out of fuel, can't drive...");
		}
		return this;
	}

	public void printDetails() {
		System.out.println("Bus2 Details: ");
		System.out.println("Number of Wheels: " + noOfWheel);
		System.out.println("Color: " + color);
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Current Fuel: " + currentFuelInLiters);
		System.out.println("Number of Seats: " + noOfSeats);
	}

	public static void main(String[] args) {
		// Using method chaining to set properties and perform actions on the Bus2 object
		Bus2 volvo=new Bus2().setNoOfWheels(4)
							.setColor("Red")
							.setMaxSpeed(120)
							.setNoOfSeats(5)
							.addFuel(6)
							.start()
							.drive();
		volvo.printDetails();
	}

}
