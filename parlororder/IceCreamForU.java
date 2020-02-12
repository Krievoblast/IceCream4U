//This program lets the user place an order at a variety of ice cream locations
//by entering a number, in most cases, to select the store and flavor, and also
//to determine how much ice cream they are ordering and how many scoops they are ordering
package parlororder;

import java.util.Scanner;
import pricecalc.*;

//Superclass
class Store
{
  //Local declarations
  protected String name;
  protected String address;
  
  //Constructor
  protected Store(String n, String ad)
  {
    name = n;
    address = ad;
  }
  
  //Show store info
  protected void showStore()
  {
    System.out.println("Store Name: " + name);
    System.out.println("Store Location: " + address);
  }
}

//Subclass of Store class
class IceCream extends Store
{
  //Local declarations
  private String iName;
  private int scoops;
  private double cost;
  
  //Constructor
  IceCream(String n, String ad, String in, int sc, double c)
  {
    super(n, ad);
    iName = in;
    scoops = sc;
    cost = c;
  }
  
  //Show information
  void showIC()
  {
    System.out.println("Ice Cream: " + iName);
    System.out.println("Scoops: " + scoops);
    System.out.println("Cost: $" + cost);
  }
  
  //Get cost of Ice Cream
  double getCost()
  {
    return cost;
  }
}

//Main Class
class IceCreamForU
{
  public static void main(String args[])
  throws java.io.IOException
  {
    //Declarations
    int choice = 0;
    char cChoice;
    int flavor, scoops;
    double cost;
    String sName, sAdd;
    Scanner uChoice = new Scanner(System.in);
    Scanner chChoice = new Scanner(System.in);
    
    //Do while loop while user orders ice cream
    do
    {
      //Create new Order object
      Order totalOrder = new Order(0);
      
      //Output information to user
      System.out.println("Welcome to New Type Designer's Ice Cream-4-U app!");
      System.out.println("Please choose a store location to place an icecream order at!");
      System.out.println("Enter one of the below numbers to choose a store!");
      System.out.println();
      System.out.println("1. Jackson Ice Line \n   1429 Line Street, Pomona, CA");
      System.out.println("2. Grimoire Ice Cream \n   54879 Magician Lane, Orange County, CA");
      System.out.println("3. Presidential Ice \n   4951 Lincoln Way, Realto, CA");
      System.out.println("4. You-Ice, We-Cream \n   872 Venture Avenue, Los Angeles, CA");
      System.out.println("5. Breaking Ice Cream \n   9546 RV Way, Sacramento, CA");
      System.out.println("6. Quit");
      
      //Get user choice
      choice = Integer.parseInt(uChoice.nextLine());
      
      System.out.println();
      
      //Switch menu based on choice made
      switch(choice)
      {
        case 1:
        {
          //Location
          sName = "Jackson Ice Line";
          sAdd = "1429 Line Street, Pomona, CA";
          System.out.println("Store Chosen: Jackson's Ice Line");
          System.out.println();
          
          //User inputs how many orders of Ice cream they wish to get
          System.out.println("Please enter how many orders of Ice Cream you will make");
          System.out.print("Must make 1 order, up to 5 orders: ");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          //Keep order reasonable
          while(choice < 1 || choice > 5)
          {
            System.out.println("Error - number not accepted, please re-enter");
            System.out.print("Must make 1 order, up to 5 orders: ");
            
            choice = Integer.parseInt(uChoice.nextLine());
          }
          
          System.out.println();
          
          //Create new Ice Cream object array based on order number
          IceCream iceOrder[] = new IceCream[choice];
          
          //For loop for each ice cream order
          for(int i = 0; i < iceOrder.length; i++)
          {
            //Choose flavor
            System.out.println("Order " + (i + 1) + ":");
            System.out.println("Please enter a number to choose a flavor.");
            System.out.println("1. Vanilla");
            System.out.println("2. Chocolate"); 
            System.out.println("3. Mint Choclate Chip"); 
            System.out.println("4. Coffee"); 
            System.out.println("5. Butterscotch");
            
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 5)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.println("Please enter a number to choose a flavor.");
              System.out.println("1. Vanilla");
              System.out.println("2. Chocolate"); 
              System.out.println("3. Mint Choclate Chip"); 
              System.out.println("4. Coffee"); 
              System.out.println("5. Butterscotch");
              
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to flavor
            flavor = choice;
            System.out.println();
            
            //Choose number of scoops
            System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 3)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to scoops
            scoops = choice;
            System.out.println();
            
            //Determine cost based on number of scoops
            if(scoops == 1)
            {
              cost = 4.25;
            }
            
            else if(scoops == 2)
            {
              cost = 5.25;
            }
            
            else
            {
              cost = 6.50;
            }
            
            //Assign values to iceOrder[i] based on choices made
            if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Vanilla", scoops, cost);
            }
            
            else if(flavor == 2)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Chocolate", scoops, cost);
            }
            
            else if(flavor == 3)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Mint Choclate Chip", scoops, cost);
            }
            
