package com.common.combinemode;

public class Test {
	
	public static void main(String[] args) {
		ParentCompany pc = new ParentCompany("北京总公司");
		pc.addCompany(new HrDept("北京总公司人力部"));
		pc.addCompany(new FinanceDept("北京总公司财务部"));
		
		ParentCompany spc = new ParentCompany("上海分公司");
		spc.addCompany(new HrDept("上海分公司人力部"));
		spc.addCompany(new FinanceDept("上海分公司财务部"));
		
		pc.addCompany(spc);
		
		ParentCompany npc = new ParentCompany("南京分公司");
		npc.addCompany(new HrDept("南京分公司人力部"));
		npc.addCompany(new FinanceDept("南京分公司财务部"));
		pc.addCompany(npc);
		
		pc.display(1);
		pc.lineOfDuty();
	}
}
