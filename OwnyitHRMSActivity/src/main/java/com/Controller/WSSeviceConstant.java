package com.Controller;

public abstract class WSSeviceConstant {

	public final static String HEADER_DATA = "/HrmsActivity";
	
	public final static String SET_PROJECTDETAILS_DATA = HEADER_DATA + "/SetProjectDetails";
	
	public final static String GET_ACTIVEDEACTIVE_DATA = HEADER_DATA + "/SelectManagerProjectDetails/{type}";
	
	public final static String GET_PMC_DETAILS = HEADER_DATA + "/SelectPMCDetails" ;
	
	public final static String SET_MODULE_COMPONENT_DETAILS = HEADER_DATA + "/SetModuleComponentData";
	
	public final static String SET_PMC_ENDDATE_DETAILS = HEADER_DATA + "/SetFinalProjectDetails" ;
	
	public final static String EDIT_MODULE_COMPONENT_DETAILS = HEADER_DATA +"/EditProjectModuleData";
	
	public final static String SET_ASSIGNMANAGER_DETAILS = HEADER_DATA +"/SetAssignmanagerData";
	
	public final static String GET_ASSIGNMANAGER_ACTIVEDEACTIVE_DATA = HEADER_DATA + "/GetAssignmanagerActiveDetails/{type}";
	
	public final static String SET_INACTIVE_DETAILS = HEADER_DATA + "/SetInactiveDetails" ;
	
	public final static String GET_ACTIVITYID_DETILS = HEADER_DATA + "/GetActivityDetails/{type}" ;
	
	public final static String GET_MODULEGRIDDETAILS = HEADER_DATA + "/GetModuleComponentGridData/{id}";
}
