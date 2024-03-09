<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
</head>
<body>

<form action="/api/v1/auth/Authenticate" method="post">
    <input type="email" name="email" placeholder="Email@example.com" required>
    <input type="password" name="password" required>
    <input type="submit" value="Login">
</form>
</body>
</html>