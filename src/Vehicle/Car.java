package Vehicle;

public class Car extends Vehicle {
    protected int maxPassengers;

    //default constructor
    public Car(){
        maxPassengers = 0;
    }

    //parameterized constructor
    public Car(String make, String model, int yearOfProduction, int maxPassengers){
        super(make,model,yearOfProduction);
        this.maxPassengers = maxPassengers;
    }

    //copy constructor
    public Car(Car other){
        super(other);
        maxPassengers = other.maxPassengers;
        //plate number?
    }

    //getter
    public int getMaxPassengers(){
        return maxPassengers;
    }

    //setter
    public void setMaxPassengers(int newMaxPassengers){
        maxPassengers = newMaxPassengers;
    }

    //toString method
    @Override
    public String toString(){
        return super.toString() +"\nMaximum Number of Passengers: " + maxPassengers;
    }

    //equals method
    public boolean equals(Car other){
        return super.equals(other) && maxPassengers == other.maxPassengers;
    }

}
