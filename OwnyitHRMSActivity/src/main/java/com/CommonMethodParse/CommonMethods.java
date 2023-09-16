package com.CommonMethodParse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import ownyit.utility.OwnYitJSON;

@Service
public class CommonMethods {

	public float ParseFloat(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Float.parseFloat(strNumber);
		       } catch(Exception e) {
		          return (float) -1;   // or some value to mark this field is wrong. or make a function validates field first ...
		       }
		   }
		   else return (float) 0;
		}
	
	public int ParseInt(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Integer.parseInt(strNumber);
		       } catch(Exception e) {
		          return  -1;   // or some value to mark this field is wrong. or make a function validates field first ...
		       }
		   }
		   else return 0;
		}
	
	public long ParseLong(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Long.parseLong(strNumber);
		       } catch(Exception e) {
		          return  -1;   // or some value to mark this field is wrong. or make a function validates field first ...
		       }
		   }
		   else return 0;
		}
	
	public String encodeBase64(String data) {
		Base64 base64 = new Base64();
		return new String(base64.encode(data.getBytes()));
	}
	
	public String decodeBase64(String data) {
		Base64 base64 = new Base64();
		return new String(base64.decode(data.getBytes()));
	}
	
	public String DateConveter(String original_str) {
		
//		System.out.println(original_str);
		String startDateString = "";
		  try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      

			startDateString = sdf2.format(sdf.parse(original_str));
			System.out.println(startDateString);
//			System.out.println(sdf2.format(sdf.parse(original_str)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
        return startDateString;
	}
	
//	public HashMap<String, String> ArraytoJsonConveter(String array_data) {
//		
//		HashMap<String, String> map_data = null;
//		OwnYitJSON json = new OwnYitJSON();
//	
//			String[] arr = json.toArray(array_data, "data");
//			System.out.println("array ::" + Arrays.toString(arr));
//			
//			for(String query : arr) {
//				map_data = json.parse(query);
//				System.out.println("map ::" + map_data);
//			}
//		return map_data;
//	}
	
	public String[] ArraytojsonComponentData(String array_data) {
		
		String[] array = null;
		OwnYitJSON json = new OwnYitJSON();
	
			array = json.toArray(array_data, "data");
//			System.out.println("array ::" + Arrays.toString(array));
//			System.out.println("array ::" + array);
			
		return array;
	}
	
	public String[] ArraytojsonAttendanceData(String array_data) {
		
		String[] array = null;
		OwnYitJSON json = new OwnYitJSON();
	
			array = json.toArray(array_data, "EMPData");
//			System.out.println("array ::" + Arrays.toString(array));
//			System.out.println("array ::" + array);
			
		return array;
	}
}
