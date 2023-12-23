import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, String>> addressBook = new HashMap<>();

        System.out.println("Welcome to Address Book");

        while (true) {
            System.out.println("\nEnter 1 to add a new entry, 2 to modify, 3 to remove, or 4 to exit:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addEntry(scanner, addressBook);
            } else if (choice == 2) {
                editEntry(scanner, addressBook);
            } else if (choice == 3) {
                deleteEntry(scanner, addressBook);
            } else if (choice == 4) {
                System.out.println("Exiting the Address Book. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }
    }

    public static void addEntry(Scanner scanner, Map<String, Map<String, String>> addressBook) {
        System.out.println("Enter the Person Details");
        Map<String, String> personDetails = new HashMap<>();

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        if (addressBook.containsKey(fullName)) {
            System.out.println("This person already exists in the address book. Use 'modify' to edit details.");
            return;
        }

        System.out.print("Address: ");
        personDetails.put("Address", scanner.nextLine());

        System.out.print("City: ");
        personDetails.put("City", scanner.nextLine());

        System.out.print("State: ");
        personDetails.put("State", scanner.nextLine());

        System.out.print("Zip: ");
        personDetails.put("Zip", scanner.nextLine());

        System.out.print("Phone Number: ");
        personDetails.put("Phone Number", scanner.nextLine());

        System.out.print("Email: ");
        personDetails.put("Email", scanner.nextLine());

        addressBook.put(fullName, personDetails);
        System.out.println("Entry added successfully.");
    }

    public static void editEntry(Scanner scanner, Map<String, Map<String, String>> addressBook) {
        System.out.print("Enter the full name of the person you want to edit: ");
        String fullName = scanner.nextLine();

        if (addressBook.containsKey(fullName)) {
            System.out.println("Editing the details for " + fullName);
            addEntry(scanner, addressBook);
        } else {
            System.out.println("Person not found in the address book.");
        }
    }

    public static void deleteEntry(Scanner scanner, Map<String, Map<String, String>> addressBook) {
        System.out.print("Enter the full name of the person you want to delete: ");
        String fullName = scanner.nextLine();

        if (addressBook.containsKey(fullName)) {
            addressBook.remove(fullName);
            System.out.println("Entry deleted successfully.");
        } else {
            System.out.println("Person not found in the address book.");
        }
    }
}
