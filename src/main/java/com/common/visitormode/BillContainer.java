package com.common.visitormode;

import java.util.ArrayList;
import java.util.List;

public class BillContainer {
	
	private List<Bill> bills = new ArrayList<Bill>();
	
	public void addBill(Bill b){
		bills.add(b);
	}
	
	/**
	 * 供账本的查看着查看账本
	 * @param abv
	 */
	public void show(AccountBillViewer abv){
		for (Bill bill : bills) {
			bill.accept(abv);
		}
	}
}
