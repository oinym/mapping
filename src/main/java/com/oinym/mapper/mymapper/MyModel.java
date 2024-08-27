package com.oinym.mapper.mymapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class MyModel {
    private Map<String,Object> map;
    
    public MyModel() {
        this.map = new HashMap<>();
    }
    
    public Map updateValue(String nestedKey,Object value){
        String[] keys=nestedKey.split("\\.");
        Map<String,Object> currentMap=this.map;
        
        // Iterate through the keys, except the last one and create it if not exists
        for (int i = 0; i < keys.length - 1; i++) {
            String key = keys[i];
            
            // If the key doesn't exist, create a new nested HashMap
            if (!currentMap.containsKey(key) || !(currentMap.get(key) instanceof Map)) {
                currentMap.put(key, new HashMap<String, Object>());
                
            }
            
            currentMap = (Map<String, Object>) currentMap.get(key);
            
        }
        
        // Set the new value at the last key
        try {
            currentMap.put(keys[keys.length - 1], value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return currentMap;
    }
    
    public String stringify(){
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(this.map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
