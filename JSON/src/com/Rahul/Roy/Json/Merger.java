package com.Rahul.Roy.Json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * 
 * @author Rahul
 *
 */

public class Merger 
{
	
	@SuppressWarnings("unchecked")
	public static void read_merge()
	{
		JSONParser jsonParser= new JSONParser();
		try 
		{
		
			FileReader reader = new FileReader("file1.json");
			FileReader reader2= new FileReader("file2.json");
			FileReader reader3= new FileReader("file3.json");
			FileWriter file4= new FileWriter("file4.json");
			
			Object object= jsonParser.parse(reader);
			Object object2= jsonParser.parse(reader2);
			Object object3= jsonParser.parse(reader3);
			JSONArray strikerList= (JSONArray) object;
			strikerList.add(object2);
			strikerList.add(object3);
			System.out.println(strikerList);
			file4.write(strikerList.toJSONString());
			file4.flush();
			System.out.println("File 4 created.");
			file4.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{   
		//First Striker
		JSONObject strikerDetails = new JSONObject();
		strikerDetails.put("Name", "Alexis Sanchez");
		strikerDetails.put("Club", "Manchester United");
		JSONObject strikerDetails2 = new JSONObject();
		strikerDetails2.put("Name", "Robin Van Persie");
		strikerDetails2.put("Club", "Feyenoord");
		
		
		JSONObject strObject= new JSONObject();
		strObject.put("striker", strikerDetails);
		JSONObject strObject2= new JSONObject();
		strObject2.put("striker", strikerDetails2);
		
		
		//Second Striker
		
		JSONObject strikerDetails3 = new JSONObject();
		strikerDetails3.put("Name", "Nicolas Pepe");
		strikerDetails3.put("Club", "Arsenal");
		
		JSONObject strObject3= new JSONObject();
		strObject3.put("striker", strikerDetails3);
		
		
		//Third Striker
		
		JSONObject strikerDetails4 = new JSONObject();
		strikerDetails4.put("Name", "Gonzalo Higuain");
		strikerDetails4.put("Club", "Napoli");
		JSONObject strikerDetails5 = new JSONObject();
		strikerDetails5.put("Name", "Sunil Chettri");
		strikerDetails5.put("Club", "Bengaluru FC");
				
		JSONObject strObject4= new JSONObject();
		strObject4.put("striker", strikerDetails4);
		JSONObject strObject5= new JSONObject();
		strObject5.put("striker", strikerDetails5);
		
		//create arrays to add the strikers
		
		JSONArray strikerList= new JSONArray();
		JSONArray strikerList2= new JSONArray();
		JSONArray strikerList3= new JSONArray();

		//First Array
		strikerList.add(strObject);
		strikerList.add(strObject2);
		//Second Array
		strikerList2.add(strObject3);
		//Third Array
		strikerList3.add(strObject4);
		strikerList3.add(strObject5);
		
		try
		{
			
			FileWriter file1= new FileWriter("file1.json"); 
			FileWriter file2= new FileWriter("file2.json");
			FileWriter file3= new FileWriter("file3.json");
			//write file1
			file1.write(strikerList.toJSONString());
			file1.flush();
			System.out.println("File 1 created.");
			
			//write file2
			file2.write(strikerList2.toJSONString());
			file2.flush();
			System.out.println("File 2 created.");
			//write file3
			file3.write(strikerList3.toJSONString());
			file3.flush();
			System.out.println("File 3 created.");
		}
		catch (IOException e) 
		{
			System.out.println("Error in file writing "+e.getStackTrace());
		}
		
		//Read 3 files, and merge then into a 4th file
		read_merge();
		
	}
}
