<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register User</h1>
<form action="${pageContext.request.contextPath}/api/user/register" method="post">
    <label for="firstname">First Name:</label>
    <input type="text" id="firstname" name="firstname"><br>
    <label for="lastname">Last Name:</label>
    <input type="text" id="lastname" name="lastname"><br>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email"><br>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password"><br>
    <button type="submit">Register</button>
</form>
</body>
</html>
