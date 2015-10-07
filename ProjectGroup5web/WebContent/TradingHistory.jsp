<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Team 5 Trading</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href = "bootstrap/css/bootstrap.min.css" rel = "stylesheet">
<link href = "bootstrap/css/styles.css" rel = "stylesheet">
</head>

<body>

<!--********************** TOP NAVBAR **********************-->
<div class = "navbar navbar-default navbar-static-top">
	<div class = "container">
		<img src = "Images/team5logo.jpg" alt="TeamLogo" class=" navbar-brand img-rounded img-responsive pull-left">
		<a href = "#" class = "navbar-brand">Team 5 Trading</a>	
		<button class = "navbar-toggle" data-toggle = "collapse" data-target = ".navHeaderCollapse">
			<span class = "icon-bar"></span>
			<span class = "icon-bar"></span>
			<span class = "icon-bar"></span>
		</button>
	
		<div class = "collapse navbar-collapse navHeaderCollapse">
			<ul class = "nav navbar-nav navbar-right">
				<li class = "active"><a href = "/ProjectGroup5/Index.jsp">Home</a></li>
				<!--<li><a href = "#">Positions</a></li>-->
		
				<li class = "dropdown">
					<a href = "#" class = "dropdown-toggle" data-toggle = "dropdown">Profile<b class = "caret"></b></a>
					<ul class = "dropdown-menu">
					<!-- <a href = "/BuildingBlock/addTCaseToQueue1.html">Trading History</a> -->
						<li><a href = "/ProjectGroup5/TradingHistory.jsp">Trading History</a></li>
						<li><a href = "/ProjectGroup5/Positions.jsp">Positions</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--********************** END OF TOP NAVBAR **********************-->


<script src= "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src= "bootstrap/js/bootstrap.js"></script>
</body>
</html>