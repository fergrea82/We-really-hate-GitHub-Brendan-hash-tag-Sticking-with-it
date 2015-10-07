package data.dataObjects;

import java.sql.Timestamp;

import data.dataObjects.StockObject;
import data.dataObjects.UserObject;

public class TradeHistoryObject {
	
	private int tradeID;
	private int userID;
	private int stockID;
	private Timestamp tradeTime;
	private boolean buy;
	
	public TradeHistoryObject() {
		//default constructor
	}

	public TradeHistoryObject(int tradeID, int userObj, int stockObj, Timestamp tradeTime, boolean isBought){
		this.tradeID=tradeID;
		this.userID=userObj;
		this.stockID=stockObj;
		this.tradeTime=tradeTime;
		this.buy=isBought;
	}
	
	public int getTradeID() {
		return tradeID;
	}
	public void setTradeID(int tradeID) {
		this.tradeID = tradeID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userObj) {
		this.userID = userObj;
	}
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockObj) {
		this.stockID = stockObj;
	}
	public Timestamp getTradeTime() {
		return tradeTime;
	}
	public void setTradeTime(Timestamp tradeTime) {
		this.tradeTime = tradeTime;
	}
	public boolean isBought() {
		return buy;
	}

	public void setBought(boolean isBought) {
		this.buy = isBought;
	}

}
