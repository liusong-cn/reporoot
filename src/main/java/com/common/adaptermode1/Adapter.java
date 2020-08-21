package com.common.adaptermode1;



//适配器
public class Adapter  extends Adaptee implements Target{
	

	@Override
	public void requestAdater() {
		//使用了父类adaptee的方法，此处可以加上控制等功能
		getAge();
	}
}
