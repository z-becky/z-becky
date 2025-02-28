package Vehicle;


public class ElectricTruck extends Truck {

 // Electric Truck attributes

    protected int maxAutonomyRange;
    private static int plateNumberNumber = 1000;
    private final String PLATE_NUMBER_TYPE = "ET";


  // default constructor

    public ElectricTruck () {
        maxAutonomyRange = 0;
        int plateNumberNumber = 1000;

        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;


    }

    //parameterized constructor

    public ElectricTruck (String make, String model , int yearOfProduction , int maxCapacity ,int maxAutonomyRange) {
        super (make,model ,yearOfProduction, maxCapacity );
        this.maxAutonomyRange = maxAutonomyRange;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;

    }
   // copy constructor

    public ElectricTruck (ElectricTruck other) {
        super (other);
        maxAutonomyRange = other.maxAutonomyRange;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }
    // getters

    public int getMaxAutonomyRange() {
        return maxAutonomyRange;
    }

    // setters

    public void setMaxAutonomyRange(int newMaxAutonomyRange) {
        maxAutonomyRange = newMaxAutonomyRange;
    }

    // To String
    @Override
    public String toString() {
        return super.toString() + "\nMaximum Autonomy Range: " + maxAutonomyRange +"km";
    }

    // equals method



    public boolean equals(ElectricTruck other) {
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return super.equals(other) && maxAutonomyRange == other.maxAutonomyRange;
    }
}
