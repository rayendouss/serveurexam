package entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="project")
public class Project implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int idp ;
	String title ;
	String description ;
	
	
	public Project() {
		
	}
	public Project(int idp, String title, String description, List<Sprint> sprints, List<User> users) {
		
		this.idp = idp;
		this.title = title;
		this.description = description;
		this.sprints = sprints;
		this.users = users;
	}
	public int getIdp() {
		return idp;
	}
	public void setIdp(int idp) {
		this.idp = idp;
	}
	public List<Sprint> getSprints() {
		return sprints;
	}
	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Project(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy="projet",fetch=FetchType.EAGER)
	private List<Sprint> sprints;
	
	@ManyToMany
	@JoinTable(name="projet_users",joinColumns= {@JoinColumn(name="projectid",referencedColumnName="idp")},
	inverseJoinColumns={@JoinColumn(name="userid",referencedColumnName="id")})
	private List<User> users;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
