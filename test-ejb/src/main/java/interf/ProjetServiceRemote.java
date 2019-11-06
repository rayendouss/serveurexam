package interf;

import java.util.Date;

import javax.ejb.Remote;

import entites.Project;
import entites.User;
@Remote
public interface ProjetServiceRemote {
	public int ajouterprojet(Project p);
	public int assignProjectToUser(int projectId, int userId);
	public User  GetUserbyid(int id);
	public void addSprintAndAssignToProject(String description, Date startDate, int idProject);
	public Project Getprbyid(int id);
}
