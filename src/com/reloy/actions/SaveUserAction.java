package com.reloy.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;

//import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import org.apache.log4j.Logger;

import com.reloy.forms.UserInfoForm;
import com.reloy.model.User;

public final class SaveUserAction extends BaseAction {


    // ----------------------------------------------------- Instance Variables

    /**
     * The <code>Log</code> instance for this application.
     */
		Logger log = Logger.getLogger(SaveUserAction.class);

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
    public ActionForward execute(ActionMapping mapping,
				 ActionForm form,
				 HttpServletRequest request,
				 HttpServletResponse response)
		throws Exception {

	// Extract attributes and parameters we will need
		Locale locale = getLocale(request);
		MessageResources messages = getResources(request);
		HttpSession session = request.getSession();

		UserInfoForm regform = (UserInfoForm) form;
		String username = regform.getUsername();
		User user = getUserDAO().getUser(username);
		if (user == null)
			user = new User();
		
	// Was this transaction cancelled?
		if (isCancelled(request)) {
			log.info("Action cancelled");
			return mapping.findForward("success");
		}

    // Validate the transactional control token
		ActionErrors errors = new ActionErrors();


	// Validate the request parameters specified by the user
		String value = null;
		value = regform.getUsername();

	// Report any errors we have discovered back to the original form
		if (!errors.isEmpty()) {
	    	saveErrors(request, errors);
        	return (mapping.getInputForward());
		}

	// Update the user's persistent profile information
    try {
        PropertyUtils.copyProperties(user, regform);
    } catch (InvocationTargetException e) {
        Throwable t = e.getTargetException();
         if (t == null) {
             t = e;
         }
         log.error("Registration.populate", t);
         throw new ServletException("Registration.populate", t);
     } catch (Throwable t) {
         log.error("Registration.populate", t);
         throw new ServletException("Subscription.populate", t);
     }

	//save user (to original data source		
		getUserDAO().saveUser( user );
		
	// Remove the obsolete form bean
		if (mapping.getAttribute() != null) {
            if ("request".equals(mapping.getScope()))
                request.removeAttribute(mapping.getAttribute());
            else
                session.removeAttribute(mapping.getAttribute());
        }

    	return (mapping.findForward("success"));

    }
}