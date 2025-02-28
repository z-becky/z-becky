package Vehicle;

public class DieselTruck extends Truck {

    // diesel Truck attributes

    protected int fullTankCapacity;
    private static int plateNumberNumber = 1000;
    private final String PLATE_NUMBER_TYPE = "DT";

    // default constructor

    public DieselTruck() {
        fullTankCapacity = 0;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    //parameterized constructor
    public DieselTruck(String make, String model, int yearOfProduction, int maxCapacity, int fullTankCapacity) {
        super(make, model, yearOfProduction, maxCapacity);
        this.fullTankCapacity = fullTankCapacity;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;


    }

    // Copy constructor
    public DieselTruck (DieselTruck other) {
        super (other);
        fullTankCapacity = other.fullTankCapacity;
        plateNumberNumber++;
        plateNumber = PLATE_NUMBER_TYPE + plateNumberNumber;
    }

    // getters & setters

    public int getFullTankCapacity() {
        return fullTankCapacity;
    }

    public void setFullTankCapacity(int fullTankCapacity) {
        this.fullTankCapacity = fullTankCapacity;


    }

    // To String method
    @Override
    public String toString() {
        return super.toString() + "\nFull tank Capacity: " + fullTankCapacity +"L";
    }

    //equal method
    public boolean equals(DieselTruck other) {
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return super.equals(other) && fullTankCapacity == other.fullTankCapacity;
    }
}

