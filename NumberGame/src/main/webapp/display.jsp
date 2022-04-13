 <html>
<body>
<h5> </h5><br>
<h1 align="center">The Number Guessing Game!</h1>
<h5 align="center" >You can do it, <%= request.getAttribute("user") %>! <%= request.getAttribute("trval") %> tries left!</h5>
<h5 align="center" >The target number is <%=request.getAttribute("state")%> than  <%=request.getAttribute("preval")%>!</h5>
<form  action="game" align="center">
<input type="text" name="num" ><br>
<h5> </h5>
<input type="submit" align="center"><br>
</form>
</body>
</html>
  