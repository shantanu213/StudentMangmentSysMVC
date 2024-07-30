package com.students.StudentMangementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.students.StudentMangementSystem.Service.StudentService;
import com.students.StudentMangementSystem.entity.Students;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private StudentService service;

	@GetMapping("/home")
	public String home() {
		return "home";

	}

	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "students";
	}

	@GetMapping("students/new")
	public String createStudentForm(Model model) {
		Students student = new Students();

		model.addAttribute("students", student);
		return "create-Student";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Students student) {
		service.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		model.addAttribute("student", service.getById(id));
		return "edit_students";
	}

	
	
	
	
	
	
	
	@PostMapping("/students/edit/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Students student) {
		Students existingStudents = service.getById(id);
		existingStudents.setFirstName(student.getFirstName());
		existingStudents.setLastName(student.getLastName());
		existingStudents.setEmail(student.getEmail());
		service.saveStudent(existingStudents);
		return "redirect:/students";
	}
	@GetMapping("/students/{id}")
	public String deletById(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/students";
	}

}
