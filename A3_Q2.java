package src;

//---------------------------------------------------------
//Assignment 3
//Written by: Becky Zhang – 40302813
//For COMP 248 Section S – Fall 2024
//---------------------------------------------------------
//Algorithm 2: Inventory Management

//This program manages an inventory of 5 products in an electronic store.

import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {

		System.out.print("Welcome to Inventory Management System");
		//Print a welcome message.
		
		String[] name = new String[5];
		double[] price = new double[5];
		int[] stock = new int[5];
		//Declare arrays of length 5 for the name, price and stock of the products.
		
		Scanner keyIn = new Scanner(System.in);
		//Create scanner object.
		
		System.out.println("\nEnter details for 5 products (price, quantity, name):");
		//Prompt the user to enter the details of the 5 products.
		
		int i, choice = 0;
		//Declare a variable i which will store the indexes of the products and initialize variable choice.
		for (i=0;i<5;i++) {
		//Set a for loop that goes through all indexes of the arrays(0-4).
			System.out.println("Product "+ (i+1) +":\nEnter product details (price, quantity, name):");
			//Prompt the user to enter the details of the product i.
			price[i] = keyIn.nextDouble();
			//Read the user input for the price and store it in the index i of the price array.
			stock[i] = keyIn.nextInt();
			//Read the user input for the stock i and store it in the index i of the stock array.
			name[i] = keyIn.nextLine().replaceFirst(" ","");
			//Read the user input for the name i and store it in the index i of the name array.
		}
		while (choice != 6) {
		//Set a while loop for a user that has not yet chosen to exit.
			System.out.print("\nInventory Management Menu:\n"
					+ "\t1. Display information of all products\n"
					+ "\t2. Update the quantity of a product\n"
					+ "\t3. Search for a product by name\n"
					+ "\t4. Find the product with the lowest quantity\n"
					+ "\t5. Find the product with the highest price\n"
					+ "\t6. Exit\n"
					+ "Enter your choice: ");
			//Prompt the user to choose from the options.
			
			choice = keyIn.nextInt();
			//Read the user input and store it in the variable choice.
			keyIn.nextLine();
			//Consume the enter character using a key.nextLine() function.
			
			switch(choice) {
			//Set a switch statement.
			//Evaluate the expression which is the choice variable.
			//Compare the choice variable to the value of each case.
			//If the choice is equal to the value of a case, the following code block is executed.
			
				case 1:
				//To display the information of all products,
					System.out.println("Product List:");
					//Print a title that precedes the product list.
					
					for(i=0;i<5;i++){
					//Set a for loop that goes through all indexes of the arrays (0-4).
						System.out.println("\tProduct "+ (i+1) +":\n"
								+ "\tName: " + name[i]
								+ "\n\tPrice: $" + price[i]
								+ "\n\tQuantity: " + stock[i]+"\n---------------------------");
						//Print the details of the product i.
					}
					break;
					
				case 2:
				//To update the quantity of a product,
					System.out.print("Enter the product number (1-5) to update quantity: ");
					//Prompt the user to enter the number of the product they want to update.
					i = keyIn.nextInt() - 1;
					//Calculate the index of the product by reading the user input and subtracting 1 from it and store it in variable i.
					System.out.print("Enter new quantity for "+ name[i] +": ");
					//Prompt the user to enter the new quantity for the product.
					stock[i] = keyIn.nextInt();
					//Read the user input and store it in the index i of the stock array.
					System.out.println("Quantity updated successfully!");
					//Print a message for a successful quantity update.
					break;
					
				case 3:
				//To search for a product,
					System.out.print("Enter the name of the product to search for: \n");
					//Prompt the user to enter the name of the product to search for.
					String search = keyIn.nextLine();
					//Read the user input and store it in search.
					for (i=0; i<name.length; i++ ) {
					//Set a for loop that goes through all indexes of the name array.
						if (name[i].equalsIgnoreCase(search)) {
						//Set an if condition for a member of the name array that is equal to the search.
							System.out.print("\nProduct Found:\n"
									+ "\tName: " + name[i]
									+ "\n\tPrice: $" + price[i]
									+ "\n\tQuantity: " + stock[i]+"\n");
							//Print the product details of the product, the member that meets the if condition.
						}
					}
					break;
					
				case 4:
				//To find the product with the lowest quantity,
					int min = 0;
					//Initialize a variable min to store the index of the product with the lowest quantity.
					for (i=0; i<stock.length; i++ ) {
					//Set a for loop that goes through all indexes of the stock array.
						if (stock[i] < stock[min]) {
							min = i;
						}
						//Set an if condition to check for the product that has the lowest quantity.
					}
					System.out.print("\nProduct of the Lowest Quantity: \n"
								+ "\tName: " + name[min]
								+ "\n\tPrice: $" + price[min]
								+ "\n\tQuantity: " + stock[min]+"\n");
					//Print the details of the product of the lowest quantity.
					break;
					
				case 5:
				//To find the product with the highest price,
					int max = 0;
					//Initialize a variable max to store the index of the product with the highest price.

					for (i=0; i<price.length; i++ ) {
					//Set a for loop that goes through all indexes of the price array.

						if (price[i]>price[max]) {
							max=i;
						}
						//Set an if condition to check for the product that has the highest price.
					}
					System.out.print("\nProduct with the Highest Price: \n"
								+ "\tName: " + name[max]
								+ "\n\tPrice: $" + price[max]
								+ "\n\tQuantity: " + stock[max]+"\n");
					//Print the details of the product of the highest price.
					break;
					
				case 6:
				//For a user that wants to exit,
					//Break out of the switch block.
					break;
					
				default:
				//For an invalid choice.
					System.out.print("Invalid choice! Please try again."
							+"\n\n----------------------------------------------------");
					//Print a message for an invalid choice.
					break;
			}

		}
		System.out.print("Goodbye!");
		//Print an ending message.
		keyIn.close();
		//Close the scanner object.
	}
}
