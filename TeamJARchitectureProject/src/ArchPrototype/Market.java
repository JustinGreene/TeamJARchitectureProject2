package ArchPrototype;

import java.util.HashMap;
import java.util.Set;
/**
 * Market.java - Class to hold a hashmap of stocks available.
 * 
 * @author TeamJ
 *
 */
public class Market {
	
	private HashMap market = new HashMap();
	
	/**
	 * default constructor
	 */
	public Market() {
		
	}
	/**
	 * returns a specific stock based on ticker symbol
	 * 
	 * @param ticker_in
	 * @return
	 */
	public Stock getStock(String ticker_in) {
		Stock report = new Stock();
		report = (Stock) market.get(ticker_in);
		return report;
	}
	/**
	 * adds a new stock to the market
	 * 
	 * @param ticker_in
	 * @param stock_in
	 */
	public void addStock(String ticker_in, Stock stock_in) {
		market.put(ticker_in,  stock_in);
	}
	/** removes a stock from the market
	 * 
	 * @param ticker_in
	 */
	public void removeStock(String ticker_in) {
		market.remove(ticker_in);
	}
	/**
	 * returns a string of the key values of market hashmap
	 * @return
	 */
	public String getKeys() {
		Set keys = market.keySet();
		String keys_out = keys.toString();
		return keys_out;
	}
	/**
	 * checks to see if the stock exists in the market.
	 * 
	 * @param key_in
	 * 
	 * @return hasKey
	 */
	public boolean hasKey(String key_in) {
		boolean hasKey = market.containsKey(key_in);
		return hasKey;
	}
}
