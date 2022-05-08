/*
 * Created on Mar 6, 2005
 *
 */
package com.reloy.util;

import org.displaytag.model.TableModel;
import org.displaytag.model.HeaderCell;
import java.util.Iterator;
/**
 * @author Samuel
 *
 * Created on Mar 6, 2005
 * 
 * 
 */
public class UserListXMLView extends org.displaytag.export.XmlView{

	private String[] columnNames;
	private int currentColumnIndex = 0;
	
	public void setParameters(TableModel tableModel, boolean exportFullList, boolean includeHeader, boolean decorateValues) {

		Iterator iter = tableModel.getHeaderCellList().iterator();
		columnNames = new String[tableModel.getHeaderCellList().size()];
		int index = 0;
		while (iter.hasNext() ){
			HeaderCell c = (HeaderCell) iter.next();
			columnNames[index++] = c.getTitle();
		}
		super.setParameters(tableModel, exportFullList, includeHeader, decorateValues);
	}

	public String getDocumentStart()
	{
		return "<?xml version=\"1.0\"?>\n<userlist>\n"; //$NON-NLS-1$
	}

	public String getDocumentEnd()
	{
		return "</userlist>\n"; //$NON-NLS-1$
	}
	public String getRowStart(){
		return "<user>";

	}
	public String getRowEnd(){
		return "</user>\n";
	}
	
	public String getCellStart(){
		return "<"+columnNames[currentColumnIndex]+">";
	}
	public String getCellEnd(){
		String ret = "</"+columnNames[currentColumnIndex++]+">\n";
		if (currentColumnIndex == columnNames.length)
			currentColumnIndex = 0;
		return ret;
	}
	
}
