package com.students.StudentMangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.StudentMangementSystem.entity.Students;
@Repository
public interface StudentRepository extends JpaRepository<Students, Integer>{

}
