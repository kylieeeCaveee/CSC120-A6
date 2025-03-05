public class Engine implements EngineRequirements{

    private FuelType f; 
    private double CurrentFuelLevel; 
    private double MaxFuelLevel; 

    /**
     * Constructor for Engine
     * @param f Engine's fuel type
     * @param CurrentFuelLevel Engine's current fuel level
     * @param MaxFuelLevel Engine's max fuel level
     */
    public Engine(FuelType f, double CurrentFuelLevel, double MaxFuelLevel )
    {
        this.f= f; 
        this.CurrentFuelLevel= CurrentFuelLevel; 
        this.MaxFuelLevel= MaxFuelLevel; 
    }

    
    /**
     * toString method for Engine that formats the print function for method.
     * @return a formatted string that prints out the engines attributes
     */
    public String toString()
    {
        return "Engine has fuel type: "+ this.f+ " current fuel level: "+ this.CurrentFuelLevel+ " and max fuel level: "+ this.MaxFuelLevel; 
    }

    /**
     * acessor method for fuel type
     * @return the fuel type for the engine
     */
    public FuelType getFuelType()
    {
        return this.f; 
    }

    /**
     * acessor for the max fuel 
     * @return the double of max fuel for the engine
     */
    public double getMaxFuel()
    {
        return CurrentFuelLevel= this.MaxFuelLevel; 
    }

    /**
     * acessor methof for the current fuel
     * @return the double of current fuel for the engine
     */
    public double getCurrentFuel()
    {
        return this.CurrentFuelLevel; 
    }
    /**
     * this method sets the engine's current fuel to the max fuel level
     */
    public void refuel()
    {
        this.CurrentFuelLevel= this.MaxFuelLevel; 
    }

    /**
     * The go method decreases the current fuel level by 5, prints how much fuel is left, and returns if the fuel level is above zero.
     * @return T/F is fuel level above zero
     */
    public Boolean go()
    {
        if (CurrentFuelLevel>0)
        {
            this.CurrentFuelLevel= this.CurrentFuelLevel-5; 
        System.out.println("Current Fuel Level: "+ this.CurrentFuelLevel);
        } 
        else {
            System.out.println("Fuel level is too low to run.");
         } 
        return CurrentFuelLevel>0;

    }

    public static void main(String[] args)
    {
        Engine myEngine= new Engine(FuelType.ELECTRIC, 0.0, 100.0); 
        System.out.println(myEngine); 
        System.out.println(myEngine.getCurrentFuel()); 
        System.out.println(myEngine.getFuelType());
        System.out.println(myEngine.getMaxFuel());
        Engine myOtherEngine= new Engine(FuelType.STEAM, 50.0, 100.0); 
        System.out.println(myOtherEngine); 
        myOtherEngine.refuel(); 
        Engine trialEngine = new Engine(FuelType.ELECTRIC, 100.0, 100.0);
        while (trialEngine.go()) 
        {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        System.out.println(trialEngine.go());
    }
}