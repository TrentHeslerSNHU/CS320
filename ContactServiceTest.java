/**
 * Trent Hesler
 * CS 320 - Software Test Automation & QA
 * 12/2/23
 * 6-1 Project One
 */
package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {
	/** 
	* -The contact service shall be able to add contacts with a unique ID.
	*/
	@Test
	@DisplayName("Add Contact Test - Generated IDs")
	@Order(1)
	void contactAddGenIDTest() {
		ContactService AddressBook = new ContactService();
		System.out.println("[TEST] Attempting to create two contacts with unique generated IDs...");
		AddressBook.addContact("George", "Washington", "0000000000", "1600 Pennsylvania Ave");
		AddressBook.addContact("John", "Adams", "0000000000", "1600 Pennsylvania Ave");
		assertNotSame(AddressBook.getByIndex(0).getID(),AddressBook.getByIndex(1).getID(),"[FAIL] Generated IDs are not unique.");
		System.out.println("[SUCCESS] Generated IDs are unique!");
		System.out.println();
	}
	
	/** 
	* -The contact service shall be able to add contacts with a unique ID.
	*/
	@Test
	@DisplayName("Add Contact Test - Provided IDs")
	@Order(2)
	void contactAddProvIDTest() {
		ContactService AddressBook = new ContactService();
		System.out.println("[TEST] Attempting to add two contacts with same provided IDs...");
		AddressBook.addContact("d8d5fa50", "Bill", "Gates", "8005550123", "1 Microsoft Way");
		assertThrows(IllegalArgumentException.class, () -> AddressBook.addContact(AddressBook.getByIndex(0).getID(),"Steve","Balmer", "8005550123", "1 Microsoft Way"),"[FAIL] Added two contacts with same provided ID.");
		System.out.println("[SUCCESS] Adding two contacts with same ID disallowed!");
		System.out.println();
	}
	
	/**
	* -The contact service shall be able to delete contacts per contact ID.
	*/
	@Test
	@DisplayName("Delete Contact Test")
	@Order(3)
	void contactDeleteTest() {
		ContactService AddressBook = new ContactService();
		
		System.out.println("[TEST] Creating and deleting a contact...");
		AddressBook.addContact("Steve", "Jobs", "8005552775", "1 Apple Park Way");
		AddressBook.deleteContact(AddressBook.getByIndex(0).getID());
		System.out.println("[TEST] Attempting to query deleted contact...");
		assertNull(AddressBook.getByIndex(0), "[FAIL] Contact was not deleted.");
		System.out.println("[SUCCESS] Contact was deleted!");
		System.out.println();
	}
	
	/**
	* -The contact service shall be able to update [firstName] per contact ID.
	*/
	@Test
	@DisplayName("Update Contact First Name Test")
	@Order(4)
	void contactUpdateFirstNameTest() {
		ContactService AddressBook = new ContactService();
		System.out.println("[TEST] Creating a contact then changing first name...");
		AddressBook.addContact("Bradley", "Manning", "5551234567", "Oklahoma City, OK");
		AddressBook.updateFirstName(AddressBook.getByIndex(0).getID(), "Chelsea");
		assertEquals(AddressBook.getByIndex(0).getFirstName(),"Chelsea","[FAIL] Could not update contact first name.");
		System.out.println("[SUCCESS] Updated contact first name!");
		System.out.println();
	}
	
	/**
	* -The contact service shall be able to update [lastName] per contact ID.
	*/
	@Test
	@DisplayName("Update Contact Last Name Test")
	@Order(5)
	void contactUpdateLastNameTest() {
		ContactService AddressBook = new ContactService();
		
		System.out.println("[TEST] Creating a contact then changing last name...");
		AddressBook.addContact("Kim", "West", "5559990134", "Calabasas, CA");
		AddressBook.updateLastName(AddressBook.getByIndex(0).getID(), "Kardashian");
		assertEquals(AddressBook.getByIndex(0).getLastName(),"Kardashian","[FAIL] Could not update contact last name.");
		System.out.println("[SUCCESS] Updated contact last name!");
		System.out.println();
	}
	
	/**
	* -The contact service shall be able to update [Number] per contact ID.
	*/
	@Test
	@DisplayName("Update Contact Phone Number Test")
	@Order(6)
	void contactUpdateNumberTest() {
		ContactService AddressBook = new ContactService();
		
		System.out.println("[TEST] Creating a contact then changing phone number...");
		AddressBook.addContact("Ma","Bell", "8005551122", "Dallas, TX");
		AddressBook.updateNumber(AddressBook.getByIndex(0).getID(), "9999999999");
		assertEquals(AddressBook.getByIndex(0).getPhone(),"9999999999","[FAIL] Could not update contact phone number.");
		System.out.println("[SUCCESS] Updated contact phone number!");
		System.out.println();
	}
	
	/**
	* -The contact service shall be able to update [Address] per contact ID.
	*/
	@Test
	@DisplayName("Update Contact Address Test")
	@Order(7)
	void contactUpdateAddressTest() {
		ContactService AddressBook = new ContactService();
		
		System.out.println("[TEST] Creating contact then changing address...");
		AddressBook.addContact("Donald","Trump", "5551110101", "1600 Pennsylvania Ave");
		AddressBook.updateAddress(AddressBook.getByIndex(0).getID(), "Mar a Lago, FL");
		assertEquals(AddressBook.getByIndex(0).getAddress(),"Mar a Lago, FL","[FAIL] Could not update contact address.");
		System.out.println("[SUCCESS] Updated contact address!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Print Contact List Test")
	@Order(8)
	void contactPrintListTest() {
		ContactService AddressBook = new ContactService();
		
		System.out.println("[TEST] Attempting to print a sample contact list...");
		AddressBook.addContact("Donald","Trump", "5551110101", "1600 Pennsylvania Ave");
		AddressBook.addContact("George", "Washington", "0000000000", "1600 Pennsylvania Ave");
		AddressBook.addContact("John", "Adams", "0000000000", "1600 Pennsylvania Ave");
		assertAll("[FAIL] Could not print contact list.", () -> AddressBook.printContactList());
		System.out.println("[SUCCESS] Printed contact list!");
		System.out.println();
	}
}
