package com.example.demo.service;

import com.example.demo.dao.DemoDao;
import com.example.demo.model.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl implements DemoService{
    @Autowired
    DemoDao demoDao;

    public Action insertAction(Action action)throws Exception{
//        System.out.println("Service");
        if(action.isActionConfirmed()){
            demoDao.insertAction(action);
            action.setActionInserted(true);
        }
        return  action;
    }
}
