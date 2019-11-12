package com.common.clone;

public class Test1 {
	
	public static void main(String[] args) {
		ShallowAndDeepClone c = new ShallowAndDeepClone();
		c.setName(1);
		Reference r = new Reference();
		r.setRef(2);
		c.setR(r);
		//浅克隆和深克隆的对比
		ShallowAndDeepClone shallow = c.shallowClone();
		ShallowAndDeepClone deep = c.DeepClone(c);
		System.out.println("-----浅克隆-----");
		System.out.println(shallow.getName());
		System.out.println(shallow.getR().getRef());
		shallow.setName(4);
		shallow.getR().setRef(5);
		System.out.println(shallow.getName());
		System.out.println(shallow.getR().getRef());
		System.out.println(c.getName());
		System.out.println(c.getR().getRef());
		/*System.out.println("-----深克隆-----");
		System.out.println(deep.getName());
		System.out.println(deep.getR().getRef());
		deep.setName(4);
		deep.getR().setRef(5);
		System.out.println(deep.getName());
		System.out.println(deep.getR().getRef());
		System.out.println(c.getName());
		System.out.println(c.getR().getRef());*/
		
	}
}
