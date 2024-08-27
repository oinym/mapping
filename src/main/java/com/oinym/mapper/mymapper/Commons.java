package com.oinym.mapper.mymapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Commons {
    public static String stringifyObject(Map<String,Object> myMap){
        ObjectMapper mapper=new ObjectMapper();
        try {
            return mapper.writeValueAsString(myMap);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
