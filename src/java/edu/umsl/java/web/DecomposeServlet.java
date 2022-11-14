/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl.java.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maher
 */
@WebServlet(name = "DecomposeServlet", urlPatterns = {"/decompose"})
public class DecomposeServlet extends HttpServlet {

   private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("randomNum");
        String decompose = number;
        BigInteger bigInt = new BigInteger(number);
        PrimeFact primeFact = new PrimeFact(bigInt);
        
        /*if (bigInt.isProbablePrime(1)) {
            decompose = (number + " = ("+ bigInt+",1)");
        }else {
            decompose = number + " = ";
            ArrayList<BigInteger> primeList = this.factors(new BigInteger(number));
            Set<BigInteger> set = new LinkedHashSet<BigInteger>();
            set.addAll(primeList);
            for (BigInteger num : set)
            {
                decompose = decompose + " ("+ num+"," + Collections.frequency(primeList, num) +") -";
            }
            decompose = decompose  
        }*/
        request.setAttribute("data", primeFact);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");

        view.forward(request, response);
    }

    private void primers(ArrayList<BigInteger> list, BigInteger n)
    {
        BigInteger two = BigInteger.valueOf(2);
        if(n.isProbablePrime(1)) {
            list.add(n);
        }else{
            if(two.compareTo(n.divide(two)) == -1) {
                for(BigInteger i = two; i.compareTo(n.divide(two)) == -1; i=i.add(BigInteger.ONE)) {
                    if(n.mod(i).compareTo(BigInteger.ZERO) == 0) {
                        this.primers(list, n.divide(i));
                    }
                }
            }
        }
    }

    private ArrayList<BigInteger> factors(BigInteger n)
    {
        ArrayList fs = new ArrayList<BigInteger>();

        this.primers(fs, n);
        Collections.sort(fs);
        return fs;
    }
}
