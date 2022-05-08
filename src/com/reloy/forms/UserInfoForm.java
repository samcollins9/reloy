package com.reloy.forms;


import javax.servlet.http.HttpServletRequest;
//import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean for the user registration page.  This form has the following
 * fields, with default values in square brackets:
 * <ul>
 * <li><b>action</b> - The maintenance action we are performing (Create,
 *     Delete, or Edit).
 * <li><b>fromAddress</b> - The EMAIL address of the sender, to be included
 *     on sent messages.  [REQUIRED]
 * <li><b>fullName</b> - The full name of the sender, to be included on
 *     sent messages.  [REQUIRED]
 * <li><b>password</b> - The password used by this user to log on.
 * <li><b>password2</b> - The confirmation password, which must match
 *     the password when changing or setting.
 * <li><b>replyToAddress</b> - The "Reply-To" address to be included on
 *     sent messages.  [Same as from address]
 * <li><b>username</b> - The registered username, which must be unique.
 *     [REQUIRED]
 * </ul>
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.1 $ $Date: 2004/01/25 05:46:35 $
 */

public final class UserInfoForm extends ValidatorForm  {


    // ----------------------------------------------------- Instance Variables

	private String username = null;
	private String firstname = null;
	private String lastname = null;	
	private String birthday = null;

    // --------------------------------------------------------- Public Methods


    /**
     * Reset all properties to their default values.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        this.lastname=null;
        this.firstname=null;
    }


    /**
     * Validate the properties that have been set from this HTTP request,
     * and return an <code>ActionErrors</code> object that encapsulates any
     * validation errors that have been found.  If no errors are found, return
     * <code>null</code> or an <code>ActionErrors</code> object with no
     * recorded error messages.
     *
     * @param mapping The mapping used to select this instance
     * @param request The servlet request we are processing
     */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Perform validator framework validations
    //    ActionErrors errors = super.validate(mapping, request);

        // Only need crossfield validations here
  //      if (!password.equals(password2)) {
  //           errors.add("password2",
  //                     new ActionError("error.password.match"));
  //      }



        return null;

    }


	/**
	 * @return Returns the birthday.
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday The birthday to set.
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return Returns the username.
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username The username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return Returns the firstname.
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname The firstname to set.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return Returns the lastname.
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname The lastname to set.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
