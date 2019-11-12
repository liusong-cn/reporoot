package com.glaway.offline.wssupport.iface;

import java.io.Serializable;

import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;

public class Resume implements Serializable {
	
	private static final long serialVersionUID  = 1L;
	
	private String candidateName;
	
	private  String resumeFileType;
	
	private DataHandler resume;

	public String getCandidateName() {
		return candidateName;
	}
	
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getResumeFileType() {
		return resumeFileType;
	}

	public void setResumeFileType(String resumeFileType) {
		this.resumeFileType = resumeFileType;
	}
	
	@XmlMimeType("application/octect-stream")
	public DataHandler getResume() {
		return resume;
	}

	public void setResume(DataHandler resume) {
		this.resume = resume;
	}
	
	
}
