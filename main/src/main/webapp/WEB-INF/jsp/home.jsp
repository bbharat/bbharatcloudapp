<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head></head>
<body>
<b>Welcome to Manage User Database REST Application.</b><br /><br /><br />

<b>This is a simple application for exposing 3 basic REST APIs for managing a User Database.</b>

<li> Add a User (Sample Request): <br /> curl http://bbharatcloudapp.cloudfoundry.com/rest/users -d '{"userkey":"4","firstname":"bharat","lastname":"bharat","email":"b@b.com"}' -X POST -H "Content-Type: application/json"</li>
<li> <a href="http://bbharatcloudapp.cloudfoundry.com/rest/users">View Complete User Database</a> </li>
<li> <a href="http://bbharatcloudapp.cloudfoundry.com/rest/users/1">Search User by User Key</a> </li>

</body>
</html>
