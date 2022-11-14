/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl.java.web;

import java.math.BigInteger;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class PrimeFact {

    private BigInteger N;
    private String decomposed;
    
    PrimeFact(BigInteger n){
        N = n;
        this.setDecomposedFact();
    }
   
    private boolean isPrime(BigInteger n){
        return n.isProbablePrime(1);
    }
   
    private void processHashtable(Hashtable<BigInteger,BigInteger> h, BigInteger i){
        boolean exist = false;
        for (BigInteger e : h.keySet()){
            if (e.intValue() == i.intValue()){
                exist = true;
                break;
            }
        }
       
        if (exist)
            h.put(i, h.get(i).add(BigInteger.ONE));
        else
            h.put(i, BigInteger.ONE);        
    }
   
    private Hashtable<BigInteger,BigInteger> decompose(){
        Hashtable<BigInteger,BigInteger>res = new Hashtable<BigInteger, BigInteger>();
        BigInteger i = BigInteger.valueOf(2), k, s;
        s = this.N;
        while (i.compareTo(s) <=0 ){
            k = i;
            if ( this.isPrime(i) ){
                if ( s.mod(i) == BigInteger.ZERO ){
                    this.processHashtable(res, i);
                    s = s.divide(i);
                    i = k;
                } else
                    i = i.add(BigInteger.ONE);
            }else
               i = i.add(BigInteger.ONE);
        }        
        return res;
    }
   
    private void setDecomposedFact(){
        System.out.print("1");
        if(this.N.isProbablePrime(1)) {
            this.decomposed = N+" = ("+N+",1)";
        }else{
            Hashtable<BigInteger,BigInteger> h = this.decompose();
            Vector<BigInteger> v = new Vector<BigInteger>(h.keySet());
            Collections.sort(v);
            String result = N+" = ";

            for (Enumeration<BigInteger> e = v.elements(); e.hasMoreElements();){
                BigInteger key = e.nextElement();
                result = result + " ("+ key+"," + h.get(key) +") -";
            }
            this.decomposed = result.substring(0, result.length() - 1);
        }
    }
    
    public String getDecomposedResult() {
        return this.decomposed;
    }
   
}
