package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class WSControllerPath {
	
	@Autowired
	WSControllerSet handleData;

	@PostMapping(WSSeviceConstant.SET_PROJECTDETAILS_DATA)
	public String AddProjectData(@RequestBody String data ) {
		System.out.println("Add project :: " + data);
		 return handleData.SetProjectDetailsData(data);	
	}
	
	@RequestMapping(value=WSSeviceConstant.GET_ACTIVEDEACTIVE_DATA, method=RequestMethod.GET)
	@ResponseBody
	public String GetProjectManagerDetails(@PathVariable("type") int type) {
		return handleData.HandleProjectManagerdata(type);
	}
	
	@PostMapping(WSSeviceConstant.GET_PMC_DETAILS)
	public String GetPMCData(@RequestBody String data ) {
		 return handleData.GetPMCDetailsData(data);	
	}
	
	@PostMapping(WSSeviceConstant.SET_MODULE_COMPONENT_DETAILS)
	public String SetModuleComponentData(@RequestBody String data ) {
		 return handleData.SetMCDetailsData(data);	
	}
	
	@PostMapping(WSSeviceConstant.SET_PMC_ENDDATE_DETAILS)
	public String SetFinalProjectData(@RequestBody String data ) {
		 return handleData.SetFinalProjectData(data);	
	}
	
	@PostMapping(WSSeviceConstant.EDIT_MODULE_COMPONENT_DETAILS)
	public String EditMCDetailsData(@RequestBody String data ) {
		 return handleData.EditModuleComponentData(data);	
	}
	
	@PostMapping(WSSeviceConstant.SET_ASSIGNMANAGER_DETAILS)
	public String SetAssignManagerData(@RequestBody String data ) {
		 return handleData.SetAssignManagerData(data);	
	}
	
	@RequestMapping(value=WSSeviceConstant.GET_ASSIGNMANAGER_ACTIVEDEACTIVE_DATA, method=RequestMethod.GET)
	@ResponseBody
	public String GetAssignManagerActiveDetails(@PathVariable("type") int type) {
		return handleData.HandleAssignManagerdata(type);
	}
	
	@PostMapping(WSSeviceConstant.SET_INACTIVE_DETAILS)
	public String SetInactiveData(@RequestBody String data ) {
		 return handleData.SetInactiveDetailsData(data);	
	}
	
	@RequestMapping(value=WSSeviceConstant.GET_ACTIVITYID_DETILS, method=RequestMethod.GET)
	@ResponseBody
	public String GetActivityIDDetails(@PathVariable("type") int type) {
		return handleData.HandleActivityIDdata(type);
	}
	
	@RequestMapping(value=WSSeviceConstant.GET_MODULEGRIDDETAILS, method=RequestMethod.GET)
	@ResponseBody
	public String GetModuleGridDetails(@PathVariable("id") int id) {
		return handleData.HandleModuleGriddata(id);
	}
}
