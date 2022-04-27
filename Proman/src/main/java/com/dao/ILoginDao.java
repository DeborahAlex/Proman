package com.dao;

import java.util.List;

import java.time.LocalDate;

import com.proman.ProjectClass;
import com.proman.TaskClass;
import com.proman.TeamClass;
import com.proman.UserClass;

public interface ILoginDao {
	boolean validateUser(String username, String password);
	String checkType(String username, String password);
	void InsertUser(String username, String password, String Type);
	void InsertTeam(String name, String descr);
	void InsertProjTeam(String project,String teams);
	void InsertUserTeam(String users,String team);
	void InsertProj(String name, String client,String dc);
	void Deleteuser(String name, String pwd);
	void Deleteproj(String name);
	void InsertTask(String project, String users, String tname);
	void InsertLog(String uname,String log);
	void EditProfile(String fname, String lname,String dat, String pn,String em);
	void ModifyTag(String task, String tag);
	List<UserClass> listUser();
	List<ProjectClass> listProject();
	List<TeamClass> listTeam();
	List<UserClass> listResources();
	List<TaskClass> listTask(String uname) ;
	List<TaskClass> list_onprogressTask(String project);
	List<TaskClass> list_onholdTask(String project);
	List<TaskClass> list_completedTask(String project);
	List<TaskClass> list_todoTask(String project);
}