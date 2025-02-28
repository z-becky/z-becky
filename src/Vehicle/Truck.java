package Vehicle;

public class Truck extends Vehicle {

    // truck attributes
    protected int maxCapacity;

    // default constructor
    public Truck (){
        maxCapacity = 0;

    }
    // parameterized constructor
    public Truck (String make , String model , int yearOfProduction, int maxCapacity) {
        super (make , model , yearOfProduction);
        this.maxCapacity = maxCapacity;
    }

    // copy constructor
    public Truck (Truck other) {
        super(other);
        maxCapacity = other.maxCapacity;
    }

    // getter
    public int getMaxCapacity (){
        return maxCapacity;
    }

    // setter
    public void setMaxCapacity (int newMaxCapacity) {
        maxCapacity = newMaxCapacity;
    }
    // equals method


    public boolean equals(Truck other) {
        if (other == null || getClass() != other.getClass())
            return false;
        else
            return super.equals(other)&& maxCapacity == other.maxCapacity;
    }
    // toString method
    @Override
    public String toString(){
        return super.toString()+ "\nMaximum Weight Capacity: " + maxCapacity + "kg";
    }
}
