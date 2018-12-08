package com.inxedu.os.edu.dao.answer;

import com.inxedu.os.edu.entity.answer.Answer;
import java.util.List;
import java.util.Map;


public interface AnswerDao {
	

	public  List<Answer>  queryAnswer(int courseId); 
	

	public Answer queryAnswerById(int id);
	
	public void createAnswer(String problems,String answer,String operate);
  
}