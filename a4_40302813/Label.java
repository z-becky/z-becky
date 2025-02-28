package src;

public class Label {
	//This Label class is used to manage the labels in a registry.

	public String type;
	//String attribute to store the type of parcel
	public int iD;
	//Attribute that store the iD of the unit
	public int day;
	//Attribute that stores the day
	public int month;
	//Attribute that stores the month
	
	public Label() {
	}
	//Default constructor
	
	public Label(String type, int iD, int day, int month) {
		this.type = type;
		if (day<1 || day>31)
			day = 0;
		this.day = day;
		
		if (month<1 || month>12)
			month = 0;
		this.month = month;
		
		if (iD < 98000000 || iD >= 100000000)
			iD = 98000000;
		this.iD = iD;
	}
	//Constructor to set the type, iD and date
	
	public Label(Label other) {
		type = other.type;
		iD = other.iD;
		day = other.day;
		month = other.month;
	}
	//Copy constructor
	
	public String getType() {
		return type;
	}
	public int getID() {
		return iD;
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	//Accessor methods
	
	public void setType(String newType) {
		type = newType;
	}
	public void setID(int newID) {
		iD = newID;
		if (iD < 98000000 || iD >= 100000000)
			iD = 98000000;
	}
	public void setDay(int newDay) {
		day = newDay;
		if (day<1 || day>31)
			day = 0;
	}
	public void setMonth(int newMonth) {
		month = newMonth;
		if (month<1 || month>12)
			month = 0;
	}
	//Mutator methods
	
	@Override
	public String toString() {
		if (day<10)
			return type +" - " + iD + " - " + "0" + day + "/" + month +"\n";
			else if (month <10)
				return type +" - " + iD + " - " + day + "/0" + month+"\n";
			else if (day<10 && month <10)
				return type +" - " + iD + " - " + "0" + day + "/0" + month+"\n";
			else
				return type +" - " + iD + " - " + day + "/" + month+"\n";
	}
	//toString() method to display the label information
	
	public boolean equals(Label other) {
		return (type.equals(other.type) &&
				iD == other.iD &&
				day == other.day &&
				month == other.month);
	}
	//equals() method that returns "true" if the labels have the same type, iD and date, and "false" otherwise
}
