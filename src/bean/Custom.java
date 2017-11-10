package bean;

import java.sql.Date;

public class Custom {
     private String username;
     private String password;
     private int age;
     private Date birthday;
     private String tel;
     private String email;
	public Custom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Custom(String username, String password, int age, Date birthday, String tel, String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.birthday = birthday;
		this.tel = tel;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
     
     
   
}
