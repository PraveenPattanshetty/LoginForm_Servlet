package DTO;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Fname;
	String Lname;
	String Email;
	int Age;
	long mobile;
	String Passw;
	Date date;
	String gender;
	String address;
	String[] country;
	String[] skills;
}   
