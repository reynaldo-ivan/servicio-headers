package mx.com.anzen.header.models;

public class UserBeans {
	
	private static UserBeans beans;
	  
	private String user;
	private String pwd;
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public static UserBeans getBeans() {
		return beans;
	}
	public static void setBeans(UserBeans beans) {
		UserBeans.beans = beans;
	}
	
	
	
	

}
