package com.guessinggame.springmvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import com.dao.ILoginDao;

@Controller
public class GameController {
	@Autowired
	ILoginDao loginDao;
	@RequestMapping("/numgame")
	public ModelAndView getNumGamepage()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user.getUsername());
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping("/login")
	public String getLoginpage()
	{
		return "login.jsp";
	}
	@RequestMapping("/signup")
	public String getSignuppage()
	{
		return "signup.jsp";
	}
	@Autowired
	User user;
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public ModelAndView checkUser(@RequestParam String username, @RequestParam String password)
	{
		ModelAndView mv = new ModelAndView();
		System.out.println("Reached checkUser in Controller");
		boolean loginFlag=loginDao.validateUser(username, password);
		if (loginFlag==true) {
			System.out.println("Validated");
			user.setUsername(username);
			mv.addObject("user", username);
			mv.setViewName("index.jsp");
			return mv;
		}
		else
		{
			System.out.println("Not Validated");
			mv.setViewName("signup.jsp");
			return mv;
		}
	}
	@RequestMapping(value="/dosignup",method=RequestMethod.POST)
	public String insertUser(@RequestParam String username, @RequestParam String password,@RequestParam String repassword )
	{
		
		if (password.equals(repassword))
		{
			loginDao.insertUser(username, password);
			return "login.jsp";
		
		}
		else
		{
			return "errormp.jsp";
		}
		
	}
	
	@Autowired
	GameModel model;
	@RequestMapping("/game")
	public ModelAndView game(HttpServletRequest request, HttpServletResponse  response)
	{
		if(model.getTries()==0) {
		int tnumber = 1 + (int)(100* Math.random());
		int i=1;
		System.out.println(tnumber);
		model.setTargetNumber(tnumber);
		model.setTries(i);
		}
		int target=model.getTargetNumber();
		int trnum=model.getTries();
		System.out.println("Target"+target);
		System.out.println("trnum"+trnum);
		int uinput=Integer.parseInt(request.getParameter("num"));
		trnum+=1;
		model.setTries(trnum);
		model.setPreval(uinput);
		
		ModelAndView mv = new ModelAndView();
		if(uinput==target)
		{
			user.setWins();
			user.setTotal();
			mv.setViewName("win.jsp");
			mv.addObject("user",user.getUsername());
			mv.addObject("trval",trnum-1);
			mv.addObject("wins", user.getWins());
			mv.addObject("total", user.getTotal());
			model.setTargetNumber(0);
			model.setTries(0);
		    return mv;
		}
		 else if(uinput>target && trnum<6)
		 {
			mv.setViewName("display.jsp");
			mv.addObject("trval",6-trnum);
			mv.addObject("preval",model.getPreval());
			mv.addObject("state","lesser");
			mv.addObject("user",user.getUsername());
			return mv;
		 }
		 else if(uinput<target && trnum<6)
		 {
			mv.setViewName("display.jsp");
			mv.addObject("trval",6-trnum);
			mv.addObject("preval",model.getPreval());
			mv.addObject("state","greater");
			mv.addObject("user",user.getUsername());
			return mv;
		 }
		user.setTotal();
		mv.addObject("wins", user.getWins());
		mv.addObject("total", user.getTotal());
		mv.addObject("user",user.getUsername());
		mv.setViewName("Fail.jsp");
		mv.addObject("target",target);
		model.setTargetNumber(0);
		model.setTries(0);
		return mv;
	}
	
}
