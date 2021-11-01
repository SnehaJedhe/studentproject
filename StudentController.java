
package com.javabykiran;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
	
  @Autowired
  SessionFactory sessionFactory;
  ArrayList<Student> al;
  
  
  
  
  
  //GIVES REQUIRED OUTPUT ON INSERTION OF ID
  @RequestMapping("students/{rno}")
  Student names(@PathVariable int rno)
  {
	  System.out.println("sessionfactory>>"+sessionFactory);
	  Session session = sessionFactory.getCurrentSession();
	  
	  Student student = (Student)session.load(Student.class,rno);
	  System.out.println(student);
	  
	  
	  return student;
  }
  
  
  
 
  
  
  
  
  
  
  //SHOW ALL STUDENTS USING LIST
  @RequestMapping("students")
   List<Student> allStudents()
   {
 	  System.out.println("sessionfactory>>"+sessionFactory);
 	  Session session = sessionFactory.getCurrentSession();
 	  return session.createCriteria(Student.class).list();
   }
 
  
  
  
  
  
   //DELETS DATA OF REQUESTED STUDENT
   @DeleteMapping("students/delete/{rno}")
   String delete(@PathVariable int rno)
   {
      Session session = sessionFactory.getCurrentSession();
      Student student = session.load(Student.class, rno);
      Transaction transaction = session.beginTransaction();
      session.delete(student);
      transaction.commit();
	  return "Deleted sucessfully.....";
   }
   
   
   
   
   //UPDATES STUDENTS PROFILE
   @PutMapping("students/update")
   String update(@RequestBody Student student)
   {  
	  Session session = sessionFactory.getCurrentSession();
	  Transaction transaction = session.beginTransaction();	  
	  Student studentFromDatabase = session.load(Student.class,student.getId());
	  studentFromDatabase.setName(student.name);
	  studentFromDatabase.setDateofbirth(student.dateofbirth);
	  studentFromDatabase.setDateofjoin(student.dateofjoin);
	  studentFromDatabase.setPnumber(student.pnumber);
      session.update(studentFromDatabase);
      transaction.commit();
	  return "student updated sucessfully....";
   }
   

   
   
   
   //RECORD INSETRION CODE
   
   @PostMapping("students/insert")
	public String saveStudent(@RequestBody Student student)
	{
		
		Session session = sessionFactory.getCurrentSession();
		
	
		Transaction transaction = session.beginTransaction();
		
        session.save(student);
		
		transaction.commit();
		
		return "Record is addded";
		
		
		
	}

   
   
   
}
