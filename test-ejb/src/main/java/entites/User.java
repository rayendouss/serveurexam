package entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
int id ;
	String email ;
	String pwd ;
	String fName;
	String IName ;
	@Enumerated
	Role role ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public User(String email, String pwd, String fName, String iName, Role role) {
		super();
		this.email = email;
		this.pwd = pwd;
		this.fName = fName;
		IName = iName;
		this.role = role;
	}



	@ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinTable(name="projet_users",joinColumns= {@JoinColumn(name="userid",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="projectid",referencedColumnName="idp")})
	private List<Project> projects;
	
	
	
	public User() {
		
	}
	public User(int id, String email, String pwd, String fName, String iName, Role role, List<Project> projects) {
		
		this.id = id;
		this.email = email;
		this.pwd = pwd;
		this.fName = fName;
		IName = iName;
		this.role = role;
		this.projects = projects;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
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

}
