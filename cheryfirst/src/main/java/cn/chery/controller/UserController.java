package cn.chery.controller;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.chery.mapper.User_tMapper;
import cn.chery.model.BusinessExpection;
import cn.chery.model.EmBussinsError;
import cn.chery.model.ResultType;
import cn.chery.model.User;
import cn.chery.model.User_t;
import cn.chery.service.UserService;

@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	private Object resultType;
	
	@ResponseBody
	@RequestMapping("/insertuser")
    public String index(HttpServletRequest request) throws ParseException {
		
		System.out.println("调用成功");
	//	System.out.println(request.getParameter("usernum"));
//		Random random = new Random();
//		 int retrunnum = random.nextInt(99999);
//		 retrunnum +=10000;
		String username = request.getParameter("username");
		String pass = request.getParameter("password");
		Integer tel = Integer.parseInt(request.getParameter("tel").trim()); 
		String mail = request.getParameter("mail");
		User user = new User();
		user.setCallphone(tel);
		user.setLoginname(username);
		//user.setPassword(MD5Encoder.encode(pass.getBytes()));
		user.setPassword(pass);
		user.setMail(mail);
//		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//	    String sqlDate = sp.format(new Date());
//	    Timestamp timestamp = Timestamp.valueOf(sqlDate);
	//    user.setCreate(new Date());
		userService.insertSelective(user);
    	return "success";
    }
   
	
	@RequestMapping("/getuser")
	@ResponseBody
	public ResultType getUser(@RequestParam(name="id")Integer id) throws BusinessExpection {
			System.out.println(id);
			User user = new User();
		user = userService.selectByPrimaryKey(id);
		
		if(user == null) {
		//	System.out.println(user);
			throw new BusinessExpection(EmBussinsError.USER_NOT_EXIT);
		}

		
		return ResultType.creat(user);
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handelExpection(HttpServletRequest request,Exception ex) {
		Map<String,Object> mapExpection = new HashMap();
		       if(ex instanceof BusinessExpection) {
				BusinessExpection businessExpection =  (BusinessExpection)ex; 
		//ResultType resultType = new ResultType();
		//resultType.setStatus("fail");
				mapExpection.put("errCode", businessExpection.getErrcode());
				mapExpection.put("errMsg", businessExpection.getErrMsg());
		     // resultType.setData(ex);				
		       }else {
		    	   mapExpection.put("errCode",EmBussinsError.UNKNOWN_ERROR.getErrcode());
					mapExpection.put("errMsg",EmBussinsError.UNKNOWN_ERROR.getErrMsg());
		       }
		       return ResultType.creat(mapExpection, "fail");
	//	return resultType;
		
	}

}
