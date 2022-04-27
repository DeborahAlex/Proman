<!DOCTYPE html>
<html>
  <head>
    <title>Tag Task</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <style>
      html, body {
      min-height: 100%;
      padding: 0;
      margin: 0;
      font-family: Roboto, Arial, sans-serif;
      font-size: 14px;
      color: #666;
      }
      h1 {
      margin: 0 0 20px;
      font-weight: 400;
      color: #0A2558;
      }
      p {
      margin: 0 0 5px;
      }
      .main-block {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      background: #0A2558;
      }
      form {
      padding: 25px;
      margin: 25px;
      box-shadow: 0 2px 5px #f5f5f5; 
      background: #f5f5f5; 
      }
      .fas {
      margin: 25px 10px 0;
      font-size: 72px;
      color: #fff;
      }
      .fa-envelope {
      transform: rotate(-20deg);
      }
      .fa-at , .fa-mail-bulk{
      transform: rotate(10deg);
      }
      input, textarea {
      width: calc(100% - 18px);
      padding: 8px;
      margin-bottom: 20px;
      border: 1px solid #0A2558;
      outline: none;
      }
      input::placeholder {
      color: #666;
      }
      button {
      width: 100%;
      padding: 10px;
      border: none;
      background: #0A2558;
      font-size: 16px;
      font-weight: 400;
      color: #fff;
      }
      button:hover {
      background: #2371a0;
      }    
      @media (min-width: 568px) {
      .main-block {
      flex-direction: row;
      }
      .left-part, form {
      width: 50%;
      }
      .fa-envelope {
      margin-top: 0;
      margin-left: 20%;
      }
      .fa-at {
      margin-top: -10%;
      margin-left: 65%;
      }
      .fa-mail-bulk {
      margin-top: 2%;
      margin-left: 28%;
      }
      }
    </style>
  </head>
  <body>
    <div class="main-block">
      <div class="left-part">
        <i class="fas fa-envelope"></i>
        <i class="fas fa-at"></i>
        <i class="fas fa-mail-bulk"></i>
      </div>
      <form action="tagtasks" method="post">
        <h1>Tag Task</h1>
        <div class="info">
         <label for="tasks">Choose a Task</label>

<select name="task" id="task">
 <% 
int tnumber=(Integer)request.getAttribute("tnumber");
for(int i=0;i<tnumber;i++)
{
	String variable="task"+Integer.toString(i);
%>
<option value="<%= request.getAttribute(variable) %>"><%= request.getAttribute(variable) %></option>
<%} 
%>
</select>
         
         
         
        
        </div>
        
        <br/>
        <br/>
           <div class="info">
         <label for="tasks">Tag</label>

<select name="tag" id="tag">
  <option value="TO-DO">To-do</option>
  <option value="ON-PROGRESS">In-progress</option>
  <option value="ON-HOLD">On-hold</option>
  <option value="COMPLETED">Completed</option>
</select>
         
         
         
        
        </div>
        <br/>
        <br/>
        <button type="submit" href="/">Submit</button>
      </form>
    </div>
  </body>
</html>