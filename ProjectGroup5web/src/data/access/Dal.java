package data.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;

import yahooFeed.Feed;
import data.dataObjects.CompanyObject;
import data.dataObjects.StockObject;
import data.dataObjects.TradeHistoryObject;

public class Dal {
	
	static Logger log = Logger.getLogger(Dal.class);
	
	public static Connection getConnection() {
		
		Connection cn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/citiprojectteam5db","root","root");
			log.info("Connection made");
		}
		catch (ClassNotFoundException e) {
			
			System.out.println("Class not found"+e);
			log.info("Class not found"+e);
		}
		catch (SQLException e) {
			
			System.out.println("SQL Exception: "+e);
			log.info("SQL Exception: "+e);
		}
		return cn;
	}

	public static void addTradeHistory(TradeHistoryObject trade) throws SQLException {
		
		Connection cn = null;
		
		try {
			cn = getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO TradeHistory (StockID, TradeTime, Buy) VALUES (?,?,?)");
		
			st.setInt(1, trade.getStockID());
			st.setTimestamp(2, trade.getTradeTime());
			st.setBoolean(3, trade.isBought());
		
			int rows = st.executeUpdate();
		
			if (rows ==1) {
				log.info("Trade History Added");
			}
		}
		catch (SQLException e) {
		
			//System.out.println("Error getting data "+e);
			log.info("Error adding trade "+e);
		}
		finally {
		
			if (cn != null) {
				cn.close();
			}
		}	
	}
	
public static List<TradeHistoryObject> getTrades(String company) throws SQLException {
		
		List<TradeHistoryObject> trades = new ArrayList<>();
		TradeHistoryObject trade = null;
		List<String> temp = new ArrayList<String>();
		Connection cn = null;
		
		try {
			cn = getConnection();
			PreparedStatement st = cn.prepareStatement("SELECT TradeID, UserID, StockID, TradeTime, Buy FROM TradeHistory t join Stocks s on t.StockID "
														+ "= s.StockID join Company c on c.CompanyID = s.CompanyID "
														+ "WHERE c.CompanySymbol = ?");
			st.setString(1, company);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				trade = new TradeHistoryObject(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getTimestamp(4), rs.getBoolean(5));
				trades.add(trade);
			}
			
		}
		catch (SQLException e) {
			
			log.info("Error getting list of trades "+e);
		}
		finally {
			
			if (cn != null) {
				cn.close();
			}
		}
		
		return trades;
	}

	public static void addStock(StockObject stock) throws SQLException {
			Connection cn = null;
		
		try {
			cn = getConnection();
			PreparedStatement st = cn.prepareStatement("INSERT INTO Stocks (CompanyID, BidPrice, AskPrice, StockTime) VALUES (?,?,?,?)");
		
			st.setInt(1, stock.getCompanyID());
			st.setDouble(2, stock.getBidPrice());
			st.setDouble(3, stock.getAskPrice());
			st.setTimestamp(4, stock.getStockTime());
		
			int rows = st.executeUpdate();
		
			if (rows ==1) {
				log.info("Stock Added");
			}
		}
		catch (SQLException e) {
		
			log.info("Error adding Stock"+e);
		}
		finally {
		
			if (cn != null) {
				cn.close();
			}
		}	
	}
	
public static List<StockObject> getStocksByCompanySymbol(String company) throws SQLException {
		
		List<StockObject> stocks = new ArrayList<>();
		StockObject stock = null;
		
		Connection cn = null;
		
		try {
			cn = getConnection();
			PreparedStatement st = cn.prepareStatement("SELECT StockID, CompanyID, BidPrice, AskPrice, StockTime FROM "
														+ "Stocks s join Company c on c.CompanyID = s.CompanyID "
														+ "WHERE c.CompanySymbol = ?");
			st.setString(1, company);
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				stock = new StockObject(rs.getInt(1),rs.getInt(2),rs.getDouble(3), rs.getDouble(4), rs.getTimestamp(5));
				stocks.add(stock);
			}
			
		}
		catch (SQLException e) {
			
			log.info("Error getting list of Stock Objects "+e);
		}
		finally {
			
			if (cn != null) {
				cn.close();
			}
		}
		
		return stocks;
	}

public static int getStockId(String company) throws SQLException {
	int stock = 0;
	
	Connection cn = null;
	log.info("Query string "+company);
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("SELECT StockID FROM "
													+ "Stocks s join Company c on c.CompanyID = s.CompanyID "
													+ "WHERE c.CompanySymbol = ?");
		st.setString(1, company);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			stock = rs.getInt(1);
		}
		log.info("DAL stockid "+stock);
	}
	catch (SQLException e) {
		
		log.info("Error getting Stock "+e);
	}
	finally {
		
		if (cn != null) {
			cn.close();
		}
	}
	
	return stock;
}

