<html>
<body>
<h5> </h5><br>
<h1 align="center">The Number Guessing Game!</h1>
<h5 align="center" > Hi <%= request.getAttribute("user") %>! Guess the secret number between 1 and 100 in 5 tries</h5>
<form  action="game" align="center">
<input type="text" name="num"><br>
<h5> </h5>
<input type="submit"><br>
</form>
</body>
</html>
