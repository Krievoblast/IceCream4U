//Interface for Order.Java
package pricecalc;

public interface Cost
{
  //Abstract methods needed to be used
  public void addCost(double c);
  public String totalCost();
  public double showTax();
  public String showCost();
}