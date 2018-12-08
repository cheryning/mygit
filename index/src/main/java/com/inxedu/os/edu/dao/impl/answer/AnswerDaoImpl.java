package com.inxedu.os.edu.dao.impl.answer;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.edu.dao.answer.AnswerDao;

import com.inxedu.os.edu.entity.answer.Answer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 *
 */
@Repository("answerDao")
public class AnswerDaoImpl extends GenericDaoImpl implements AnswerDao {

	@Override
	public List<Answer> queryAnswer(int courseId) {
		// TODO Auto-generated method stub
		return this.selectList("AnswerMapper.queryAnswer", courseId);
	}

	@Override
	public Answer queryAnswerById(int id) {
		// TODO Auto-generated method stub
		return this.selectOne("AnswerMapper.queryAnswerById", id);
	}

	@Override
	public void createAnswer(String problems, String answer, String operate) {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("problems", problems);
		map.put("answer", answer);
		map.put("operate", operate);
		this.insert("AnswerMapper.createAnswer",map);
		
	}
	

}
