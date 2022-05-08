<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<html>
<body>

Users:<br/><br/>

<display:table name="userList" requestURI="viewusers.do" export="true" pagesize="10" sort="list" id="user" >

    <display:setProperty name="export.csv.filename" value="reloy_users.csv" />
    <display:setProperty name="export.pdf.filename" value="reloy_users.pdf" />
    <display:setProperty name="export.xml.filename" value="reloy_users.xml" />
    <display:column property="id" sort="true" title="id"/>
    <display:column property="username" sort="true" title="User"/>
    <display:column property="firstname" sort="true" title="First Name"/>
    <display:column property="lastname" sort="true" title="Last Name"/>
    <!--display:column property="birthday" sort="true" title="Account Created"/-->
</display:table>

</body>
</html>