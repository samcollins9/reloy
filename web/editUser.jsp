<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>

<html>
<body>

<html:form action="/saveuser.do">

<table border="0" width="100%">

  <tr>
    <th align="right">
      <bean:message key="prompt.username"/>:
    </th>
    <td align="left">
<%=request.getAttribute("username")%>
<input type="hidden" name="username" value="<%=request.getAttribute("username")%>">

    </td>
  </tr>
  <tr>
    <th align="right">
      <bean:message key="prompt.firstname"/>:
    </th>
    <td align="left">
        <html:text property="firstname" size="16" maxlength="16"/>
    </td>
  </tr>
  <tr>
    <th align="right">
      <bean:message key="prompt.lastname"/>:
    </th>
    <td align="left">
        <html:text property="lastname" size="16" maxlength="16"/>
    </td>
  </tr>

  <tr>
    <td align="right">
      <html:submit>
        <bean:message key="button.save"/>
      </html:submit>
    </td>
    <td align="left">
      <html:reset>
        <bean:message key="button.reset"/>
      </html:reset>
      &nbsp;
      
    </td>
  </tr>

</table>
</html:form>

</body>
</html>