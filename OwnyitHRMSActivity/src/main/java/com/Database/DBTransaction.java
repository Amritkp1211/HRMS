package com.Database;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CommonMethodParse.RecordNumberGenerate;

@Service
public class DBTransaction {
	
	@Autowired
	RecordNumberGenerate rNumber;
	
	@Autowired
	DBMessages dbMessage;
	
	@Autowired
	DatabaseSnapshotHandler dbResponse;

	public String addProjectData(HashMap<String, String> decode_map) {
		String response = null;
		
		String checkData = dbMessage.GetLastDataCount(decode_map);
		int count_data = dbResponse.getResponseDataCount(checkData);
		
		System.out.println(count_data);
		if(count_data != 0) {
			response = dbResponse.LastCountResponse(count_data);
		}else {
			int recordNumber = rNumber.ExistingRecordnumber(decode_map);

			String str_query = dbMessage.SetprojecData(decode_map,recordNumber);
			int count =  dbResponse.getResponseDB(str_query);
		
		if(count != 0) {
			response = dbResponse.Insertresponse(count);
		}
	}
		
		return response;
	}
	
	
	public String deleteProjectData(HashMap<String, String> decode_map) {
		String response = null;
		int count = 0;
	
		String str_query_I351 = dbMessage.DeleteprojectI351Data(decode_map);
		count =  dbResponse.getResponseDB(str_query_I351);
		
		String str_query_I352 = dbMessage.DeleteprojectI352Data(decode_map);
		count =  dbResponse.getResponseDB(str_query_I352);
		
		if(count != 0) {
			response = dbResponse.Deleteresponse(count);
		}
		
		return response;
	}

	public String getactiveData(int type) {
		String response = null;
	
		String str_query_active = dbMessage.Getactivedata(type);
		if(str_query_active != null) {
			String response_data = dbResponse.getResponseJsonData(str_query_active);
			response = dbResponse.getReponseString(response_data);
		
		}
		return response;
	}

	public String getPMCData(HashMap<String, String> decode_map) {
		String response = null;
		
		String str_query = dbMessage.GetPMCDataDetails(decode_map);
		if(str_query != null) {
			String response_data = dbResponse.getResponseJsonData(str_query);
			response = dbResponse.getReponseString(response_data);
		
		}
		
		return response;
	}

	public String setModuleData(HashMap<String, String> decode_map) {
		String response = null;
		
		String checkData = dbMessage.GetLastDataCount(decode_map);
		int count_data = dbResponse.getResponseDataCount(checkData);
		
		
		if(count_data != 0) {
			response = dbResponse.LastCountResponse(count_data);
		}else {
			int recordNumber = rNumber.ExistingRecordnumber(decode_map);
		
			String str_query = dbMessage.SetModuleDetails(decode_map,recordNumber);
			int count =  dbResponse.getResponseDB(str_query);
		
		if(count != 0) {
			response = dbResponse.Insertresponse(count);
		}
	}
		
		return response;
	}
	
	public String setComponentData(HashMap<String, String> decode_map) {
		String response = null;
		
		String checkData = dbMessage.GetLastDataCount(decode_map);
		int count_data = dbResponse.getResponseDataCount(checkData);
		if(count_data != 0) {
			response = dbResponse.LastCountResponse(count_data);
		}else {
			int recordNumber = rNumber.ExistingRecordnumber(decode_map);
		
			String str_query = dbMessage.SetComponentDetails(decode_map,recordNumber);
			int count =  dbResponse.getResponseDB(str_query);
		
		if(count != 0) {
			response = dbResponse.Insertresponse(count);
		}
	}
		return response;
	}


	public String setFinalProjectData(HashMap<String, String> decode_map) {
		String response = null;
		
		String str_query = dbMessage.SetFinalProjectDetails(decode_map);
		if(str_query != null) {
			int count =  dbResponse.getResponseDB(str_query);
			response = dbResponse.UpdateResponse(count);
			
		}
		
		return response;
	}


	public String EditModuleComponentData(HashMap<String, String> decode_map) {
		String response = null;
		
		String str_query = dbMessage.EditModuleComponentDetails(decode_map);
		if(str_query != null) {
			int count =  dbResponse.getResponseDB(str_query);
			response = dbResponse.Deleteresponse(count);
		}
		
		return response;
	}


	public String SetAssiManagerData(HashMap<String, String> decode_map) {
		String response = null;
		
		String checkData = dbMessage.LastcountI352DataCount(decode_map);
		int count_data = dbResponse.getResponseDataCount(checkData);
		if(count_data != 0) {
			response = dbResponse.LastCountResponse(count_data);
		}else {
//			int recordNumber = rNumber.ExistingRecordnumber(decode_map);
		
			String str_query = dbMessage.SetAssignManagerDetails(decode_map);
			int count =  dbResponse.getResponseDB(str_query);
		
		if(count != 0) {
			response = dbResponse.Insertresponse(count);
		}
	}
		return response;
	}


	public String EditAssiManagerData(HashMap<String, String> decode_map) {
		String response = null;
		
			String str_query = dbMessage.EditAssignManagerDetails(decode_map);
			int count =  dbResponse.getResponseDB(str_query);
		
			if(count != 0) {
				response = dbResponse.UpdateResponse(count);
			}
		return response;
	}


	public String getAssignManageractiveData(int type) {
		String response = null;
		
		String str_query_active = dbMessage.GetAssignManageractivedata(type);
		if(str_query_active != null) {
			String response_data = dbResponse.getResponseJsonData(str_query_active);
			response = dbResponse.getReponseString(response_data);
		}
		return response;
	}


	public String SetInactiveData(HashMap<String, String> decode_map) {
		String response = null;
		
		String str_query_active = dbMessage.SetInactiveDetails(decode_map);
		int count =  dbResponse.getResponseDB(str_query_active);
		
		if(count != 0) {
			response = dbResponse.Deleteresponse(count);
		}
		return response;
	}


	public String getActivityIDData(int type) {
		String response = null;
		
		String str_query = dbMessage.GetActivityIddata(type);
		if(str_query != null) {
			String response_data = dbResponse.getResponseJsonData(str_query);
			response = dbResponse.getReponseString(response_data);
		}
		return response;
	}


	public String getModuleGridData(int id) {
		String response = null;
		
		String str_query = dbMessage.GetModuleGriddataDetails(id);
		if(str_query != null) {
			String response_data = dbResponse.getResponseJsonData(str_query);
			response = dbResponse.getReponseString(response_data);
		}
		return response;
	}

	 
}
