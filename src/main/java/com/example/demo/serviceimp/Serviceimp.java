package com.example.demo.serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
@Service
public class Serviceimp implements StudentService {
	@Autowired
 StudentRepository repo;
	@Override
	public List<Student> getAll() {
		
		return repo.findAll() ;
	}

	@Override
	public Student findbyId(int id) {
		Optional<Student> st=repo.findById(id);
		return st.get();
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return repo.save(student);
	}

	@Override
	public Student update(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> fromDB=repo.findById(student.getId());
		if(fromDB.isPresent()) {
			Student st=fromDB.get();
			st.setName(student.getName());
			return repo.save(st);
		}
		return null ;

	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}