package data.dataObjects;

import java.sql.Timestamp;

import data.dataObjects.CompanyObject;
import data.dataObjects.MarketObject;

public class StockObject {
	
	private int stockID;
	private int marketID;
	private int companyID;
	private double bidPrice;
	private double askPrice;
	private Timestamp stockTime;
	
	public StockObject() {
		//default constructor
	}
	
	public StockObject(int stockID, int companyObj, double bidPrice, double askPrice, Timestamp stockTime){
		this.stockID=stockID;
		this.companyID=companyObj;
		this.bidPrice=bidPrice;
		this.askPrice=askPrice;
		this.stockTime=stockTime;
	}
	
	public int getStockID() {
		return stockID;
	}
	public void setStockID(int stockID) {
		this.stockID = stockID;
	}
	public int getMarketID() {
		return marketID;
	}
	public void setMarketID(int marketObj) {
		this.marketID = marketObj;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyObj) {
		this.companyID = companyObj;
	}
	public double getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}
	public double getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}

	public Timestamp getStockTime() {
		return stockTime;
	}

	public void setStockTime(Timestamp stockTime) {
		this.stockTime = stockTime;
	}
	
	public String toString() {
		return stockID+", "+marketID+", "+companyID+", "+bidPrice+", "+askPrice+", "+stockTime.toString();
	}
}
