package data.dataObjects;

import java.util.List;

import data.dataObjects.StockObject;

public class CompanyObject {
	
	private int  companyID;
	private String companySymbol;
	private int strategy;
	private List<StockObject> stocks;
	
	public CompanyObject() {
		//super();
	}
	
	public CompanyObject(int companyID, String companySymbol, int strategy){
		this.companyID=companyID;
		this.companySymbol=companySymbol;
		this.strategy = strategy;
	}
	
	public List<StockObject> getStocks() {
		return stocks;
	}

	public void setStocks(List<StockObject> stocks) {
		this.stocks = stocks;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getCompanySymbol() {
		return companySymbol;
	}

	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}

	public int getStrategy() {
		return strategy;
	}

	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}
	
}
