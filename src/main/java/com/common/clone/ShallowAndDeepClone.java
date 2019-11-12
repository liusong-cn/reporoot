package com.common.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ShallowAndDeepClone implements Cloneable, Serializable {
	
	private int name;
	
	private Reference r;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Reference getR() {
		return r;
	}

	public void setR(Reference r) {
		this.r = r;
	}
	
	public ShallowAndDeepClone shallowClone(){
		Object o = null;
		try {
			o = super.clone();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (ShallowAndDeepClone) o;
	}
	
	@SuppressWarnings("finally")
	public ShallowAndDeepClone DeepClone(ShallowAndDeepClone s){
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		ShallowAndDeepClone sc = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(s);
			ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			sc = (ShallowAndDeepClone) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				bos.close();
				oos.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sc;
		}
	}
}
