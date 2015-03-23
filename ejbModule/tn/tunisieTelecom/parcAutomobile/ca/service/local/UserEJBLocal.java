package tn.tunisieTelecom.parcAutomobile.ca.service.local;

import javax.ejb.Local;

import tn.tunisieTelecom.parcAutomobile.ca.entity.User;

@Local
public interface UserEJBLocal {
	
	public User authentication (String login,String pass);

}
