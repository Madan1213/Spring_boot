package com.spring.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.entities.StudentEntity;
import com.spring.crud.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public StudentEntity insertStudent(StudentEntity entity)
	{
		return repo.save(entity);
	}
	
	public List<StudentEntity> getAllStudent()
	{
		return repo.findAll();
	}
	
	public StudentEntity findStudentById(int sid)
	{
		return repo.findById(sid).orElse(null);
	}
	
	public void deleteStudentById(int sid)
	{
		repo.deleteById(sid);
	}
}
