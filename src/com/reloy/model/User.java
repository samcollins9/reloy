package com.reloy.model;

import java.util.Date;



public class User extends BaseObject{
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private Date birthday = new Date();
    

    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Returns the firstName.
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param firstName The firstName to set.
     */
    public void setUsername(String userName) {
        this.username = userName;
    }

    /**
     * @return Returns this user's birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday The birthday to set.
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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