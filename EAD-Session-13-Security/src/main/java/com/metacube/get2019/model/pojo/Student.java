package com.metacube.get2019.model.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * POJO class for Student table
 * @author Vertika
 *
 */
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="email_id",unique=true)
	private String email;
	
	@Column(name="class")
	private String className;
	
	@Column(name="age")
	private int age;

	
	public Student(){
		super();
	}
	public Student(String firstName, String lastName, String email, String fatherName,String className, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fatherName=fatherName;
		this.className = className;
		this.age = age;
	}

	public Student(int studentId, String firstName, String lastName, String email, String fatherName,
			String className, int age) {
		super();
		this.studentId=studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fatherName=fatherName;
		this.className = className;
		this.age = age;
	}
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
