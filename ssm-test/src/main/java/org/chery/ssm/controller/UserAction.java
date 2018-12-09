package org.chery.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.chery.ssm.modle.User;
import org.chery.ssm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserAction {
 // private static Logger log = LoggerFactory.getLogger(UserAction.class);

	@Resource
	private UserService userservice;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test (HttpServletRequest request,Model model) {
		
		int sumcount = userservice.countnum();   //�õ��ܼ�¼��
		int page = 0;
		int indexnum = 1;                     //ҳ��
		int size = 3;  							//ÿҳ��ʾ��ҳ��
		//System.out.println(request.getParameter("page"));
		if(request.getParameter("page") != null) {
			indexnum = Integer.parseInt(request.getParameter("page")); //�� ҳ���ȡ��������ҳ��
			page = (indexnum-1)*size;                             //limit�Ŀ�ʼֵ
		}
		//System.out.println(page);
		
		HashMap<String,Object> map = new HashMap<String,Object>(); 
		map.put("page", page);
		map.put("size", size);
		sumcount = sumcount/size;
		List<User> users = userservice.querylist(map);      //��ѯ�������û��б�
		model.addAttribute("listusers", users);				//modle�����ݴ����JSP
		model.addAttribute("sum", sumcount);
		model.addAttribute("indexnum", indexnum);
		return "login";
	}
	
	
	@RequestMapping(value="/show",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> show(String username,String password,HttpServletRequest request) {
		Map<String,Object> map = new HashMap();
      User user =  userservice.getUserByName(username);
      
      if (password.equals(user.getPassword())) {
    	  map.put("stu", "ok");
    	  map.put("user", user);
    	  request.getSession().setAttribute("user", user);
    	  return map;
      }
          map.put("stu", "error");
		return map;
	}
	
	@RequestMapping(value="/file",method=RequestMethod.POST)
	public String file(HttpServletRequest request,MultipartFile file,Model modle) throws IllegalStateException, IOException {
		
		//String username = request.getParameter("username");
		String username = "����";
		
		String filepath = "/images/"+file.getOriginalFilename();
		String url = request.getSession().getServletContext().getRealPath("/images");
	
	
		User user = new User();
		user.setUsername(username);
		user.setImage(filepath);
		file.transferTo(new File(url+"/"+file.getOriginalFilename()));
		System.out.println(url+file.getOriginalFilename());
		userservice.addUser(user);
		modle.addAttribute("user", user);
		return "fileindex";
	}
	
}
