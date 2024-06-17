<!DOCTYPE html>
<html>
<head>
    <title>Fetch User</title>
</head>
<body>
<h1>Fetch User</h1>
<form action="${pageContext.request.contextPath}/api/user/fetch" method="get">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username"><br>
    <button type="submit">Fetch User</button>
</form>
</body>
</html>
