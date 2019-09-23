package com.metacube.get2019.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
/**
 * model attribute for update student form
 * @author Vertika
 *
 */
public class UpdateStudentCommands {

	//validation constraints
		private int studentId;
		
		@NotBlank(message="{requiredField}")
		@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
		private String firstName;
		
		@NotBlank(message="{requiredField}")
		@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
		private String lastName;
		
		@NotBlank(message="{requiredField}")
		@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
		private String fatherName;
		
		
		@NotNull
		private int age;
		
		@NotBlank(message="{requiredField}")
		@Size(max = 10, message="{fixedSize}")
		private String className;
		
		@NotBlank(message="{requiredField}")
		@Email(message="{emailFormat}")
		private String email;
		
		//Getters and Setters of the data members
		
		
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
		public String getFatherName() {
			return fatherName;
		}
		public void setFatherName(String fatherName) {
			this.fatherName = fatherName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getClassName() {
			return className;
		}
		public void setClassName(String className) {
			this.className = className;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	}


