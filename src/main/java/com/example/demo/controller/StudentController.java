package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.exception.Exceptionn;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	StudentService ser;
	@GetMapping
	public ResponseEntity getAll() {
		try {
	List<Student> st=ser.getAll();
	ResponseEntity<List<Student>> response= new ResponseEntity<List<Student>>(st,HttpStatusCode.valueOf(200));
	return response;
		}
		catch (Exception e) {
			Exceptionn ex= new Exceptionn(200, "unamle to retrive student");
			ResponseEntity<Exceptionn> response= new ResponseEntity<>(ex,HttpStatusCode.valueOf(400));
			return response;
			
		
		}
	}
	@PostMapping
	public ResponseEntity save(@RequestBody Student student) {
		try {
		Student studentFeomDB=ser.save(student);
		ResponseEntity<Student> response= new ResponseEntity<Student>(studentFeomDB,HttpStatusCode.valueOf(200));
		return response;
		}
		catch (Exception e) {
			// TODO: handle exception
			Exceptionn ex= new Exceptionn(200, "unable to save");
			ResponseEntity<Exceptionn> response= new ResponseEntity<Exceptionn>(ex,HttpStatusCode.valueOf(400));
			return response;
			
		}
}
	@GetMapping(value="/{id}")
	public ResponseEntity find(@PathVariable ("id") int id) {
		try {
		Student student= ser.findbyId(id);
		ResponseEntity<Student> response= new ResponseEntity<Student>(student,HttpStatusCode.valueOf(200));
		return response;
		}
		catch (Exception e) {
			// TODO: handle exception
			Exceptionn ex=new Exceptionn(400,"unable to find");
			ResponseEntity<Exceptionn> response= new ResponseEntity<Exceptionn>(ex,HttpStatusCode.valueOf(400));
			return response;
			
		}
	}
	@PutMapping
	public ResponseEntity update(@RequestBody Student student) {
		try {
		Student fromDB= ser.update(student);
		ResponseEntity<Student> response= new ResponseEntity<Student>(fromDB,HttpStatusCode.valueOf(200));
		return response;
		}
		catch (Exception e) {
			// TODO: handle exception
			Exceptionn ex= new Exceptionn(400, "unable to update");
			ResponseEntity<Exceptionn> response= new ResponseEntity<Exceptionn>(ex,HttpStatusCode.valueOf(400));
			return response;
		}
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		try {
		ser.delete(id);
		ResponseEntity<String>response= new ResponseEntity<String>("Student deleted",HttpStatusCode.valueOf(200));
		return response;
	}
		catch (Exception e) {
			// TODO: handle exception
			Exceptionn ex= new Exceptionn(400,"unable to delete");
			ResponseEntity<Exceptionn> response= new ResponseEntity<Exceptionn>(ex,HttpStatusCode.valueOf(200));
			return response;
			
		}
	}
}
