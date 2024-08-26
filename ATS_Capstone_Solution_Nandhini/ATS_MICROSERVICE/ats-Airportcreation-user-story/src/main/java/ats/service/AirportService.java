package ats.service;

import ats.model.AirportModel;

import java.util.List;

public interface AirportService {
    List<AirportModel> getAllAirports();
    String generateId();
}
