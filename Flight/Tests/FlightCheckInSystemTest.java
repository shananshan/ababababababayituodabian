import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class FlightCheckInSystemTest {

    @Test
    public void testCheckIn() {
        FlightCheckInSystem checkInSystem = new FlightCheckInSystem();
        
        try {
            checkInSystem.readFlights("Flight Detail��.csv");
            checkInSystem.readPassengers("Passenger Bookings.csv");

            // Test a successful check-in
            assertTrue(checkInSystem.checkIn("Smith", "ABC123"));

            // Test an unsuccessful check-in
            assertFalse(checkInSystem.checkIn("NonExistent", "XYZ456"));
        } catch (IOException e) {
            fail("IOException occurred while reading test data.");
        }
    }

    @Test
    public void testGetPassenger() {
        FlightCheckInSystem checkInSystem = new FlightCheckInSystem();

        try {
            checkInSystem.readPassengers("Passenger Bookings.csv");

            // Test getting an existing passenger
            Passenger existingPassenger = checkInSystem.getPassenger("Zoe", "3PA-345219");
            assertNotNull(existingPassenger);

            // Test getting a non-existent passenger
            Passenger nonExistentPassenger = checkInSystem.getPassenger("NonExistent", "XYZ456");
            assertNull(nonExistentPassenger);
        } catch (IOException e) {
            fail("IOException occurred while reading test data.");
        }
    }

    @Test
    public void testGetFlight() {
        FlightCheckInSystem checkInSystem = new FlightCheckInSystem();
        
        try {
            checkInSystem.readFlights("Flight Detail.csv");

            // Test getting an existing flight
            Flight existingFlight = checkInSystem.getFlight("PA-345219");
            assertNotNull(existingFlight);

            // Test getting a non-existent flight
            Flight nonExistentFlight = checkInSystem.getFlight("XYZ456");
            assertNull(nonExistentFlight);
        } catch (IOException e) {
            fail("IOException occurred while reading test data.");
        }
    }
}
