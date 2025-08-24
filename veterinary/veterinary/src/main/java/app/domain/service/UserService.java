package app.domain.service;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class UserService {
	
	private UserPort userPort;
	
	
	public void createUser (User User) throws Exception {
		//validar que solo exista una persona con la cedula
		if (userPort.findByDocument(User)!=null) {
			throw new Exception("Ya existe una persona registrada con esa cedula");
		}
		
		//validar que solo exista un usuario con ese userName
		if (userPort.findByUserName(User)!= null) {
			throw new Exception("Ya existe una persona registrada con esa cedula");
		}
		userPort.save(User);
	}
}
