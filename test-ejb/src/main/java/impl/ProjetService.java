package impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entites.Project;
import entites.Sprint;
import entites.User;
import interf.ProjetServiceRemote;
@Stateless
public class ProjetService implements ProjetServiceRemote {
	@PersistenceContext(unitName = "test-ejb")
	EntityManager em;
	@Override
	public int ajouterprojet(Project p) {
		em.persist(p);
		return 0;
	}
	@Override
	public int assignProjectToUser(int projectId, int userId) {
		User u =em.find(User.class, userId);
		System.out.println(u.getfName());
		Project p = em.find(Project.class, projectId);
		System.out.println(p.getTitle());
		List <Project> projects = new ArrayList<Project>() ;
		System.out.println();
		projects.add(p);
	 u.setProjects(projects);
	 em.merge(u);
	 em.merge(p);
	 System.out.println(u.getProjects().size());
	 return u.getProjects().size();
		
		
	}
	public User  GetUserbyid(int id)
	{
	return	em.find(User.class, id);
		
	}
	public Project Getprbyid(int id)
	{
		return em.find(Project.class, id);
	}
	@Override
	public void addSprintAndAssignToProject(String description, Date startDate, int idProject) {
		System.out.println("1");
		Sprint s = new Sprint(startDate,description);
		System.out.println("2222222222222222222"+s.toString());
		s.setProjet(Getprbyid(idProject));
		System.out.println("333333333333"+Getprbyid(idProject).toString());
		System.out.println("444444444"+s.getProjet().getTitle());
		em.persist(s);
		
	}

}
