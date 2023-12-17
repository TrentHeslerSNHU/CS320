/**
 * Trent Hesler
 * CS 320 - Software Test Automation & QA
 * 12/2/23
 * 6-1 Project One
 */
package ContactService;

import java.util.UUID;
import java.util.ArrayList;

public class ContactService {
	
	private ArrayList<Contact> ContactList = new ArrayList<Contact>();
	
	/**
	 * Method to check if a proposed contact ID is unique
	 * @param checkID - The ID to be checked.
	 * @return isUnique - A boolean indicating whether the provided ID is unique or not
	 */
	public boolean checkUniqueID(String checkID) {
		boolean isUnique = true;
		try {
			for (int i = 0; i < ContactList.size(); i++) {
				if (ContactList.get(i).getID() == checkID) {
					isUnique = false;
				}
			}
		} catch (ArrayStoreException|NullPointerException err) {
			isUnique = false;
			System.out.println("[ERROR] Contact list is null. Is it empty, perhaps?");
		}
		return isUnique;
	}
	
	/**
	 * Method to find a particular contact from within the list, by its ID.
	 * @param ID - the ID to search for
	 * @return i - the array index for the contact with a matching ID (-1 if not found)
	 */
	public int getByID(String ID) {
		for (int i = 0; i < ContactList.size(); i++) {
			if (ContactList.get(i).getID() == ID) {
				return i;
			}
		}
		System.out.println("[ERROR] Contact with ID '" + ID + "' not found.");
		return -1;
	}
	
	/**
	 * Method to find a particular contact by its index within the ContactList array.
	 * @param index - the index of the contact to try to get
	 * @return ContactList.get(index) - the Contact object of the contact at the given index
	 */
	public Contact getByIndex(int index) {
		try {
			return ContactList.get(index);
		} catch (IndexOutOfBoundsException|NullPointerException err) {
			System.out.println("[ERROR] No contact available at index " + index + ".");
			return null;
		}
	}
	
	/**
	 * Method to add a contact to the contact list (without specifying a unique ID)
	 * @param firstName - the first name of the contact to be added
	 * @param lastName - the last name of the contact to be added
	 * @param phone - the phone number of the contact to be added
	 * @param address - the address of the contact to be added
	 */
	public void addContact(String firstName, String lastName, String phone, String address) {
		String ID = UUID.randomUUID().toString().replace("-","").substring(0, 10);
		
		if (checkUniqueID(ID)) {
			 ContactList.add(new Contact(ID,firstName,lastName,phone,address));
		} else {
				 while (!checkUniqueID(ID)) {
					 ID = UUID.randomUUID().toString().replace("-","").substring(0, 10);
				 }
				 ContactList.add(new Contact(ID,firstName,lastName,phone,address));
		}
	}
	
	/**
	 * Method to add a contact to the contact list with a specified ID
	 * @param ID - Unique ID for contact to be added
	 * @param firstName - the first name of the contact to be added
	 * @param lastName - the last name of the contact to be added
	 * @param phone - the phone number of the contact to be added
	 * @param address - the address of the contact to be added
	 */
	public void addContact(String ID, String firstName, String lastName, String phone, String address) {
		if (checkUniqueID(ID)) {
			ContactList.add(new Contact(ID,firstName,lastName,phone,address));
		} else {
			throw new IllegalArgumentException("[ERROR] Contact ID is not unique.");
		}
	}
	
	//TODO Future: Make delete/update by index (maybe)
	//     For now, can just use getByIndex(#).getID()
	
	/**
	 * Method to delete a contact with a specified ID from the contact list
	 * @param ID - the ID of the contact to be deleted from the list
	 */
	public boolean deleteContact(String ID) {
		try {
			ContactList.remove(getByID(ID));
			System.out.println("[INFO] Deleted contact with ID '" + ID + "'.");
			return true;
		} catch (NullPointerException err){
			System.out.println("[ERROR] Contact list not found. Is it empty, perhaps?");
			return false;
		}
	}
	
	/**
	 * Method to update the first name of a contact with a specified ID
	 * @param ID - the ID of the contact whose first name is to be changed
	 * @param newFirstName - the new first name of the contact
	 */
	public void updateFirstName(String ID, String newFirstName) {
		try {
			String origFirstName = ContactList.get(getByID(ID)).getFirstName();
			ContactList.get(getByID(ID)).setFirstName(newFirstName);
			System.out.println("[INFO] Changed first name from '" + origFirstName + "' to '" + newFirstName + "'.");
		} catch (NullPointerException err) {
			System.out.println("[ERROR] Cannot update first name of contact with ID " + ID + ": Contact not found.");
		}
	}
	
	/**
	 * Method to update the last name of a contact with a specified ID
	 * @param ID - the ID of the contact whose last name is to be changed
	 * @param newLastName - the new last name of the contact
	 */
	public void updateLastName(String ID, String newLastName) {
		try {
			String origLastName = ContactList.get(getByID(ID)).getLastName();
			ContactList.get(getByID(ID)).setLastName(newLastName);
			System.out.println("[INFO] Changed last name from '" + origLastName + "' to '" + newLastName + "'.");;
		} catch (NullPointerException err) {
			System.out.println("[ERROR] Cannot update last name of contact with ID " + ID + ": Contact not found.");
		}
	}
	
	/**
	 * Method to update the phone number of a contact with a specified ID
	 * @param ID - the ID of the contact whose phone number is to be changed
	 * @param newNumber - the new phone number for the contact
	 */
	public void updateNumber(String ID, String newNumber) {
		try {
			String origNumber = ContactList.get(getByID(ID)).getPhone();
			ContactList.get(getByID(ID)).setPhone(newNumber);
			System.out.println("[INFO] Changed phone number from '" + origNumber + "' to '" + newNumber + "'.");
		} catch (NullPointerException err) {
			System.out.println("[ERROR] Cannot update phone number of contact with ID " + ID + ": Contact not found.");
		}
	}
	
	/**
	 * Method to update the address of a contact with a specified ID
	 * @param ID - the ID of the contact whose address is to be changed
	 * @param newAddress - the new address for the contact
	 */
	public void updateAddress(String ID, String newAddress) {
		try {
			String origAddress = ContactList.get(getByID(ID)).getAddress();
			ContactList.get(getByID(ID)).setAddress(newAddress);
			System.out.println("[INFO] Changed address from '" + origAddress + "' to '" + newAddress + "'.");
		} catch (NullPointerException err){
			System.out.println("[ERROR] Cannot update address of contact with ID " + ID + ": Contact not found.");
		}
	}
	
	/**
	 * Method to display the contents of the contact list
	 */
	public void printContactList() {
		try {
			for (int i = 0; i < ContactList.size(); i++) {
				System.out.println("Contact #" + (i+1));
				System.out.println("Unique ID: " +ContactList.get(i).getID());
				System.out.println("First name: " + ContactList.get(i).getFirstName());
				System.out.println("Last name: " + ContactList.get(i).getLastName());
				System.out.println("Phone number: " + ContactList.get(i).getPhone());
				System.out.println("Address: " + ContactList.get(i).getAddress());
				System.out.println();
			}
		} catch (NullPointerException err) {
			System.out.println("Contact list is empty.");
		}
	}
}