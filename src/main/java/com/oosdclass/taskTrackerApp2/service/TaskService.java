package com.oosdclass.taskTrackerApp2.service;

import java.util.List;

import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {
	public List<Task> getAllTask();
	
	public boolean isValid(Task addTaskFormObject);
	
	public int addANewTask(Task addTaskFormObject);
}

 