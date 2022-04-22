package combridgelabz.Addressbook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	private static ArrayList<AddressBookContact> list = new ArrayList<AddressBookContact>();

	// Add contact details in AddressBookContact ::
	public void AddContactsDetails() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter the First Name => ");
		String firstName = userInput.nextLine();
		System.out.println("Enter the Last Name => ");
		String lastName = userInput.nextLine();
		System.out.println("Enter the Address => ");
		String address = userInput.nextLine();
		System.out.println("Enter the City => ");
		String city = userInput.nextLine();
		System.out.println("Enter the State => ");
		String state = userInput.nextLine();
		System.out.println("Enter the Zip Code => ");
		int zip = userInput.nextInt();
		System.out.println("Enter the Phone Number => ");
		long phoneNumber = userInput.nextLong();
		System.out.println("Enter the Email => ");
		String email = userInput.nextLine();
		AddressBookContact details = new AddressBookContact(firstName, lastName, address, city, state, zip, phoneNumber,
				email);
		list.add(details);
		details.display();
	}

	// Edit contact details in AddressBookContact::
	private void editContact() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter firstname to edit contact => ");
		String name = userInput.nextLine();
		for (AddressBookContact search : list) {
			if (name.equalsIgnoreCase(search.getFirstName())) {
				System.out.println("Enter the updated first name => ");
				String firstName = userInput.next();
				search.setFirstName(firstName);
				System.out.println("Enter the updated last name => ");
				String lastName = userInput.next();
				search.setLastName(lastName);
				System.out.println("Enter the updated address => ");
				String address = userInput.next();
				search.setAddress(address);
				System.out.println("Enter the updated city => ");
				String city = userInput.next();
				search.setCity(city);
				System.out.println("Enter the updated state => ");
				String state = userInput.next();
				search.setState(state);
				System.out.println("Enter the updated zipcode => ");
				int zip = userInput.nextInt();
				search.setZip(zip);
				System.out.println("Enter the updated phoneNumber => ");
				long phoneNumber = userInput.nextInt();
				search.setPhoneNumber(phoneNumber);
				System.out.println("Enter the updated emailID => ");
				String email = userInput.next();
				search.setEmail(email);
				search.display();
			} else {
				System.out.println("Entered name not found in the AddressBook");
			}
		}
	}

	// Delete contact details in AddressBookContact ::
	private void deleteContact() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter firstname to Delete Contact => ");
		String name = userInput.nextLine();
		for (AddressBookContact search : list) {
			if (name.equalsIgnoreCase(search.getFirstName())) {
				System.out.println("Entered name found in the Address Book, deleting contact");
				list.remove(search);
			} else {
				System.out.println("Entered name not found in the Address Book");
			}
		}
	}

	// Check duplicate entry in AddressBookContact::
	private void checkDuplicateEntry() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter firstname to Check duplicate entry Contact: ");
		String name = userInput.nextLine();
		for (AddressBookContact search : list) {
			if (name.equalsIgnoreCase(search.getFirstName())) {
				System.out.println("Entered name found in the Address Book");
			} else {
				System.out.println("Entered name not found in the Address Book");
			}
		}
	}

	// Search person in AddressBookContact::
	private void searchPerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter city to search person entry in Contact: ");
		String city = sc.nextLine();
		for (AddressBookContact search : list) {
			if (city.equalsIgnoreCase(search.getCity())) {
				System.out.println("Entered city found in the Address Book");
				search.display();
			} else {
				System.out.println("Entered city not found in the Address Book");
			}
		}
	}

	// View persons by state wise ::
	private void viewPersons() {
		Collections.sort(list, (o1, o2) -> (o1.getState().compareTo(o2.getState())));
		for (AddressBookContact search : list) {
			System.out.println("The person name is " + search.getFirstName() + " from " + search.getState() + " State");
		}
	}

	// View persons contact number by state wise ::
	private void viewPersonsContactNumber() {
		Collections.sort(list, (o1, o2) -> (o1.getState().compareTo(o2.getState())));
		for (AddressBookContact search : list) {
			System.out.println(" ");
			System.out.println("Person name :: " + search.getFirstName() + "|| Phone no :: " + search.getPhoneNumber()
					+ "|| State :: " + search.getState());
		}
	}

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		HashMap<String, AddressBook> addressBooks = new HashMap<>();
		AddressBook book1 = new AddressBook();
		AddressBook book2 = new AddressBook();
		AddressBook book3 = new AddressBook();
		addressBooks.put("AddressBook1", book1);
		addressBooks.put("AddressBook2", book2);
		addressBooks.put("AddressBook3", book3);
		System.out.println("Choose your Address Book => AddressBook(1)/ AddressBook(2)/ AddressBook(3)");
		int chooseAddressBook = userInput.nextInt();
		System.out.println("Choose your Address Book => Add/Edit/Delete/DuplicateEntry/SearchPerson");
		while (chooseAddressBook >= 1) {
			System.out.println(
					"Enter Your Choice => Add Contacts (1)/Edit Contacts (2)/Delete Contacts (3)/ Check Duplicate Entry (4)/ Search person (5)");
			int choice = userInput.nextInt();
			switch (chooseAddressBook) {
			case 1:
				if (choice == 1) {
					book1.AddContactsDetails();
				} else if (choice == 2) {
					book1.editContact();
				} else if (choice == 3) {
					book1.deleteContact();
				} else if (choice == 4) {
					book1.checkDuplicateEntry();
				} else if (choice == 5) {
					book1.searchPerson();
				}
				break;
			case 2:
				if (choice == 1) {
					book2.AddContactsDetails();
				} else if (choice == 2) {
					book2.editContact();
				} else if (choice == 3) {
					book2.deleteContact();
				} else if (choice == 4) {
					book2.checkDuplicateEntry();
				} else if (choice == 5) {
					book2.searchPerson();
				}
				break;
			case 3:
				if (choice == 1) {
					book3.AddContactsDetails();
				} else if (choice == 2) {
					book3.editContact();
				} else if (choice == 3) {
					book3.deleteContact();
				} else if (choice == 4) {
					book3.checkDuplicateEntry();
				} else if (choice == 5) {
					book3.searchPerson();
				}
				break;
			default:
				System.out.println("Give proper input");
				break;
			}
			System.out.println("1) AddressBook 1");
			System.out.println("2) AddressBook 2");
			System.out.println("3) AddressBook 3");
			System.out.println("0) Exit");
			AddressBook myobj = new AddressBook();
			myobj.viewPersons();
			myobj.viewPersonsContactNumber();
			chooseAddressBook = userInput.nextInt();

		}
	}

}
