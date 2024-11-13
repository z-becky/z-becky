package src;

//---------------------------------------------------------
//Assignment 3
//Written by: Becky Zhang – 40302813
//For COMP 248 Section S – Fall 2024
//---------------------------------------------------------
//Algorithm 1: ATM Simulator

//Welcome to the ATM Simulator!
//This program simulates a simple ATM machine by allowing users to check their balance, deposit money, and withdraw money.

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {

		Scanner keyIn = new Scanner(System.in);
		//Create scanner object.
		
		double balance = 0;
		//Initialize balance variable to store the total balance of the user.
		
		System.out.print("Welcome to the Best Bank ATM!\n----------------------------------------------------");
		//Print a welcome message.
		
		int choice = 0;
		//Initialize choice variable to store the user's choice.
		
		while (choice !=4) {
		//Set a while loop for a user that has not yet chosen to exit.
			//In the while loop:
			
			System.out.print("\nPlease choose an option:\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit\nEnter your choice: ");
			//Prompt the user to choose from the options.
			choice = keyIn.nextInt();
			//Read the user input for the choice and store it in choice.
			
			switch (choice) {
			//Set a switch statement.
			//Evaluate the expression which is the choice variable.
			//Compare the choice variable to the value of each case.
			//If the choice is equal to the value of a case, the following code block is executed.
			
				case 1:
				//For a user that wants to check their balance, print the balance.
					System.out.printf("Your balance is: $%.2f\n\n----------------------------------------------------",balance);
					break;
					
				case 2:
				//For a user that wants to deposit,
					System.out.print("Enter amount to deposit: ");
					//Prompt the user to input the amount they want to deposit.
					double deposit = keyIn.nextDouble();
					//Read the user input for the deposit amount and store it in deposit.
					
					if (deposit % 5 == 0 && 5 <= deposit && deposit <=10000) {
					//Set an if condition for a deposit amount that is in bills and is between 5$ and 10000$.
						balance += deposit;
						//Calculate the new balance by adding the deposit amount to the balance.
						System.out.print("Deposit successful!\n\n----------------------------------------------------");
						//Print a message for a successful deposit.
					}
					
					else
					//Set an else condition for an invalid deposit amount.
						System.out.print("Invalid deposit amount! You can only deposit amounts that are multiples of 5, 10, 50, or 100."
								+"\n\n----------------------------------------------------");
						//Print a message for an invalid deposit amount.
					break;
					
				case 3:
				//For a user that wants to withdraw,
					System.out.print("Enter amount to withdraw (multiples of 5, 10, 50, or 100): ");
					//Prompt the user to input the amount they want to withdraw
					double withdrawal = keyIn.nextDouble();
					//Read the user input for the withdrawal amount and store it in withdrawal.
					int bills = 0;
					//Initialize bills variable to store the number of each type of bills that will be dispensed.
					
					if (withdrawal % 5 == 0 && withdrawal <= balance && 5 <= withdrawal && withdrawal <= 1000) {
					//Set an if condition for a withdrawal amount that is in bills and is between 5$ and 1000$.
						balance -= withdrawal;
						//Calculate the new balance by subtracting the withdrawal amount from the balance.
						System.out.println("You will receive: ");
						//Print a message for the withdrawal.
						
							if (withdrawal >= 100) {
							//Set an if condition for a withdrawal amount that is bigger or equal to 100$.
								bills = (int)withdrawal/100;
								//Calculate the number of bills dispensed for bills of 100$.
								System.out.println("\t"+ bills +" bill(s) of 100$");
								//Print the number of 100$ bills dispensed.
								withdrawal -= bills*100;
								//Calculate the amount left to withdraw.
							}
							if (withdrawal >= 50) {
								//Set an if condition for a withdrawal amount that is bigger or equal to 50$.
									bills = (int)withdrawal/50;
									//Calculate the number of bills dispensed for bills of 50$.
									System.out.println("\t"+ bills +" bill(s) of 50$");
									//Print the number of 50$ bills dispensed.
									withdrawal -= bills*50;
									//Calculate the amount left to withdraw.
							}
							if (withdrawal >= 10) {
								//Set an if condition for a withdrawal amount that is bigger or equal to 10$.
									bills = (int)withdrawal/10;
									//Calculate the number of bills dispensed for bills of 10$.
									System.out.println("\t"+ bills +" bill(s) of 10$");
									//Print the number of 10$ bills dispensed.
									withdrawal -= bills*10;
									//Calculate the amount left to withdraw.
							}
							if (withdrawal >= 5) {
								//Set an if condition for a withdrawal amount that is bigger or equal to 5$.
									bills = (int)withdrawal/5;
									//Calculate the number of bills dispensed for bills of 5$.
									System.out.println("\t"+ bills +" bill(s) of 5$");
									//Print the number of 5$ bills dispensed.
								}
						System.out.print("Withdrawal successful!\n\n----------------------------------------------------");
						//Print a message for a successful withdrawal.
					}
					else
						//Set an else condition for an invalid withdrawal amount.
						System.out.print("Invalid withdrawal amount! You can only withdraw amounts that are multiples of 5, 10, 50, or 100."
								+"\n\n----------------------------------------------------");
						//Print a message for an invalid withdrawal amount.
					break;
					
				case 4:
				//For a user that wants to exit,
					//Break out of the switch block.
					break;
					
				default:
				//For an invalid choice,
					System.out.print("Invalid choice! Please try again.\n\n----------------------------------------------------");
					//Print a message for an invalid choice.
			}
		}
		System.out.print("Goodbye!");
		//Print an ending message.
		keyIn.close();
		//Close the scanner object.
	}

}
