package com.redsource.json;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class App {
    public static void main( String[] args ){
    	JSONParser parser = new JSONParser();

        try {
 
            Object obj = parser.parse(new FileReader(
                    "test.json"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            System.out.println(jsonObject.toJSONString());
            TestModel t = new TestModel();
            
            CustomJsonMapper.map(t, jsonObject);
            
            System.out.println(t.getCity());
            System.out.println(t.getFirstname());
            System.out.println(t.getHobbies().toJSONString());
            System.out.println(t.getAge());
            System.out.println(t.getFirstInterest());
            System.out.println(t.getMusic().toJSONString());
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
