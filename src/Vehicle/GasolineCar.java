package Vehicle;

public class GasolineCar extends Car{
    protected int gasolineTankCapacity;
    private static int plateNumberNumber = 1000;
    private final String PLATE_NUMBER_TYPE = "GC";

    //default constructor
    public GasolineCar(){
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    public GasolineCar(String make, String model, int yearOfProduction, int maxPassengers, int gasolineTankCapacity){
        super(make,model,yearOfProduction, maxPassengers);
        this.gasolineTankCapacity = gasolineTankCapacity;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    public int getGasolineTankCapacity() {
        return gasolineTankCapacity;
    }

    public void setGasolineTankCapacity(int gasolineTankCapacity) {
        this.gasolineTankCapacity = gasolineTankCapacity;
    }

    @Override
    public String toString(){
        return super.toString() + "\nGasoline Tank Capacity: " + gasolineTankCapacity +"L";
    }

    //equals method
    public boolean equals(GasolineCar other){
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return super.equals(other) && gasolineTankCapacity == other.gasolineTankCapacity;
    }
}
