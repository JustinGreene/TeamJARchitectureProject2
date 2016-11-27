package ArchPrototype;

import java.text.NumberFormat;

import ArchPrototype.Portfolio;

/**
 * Investor.java - Holds the investor or user information
 * 
 * @author TeamJ
 * 
 *
 */
public class Investor {
	
	private String firstName = "";
	private String lastName = "";
	private String userID = "";
	private String password = "";
	private double walletAmt = 0.00;
	private double portfolioValue = 0.00;
	private Portfolio portfolio = new Portfolio();
	
	/**
	 * default constructor for Investor
	 */
	public Investor() {
		firstName = "";
		lastName = "";
		userID = "";
		password = "";
		walletAmt = 0.00;
		portfolioValue = 0.00;
	}
	/**
	 * constructor for Investor
	 * 
	 * @param firstName_in
	 * @param lastName_in
	 * @param userID_in
	 * @param password_in
	 * @param walletAmt_in
	 * @param portfolioValue_in
	 */
	public Investor(String firstName_in, String lastName_in, String userID_in, String password_in, double walletAmt_in, double portfolioValue_in, Portfolio portfolio_in) {
		firstName = firstName_in;
		lastName = lastName_in;
		userID = userID_in;
		password = password_in;
		walletAmt = walletAmt_in;
		portfolioValue = portfolioValue_in;
		portfolio = portfolio_in;
	}
	/**
	 * accessor for first name
	 * 
	 * @return firstName
	 */
	public String getFirstName () {
		return firstName;
	}
	/**
	 * accessor for lastName
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * accessor for userID
	 * 
	 * @return userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * accessor for password
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * accessor for walletAmt
	 * 
	 * @return walletAmt
	 */
	public double getWalletAmt() {
		return walletAmt;
	}
	/**
	 * accessor for portfolioValue
	 * 
	 * @return portfolioValue
	 */
	public double getPortfolioValue() {
		return portfolioValue;
	}
	/**
	 * accessor for portfolio
	 * 
	 * @return portfolio
	 */
	public Portfolio getPortfolio() {
		return portfolio;
	}
	/**
	 * setter for fisrtName
	 * 
	 * @param firstName_in
	 */
	public void setFirstName(String firstName_in) {
		firstName = firstName_in;
	}
	/**
	 * setter for lastName
	 * 
	 * @param lastName_in
	 */
	public void setLastName(String lastName_in) {
		lastName = lastName_in;
	}
	/**
	 * setter for password
	 * 
	 * @param password_in
	 */
	public void setPassword(String password_in) {
		password = password_in;
	}
	/**
	 * setter for userID
	 * 
	 * @param userID_in
	 */
	public void setUserID(String userID_in) {
		userID = userID_in;
	}
	/**
	 * setter for walletAmt
	 * 
	 * @param walletAmt_in
	 */
	public void setWalletAmt(double walletAmt_in) {
		walletAmt = walletAmt_in;
	}
	/**
	 * setter for portfolioValue
	 * 
	 * @param portfolioValue_in
	 */
	public void setPortfolioValue(double portfolioValue_in) {
		portfolioValue = portfolioValue_in;
	}
	/**
	 * setter for portfolio
	 * 
	 * @param portfolio_in
	 */
	public void setPortfolio(Portfolio portfolio_in) {
		portfolio = portfolio_in;
	}
	
	/**
	 * returns a string representation of the investor
	 * 
	 * @return report
	 */
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String report = "firstName = " + firstName + " lastName = " + lastName + " userID = " + userID + " password = " + password + " walletAmt = " + fmt.format(walletAmt) + " portfolioValue = " + fmt.format(portfolioValue) + " " + portfolio.toString();
		return report;
	}
	

}

