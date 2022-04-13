<html>
<body>
<h5> </h5><br>
<h1 align="center">The Number Guessing Game!</h1>
<h2 align="center">Congratulations <%= request.getAttribute("user") %>! You won in <%= request.getAttribute("trval") %> tries! </h2>
<h3 align="center">Score: You have won <%= request.getAttribute("wins") %> time/s in total <%= request.getAttribute("total") %> time/s! </h3>
<p align='center'>
<a  href='/NumberGame/numgame' >Try again </a>
</p>
<h5 align='center'>Let's see if your friend can beat you!</h5>
<p align="center">
<a  href='/NumberGame/login' >Login again!</a>
</p>
</body>
</html>