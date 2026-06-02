import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println(" VEHICLE INFORMATION SYSTEM ");
            System.out.println("================================");
            System.out.println("1. Add Car");
            System.out.println("2. Add Motorcycle");
            System.out.println("3. Add Truck");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            try {

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:

                        Car car = new Car();

                        System.out.print("Enter car make: ");
                        car.setMake(input.nextLine());

                        System.out.print("Enter car model: ");
                        car.setModel(input.nextLine());

                        System.out.print("Enter manufacturing year: ");
                        car.setYear(input.nextInt());

                        System.out.print("Enter number of doors: ");
                        car.setNumberOfDoors(input.nextInt());
                        input.nextLine();

                        System.out.print(
                                "Enter fuel type "
                                        + "(Petrol/Diesel/Electric): ");

                        car.setFuelType(input.nextLine());

                        car.displayCarInfo();

                        break;

                    case 2:

                        Motorcycle motorcycle =
                                new Motorcycle();

                        System.out.print(
                                "Enter motorcycle make: ");

                        motorcycle.setMake(
                                input.nextLine());

                        System.out.print(
                                "Enter motorcycle model: ");

                        motorcycle.setModel(
                                input.nextLine());

                        System.out.print(
                                "Enter manufacturing year: ");

                        motorcycle.setYear(
                                input.nextInt());

                        System.out.print(
                                "Enter number of wheels: ");

                        motorcycle.setNumberOfWheels(
                                input.nextInt());

                        input.nextLine();

                        System.out.print(
                                "Enter motorcycle type "
                                + "(Sport/Cruiser/Off-road): ");

                        motorcycle.setMotorcycleType(
                                input.nextLine());

                        motorcycle.displayMotorcycleInfo();

                        break;

                    case 3:

                        Truck truck = new Truck();

                        System.out.print(
                                "Enter truck make: ");

                        truck.setMake(
                                input.nextLine());

                        System.out.print(
                                "Enter truck model: ");

                        truck.setModel(
                                input.nextLine());

                        System.out.print(
                                "Enter manufacturing year: ");

                        truck.setYear(
                                input.nextInt());

                        System.out.print(
                                "Enter cargo capacity (tons): ");

                        truck.setCargoCapacity(
                                input.nextDouble());

                        input.nextLine();

                        System.out.print(
                                "Enter transmission type "
                                + "(Manual/Automatic): ");

                        truck.setTransmissionType(
                                input.nextLine());

                        truck.displayTruckInfo();

                        break;

                    case 4:

                        System.out.println(
                                "\nExiting program...");
                        System.out.println(
                                "Thank you for using the system.");

                        break;

                    default:

                        System.out.println(
                                "Invalid option. Try again.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid input! Please enter correct data.");

                input.nextLine();
                choice = 0;
            }

        } while (choice != 4);

        input.close();
    }
}