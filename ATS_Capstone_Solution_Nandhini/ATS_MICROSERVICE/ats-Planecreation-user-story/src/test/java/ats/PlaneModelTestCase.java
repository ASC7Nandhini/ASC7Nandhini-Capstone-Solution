package ats;

import ats.model.PlaneModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaneModelTestCase {
    PlaneModel planeModel = new PlaneModel("PL1234", "Boeing", "737", "/images/plane.jpg", 150);

    @Test
    public void testRegistrationNumberField() {
        String actualRegistrationNumber = planeModel.getRegistrationNumber();
        Assertions.assertEquals("PL1234", actualRegistrationNumber);
    }

    @Test
    public void testMakerField() {
        String actualMaker = planeModel.getMaker();
        Assertions.assertEquals("Boeing", actualMaker);
    }

    @Test
    public void testModelField() {
        String actualModel = planeModel.getModel();
        Assertions.assertEquals("737", actualModel);
    }

    @Test
    public void testImagePathField() {
        String actualImagePath = planeModel.getImagePath();
        Assertions.assertEquals("/images/plane.jpg", actualImagePath);
    }

    @Test
    public void testSeatingCapacityField() {
        int actualSeatingCapacity = planeModel.getSeatingCapacity();
        Assertions.assertEquals(150, actualSeatingCapacity);
    }
}

