package ats.service;

import ats.entity.AirportEntity;
import ats.model.AirportModel;
import ats.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    private AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public String generateId() {
        String airportId = airportRepository.findTopId();
        if (airportId == null || airportId.isEmpty()) {
            airportId = "A0000";
        }
        String id = "A";
        int number = Integer.parseInt(airportId.substring(1, 5));
        number++;
        String digit = Integer.toString(number);
        switch (4 - digit.length()) {
            case 1:
                id += "0";
                break;
            case 2:
                id += "00";
                break;
            case 3:
                id += "000";
                break;
            default:
                break;
        }
        id += digit;
        return id;
    }

    @Override
    public List<AirportModel> getAllAirports() {
        List<AirportEntity> allAirports = airportRepository.findAll();
        List<AirportModel> airportModelList = new ArrayList<>();
        for (AirportEntity airportEntity : allAirports) {
            AirportModel airportModel = new AirportModel(airportEntity.getAirportId(), airportEntity.getAirportName(), airportEntity.getCountryCode());
            airportModelList.add(airportModel);
        }
        return airportModelList;
    }
}
