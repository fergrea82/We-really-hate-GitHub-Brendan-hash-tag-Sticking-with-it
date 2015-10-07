<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="data.dataObjects.*, 
javax.naming.InitialContext, java.util.List, yahooFeed.Feed"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<table class="table table-striped">
				<tr>
					<th>Symbol</th>
					<th>Bid Price</th>
					<th>Ask Price</th>
					<th>Time</th>
				</tr>
				<%
				StockObject AAPL = Feed.feedConnection("AAPL");
				StockObject MSFT = Feed.feedConnection("MSFT");
				StockObject CSCO = Feed.feedConnection("CSCO");
				StockObject IBM = Feed.feedConnection("IBM");
				StockObject LSEL = Feed.feedConnection("LSE.L");
				%>
				<tr>			
					<td>AAPL</td>
					<td><%=AAPL.getBidPrice() %></td>
					<td><%=AAPL.getAskPrice() %></td>
					<td><%=AAPL.getStockTime().toString()%></td>
				</tr>
				<tr>			
					<td>MSFT</td>
					<td><%=MSFT.getBidPrice() %></td>
					<td><%=MSFT.getAskPrice() %></td>
					<td><%=MSFT.getStockTime().toString() %></td>
				</tr>
				<tr>			
					<td>CSCO</td>
					<td><%=CSCO.getBidPrice() %></td>
					<td><%=CSCO.getAskPrice() %></td>
					<td><%=CSCO.getStockTime().toString()%></td>
				</tr>
				<tr>			
					<td>IBM</td>
					<td><%=IBM.getBidPrice() %></td>
					<td><%=IBM.getAskPrice() %></td>
					<td><%=IBM.getStockTime().toString() %></td>
				</tr>
				<tr>			
					<td>LSE.L</td>
					<td><%=LSEL.getBidPrice() %></td>
					<td><%=LSEL.getAskPrice() %></td>
					<td><%=LSEL.getStockTime().toString() %></td>
				</tr>
			</table>
<script src= "http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src= "bootstrap/js/bootstrap.js"></script>			
</html>