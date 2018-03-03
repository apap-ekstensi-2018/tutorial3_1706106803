package com.example.tutorial3.service;

import java.util.ArrayList;
import java.util.List;
import com.example.tutorial3.model.StudentModel;
import java.util.ListIterator;

public class InMemoryStudentService implements StudentService{
	private static List<StudentModel> studentList = new ArrayList<StudentModel>();
	
	@Override
	public StudentModel selectStudent(String npm) {
		//get student list : using enhance loop
		for(StudentModel student: studentList) {
			if(student.getNpm().equals(npm)) {				
				return student;
			}
		}
		return null;
	}
	
	@Override
	public List<StudentModel> selectAllStudents(){
		return studentList;
	}
	
	@Override
	public void addStudent(StudentModel student) {
		studentList.add(student);
	}
	
	//add method delete
	public boolean deleteStudent(String npm) {
		boolean flag = false;
		if(this.selectStudent(npm) != null) {
			ListIterator<StudentModel> iter = studentList.listIterator();
			while(iter.hasNext()){
			    if(iter.next().getNpm().equals(npm)){
			        iter.remove();
			        flag = true;
			        break;
			    }
			}
			
		}
		
		return flag;
	}
}
