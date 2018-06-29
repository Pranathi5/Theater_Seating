package com.controller;

import java.util.List;
import java.util.Scanner;

import com.model.TheaterLayout;
import com.model.TheaterRequest;
import com.util.TheaterSeatingUtil;


public class TheatreSeating {
    
    public static void main(String[] args) {
        
        String line;
        StringBuilder layoutBuilder = new StringBuilder();
        StringBuilder ticketRequestsBuilder = new StringBuilder();
        boolean isLayoutActive = true;
        
        System.out.println("Please enter Theater Layout and List of ticket requests and then enter 'process'.\n");
        
        Scanner input = new Scanner(System.in);

        while((line = input.nextLine()) != null && !line.equalsIgnoreCase("process")){
            
            if(line.length() == 0){
                isLayoutActive = false;
                continue;
            }
            if(isLayoutActive){
                layoutBuilder.append(line + System.lineSeparator());
            }else{
                ticketRequestsBuilder.append(line + System.lineSeparator());
            }
        }
        
        input.close();
        
        TheaterSeatingUtil util = new TheaterSeatingUtil();
        
        try{
        
            TheaterLayout theaterLayoutObj = util.constructTheaterLayout(layoutBuilder.toString());
            
            List<TheaterRequest> theaterRequestsObj = util.constructListOfTicketRequest(ticketRequestsBuilder.toString());
            
            util.processTicketRequests(theaterLayoutObj, theaterRequestsObj);
            
            
        }catch(Exception e){
        	
        	System.out.println("failed to parse input please check");
    
        }

        
        
    }

}
