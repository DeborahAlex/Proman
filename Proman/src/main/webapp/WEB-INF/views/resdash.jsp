
<html lang="en" dir="ltr">
    <head>
      <meta charset="UTF-8">
      <!--<title> Resources Dashboard </title>-->
      <link rel="stylesheet" href="css/styleadmin.css">
      
     </head>
  
  
  <body>
    <div class="sidebar" >
      <div class="logo-details">
        <img src="img/LOGO_rm.png" width="100" height="100" left="80px"  top="20px"/> 
        <span class="logo_name" allign="left">Proman</span>
        <i class='bx bxl-c-plus-plus'></i>
        
       
      </div>
        <ul class="nav-links">
          <li>
            <a href="tagtask" class="active">
              <i class='bx bx-grid-alt' ></i>
              <span class="links_name">Tag Task</span>
            </a>
          </li>
          <li>
            <a href="resworklog">
              <i class='bx bx-box' ></i>
              <span class="links_name">Work log </span>
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
          <span class="dashboard">Resources Dashboard</span>
        </div>
       
        <div class="profile-details">
          <!--<img src="images/profile.jpg" alt="">-->
          <span class="admin_name"><%= request.getAttribute("user") %></span>
          <i class='bx bx-chevron-down' ></i>
        </div>
      </nav>
  
      <div class="home-content">
        <div class="overview-boxes">
          <div class="box">
            <div class="right-side">
              <div class="box-topic">List of projects </div>
                           <% 
				int pnumber=(Integer)request.getAttribute("pnumber");
				for(int i=0;i<pnumber;i++)
				{
					String variable="proj"+Integer.toString(i);
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
              <div class="box-topic">List of teams</div>
              <% 
				int tnumber=(Integer)request.getAttribute("tnumber");
				for(int i=0;i<tnumber;i++)
				{
					String variable="team"+Integer.toString(i);
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