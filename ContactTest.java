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
public class ContactTest {
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact ID >10 Chars Test")
	@Order(1)
	void contactLongIDTest() {
		System.out.println("[TEST] Attempting to create a contact with ID longer than 10 chars...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890A","Bill","Nye","5555555555","123 Science Guy Way"), "[FAIL] Contact with ID >10 chars created.");
		System.out.println("[SUCCESS] Contact with ID >10 chars disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact ID NULL Test")
	@Order(2)
	void contactNullIDTest() {
		System.out.println("[TEST] Attempting to create contact with NULL ID...");
		assertThrows(IllegalArgumentException.class, () -> new Contact(null,"Bill","Nye","5555555555","123 Science Guy Way"),"[FAIL] Contact with null ID created.");
		System.out.println("[SUCCESS] Contact with NULL ID disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact First Name >10 Chars Test")
	@Order(3)
	void contactLongFirstNameTest() {
		System.out.println();
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Biiiiiillllllllll","Nye","5555555555","123 Science Guy Way"),"[FAIL] Contact with first name >10 chars created.");
		System.out.println("[SUCCESS] Contact with first name >10 chars disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact First Name NULL Test")
	@Order(4)
	void contactNullFirstNameTest() {
		System.out.println("[TEST] Attempting to create contact with NULL first name...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890",null,"Nye","5555555555","123 Science Guy Way"),"[FAIL] Contact with NULL first name created.");
		System.out.println("[SUCCESS] Contact with NULL first name disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Last Name >10 Chars Test")
	@Order(5)
	void contactLongLastNameTest() {
		System.out.println("[TEST] Attempting to create contact with last name >10 chars...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nyyyyyyeeeeeeeeeee","5555555555","123 Science Guy Way"),"[FAIL] Contact with last name >10 chars created.");
		System.out.println("[SUCCESS] Contact with last name >10 chars disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Last Name NULL Test")
	@Order(6)
	void contactNullLastNameTest() {
		System.out.println("[TEST] Attempting to create contact with NULL last name...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill",null,"5555555555","123 Science Guy Way"),"[FAIL] Contact with NULL last name created.");
		System.out.println("[SUCCESS] Contact with NULL last name disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Phone <10 Chars Test")
	@Order(7)
	void contactShortPhoneTest() {
		System.out.println("[TEST] Attempting to create contact with phone number <10 chars...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nye","0","123 Science Guy Way"),"[FAIL] Contact with phone number <10 chars created.");
		System.out.println("[SUCCESS] Contact with phone number <10 chars disallowed!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Phone >10 Chars Test")
	@Order(8)
	void contactLongPhoneTest() {
		System.out.println("[TEST] Attempting to create contact with phone number >10 chars...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nye","15555555555","123 Science Guy Way"),"[FAIL] Contact with phone number >10 chars created. ");
		System.out.println("[SUCCESS] Contact with phone number >10 chars disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Phone NULL Test")
	@Order(9)
	void contactNullPhoneTest() {
		System.out.println("[TEST] Attempting to create contact with NULL phone number...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nye",null,"123 Science Guy Way"),"[FAIL] Contact with NULL phone number created.");
		System.out.println("[SUCCESS] Contact with NULL phone number disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Address >30 Chars Test")
	@Order(10)
	void contactLongAddressTest() {
		System.out.println("[TEST] Attempting to create contact with address >30 chars...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nye","5555555555","123 Science Guy Way, Boston, MA, USA, Earth, Solar System"),"[FAIL] Contact with address >30 chars created.");
		System.out.println("[SUCCESS] Contact with address >30 chars disallowed!");
		System.out.println();
	}
	
	/** 
	* The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
	*/
	@Test
	@DisplayName("Contact Address NULL Test")
	@Order(11)
	void contactNullAddressTest() {
		System.out.println("[TEST] Attempting to create contact with NULL address...");
		assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890","Bill","Nye","5555555555",null),"[FAIL] Contact with NULL address created.");
		System.out.println("[SUCCESS] Contact with NULL address disallowed!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Get Contact ID Test")
	@Order(12)
	void contactGetIDTest() {
		System.out.println("[TEST] Creating a contact and querying its ID...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not query contact ID.",() -> testContact.getID());
		System.out.println("[SUCCESS] Contact ID successfully queried!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Get First Name Test")
	@Order(13)
	void contactGetFirstNameTest() {
		System.out.println("[TEST] Creating a contact and querying its first name...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not query contact first name.", () -> testContact.getFirstName());
		System.out.println("[SUCCESS] Contact first name successfully queried!");
		System.out.println();
	}

	@Test
	@DisplayName("Contact Get Last Name Test")
	@Order(14)
	void contactGetLastNameTest() {
		System.out.println("[TEST] Creating a contact and querying its last name...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not query contact last name.", () -> testContact.getLastName());
		System.out.println("[SUCCESS] Contact last name successfully queried!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Get Phone Number Test")
	@Order(15)
	void contactGetPhoneTest() {
		System.out.println("[TEST] Creating a contact and querying its phone number...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not query contact phone number.", () -> testContact.getPhone());
		System.out.println("[SUCCESS] Contact phone number successfully queried!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Get Address Test")
	@Order(16)
	void contactGetAddressTest() {
		System.out.println("[TEST] Creating a contact and querying its address...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not query contact address.", () -> testContact.getAddress());
		System.out.println("[SUCCESS] Contact address successfully queried!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Set First Name Test")
	@Order(17)
	void contactSetFirstNameTest() {
		System.out.println("[TEST] Creating a contact and changing its first name...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not set contact first name.", () -> testContact.setFirstName("William"));
		System.out.println("[SUCCESS] Contact first name successfully changed!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Set Last Name Test")
	@Order(18)
	void contactSetLastNameTest() {
		System.out.println("[TEST] Creating a contact and changing its last name...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not set contact last name.", () -> testContact.setLastName("SciGuy"));
		System.out.println("[SUCCESS] Contact last name successfully changed!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Set Phone Number Test")
	@Order(19)
	void contactSetPhoneTest() {
		System.out.println("[TEST] Creating a contact and changing its phone number...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not set contact phone number.", () -> testContact.setPhone("1111111111"));
		System.out.println("[SUCCESS] Contact phone number successfully changed!");
		System.out.println();
	}
	
	@Test
	@DisplayName("Contact Set Address Test")
	@Order(20)
	void contactSetAddressTest() {
		System.out.println("[TEST] Creating a contact and changing its address...");
		Contact testContact = new Contact("1234567890","Bill","Nye","5555555555","1 SciGuy Way");
		assertAll("[FAIL] Could not set contact address.", () -> testContact.setAddress("Boston,MA"));
		System.out.println("[SUCCESS] Contact address successfully changed!");
		System.out.println();
	}
}
