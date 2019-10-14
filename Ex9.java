package com.exam;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Ex9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JSON 파싱하기
		String path= Ex9.class.getResource("personList.json").getPath();
		//파일객체 준비
		 File file=new File(path);
		 
		 //파일문자 입력스트림 준비
		 FileReader reader = null;
		 try {
			 reader = new FileReader(file);
			 
			 
			//json파서 준비하기
			 JSONParser jsonParser = new JSONParser();
			//json 파싱 수행하기
			JSONArray jsonArray =(JSONArray) jsonParser.parse(reader);
			
			Iterator iter = jsonArray.iterator();
			while(iter.hasNext()) {
				JSONObject jsonObject = (JSONObject) iter.next();
				//System.out.println("id:" + jsonObject.get("id")+"\t");
				//System.out.println("name:"+jsonObject.get("name")+"\t");
				//System.out.println("company: "+jsonObject.get("company"));
				Set<String> keySet = jsonObject.keySet();
				for(String key : keySet) {
					Object value= jsonObject.get(key);
					System.out.print(key+ ": " + value+"\t");
					
				}
				System.out.println();
			}//WHILE
		} catch (Exception e) {
			// TODO: handle exception
		}
		//JSON 파서 준비하기
		JSONParser jsonP = new JSONParser();
		//jsonP.parse(in);
	}

}
