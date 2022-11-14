package edu.umsl.java.web;

import java.io.IOException;
import java.util.*;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.jasper.tagplugins.jstl.core.ForEach;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            
		String  browserDetails = request.getHeader("User-Agent");
		ServletContext ctx = this.getServletContext();
		
		String cities = ctx.getInitParameter("cities");
		String rates = ctx.getInitParameter("tax_rates");
                
                String[] rateArr = rates.split(",");
                double[] ratesValues = new double[rateArr.length];
                
                for(int i=0; rateArr.length > i; i++){
                    ratesValues[i] = Double.parseDouble(rateArr[i]);
                }
		//ratesValues[0] = Double.parseDouble("5.2");
                
		System.out.println("Cities: " + cities);
		System.out.println("Tax rates: " + rates);
		
		String[] cityArr = cities.split(",");
                List<String> list = Arrays.asList(cityArr);
                //list.add("test");
		Data data = new Data(list,ratesValues);
                
		request.setAttribute("data", data);
                RequestDispatcher view;
                if (browserDetails.toLowerCase().indexOf("windows") >= 0 )
                {
                    request.setAttribute("os", "Windows");
                    view = request.getRequestDispatcher("input.jsp");
                    view.forward(request, response);
                }else{
                    if (browserDetails.toLowerCase().indexOf("mac") >= 0 ) {
                       request.setAttribute("os", "Mac os");
                        view = request.getRequestDispatcher("input.jsp");
                        view.forward(request, response);
                    }
                    
                   
                }
	}

}
