package com.proman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class promanController {
	
	@RequestMapping({"/login" , "/"})
	public String getLoginpage()
	{
		return "login";
	}
	@RequestMapping("/dashboard")
	public String getDashboard()
	{
		return "dashboard";
	}
	@RequestMapping("/admindash")
	public String getAdminDash()
	{
		return "admindash";
	}
	@RequestMapping("/busdevdash")
	public String getBusDevDash()
	{
		return "busdevdash";
	}
}
