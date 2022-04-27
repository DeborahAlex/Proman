
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    
    <link rel="stylesheet" href="css/styleadmin.css">
    
   </head>


<body>
  <div class="sidebar" >
    <div class="logo-details">
      <img src="img/LOGO_rm.png" width="100" height="100" left="80px"  top="20px"/> 
      <span class="logo_name" align="left">Proman</span>
      <i class='bx bxl-c-plus-plus'></i>
      
     
    </div>
     <ul class="nav-links">
          <li>
            <a href="pmcreatetask" class="active">
              <i class='bx bx-grid-alt' ></i>
              <span class="links_name">Create Task</span>
            </a>
          </li>
          <li>
            <a href="pmviewtask">
              <i class='bx bx-box' ></i>
              <span class="links_name">View tasks </span>
            </a>
          </li>

         
    
          <li >
            <a href="logout">
              <i class='bx bx-log-out'></i>
              <span class="links_name">Log out</span>
            </a>
          </li>
        </ul>
    </div> 
  <section class="home-section">
    <nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Tasks</span>
      </div>
     
     
    </nav>

    <div class="home-content">
      <div class="overview-boxes">
        <div class="box">
          <div class="right-side">
            <div class="box-topic">TO-DO </div>
           
            
               <% 
				int tdnumber=(Integer)request.getAttribute("tdnumber");
				for(int i=0;i<tdnumber;i++)
				{
					String variable="td"+Integer.toString(i);
				%>
				<div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
				<p class="text"><br/><%= request.getAttribute(variable) %></p>
				<br/>
				</div>
				<%} 
%>				
            
          </div>
        
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">ON-HOLD</div>
  
                             <% 
				int ohnumber=(Integer)request.getAttribute("ohnumber");
				for(int i=0;i<ohnumber;i++)
				{
					String variable="oh"+Integer.toString(i);
				%>
				<div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
				<p class="text"><br/><%= request.getAttribute(variable) %></p>
				<br/>
				</div>
				<%} 
%>				

          
          </div>
          
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">IN-PROGRESS</div>
         
            
                <% 
				int opnumber=(Integer)request.getAttribute("opnumber");
				for(int i=0;i<opnumber;i++)
				{
					String variable="op"+Integer.toString(i);
				%>
				<div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
				<p class="text"><br/><%= request.getAttribute(variable) %></p>
				<br/>
				</div>
				<%} 
%>				

            
          </div>
         
        </div>
        <div class="box">
          <div class="right-side">
            <div class="box-topic">COMPLETED</div>
         
            
                <% 
				int conumber=(Integer)request.getAttribute("conumber");
				for(int i=0;i<conumber;i++)
				{
					String variable="co"+Integer.toString(i);
				%>
				<div class="indicator">
              <i class='bx bx-up-arrow-alt'></i>
				<p class="text"><br/><%= request.getAttribute(variable) %></p>
				<br/>
				</div>
				<%} 
%>				

            
          </div>
         
        </div>
      
      </div>

      



</body>
</html>