package com.spring.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.spring.crud.entities.StudentEntity;
import com.spring.crud.service.StudentService;

@Controller
public class StudentController 
{
	String m = "Trying to Merge";
	String a ="ABCD";
	@Autowired
	StudentService service;
	
	@GetMapping("/")
	public String createStudent(Model model)
	{
		model.addAttribute("entity" , new StudentEntity());
		return "AddStudent";
	}
	
	@PostMapping("/save")
	public String registerStudent(@ModelAttribute("entity") StudentEntity entity)
	{
		service.insertStudent(entity);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String getAllStudents(Model model)
	{
		List<StudentEntity> student = service.getAllStudent();
		model.addAttribute("student", student);
		return "StudentList";
	}
	
	@GetMapping("/edit/{sid}")
	public String getStudentById(@PathVariable int sid, Model model)
	{
		StudentEntity entity = service.findStudentById(sid);
		if(entity.equals(null))
				return "errors";
		model.addAttribute("entity", entity);
		return "EditStudent";
	}
	
	@PostMapping("/update")
	public String updateStudentById( @ModelAttribute("entity") StudentEntity entity)
	{
		service.insertStudent(entity);
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{sid}")
	public String deleteStudentById(@PathVariable int sid)
	{
		service.deleteStudentById(sid);
		return "redirect:/list";
	}
	
}
