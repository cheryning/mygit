package com.inxedu.os.edu.controller.answer;

import com.inxedu.os.common.controller.BaseController;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.common.util.ObjectUtils;
import com.inxedu.os.common.util.SingletonLoginUtils;
import com.inxedu.os.common.util.WebUtils;
import com.inxedu.os.edu.entity.answer.Answer;
import com.inxedu.os.edu.entity.course.Course;
import com.inxedu.os.edu.entity.course.CourseDto;
import com.inxedu.os.edu.entity.course.CourseFavorites;
import com.inxedu.os.edu.entity.course.QueryCourse;
import com.inxedu.os.edu.entity.kpoint.CourseKpoint;
import com.inxedu.os.edu.entity.subject.QuerySubject;
import com.inxedu.os.edu.entity.subject.Subject;
import com.inxedu.os.edu.entity.system.SysUser;
import com.inxedu.os.edu.entity.teacher.QueryTeacher;
import com.inxedu.os.edu.entity.teacher.Teacher;
import com.inxedu.os.edu.service.answer.AnswerService;
import com.inxedu.os.edu.service.course.CourseFavoritesService;
import com.inxedu.os.edu.service.course.CourseKpointService;
import com.inxedu.os.edu.service.course.CourseService;
import com.inxedu.os.edu.service.subject.SubjectService;
import com.inxedu.os.edu.service.teacher.TeacherService;

import org.apache.poi.util.SystemOutLogger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
/**
 * 考试管理

 */
@Controller
public class AnswerController extends BaseController {

   // private static final String answer = getViewPath("/web/answer/answer");

    @Autowired
	private AnswerService answerService;
    
    @Autowired     
    private CourseService courseService;
    
	 @RequestMapping("/an/answer/{courseId}")
	public ModelAndView showAnswer(HttpServletRequest request,@PathVariable("courseId") int courseId) {
		 ModelAndView model = new ModelAndView();
		 
		 model.setViewName(getViewPath("/web/answer/answer"));
		 List<Answer> answerList = answerService.queryAnswer(courseId);
		 request.getSession().setAttribute("answerUri", WebUtils.getServletRequestUriParms(request));
		 request.setAttribute("courseId", courseId);
		 model.addObject(answerList);
		 return model;
	 }
	
	 
	/* @RequestMapping("/an/testanswer/{courseId}")
	 public Map<String,Object>  testanswer(HttpServletRequest request,HttpServletResponse response,HttpSession session,@PathVariable("courseId") int courseId,Answer answer1) {
		// ModelAndView model = new ModelAndView();
		 Map<String,Object> json = new HashMap<String,Object>();

		
		  List<Answer> answerList = answerService.queryAnswer(courseId);
		//  String  testanswer = answer.getAnswer();
		//  String message = "message";
		  //int courseid = answer.getCourse_id();
		  for(Answer answer:answerList) {    //循环课程所有题目
			  int  ans = answer.getId();   //得到课程id
			  String Sanswer = answer.getAnswer();  //得到课程答案
			 String ansId = String.valueOf(ans);
			   String  testkey=  request.getParameter(ansId);   //获取页面上的答案

			   if(testkey.equals(Sanswer)) {   //如果答案相同  则				   
				   json = this.setJson(true, "正确", null);
				   
				   return json;
			   }
			   
			  
		  }*/
	 /*
	 @RequestMapping("/an/testanswer/{courseId}")
	 public ModelAndView  testanswer(HttpServletRequest request,@PathVariable("courseId") int courseId) {
		// @RequestBody Map<String,String> map
		// System.out.print("data:"+map.size());

		 //在这边直接取出data的值了 然后和
		 ModelAndView model = new ModelAndView();
		 model.setViewName("redirect:/an/answer/"+courseId);
		 Object uri = request.getSession().getAttribute("courseListUri");
	 		if(uri!=null){
	 			model.setViewName("redirect:"+uri.toString());
	 		}
		 List<Answer> answerList = answerService.queryAnswer(courseId); //查出课程所有的题
		 for(Answer answer:answerList) {    //循环课程所有题目
			 int  ans = answer.getId();   //得到课程id
			 String Sanswer = answer.getAnswer();  //得到课程答案
			 String ansId = String.valueOf(ans);
			 String  testkey=  request.getParameter(ansId);   //获取页面上的答案
			 if (testkey.equals(Sanswer) ){                   //页面和答案相同
				 
				 request.setAttribute(ansId, "正确");
			//	 List<Answer> Lanswer = new ArrayList<Answer>();
			//	 Lanswer.add(ans, "正确");
				// model.addObject("ansId",ansId);
				// model.addObject("testkey",testkey);
				 return model;
			 }
			 
		//	 System.out.println(testkey);
		 }
		 
		
		  return model;
		  
	 }
*/

	 @RequestMapping("/an/testanswer/{courseId}")
	 @ResponseBody
	 public String testanswer(HttpServletRequest request,HttpServletResponse response,@PathVariable("courseId") int courseId) {
		
		 int score = 0;
		 Map<String, String> map = request.getParameterMap(); 
		 Map<String,String> json = new HashMap<String,String>();
	  	 JSONObject jsonObject = new JSONObject(map);
	  	 List<Answer> answerList = answerService.queryAnswer(courseId); //查出课程所有的题
	  	 for(Answer answer:answerList) {    //循环课程所有题目
	  		 int  ans = answer.getId();   //得到课程id
			 String Sanswer = answer.getAnswer();  //得到课程答案
			 String ansId = String.valueOf(ans);
			 String Aanswer =	jsonObject.get(ansId).toString().replaceAll("[\\[\\]]", "");
	  		 String Banswer = Aanswer.replace("\"", "");
	  		 if (Banswer.equals(Sanswer)) {
	  			json.put(ansId, "正确");
	  			score = score+10;
	  		 }
	  		 else {
	  			 
	  			json.put(ansId, "错误");
	  		 } 
	  	 }
	  	 if (score>=70) {
	  		 
	  		courseService.updateCpurseById(courseId);
	  	 }
	  	String scoreString = score+"";
	  	json.put("score", scoreString);
	  	 
	  	JSONObject jsonMap = new JSONObject(json);

	  //	System.out.println(jsonMap.toString());
		 return jsonMap.toString();
	 }

}