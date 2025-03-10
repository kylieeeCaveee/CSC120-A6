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
        fail();
    }

    // Passenger Tests
    @Test
    public void testPassengerBoardCarWithSpace() {
        fail();
    }

    @Test
    public void testPassengerBoardCarFull() {
        fail();
    }

    // Train Tests
    @Test
    public void testTrainConstructor() {
        fail();
    }

    @Test
    public void testTrainPassengerCount() {
        fail();
    }

    @Test
    public void testTrainGetCar() {
        fail();
    }

    @Test
    public void testTrainPrintManifest() {
        fail();
    }
    
}
