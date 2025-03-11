import static org.junit.Assert.*;
import org.junit.Test;

public class TrainTest {

    // Engine Tests
    @Test
    public void testEngineConstructor() {
        Engine testingEngine= new Engine(FuelType.STEAM, 100.0, 200.0); 
        assertEquals(FuelType.STEAM, testingEngine.getFuelType()); 
        double expectedFuel= 100.0; 
        double actualFuel= testingEngine.getCurrentFuel(); 
        assertEquals(expectedFuel, actualFuel,0); 
    }

    @Test
    public void testEngineGo() {
        Engine testingEngine= new Engine(FuelType.STEAM, 100.0, 200.0);
        double expectedValue= 95.0; 
        testingEngine.go(); 
        double actualValue= testingEngine.getCurrentFuel(); 
        assertEquals(expectedValue, actualValue, 0.0);
    }

    // Car Tests
    @Test
    public void testCarAddPassenger() {
        Car testCar= new Car(1); 
        Passenger Kylie = new Passenger("Kylie"); 
        int expectedValue= 0; 
        testCar.addPassenger(Kylie); 
        int actualValue= testCar.seatsRemaining(); 
        assertEquals(expectedValue, actualValue); 
 
    }

    @Test
    public void testCarRemovePassenger() {
        Car testCar= new Car(1); 
        Passenger Kylie = new Passenger("Kylie");
        Passenger Caden= new Passenger("Caden"); 
        testCar.addPassenger(Kylie); 
        int expectedValue= 1; 
        testCar.removePassenger(Kylie); 
        int actualValue= testCar.seatsRemaining(); 
        assertEquals(expectedValue, actualValue); 
        assertFalse(testCar.removePassenger(Caden)); 
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        Car testCar= new Car(1); 
        Passenger Kylie = new Passenger("Kylie");
        int expectedValue= 0; 
        Kylie.boardCar(testCar);
        int actualValue= testCar.seatsRemaining(); 
        assertEquals(expectedValue, actualValue); 

    }

    @Test(expected= RuntimeException.class)
    public void testPassengerBoardCarFull() {
        Car testCar= new Car(1); 
        Passenger Kylie = new Passenger("Kylie");
        Kylie.boardCar(testCar);
        Passenger Katie = new Passenger("Katie");
        Katie.boardCar(testCar);
    }

    // Train Tests
    @Test(expected= IndexOutOfBoundsException.class)
    public void testTrainConstructor() {
        Train testingTrain= new Train(FuelType.ELECTRIC, 100.0, 10, 10);
        String expectedString= "Car with Capacity: 10"; 
        String actualString= testingTrain.getCar(9).toString(); 
        assertEquals(expectedString, actualString); 
        testingTrain.getCar(10); 
    }

    @Test
    public void testTrainPassengerCount() {
        Train testingTrain= new Train(FuelType.ELECTRIC, 100.0, 10, 10);
        Passenger Kylie = new Passenger("Kylie");
        Passenger Caden = new Passenger("Caden"); 
        Kylie.boardCar(testingTrain.getCar(1));
        int firstEValue= 99; 
        int firstAValue= testingTrain.seatsRemaining(); 
        assertEquals(firstEValue, firstAValue); 
        Caden.boardCar(testingTrain.getCar(1));
        int SecondEValue= 98; 
        int SecondAValue= testingTrain.seatsRemaining(); 
        assertEquals(SecondEValue, SecondAValue); 
        Caden.getOffCar(testingTrain.getCar(1));
        int thirdEValue= 99; 
        int thirdAValue= testingTrain.seatsRemaining(); 
        assertEquals(thirdEValue, thirdAValue); 
        Kylie.getOffCar(testingTrain.getCar(1));
        int fourthEValue= 100; 
        int fourthAValue= testingTrain.seatsRemaining(); 
        assertEquals(fourthEValue, fourthAValue); 
    }

    @Test
    public void testTrainGetCar() {
        Train testingTrain= new Train(FuelType.ELECTRIC, 100.0, 10, 10);
        Car expectedCar= testingTrain.carList.get(1); 
        Car actualCar= testingTrain.getCar(1); 
        assertSame(expectedCar, actualCar);
    }

    @Test
    public void testTrainPrintManifest() {
        Train testingTrain= new Train(FuelType.ELECTRIC, 100.0, 10, 10);
        Passenger Kylie = new Passenger("Kylie");
        Passenger Caden = new Passenger("Caden"); 
        Kylie.boardCar(testingTrain.getCar(1));
        Caden.boardCar(testingTrain.getCar(9));
        testingTrain.printManifest();

    }
    
}
