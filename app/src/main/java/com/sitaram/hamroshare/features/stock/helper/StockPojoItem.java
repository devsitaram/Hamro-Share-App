package com.sitaram.hamroshare.features.stock.helper;

public class StockPojoItem{
	private Object yearLow;
	private String symbol;
	private String identifier;
	private int totalTradedVolume;
	private Object change;
	private Object dayLow;
	private Object perChange30d;
	private Object yearHigh;
	private Object perChange365d;
	private Object previousClose;
	private Object pChange;
	private Object totalTradedValue;
	private Object open;
	private Object dayHigh;
	private Object lastPrice;
	private String lastUpdateTime;

	public Object getYearLow(){
		return yearLow;
	}

	public String getSymbol(){
		return symbol;
	}

	public String getIdentifier(){
		return identifier;
	}

	public int getTotalTradedVolume(){
		return totalTradedVolume;
	}

	public Object getChange(){
		return change;
	}

	public Object getDayLow(){
		return dayLow;
	}

	public Object getPerChange30d(){
		return perChange30d;
	}

	public Object getYearHigh(){
		return yearHigh;
	}

	public Object getPerChange365d(){
		return perChange365d;
	}

	public Object getPreviousClose(){
		return previousClose;
	}

	public Object getPChange(){
		return pChange;
	}

	public Object getTotalTradedValue(){
		return totalTradedValue;
	}

	public Object getOpen(){
		return open;
	}

	public Object getDayHigh(){
		return dayHigh;
	}

	public Object getLastPrice(){
		return lastPrice;
	}

	public String getLastUpdateTime(){
		return lastUpdateTime;
	}
}
