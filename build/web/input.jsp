<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="edu.umsl.java.web.Data"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Page</title>
</head>
<body style="display: flex">
    <div style="margin: auto">
        <h2> OS Used : <%= request.getAttribute("os") %> </h2>
        <br/><br/>
    <table style="width: 60vw;">
        <tr>
            <td width="30%">
                <form action="calculate" method="post">
                     <b>Select a city</b>
                     <br /><br />
                    <select name="city" id="citySelect" onchange="onCityChange()">
                        <c:forEach var="city" items="${data.getCities()}">
                            <option value="${city}">${city}</option>
                        </c:forEach>
                    </select>
                    <br /><br />

                    <b>City tax rate :</b>
                    <br /><br />

                    <select id="rates" name="rates" disabled="disabled" >
                        <c:forEach var="rate" items="${data.getTaxRate()}">
                            <option value="${rate}">${rate}</option>
                        </c:forEach>
                    </select>

                    <br/><br/>

                    <input type="submit" name="submit" value="Calculate" />
                </form>
            </td>
            
            <td>
                <b>Random 100-digit number :</b>
                <br /><br />
                <form action="decompose" method="post">
                    <input type="text" name="randomNum" id="randomNum" style="width: 771px" /> <br/><br/>
                    <button type="button" onClick="generateRandom(100)"> Generate </button>
                    <br/><br/><br />
                    <input type="submit" name="submit" value="Decompose" />
                </form>    
            </td>
        </tr>
    </table>
    </div>

    <script>
        function generate(n) {
            var add = 1, max = 12 - add;
            console.log(n);
            if ( n > max ) {
               return generate(max) + generate(n - max);
            }
            max        = Math.pow(10, n+add);
            var min    = max/10; // Math.pow(10, n) basically
            var number = Math.floor( Math.random() * (max - min + 1) ) + min;
            
            return ("" + number).substring(add);
        }
        
        function generateRandom(n) {
            const result = generate(n);
            document.getElementById('randomNum').value = result;
        }
        
        function onCityChange() {
            const cityIndex = document.getElementById("citySelect").selectedIndex;
            document.getElementById('rates').selectedIndex = cityIndex;
        }
        
    </script>
    
</body>
</html>
