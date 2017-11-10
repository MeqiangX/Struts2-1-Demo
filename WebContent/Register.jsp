<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <s:form action="register.action" method="post">
  <s:textfield label="Username" name="custom.username"></s:textfield>
  <s:password label="Password" name="custom.password"></s:password>
  <s:textfield label="Age" name="custom.age"></s:textfield>
  <s:textfield label="Birthday" name="custom.birthday"></s:textfield>
  <s:textfield label="Tel" name="custom.tel"></s:textfield>
  <s:textfield label="Email" name="custom.email"></s:textfield>
  <s:submit value="Register"></s:submit>
  </s:form>
</body>
</html>