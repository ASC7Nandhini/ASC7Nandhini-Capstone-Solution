package ats.entity;

import javax.persistence.*;

@Entity
@Table(name = "Airport")
public class AirportEntity {
    @Id
    @Column(name = "airport_id", updatable = false, nullable = false)
    private String airportId;

    @Column(name = "airport_name", nullable = false)
    private String airportName;

    @Column(name = "country_code", nullable = false, length = 5)
    private String countryCode;

    public AirportEntity() {
    }

    public AirportEntity(String airportId, String airportName, String countryCode) {
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
