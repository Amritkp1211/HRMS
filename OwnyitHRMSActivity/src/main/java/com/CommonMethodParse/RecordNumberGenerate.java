package com.CommonMethodParse;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Database.DBMessages;
import com.Database.DatabaseSnapshotHandler;





@Service
public class RecordNumberGenerate {

	@Autowired
	DBMessages db_query;
	
	@Autowired
	DatabaseSnapshotHandler _db_handler;

	public int ExistingRecordnumber(HashMap<String, String> map_data) {
		
		int rNumber = 0;
	
		String record_number_check = db_query.getLastRecordNumberCheck(map_data);
//		System.out.println("recordnumber ::" + record_number_check);
		
		rNumber = _db_handler.getResponseDataCount(record_number_check);
//		System.out.println("count :" + rNumber);
		
		if (rNumber == 0) {
			return CreateRecordNumber(map_data);
		}
		return rNumber;
	}
	
	private int CreateRecordNumber(HashMap<String, String> map_data) {
		
		int rNumber = 0;
		
//		String rNumber_query = db_query.getLastRecordNumberCheck(map_data)
		
		String last_number_ckeck = db_query.getRecordNumber(map_data);
//		System.out.println("last number_check ::" + last_number_ckeck);
		
		if(last_number_ckeck != null) {
			rNumber = _db_handler.getResponseDataCount(last_number_ckeck);
//			System.out.println("count :" + rNumber);
		}
		
	return rNumber;
	}
}
