package ats.model;

public class AirportModel {
    private String airportId;
    private String airportName;
    private String countryCode;

    public AirportModel() {
    }

    public AirportModel(String airportId, String airportName, String countryCode) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.countryCode = countryCode;
    }

    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
