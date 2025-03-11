import java.util.ArrayList; 
public class Train implements TrainRequirements
{
    ArrayList<Car> carList; 
    private Engine engine; 

    /**
     * This is the constructor for the Train Class.
     * @param f the fuel type attribute for engine
     * @param fuelCapacity how much fuel the train can hold for engine
     * @param nCars how many cars the train has 
     * @param passengerCapacity how many people the train can fit. 
     */
    public Train(FuelType f, double fuelCapacity, int nCars, int passengerCapacity)
    {
       
        this.engine= new Engine(f, fuelCapacity,fuelCapacity); 
        this.carList= new ArrayList<>(nCars); 
        for (int counter= 0; counter<nCars; counter++)
        {
            carList.add(new Car(passengerCapacity)); 
        }

    }



    /** 
     * This method is an accessor for Engine.
     * @return Engine that is this cars engine.
    */
    public Engine getEngine()
    {
        return this.engine; 
    }

    /**this is an acessor method for a specific car
    * @return Car that is the car at the idx in the array list of the int given.
    */
    public Car getCar(int i)
    {
        return carList.get(i); 
        
    }
    /**
     * This function returns the MaxCapacity for the total train. 
     * @return int which is the MaxCapacity for the total train.
     */
    public int getMaxCapacity()
    {
        int MaxCapacity=0; 
        for (int i=0; i<carList.size(); i++)
        {
            MaxCapacity+= carList.get(i).getCapacity(); 
        }
        return MaxCapacity; 
    }
    /**
     * This funciton calculates how many seats there are remaining on the entire train.
     * @return int the total seats that are remaining on the entire train.
     */
    public int seatsRemaining()
    {
        int total_seats_remaining= 0;
        for (int counter= 0; counter<carList.size(); counter++)
        {
            total_seats_remaining+=carList.get(counter).seatsRemaining(); 
        }
        return total_seats_remaining; 
    }

    /**
     * This function prints the manifest of all the passengers on the entire train. 
     */
    public void printManifest(){
       
        System.out.println("Passenger Manifest: ");
        Boolean empty_train= true; 
        for (int counter=0; counter<this.carList.size(); counter++)
        {
            if(this.getCar(counter).seatsRemaining()!=this.getCar(counter).getCapacity())
            {
                empty_train=false;  
            }

        }
        if (empty_train== true)
        {
            System.out.println("This train is empty!");
        }
        else
        {
            for (int counter= 0; counter<carList.size(); counter++)
        {
           carList.get(counter).printManifest();
        }
        }
    }

    public static void main(String[] args) 
    {
        Train testing_train= new Train( FuelType.ELECTRIC, 100.0, 3, 5); 
        System.out.println(testing_train.carList);
        testing_train.printManifest();
        Passenger Kylie= new Passenger("Kylie"); 
        Passenger Katie= new Passenger("Katie"); 
        Passenger Alice= new Passenger("ALice"); 
        Passenger Syd= new Passenger("Syd"); 
        Passenger Sarah= new Passenger("Sarah"); 
        System.out.println(testing_train.getEngine());
        System.out.println(testing_train.getMaxCapacity()); 

        testing_train.getCar(0).addPassenger(Kylie); 
        testing_train.getCar(0).addPassenger(Katie); 
        testing_train.getCar(1).addPassenger(Alice); 
        testing_train.getCar(1).addPassenger(Syd); 
        testing_train.getCar(2).addPassenger(Sarah); 

        System.out.println(testing_train.seatsRemaining()); 
        testing_train.printManifest(); 
    }


}
