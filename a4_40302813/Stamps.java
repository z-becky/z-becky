package src;

public class Stamps {
	//This Stamps class is used to manage the stamps in a registry.
	
	public static final int VAL_A=2, VAL_B=5, VAL_C=10, VAL_D=15, VAL_E=20;
	//Static constants for the values of each stamp category
	private int category_A, category_B, category_C, category_D, category_E;
	//Attributes to store the number of stamps in each stamp category
	
	public Stamps() {
	}
	//Default constructor
	
	public Stamps(int category_A, int category_B, int category_C, int category_D, int category_E) {
		this.category_A=category_A;
		this.category_B=category_B;
		this.category_C=category_C;
		this.category_D=category_D;
		this.category_E=category_E;		
	}
	//Constructor to set the number of each stamp category in the registry
	
	public Stamps(Stamps other) {
		category_A=other.category_A;
		category_B=other.category_B;
		category_C=other.category_C;
		category_D=other.category_D;
		category_E=other.category_E;		
	}
	//Copy constructor
	
	public int getCategory_A() {
		return category_A;
	}
	public int getCategory_B() {
		return category_B;
	}
	public int getCategory_C() {
		return category_C;
	}
	public int getCategory_D() {
		return category_D;
	}
	public int getCategory_E() {
		return category_E;
	}
	//Accessor methods
	
	public void setCategory_A(int newCategory_A) {
		category_A = newCategory_A;
	}
	public void setCategory_B(int newCategory_B) {
		category_B = newCategory_B;
	}
	public void setCategory_C(int newCategory_C) {
		category_C = newCategory_C;
	}
	public void setCategory_D(int newCategory_D) {
		category_D = newCategory_D;
	}
	public void setCategory_E(int newCategory_E) {
		category_E = newCategory_E;
	}
	//Mutator methods
	
	public void addStamps(int add_A, int add_B, int add_C, int add_D, int add_E) {
		category_A += add_A;
		category_B += add_B;
		category_C += add_C;
		category_D += add_D;
		category_E += add_E;
	}
	//Method to add a number of stamps to each category
	
	public int stampsTotal() {
		return category_A*VAL_A + category_B*VAL_B + category_C*VAL_C + category_D*VAL_D + category_E*VAL_E;
	}
	//Method to calculate the total value of all the stamps
	
	@Override
	public String toString() {
		return category_A + " x $2 + " + category_B + " x $5 + " + category_C + " x $10 + " 
				+ category_D + " x $15 + " + category_E + " x $20 ";
	}
	//Method to display a clear count of the stamps of each category with their values
	
	public boolean equals(Stamps other) {
		return (category_A == other.category_A &&
				category_B == other.category_B &&
				category_C == other.category_C &&
				category_D == other.category_D &&
				category_E == other.category_E);
	}
	//Method to display "true" if the two Stamps objects have the same breakdown of stamps and "false" otherwise
}
