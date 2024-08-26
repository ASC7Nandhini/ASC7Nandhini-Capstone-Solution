package ats.service;

import ats.entity.PlaneEntity;
import ats.model.PlaneModel;
import ats.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService{

    private final PlaneRepository planeRepository;

    @Autowired
    private PlaneServiceImpl(PlaneRepository planeRepository){
        this.planeRepository=planeRepository;
    }

    @Override
    public String generateId(){
        String planeId = planeRepository.findTopId();
        if(planeId==null || planeId.isEmpty()){
            planeId="PL0000";
        }
        String id="PL";
        int number=Integer.parseInt(planeId.substring(2,6));
        number++;
        String digit=Integer.toString(number);
        switch (4-digit.length()){
            case 1:
                id+="0";
                break;
            case 2:
                id+="00";
                break;
            case 3:
                id+="000";
                break;
            default:
                break;
        }
        id+=digit;
        return id;
    }

    @Override
    public List<PlaneModel> getAllPlanes(){
        List<PlaneEntity> allPlanes = planeRepository.findAll();
        List<PlaneModel> planeModelList = new ArrayList<>();
        for(PlaneEntity planeEntity : allPlanes){
            PlaneModel planeModel = new PlaneModel(planeEntity.getRegistrationNumber(),planeEntity.getMaker(),planeEntity.getModel(),planeEntity.getImagePath(),planeEntity.getSeatingCapacity());
            planeModelList.add(planeModel);
        }
        return planeModelList;
    }
}
