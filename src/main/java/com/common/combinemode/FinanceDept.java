package com.common.combinemode;

public class FinanceDept extends Company {

	public FinanceDept(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addCompany(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	void removeCompay(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	void display(int depth) {
		// TODO Auto-generated method stub
		String str = null;
		switch (depth) {
		case 1:
			str = "-";
			break;
		case 2:
			str = "--";
			break;
		case 3:
			str = "---";
			break;
		case 4:
			str = "----";
			break;
		default:
			str = "-----";
			break;
		}
		System.out.println(str + name);
	}

	@Override
	void lineOfDuty() {
		// TODO Auto-generated method stub
		System.out.println("FinanceDept" + name);
	}

}
