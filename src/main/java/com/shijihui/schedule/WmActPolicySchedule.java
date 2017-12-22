package com.shijihui.schedule;

import com.shijihui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WmActPolicySchedule {

    @Autowired
    private UserService iHotSpotService;
    
    public void work(){
        for ( int i=0; i<10; i++) {
            System.out.println(i);
        }
    }


}
