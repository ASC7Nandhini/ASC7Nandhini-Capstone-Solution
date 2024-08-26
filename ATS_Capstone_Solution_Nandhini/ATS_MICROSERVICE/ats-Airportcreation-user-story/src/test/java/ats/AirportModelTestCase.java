package ats;

import ats.model.AirportModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AirportModelTestCase {
    AirportModel airportModel = new AirportModel("A0001", "TN International Airport", "TN");

    @Test
    public void testAirportIdField() {
        String actualAirportId = airportModel.getAirportId();
        Assertions.assertEquals("A0001", actualAirportId);
    }

    @Test
    public void testAirportNameField() {
        String actualAirportName = airportModel.getAirportName();
        Assertions.assertEquals("TN International Airport", actualAirportName);
    }

    @Test
    public void testCountryCodeField() {
        String actualCountryCode = airportModel.getCountryCode();
        Assertions.assertEquals("TN", actualCountryCode);
    }
}

