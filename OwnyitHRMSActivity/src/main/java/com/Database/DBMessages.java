package com.Database;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

import com.CommonMethodParse.CommonMethods;


@Service
public class DBMessages {
	
	@Autowired
	CommonMethods cDMethod;

	public String SetprojecData(HashMap<String, String> mapData,int rNumber) {
		
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.ADD_PROJECT_QUERY);
		
		builder.append(rNumber);
		builder.append(",'");
		builder.append(mapData.get("ProjectName"));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("StartDate")));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("EndDate")));
		builder.append("',");
		builder.append("1");
		builder.append(")");
		
		str_query = builder.toString();
		System.out.println("insert query ::" + str_query);
		return str_query;
		
	}
	
	public String getLastRecordNumberCheck(HashMap<String, String> map_data) {
		
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_DISTINCT_RECORD_QUERY);
		
		if(!map_data.get("ProjectName").equals("null")) {
			builder.append("L1ID from I351DeliMaster where L1Name = '");
			builder.append(map_data.get("ProjectName"));
			builder.append("'");
		}else if(!map_data.get("ModuleName").equals("null")) {
			builder.append("L2ID from I351DeliMaster where L2Name = '");
			builder.append(map_data.get("ModuleName"));
			builder.append("'");
		}else {
			builder.append("L3ID from I351DeliMaster where L3Name = '");
			builder.append(map_data.get("ComponentName"));
			builder.append("'");
		}
		
		str_query = builder.toString();
		System.out.println("Last record number query ::" + str_query);
		return str_query;
	}
	
	public String getRecordNumber(HashMap<String, String> map_data) {
		
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_RECORDNUMBER_QUERY);
		if(!map_data.get("ProjectName").equals("null")) {
			builder.append("l1ID),0)+1 from I351DeliMaster");
		}else if(!map_data.get("ModuleName").equals("null")) {
			builder.append("l2ID),0)+1 from I351DeliMaster");
		}else {
			builder.append("l3ID),0)+1 from I351DeliMaster");
		}
		
		str_query = builder.toString();
		
		return str_query;
	}

	public String DeleteprojectI351Data(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELETEPROJECTI351_QUERY);
		builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
		builder.append("' Where L1ID = ");
		builder.append(decode_map.get("L1ID"));
		
		str_query = builder.toString();
		System.out.println("Delete Project I351Data ::" + str_query);
		
		return str_query;
	}

	public String DeleteprojectI352Data(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.SET_DELETEPROJECTI352_QUERY);
		builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
		builder.append("' Where L1ID = ");
		builder.append(decode_map.get("L1ID"));
		
		str_query = builder.toString();
		System.out.println("Delete Project I352Data ::" + str_query);
		
		return str_query;
	}

	public String Getactivedata(int type) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_PROJECTMANAGERDETAILS_QUERY);
		if(type == 1) {
			builder.append("1");
		}else {
			builder.append("0");
		}
		
		str_query = builder.toString();
		System.out.println("active/Deactive query ::" + str_query);
		return str_query;
	}


	public String GetPMCDataDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder();
		
		if(decode_map.get("action").equals("1")) {
			builder.append(DBQuery.GET_PROJECTDETAILS_QUERY);
			builder.append(" from I351DeliMaster where Status = 1");
		}else if(decode_map.get("action").equals("2")) {
			builder.append(DBQuery.GET_PROJECTDETAILS_QUERY);
			builder.append(" ,L2ID as ModuleID,L2Name as 'ModuleName'");
			builder.append(" from I351DeliMaster where Status = 1");
			builder.append(" and L1Name = '");
			builder.append(decode_map.get("ProjectName"));
			builder.append("' and L2Name != 'null'");
		}else {
			builder.append(DBQuery.GET_PROJECTDETAILS_QUERY);
			builder.append(",L2ID as ModuleID,L2Name as 'ModuleName',L3ID as ComponentID,L3Name as 'ComponentName' from I351DeliMaster where Status = 1");
			builder.append(" and L1Name = '");
			builder.append(decode_map.get("ProjectName"));
			builder.append("' and L2Name ='");
			builder.append(decode_map.get("ModuleName"));
			builder.append("' and L2Name != 'null' and L3Name != 'null'");
		}
		str_query = builder.toString();
		System.out.println("PMCDetails data ::" + str_query);
		return str_query;
	}

	public String SetModuleDetails(HashMap<String, String> mapData, int recordNumber) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.ADD_MODULE_PROJECT_QUERY);
		
		builder.append(mapData.get("L1ID"));
		builder.append(",'");
		builder.append(mapData.get("ProjectName"));
		builder.append("',");
		builder.append(recordNumber);
		builder.append(",'");
		builder.append(mapData.get("ModuleName"));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("StartDate")));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("EndDate")));
		builder.append("',");
		builder.append("1");
		builder.append(")");
		
		str_query = builder.toString();
		System.out.println("insert Module query ::" + str_query);
		return str_query;
	}

	public String SetComponentDetails(HashMap<String, String> mapData, int recordNumber) {
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.ADD_COMPONENT_PROJECT_QUERY);
		
		builder.append(mapData.get("L1ID"));
		builder.append(",'");
		builder.append(mapData.get("ProjectName"));
		builder.append("',");
		builder.append(recordNumber);
		builder.append(",'");
		builder.append(mapData.get("ModuleName"));
		builder.append("',");
		builder.append(recordNumber);
		builder.append(",'");
		builder.append(mapData.get("ComponentName"));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("StartDate")));
		builder.append("','");
		builder.append(cDMethod.DateConveter(mapData.get("EndDate")));
		builder.append("',");
		builder.append("1");
		builder.append(")");
		
		str_query = builder.toString();
		System.out.println("insert Component query ::" + str_query);
		return str_query;
	}

	public String GetLastDataCount(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder();
//		System.out.println("Project ::"+ !decode_map.get("ProjectName").equals("null"));
//		if(!decode_map.get("ProjectName").equals("null")) {
			builder.append(DBQuery.GET_LAST_RECORD_COUNT);
			builder.append(decode_map.get("ProjectName"));
			builder.append("' and StartDate ='");
			builder.append(cDMethod.DateConveter(decode_map.get("StartDate")));
			builder.append("' and EndDate = '");
			builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
			builder.append("'");
			
	if( !decode_map.get("ModuleName").equals("null")){
//			builder.append(DBQuery.GET_LAST_RECORD_COUNT);
//			builder.append(decode_map.get("ProjectName"));
//			builder.append("'");
			builder.append("and L2Name = '");
			builder.append(decode_map.get("ModuleName"));
			builder.append("'");
//			builder.append(" and StartDate ='");
//			builder.append(cDMethod.DateConveter(decode_map.get("StartDate")));
//			builder.append("' and EndDate = '");
//			builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
//			builder.append("'");
			
System.out.println("Component ::" + !decode_map.get("ComponentName").equals("null"));
		}else if(!decode_map.get("ComponentName").equals("null")){
			builder.append(DBQuery.GET_LAST_RECORD_COUNT);
			builder.append(decode_map.get("ProjectName"));
			builder.append("' and L2Name = '");
			builder.append(decode_map.get("ModuleName"));
			builder.append("' and L3Name = '");
			builder.append(decode_map.get("ComponentName"));
			builder.append("' and StartDate ='");
			builder.append(cDMethod.DateConveter(decode_map.get("StartDate")));
			builder.append("' and EndDate = '");
			builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
			builder.append("'");
		}
		
		str_query = builder.toString();
		System.out.println("Get Last count data Query:: " + str_query);
		
		return str_query;
	}
	
	public String LastcountI352DataCount(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_LAST_COUNT_DATA_I352AUTHROLE_QUERY);
		builder.append(decode_map.get("Mgr_id"));
		builder.append(" and L1ID = ");
		builder.append(decode_map.get("L1ID"));
		builder.append(" and L2ID = ");
		builder.append(decode_map.get("L2ID"));
		builder.append(" and L3ID = ");
		builder.append(decode_map.get("L3ID"));
		builder.append(" and PStartDate = '");
		builder.append(cDMethod.DateConveter(decode_map.get("PStartDate")));
		builder.append("' and PEndDate = '");
		builder.append(cDMethod.DateConveter(decode_map.get("PEndDate")));
		builder.append("'");
		
		
		str_query = builder.toString();
		System.out.println("Last count data I352AuthRole query ::" + str_query);
		
		return str_query;
	}

	public String SetFinalProjectDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.SET_FINALPROJECT_DETAILS_QUERY);
		builder.append(decode_map.get("L1ID"));
		builder.append(", L1Name = '");
		builder.append(decode_map.get("ProjectName"));
