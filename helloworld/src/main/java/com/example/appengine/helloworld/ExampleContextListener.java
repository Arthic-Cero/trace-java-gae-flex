package com.example.appengine.helloworld;

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
import java.util.ArrayList;

import io.opencensus.exporter.trace.stackdriver.StackdriverTraceExporter;
import io.opencensus.exporter.trace.stackdriver.StackdriverTraceConfiguration;

public class ExampleContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
        try {
        	 StackdriverTraceExporter.createAndRegister(StackdriverTraceConfiguration.builder().build());
        } catch(Exception e){
        	e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}
