package com.oosdclass.taskTrackerApp2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Controller
public class TaskController {
	
	
	
	@Autowired
	TaskService taskService;
	
	
	@RequestMapping(value="/adminTasks")
	public ModelAndView viewTasks(ModelAndView model) {
		
		//replace the mock method with the service
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("viewTask");
		return model;
		
	}
	
	@RequestMapping(value = "/addTask")
	public ModelAndView addTask(ModelAndView model) {
			Task task = new Task();
			//by adding object we are informing 
			//spring mvc to initialize task object on the addTaskView page
			model.addObject(task);
			//by setting viewname to /addTaskView spring mvc displays 
			//the jsp that is named addTaskView
			model.setViewName("/addTaskView");
			return model;
		}

	//(/addTask) method (POST) is mapped to /addTask URL where user post/submits the
	// form which is mapped to task object and we pass to service
	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public ModelAndView addTask(Task addTaskFormObject) {
//		System.out.println("Added: " + addTaskFormObject);
//		ModelAndView model = new ModelAndView("/addTaskView");
		
		ModelAndView model = null;
		
		int result = taskService.addANewTask(addTaskFormObject);
		
//		if addTask entry is valid then display a view Task page to see it 
 		if(result == 1) {
 			model = new ModelAndView("redirect:/adminTasks");
 		}
//		else keep them on addTaskView page and display error
		else {
			model = new ModelAndView("addTaskView");
			model.addObject("error", "Task entry invalid");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/assignTask")
	public ModelAndView assignTask(ModelAndView model) {
		Task task = new Task();
//		task.setTaskID(taskID);
		//add the task object sent from the task row on view task screen
		//spring mvc will add this task object's contents to the assignTask page
		model.addObject(task);
		//by setting viewname to assignTask spring mvc displays 
		//the jsp that is named assignTask
		model.setViewName("/assignTask");
		return model;
		}

	//(/assignTask) method (POST) is mapped to /assignTask URL where user post/submits the
	// form which is mapped to assigntask object and we pass to service
	@RequestMapping(value = "/assignTask", method = RequestMethod.POST)
	public ModelAndView assTask(Task assignTaskFormObject) {
		System.out.println("Assigned: " + assignTaskFormObject);
		ModelAndView model = new ModelAndView("/assignTask");
//		//if task entry is valid then display view Task page
//		if(taskService.isValid(addTaskFormObject)) {
//			model = new ModelAndView("redirect:/adminTasks");
//		}
//		//else keep them on Add Task page and send an error to display
//		//on page to the user
//		else {
//			model = new ModelAndView("addTaskView");
//			model.addObject("error", "Task entry invalid");
//		}
		
		return model;
	}
	
}
