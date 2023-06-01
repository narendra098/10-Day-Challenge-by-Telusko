package com.example.telusko.Quiz.Application.Repository;

import com.example.telusko.Quiz.Application.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByTech(String tech);
    
}
