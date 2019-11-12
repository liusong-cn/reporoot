package com.glaway.offline.util;

/**
 * 测试文件包装对象的属性为简单类型时能否通过JaxWSDynamicClientFactory进行调用
 * @author Administrator
 *
 */
public class SimpleResume {
	private String fileName;
	
	private String suffix;
	
	private byte[] content;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}
	
	
	
}
