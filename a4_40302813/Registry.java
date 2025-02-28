package src;

public class Registry {
	//This Registry class is used to manage the registries.
	
	private Stamps stamps;
	//Attribute that stores stamp objects
	private Label[] labels;
	//Attribute that is an array storing labels
	
	public Registry() {
	}
	//Default constructor
	
	public Registry(Stamps stamps, Label[] labels) {
		this.stamps = stamps;
		
		if (labels != null) {
			this.labels = new Label[labels.length];
			for (int i=0; i<labels.length;i++)
				this.labels[i] = labels[i];
		}
			else
			this.labels = null;
	}
	//Constructor with the 2 attributes: stamps and labels
	
	public String getStamps() {
		return stamps.toString();
	}
	//Method to get the display a clear count of the stamps of each category with their values
	
	public boolean equalStampsTotal(Registry other) {
		return (stamps.stampsTotal() == other.stamps.stampsTotal());
	}
	//Method which will return "true" if the total value of stamps of two registries are equal, and "false" otherwise
	
	public boolean equalStamps(Registry other) {
		return stamps.equals(other.stamps);
	}
	//Method which will return "tru"e if the number of each stamps category of two registries are equal, and "false" otherwise
	
	public int getStampsTotal() {
		return stamps.stampsTotal();
	}
	//Method which will return the total $ amount of shipment stamps of a registry`
	
	public int numberLabels() {
		return labels.length;
	}
	//Method which will return the number of labels in a Registry.
	
	public int addLabel(String type, int iD, int day, int month) {
		Label newLabel = new Label(type, iD, day, month);
		if (labels == null || labels.length <= 0) {
			labels = new Label[1];
			labels[0] = newLabel;
		}
			else {
				Label[] newLabels = new Label[labels.length+1];
				for (int i =0; i < labels.length; i++)
					newLabels [i] = labels [i];
				newLabels[labels.length] = newLabel;
				labels = newLabels;
			}
		return labels.length;
	}
	//Method to add a label to a registry
	
	public boolean removeLabel(int indexRemovedLabel) {
		if (indexRemovedLabel < 0 || indexRemovedLabel >= labels.length)
			return false;
		else if (labels == null || labels.length <= 0)
			return false;
		else {
			Label[] newLabels = new Label[labels.length - 1];
			for (int i = 0, j= 0; i < labels.length; i++) {
				if (i == indexRemovedLabel)
					continue;
				newLabels[j++]=labels[i];
			}
			labels = newLabels;
			return true;
		}
			
	}
	//Method to remove a label from a registry
	
	public void updateDate(int i, int newDay, int newMonth) {
		labels[i].setDay(newDay);
		labels[i].setMonth(newMonth);
	}
	//Method to update the expiry date of a label
	
	public int addStamps(int add_A, int add_B, int add_C, int add_D, int add_E) {
		stamps.setCategory_A(stamps.getCategory_A() + add_A);
		stamps.setCategory_B(stamps.getCategory_B() + add_B);
		stamps.setCategory_C(stamps.getCategory_C() + add_C);
		stamps.setCategory_D(stamps.getCategory_D() + add_D);
		stamps.setCategory_E(stamps.getCategory_E() + add_E);

		return stamps.stampsTotal();
	}
	//Method to add a number of stamps in each stamp categories
	
	public boolean equals(Registry other) {
		return (stamps.stampsTotal() == other.getStampsTotal() && labels.length == other.numberLabels());
	}
	//equals() method that returns "true" if the registries have the same stamp total $ and number of labels, and "false" otherwise
	
	@Override
	public String toString() {
		if (labels == null || labels.length <= 0)
			return stamps.toString() + "\nNo prepaid labels\n";
		else {
			String allLabels = "";
			for (int i = 0; i < labels.length; i++)
				allLabels += labels[i].toString();
			return stamps.toString()+"\n" + allLabels;
		}
	}
	//toString() method to display the information of a registry
	
	public String stampsToString() {
		return stamps.toString();
	}
	//Method to display the stamps breakdown of a registry
}
