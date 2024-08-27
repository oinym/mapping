package com.oinym.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.oinym.mapper.mymapper.MyModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SampleSpringApplication {

    /**
     * Main operation.
     *
     * @param args
     *      command line arguments
     */
    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(SampleSpringApplication.class, args);
        MyModel map=new MyModel();
        map.updateValue("Employee.address.country","USA");
        map.updateValue("Employee.address.city","LA");
        map.updateValue("Employee.Company.name","Google");
        map.updateValue("event.original",map.stringify());
        System.out.println(map.stringify());
    }

}
