package com.example.telusko.Quiz.Application.Controller;

import com.example.telusko.Quiz.Application.Model.Question;
import com.example.telusko.Quiz.Application.Repository.QuestionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class QuestionController {
    
    @Autowired
    QuestionRepository questionRepository;
    
    @GetMapping("/")
    public String home(Model model){
     return "home";
    }
    

    @GetMapping("/getquestions")
    public String getallquestions(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "question-list";
    }

    @GetMapping("/addquestion")
    public String addnewquestion(Model model){
        Question question = new Question();
        model.addAttribute("question", question);
        return "addquestion";
    }

    @PostMapping("/addquestion")
    public String addquestion(@ModelAttribute("question") Question question){
        questionRepository.save(question);
        return "redirect:/getquestions";
    }

    @GetMapping("/editquestion/{id}")
    public String editquestion(@PathVariable int id, Model model){
        model.addAttribute("question", questionRepository.findById(id).get());
        return "edit-question";
    }

    @PostMapping("/updatequestion/{id}")
	public String updateStudent(@PathVariable int id,
			@ModelAttribute("question") Question question,
			Model model) {
		
		// get student from database by id
        Question existingquestion = questionRepository.findById(id).get();
		System.out.println("exis question:   >>>"+ existingquestion.getQuestionText());
		existingquestion.setId(id);
		existingquestion.setQuestionText(question.getQuestionText());
        existingquestion.setOptions(question.getOptions());
        existingquestion.setCorrectOption(question.getCorrectOption());
        existingquestion.setTech(question.getTech());
        System.out.println("question: >>>"+existingquestion.getQuestionText());

		questionRepository.save(existingquestion);
		
		return "redirect:/getquestions";		
	}

    @GetMapping("deletequestion/{id}")
    public String deletequestion(@PathVariable int id){
        System.out.println("id >>>>"+id);
        questionRepository.deleteById(id);
        return "redirect:/getquestions";
    }


    @GetMapping("/selecttech")
    public String selecttech(Model model){
        return "selectionpage";
    }

    @GetMapping("/quiz/{tech}")
    public String quiz(@PathVariable String tech, Model model){

        List<Question> questions = questionRepository.findByTech(tech);
        model.addAttribute("questions", questions);
        return "quiz";
    }


    @PostMapping("/submit")
    public String submitquiz(@RequestParam Map<String, String> formParams,Model model){
           
            int totalQuestions = 0;
            int correctAnswers = 0;
            HashMap<Integer, Integer> submittedanswers = new HashMap<>();
            for (Map.Entry<String, String> entry : formParams.entrySet()) {
               
                String value = entry.getValue();
                String[] parts = value.split(":");
                int key = Integer.parseInt(parts[0]);
                int val = Integer.parseInt(parts[1]);

                submittedanswers.put(key, val);
                totalQuestions++;
     
            }

            System.out.println("submitted answers: >>>>"+submittedanswers);
            
            for (Map.Entry<Integer, Integer> entry : submittedanswers.entrySet()) {
                Integer id = entry.getKey();
                Integer submitted_answer = entry.getValue()+1;

                Question question= questionRepository.findById(id).get();
                int actual_answer = question.getCorrectOption();
                System.out.println("question: "+question.getQuestionText());
                System.out.println("submitted answer: "+submitted_answer+" actual_answer: "+actual_answer);
                if(submitted_answer == actual_answer){
                    correctAnswers++;
                }
                
                
            }

            model.addAttribute("score", correctAnswers);
            model.addAttribute("total_questions", totalQuestions);
            
        
       
        
        return "result";
    }




}
 
