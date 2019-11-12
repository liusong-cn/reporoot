package com.common.visitormode;

public interface Bill {
	
	/**
	 * 提供账单被访问的方法，访问者拿到账单之后如何访问此处不关心，访问者要访问该账单
	 * 必然需要知道该账单的一些内部信息
	 * @param abv
	 */
	void accept(AccountBillViewer abv);
}
