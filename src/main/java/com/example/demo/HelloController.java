package com.example.demo;

import com.example.demo.model.Action;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.UUID;


@RestController
public class HelloController {

	@Autowired
	DemoService demoService;

	@PostMapping ("/action")
	public Action postAction(@RequestBody Action action) throws Exception{
		System.out.println("Request Received from Device");
		String sessionId = StringUtils.isEmpty(action.getSessionId())
				? UUID.randomUUID().toString()
				: action.getSessionId();
		action.setSessionId(sessionId);
		action.setTimestamp(Calendar.getInstance());
		action.setActionConfirmed(true);
		return demoService.insertAction(action);
	}
}
