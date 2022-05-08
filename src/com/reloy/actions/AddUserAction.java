package com.reloy.actions;

import com.reloy.dao.UserDAO;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.log4j.Logger;

import com.reloy.model.User;


public class AddUserAction extends BaseAction {
    /**
     * The <code>Log</code> instance for this application.
     */

	private static Logger logger = Logger.getLogger(AddUserAction.class);
		
		
		
	public ActionForward execute( ActionMapping mapping,
					ActionForm form,
					HttpServletRequest request,
					HttpServletResponse response )
	throws Exception {

    // --------------------------------------------------------- Public Methods


    /**
     * Process the specified HTTP request, and create the corresponding HTTP
     * response (or forward to another web component that will create it).
     * Return an <code>ActionForward</code> instance describing where and how
     * control should be forwarded, or <code>null</code> if the response has
     * already been completed.
     *
     * @param mapping The ActionMapping used to select this instance
     * @param actionForm The optional ActionForm bean for this request (if any)
     * @param request The HTTP request we are processing
     * @param response The HTTP response we are creating
     *
     * @exception Exception if the application business logic throws
     *  an exception
     */

		ActionForward forward = null;

		User user = null;

		String username = (String) PropertyUtils.getSimpleProperty(form, "username");

		UserDAO userDAO = getUserDAO();

	// Validate the request parameters specified by the user
		ActionErrors errors = new ActionErrors();
		user = userDAO.getUser(username);

	    if (user != null)
       		errors.add(ActionErrors.GLOBAL_ERROR, new ActionError("error.username.unique"));

	// Report any errors we have discovered back to the original form
		if (!errors.isEmpty()) {
	    	saveErrors(request, errors);
            	return (mapping.getInputForward());
		}


		// Invalidate existing session if it exists
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();

		// Create a new session for this user
		session = request.getSession(true);

		request.setAttribute("username", username);
		forward = mapping.findForward( "success" );

		return forward;

	}
}