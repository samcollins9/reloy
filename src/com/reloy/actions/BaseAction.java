/*
 * Created on Jan 8, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.reloy.actions;

import org.apache.struts.action.Action;
import com.reloy.dao.*;
import com.reloy.dao.impl.*;
/**
 * @author Samuel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BaseAction extends Action{

	protected UserDAO getUserDAO(){
		return new HibernateUserDAO();
	}	
}