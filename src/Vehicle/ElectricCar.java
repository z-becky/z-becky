package Vehicle;

public class ElectricCar extends Car{
    protected int maxAutonomyRange;
    private static int plateNumberNumber = 1000;
    private final String PLATE_NUMBER_TYPE = "EC";

    //default constructor
    public ElectricCar(){
        maxAutonomyRange = 0;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    //parameterized constructor
    public ElectricCar(String make, String model, int yearOfProduction, int maxPassengers, int maxAutonomyRange){
        super(make,model,yearOfProduction, maxPassengers);
        this.maxAutonomyRange = maxAutonomyRange;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    //copy constructor
    public ElectricCar(ElectricCar other){
        super(other);
        maxAutonomyRange = other.maxAutonomyRange;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    //getters
    public int getMaxAutonomyRange(){
        return maxAutonomyRange;
    }

    //setters
    public void setMaxAutonomyRange(int newMaxAutonomyKilometers){
        maxAutonomyRange = newMaxAutonomyKilometers;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() + "\nMaximum Autonomy Range: " + maxAutonomyRange +"km";
    }

    //equals method
    public boolean equals(ElectricCar other){
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return super.equals(other) && maxAutonomyRange == other.maxAutonomyRange;
    }

}
