package src;

//---------------------------------------------------------
//Assignment 4
//Written by: Becky Zhang – 40302813
//For COMP 248 Section S – Fall 2024
//---------------------------------------------------------

//Welcome to Montreal Intercampuses Shipping Service(MISSⒸ)!
//This program allows any department or facility of the campuses to send a parcel using either a parcel stamp or a yearly prepaid
//subscription label. It allows the user to see the registries' information such as label and stamps, to see similar registries
//to add or remove stamps,to add stamps and to update the expiry date of a prepaid label.

import java.util.Scanner;

public class MissDemo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//Create scanner object
				
		int choice=1;
		//Initialize choice variable
		
		System.out.print("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
				+ "\n|  Welcome to Montreal Intercampuses Shipping Service(MISSⒸ) Application                |"
				+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		//Welcome message
		
		Stamps stamps0 = new Stamps(4,0,0,4,1);
		Registry registry0 = new Registry(stamps0, new Label[0]);
		registry0.addLabel("Standard", 98825164, 25, 12);
		registry0.addLabel("Confidential", 98703195, 3, 12);
		
		Registry registry1 = new Registry(stamps0, new Label[0]);
		registry1.addLabel("Fragile", 98825164, 7, 12);
		registry1.addLabel("Standard", 98596387, 24, 8);
		
		Stamps stamps2 = new Stamps(9,4,0,2,1);
		Registry registry2 = new Registry(stamps2, new Label[0]);
		registry2.addLabel("Express", 98432806, 1, 6);
		registry2.addLabel("Small", 98087913, 18, 12);
		registry2.addLabel("Oversize", 98735421, 5, 4);
		
		Stamps stamps3 = new Stamps(3,2,4,1,0);
		Registry registry3 = new Registry(stamps3, new Label[0]);
		
		Registry registry4 = new Registry(stamps3, new Label[0]);
		//Creating the registries 0 to 4
		//Making stamp objects to put into the registry
		//Adding labels to the registry
		
		Registry[] registries = {registry0, registry1, registry2, registry3, registry4};
		//Creating an array to store the registries
		
		while (choice !=0) {
		//Set a while loop for a user that has not quit the application
			System.out.print("\n| What would you like to do?                                                             |"
					+ "\n| 1  >> See the content of all Registeries                                               |"
					+ "\n| 2  >> See the content of one Registry                                                  |"
					+ "\n| 3  >> List Registries with same $ amount of shipment Stamps                            |"
					+ "\n| 4  >> List Registries with same number of shipment Stamps types                        |"
					+ "\n| 5  >> List Registries with same $ amount of Stamps and same number of prepaid Labels   |"
					+ "\n| 6  >> Add a prepaid label to an existing Registry                                      |"
					+ "\n| 7  >> Remove an existing prepaid label from a Registry                                 |"
					+ "\n| 8  >> Update the expiry date of an existing prepaid label                              |"
					+ "\n| 9  >> Add Stamps to a Registry                                                         |"
					+ "\n| 0  >> To quit                                                                          |"
					+ "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
					+ "\n\nPlease enter your choice and press <Enter>:");
			//Display all the choices and prompt the user to input a choice
			choice = sc.nextInt();
			//Read the user input
			
			switch (choice) {
			//Set a switch case for to compare the expression that is the variable choice with each case
				case 1:
					System.out.println("Content of each Registry:"
							+ "\n---------------------");
					for (int i = 0; i<=4; i++) 
						System.out.print("\nRegistry #" + i +":\n"+ registries[i].toString());
					//Print the content of each registry, using a loop to access all the registries in the registries array
					break;
					
				case 2:
					System.out.print("Which Registry you want to see the content of? (Enter number 0 to 4):");
					//Prompt the user to choose a registry
					int registryChoice = sc.nextInt();
					//Scan user input
					while (registryChoice < 0 || registryChoice > 4) {
						System.out.print("Sorry but there is no Registry number " + registryChoice + "\n--> Try again: (Enter number 0 to 4): ");
						registryChoice = sc.nextInt();
					}
					//Set a while loop for an invalid choice
					
					System.out.print(registries[registryChoice].toString());
					//Print the information about the chosen registry
					break;
					
				case 3:
					System.out.print("List of Registries with same total $ Stamps:\n\n");
					for (int j = 0, i = 0; j<=4; j++)
						for (i = j+1; i<=4; i++) {
							if(registries[j].equalStampsTotal(registries[i]))
								System.out.print("\tRegistries " + j + " and " + i + " both have " + registries[j].getStampsTotal()+"\n");
						}
					//Use a for loop in a for loop to compare the registries to each other and printing if they have the same total
					break;
					
				case 4:
					System.out.print("List of Registries with same Stamps categories:\n\n");
					for (int j = 0, i = 0; j<=4; j++)
						for (i = j+1; i<=4; i++) {
							if(registries[j].equalStamps(registries[i]))
								System.out.print("\tRegistries " + j + " and " + i + " both have " + registries[j].getStamps()+"\n");
						}
					//Use a for loop in a for loop to compare the registries to each other and printing if they have the same stamps categories
					break;
					
				case 5:
					System.out.print("List of Registries with same $ amount of Stamps and same number of Labels:\n\n");
					for (int j = 0, i = 0; j<=4; j++)
						for (i = j+1; i<=4; i++) {
							if(registries[j].equals(registries[i]))
								System.out.print("\tRegistries " + j + " and " + i +"\n");
						}
					//Use a for loop in a for loop to compare the registries to each other and printing if they have the same total and number of labels
					break;
					
				case 6:
					System.out.print("Which Registry do you want to add a Label to? (Enter number 0 to 4): ");
					//Prompt user to choose a registry
					int registryChoice6 = sc.nextInt();
					//Scan user input
					System.out.print("Please enter the following information so that we can complete the Label-\n"
							+ " --> Type of Label (Confidential, Small, Oversize, Express, Standard, Fragile): ");
					sc.nextLine();
					String type = sc.nextLine();
					System.out.print(" --> Id of the prepaid label possessor: ");
					int iD = sc.nextInt();
					System.out.print(" --> Expiry day number and month (separate by a space): ");
					int day = sc.nextInt();
					int month =sc.nextInt();
					//Prompt the user to input the information of the label and can for user input
					registries[registryChoice6].addLabel(type, iD, day, month);
					//Add the label to the registry using the method
					System.out.print("You now have " + registries[registryChoice6].numberLabels()+ " Label");
					//Print the number of labels in the chosen registry after the addition of the new label
					break;
					
				case 7:
					System.out.print("Which Registry do you want to remove a Label from? (Enter number 0 to 4): ");
					//Prompt user to choose a registry
					int registryChoice7 = sc.nextInt();
					//Scan user input
					if (registries[registryChoice7].numberLabels() == 0)
						System.out.print("Sorry that Registry has no Labels");
					//Check for an invalid choice
					else {
						System.out.print("(Enter number 0 to " + (registries[registryChoice7].numberLabels()-1)+")\n");
						//Prompt the user for the index of the label to be removed
						int removedLabelIndex = sc.nextInt();
						//Scan user input
						registries[registryChoice7].removeLabel(removedLabelIndex);
						//Remove the label using the method
						System.out.print("Label was removed successfully");
					}
					break;
					
				case 8:
					System.out.print("Which Registry do you want to update a Label from? (Enter number 0 to 4): ");
					//Prompt user to choose a registry
					int registryChoice8 = sc.nextInt();
					//Scan user input
					System.out.print("Which Label do you want to update? (Enter number 0 to 4):"
							+ "(Enter number 0 to " + (registries[registryChoice8].numberLabels()-1)+"):\n");
					//Prompt user to choose a label to update
					int updateLabel = sc.nextInt();
					//Scan user input
					System.out.print(" --> Enter new expiry date day number and month (separated by a space): ");
					//Prompt the user to enter the new expiry date
					int dayUpdate = sc.nextInt();
					int monthUpdate =sc.nextInt();
					//Scan user input
					registries[registryChoice8].updateDate(updateLabel, dayUpdate, monthUpdate);
					//Update expiry date using the method
					System.out.print("Expiry Date updated.");
					break;
					
				case 9:
					System.out.print("Which Registry do you want to add Stamps to? (Enter number 0 to 4): ");
					//Prompt user to choose a registry
					int registryChoice9 = sc.nextInt();
					//Scan user input
					System.out.print("How many category_A($2), category_B($5), category_C($10), category_D ($15), category_E ($20) parcel stamps do you want to add?"
							+ "\n(Enter 5 numbers separated by a space): ");
					//Prompt the user to enter the number of added parcel stamps
					int add_A = sc.nextInt();
					int add_B = sc.nextInt();
					int add_C = sc.nextInt();
					int add_D = sc.nextInt();
					int add_E = sc.nextInt();
					//Scan user input
					registries[registryChoice9].addStamps(add_A, add_B, add_C, add_D, add_E);
					//Add stamos using the method
					System.out.print("You now have $" + registries[registryChoice9].getStampsTotal()+".0");
					//Print the new stamps total
					break;
					
				case 0:
					break;
				default:
					System.out.print("Sorry that is not a valid choice. Try again.");
					//Print a message to indicate an invalid choice
			}
		}
		sc.close();
		System.out.print("Thank you for using Montreal Intercampuses Shipping Service(MISSⒸ) Application!");
		//Closing message
	}

}
