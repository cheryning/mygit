package com.inxedu.os.edu.service.answer;

import java.util.List;
import java.util.Map;

import com.inxedu.os.edu.entity.answer.Answer;

public interface AnswerService {

	public   List<Answer>  queryAnswer(int courseId) ;
	
	public  Answer queryAnswerById (int id);
	
	public void createAnswer(String problems,String answer,String operate);

}
