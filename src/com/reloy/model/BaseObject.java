/*
 * Created on Jan 29, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.reloy.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Samuel
 *
 *	This was copied from Matt Raible's org.appfuse.model.BaseObject
 *
 *	Hibernate requires that Objects with composite-ids implement these methods
 * 
 */
public class BaseObject implements Serializable {
	    public String toString() {
	        return ToStringBuilder.reflectionToString(this,
	                ToStringStyle.MULTI_LINE_STYLE);
	    }

	    public boolean equals(Object o) {
	        return EqualsBuilder.reflectionEquals(this, o);
	    }

	    public int hashCode() {
	        return HashCodeBuilder.reflectionHashCode(this);
	    }
}
