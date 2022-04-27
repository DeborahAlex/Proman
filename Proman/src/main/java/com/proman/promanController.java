package com.proman;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.dao.ILoginDao;

@Controller
public class promanController {
	@Autowired
	CurrentUser Cuser;
	@Autowired
	ILoginDao loginDao;
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
	
	@RequestMapping("/resworklog")
	public String getWorkLog()
	{
		return "res_worklog";
	}
	
	@RequestMapping("/tagtask")
	public ModelAndView gettagtask()
	{
		ModelAndView mv = new ModelAndView();
		List<TaskClass> t=loginDao.listTask(Cuser.getName());
		int num=0;
		String taskval;

		for(TaskClass model : t) {
			System.out.println(model.getName());
            String variable="task"+Integer.toString(num);
            taskval=model.getName();
            mv.addObject(variable, taskval);
            num+=1;
        }
		
		
		mv.addObject("tnumber",t.size());
		mv.setViewName("tag_task");
		return mv;
	}
	
	@RequestMapping("/admindash")
	public ModelAndView getAdminDash()
	{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	@RequestMapping("/busdevdash")
	public ModelAndView getBusDevDash()
	{
ModelAndView mv = new ModelAndView();
mv.addObject("user", Cuser.getName());
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("resdash");
		return mv;
	}
	@RequestMapping("/resources")
	public ModelAndView getResDash()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("resdash");
		return mv;
	}
	@RequestMapping("/manager")
	public ModelAndView ManDash()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("mandash");
		return mv;
	}
	@RequestMapping("/adminadduser")
	public String getadduser()
	{
		return "admin_adduser";
	}
	@RequestMapping("/admindeluser")
	public String getdeluser()
	{
		return "admin_deluser";
	}
	@RequestMapping("/admindelproj")
	public String getdelProj()
	{
		return "admin_delproj";
	}
	
	
	
	@RequestMapping("/admincreateproject")
	public String getaddproject()
	{
		return "admin_addproject";
	}
	@RequestMapping("/admincreateteam")
	public String getaddteam()
	{
		return "createteam";
	}
	
	@RequestMapping("/buseditprof")
	public String geteditprof()
	{
		return "bus_edit_profile";
	}
	
	@RequestMapping("/container")
	public String getcontainer()
	{
		return "container";
	}
	
	@RequestMapping("/pmcreatetask")
	public ModelAndView getcreatetask()
	{
		ModelAndView mv = new ModelAndView();
		
		List<ProjectClass> p=loginDao.listProject();
		List<UserClass> u=loginDao.listResources();
		int num=0;
		 String projval;
		 String userval;
		 for(ProjectClass model : p) {
	            System.out.println(model.getName());
	            String variable="pro"+Integer.toString(num);
	            projval=model.getName();
	            mv.addObject(variable, projval);
	            num+=1;
	        }
		 num=0;
		 for(UserClass model : u) {
	            System.out.println(model.getName());
	            String variable="user"+Integer.toString(num);
	            userval=model.getName();
	            mv.addObject(variable, userval);
	            num+=1;
	        }
	   
		 mv.addObject("pnumber",p.size());
		 mv.addObject("unumber",u.size());
		 mv.setViewName("pm_create_task");
		 return mv;
	}
	
	@RequestMapping("/pmviewtask")
	public ModelAndView getviewtask()
	{
		ModelAndView mv = new ModelAndView();
		List<ProjectClass> p=loginDao.listProject();
		int num=0;
		 String projval;
		 for(ProjectClass model : p) {
	            System.out.println(model.getName());
	            String variable="pro"+Integer.toString(num);
	            projval=model.getName();
	            mv.addObject(variable, projval);
	            num+=1;
	        }
		 
		 mv.addObject("pnumber",p.size());
		
		 mv.setViewName("view_task");
		 return mv;
	}
	
	@RequestMapping("/logout")
	public String getlogout()
	{
		return "login";
	}
	@RequestMapping("/busdevassignteam")
	public ModelAndView assignTeam()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("allocate_mem");
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		 String projval;
		 String teamval;
		 for(ProjectClass model : p) {
	            System.out.println(model.getName());
	            String variable="pro"+Integer.toString(num);
	            projval=model.getName();
	            mv.addObject(variable, projval);
	            num+=1;
	        }
		 num=0;
		 for(TeamClass model : t) {
	            System.out.println(model.getName());
	            String variable="team"+Integer.toString(num);
	            teamval=model.getName();
	            mv.addObject(variable, teamval);
	            num+=1;
	        }
	    //add object to model in Spring controller
		 mv.addObject("pnumber",p.size());
		 mv.addObject("tnumber",t.size());
		 mv.setViewName("busdev_assignteam");
		return mv;
	}
	

	@RequestMapping(value="/on_bus_editprof",method=RequestMethod.POST)
	public ModelAndView editprof(@RequestParam String fname, @RequestParam String lname, @RequestParam String dat, String pn, String em)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		loginDao.EditProfile(fname,lname,dat,pn,em);
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("busdevdash");
		return mv;
	}
	
	@RequestMapping("/adminallocmem")
	public ModelAndView getallocmem() {
		ModelAndView mv = new ModelAndView();
		
		List<UserClass> u=loginDao.listUser();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		 String userval;
		 String teamval;
		 for(UserClass model : u) {
	            System.out.println(model.getName());
	            String variable="user"+Integer.toString(num);
	            userval=model.getName();
	            mv.addObject(variable, userval);
	            num+=1;
	        }
	   
	    //add object to model in Spring controller
		 mv.addObject("unumber",u.size());
		 num=0;
		
		 for(TeamClass model : t) {
	            System.out.println(model.getName());
	            String variable="team"+Integer.toString(num);
	            teamval=model.getName();
	            mv.addObject(variable, teamval);
	            num+=1;
	        }
	   
	    //add object to model in Spring controller
		 mv.addObject("unumber",u.size());
		 mv.addObject("tnumber",t.size());
		 mv.setViewName("allocate_mem");
		 return mv;
	}
	
	@RequestMapping(value="/createuser",method=RequestMethod.POST)
	public ModelAndView InsertUser(@RequestParam String username, @RequestParam String password, @RequestParam String type)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.InsertUser(username,password,type);
		mv.addObject("user", username);
		mv.addObject("user", Cuser.getName());
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	
	
	@RequestMapping(value="/createproj",method=RequestMethod.POST)
	public ModelAndView InsertProj(@RequestParam String name, @RequestParam String client,@RequestParam String dc)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.InsertProj(name,client,dc);
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;
		mv.addObject("user", Cuser.getName());
		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	
	@RequestMapping(value="/tagtasks",method=RequestMethod.POST)
	public ModelAndView TagTask(@RequestParam String task, @RequestParam String tag)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.ModifyTag(task,tag);
			
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		mv.addObject("user", Cuser.getName());
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("resdash");
		return mv;
	}
	
	@RequestMapping(value="/deluser",method=RequestMethod.POST)
	public ModelAndView DeleteUser(@RequestParam String name, @RequestParam String pwd)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.Deleteuser(name,pwd);
		mv.addObject("user", Cuser.getName());
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	
	
	@RequestMapping(value="/delproj",method=RequestMethod.POST)
	public ModelAndView Deleteproj(@RequestParam String name)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.Deleteproj(name);
		mv.addObject("user", Cuser.getName());
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	
	@RequestMapping(value="/createteam",method=RequestMethod.POST)
	public ModelAndView InsertTeam(@RequestParam String name, @RequestParam String descr)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.InsertTeam(name,descr);		
		mv.addObject("user", Cuser.getName());
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	@RequestMapping(value="/projteam",method=RequestMethod.POST)
	public ModelAndView ProjTeam(@RequestParam String project, @RequestParam String teams)
	{
		ModelAndView mv = new ModelAndView();
		loginDao.InsertProjTeam(project,teams);		
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("busdevdash");
		return mv;
	}
	@RequestMapping(value="/userteam",method=RequestMethod.POST)
	public ModelAndView UserTeam(@RequestParam String users, @RequestParam String team)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		loginDao.InsertUserTeam(users,team);		
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	@RequestMapping(value="/createproject",method=RequestMethod.POST)
	public ModelAndView InsertProject(@RequestParam String name, @RequestParam String client,@RequestParam String descr)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		loginDao.InsertProj(name,client,descr);		
		List<UserClass> u=loginDao.listUser();
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
		String userval;
		String projval;
		String teamval;

		for(UserClass model : u) {
			System.out.println(model.getName());
            String variable="user"+Integer.toString(num);
            userval=model.getName();
            mv.addObject(variable, userval);
            num+=1;
        }
		num=0;
		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("unumber",u.size());
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("admindash");
		return mv;
	}
	
	@RequestMapping(value="/viewtasks",method=RequestMethod.POST)
	public ModelAndView ViewTask(@RequestParam String project)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		List <TaskClass> oh= loginDao.list_onholdTask( project);	
		List <TaskClass> op= loginDao.list_onprogressTask( project);
		List <TaskClass> td=loginDao.list_todoTask( project);	
		List <TaskClass> co=loginDao.list_completedTask( project);
		int num=0;
		
		String ohval;
		String tdval;
		String opval;
		String coval;
		System.out.println("TASKS:");
		for(TaskClass model : oh) {
			System.out.println(model.getName());
            String variable="oh"+Integer.toString(num);
            ohval=model.getName();
            mv.addObject(variable, ohval);
            num+=1;
        }
		num=0;
		for(TaskClass model : op) {
			System.out.println(model.getName());
            String variable="op"+Integer.toString(num);
            opval=model.getName();
            mv.addObject(variable, opval);
            num+=1;
        }
		num=0;
		for(TaskClass model : td) {
			System.out.println(model.getName());
            String variable="td"+Integer.toString(num);
            tdval=model.getName();
            mv.addObject(variable, tdval);
            num+=1;
        }
		
		num=0;
		for(TaskClass model : co) {
			System.out.println(model.getName());
            String variable="co"+Integer.toString(num);
            coval=model.getName();
            mv.addObject(variable, coval);
            num+=1;
        }
		mv.addObject("ohnumber",oh.size());
		mv.addObject("tdnumber",td.size());
		mv.addObject("conumber",co.size());
		mv.addObject("opnumber",op.size());
		 mv.setViewName("container");
		return mv;
	}
	
	@RequestMapping(value="/createtask",method=RequestMethod.POST)
	public ModelAndView InsertTask(@RequestParam String project, @RequestParam String users,@RequestParam String tname)
	{
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		loginDao.InsertTask(project,users,tname);		
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("mandash");
		return mv;
	}
	
	@RequestMapping(value="/worklog",method=RequestMethod.POST)
	public ModelAndView InsertLog(@RequestParam String uname, @RequestParam String log)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		LocalDate td= java.time.LocalDate.now();   
		loginDao.InsertLog(uname,log);
		List<ProjectClass> p=loginDao.listProject();
		List<TeamClass> t=loginDao.listTeam();
		int num=0;
	
		String projval;
		String teamval;

		for(ProjectClass model : p) {
			System.out.println(model.getName());
            String variable="proj"+Integer.toString(num);
            projval=model.getName();
            mv.addObject(variable, projval);
            num+=1;
        }
		num=0;
		for(TeamClass model : t) {
			System.out.println(model.getName());
            String variable="team"+Integer.toString(num);
            teamval=model.getName();
            mv.addObject(variable, teamval);
            num+=1;
        }
		mv.addObject("pnumber",p.size());
		mv.addObject("tnumber",t.size());
		mv.setViewName("resdash");
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView checkUser(@RequestParam String text, @RequestParam String pass)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", Cuser.getName());
		System.out.println("Reached checkUser in Controller");
		boolean loginFlag=loginDao.validateUser(text, pass);
		if (loginFlag==true) {
			System.out.println("Validated");
			String Type=loginDao.checkType(text,pass);
			System.out.println(Type);
			
			Cuser.setName(text);
			if (Type.equals("admin"))
			{
			mv.addObject("user", Cuser.getName());
			
			List<UserClass> u=loginDao.listUser();
			List<ProjectClass> p=loginDao.listProject();
			List<TeamClass> t=loginDao.listTeam();
			int num=0;
			String userval;
			String projval;
			String teamval;

			for(UserClass model : u) {
				System.out.println(model.getName());
	            String variable="user"+Integer.toString(num);
	            userval=model.getName();
	            mv.addObject(variable, userval);
	            num+=1;
	        }
			num=0;
			for(ProjectClass model : p) {
				System.out.println(model.getName());
	            String variable="proj"+Integer.toString(num);
	            projval=model.getName();
	            mv.addObject(variable, projval);
	            num+=1;
	        }
			num=0;
			for(TeamClass model : t) {
				System.out.println(model.getName());
	            String variable="team"+Integer.toString(num);
	            teamval=model.getName();
	            mv.addObject(variable, teamval);
	            num+=1;
	        }
			mv.addObject("unumber",u.size());
			mv.addObject("pnumber",p.size());
			mv.addObject("tnumber",t.size());
			mv.setViewName("admindash");
			return mv;
			}
			else if (Type.equals("busdev"))
			{
				mv.addObject("user", Cuser.getName());
				List<ProjectClass> p=loginDao.listProject();
				List<TeamClass> t=loginDao.listTeam();
				int num=0;
			
				String projval;
				String teamval;

				for(ProjectClass model : p) {
					System.out.println(model.getName());
		            String variable="proj"+Integer.toString(num);
		            projval=model.getName();
		            mv.addObject(variable, projval);
		            num+=1;
		        }
				num=0;
				for(TeamClass model : t) {
					System.out.println(model.getName());
		            String variable="team"+Integer.toString(num);
		            teamval=model.getName();
		            mv.addObject(variable, teamval);
		            num+=1;
		        }
				mv.addObject("pnumber",p.size());
				mv.addObject("tnumber",t.size());
				mv.setViewName("busdevdash");
				return mv;
			}
			else if (Type.equals("res"))
			{
				mv.addObject("user", Cuser.getName());
				List<ProjectClass> p=loginDao.listProject();
				List<TeamClass> t=loginDao.listTeam();
				int num=0;
			
				String projval;
				String teamval;

				for(ProjectClass model : p) {
					System.out.println(model.getName());
		            String variable="proj"+Integer.toString(num);
		            projval=model.getName();
		            mv.addObject(variable, projval);
		            num+=1;
		        }
				num=0;
				for(TeamClass model : t) {
					System.out.println(model.getName());
		            String variable="team"+Integer.toString(num);
		            teamval=model.getName();
		            mv.addObject(variable, teamval);
		            num+=1;
		        }
				mv.addObject("pnumber",p.size());
				mv.addObject("tnumber",t.size());
				mv.setViewName("resdash");
				return mv;
			}
			else if (Type.equals("man"))
			{
				mv.addObject("user", Cuser.getName());
				List<ProjectClass> p=loginDao.listProject();
				List<TeamClass> t=loginDao.listTeam();
				int num=0;
			
				String projval;
				String teamval;

				for(ProjectClass model : p) {
					System.out.println(model.getName());
		            String variable="proj"+Integer.toString(num);
		            projval=model.getName();
		            mv.addObject(variable, projval);
		            num+=1;
		        }
				num=0;
				for(TeamClass model : t) {
					System.out.println(model.getName());
		            String variable="team"+Integer.toString(num);
		            teamval=model.getName();
		            mv.addObject(variable, teamval);
		            num+=1;
		        }
				mv.addObject("pnumber",p.size());
				mv.addObject("tnumber",t.size());
				mv.setViewName("mandash");
				return mv;
			}
		}
					//ADD FAILURE PAGE
			System.out.println("Not Validated");
			mv.setViewName("login");
			return mv;
		
	}
}