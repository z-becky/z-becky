package Client;
import Vehicle.Vehicle;

public class Client {
    // client attributes

    protected String fullName;
    protected String email;
    protected String phoneNumber;
    protected String dateOfBirth;
    protected Vehicle[] leasedVehicle;

    // default constructor

    public Client () {
        fullName = "null";
        email = "null";
        phoneNumber = "null";
        leasedVehicle = null;
        dateOfBirth = "null";
    }
     //parameterized constructor

    public Client (String fullName,String email, String phoneNumber, String dateOfBirth,Vehicle[] leasedVehicle) {
        this.email = email;
        this.phoneNumber = phoneNumber;
       this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.leasedVehicle = leasedVehicle;

    }
    // getters & setters

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Vehicle[] getLeasedVehicle() {
        return leasedVehicle;
    }

    public void setLeasedVehicle(Vehicle[] leasedVehicle) {
        this.leasedVehicle = leasedVehicle;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //equals method


    public String displayLeasedVehicles(){
        String leasedVehicles = "";
        for (int i=0; i<leasedVehicle.length; i++){
           leasedVehicles += leasedVehicle[i].toString();
        }
        return leasedVehicles;
    }

    public boolean equals(Client other) {
        if (other == null || getClass() != other.getClass()) return false;
        return fullName.equals(other.fullName) && dateOfBirth.equals(other.dateOfBirth)
                && phoneNumber.equals(other.phoneNumber) && email.equals(other.email)
                //change array equals
                && other.leasedVehicle.equals(other.leasedVehicle);

    }

    // toString method


    @Override
    public String toString() {
        return "\n\nClient's information: " +
                "\nFullName: " + fullName +
                "\nEmail Address: " + email +
                "\nPhone Number: " + phoneNumber +
                "\nDate Of Birth: " + dateOfBirth;
    }
}
