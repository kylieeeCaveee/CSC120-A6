public class Passenger implements PassengerRequirements{
    //make sure you don't check add capacity twice the car method already does it
    //should use add passenger and remove passenger methods from car 
    private String name;
    /**
     * This is the constructor for the Passenger class
     * @param name is the name of the passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * This method has the passenger board a car if has space.
     * @param c this is the car that the passenger would be added to if successful. 
     */
    public void boardCar(Car c)
    {
        if (c.addPassenger(this)==true){
            System.out.println("Passenger Boarded");
        }
        else{
            throw new RuntimeException("The selected car is full");
        }
    
    }

    /**
     * This method removes the passenger from the car if they are currently aboard that car.
     * @param c this is the car that the passenger will be removed from. 
     */
    public void getOffCar(Car c)
    {
        if (c.removePassenger(this)==true)
        {
            System.out.println("Passenger removed from car.");
        }
        else
        {
            System.out.println("Passnger not onboard this car.");
        }
    }

    /**
     * This is the toString function that tells the system how to print out passengers.
     * @return String which is the name of the passenger.
     */
    public String toString()
    {
        return this.name; 
    }

    public static void main(String[] args) 
    {
        Car testingCar= new Car(1); 
        Passenger Kylie= new Passenger("Kylie"); 
        Kylie.boardCar(testingCar);
        Passenger Katie= new Passenger("Katie"); 
        try{
            Katie.boardCar(testingCar);
        }
        catch (RuntimeException e){
            System.out.println(e.getLocalizedMessage()); 
        }
        testingCar.printManifest();
        Kylie.getOffCar(testingCar); 
        testingCar.printManifest();
        Katie.getOffCar(testingCar); 
    }
}
