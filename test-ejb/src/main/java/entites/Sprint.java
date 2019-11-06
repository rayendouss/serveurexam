package entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="sprint")
public class Sprint implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int ids ;
	Date startdate ;
	String description ;
	@ManyToOne
	Project projet;
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Project getProjet() {
		return projet;
	}
	public void setProjet(Project projet) {
		this.projet = projet;
	}
	public Sprint(Date startdate, String description) {
		super();
		this.startdate = startdate;
		this.description = description;
	}
	public Sprint(Date startdate, String description, Project projet) {
		super();
		this.startdate = startdate;
		this.description = description;
		this.projet = projet;
	}
	
}
