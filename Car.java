import java.util.ArrayList; 
public class Car implements CarRequirements{
//make sure you check that there are seats remaining and that the passenger is not already on that car
//check to make sure that a passenger is on that car before removing them 
//add passenger and remove passenger should be public 
private int capacity; 
private ArrayList <Passenger> passengerList; 
/**
 *  Constructor for Car
 * @param capacity the max number of passengers the car can hold
 */
public Car( int capacity){
    this.capacity=capacity; 
    passengerList= new ArrayList<Passenger>(); 
    passengerList.ensureCapacity(capacity);
    //not sure this is the right way to do max capacity 
}
/**
 * Acessor method for Capacity attribute
 * @return int of car capcity
 */
public int getCapacity(){
    return this.capacity; 
}

/**
 * This function counts how many seats are left avalible in the car 
 * @return int number of seats left
 */
public int seatsRemaining(){
    int seatsRemaining= capacity- passengerList.size(); 
    return seatsRemaining; 
}

/**
 * This function adds a passenger to the car if there is space and returns true. Otherwise, it returns false.
 * @param p the passenger to be added to the car
 * @return T/F if the passenger has been added to the car or not
 */
public Boolean addPassenger (Passenger p){
    if (capacity-passengerList.size()>0){
        this.passengerList.add(p); 
        return true; 
    }else{
        return false; 
    }

}

/**
 * This function checks to see if a passenger is in the car, and if they are removes them, and returns true. Otherwise, it returns false.
 * @param p the passenger to be removed
 * @return T/F if the passenger has been removed or not
 */
public Boolean removePassenger(Passenger p){
    if (this.passengerList.contains(p)==true){
        this.passengerList.remove(p); 
        return true; 
    }else{
        return false; 
    }
}

/**
 * This prints out each passenger that is in the current car.
 */
public void printManifest(){
    if(this.passengerList.size()>0){
        for( int currentIdx= 0; currentIdx<this.passengerList.size(); currentIdx++){
            System.out.println(this.passengerList.get(currentIdx)); 
        }
    }else{
        System.out.println("This car is Empty");
    }    
}

/**
 * This method creates a nice formatted print strucutre for the car
 * @return String with information about car capacity
 */
public String toString(){
    return "Car with Capacity: "+ capacity; 
}

public static void main(String[] args) {
    Car testingCar= new Car(1); 
    System.out.println(testingCar.getCapacity());
    System.out.println(testingCar.seatsRemaining()); 
    Passenger kylie= new Passenger("Kylie");
    testingCar.addPassenger(kylie); 
    System.out.println(testingCar.getCapacity());
    System.out.println(testingCar.seatsRemaining()); 
    Passenger katie= new Passenger("Katie");
    System.out.println(testingCar.addPassenger(katie)); 
    System.out.println(testingCar.passengerList);
    testingCar.printManifest(); 
    System.out.println(testingCar.removePassenger(kylie)); 
    testingCar.printManifest();
    System.out.println(testingCar.removePassenger(katie));
}
}