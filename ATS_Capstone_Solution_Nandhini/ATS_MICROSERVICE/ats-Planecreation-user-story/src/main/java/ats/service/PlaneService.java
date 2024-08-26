package ats.service;

import ats.model.PlaneModel;

import java.util.List;

public interface PlaneService {
    List<PlaneModel> getAllPlanes();
    String generateId();
}
