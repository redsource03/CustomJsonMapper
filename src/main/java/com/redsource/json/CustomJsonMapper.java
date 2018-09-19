package com.redsource.json;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CustomJsonMapper {

	public static <T> T map(T t, JSONObject obj) {
		for (Field field : t.getClass().getDeclaredFields()) {
			if (field.isAnnotationPresent(JsonMapAnnotation.class)) {
				Annotation annotation = field.getAnnotation(JsonMapAnnotation.class);
				JsonMapAnnotation jsonMapAnnotation = (JsonMapAnnotation) annotation;
				String[] loc = jsonMapAnnotation.loc().split("\\.");
				JSONObject finalObj = recursCall(obj, 0, loc);	
				invokeSetter(t, field.getName(), finalObj.get(loc[loc.length - 1]));

			}
		}
		return t;
	}

	private static JSONObject recursCall(JSONObject obj, int counter, String[] loc) {
		if (counter == loc.length - 1) {
			return obj;
		} else {
			if(loc[counter].contains("[")||loc[counter].contains("]")) {
				Pattern p3 = Pattern.compile("\\[(.*?)\\]");

		        Matcher m3 = p3.matcher(loc[counter]);
		        int number=0;
		        while (m3.find()) {
		           Integer.parseInt(m3.group(1));
		        }
				String name = loc[counter].substring(0, loc[counter].indexOf("["));
				JSONArray arr = (JSONArray) obj.get(name);
				
				return recursCall((JSONObject) arr.get(number), ++counter, loc);
			}else {
				return recursCall((JSONObject) obj.get(loc[counter]), ++counter, loc);
			}
			
		}
	}

	private static void invokeSetter(Object obj, String variableName, Object variableValue) {
		try {

			PropertyDescriptor objPropertyDescriptor = new PropertyDescriptor(variableName, obj.getClass());

			objPropertyDescriptor.getWriteMethod().invoke(obj, variableValue);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
