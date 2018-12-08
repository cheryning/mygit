package com.inxedu.os.edu.entity.answer;

import java.io.Serializable;
import lombok.Data;


/**
 * 考试
 
 */
@Data
public class Answer implements Serializable{
	
	private int id;

	private String subject;
	
	private String answer;
	
	private int course_id;

}
