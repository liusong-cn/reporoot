package com.common.mpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;
import net.sf.mpxj.mpp.MPPReader;

public class TestMppImport {
	public static void main(String[] args) throws FileNotFoundException, MPXJException {
		FileInputStream fis = new FileInputStream(new File("d://plan.mpp"));
		List<Task> taskList = new ArrayList<Task>();
		MPPReader reader = new MPPReader();
		ProjectFile file = reader.read(fis);
		taskList = file.getAllTasks();
		taskList.forEach((task)->System.out.println(task.getStart()));
	}
}
