package ats.controller;

import ats.entity.PlaneEntity;
import ats.exceptions.PlaneNotFoundException;
import ats.model.PlaneModel;
import ats.repository.PlaneRepository;
import ats.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlaneController {
    private final PlaneRepository planeRepository;
    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneRepository planeRepository,PlaneService planeService){
        this.planeRepository=planeRepository;
        this.planeService=planeService;
    }

    @GetMapping("/Planes")
    public List<PlaneModel> getAllPlanes(){
        return planeService.getAllPlanes();
    }

    @GetMapping("/Planes/{id}")
    public PlaneModel getPlaneById(@PathVariable("id") String planeId) {
        try{
            PlaneEntity planeDetails = planeRepository.findById(planeId).get();
            return new PlaneModel(planeDetails.getRegistrationNumber(),planeDetails.getMaker(),planeDetails.getModel(),planeDetails.getImagePath(),planeDetails.getSeatingCapacity());
        }
        catch (PlaneNotFoundException planeNotFOundException){
            return null;
        }
    }

    @PostMapping("/Planes")
    public String createPlane(@RequestBody PlaneModel planeModelFromClient) {
        if(planeModelFromClient.getModel()==null || planeModelFromClient.getMaker()==null || planeModelFromClient.getImagePath()==null || planeModelFromClient.getSeatingCapacity()<=0 || planeModelFromClient.getModel().isEmpty() || planeModelFromClient.getMaker().isEmpty() || planeModelFromClient.getImagePath().isEmpty()){
            return "Required fields must be provided";
        }
        String planeId=planeService.generateId();
        PlaneEntity planeDetails = new PlaneEntity(planeId,planeModelFromClient.getMaker(),planeModelFromClient.getModel(),planeModelFromClient.getImagePath(),planeModelFromClient.getSeatingCapacity());
        planeRepository.save(planeDetails);
        return "Plane Details inserted successfully";
    }

    @DeleteMapping("/plane/{plId}")
    public String deletePlaneDetails (@PathVariable(value = "plId") String planeId){
        try{
            PlaneEntity planeDetailsToBeDeleted = planeRepository.findById(planeId).get();
            planeRepository.delete(planeDetailsToBeDeleted);
            return "PlaneDetails deleted successfully";
        }
        catch (PlaneNotFoundException planeNotFoundException){
            return "PlaneDetails is not available";
        }
    }

    @PutMapping("/plane")
    public String updatePlaneDetails(@RequestBody PlaneModel planeModelFromClient){
        try{
            PlaneEntity planeDetailsToBeUpdated = planeRepository.findById(planeModelFromClient.getRegistrationNumber()).get();
            if(planeModelFromClient.getModel()!=null && !planeModelFromClient.getModel().isEmpty())planeDetailsToBeUpdated.setModel(planeModelFromClient.getModel());
            if(planeModelFromClient.getMaker()!=null && !planeModelFromClient.getMaker().isEmpty())planeDetailsToBeUpdated.setMaker(planeModelFromClient.getMaker());
            if(planeModelFromClient.getImagePath()!=null && !planeModelFromClient.getImagePath().isEmpty())planeDetailsToBeUpdated.setImagePath(planeModelFromClient.getImagePath());

            planeRepository.save(planeDetailsToBeUpdated);
            return "PlaneDetails updated successfully";
        }
        catch (PlaneNotFoundException planeNotFoundException){
            return "PlaneDetails not updated for the provided PlaneId";
        }
    }
}

