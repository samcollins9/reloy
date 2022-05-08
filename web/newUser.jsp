
<%@ taglib uri="struts-bean.tld" prefix="bean" %>
<%@ taglib uri="struts-html.tld" prefix="html" %>

<html>
<body>

<html:errors/>

<html:form action="/adduser" focus="username">
<table border="0" width="100%">

  <tr>
    <th align="right">
      <bean:message key="prompt.username"/>:
    </th>
    <td align="left">
      <html:text property="username" size="16" maxlength="18"/>
    </td>
  </tr>
  <tr>
    <td align="right">
      <html:submit value="Submit"/>
    </td>
  </tr>

</table>

</html:form>

</body>
</html>