public static List<StockObject> getStocksByTradeHistory(int tradeId) throws SQLException {
	
	List<StockObject> stocks = new ArrayList<>();
	StockObject stock = null;
	
	Connection cn = null;
	
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("SELECT TradeID, UserID, StockID, TradeTime, Buy FROM "
													+ "Stocks s join TradeHistory t on s.StockID= t.StockID "
													+ "WHERE t.TradeID = ?");
		st.setInt(1, tradeId);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			stock = new StockObject(rs.getInt(1),rs.getInt(2),rs.getDouble(3), rs.getDouble(4), rs.getTimestamp(5));
			stocks.add(stock);
		}
		
	}
	catch (SQLException e) {
		
		log.info("Error getting stocks by trade history "+e);
	}
	finally {
		
		if (cn != null) {
			cn.close();
		}
	}
	
	return stocks;
}

public static int getStrategyByCompany(String symbol) throws SQLException {
	int strategy = 0;
	Connection cn = null;
	try {
		
		cn = getConnection();
		
		PreparedStatement st = cn.prepareStatement("SELECT Strategy FROM Company WHERE CompanySymbol = ?");
		st.setString(1, symbol);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			strategy = rs.getInt(1);
		}
	}catch (SQLException e) {
		
		log.info("Error getting strategy by company "+e);
	}
	finally {
		
		if (cn != null) {
			cn.close();
		}
	}
	return strategy;
}

public static List<CompanyObject> getAllCompanies() throws SQLException {
	
	List<CompanyObject> companies = new ArrayList<>();
	CompanyObject company = null;
	Connection cn = null;
	try {
		cn = getConnection();
		
		PreparedStatement st = cn.prepareStatement("SELECT * FROM Company");
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			company = new CompanyObject(rs.getInt(1),rs.getString(2),rs.getInt(3));
		}
		
	} catch (SQLException e) {
		log.info("Error getting all companies "+e);
	}
	finally {
		
		if (cn != null) {
			cn.close();
		}
	}

	return null;
}

public static void addCompany(CompanyObject comp) throws SQLException {
	Connection cn = null;
	
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("INSERT INTO Company (CompanySymbol, Strategy) VALUES (?,?)");
	
		st.setString(1, comp.getCompanySymbol());
		st.setInt(2, comp.getStrategy());
	
		int rows = st.executeUpdate();
	
		if (rows ==1) {
			log.info("Company added");
		}
	}
	catch (SQLException e) {
	
		log.info("Error adding company "+e);
	}
	finally {
	
		if (cn != null) {
			cn.close();
		}
	}
}

public static int returnCompanyId(String company) throws SQLException {
	int id = 0;
	Connection cn = null;
	log.info("query string "+company);
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("SELECT CompanyID FROM Company WHERE CompanySymbol = ?");
		st.setString(1, company);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			id = rs.getInt(1);
		}
	}
	catch (SQLException e) {
		
		log.info("Error getting company id "+e);
	}
	finally {
	
		if (cn != null) {
			cn.close();
		}
	}
	
	return id;
	
}

public static Boolean companyCheck(String company) throws SQLException {
	Connection cn = null;
	CompanyObject comp =null;
	boolean contains = false;
	
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("SELECT * FROM Company WHERE CompanySymbol = ?");
		st.setString(1, company);
		
		ResultSet rs = st.executeQuery();
		
		
		if (rs.next()) {
			contains = true;
		} 
		else {
			contains = false;
		}
	}
	catch (SQLException | NullPointerException e) {
		
		log.info("Error getting company "+e);
		contains = false;
	}
	finally {
	
		if (cn != null) {
			cn.close();
		}
	}
	
	return contains;
}

public static void updateStrategy(String comp, int strategy) throws SQLException {
	Connection cn = null;
	
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("UPDATE Company SET Strategy= ? WHERE CompanySymbol = ?");
		st.setInt(1, strategy);
		st.setString(2, comp);
		
		ResultSet rs = st.executeQuery();
		
	} catch (SQLException | NullPointerException e) {
		
		log.info("Error setting new strategy value "+e);
		
	}
	finally {
	
		if (cn != null) {
			cn.close();
		}
	}
}

public static CompanyObject getCompanyByName(String company) throws SQLException {
	
	Connection cn = null;
	CompanyObject comp = new CompanyObject();
	
	try {
		cn = getConnection();
		PreparedStatement st = cn.prepareStatement("SELECT * FROM Company WHERE CompanySymbol = ?");
		st.setString(1, company);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			comp.setCompanyID(rs.getInt(1));
			comp.setCompanySymbol(rs.getString(2));
			comp.setStrategy(rs.getInt(3));
		}
	}
	catch (SQLException e) {
		
		log.info("Error getting company id "+e);
	}
	finally {
	
		if (cn != null) {
			cn.close();
		}
	}
	
	return comp;
	
}

}
