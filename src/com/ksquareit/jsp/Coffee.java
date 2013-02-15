package com.ksquareit.jsp;
public class Coffee {
	private String cofname;
	private int supid;
	private double price;
	private double sales;	
	private double total;
	
	public Coffee(String cname,int sid,double price,double sales,double total){
		this.cofname = cname;
		this.supid = sid;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}

	public void setCofName(String cname){
		this.cofname = cname;
	}
		
	public void setSupId(String sid){
		this.supid = new Integer(sid).intValue();
	}

	public void setPrice(String price){
		this.price = new Double(price).doubleValue();
	}

	public void setSales(String sales){
		this.sales = new Double(sales).doubleValue();
	}

	public void setTotal(String total){
		this.total = new Double(total).doubleValue();
	}
	
	public String getCofName(){
		return this.cofname;
	}
	
	public int getSupId(){
		return this.supid;
	}

	public double getPrice(){
		return this.price;
	}
	
	public double getSales(){
		return this.sales;
	}
	
	public double getTotal(){
		return this.total;
	}
	
}
