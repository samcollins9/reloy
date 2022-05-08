/*
 * Created on Jan 8, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.reloy.dao;
import java.util.List;

import com.reloy.model.User;
/**
 * @author Samuel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface UserDAO {
	public User getUser(String userName);
	
	public void saveUser(User user);
	
	public List getAllUsers();
}
