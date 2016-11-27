package ArchPrototype;

import java.awt.EventQueue;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

/**
 * Simple stripped down GUI application to assist in the architecture prototype
 * 
 * @author TeamJ
 *
 */
public class ArchitectureGUI {

	private JFrame frame;
	private JTextField textFieldLoginUserName;
	private JTextField textFieldLoginPassword;
	private static Stock stock1;
	private static Stock stock2;
	private static Stock stock3;
	private static Portfolio portfolio1, portfolio2, portfolio3;
	private static Investor investor1, investor2, investor3;
	private static Users usermap;
	private static Market market1;
	private JTextField textFieldHomePageName;
	private JTextField textFieldHomePageWalletAmt;
	private JTextField textFieldHomePagePortfolioValue;
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	private JTextField textFieldPortShares;
	private JTextField textFieldPortValue;
	private JTextField textFieldPortContents;
	private JTextField textFieldTickerSearch;
	private JTextField textFieldSearchCoName;
	private JTextField textFieldSearchTicker;
	private JTextField textFieldSearchPrice;
	private JTextField textFieldInfoCoName;
	private JTextField textFieldInfoTicker;
	private JTextField textFieldInfoPrice;
	private JTextField textFieldInfoQuantity;
	private static String hold_userID = "";
	private static double purchase_price = 0.00;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		stock1 = new Stock("Stars and Bucks", "STB", 34.58, 25);
		stock2 = new Stock("Harvey Price Inc.", "HPI", 15.74, 50);
		stock3 = new Stock("Ritzy Cracker Company", "RCC", 5.64, 25);
		
		portfolio1 = new Portfolio();
		portfolio1.addStock("STB", 25, 864.5, stock1);
		portfolio1.addStock("HPI",  40,  629.60,  stock2);
		portfolio1.getValue();
		portfolio2 = new Portfolio();
		portfolio2.addStock("RCC", 65,  366.60, stock3);
		portfolio2.addStock("STB",  85,  2939.30,  stock1);
		portfolio2.getValue();
		portfolio3 = new Portfolio();
		portfolio3.addStock("RCC", 30,  169.20, stock3);
		portfolio3.addStock("STB",  45,  1556.10,  stock1);
		portfolio3.addStock("HPI",  65,  1023.10,  stock2);
		portfolio3.getValue();
		
		investor1 = new Investor("Fred", "Mertz", "FredM", "ethel", 587.25, 1494.10, portfolio1);
		investor2 = new Investor("Judy", "Sheindlan", "JudgeJ", "wapner", 1587.12, 3305.90, portfolio2);
		investor3 = new Investor("James", "Kirk", "CaptainKirk", "spock", 5487.96, 2748.40, portfolio3);
		
		usermap = new Users();
		usermap.addUser("FredM", investor1);
		usermap.addUser("JudgeJ", investor2);
		usermap.addUser("CaptainKirk", investor3);
		
		market1 = new Market();
		market1.addStock("STB", stock1);
		market1.addStock("HPI", stock2);
		market1.addStock("RCC", stock3);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArchitectureGUI window = new ArchitectureGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArchitectureGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel Login = new JPanel();
		Login.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(Login, "name_92765429242672");
		Login.setLayout(null);
		
		
		
		JPanel HomePage = new JPanel();
		HomePage.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(HomePage, "name_92785163492455");
		HomePage.setLayout(null);
		
		JPanel Portfolio = new JPanel();
		Portfolio.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(Portfolio, "name_92812364860315");
		Portfolio.setLayout(null);
		
		JPanel Search = new JPanel();
		Search.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(Search, "name_92837815638219");
		Search.setLayout(null);
		
		JPanel Info = new JPanel();
		Info.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(Info, "name_92865916467277");
		Info.setLayout(null);
		
		JTextArea txtrSearch = new JTextArea();
		txtrSearch.setBackground(new Color(0, 128, 0));
		txtrSearch.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrSearch.setText("Search");
		txtrSearch.setBounds(21, 28, 228, 35);
		Search.add(txtrSearch);
		
