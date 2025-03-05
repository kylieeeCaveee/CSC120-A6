import java.util.ArrayList; 
public class Car implements CarRequirements
{
//make sure you check that there are seats remaining and that the passenger is not already on that car
//check to make sure that a passenger is on that car before removing them 
//add passenger and remove passenger should be public 
private int capacity; 
private ArrayList <Passenger> passengerlist; 
/**
 *  Constructor for Car
 * @param capacity the max number of passengers the car can hold
 */
public Car( int capacity)
{
    this.capacity=capacity; 
    passengerlist= new ArrayList<Passenger>(); 
    passengerlist.ensureCapacity(capacity);
    //not sure this is the right way to do max capacity 
}
/**
 * Acessor method for Capacity attribute
 * @return int of car capcity
 */
public int getCapacity()
{
    return this.capacity; 
}

/**
 * This function counts how many seats are left avalible in the car 
 * @return int number of seats left
 */
public int seatsRemaining()
{
    int seatsRemaining= capacity- passengerlist.size(); 
    return seatsRemaining; 
}

/**
 * This function adds a passenger to the car if there is space and returns true. Otherwise, it returns false.
 * @param P the passenger to be added to the car
 */
public Boolean addPassenger (Passenger P)
{
    if (capacity-passengerlist.size()>0)
    {
        this.passengerlist.add(P); 
        return true; 
    }
    else
    {
        return false; 
    }

}

/**
 * This function checks to see if a passenger is in the car, and if they are removes them, and returns true. Otherwise, it returns false.
 * @param P the passenger to be removed
 */
public Boolean removePassenger(Passenger P)
{
    if (this.passengerlist.contains(P)==true)
    {
        this.passengerlist.remove(P); 
        return true; 
    }
    else
    {
        return false; 
    }
}

/**
 * This prints out each passenger that is in the current car.
 */
public void printManifest()
{
    if(this.passengerlist.size()>0){
        for( int current_idx= 0; current_idx<this.passengerlist.size(); current_idx++)
        {
            System.out.println(this.passengerlist.get(current_idx)); 
        }
    }else {
        System.out.println("This car is Empty");
    }
    
}

public String toString()
{
    return "Car with Capacity: "+ capacity; 
}

public static void main(String[] args) 
{
    Car testingCar= new Car(1); 
    System.out.println(testingCar.getCapacity());
    System.out.println(testingCar.seatsRemaining()); 
    Passenger Kylie= new Passenger("Kylie");
    testingCar.addPassenger(Kylie); 
    System.out.println(testingCar.getCapacity());
    System.out.println(testingCar.seatsRemaining()); 
    Passenger Katie= new Passenger("Katie");
    System.out.println(testingCar.addPassenger(Katie)); 
    System.out.println(testingCar.passengerlist);
    testingCar.printManifest(); 
    System.out.println(testingCar.removePassenger(Kylie)); 
    testingCar.printManifest();
    System.out.println(testingCar.removePassenger(Katie));
}
}