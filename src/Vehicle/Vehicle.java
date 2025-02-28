package Vehicle;

public class Vehicle {
    //vehicle attributes
    protected String plateNumber;
    protected String make;
    protected String model;
    protected int yearOfProduction;

    //default constructor
    public Vehicle(){
        plateNumber = "Plate Number Unknown";
        make = "Make Unknown";
        model = "Model Unknown";
        yearOfProduction = 0;
    }

    //parameterized constructor
    public Vehicle(String make, String model, int yearOfProduction){
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        //plate number needs to be set automatically
        //maybe make the vehicle class abstract
    }

    //copy constructor
    public Vehicle(Vehicle other){
        make = other.make;
        model = other.model;
        yearOfProduction = other.yearOfProduction;
        //plate number not the same must be set automatically incrementing 1
    }

    //getters
    public String getPlateNumber(){
        return plateNumber;
    }

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public int getYearOfProduction(){
        return yearOfProduction;
    }

    //setters
    public void setPlateNumber(String newPlateNumber){
        plateNumber = newPlateNumber;
    }

    public void setMake(String newMake){
        make = newMake;
    }

    public void setModel(String newModel){
        model = newModel;
    }

    public void setYearOfProduction(int newYearOfProduction){
        yearOfProduction = newYearOfProduction;
    }

    //toString method
    @Override
    public String toString(){
        return "\n\nPlate Number: " + plateNumber
                +"\nMake: " + make
                +"\nModel: " + model
                +"\nYear of Production: " + yearOfProduction;
    }

    //equals method
    public boolean equals(Vehicle other){
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return make.equals(other.make) && model.equals(other.model) && yearOfProduction == other.yearOfProduction;
    }

}