		JButton btnSearchHomeButton = new JButton("Home Page");
		btnSearchHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search.setVisible(false);
				HomePage.setVisible(true);
			}
		});
		btnSearchHomeButton.setBounds(382, 34, 109, 49);
		Search.add(btnSearchHomeButton);
		
		JButton btnSearchPortfolioButton = new JButton("Portfolio");
		btnSearchPortfolioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.setVisible(false);
				Portfolio.setVisible(true);
			}
		});
		btnSearchPortfolioButton.setBounds(528, 34, 109, 49);
		Search.add(btnSearchPortfolioButton);
		
		JTextArea txtrEnterTickerSymbol = new JTextArea();
		txtrEnterTickerSymbol.setLineWrap(true);
		txtrEnterTickerSymbol.setWrapStyleWord(true);
		txtrEnterTickerSymbol.setText("Enter Ticker Symbol to Search Accepted Symbols are STB, HPI, and RCC");
		txtrEnterTickerSymbol.setBounds(31, 74, 246, 60);
		Search.add(txtrEnterTickerSymbol);
		
		textFieldTickerSearch = new JTextField();
		textFieldTickerSearch.setBounds(111, 174, 86, 20);
		Search.add(textFieldTickerSearch);
		textFieldTickerSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sTicker_in = textFieldTickerSearch.getText();
				boolean is_stock = market1.hasKey(sTicker_in);
				if (is_stock) {
					Stock current_stock = market1.getStock(sTicker_in);
					textFieldSearchCoName.setText(current_stock.getCompanyName());
					textFieldSearchTicker.setText(current_stock.getTicker());
					double temp_Dprice = current_stock.getPrice();
					purchase_price = temp_Dprice;
					textFieldSearchPrice.setText(fmt.format(temp_Dprice));
					textFieldInfoCoName.setText(current_stock.getCompanyName());
					textFieldInfoTicker.setText(current_stock.getTicker());
					textFieldInfoPrice.setText(fmt.format(temp_Dprice));
				}
				else {
					textFieldSearchCoName.setText("That ticker symbol is not on file. Please try again");
				}
			
			}
		});
		btnSearch.setBounds(96, 235, 138, 54);
		Search.add(btnSearch);
		
		JTextArea txtrResults = new JTextArea();
		txtrResults.setBackground(new Color(0, 128, 0));
		txtrResults.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrResults.setText("Results");
		txtrResults.setBounds(474, 145, 80, 22);
		Search.add(txtrResults);
		
		JTextArea txtrCompanyName = new JTextArea();
		txtrCompanyName.setBackground(new Color(0, 128, 0));
		txtrCompanyName.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrCompanyName.setText("Company Name");
		txtrCompanyName.setBounds(346, 185, 109, 22);
		Search.add(txtrCompanyName);
		
		textFieldSearchCoName = new JTextField();
		textFieldSearchCoName.setBounds(346, 212, 350, 20);
		Search.add(textFieldSearchCoName);
		textFieldSearchCoName.setColumns(10);
		
		JTextArea txtrTickerSymbol = new JTextArea();
		txtrTickerSymbol.setText("Ticker Symbol");
		txtrTickerSymbol.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrTickerSymbol.setBackground(new Color(0, 128, 0));
		txtrTickerSymbol.setBounds(346, 238, 109, 22);
		Search.add(txtrTickerSymbol);
		
		textFieldSearchTicker = new JTextField();
		textFieldSearchTicker.setColumns(10);
		textFieldSearchTicker.setBounds(346, 269, 350, 20);
		Search.add(textFieldSearchTicker);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setText("Price");
		txtrPrice.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPrice.setBackground(new Color(0, 128, 0));
		txtrPrice.setBounds(346, 300, 109, 22);
		Search.add(txtrPrice);
		
		textFieldSearchPrice = new JTextField();
		textFieldSearchPrice.setColumns(10);
		textFieldSearchPrice.setBounds(346, 332, 350, 20);
		Search.add(textFieldSearchPrice);
		
		JButton btnSearchInfoButton = new JButton("Info");
		btnSearchInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search.setVisible(false);
				Info.setVisible(true);
				
			}
		});
		btnSearchInfoButton.setBounds(465, 385, 127, 49);
		Search.add(btnSearchInfoButton);
		Search.setVisible(false);
		
		
		
		JTextArea txtrInfo = new JTextArea();
		txtrInfo.setBackground(new Color(0, 128, 0));
		txtrInfo.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrInfo.setText("Info");
		txtrInfo.setBounds(39, 40, 119, 40);
		Info.add(txtrInfo);
		
		JTextArea txtrBuySell = new JTextArea();
		txtrBuySell.setBackground(new Color(0, 128, 0));
		txtrBuySell.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrBuySell.setText("Purchase Shares");
		txtrBuySell.setBounds(505, 156, 167, 22);
		Info.add(txtrBuySell);
		
		JTextArea txtrCompanyName_1 = new JTextArea();
		txtrCompanyName_1.setBackground(new Color(0, 128, 0));
		txtrCompanyName_1.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrCompanyName_1.setText("Company Name");
		txtrCompanyName_1.setBounds(39, 116, 209, 22);
		Info.add(txtrCompanyName_1);
		
		JTextArea txtrTickerSymbol_1 = new JTextArea();
		txtrTickerSymbol_1.setBackground(new Color(0, 128, 0));
		txtrTickerSymbol_1.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrTickerSymbol_1.setText("Ticker Symbol");
		txtrTickerSymbol_1.setBounds(39, 211, 209, 22);
		Info.add(txtrTickerSymbol_1);
		
		JTextArea txtrPrice_1 = new JTextArea();
		txtrPrice_1.setBackground(new Color(0, 128, 0));
		txtrPrice_1.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPrice_1.setText("Price");
		txtrPrice_1.setBounds(39, 306, 209, 22);
		Info.add(txtrPrice_1);
		
		JTextArea txtrQuantity = new JTextArea();
		txtrQuantity.setBackground(new Color(0, 128, 0));
		txtrQuantity.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrQuantity.setText("Quantity");
		txtrQuantity.setBounds(507, 211, 209, 22);
		Info.add(txtrQuantity);
		
		textFieldInfoCoName = new JTextField();
		textFieldInfoCoName.setBounds(39, 161, 209, 20);
		Info.add(textFieldInfoCoName);
		textFieldInfoCoName.setColumns(10);
		
		textFieldInfoTicker = new JTextField();
		textFieldInfoTicker.setBounds(39, 251, 209, 20);
		Info.add(textFieldInfoTicker);
		textFieldInfoTicker.setColumns(10);
		
		textFieldInfoPrice = new JTextField();
		textFieldInfoPrice.setText("");
		textFieldInfoPrice.setBounds(39, 350, 209, 20);
		Info.add(textFieldInfoPrice);
		textFieldInfoPrice.setColumns(10);
		
		textFieldInfoQuantity = new JTextField();
		textFieldInfoQuantity.setBounds(509, 265, 86, 20);
		Info.add(textFieldInfoQuantity);
		textFieldInfoQuantity.setColumns(10);
		
		JButton btnInfoBuyButton = new JButton("Buy Shares");
		btnInfoBuyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str_purchase_quantity = textFieldInfoQuantity.getText();
				int int_purchase_quantity = Integer.parseInt(str_purchase_quantity);
				Investor purchase_investor = new Investor();
				Portfolio purchase_portfolio = new Portfolio();
				Stock purchase_stock = new Stock();
				purchase_investor = usermap.getUser(hold_userID);
				purchase_portfolio = purchase_investor.getPortfolio();
				String active_ticker = textFieldInfoTicker.getText();
				boolean in_port = purchase_portfolio.hasKey(active_ticker);
				if (in_port) {
					purchase_stock = purchase_portfolio.getStock(active_ticker);
					int temp_shares = int_purchase_quantity + purchase_stock.getShares();
					purchase_stock.setShares(temp_shares);
					double temp_value = purchase_stock.getValue();
					double update_value = int_purchase_quantity * purchase_stock.getPrice();
					double temp_wallet = purchase_investor.getWalletAmt() - update_value;
					purchase_investor.setWalletAmt(temp_wallet);
					purchase_stock.setValue(temp_value);
					purchase_portfolio.addStock(active_ticker, int_purchase_quantity, update_value, purchase_stock);
					purchase_investor.setPortfolio(purchase_portfolio);
					usermap.addUser(hold_userID, purchase_investor);
					textFieldPortShares.setText(Integer.toString(purchase_portfolio.getShares()));
					textFieldPortValue.setText(fmt.format(purchase_portfolio.getValue()));
					textFieldPortContents.setText(purchase_portfolio.toString()); 
					textFieldHomePageWalletAmt.setText(fmt.format(purchase_investor.getWalletAmt()));
					textFieldHomePagePortfolioValue.setText(fmt.format(purchase_portfolio.getValue()));
				}
				else {
					
					purchase_stock.setShares(int_purchase_quantity);
					purchase_stock.setCompanyName(textFieldInfoCoName.getText());
					purchase_stock.setTicker(textFieldInfoTicker.getText());
					purchase_stock.setPrice(purchase_price);
					double temp_price = purchase_stock.getPrice();
					double temp_value = int_purchase_quantity * temp_price;
					purchase_stock.setValue(temp_value);
					purchase_portfolio.addStock(active_ticker, int_purchase_quantity, temp_value, purchase_stock);
					purchase_investor.setPortfolio(purchase_portfolio);
					usermap.addUser(hold_userID, purchase_investor);
					textFieldPortShares.setText(Integer.toString(purchase_portfolio.getShares()));
					textFieldPortValue.setText(fmt.format(purchase_portfolio.getValue()));
					textFieldPortContents.setText(purchase_portfolio.toString()); 
					textFieldHomePageWalletAmt.setText(fmt.format(purchase_investor.getWalletAmt()));
					textFieldHomePagePortfolioValue.setText(fmt.format(purchase_portfolio.getValue()));
						
				}
				
			
			}
		});
		btnInfoBuyButton.setBounds(512, 320, 126, 50);
		Info.add(btnInfoBuyButton);
		
		JButton btnInfoHomeButton = new JButton("Home");
		btnInfoHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info.setVisible(false);
				HomePage.setVisible(true);
			}
		});
		btnInfoHomeButton.setBounds(449, 40, 100, 40);
		Info.add(btnInfoHomeButton);
		
		JButton btnInfoPortfolioButton = new JButton("Portfolio");
		btnInfoPortfolioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info.setVisible(false);
				Portfolio.setVisible(true);
			}
		});
		btnInfoPortfolioButton.setBounds(598, 40, 100, 40);
		Info.add(btnInfoPortfolioButton);
		Info.setVisible(false);
		
		JPanel Instructions = new JPanel();
		Instructions.setBackground(new Color(0, 128, 0));
		frame.getContentPane().add(Instructions, "name_92913394925067");
		Instructions.setLayout(null);
		Instructions.setVisible(false);
		
		JPanel InvalidLogin = new JPanel();
		InvalidLogin.setBackground(new Color(139, 0, 0));
		frame.getContentPane().add(InvalidLogin, "name_95583461687363");
		InvalidLogin.setLayout(null);
		
		JTextArea txtrHomePage = new JTextArea();
		txtrHomePage.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrHomePage.setBackground(new Color(0, 128, 0));
		txtrHomePage.setText("Home Page");
		txtrHomePage.setBounds(49, 36, 190, 22);
		HomePage.add(txtrHomePage);
		
		JTextArea txtrHello = new JTextArea();
		txtrHello.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrHello.setBackground(new Color(0, 128, 0));
		txtrHello.setText("Hello");
		txtrHello.setBounds(60, 87, 49, 22);
		HomePage.add(txtrHello);
		
		textFieldHomePageName = new JTextField();
		textFieldHomePageName.setBounds(203, 89, 167, 20);
		HomePage.add(textFieldHomePageName);
		textFieldHomePageName.setColumns(10);
		
		JTextArea txtrWalletAmount = new JTextArea();
		txtrWalletAmount.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrWalletAmount.setBackground(new Color(0, 128, 0));
		txtrWalletAmount.setText("Wallet Amount");
		txtrWalletAmount.setBounds(24, 153, 114, 22);
		HomePage.add(txtrWalletAmount);
		
		textFieldHomePageWalletAmt = new JTextField();
		textFieldHomePageWalletAmt.setBounds(203, 155, 135, 20);
		HomePage.add(textFieldHomePageWalletAmt);
		textFieldHomePageWalletAmt.setColumns(10);
		
		JTextArea txtrPortfolioValue = new JTextArea();
		txtrPortfolioValue.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPortfolioValue.setBackground(new Color(0, 128, 0));
		txtrPortfolioValue.setText("Portfolio Value");
		txtrPortfolioValue.setBounds(24, 225, 128, 22);
		HomePage.add(txtrPortfolioValue);
		
		textFieldHomePagePortfolioValue = new JTextField();
		textFieldHomePagePortfolioValue.setBounds(203, 227, 135, 20);
		HomePage.add(textFieldHomePagePortfolioValue);
		textFieldHomePagePortfolioValue.setColumns(10);
		
		JButton btnHomePageSearchButton = new JButton("Search");
		btnHomePageSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(false);
				Search.setVisible(true);
			}
		});
		btnHomePageSearchButton.setBounds(167, 330, 135, 52);
		HomePage.add(btnHomePageSearchButton);
		
		JButton btnHomePagePortfolioButton = new JButton("Portfolio");
		btnHomePagePortfolioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage.setVisible(false);
				Portfolio.setVisible(true);
			}
		});
		btnHomePagePortfolioButton.setBounds(447, 330, 135, 52);
		HomePage.add(btnHomePagePortfolioButton);
		HomePage.setVisible(false);
		
		
		
		JTextArea txtrPortfolio = new JTextArea();
		txtrPortfolio.setBackground(new Color(0, 128, 0));
		txtrPortfolio.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrPortfolio.setText("Portfolio");
		txtrPortfolio.setBounds(10, 33, 167, 32);
		Portfolio.add(txtrPortfolio);
		
		JTextArea txtrTotalShares = new JTextArea();
		txtrTotalShares.setBackground(new Color(0, 128, 0));
		txtrTotalShares.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrTotalShares.setText("Total Shares");
		txtrTotalShares.setBounds(21, 90, 105, 22);
		Portfolio.add(txtrTotalShares);
		
		JTextArea txtrValue = new JTextArea();
		txtrValue.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrValue.setBackground(new Color(0, 128, 0));
		txtrValue.setText("Value");
		txtrValue.setBounds(21, 137, 105, 22);
		Portfolio.add(txtrValue);
		
		JTextArea txtrContents = new JTextArea();
		txtrContents.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrContents.setBackground(new Color(0, 128, 0));
		txtrContents.setText("Contents");
		txtrContents.setBounds(21, 182, 105, 22);
		Portfolio.add(txtrContents);
		
		textFieldPortShares = new JTextField();
		textFieldPortShares.setBounds(151, 92, 86, 20);
		Portfolio.add(textFieldPortShares);
		textFieldPortShares.setColumns(10);
		
		textFieldPortValue = new JTextField();
		textFieldPortValue.setColumns(10);
		textFieldPortValue.setBounds(151, 139, 86, 20);
		Portfolio.add(textFieldPortValue);
		
		JButton btnPortHomeButton = new JButton("Home Page");
		btnPortHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Portfolio.setVisible(false);
				HomePage.setVisible(true);
			}
		});
		btnPortHomeButton.setBounds(474, 71, 115, 41);
		Portfolio.add(btnPortHomeButton);
		
		JButton btnPortSearch = new JButton("Search");
		btnPortSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Portfolio.setVisible(false);
				Search.setVisible(true);
			}
		});
		btnPortSearch.setBounds(659, 69, 115, 41);
		Portfolio.add(btnPortSearch);
		
		textFieldPortContents = new JTextField();
		textFieldPortContents.setBounds(21, 224, 753, 20);
		Portfolio.add(textFieldPortContents);
		textFieldPortContents.setColumns(10);
		Portfolio.setVisible(false);
		
		
		
		
		
		JTextArea txtrThatCombinationOf = new JTextArea();
		txtrThatCombinationOf.setText("That combination of user name and password does not match our records.  Please try again, click on the instructions button on the login screen if you need more assistance.");
		txtrThatCombinationOf.setWrapStyleWord(true);
		txtrThatCombinationOf.setLineWrap(true);
		txtrThatCombinationOf.setBounds(128, 80, 475, 124);
		InvalidLogin.add(txtrThatCombinationOf);
		
		JButton btnInvLogOK = new JButton("OK");
		btnInvLogOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvalidLogin.setVisible(false);
				Login.setVisible(true);
			}
		});
		btnInvLogOK.setBounds(255, 259, 202, 102);
		InvalidLogin.add(btnInvLogOK);
		InvalidLogin.setVisible(false);
		
		JTextArea txtrInstructionsForThe = new JTextArea();
		txtrInstructionsForThe.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrInstructionsForThe.setText("Instructions for the Architecture Prototype Demo");
		txtrInstructionsForThe.setWrapStyleWord(true);
		txtrInstructionsForThe.setLineWrap(true);
		txtrInstructionsForThe.setBounds(10, 11, 600, 29);
		Instructions.add(txtrInstructionsForThe);
		
		JTextArea txtrThisWillShow = new JTextArea();
		txtrThisWillShow.setText("This will show the functionality of the act of buying or selling a stock - will also show some of the search function");
		txtrThisWillShow.setWrapStyleWord(true);
		txtrThisWillShow.setLineWrap(true);
		txtrThisWillShow.setBounds(10, 47, 401, 63);
		Instructions.add(txtrThisWillShow);
		
		JTextArea txtrValidLoginsAnd = new JTextArea();
		txtrValidLoginsAnd.setText("Valid logins and Searchable Ticker Symbols will be listed");
		txtrValidLoginsAnd.setWrapStyleWord(true);
		txtrValidLoginsAnd.setLineWrap(true);
		txtrValidLoginsAnd.setBounds(10, 113, 390, 47);
		Instructions.add(txtrValidLoginsAnd);
		
		JTextArea txtrClickOkTo = new JTextArea();
		txtrClickOkTo.setWrapStyleWord(true);
		txtrClickOkTo.setLineWrap(true);
		txtrClickOkTo.setText("click OK to begin prototype and click Instructions on any screen to bring up this instruction panel again if needed");
		txtrClickOkTo.setBounds(10, 164, 401, 63);
		Instructions.add(txtrClickOkTo);
		
		JTextArea txtrLoginInfo = new JTextArea();
		txtrLoginInfo.setText("Login Info");
		txtrLoginInfo.setBounds(30, 238, 144, 22);
		Instructions.add(txtrLoginInfo);
		
		JTextArea txtrUsernameFredm = new JTextArea();
		txtrUsernameFredm.setText("username - FredM  password - ethel");
		txtrUsernameFredm.setBounds(30, 271, 341, 22);
		Instructions.add(txtrUsernameFredm);
		
		JTextArea txtrUsernameCaptainkirk = new JTextArea();
		txtrUsernameCaptainkirk.setText("username - CaptainKirk  password - spock");
		txtrUsernameCaptainkirk.setBounds(30, 304, 341, 22);
		Instructions.add(txtrUsernameCaptainkirk);
		
		JTextArea txtrUsernameJudgej = new JTextArea();
		txtrUsernameJudgej.setText("username - JudgeJ  password - wapner");
		txtrUsernameJudgej.setBounds(30, 337, 341, 22);
		Instructions.add(txtrUsernameJudgej);
		
		JTextArea txtrSearchableTickerSymbols = new JTextArea();
		txtrSearchableTickerSymbols.setText("Searchable Ticker Symbols");
		txtrSearchableTickerSymbols.setBounds(462, 238, 224, 22);
		Instructions.add(txtrSearchableTickerSymbols);
		
		JTextArea txtrStbHpiRcc = new JTextArea();
		txtrStbHpiRcc.setText("STB   HPI   RCC");
		txtrStbHpiRcc.setBounds(462, 271, 224, 22);
		Instructions.add(txtrStbHpiRcc);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructions.setVisible(false);
			}
		});
		btnNewButton.setBounds(543, 353, 164, 63);
		Instructions.add(btnNewButton);
		Instructions.setVisible(true);
		
		JTextArea txtrPleaseClickInstruction = new JTextArea();
		txtrPleaseClickInstruction.setWrapStyleWord(true);
		txtrPleaseClickInstruction.setLineWrap(true);
		txtrPleaseClickInstruction.setText("Please Click Instruction to get Instructions on the Architecture Prototype Functions");
		txtrPleaseClickInstruction.setBounds(20, 30, 423, 47);
		Login.add(txtrPleaseClickInstruction);
		
		JButton btnNewButton_1 = new JButton("Instructions");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Instructions.setVisible(true);
				Login.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(561, 30, 154, 58);
		Login.add(btnNewButton_1);
		
		JTextArea txtrUserName = new JTextArea();
		txtrUserName.setBackground(new Color(0, 128, 0));
		txtrUserName.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrUserName.setForeground(new Color(0, 0, 0));
		txtrUserName.setText("User Name");
		txtrUserName.setBounds(151, 183, 123, 22);
		Login.add(txtrUserName);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setBackground(new Color(0, 128, 0));
		txtrPassword.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtrPassword.setText("Password");
		txtrPassword.setBounds(151, 218, 123, 22);
		Login.add(txtrPassword);
		
		textFieldLoginUserName = new JTextField();
		textFieldLoginUserName.setBounds(274, 185, 144, 20);
		Login.add(textFieldLoginUserName);
		textFieldLoginUserName.setColumns(10);
		
		textFieldLoginPassword = new JTextField();
		textFieldLoginPassword.setColumns(10);
		textFieldLoginPassword.setBounds(274, 220, 144, 20);
		Login.add(textFieldLoginPassword);
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_in = textFieldLoginUserName.getText();
				String password_in = textFieldLoginPassword.getText();
				Investor current_investor = new Investor();
				Portfolio current_portfolio = new Portfolio();
				boolean validKey = usermap.hasKey(user_in);
				if (validKey) {
					boolean is_user = usermap.validateUser(user_in, password_in);
					if(is_user == true) {
						current_investor = usermap.getUser(user_in);
						current_portfolio = current_investor.getPortfolio();
						String temp_name = current_investor.getFirstName() + " " + current_investor.getLastName();
						String str_walletAmt = fmt.format(current_investor.getWalletAmt());
						String str_portValue = fmt.format(current_investor.getPortfolioValue());
						int int_shares = current_portfolio.getShares();
						String str_shares = Integer.toString(int_shares);
						textFieldHomePageName.setText(temp_name);
						textFieldHomePageWalletAmt.setText(str_walletAmt);
						textFieldHomePagePortfolioValue.setText(str_portValue);
						textFieldPortShares.setText(str_shares);
						textFieldPortValue.setText(str_portValue);
						textFieldPortContents.setText(current_portfolio.toString());
						hold_userID = user_in;
						Login.setVisible(false);
						HomePage.setVisible(true);
					}
					else {
						Login.setVisible(false);
						InvalidLogin.setVisible(true);
						
					}
				}
				else {
					Login.setVisible(false);
					InvalidLogin.setVisible(true);
				}
				
			}
		});
		btnNewButton_2.setBounds(342, 290, 89, 23);
		Login.add(btnNewButton_2);
		
		
	}
}
