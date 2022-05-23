package com.kafka.streams.dto;

public class Orders {

	private String sItem;
	private int iQty;
	private String sDelivery;
	
	public Orders() {
		super();
	}
	
	public Orders(String sItem, int iQty, String sDelivery) {
		super();
		this.sItem = sItem;
		this.iQty = iQty;
		this.sDelivery = sDelivery;
	}
	public String getsItem() {
		return sItem;
	}
	public void setsItem(String sItem) {
		this.sItem = sItem;
	}
	public int getiQty() {
		return iQty;
	}
	public void setiQty(int iQty) {
		this.iQty = iQty;
	}
	public String getsDelivery() {
		return sDelivery;
	}
	public void setsDelivery(String sDelivery) {
		this.sDelivery = sDelivery;
	}
	
	
}
