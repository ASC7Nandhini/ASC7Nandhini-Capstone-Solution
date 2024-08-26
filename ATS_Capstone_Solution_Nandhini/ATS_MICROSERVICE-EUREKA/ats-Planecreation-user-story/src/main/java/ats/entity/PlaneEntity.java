package ats.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Plane")
public class PlaneEntity {
    @Id
    @Column(name = "registration_number", updatable = false, nullable = false)
    private String registrationNumber;
    @Column(name = "maker")
    private String maker;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "seating_capacity", nullable = false)
    private int seatingCapacity;

    public PlaneEntity(){
    }

    public PlaneEntity(String registrationNumber, String maker, String model, String imagePath, int seatingCapacity){
        this.registrationNumber=registrationNumber;
        this.maker=maker;
        this.model=model;
        this.imagePath=imagePath;
        this.seatingCapacity=seatingCapacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

}
