package ats.model;

public class PlaneModel {
    private String registrationNumber;
    private String maker;
    private String model;
    private String imagePath;
    private int seatingCapacity;

    public PlaneModel(){
    }

    public PlaneModel(String registrationNumber, String maker, String model, String imagePath, int seatingCapacity){
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
