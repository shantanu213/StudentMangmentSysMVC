package com.students.StudentMangementSystem.serviceIMpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.StudentMangementSystem.Service.StudentService;
import com.students.StudentMangementSystem.entity.Students;
import com.students.StudentMangementSystem.repository.StudentRepository;

@Service
public class ServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Students> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Students saveStudent(Students students) {

		return studentRepository.save(students);
	}

	@Override
	public Students getById(int id) {

		return studentRepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		
		studentRepository.deleteById(id);
	}

}
