package com.javabykiran;

import static javax.persistence.GenerationType.IDENTITY;



import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student 
{

  @Id
  
	 
 int id;
 String name;
 String pnumber;
 String dateofbirth;
 String dateofjoin;
 
 
 public Student()
 {
	 
 }
 
@Column(name="id")
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}



@Column(name="name")
public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}

@Column(name="pnumber")
public String getPnumber() {
	return pnumber;
}


public void setPnumber(String pnumber) {
	this.pnumber = pnumber;
}


@Column(name="dateofbirth")
public String getDateofbirth() {
	return dateofbirth;
}


public void setDateofbirth(String dateofbirth) {
	this.dateofbirth = dateofbirth;
}



@Column(name="dateofjoin")
public String getDateofjoin() {
	return dateofjoin;
}


public void setDateofjoin(String dateofjoin) {
	this.dateofjoin = dateofjoin;
}


@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", pnumber=" + pnumber + ", dateofbirth=" + dateofbirth
			+ ", dateofjoin=" + dateofjoin + "]";
}
 
 
}
