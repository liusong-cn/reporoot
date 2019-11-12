package com.common.combinemode;

import java.util.ArrayList;
import java.util.List;

public class ParentCompany extends Company {
	
	private List<Company> list = new ArrayList<Company>();
	
	public ParentCompany(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addCompany(Company company) {
		// TODO Auto-generated method stub
		list.add(company);
	}

	@Override
	void removeCompay(Company company) {
		// TODO Auto-generated method stub
		list.remove(company);
	}

	@Override
	void display(int depth) {
		// TODO Auto-generated method stub
		/*String str = null;
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
		}*/
		for (Company company : list) {
			company.display(depth +1);
		}
	}

	@Override
	void lineOfDuty() {
		// TODO Auto-generated method stub
		for (Company company : list) {
			company.lineOfDuty();
		}
	}

}
