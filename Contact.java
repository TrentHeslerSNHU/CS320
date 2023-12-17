/**
 * Trent Hesler
 * CS 320 - Software Test Automation & QA
 * 12/2/23
 * 6-1 Project One
 */
package ContactService;

public class Contact {
	private final String ID;
	private String firstName;
	private String lastName;
	private String phone;
	private String Address;
	
	/**
	 * Contact constructor method
	 * @param newID - New ID for the contact
	 * @param newFirstName - New first name for the contact
	 * @param newLastName - New last name for the contact
	 * @param newPhone - New phone number for the contact
	 * @param newAddress - New address for the contact
	 */
	public Contact(String newID, String newFirstName, String newLastName, String newPhone, String newAddress) {
		
		/**-The contact object shall have a required unique contact ID string that cannot be longer than 10 characters.
		 *  The contact ID shall not be null and shall not be updatable.
		 */
		try{
			if (newID.length() <= 10) {
				this.ID = newID;
			}
			else {
				throw new IllegalArgumentException("[ERROR] Invalid contact ID.");
			}
		} catch (NullPointerException err) {
			throw new IllegalArgumentException("[ERROR] Contact ID cannot be null.");
		}
		
		/**-The contact object shall have a required firstName String field that cannot be longer than 10 characters.
		 *  The firstName field shall not be null.
		 */
		try {
			if(newFirstName.length() <= 10) {
				this.firstName = newFirstName;
			} else {
				throw new IllegalArgumentException("[ERROR] Invalid contact first name.");
			}
		} catch (NullPointerException err) {
			throw new IllegalArgumentException("[ERROR] Contact first name cannot be null.");
		}
			
		/**-The contact object shall have a required lastName String field that cannot be longer than 10 characters.
		 *  The lastName field shall not be null.
		 */
		try {
			if (newLastName.length() <= 10) {
				this.lastName = newLastName;
			}
			else {
				throw new IllegalArgumentException("[ERROR] Invalid contact last name.");
			}
		} catch (NullPointerException err) {
			throw new IllegalArgumentException("[ERROR] Contact last name cannot be null.");
		}
		
		/**-The contact object shall have a required phone String field that must be exactly 10 digits.
		 *  The phone field shall not be null.
		 */
		try {
			if (newPhone.length() == 10) {
				this.phone = newPhone;
			}
			else {
				throw new IllegalArgumentException("[ERROR] Invalid contact phone number.");
			}
		} catch (NullPointerException err) {
			throw new IllegalArgumentException("[ERROR] Contact phone number cannot be null.");
		}
		
		/**-The contact object shall have a required address field that must be no longer than 30 characters.
		 *  The address field shall not be null.
		 */
		try {
			if (newAddress.length() <= 30) {
				this.Address = newAddress;
			}
			else {
				throw new IllegalArgumentException("[ERROR] Invalid contact address.");
			}
		} catch (NullPointerException err) {
			throw new IllegalArgumentException("[ERROR] Contact address cannot be null.");
		}
		
		System.out.println("[INFO] Created new contact '" + this.firstName + " " + this.lastName + "' with ID " + this.ID + ".");
	}
	
	/**
	 * Method to get a contact's ID
	 * @return contactID - The unique ID for the contact, or null if the contact doesn't exist.
	 */
	public String getID() {
		try {
			//Assign this string just to see if it throws a null pointer exception
			String contactID = ID;
			
			//If not, return the contact ID
			return contactID;
		} catch (NullPointerException err) {
			System.out.println("[ERROR] Contact does not exist.");
			return null;
		}
	}
	
	/**
	 * Method to get contact's first name
	 * @return firstName - Contact's first name
	 */
	public String getFirstName() {
		return firstName;
	}
		

	/**
	 * Method to get contact's last name
	 * @return lastName - Contact's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Method to get contact's phone number
	 * @return phone - Contact's phone number
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Method to get contact's address
	 * @return Address - Contact's address
	 */
	public String getAddress() {
		return Address;
	}
	
	/**
	 * Method to change contact first name.
	 * @param newFirstName - New first name for contact
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	/**
	 * Method to change contact last name.
	 * @param newLastName - New last name for contact
	 */
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	/**
	 * Method to change contact phone number
	 * @param newPhone - New phone number for contact
	 */
	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}
	
	/**
	 * Method to change contact address
	 * @param newAddress - New address for contact
	 */
	public void setAddress(String newAddress) {
		this.Address = newAddress;
	}
}