//		builder.append("', L2ID =");
//		builder.append(decode_map.get("L2ID"));
//		builder.append(", L2Name = '");
//		builder.append(decode_map.get("ModuleName"));
//		builder.append("', L3ID =");
//		builder.append(decode_map.get("L3ID"));
//		builder.append(", L3Name = '");
//		builder.append(decode_map.get("ComponentName"));
		builder.append("', StartDate ='");
		builder.append(cDMethod.DateConveter(decode_map.get("StartDate")));
		builder.append("', EndDate = '");
		builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
		builder.append("'");
		
		str_query = builder.toString();
		
		System.out.println("Set Final Project Details ::" + str_query);
		return str_query;
	}

	public String EditModuleComponentDetails(HashMap<String, String> decode_map) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder();
		if(decode_map.get("action").equals("1")) {
			builder.append(DBQuery.EDIT_MODULE_DETAILS);	
			builder.append(decode_map.get("ModuleName"));
			builder.append("' and L2ID = ");
			builder.append(decode_map.get("L2ID"));
			builder.append(" and EndDate = '");
			builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
			builder.append("'");
		}else {
			builder.append(DBQuery.EDIT_MODULE_DETAILS);	
			builder.append(decode_map.get("ModuleName"));
			builder.append("' and L2ID = ");
			builder.append(decode_map.get("L2ID"));
			builder.append(" and L3Name = '");
			builder.append(decode_map.get("ComponentName"));
			builder.append("' and L3ID =");
			builder.append(decode_map.get("L3ID"));
			builder.append(" and EndDate = '");
			builder.append(cDMethod.DateConveter(decode_map.get("EndDate")));
			builder.append("'");
		}
		str_query = builder.toString();
		
		System.out.println("edit MC details ::" + str_query);
		
		return str_query;
	}

	public String SetAssignManagerDetails(HashMap<String, String> decode_map) {
		String str_query = null;
	
		StringBuilder builder = new StringBuilder(DBQuery.SET_ASSIGNMANAGERDETAILS_QUERY);
		
		if(decode_map.get("Activity").equals("null")) {
			builder.append("1");
		}else {
			builder.append("2");
		}
		builder.append(",'");
		builder.append(decode_map.get("Mgr_id"));
		builder.append("',");
		builder.append(decode_map.get("DelLinkageID"));
		builder.append(",");
		if(!decode_map.get("L1ID").equals("null")) {
			builder.append(decode_map.get("L1ID"));
			builder.append(",");
		}
		if(!decode_map.get("L2ID").equals("null")) {
			builder.append(decode_map.get("L2ID"));
			builder.append(",");
		}
		if(!decode_map.get("L3ID").equals("null")) {
			builder.append(decode_map.get("L3ID"));
			builder.append(",");
		}
		if(!decode_map.get("ActL1ID").equals("null")) {
			builder.append(decode_map.get("ActL1ID"));
			builder.append(",");
		}
		builder.append("'");
		builder.append(cDMethod.DateConveter(decode_map.get("PStartDate")));
		builder.append("','");
		builder.append(cDMethod.DateConveter(decode_map.get("PEndDate")));
		builder.append("','");
		builder.append(decode_map.get("PEfforts"));
		builder.append("',");
		builder.append("1 )");
		
		str_query = builder.toString();
		System.out.println("Add I352 AuthRoll Data ::" + str_query);
		return str_query;
	}

	public String EditAssignManagerDetails(HashMap<String, String> decode_map) {
		
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.EDIT_ASS_MANAGER_DATA_QUERY);
		
		builder.append(cDMethod.DateConveter(decode_map.get("PEndDate")));
		builder.append("' , PEffort =  '");
		builder.append(decode_map.get("PEfforts"));
		builder.append("' Where MgrID = '");
		builder.append(decode_map.get("Mgr_id"));
		builder.append("'");
		if(!decode_map.get("L1ID").equals("null")) {
			builder.append(" and L1ID = ");
			builder.append(decode_map.get("L1ID"));
		}
		if(!decode_map.get("L2ID").equals("null")) {
			builder.append(" and L2ID = ");
			builder.append(decode_map.get("L2ID"));
		}
		if(!decode_map.get("L3ID").equals("null")) {
			builder.append(" and L3ID = ");
			builder.append(decode_map.get("L3ID"));
		}
		if(!decode_map.get("ActIDL1").equals("null")) {
			builder.append(" and ActIDL1 = ");
			builder.append(decode_map.get("ActIDL1"));
		}
		
		str_query = builder.toString();
		System.out.println("Update AssignManager query ::" + str_query);
		return str_query;
	}

	public String GetAssignManageractivedata(int type) {
		String str_query = null;

		StringBuilder builder = new StringBuilder(DBQuery.GET_ASSIGNMANAGERACTIVE_DETAILS_QUERY);
		if(type == 1) {
			builder.append("A.Active = 1 and b.Status = 1 and A.L1ID = b.L1ID and C.DefnType = 5 and C.DefnIDL1 = A.ActIDL1");		
		}else {
			builder.append("A.Active = 0 and b.Status = 0 and A.L1ID = b.L1ID and C.DefnType = 5 and C.DefnIDL1 = A.ActIDL1");
		}
		
		str_query = builder.toString();
		System.out.println("AssignManagerActive Data ::" +str_query);
		return str_query;
	}

	public String SetInactiveDetails(HashMap<String, String> decode_map) {
	
		String str_query = null;
		StringBuilder builder = new StringBuilder(DBQuery.SET_INACTIVEMANAGER_DETAILS);
		builder.append(cDMethod.DateConveter(decode_map.get("PEndDate")));
		builder.append("' where PStartDate ='");
		builder.append(cDMethod.DateConveter(decode_map.get("PStartDate")));
		builder.append("' and L1ID ='");
		builder.append(decode_map.get("L1ID"));
		builder.append("' and MgrID = '");
		builder.append(decode_map.get("Mgr_id"));
		builder.append("'");
		
		str_query = builder.toString();
		System.out.println("Edit Inactive Assign Manager Query :: " + str_query);
		
		return str_query;
	}

	public String GetActivityIddata(int type) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder();
		if(type == 1) {
			builder.append(DBQuery.GET_ACTIVITYID_DETAILS_QUERY);
		}else {
			builder.append(DBQuery.GET_SUBACTIVITYID_DETAILS_QUERY);
		}
		
		str_query = builder.toString();
		System.out.println("Get activity & subactivity details query :" + str_query);
		
		return str_query;
	}

	public String GetModuleGriddataDetails(int id) {
		String str_query = null;
		
		StringBuilder builder = new StringBuilder(DBQuery.GET_MODULE_GRID_QUERY);
		builder.append(id);
		
		str_query = builder.toString();
		System.out.println("Get moduleGrid details ::" + str_query);
		
		return str_query;
	}

}
