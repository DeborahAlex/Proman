package com.dao.impl;

import com.dao.ILoginDao;
import com.proman.ProjectClass;
import com.proman.TaskClass;
import com.proman.TeamClass;
import com.proman.UserClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;


@Repository
public class LoginDaoImpl implements ILoginDao {

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	public boolean validateUser(String username, String password) {
		// TODO Auto-generated method stub
		int count=jdbcTemplate.queryForObject("select count(*) from Users  where username=? and password=?",Integer.class,username,password);
		if (count==1)
		{	
			return true;
		}
		else
			return false;
	}
	public String checkType(String username, String password) {
		
			 String type=jdbcTemplate.queryForObject("select Type from Users  where username=? and password=? ",String.class,username,password);
			 return type;
		 
	}
	public void InsertUser(String username, String password, String Type)
	{
		String sql="insert into Users values (?,?,?)";
		jdbcTemplate.update(sql,username,password, Type);
	}
	public void InsertTeam(String name, String descr)
	{
		String sql="insert into Teams values (?,?)";
		jdbcTemplate.update(sql,name,descr);
	}
	
	
	public void Deleteuser(String name, String pwd)
	{
		String sql="delete from Users where username=?";
		jdbcTemplate.update(sql,name);
	}
	
	public void Deleteproj(String name)
	{
		String sql="delete from Project where name=?";
		jdbcTemplate.update(sql,name);
	}
	
	
	
	
	public void InsertProj(String name, String client,String dc)
	{
		String sql="insert into Project values (?,?,?)";
		jdbcTemplate.update(sql,name,client,dc);
	}
	
	public void InsertProjTeam(String project, String teams)
	{
		String sql="insert into ProjectTeam values (?,?)";
		jdbcTemplate.update(sql,project,teams);
	}
	
	public void InsertTask(String project, String users, String tname)
	{
		String sql="insert into Task values (?,?,?,?)";
		jdbcTemplate.update(sql,project,users, tname,"TO-DO");
	}
	
	public void ModifyTag(String task, String tag)
	{
		String sql="update task set tag=? WHERE task=?";
		jdbcTemplate.update(sql,tag,task);
	}
	
	public List<UserClass> listUser() {
	    String sql = "SELECT * FROM Users";
	    List<UserClass> listuser = jdbcTemplate.query(sql, new RowMapper<UserClass>() {
	 
	        public UserClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	UserClass user = new UserClass();
	 
	            user.setName(rs.getString("Username"));
	            
	 
	            return user;
	        }
	 
	    });
	 
	    return listuser;
	}
	public List<UserClass> listResources() {
	    String sql = "SELECT * FROM Users WHERE Type='res'";
	    List<UserClass> listuser = jdbcTemplate.query(sql, new RowMapper<UserClass>() {
	 
	        public UserClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	UserClass user = new UserClass();
	 
	            user.setName(rs.getString("Username"));
	            
	 
	            return user;
	        }
	 
	    });
	 
	    return listuser;
	}
	public List<ProjectClass> listProject() {
		String sql = "SELECT * FROM Project";
	    List<ProjectClass> projectuser = jdbcTemplate.query(sql, new RowMapper<ProjectClass>() {
	 
	        public ProjectClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	ProjectClass project = new ProjectClass();
	 
	            project.setName(rs.getString("name"));
	            
	 
	            return project;
	        }
	 
	    });
	 
	    return projectuser;
	}
	public List<TeamClass> listTeam() {
		String sql = "SELECT * FROM teams";
	    List<TeamClass> teamuser = jdbcTemplate.query(sql, new RowMapper<TeamClass>() {
	 
	        public TeamClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TeamClass team = new TeamClass();
	            team.setName(rs.getString("name"));
	            return team;
	        }
	 
	    });
	 
	    return teamuser;
	}
	
	public List<TaskClass> listTask(String uname) {
		String sql = "SELECT * FROM task WHERE Resource='"+uname+"'";
	    List<TaskClass> taskC = jdbcTemplate.query(sql, new RowMapper<TaskClass>() {
	 
	        public TaskClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TaskClass t = new TaskClass();
	            t.setName(rs.getString("Task"));
	            return t;
	        }
	 
	    });
	 
	    return taskC;
	}
	
	public List<TaskClass> list_todoTask(String project) {
		
		
		
		
		String sql = "SELECT * FROM task where tag='TO-DO' and Project='"+project+"'";
	    List<TaskClass> taskC = jdbcTemplate.query(sql, new RowMapper<TaskClass>() {
	 
	        public TaskClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TaskClass t = new TaskClass();
	            t.setName(rs.getString("Task"));
	            return t;
	        }
	 
	    });
	 
	    return taskC;
	}
	
	public List<TaskClass> list_onholdTask(String project) {
		
		String sql = "SELECT * FROM task where tag='ON-HOLD' and Project='"+project+"'";
	    List<TaskClass> taskC = jdbcTemplate.query(sql, new RowMapper<TaskClass>() {
	 
	        public TaskClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TaskClass t = new TaskClass();
	            t.setName(rs.getString("Task"));
	            return t;
	        }
	 
	    });
	 
	    return taskC;
	}
	
	public List<TaskClass> list_onprogressTask(String project) {
		
		String sql = "SELECT * FROM task where tag='ON-PROGRESS' and Project='"+project+"'";
	    List<TaskClass> taskC = jdbcTemplate.query(sql, new RowMapper<TaskClass>() {
	 
	        public TaskClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TaskClass t = new TaskClass();
	            t.setName(rs.getString("Task"));
	            return t;
	        }
	 
	    });
	 
	    return taskC;
	}
	
	
	public List<TaskClass> list_completedTask(String project) {
		
		String sql = "SELECT * FROM task where tag='COMPLETED' and Project='"+project+"'";
	    List<TaskClass> taskC = jdbcTemplate.query(sql, new RowMapper<TaskClass>() {
	 
	        public TaskClass mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	TaskClass t = new TaskClass();
	            t.setName(rs.getString("Task"));
	            return t;
	        }
	 
	    });
	 
	    return taskC;
	}
	
	public void InsertUserTeam(String users, String team) {
		String sql="insert into UserTeam values (?,?)";
		jdbcTemplate.update(sql,users,team);
	}
	public void InsertLog (String uname,String log)
	{
		String sql="INSERT INTO Worklog VALUES(?,?)";
		jdbcTemplate.update(sql,uname,log);
	}
	public void EditProfile(String fname, String lname,String dat, String pn,String em)
	{
		String sql="INSERT INTO usertable (fname, lname, dat,pn,email) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(sql,fname,lname,dat,pn,em);
	}
	
}