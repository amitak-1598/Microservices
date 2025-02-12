package com.question.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class QuestionServiceImp implements QuestionService {

	private QuestionRepository questionrepository;
	
	@Autowired
	private HibernateCacheStatsLogger cacheStatsLogger;
	
	@PersistenceContext	  
	private EntityManager entitymanager;

	public QuestionServiceImp(QuestionRepository questionrepository) {
		this.questionrepository = questionrepository;
	}

	@Override
	public Question add(Question question) {

		return questionrepository.save(question);
	}

	@Override
	public List<Question> get() {

		return questionrepository.findAll();
	}
                  
	@Override
	public Question get(Long id) {
		 System.out.println("First Fetch:");
			Question question = questionrepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found or No question present"));
			 cacheStatsLogger.logCacheStats();
			 
			 System.out.println("Second Fetch:");
			 Question question2 = questionrepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found or No question present"));
			 cacheStatsLogger.logCacheStats();
			return question;
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long id) {
		       
		return questionrepository.findByQuizId(id);
	}

	
	
//	public Question findByIdInQuestion(Long id) {
//	    Query query = entitymanager.createQuery("FROM Question q WHERE q.id = :id");
//	    query.setParameter("id", id);
//	    query.setHint("org.hibernate.cacheable", true); 
//	    return (Question) query.getSingleResult();
//	}
	
	public Question findById(Long id) {
		
		Question question = questionrepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found or No question present"));		
		return question;
	}

}