            else if(flavor == 4)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Coffee", scoops, cost);
            }
            
            else
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Butterscotch", scoops, cost);
            }
            
            //Add cost to total order
            totalOrder.addCost(iceOrder[i].getCost());
          }
          
          //Show order and where placed
          System.out.println("CHECKOUT");
          iceOrder[0].showStore();
          System.out.println();
          
          //Outputs orders made to user
          for(int i = 0; i < iceOrder.length; i++)
          {
            System.out.println("Order " + (i + 1) + ":");
            iceOrder[i].showIC();
            System.out.println();
          }
          
          //Outputs cost
          System.out.println("Sub-total: $" + totalOrder.showCost());
          System.out.println("Tax: " + totalOrder.showTax() + "%");
          System.out.println("Total Cost: $" + totalOrder.totalCost());
          System.out.println();
          
          //Checks if user wishes to place the order
          System.out.println("Place order? <y/n>");
          
          cChoice = chChoice.next().charAt(0);
          
          //If no, reset do-while loop, else place order
          if(cChoice != 'y' && cChoice != 'Y')
          {
            System.out.println("Order not placed, resetting order placement...");
            choice = 0;
          }
          else
          {
            System.out.println("Order placed ... sent ...");
            System.out.println("Please give the location 15 - 30 minutes to get your order ready!");
            choice = -1;
          }
            
          break;
        }
        
        case 2:
        {
          //Location
          sName = "Grimoire Ice Cream";
          sAdd = "54879 Magician Lane, Orange County, CA";
          System.out.println("Store Chosen: Grimoire Ice Cream");
          System.out.println();
          
          //User inputs how many orders of Ice cream they wish to get
          System.out.println("Please enter how many orders of Ice Cream you will make");
          System.out.print("Must make 1 order, up to 5 orders: ");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          //Keep order reasonable
          while(choice < 1 || choice > 5)
          {
            System.out.println("Error - number not accepted, please re-enter");
            System.out.print("Must make 1 order, up to 5 orders: ");
            
            choice = Integer.parseInt(uChoice.nextLine());
          }
          
          System.out.println();
          
          //Create new Ice Cream object array based on order number
          IceCream iceOrder[] = new IceCream[choice];
          
          //For loop for each ice cream order
          for(int i = 0; i < iceOrder.length; i++)
          {
            //Choose flavor
            System.out.println("Order " + (i + 1) + ":");
            System.out.println("Please enter a number to choose a flavor.");
            System.out.println("1. Magician's Secret");
            System.out.println("2. Magic Mint-ssiles"); 
            System.out.println("3. Choc-liosa"); 
            System.out.println("4. Rockillarmus"); 
            System.out.println("5. Vanisible");
            
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 5)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.println("Please enter a number to choose a flavor.");
              System.out.println("1. Magician's Secret");
              System.out.println("2. Magic Mint-ssiles"); 
              System.out.println("3. Choc-liosa"); 
              System.out.println("4. Rockillarmus"); 
              System.out.println("5. Vanisible");
              
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to flavor
            flavor = choice;
            System.out.println();
            
            //Choose number of scoops
            System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 3)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to scoops
            scoops = choice;
            System.out.println();
            
            //Determine cost based on number of scoops
            if(scoops == 1)
            {
              cost = 3.25;
            }
            
            else if(scoops == 2)
            {
              cost = 4.75;
            }
            
            else
            {
              cost = 6.00;
            }
            
            //Assign values to iceOrder[i] based on choices made
            if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Magician's Secret", scoops, cost);
            }
            
            else if(flavor == 2)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Magic Mint-ssiles", scoops, cost);
            }
            
            else if(flavor == 3)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Choc-liosa", scoops, cost);
            }
            
            else if(flavor == 4)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Rockillarmus", scoops, cost);
            }
            
            else
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Vanisible", scoops, cost);
            }
            
            //Add cost to total order
            totalOrder.addCost(iceOrder[i].getCost());
          }
          
          //Show order and where placed
          System.out.println("CHECKOUT");
          iceOrder[0].showStore();
          System.out.println();
          
          //Outputs orders made to user
          for(int i = 0; i < iceOrder.length; i++)
          {
            System.out.println("Order " + (i + 1) + ":");
            iceOrder[i].showIC();
            System.out.println();
          }
          
          //Outputs cost
          System.out.println("Sub-total: $" + totalOrder.showCost());
          System.out.println("Tax: " + totalOrder.showTax() + "%");
          System.out.println("Total Cost: $" + totalOrder.totalCost());
          System.out.println();
          
          //Checks if user wishes to place the order
          System.out.println("Place order? <y/n>");
          
          cChoice = chChoice.next().charAt(0);
          
          //If no, reset do-while loop, else place order
          if(cChoice != 'y' && cChoice != 'Y')
          {
            System.out.println("Order not placed, resetting order placement...");
            choice = 0;
          }
          else
          {
            System.out.println("Order placed ... sent ...");
            System.out.println("Please give the location 15 - 30 minutes to get your order ready!");
            choice = -1;
          }
          
          break;
        }
        
        case 3:
        {
          //Location
          sName = "Presidential Ice";
          sAdd = "4951 Lincoln Way, Realto, CA";
          System.out.println("Store Chosen: Presidential Ice");
          System.out.println();
          
          //User inputs how many orders of Ice cream they wish to get
          System.out.println("Please enter how many orders of Ice Cream you will make");
          System.out.print("Must make 1 order, up to 5 orders: ");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          //Keep order reasonable
          while(choice < 1 || choice > 5)
          {
            System.out.println("Error - number not accepted, please re-enter");
            System.out.print("Must make 1 order, up to 5 orders: ");
            
            choice = Integer.parseInt(uChoice.nextLine());
          }
          
          System.out.println();
          
          //Create new Ice Cream object array based on order number
          IceCream iceOrder[] = new IceCream[choice];
          
          //For loop for each ice cream order
          for(int i = 0; i < iceOrder.length; i++)
          {
            //Choose flavor
            System.out.println("Order " + (i + 1) + ":");
            System.out.println("Please enter a number to choose a flavor.");
            System.out.println("1. The Washington");
            System.out.println("2. The Lincoln"); 
            System.out.println("3. The Reagan"); 
            System.out.println("4. The Jackson"); 
            System.out.println("5. The Kennedy");
            
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 5)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.println("Please enter a number to choose a flavor.");
              System.out.println("1. The Washington");
              System.out.println("2. The Lincoln"); 
              System.out.println("3. The Reagan"); 
              System.out.println("4. The Jackson"); 
              System.out.println("5. The Kennedy");
              
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to flavor
            flavor = choice;
            System.out.println();
            
            //Choose number of scoops
            System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 3)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to scoops
            scoops = choice;
            System.out.println();
            
            //Determine cost based on number of scoops
            if(scoops == 1)
            {
              cost = 5.00;
            }
            
            else if(scoops == 2)
            {
              cost = 6.50;
            }
            
            else
            {
              cost = 7.50;
            }
            
            //Assign values to iceOrder[i] based on choices made
            if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "The Washington", scoops, cost);
            }
            
            else if(flavor == 2)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "The Lincoln", scoops, cost);
            }
            
            else if(flavor == 3)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "The Reagan", scoops, cost);
            }
            
            else if(flavor == 4)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "The Jackson", scoops, cost);
            }
            
            else
            {
              iceOrder[i] = new IceCream(sName, sAdd, "The Kennedy", scoops, cost);
            }
            
            //Add cost to total order
            totalOrder.addCost(iceOrder[i].getCost());
          }
          
          //Show order and where placed
          System.out.println("CHECKOUT");
          iceOrder[0].showStore();
          System.out.println();
          
          //Outputs orders made to user
          for(int i = 0; i < iceOrder.length; i++)
          {
            System.out.println("Order " + (i + 1) + ":");
            iceOrder[i].showIC();
            System.out.println();
          }
          
          //Outputs cost
          System.out.println("Sub-total: $" + totalOrder.showCost());
          System.out.println("Tax: " + totalOrder.showTax() + "%");
          System.out.println("Total Cost: $" + totalOrder.totalCost());
          System.out.println();
          
          //Checks if user wishes to place the order
          System.out.println("Place order? <y/n>");
          
          cChoice = chChoice.next().charAt(0);
          
          //If no, reset do-while loop, else place order
          if(cChoice != 'y' && cChoice != 'Y')
          {
            System.out.println("Order not placed, resetting order placement...");
            choice = 0;
          }
          else
          {
            System.out.println("Order placed ... sent ...");
            System.out.println("Please give the location 15 - 30 minutes to get your order ready!");
            choice = -1;
          }
          
          break;
        }
        
        case 4:
        {
          //Location
          sName = "You-Ice, We-Cream";
          sAdd = "872 Venture Avenue, Los Angeles, CA";
          System.out.println("Store Chosen: You-Ice, We-Cream");
          System.out.println();
          
          //User inputs how many orders of Ice cream they wish to get
          System.out.println("Please enter how many orders of Ice Cream you will make");
          System.out.print("Must make 1 order, up to 5 orders: ");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          //Keep order reasonable
          while(choice < 1 || choice > 5)
          {
            System.out.println("Error - number not accepted, please re-enter");
            System.out.print("Must make 1 order, up to 5 orders: ");
            
            choice = Integer.parseInt(uChoice.nextLine());
          }
          
          System.out.println();
          
          //Create new Ice Cream object array based on order number
          IceCream iceOrder[] = new IceCream[choice];
          
          //For loop for each ice cream order
          for(int i = 0; i < iceOrder.length; i++)
          {
            //Choose flavor
            System.out.println("Order " + (i + 1) + ":");
            System.out.println("Please enter a number to choose a flavor.");
            System.out.println("1. Vanolate");
            System.out.println("2. Mint-Cookies and Chip"); 
            System.out.println("3. Coffee-Toffee Family"); 
            System.out.println("4. Caramel Deluxe"); 
            System.out.println("5. Desert Winds");
            
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 5)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.println("Please enter a number to choose a flavor.");
              System.out.println("1. Vanolate");
              System.out.println("2. Mint-Cookies and Chip"); 
              System.out.println("3. Coffee-Toffee Family"); 
              System.out.println("4. Caramel Deluxe"); 
              System.out.println("5. Desert Winds");
              
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to flavor
            flavor = choice;
            System.out.println();
            
            //Choose number of scoops
            System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 3)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to scoops
            scoops = choice;
            System.out.println();
            
            //Determine cost based on number of scoops
            if(scoops == 1)
            {
              cost = 4.00;
            }
            
            else if(scoops == 2)
            {
              cost = 5.00;
            }
            
            else
            {
              cost = 6.00;
            }
            
            //Assign values to iceOrder[i] based on choices made
            if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Vanolate", scoops, cost);
            }
            
            else if(flavor == 2)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Mint-Cookies and Chip", scoops, cost);
            }
            
            else if(flavor == 3)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Coffee-Toffee Family", scoops, cost);
            }
            
            else if(flavor == 4)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Caramel Deluxe", scoops, cost);
            }
            
            else
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Desert Winds", scoops, cost);
            }
            
            //Add cost to total order
            totalOrder.addCost(iceOrder[i].getCost());
          }
          
          //Show order and where placed
          System.out.println("CHECKOUT");
          iceOrder[0].showStore();
          System.out.println();
          
          //Outputs orders made to user
          for(int i = 0; i < iceOrder.length; i++)
          {
            System.out.println("Order " + (i + 1) + ":");
            iceOrder[i].showIC();
            System.out.println();
          }
          
          //Outputs cost
          System.out.println("Sub-total: $" + totalOrder.showCost());
          System.out.println("Tax: " + totalOrder.showTax() + "%");
          System.out.println("Total Cost: $" + totalOrder.totalCost());
          System.out.println();
          
          //Checks if user wishes to place the order
          System.out.println("Place order? <y/n>");
          
          cChoice = chChoice.next().charAt(0);
          
          //If no, reset do-while loop, else place order
          if(cChoice != 'y' && cChoice != 'Y')
          {
            System.out.println("Order not placed, resetting order placement...");
            choice = 0;
          }
          else
          {
            System.out.println("Order placed ... sent ...");
            System.out.println("Please give the location 15 - 30 minutes to get your order ready!");
            choice = -1;
          }
          
          break;
        }
        
        case 5:
        {
          //Location
          sName = "Breaking Ice Cream";
          sAdd = "9546 RV Way, Sacramento, CA";
          System.out.println("Store Chosen: Breaking Ice Cream");
          System.out.println();
          
          //User inputs how many orders of Ice cream they wish to get
          System.out.println("Please enter how many orders of Ice Cream you will make");
          System.out.print("Must make 1 order, up to 5 orders: ");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          //Keep order reasonable
          while(choice < 1 || choice > 5)
          {
            System.out.println("Error - number not accepted, please re-enter");
            System.out.print("Must make 1 order, up to 5 orders: ");
            
            choice = Integer.parseInt(uChoice.nextLine());
          }
          
          System.out.println();
          
          //Create new Ice Cream object array based on order number
          IceCream iceOrder[] = new IceCream[choice];
          
          //For loop for each ice cream order
          for(int i = 0; i < iceOrder.length; i++)
          {
            //Choose flavor
            System.out.println("Order " + (i + 1) + ":");
            System.out.println("Please enter a number to choose a flavor.");
            System.out.println("1. Burnt Vanilla");
            System.out.println("2. Heated Chocolate"); 
            System.out.println("3. Mint Choclate Beaker"); 
            System.out.println("4. Shattered Coffee"); 
            System.out.println("5. Solid Butterscotch");
            
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 5)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.println("Please enter a number to choose a flavor.");
              System.out.println("1. Burnt Vanilla");
              System.out.println("2. Heated Chocolate"); 
              System.out.println("3. Mint Choclate Beaker"); 
              System.out.println("4. Shattered Coffee"); 
              System.out.println("5. Solid Butterscotch");
              
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to flavor
            flavor = choice;
            System.out.println();
            
            //Choose number of scoops
            System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
            choice = Integer.parseInt(uChoice.nextLine());
            
            //Make sure choice is accepted
            while(choice < 1 || choice > 3)
            {
              System.out.println("Error - number not accepted, please re-enter");
              System.out.print("Please enter number of scoops, between 1 - 3 scoops: ");
              choice = Integer.parseInt(uChoice.nextLine());
            }
            
            //Assign number chosen to scoops
            scoops = choice;
            System.out.println();
            
            //Determine cost based on number of scoops
            if(scoops == 1)
            {
              cost = 6.00;
            }
            
            else if(scoops == 2)
            {
              cost = 7.00;
            }
            
            else
            {
              cost = 8.00;
            }
            
            //Assign values to iceOrder[i] based on choices made
            if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Burnt Vanilla", scoops, cost);
            }
            
            else if(flavor == 2)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Heated Chocolate", scoops, cost);
            }
            
            else if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Mint Choclate Beaker", scoops, cost);
            }
            
            else if(flavor == 1)
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Shattered Coffee", scoops, cost);
            }
            
            else
            {
              iceOrder[i] = new IceCream(sName, sAdd, "Solid Butterscotch", scoops, cost);
            }
            
            //Add cost to total order
            totalOrder.addCost(iceOrder[i].getCost());
          }
          
          choice = 1;
          
          //Show order and where placed
          System.out.println("CHECKOUT");
          iceOrder[0].showStore();
          System.out.println();
          
          //Outputs orders made to user
          for(int i = 0; i < iceOrder.length; i++)
          {
            System.out.println("Order " + (i + 1) + ":");
            iceOrder[i].showIC();
            System.out.println();
          }
          
          //Outputs cost
          System.out.println("Sub-total: $" + totalOrder.showCost());
          System.out.println("Tax: " + totalOrder.showTax() + "%");
          System.out.println("Total Cost: $" + totalOrder.totalCost());
          System.out.println();
          
          //Checks if user wishes to place the order
          System.out.println("Place order? <y/n>");
          
          cChoice = chChoice.next().charAt(0);
          
          //If no, reset do-while loop, else place order
          if(cChoice != 'y' && cChoice != 'Y')
          {
            System.out.println("Order not placed, resetting order placement...");
            choice = 0;
          }
          else
          {
            System.out.println("Order placed ... sent ...");
            System.out.println("Please give the location 15 - 30 minutes to get your order ready!");
            choice = -1;
          }
          
          break;
        }
        
        case 6:
        {
          //Quit program
          System.out.println("Quitting ...");
          choice = -1;
          
          break;
        }
        
        default:
        {
          //Check user intention if no match found
          System.out.println("Choice not found, do you wish to try again or quit?");
          System.out.println("1. Try again");
          System.out.println("2. Quit");
          
          choice = Integer.parseInt(uChoice.nextLine());
          
          System.out.println();
          
          //Quit if choice isn't 1
          if(choice != 1)
          {
            System.out.println("Quitting...");
            choice = -1;
          }
        }
      }
    }while(choice != -1);
    
    //Output when program is complete
    System.out.println();
    System.out.println("Thank you for using the Ice Cream-4-U Mobile App.");
    System.out.println("We hope to see you again!");
  }
}