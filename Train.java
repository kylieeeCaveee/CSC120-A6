import java.util.ArrayList; 
public class Train implements TrainRequirements
{
    private ArrayList<Car> carList; 
    private Engine engine; 

    /**
     * This is the constructor for the Train Class.
     * @param f the fuel type attribute for engine
     * @param fuelCapacity how much fuel the train can hold for engine
     * @param nCars how many cars the train has 
     * @param passengerCapacity how many people the train can fit. 
     */
    public Train(FuelType f, double fuelCapacity, int nCars, int passengerCapacity){
       
        this.engine= new Engine(f, fuelCapacity,fuelCapacity); 
        this.carList= new ArrayList<>(nCars); 
        for (int counter= 0; counter<nCars; counter++){
            carList.add(new Car(passengerCapacity)); 
        }
    }

    
    /**
     * A method that returns the carList for this train.
     * @return the list of cars in this train formatted as an array list.
     */
    public ArrayList<Car> getCarList(){
        return this.carList; 
    }



    /** 
     * This method is an accessor for Engine.
     * @return Engine that is this cars engine.
    */
    public Engine getEngine(){
        return this.engine; 
    }

    /**this is an acessor method for a specific car
    * @param i int that is the car you want to acess
    * @return Car that is the car at the idx in the array list of the int given.
    */
    public Car getCar(int i){
        return carList.get(i);  
    }
    /**
     * This function returns the MaxCapacity for the total train. 
     * @return int which is the MaxCapacity for the total train.
     */
    public int getMaxCapacity(){
        int maxCapacity=0; 
        for (int i=0; i<carList.size(); i++){
            maxCapacity+= carList.get(i).getCapacity(); 
        }
        return maxCapacity; 
    }
    /**
     * This funciton calculates how many seats there are remaining on the entire train.
     * @return int the total seats that are remaining on the entire train.
     */
    public int seatsRemaining(){
        int totalSeatsRemaining= 0;
        for (int counter= 0; counter<carList.size(); counter++){
            totalSeatsRemaining+=carList.get(counter).seatsRemaining(); 
        }
        return totalSeatsRemaining; 
    }

    /**
     * This function prints the manifest of all the passengers on the entire train. 
     */
    public void printManifest(){ 
        System.out.println("Passenger Manifest: ");
        Boolean emptyTrain= true; 
        for (int counter=0; counter<this.carList.size(); counter++){
            if(this.getCar(counter).seatsRemaining()!=this.getCar(counter).getCapacity()){
                emptyTrain=false;  
            }
        }
        if (emptyTrain== true){
            System.out.println("This train is empty!");
        }else{
            for (int counter= 0; counter<carList.size(); counter++){
            carList.get(counter).printManifest();
            }
        }
    }

    public static void main(String[] args) {
        Train testing_train= new Train( FuelType.ELECTRIC, 100.0, 3, 5); 
        System.out.println(testing_train.carList);
        testing_train.printManifest();
        Passenger kylie= new Passenger("Kylie"); 
        Passenger katie= new Passenger("Katie"); 
        Passenger alice= new Passenger("ALice"); 
        Passenger syd= new Passenger("Syd"); 
        Passenger sarah= new Passenger("Sarah"); 
        System.out.println(testing_train.getEngine());
        System.out.println(testing_train.getMaxCapacity()); 

        testing_train.getCar(0).addPassenger(kylie); 
        testing_train.getCar(0).addPassenger(katie); 
        testing_train.getCar(1).addPassenger(alice); 
        testing_train.getCar(1).addPassenger(syd); 
        testing_train.getCar(2).addPassenger(sarah); 

        System.out.println(testing_train.seatsRemaining()); 
        testing_train.printManifest(); 
    }
}
