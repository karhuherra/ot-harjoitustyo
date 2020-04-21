/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirjanpito.action;

/**
 *
 * @author kaikarhu
 */
public class receipt {
    
    private double total;
    private String category;
    
    public receipt(double total, String category){
        this.total = total;
        this.category = category;
    }
    
    public String toString(){
        return "summa: " + this.total + " kategoria: " + this.category;
    }
    
    public double getTotal(){
        return total;
    }
    
    public String getCategory(){
        return category;
    }
}
