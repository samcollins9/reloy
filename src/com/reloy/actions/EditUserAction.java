package com.reloy.actions;


import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.PropertyUtils;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import org.apache.log4j.Logger;

import com.reloy.forms.UserInfoForm;
import com.reloy.model.User;


public final class EditUserAction extends BaseAction {


    // ----------------------------------------------------- Instance Variables


    /**
     * The <code>Log</code> instance for this application.
     */
		Logger log = Logger.getLogger(EditUserAction.class);


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


	// Extract attributes we will need
	Locale locale = getLocale(request);
	MessageResources messages = getResources(request);
	HttpSession session = request.getSession();

	String username = request.getParameter("username");
	User user = getUserDAO().getUser(username);

	// Create the user information form & populate it with User's fields
	UserInfoForm uiForm = (UserInfoForm) form;
	//if (user != null) {
		log.info("Populating User Info Form");
        try {
            PropertyUtils.copyProperties(uiForm, user);
        } catch (InvocationTargetException e) {
            Throwable t = e.getTargetException();
            if (t == null)
                t = e;
            log.error("UserInfoForm.populate", t);
            throw new ServletException("RegistrationForm.populate", t);
        } catch (Throwable t) {
            log.error("UserInfoForm.populate", t);
            throw new ServletException("RegistrationForm.populate", t);
        }
//	}

	// set the user information form
	if (form == null) {
	    form = new UserInfoForm();
        if ("request".equals(mapping.getScope()))
        	request.setAttribute(mapping.getAttribute(), form);
        else
            session.setAttribute(mapping.getAttribute(), form);
	}

    // Set a transactional control token to prevent double posting
    log.info(" Setting transactional control token");

    saveToken(request);
    return mapping.findForward("success");

    }//end execute()


}