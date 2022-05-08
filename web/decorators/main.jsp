<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>

<html:html>
<head>
  <title>
   RELOY
  </title>
<link rel="stylesheet" type="text/css" href="root.css" media="all" />
</head>
<body bgcolor="#987654" link="red" alink="red" vlink="red">
 <br /><br /><br /><br />
  <table border="2px" align="center" bordercolor="#000000">
   <table align="center" width="500px" bgcolor="black" border="1px 2px 1px 2px 1px"    cellpadding="2px" cellspacing="0" margin="0">
   <tr>
    <td class="top">
      <%-- header --%>
<div  font-family="verdana" font-size="10px">


	<b><bean:message key="header.welcome"/>
	</b><br />
	This is a Hibernate/HSQLDB example

</div>
    </td>
   </tr>
   <tr>
     <td class="body">
     
        <decorator:body />
        
        <p><small>(<a href="?printable=true">printable version</a>)</small></p>
        
        
      <hr id="dot" width="82%">
      
      <center>
      
      	<%-- menu --%>

<html:link forward="viewusers"><bean:message key="main.viewusers"/></html:link>&nbsp;&nbsp;&nbsp;<html:link forward="newuser"><bean:message key="main.adduser"/></html:link>&nbsp;&nbsp;&nbsp;
      

      </center>
      
     </td>
   </tr>
 </table>
</table>
<br />
<br />
 <center>
      
   <%-- footer --%>
        <font face="verdana" color="red" size="-1" weight="bold">
          <div class="des">
            <b>Reloy Rocks in 2005</b>
          </div>  
        </font>
      
 </center>   
</body>
</html:html>
