package jdbc_1connecttest;

import java.sql.Date;

/**
* @author 刘春阳
* @version 创建时间：2020年9月6日 上午9:56:09
* @Description 类描述
*/
public class Customer {
	private int id;
	private String name;
	private String email;
	private Date birth;
	
	public Customer() {}
	public Customer(int id,String name,String email,Date birth) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.birth = birth;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return birth;
	}
	public void setDate(Date date) {
		this.birth = date;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", date=" + birth + "]";
	}
	
}
