Use this file to record your reflection on this assignment.

Detailed Description of tests:
testEngineConstructor- This creates a test engine and uses assert Equals to ensure that the fuel value is the same number that was entered into the constructor.

testEngineGo- This has an exepcted value of five less than the intialized fuel value to match how much the go method subtracts. It runs the go method and then gets the fuel value for the train. It uses assertEquals to ensure they are the same.

testCarAddPassenger- This creates a car and a passenger and uses assertEquals to ensure that the seats remaining on the test car decrease by one after the passenger is added to the car.

testCarRemovePassenger- This creates a car and two passengers. It uses assert equals to ensure that after the passenger Kylie is added and removed the capacity goes back to the original capacity. It then uses assertFalse to ensure that the passenger can't be removed from a car they are not on.

testPassengerBoardCarWithSpace- This ensures w/ assert equals that using the passenger's board car message will decrease the seats remaining on the car, meaning the passenger boarded the car. 

testPassengerBoardCarFull- this tests that a runtime exception is thrownwhen a car is full and another additional passenger, in this case Katie tries to board the car.

testTrainConstrucot- This tests that the highest value car (in this case car 9) is created and accessible using getCar. It also tests that a IndexOutOfBoundsException is thrown when attempting to acess one higher than the number of cars (in this case 10) ensuring that exactly 10 cars were created.

testTrainPassengerCount- This creates a testing train and two different passengers. It tests using assert equals that the seatsRemaining decrease as each of the passengers board the train and that it increases as each of the passengers leave the train.

testTrainGetCar- I made the carList of the train accessible and then tested that the accessormethod getting the first train was equal to the first train using assertSame. 

testTrainPrintManifest- This assures that no errors are thrown when printing the manifest of a passenger on the first car and a passenger on the last car. 

What are your initial impressions of how `Unit Testing` affects your programming?
I really like Unit testing. It is a simple way to test your code that is incrimental and feels simple and organized. The assert methods are helpful and I really like the feedback given when a method fails. It is helpful for debugging.

What worked, what didn't, what advice would you give someone taking this course in the future?

I think everything went pretty smoothly! The only thing I changed was that I changed my boardCar method to throw an error instead of jsut printing a message which made it easier to debug. The advice I would give to a person taking this course in the future is to pay attention to In-Class examples they are a helpful tool to lean on whne getting started on homeworks. 
