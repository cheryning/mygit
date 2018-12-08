package com.inxedu.os.edu.service.impl.answer;

import com.inxedu.os.common.cache.EHCacheUtil;
import com.inxedu.os.common.constants.CacheConstans;
import com.inxedu.os.common.entity.PageEntity;
import com.inxedu.os.edu.dao.answer.AnswerDao;
import com.inxedu.os.edu.dao.course.CourseDao;
import com.inxedu.os.edu.entity.answer.Answer;
import com.inxedu.os.edu.entity.course.Course;
import com.inxedu.os.edu.entity.course.CourseDto;
import com.inxedu.os.edu.entity.course.QueryCourse;
import com.inxedu.os.edu.service.answer.AnswerService;
import com.inxedu.os.edu.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Course 课程service接口实现
 */

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	public  List<Answer>  queryAnswer(int courseId){
		
		return answerDao.queryAnswer(courseId);
	}

	@Override
	public Answer queryAnswerById(int id) {
		// TODO Auto-generated method stub
		return answerDao.queryAnswerById(id);
	}

	@Override
	public void createAnswer(String problems, String answer, String operate) {
		// TODO Auto-generated method stub
		
		 answerDao.createAnswer(problems,answer,operate);
	}	
	
	
	
}