package Driver;

import Client.Client;
import Vehicle.*;

import java.util.Scanner;

//----------------------------------------------
// Assignment 1
// Written by: Becky Zhang (40302813) & Rojin Niknejad (40264301)
//----------------------------------------------
public class Driver {

    //To store the vehicles available in the manager
    static Vehicle[] vehicleManager = new Vehicle[0];
    //client array
    static Client[] clientManager = new Client[0];

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //Welcome message
        System.out.println("Welcome to the Royal Rentals Manager!");

        System.out.print("Would you like to run the predefined scenario?" +
                "\n\t1. Yes" +
                "\n\t2. No" +
                "\nEnter your choice: ");
        int scenarioChoice = sc.nextInt();
        if (scenarioChoice == 1){

            //3 vehicles of each type

            vehicleManager = new Vehicle[]{
                    new ElectricCar("Tesla", "Model 3", 2023, 5, 530),
                    new ElectricCar("Hyundai","Ioniq 6", 2023, 5,488),
                    new ElectricCar("Nissan","Leaf",2023,5,381),
                    new GasolineCar("Honda", "Civic", 2023,5,2),
                    new GasolineCar("Toyota","Corolla",2023,5,2),
                    new GasolineCar("Mazda","Mazda3",2023,5,3),
                    new ElectricTruck("Ford","F-150 Lightning",2023,907,386),
                    new ElectricTruck("Rivian","R1T",2023,799,505),
                    new ElectricTruck("Chevrolet","Silverado EV",2024,590,644),
                    new DieselTruck("Ford","Super Duty F-250",2023,1905,7),
                    new DieselTruck("RAM","2500",2023,1835,7),
                    new DieselTruck("Ford","Super Duty F-250",2023,1905,7)
            };

            //3 clients
            clientManager = new Client[]{
                    new Client("Karen Brown","brown.karen@gmail.com","(514)111-1111","1977/01/01",new Vehicle[0]),
                    new Client("Noah Zhang","zhang.noah@gmail.com","(514)222-2222","1988/02/02",new Vehicle[0]),
                    new Client("Anna Belle","belle.anna@gmail.com","(514)333-3333","1999/03/03",new Vehicle[0])
            };

            //list all objects
            System.out.print("--- Vehicles ---");
            for (int i=0; i<vehicleManager.length; i++){
                System.out.print(vehicleManager[i].toString());
            }
            System.out.print("\n\n--- Clients ---");
            for (int i=0; i< clientManager.length; i++){
                System.out.print(clientManager[i].toString());
            }

            //testing equals methods
            System.out.println("\n\n- Comparing 2 objects from different classes -" +
                    "\nEC1001 vs GC1002: " + vehicleManager[0].equals(vehicleManager[4])+
                    "\n- Comparing 2 objects of the same class with different attributes -" +
                    "\nET1001 vs ET1003: " + vehicleManager[6].equals(vehicleManager[8])+
                    "\n- Comparing 2 objects of the same class and attributes -"+
                    "\nDT1001 vs DT1003: " + vehicleManager[9].equals(vehicleManager[11]));



            System.out.print("\n- Largest Diesel Truck -" + getLargestTruck(vehicleManager));

            //arrays for each type of vehicle
            //electric truck array
            int count = 0;

            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof ElectricTruck){
                    count++;
                }
            }

            ElectricTruck[] electricTruckArray = new ElectricTruck[count];

            int j=0;
            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof ElectricTruck){
                    electricTruckArray[j++] = (ElectricTruck) vehicleManager[i];
                }
            }

            //electric car array
            int countEC = 0;

            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof ElectricCar){
                    countEC++;
                }
            }

            ElectricCar[] electricCarArray = new ElectricCar[countEC];

            int m =0;
            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof ElectricCar){
                    electricCarArray[m++] = (ElectricCar) vehicleManager[i];
                }
            }
            //diesel truck array
            int countDT = 0;

            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof DieselTruck){
                    countDT++;
                }
            }

            DieselTruck[] dieselTruckArray = new DieselTruck[countDT];

            int l =0;
            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof DieselTruck){
                    dieselTruckArray[l++] = (DieselTruck) vehicleManager[i];
                }
            }
            //gasoline car array
            int countGC = 0;

            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof GasolineCar){
                    countGC++;
                }
            }

            GasolineCar[] gasolineCarArray = new GasolineCar[countGC];

            int k =0;
            for(int i =0; i<vehicleManager.length; i++){
                if (vehicleManager[i] instanceof GasolineCar){
                    gasolineCarArray[k++] = (GasolineCar) vehicleManager[i];
                }
            }


            //electric truck array copy
            ElectricTruck[] electricTruckArrayCopy = copyVehicles(electricTruckArray);

            System.out.print("\n\n- List of a copy of the electric trucks -");

            for (int i=0; i<electricTruckArrayCopy.length; i++){
                System.out.print(electricTruckArrayCopy[i].toString());
            }

        }


        int choice = 0;

        //Menu of Operations

        while (choice != 5){
            System.out.print("\n========== Menu of Operations ==========" +
                    "\nWhat would you like to do?" +
                    "\n\t1. Manage Vehicles" +
                    "\n\t2. Manage Clients" +
                    "\n\t3. Manage Leases" +
                    "\n\t4. Additional Operations" +
                    "\n\t5. Quit" +
                    "\nEnter your choice: ");

            choice = sc.nextInt();

            switch(choice){
                //Vehicle Management
                case 1:

                    int vehicleChoice = 0;

                    while (vehicleChoice !=5){
                        System.out.print("\n----- Vehicle Management -----" +
                                "\nWhat would you like to do?" +
                                "\t\n1. Add a vehicle" +
                                "\t\n2. Delete a vehicle" +
                                "\t\n3. Update vehicle information" +
                                "\t\n4. List all vehicles by category" +
                                "\t\n5. Quit" +
                                "\nEnter your choice: ");

                        vehicleChoice = sc.nextInt();

                        switch(vehicleChoice){

                            //Add a vehicle
                            case 1:

                                    int vehicleTypeChoice = 0;

                                    //Choosing the type of vehicle to add
                                        System.out.print("\n- Add a Vehicle -" +
                                                "\nWhat type of vehicle would you like to add?" +
                                                "\t\n1. Electric Car" +
                                                "\t\n2. Gasoline Car" +
                                                "\t\n3. Electric Truck" +
                                                "\t\n4. Diesel Truck" +
                                                "\nEnter your choice: ");

                                        vehicleTypeChoice = sc.nextInt();

                                        //Adding the vehicle
                                        switch (vehicleTypeChoice){
                                            //Electric car
                                            case 1:
                                                //Prompt the user to enter the information of the new electric car
                                                System.out.print("\n\tEnter the following information:" +
                                                        "\n\tMake: ");
                                                sc.nextLine();
                                                String makeEC = sc.nextLine();

                                                System.out.print("\tModel: ");
                                                String modelEC = sc.nextLine();

                                                System.out.print("\tYear of Production: ");
                                                int yearOfProductionEC = sc.nextInt();

                                                System.out.print("\tMaximum Number of Passengers: ");
                                                int maxPassengersEC = sc.nextInt();

                                                System.out.print("\tMaximum Autonomy Range(Kilometers): ");
                                                int maxAutonomyKilometersEC = sc.nextInt();

                                                //extend the manager array and add the electric car
                                                Vehicle[] vehicleManagerExtendEC = new Vehicle[vehicleManager.length+1];
                                                for (int i=0; i<vehicleManager.length; i++){
                                                    vehicleManagerExtendEC[i] = vehicleManager[i];
                                                }
                                                vehicleManagerExtendEC[vehicleManagerExtendEC.length-1] = new ElectricCar(makeEC,modelEC,yearOfProductionEC, maxPassengersEC,maxAutonomyKilometersEC);
                                                vehicleManager = vehicleManagerExtendEC;

                                                System.out.print("\nElectric car successfully added!");
                                                break;

                                            //Gasoline Car
                                            case 2:
                                                //Prompt the user to enter the information of the new gasoline car
                                                System.out.print("\n\tEnter the following information:" +
                                                        "\n\tMake: ");
                                                sc.nextLine();
                                                String makeGC = sc.nextLine();

                                                System.out.print("\tModel: ");
                                                String modelGC = sc.nextLine();

                                                System.out.print("\tYear of Production: ");
                                                int yearOfProductionGC = sc.nextInt();

                                                System.out.print("\tMaximum Number of Passengers: ");
                                                int maxPassengersGC = sc.nextInt();

                                                System.out.print("\tGasoline Tank Capacity(Liters): ");
                                                int maxTankCapacityGC = sc.nextInt();

                                                //extend the manager array and add the gasoline car
                                                Vehicle[] vehicleManagerExtendGC = new Vehicle[vehicleManager.length+1];
                                                for (int i=0; i<vehicleManager.length; i++){
                                                    vehicleManagerExtendGC[i] = vehicleManager[i];
                                                }
                                                vehicleManagerExtendGC[vehicleManagerExtendGC.length-1] = new GasolineCar(makeGC, modelGC, yearOfProductionGC, maxPassengersGC, maxTankCapacityGC);
                                                vehicleManager = vehicleManagerExtendGC;

                                                System.out.print("\nGasoline car successfully added!");
                                                break;

                                            //Electric Truck
                                            case 3:
                                                //Prompt the user to enter the information of the new electric truck
                                                System.out.print("\n\tEnter the following information:" +
                                                        "\n\tMake: ");
                                                sc.nextLine();
                                                String makeET = sc.nextLine();

                                                System.out.print("\tModel: ");
                                                String modelET = sc.nextLine();

                                                System.out.print("\tYear of Production: ");
                                                int yearOfProductionET = sc.nextInt();

                                                System.out.print("\tMaximum Capacity(Kilograms): ");
                                                int maxCapacityET = sc.nextInt();

                                                System.out.print("\tMaximum Autonomy Range(Kilometers): ");
                                                int maxAutonomyKilometersET = sc.nextInt();

                                                //extend the manager array and add the electric truck
                                                Vehicle[] vehicleManagerExtendET = new Vehicle[vehicleManager.length+1];
                                                for (int i=0; i<vehicleManager.length; i++){
                                                    vehicleManagerExtendET[i] = vehicleManager[i];
                                                }
                                                vehicleManagerExtendET[vehicleManagerExtendET.length-1] = new ElectricTruck(makeET,modelET,yearOfProductionET, maxCapacityET,maxAutonomyKilometersET);
                                                vehicleManager = vehicleManagerExtendET;

                                                System.out.print("\nElectric truck successfully added!");
                                                break;

                                            //Diesel Truck
                                            case 4:
                                                //Prompt the user to enter the information of the new electric car
                                                System.out.print("\n\tEnter the following information:" +
                                                        "\n\tMake: ");
                                                sc.nextLine();
                                                String makeDT = sc.nextLine();

                                                System.out.print("\tModel: ");
                                                String modelDT = sc.nextLine();

                                                System.out.print("\tYear of Production: ");
                                                int yearOfProductionDT = sc.nextInt();

                                                System.out.print("\tMaximum Capacity(Kilograms): ");
                                                int maxCapacityDT = sc.nextInt();

                                                System.out.print("\tDiesel Tank Capacity(Liters): ");
                                                int maxTankCapacityDT = sc.nextInt();

                                                //extend the manager array and add the electric car
                                                Vehicle[] vehicleManagerExtendDT = new Vehicle[vehicleManager.length+1];
                                                for (int i=0; i<vehicleManager.length; i++){
                                                    vehicleManagerExtendDT[i] = vehicleManager[i];
                                                }
                                                vehicleManagerExtendDT[vehicleManagerExtendDT.length-1] = new DieselTruck(makeDT, modelDT, yearOfProductionDT, maxCapacityDT, maxTankCapacityDT);
                                                vehicleManager = vehicleManagerExtendDT;

                                                System.out.print("\nDiesel truck successfully added!");
                                                break;

                                            //Quit
                                            case 5:
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please try again.");

                                        }

                                break;

                           //Delete a vehicle
                            case 2:

                                System.out.print("\n- Delete a Vehicle -" +
                                        "\nEnter the plate number of the vehicle you would like to delete: ");

                                sc.nextLine();

                                String deleteVehicle = sc.nextLine();

                                for(int i =0; i<vehicleManager.length; i++){
                                    if (deleteVehicle.equals(vehicleManager[i].getPlateNumber())){
                                        vehicleManager[i] = null;

                                        Vehicle[] vehicleManagerShrink = new Vehicle[vehicleManager.length-1];

                                        int shrunkIndex = 0;
                                        for (int j = 0; j<vehicleManager.length; j++){
                                            if(vehicleManager[j] != null){
                                                vehicleManagerShrink[shrunkIndex++] = vehicleManager[j];
                                            }
                                        }
                                        vehicleManager = vehicleManagerShrink;

                                        System.out.print("Vehicle successfully deleted!");
                                        break;
                                    }
                                    if (i == vehicleManager.length-1){
                                        System.out.print("There is no vehicle with this plate number.");
                                    }
                                }

                                break;

                            //Update vehicle information
                            case 3:

                                System.out.print("\n- Update Vehicle Information -" +
                                        "\nEnter the plate number of the vehicle you would like to update: ");

                                sc.nextLine();
                                String updateVehicle = sc.nextLine();

                                for (int i =0; i<vehicleManager.length; i++) {
                                    if (updateVehicle.equals(vehicleManager[i].getPlateNumber())) {
                                        System.out.print(vehicleManager[i].toString() +
                                                "\n\nWhat would you like to update?" +
                                                "\n\t1. Make" +
                                                "\n\t2. Model" +
                                                "\n\t3. Year of Production");
                                        if(vehicleManager[i] instanceof ElectricCar){
                                            System.out.print("\n\t4. Maximum Passengers" +
                                                    "\n\t5. Maximum Autonomy Range" +
                                                    "\n\t6. Quit" +
                                                    "\nEnter your choice: ");
                                        }
                                        if(vehicleManager[i] instanceof GasolineCar){
                                            System.out.print("\n\t4. Maximum Passengers" +
                                                    "\n\t5. Gasoline Tank Capacity" +
                                                    "\n\t6. Quit" +
                                                    "\nEnter your choice: ");
                                        }
                                        if(vehicleManager[i] instanceof ElectricTruck){
                                            System.out.print("\n\t4. Maximum Weight Capacity" +
                                                    "\n\t5. Maximum Autonomy Range" +
                                                    "\n\t6. Quit" +
                                                    "\nEnter your choice: ");
                                        }
                                        if(vehicleManager[i] instanceof DieselTruck){
                                            System.out.print("\n\t4. Maximum Weight Capacity" +
                                                    "\n\t5. Diesel Tank Capacity" +
                                                    "\n\t6. Quit" +
                                                    "\nEnter your choice: ");
                                        }

                                        int updateChoice = sc.nextInt();

                                        switch (updateChoice){
                                            case 1:
                                                System.out.print("\nEnter new make: ");

                                                sc.nextLine();
                                                String newMake = sc.nextLine();

                                                vehicleManager[i].setMake(newMake);
                                                System.out.print("\nVehicle updated!" + vehicleManager[i].toString());

                                                break;
                                            case 2:
                                                System.out.print("\nEnter new model: ");

                                                sc.nextLine();
                                                String newModel = sc.nextLine();

                                                vehicleManager[i].setModel(newModel);
                                                System.out.print("\nVehicle updated!" + vehicleManager[i].toString());

                                                break;
                                            case 3:
                                                System.out.print("\nEnter new year of production: ");

                                                int newYearOfProduction = sc.nextInt();

                                                vehicleManager[i].setYearOfProduction(newYearOfProduction);
                                                System.out.print("\nVehicle updated!" + vehicleManager[i].toString());

                                                break;
                                            case 4:
                                                if (vehicleManager[i] instanceof Car){
                                                    System.out.print("\nEnter new maximum number of passengers: ");

                                                    int newMaxPassengers = sc.nextInt();

                                                    ((Car)vehicleManager[i]).setMaxPassengers(newMaxPassengers);
                                                }
                                                if (vehicleManager[i] instanceof Truck){
                                                    System.out.print("\nEnter new maximum weight capacity: ");

                                                    int newMaxCapacity = sc.nextInt();

                                                    ((Truck)vehicleManager[i]).setMaxCapacity(newMaxCapacity);
                                                }
                                                System.out.print("\nVehicle updated!" + vehicleManager[i].toString());


                                                break;
                                            case 5:
                                                if (vehicleManager[i] instanceof DieselTruck || vehicleManager[i] instanceof GasolineCar){
                                                    System.out.print("\nEnter new tank capacity: ");

                                                    int newTankCapacity = sc.nextInt();

                                                    if (vehicleManager[i] instanceof DieselTruck) {
                                                        ((DieselTruck) vehicleManager[i]).setFullTankCapacity(newTankCapacity);
                                                    }

                                                    if (vehicleManager[i] instanceof GasolineCar) {
                                                        ((GasolineCar) vehicleManager[i]).setGasolineTankCapacity(newTankCapacity);
                                                    }
                                                    System.out.print("\nVehicle updated!" + vehicleManager[i].toString());

                                                }
                                                if (vehicleManager[i] instanceof ElectricTruck || vehicleManager[i] instanceof ElectricCar){
                                                    System.out.print("\nEnter new maximum autonomy range: ");

                                                    int newAutonomyRange = sc.nextInt();

                                                    if (vehicleManager[i] instanceof ElectricTruck) {
                                                        ((ElectricTruck) vehicleManager[i]).setMaxAutonomyRange(newAutonomyRange);
                                                    }

                                                    if (vehicleManager[i] instanceof ElectricCar) {
                                                        ((ElectricCar) vehicleManager[i]).setMaxAutonomyRange(newAutonomyRange);
                                                    }
                                                    System.out.print("\nVehicle updated!" + vehicleManager[i].toString());

                                                }
                                                break;
                                            case 6:
                                                break;
                                            default:
                                                System.out.print("Invalid choice. Please try again.");
                                        }
                                    }
                                    else if (i == vehicleManager.length-1){
                                        System.out.print("There is no vehicle with this plate number.");
                                    }
                                }
                                break;

                            //List all vehicles by category
                            case 4:

                                System.out.print("\n- List Vehicles -" +
                                        "\nWhich type of vehicles would you like to list?" +
                                        "\n\t1. Electric Car" +
                                        "\n\t2. Gasoline Car" +
                                        "\n\t3. Electric Truck" +
                                        "\n\t4. Diesel Truck" +
                                        "\n\t5. Quit" +
                                        "\nEnter your choice: ");

                                int listVehicles = sc.nextInt();

                                switch (listVehicles){
                                    //list electric cars
                                    case 1:
                                        for (int i=0; i<vehicleManager.length; i++){
                                            if (vehicleManager[i] instanceof ElectricCar){
                                                System.out.println(vehicleManager[i].toString());
                                            }
                                        }
                                        break;
                                    //list gasoline cars
                                    case 2:
                                        for (int i=0; i<vehicleManager.length; i++){
                                            if (vehicleManager[i] instanceof GasolineCar){
                                                System.out.println(vehicleManager[i].toString());
                                            }
                                        }
                                        break;
                                    //list electric trucks
                                    case 3:
                                        for (int i=0; i<vehicleManager.length; i++){
                                            if (vehicleManager[i] instanceof ElectricTruck){
                                                System.out.println(vehicleManager[i].toString());
                                            }
                                        }
                                        break;
                                    //list diesel trucks
                                    case 4:
                                        for (int i=0; i<vehicleManager.length; i++){
                                            if (vehicleManager[i] instanceof DieselTruck){
                                                System.out.println(vehicleManager[i].toString());
                                            }
                                        }
                                        break;
                                    //quit
                                    case 5:
                                        break;
                                    default:
                                        System.out.print("Invalid choice. Try again.");

                                }

                                break;

                            //Quit
                            case 5:
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;

                //Client Management
                case 2:

                    int clientChoice = 0;

                    while (clientChoice !=4 ) {
                        System.out.print("\n----- Client Management -----" +
                                "\nWhat would you like to do?" +
                                "\t\n1. Add a Client" +
                                "\t\n2. Edit a Client" +
                                "\t\n3. Delete a Client" +
                                "\t\n4. Quit" +
                                "\nEnter your choice: ");
                        clientChoice = sc.nextInt();

                        switch (clientChoice) {
                            // add a client
                            case 1 :
                                System.out.print("PLease enter new Client's information:" +
                                        "\n\tEnter Client's Full name: ");
                                sc.nextLine();
                                String  clientName = sc.nextLine();
                                System.out.print ("\tEnter Client's date of birth: ");
                                String clientDate = sc.next();
                                System.out.print("\tEnter Client's Phone Number: ");
                                String phoneNumber = sc.next();
                                System.out.print("\tEnter Client's Email address: ");
                                String emailAdd = sc.next();
                                // create a client object to put new client's information
                                Client newClient = new Client(clientName , emailAdd ,phoneNumber , clientDate , new Vehicle[0]);

                                // creating an array to extend the length for new client
                                Client[] clientManagerExtend = new Client [clientManager.length + 1];

                                for (int i = 0 ; i < clientManager.length ; i++) {
                                    clientManagerExtend[i] = clientManager[i];
                                }

                                clientManagerExtend[clientManagerExtend.length - 1] = newClient;
                                clientManager = clientManagerExtend;

                                System.out.println("\nNew client successfully added!");

                                break;

                            // update client's information

                            case 2 :

                                System.out.print("Enter client's full name: ");
                                sc.nextLine();
                                String n = sc.nextLine();

                                Client selectedClient = null;

                                for (int i = 0; i < clientManager.length ; i++) {
                                    if(clientManager[i].getFullName().equals(n))  {
                                        selectedClient = clientManager[i];
                                        break;
                                    }
                                }

                                if (selectedClient == null) {
                                    System.out.println("No clients match this name!");
                                    break;
                                }

                                System.out.print("Please enter Client's new full name: ");
                                String newName = sc.nextLine();
                                System.out.print("Please enter Client's new email: ");
                                String newEmail = sc.nextLine();
                                System.out.print("Please enter Client's new date of Birth: ");
                                String newDate = sc.nextLine();
                                System.out.print("Please enter Client's new Phone Number: ");
                                String newPhoneNumber = sc.nextLine();

                                selectedClient.setFullName(newName);
                                selectedClient.setPhoneNumber(newPhoneNumber);
                                selectedClient.setDateOfBirth(newDate);
                                selectedClient.setEmail(newEmail);
                                break;

                            // delete a client

                            case 3:
                                System.out.print("Enter the full name of the client you wish to delete: ");
                                sc.nextLine();
                                String nameDelete = sc.nextLine();
                                int result = -1;
                                for (int i = 0 ; i < clientManager.length ; i++) {
                                    if (clientManager[i].getFullName().equals(nameDelete)) {
                                        result = i;
                                        break;
                                    }
                                }
                                if (result == -1) {
                                    System.out.println("No client matches your search.");
                                    break;
                                }
                                Client[] clientManagerShrink = new Client[clientManager.length - 1];
                                int shrunkIndex = 0;
                                for (int i = 0 ; i <clientManager.length ; i++) {
                                    if (i == result )
                                        continue;
                                    clientManagerShrink[shrunkIndex++] = clientManager[i];

                                } clientManager = clientManagerShrink;

                                break;

                            case 4 :
                                break;

                            default : System.out.println("Invalid choice, please try again!");
                        }
                    }


                    break;

                //Leasing Operations
                case 3:

                    int leaseChoice = 0;

                    while (leaseChoice !=5) {

                        System.out.print("\n---- Leasing Operations ----" +
                                "\nWhat would you like to do?" +
                                "\n\t1. Lease a vehicle to a client" +
                                "\n\t2. Return a vehicle from a client" +
                                "\n\t3. Show all vehicles leased by a client" +
                                "\n\t4. Show al vehicles leased by all clients" +
                                "\n\t5. Quit" +
                                "\nEnter your choice: ");

                        leaseChoice = sc.nextInt();

                        switch (leaseChoice) {
                            case 1:

                                System.out.print("Enter the full name of the client leasing a vehicle: ");
                                sc.nextLine();
                                String leaseName = sc.nextLine();

                                System.out.print("Enter the plate number of the vehicle you would like to lease: ");

                                String leasedPlate = sc.nextLine();

                                boolean leaseSuccess = false;

                                for (int i = 0; i < clientManager.length; i++) {
                                    if (leaseName.equals(clientManager[i].getFullName())) {
                                        for (int j = 0; j < vehicleManager.length; j++) {
                                            if (leasedPlate.equals(vehicleManager[j].getPlateNumber())) {

                                                Vehicle[] leasedVehiclesExtend = new Vehicle[clientManager[i].getLeasedVehicle().length + 1];

                                                for (int k = 0; k < clientManager[i].getLeasedVehicle().length; k++) {
                                                    leasedVehiclesExtend[k] = clientManager[i].getLeasedVehicle()[k];
                                                }

                                                leasedVehiclesExtend[leasedVehiclesExtend.length - 1] = vehicleManager[j];
                                                clientManager[i].setLeasedVehicle(leasedVehiclesExtend);

                                                System.out.print("\nVehicle successfully leased.");

                                                leaseSuccess = true;
                                                break;
                                            }

                                        }
                                        break;
                                    }
                                }

                                if (!leaseSuccess){
                                    System.out.print("There is no client or vehicle with this name or plate number.");
                                }


                                break;
                            case 2:
                                System.out.print("Enter the full name of the " +
                                        "client returning a vehicle: ");
                                sc.nextLine();
                                String returnName = sc.nextLine();

                                System.out.print("Enter the plate number of the " +
                                        "vehicle you would like to return: ");
                                String returnedPlate = sc.nextLine();

                                boolean deleteLeaseSuccess = false;

                                for (int i = 0; i < clientManager.length; i++) {
                                    if (returnName.equals(clientManager[i].getFullName())) {
                                        for (int j = 0; j < clientManager[i].getLeasedVehicle().length; j++) {
                                            if (returnedPlate.equals(clientManager[i].getLeasedVehicle()[j].getPlateNumber())) {

                                                clientManager[i].getLeasedVehicle()[j] = null;

                                                Vehicle[] leasedVehiclesShrink = new Vehicle[clientManager[i].getLeasedVehicle().length - 1];

                                                int returnIndexCount = 0;
                                                for (int k = 0; k < clientManager[i].getLeasedVehicle().length; k++) {
                                                    if (clientManager[i].getLeasedVehicle()[k] != null) {
                                                        leasedVehiclesShrink[returnIndexCount++] = clientManager[i].getLeasedVehicle()[k];
                                                    }
                                                }
                                                clientManager[i].setLeasedVehicle(leasedVehiclesShrink);

                                                System.out.print("\nVehicle successfully deleted.");

                                                deleteLeaseSuccess = true;

                                            }
                                        }
                                    }
                                }
                                if(clientManager.length == 0 || vehicleManager.length == 0){
                                System.out.print("There is no client or vehicle in the manager.");
                                }

                                if(!deleteLeaseSuccess){
                                    System.out.print("There is no client or vehicle with this name or plate number.");
                                }
                                break;
                            case 3:
                                System.out.print("- Display a client's leased vehicles -" +
                                        "\nEnter the name of the client:");

                                String displayClientLeases = sc.nextLine();

                                for (int i = 0; i < clientManager.length; i++) {
                                    if (displayClientLeases.equals(clientManager[i].getFullName())) {
                                        System.out.print(clientManager[i].displayLeasedVehicles());
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("- Display all clients' leased vehicles -");

                                for (int i = 0; i < clientManager.length; i++) {
                                    System.out.print(clientManager[i].displayLeasedVehicles());
                                }
                                break;
                            case 5:

                                break;
                            default:
                                System.out.print("Invalid choice. Try again.");
                        }
                    }

                    break;

                //Additional Operations
                case 4:

                    int additionalChoice = 0;

                    while (additionalChoice !=3) {
                        System.out.print("\n----- Additional Operations -----" +
                                "\nWhat would you like to do?" +
                                "\t\n1. Display the truck with the largest capacity" +
                                "\t\n2. Create a copy of the electric trucks array" +
                                "\t\n3. Quit" +
                                "\nEnter your choice: ");

                        additionalChoice = sc.nextInt();

                        switch (additionalChoice){
                            case 1:
                                System.out.print("\nThe diesel truck(s) with the largest capacity:\n" + getLargestTruck(vehicleManager));
                                break;
                            case 2:
                                int count = 0;

                                for(int i =0; i<vehicleManager.length; i++){
                                    if (vehicleManager[i] instanceof ElectricTruck){
                                        count++;
                                    }
                                }

                                ElectricTruck[] electricTruckArray = new ElectricTruck[count];

                                int j=0;
                                for(int i =0; i<vehicleManager.length; i++){
                                    if (vehicleManager[i] instanceof ElectricTruck){
                                        electricTruckArray[j++] = (ElectricTruck) vehicleManager[i];
                                    }
                                }

                                ElectricTruck[] electricTruckArrayCopy = copyVehicles(electricTruckArray);

                                System.out.print("\nList of a copy of the electric trucks: ");

                                for (int i=0; i<electricTruckArrayCopy.length; i++){
                                    System.out.print(electricTruckArrayCopy[i].toString());
                                }

                                break;
                            case 3:
                                break;
                            default:
                                System.out.print("Invalid choice. Try again.");
                        }
                    }

                    break;

                //Quit
                case 5:
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you for using the Royal Rentals Vehicle Manager.");

    }

    //method to get the largest truck
    public static String getLargestTruck(Vehicle[] vehicleManager){

        DieselTruck largestTruck = null;

        for (int i = 0 ; i < vehicleManager.length ; i++){
            if (vehicleManager[i] instanceof DieselTruck){
                if (largestTruck == null || ((DieselTruck) vehicleManager[i]).getMaxCapacity() > largestTruck.getMaxCapacity()) {
                    largestTruck = (DieselTruck)vehicleManager[i];
                }
            }
        }

        if (largestTruck != null){
                return largestTruck.toString();
        }
        else
            return "There are no trucks in the vehicle manager.";
    }

    //method to create a deep copy of an electric truck array
    public static ElectricTruck[] copyVehicles(ElectricTruck[] electricTrucks){

        ElectricTruck[] deepCopy = new ElectricTruck[electricTrucks.length];

        for (int i = 0 ; i<electricTrucks.length; i++){
             deepCopy[i] = new ElectricTruck(electricTrucks[i]);
        }
        return deepCopy;

    }

}
