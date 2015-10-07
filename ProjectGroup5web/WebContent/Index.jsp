<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="data.dataObjects.StockObject , 
javax.naming.InitialContext, java.util.List, yahooFeed.Feed"%>
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
<!--********************** Jumbotron **********************-->
<div class = "container">
	<div class = "jumbotron">
		<h2 class ="text-center"> Welcome to the Team 5 Trading Hub</h2>
		<p>Please select a relevant Market from the Market dropdown and then a company to view live market data for that Company. </p>
		<div class = "text-center">
			<form class="form-inline" id="liveData" action="CompanySymbolServlet" method="POST">
	  			<div class="form-group">
	    			<label for="market">Market: </label>
	   			 	<select class="form-control" name="market">
						<option value="" selected disabled>Please select</option>
						<option>Market Name</option>
					</select>
	  			</div>
	  			<div class="form-group">
	    			<label for="company">Company: </label>
	   			 	<select class="form-control" name="company">
						<option value="" selected disabled>Please select</option>
						<option value ="AAPL">Apple(AAPL)</option>
						<option value ="MSFT">Microsoft(MSFT)</option>
						<option value ="CSCO">Cisco(CSCO)</option>
						<option value ="IBM">IBM(IBM)</option>
						<option value ="LSE.L">London Stock Exchange</option>
					</select>
	  			</div>
	  			<button  type="submit" class="btn btn-success">Submit</button>
			</form>
		</div>
	</div>	
</div>
<!--******************** End of Jumbotron *****************-->
<!--********************** Columns Fluid Grid - Article Entries **********************-->
<div class = "container">
<div class = "row">
	<div class="col-md-6 panel panel-success">
  		<div class="panel-heading">Live Market Data</div>
		  <div class="panel-body" id="tableHolder">
			
		</div>
	</div>

	<div class="col-md-6 panel panel-success">
		<div class="panel-heading">Strategy</div>
		  <div class="panel-body">
		    <p>//:TODO!!</p>
			<p class = "text-center"><a class="btn btn-success" href="#" role="button">To Do</a>
		  </div>
	</div>
</div>
</div>

<!--********************** Fixed Bottom NAVBAR **********************-->
<!--  <div class = "container">
	<div class = "navbar navbar-default navbar-fixed-bottom">
		<img src = "Resources/images/citi_200_year.gif" alt="Citi200Years" class=" navbar-brand img-rounded img-responsive pull-right">
	</div>
</div>-->
<script src= "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src= "bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
      refreshTable();
    });

    function refreshTable(){
        $('#tableHolder').load('LiveTableData.jsp', function(){
           setTimeout(refreshTable, 1000);
        });
    }
</script>

</body>
</html>