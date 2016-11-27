package ArchPrototype;

/**
 * Portfolio.java  - Holds an investors collection of stocks in a hashmap
 * @author - TeamJ
 */
import java.util.HashMap;
import java.util.Set;

public class Portfolio {
	
	private HashMap portfolio = new HashMap();
	private int count, totalShares;
	private double value;
	
	/**
	 * default constructor - sets values for empty hashmap
	 */
	public Portfolio() {
		count = 0;
		totalShares = 0;
		value = 0.00;
	}
	/**
	 * returns the requested stock by key which is the ticker symbol
	 * @param ticker_in
	 * @return
	 */
	public Stock getStock(String ticker_in) {
		 Stock report =  (Stock) portfolio.get(ticker_in);
		 return report;	 
	}
	/**
	 * returns the number of stocks held.
	 * 
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * returns the total number of shares held
	 * 
	 * @return totalShares
	 */
	public int getShares() {
		return totalShares;
	}
	/**
	 * returns the value of the portfolio
	 * 
	 * @return value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * sets the value of count manually
	 * 
	 * @param count_in
	 */
	public void setCount(int count_in) {
		count = count_in;
	}
	/**
	 * Sets the value of totalShares manually
	 * 
	 * @param totalShares_in
	 */
	public void setTotalShares( int totalShares_in) {
		totalShares = totalShares_in;
	}
	/**
	 * Sets the value of value manually
	 * 
	 * @param value_in
	 */
	public void setValue (double value_in) {
		value = value_in;
	}
	/**
	 * adds a stock to the portfolio and updates the value and total number of shares
	 * 
	 * @param ticker_in
	 * @param shares_in
	 * @param value_in
	 * @param stock_in
	 */
	public void addStock(String ticker_in, int shares_in, double value_in, Stock stock_in) {
		portfolio.put(ticker_in,  stock_in);
		count ++;
		totalShares += shares_in;
		value += value_in;
	}
	/**
	 * removes a stock from the portfolio, and updates the value and total number of shares.
	 * 
	 * @param ticker_in
	 * @param shares_in
	 * @param value_in
	 */
	public void removeStock(String ticker_in, int shares_in, double value_in) {
		portfolio.remove(ticker_in);
		count --;
		totalShares -= shares_in;
		value -= value_in;
	}
	/**
	 * returns a string of the keys in the portfolio hashmap
	 * 
	 * @return keys_out
	 */
	public String getKeys() {
		Set keys = portfolio.keySet();
		String keys_out = keys.toString();
		return keys_out;
	}
	/**
	 * checks if a stock exists in a users portfolio
	 * 
	 * @param ticker_in
	 * 
	 * @return hasKey
	 */
	public boolean hasKey(String ticker_in) {
		boolean hasKey = portfolio.containsKey(ticker_in);
		return hasKey;
	}
	@Override
	public String toString() {
		return "Portfolio [portfolio=" + portfolio + ", totalShares=" + totalShares + ", value="
				+ value + "]";
	}
	
}
