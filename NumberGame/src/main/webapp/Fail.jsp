 <html>
<body>
<h5> </h5><br>
<h1 align="center">Oh no <%= request.getAttribute("user") %> you lost! Five tries done!</h1>
<h3 align="center">Score: You have won <%= request.getAttribute("wins") %> time/s in total <%= request.getAttribute("total") %> time/s! </h3>
<h5 align="center">The secret number was <%= request.getAttribute("target") %></h5>
<p align='center'>
<a  href='/NumberGame/numgame' >Try again </a>
</p>
<h5 align='center'>Let your friend take a turn!</h5>
<p align="center">
<a  href='/NumberGame/login'>Login again!</a>
</p>
</body>
</html>