package ArchPrototype;

/** 
 *  Stock.java  An object to hold information about a stock
 *  
 * @author TeamJ
 * 
 *
 */
import java.text.NumberFormat;

public class Stock {
	
	private String companyName = "";
	private String ticker = "";
	private double price = 0.00;
	private int shares = 0;
	private double value = 0.00;
	/**
	 * default constructor
	 */
	public Stock () {
		companyName = "default";
		ticker = "";
		price = 0.00;
		shares = 0;
	}
	/**
	 * constructor
	 * @param companyName_in
	 * @param ticker_in
	 * @param price_in
	 */
	
	public Stock(String companyName_in, String ticker_in, double price_in, int shares_in) {
		companyName = companyName_in;
		ticker = ticker_in;
		price = price_in;
		shares = shares_in;
	}
	/**
	 * accessor for companyName.
	 * @return companyName
	 */
	public String getCompanyName () {
		return companyName;
	}
	/**
	 * accessor for ticker
	 * @return ticker
	 */
	public String getTicker () {
		return ticker;
	}
	/**
	 * accessor for price
	 * @return price
	 */
	public double getPrice () {
		return price;
	}
	/**
	 * accessor for shares
	 * @return shares
	 */
	public int getShares() {
		return shares;
	}
	/**
	 * computes and returns the value of the shares of stock an investor ownes
	 * 
	 * @return value
	 */
	public double getValue() {
		double temp_price = this.getPrice();
		int temp_shares = this.getShares();
		value = temp_price * temp_shares;
		return value;
		
	}
	/**
	 * setter for companyName
	 * @param companyName_in
	 */
	public void setCompanyName (String companyName_in) {
		companyName = companyName_in;
	}
	/**
	 * setter for ticker
	 * @param ticker_in
	 */
	public void setTicker (String ticker_in) {
		ticker = ticker_in;
	}
	/**
	 * setter for price
	 * @param price_in
	 */
	public void setPrice (double price_in) {
		price = price_in;
	}
	public void setShares (int shares_in) {
		shares = shares_in;
	}
	public void setValue (double value_in) {
		value = value_in;
	}
	/**
	 * returns a string describing the stock
	 */
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String report = "";
		report = companyName + " " + ticker + " " + fmt.format(price) + " " + shares + "\n";
		return report;
	}

}

