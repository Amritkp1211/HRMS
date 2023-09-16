package com.Controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CommonMethodParse.CommonMethods;
import com.Database.DBTransaction;
import ownyit.utility.OwnYitJSON;

@Service
public class WSControllerSet {
	
	@Autowired
	CommonMethods cDMethods;
	
	@Autowired
	DBTransaction handle_transaction;
	
	public String SetProjectDetailsData(String data) {
		
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
System.out.println("decode data ::" + decode_map);
			if(decode_map.get("action").equals("1")) {
				strData = handle_transaction.addProjectData(decode_map);
			}else if(decode_map.get("action").equals("2")) {
				strData = handle_transaction.deleteProjectData(decode_map);
			}
		}
		return strData;
		
		
	}

	public String HandleProjectManagerdata(int type) {
		String strData = null;
		
		strData = handle_transaction.getactiveData(type);
			
		return strData;
	}

	public String GetPMCDetailsData(String data) {
	String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			
			strData = handle_transaction.getPMCData(decode_map);
		}
		return strData;	
	}

	public String SetMCDetailsData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			
			if(decode_map.get("action").equals("1")) {
				strData = handle_transaction.setModuleData(decode_map);
			}else {
				strData = handle_transaction.setComponentData(decode_map);
			}
		}
		return strData;	
	}

	public String SetFinalProjectData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
				strData = handle_transaction.setFinalProjectData(decode_map);
		}
		return strData;	
	}

	public String EditModuleComponentData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			
				strData = handle_transaction.EditModuleComponentData(decode_map);
		
		}
		return strData;	
	}

	public String SetAssignManagerData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			
			if(decode_map.get("action").equals("1")) {
				strData = handle_transaction.SetAssiManagerData(decode_map);
			}else {
				strData = handle_transaction.EditAssiManagerData(decode_map);
			}
		}
		return strData;	
	}

	public String HandleAssignManagerdata(int type) {
		String strData = null;
		strData = handle_transaction.getAssignManageractiveData(type);
			
		return strData;
	}

	public String SetInactiveDetailsData(String data) {
		String strData = null;
		
		OwnYitJSON parse_data = new OwnYitJSON();
		HashMap<String, String> map_data = parse_data.parse(data);
		
		String user_json = map_data.get("user_json");
		if(user_json != null) {
			String decode_data =  cDMethods.decodeBase64(user_json);
			HashMap<String, String> decode_map = parse_data.parse(decode_data);
			
			strData = handle_transaction.SetInactiveData(decode_map);
			
		}
		return strData;	
	}

	public String HandleActivityIDdata(int type) {
		String strData = null;
		strData = handle_transaction.getActivityIDData(type);
			
		return strData;
	}

	public String HandleModuleGriddata(int id) {
		String strData = null;
		strData = handle_transaction.getModuleGridData(id);
			
		return strData;
	}

}
