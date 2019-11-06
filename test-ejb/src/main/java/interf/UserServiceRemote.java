package interf;

import javax.ejb.Remote;

import entites.User;


@Remote
public interface UserServiceRemote {
	public int ajouteruser(User u);

	public User getEmployeByEmailAndPassword(String email, String pwd);
}
