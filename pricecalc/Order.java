//Used to calculate costs, implementing an interface
package pricecalc;

import java.text.DecimalFormat;

public class Order implements Cost 
{
  //Local declarations
  private double totalCost;
  private double tax = .0775;
  DecimalFormat df = new DecimalFormat("#.##");
  
  //Constructor
  public Order(double c)
  {
    totalCost = c;
  }
  
  //Add costs
  public void addCost(double c)
  {
    totalCost += c;
  }
  
  //Return formatted totalCost
  public String totalCost()
  {
    return df.format(totalCost + (totalCost * tax));
  }
  
  //Return Tax
  public double showTax()
  {
    return tax;
  }
  
  //Return formatted cost
  public String showCost()
  {
    return df.format(totalCost);
  }
}