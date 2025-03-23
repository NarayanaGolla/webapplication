package com.cog.dao;

import com.cog.dom.Student;
import com.cog.dom.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>  {
}
