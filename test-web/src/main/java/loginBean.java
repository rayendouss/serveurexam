import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Enumerated;

import entites.Role;
import entites.User;
import interf.UserServiceRemote;

@ManagedBean
@SessionScoped
public class loginBean implements Serializable{
	
	String email ;
	String pwd ;
	String fName;
	String IName ;
	User user;
	Role role ;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserServiceRemote getUs() {
		return us;
	}

	public void setUs(UserServiceRemote us) {
		this.us = us;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getIName() {
		return IName;
	}

	public void setIName(String iName) {
		IName = iName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@EJB
	UserServiceRemote us;
	
	public String doLogin() {
		String navigateTo = "null";
		 user = us.getEmployeByEmailAndPassword(email, pwd);
		if (user != null && (user.getRole() == Role.CLIENT || user.getRole() == Role.PRODUCT_OWNER) ) {
			
			
		
			navigateTo = "welcome?faces-redirect=true";
			boolean loggedIn = true;
		} 
		else
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo;
	}
}
