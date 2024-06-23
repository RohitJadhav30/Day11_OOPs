//program1

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock{
    private String stockName;
    private int noOfShares;
    private double price;

    public Stock(String stockName, int noOfShares, double price){
        this.stockName = stockName;
        this.noOfShares = noOfShares;
        this.price = price;
    }

    public double getTotalValue(){
        return noOfShares * price;
    }

    @Override
    public String toString() {
        return "Stock name is: " + stockName + " No. of shares are: " + noOfShares + " and the price of the share is: " + price;
    }

}

class StockPortfolio{
    private List<Stock> stocks;

    public StockPortfolio(){
        stocks = new ArrayList<>();
    }

    public void addStocks(Stock stock){
        stocks.add(stock);
    }

    public double getTotalValue(){
        double totalValue = 0;
        for (Stock stock : stocks) {
            totalValue += stock.getTotalValue();
        }
        return totalValue;
    }

    public void printStocks(){
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
        System.out.println("Total value of all stocks is: " + getTotalValue());
    }
}

public class StockManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StockPortfolio portfolio = new StockPortfolio();

        System.out.print("Enter the total number of stocks: ");
        int noOfStocks = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < noOfStocks; i++){
            System.out.print("enter stock name: ");
            String stock = sc.nextLine();

            System.out.print("enter number of shares: ");
            int noOfShares = sc.nextInt();

            System.out.print("enter stock price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            Stock stock1 = new Stock(stock, noOfShares, price);
            portfolio.addStocks(stock1);
        }
        sc.close();
        portfolio.printStocks();
    }
}