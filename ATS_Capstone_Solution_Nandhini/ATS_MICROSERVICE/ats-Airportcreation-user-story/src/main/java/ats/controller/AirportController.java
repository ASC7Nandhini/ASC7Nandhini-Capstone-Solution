package ats.controller;

import ats.entity.AirportEntity;
import ats.exception.AirportNotFoundException;
import ats.model.AirportModel;
import ats.repository.AirportRepository;
import ats.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AirportController {

    private final AirportRepository airportRepository;
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportRepository airportRepository, AirportService airportService) {
        this.airportRepository = airportRepository;
        this.airportService = airportService;
    }

    @GetMapping("/Airports")
    public List<AirportModel> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/Airports/{id}")
    public AirportModel getAirportById(@PathVariable("id") String airportId) {
        try{
            AirportEntity airportDetails = airportRepository.findById(airportId).get();
            return new AirportModel(airportDetails.getAirportId(),airportDetails.getAirportName(),airportDetails.getCountryCode());
        }
        catch (AirportNotFoundException airportNotFoundException){
            return null;
        }
    }

    @PostMapping("/Airports")
    public String createAirport(@RequestBody AirportModel airportModelFromClient) {
        validateAirportModel(airportModelFromClient);
        if (airportModelFromClient.getAirportName() == null || airportModelFromClient.getCountryCode() == null || airportModelFromClient.getAirportName().isEmpty() || airportModelFromClient.getCountryCode().isEmpty() || airportModelFromClient.getCountryCode().length() > 5) {
            return "Required fields must be provided";
        }
        String airportId = airportService.generateId();
        AirportEntity airportDetails = new AirportEntity(airportId, airportModelFromClient.getAirportName(), airportModelFromClient.getCountryCode());
        airportRepository.save(airportDetails);
        return "Airport Details inserted successfully";
    }

    @DeleteMapping("/Airports/{id}")
    public String deleteAirport(@PathVariable("id") String airportId) {
        try{
            AirportEntity airportDetailsToBeDeleted = airportRepository.findById(airportId).get();
            airportRepository.delete(airportDetailsToBeDeleted);
            return "Airport Details deleted successfully";
        }
        catch (AirportNotFoundException airportNotFoundException){
            return "Airport Details is not available";
        }
    }

    @PutMapping("/Airports")
    public String updateAirport(@RequestBody AirportModel airportModelFromClient) {
       validateAirportModel(airportModelFromClient);
        try{
            AirportEntity airportDetailsToBeUpdated = airportRepository.findById(airportModelFromClient.getAirportId()).get();
            if(airportModelFromClient.getAirportName()!=null && !airportModelFromClient.getAirportName().isEmpty())airportDetailsToBeUpdated.setAirportName(airportModelFromClient.getAirportName());
            if(airportModelFromClient.getCountryCode()!=null && !airportModelFromClient.getCountryCode().isEmpty())airportDetailsToBeUpdated.setCountryCode(airportModelFromClient.getCountryCode());
            airportRepository.save(airportDetailsToBeUpdated);
            return "Airport Details updated successfully";
        }
        catch (AirportNotFoundException airportNotFoundException){
            return "Airport Details not updated for the provided PlaneId";
        }
    }

    private void validateAirportModel(AirportModel airportModel) {
        if (airportModel.getCountryCode() == null || airportModel.getCountryCode().length() < 2 || airportModel.getCountryCode().length() > 3) {
            throw new IllegalArgumentException("Country code must be 2 to 3 characters long");
        }
    }
}
