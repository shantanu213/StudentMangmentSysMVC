package com.students.StudentMangementSystem.Service;

import java.util.List;

import com.students.StudentMangementSystem.entity.Students;

public interface StudentService {
	public List<Students> getAllStudents();
	public Students saveStudent(Students students);
	public Students getById(int id);
	public void deleteById(int id);
}
