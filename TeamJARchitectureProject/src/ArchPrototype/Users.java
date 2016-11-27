package ArchPrototype;

import java.util.HashMap;
import java.util.Set;

/**
 * Class to hold all the users and passwords in a hashmap for validation on the user 
 * 
 * @author TeamJ
 *
 */
public class Users {
	
	private HashMap userMap = new HashMap();
	
	/**
	 * adds an investor to the user database
	 * 
	 * @param userID_in
	 * @param investor_in
	 */
	public void addUser (String userID_in, Investor investor_in) {
		userMap.put(userID_in, investor_in);
	}
	/**
	 * removes an investor from the user database
	 * @param userID_in
	 */
	public void removeUser (String userID_in) {
		userMap.remove(userID_in);
	}
	/**
	 * returns an Investor object
	 * 
	 * @param userID_in
	 * @return report
	 */
	public Investor getUser(String userID_in) {
		Investor report = (Investor) userMap.get(userID_in);
		return report;
	}
	/**
	 * checks to see if entered userID and password matches information in user hashmap
	 * 
	 * @param userID_in
	 * @param password_in
	 * @return result
	 */
	public boolean validateUser (String userID_in, String password_in) {
		Investor validate = (Investor) userMap.get(userID_in);
		String comp_password = validate.getPassword();
		boolean result = (password_in.equals(comp_password));
		return result;
	}
	/**
	 * returns a string value of keys in the hashmap
	 * 
	 * @return keys_out
	 */
	public String getKeys() {
		Set keys = userMap.keySet();
		String keys_out = keys.toString();
		return keys_out;
	
	}
	/**
	 * checks to see if user exists in database
	 * 
	 * @param key_in
	 * 
	 * @return hasKey
	 */
	public boolean hasKey(String key_in) {
		boolean hasKey = userMap.containsKey(key_in);
		return hasKey;
	}
	@Override
	public String toString() {
		return "Users [userMap=" + userMap + "]";
	}

}
