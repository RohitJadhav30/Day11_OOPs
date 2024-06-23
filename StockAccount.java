//program3

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class CompanyShares {
    private String stockSymbol;
    private int numberOfShares;
    private LocalDateTime dateTime;

    public CompanyShares(String stockSymbol, int numberOfShares, LocalDateTime dateTime) {
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.dateTime = dateTime;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(int numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "CompanyShares{" + "stockSymbol='" + stockSymbol + '\'' + ", numberOfShares=" + numberOfShares + ", dateTime=" + dateTime + '}';
    }
}

public class StockAccount {
    private String customerName;
    private List<CompanyShares> sharesList;

    public StockAccount(String customerName) {
        this.customerName = customerName;
        this.sharesList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<CompanyShares> getSharesList() {
        return sharesList;
    }

    public void buy(String stockSymbol, int numberOfShares) {
        for (CompanyShares shares : sharesList) {
            if (shares.getStockSymbol().equals(stockSymbol)) {
                shares.setNumberOfShares(shares.getNumberOfShares() + numberOfShares);
                shares.setDateTime(LocalDateTime.now());
                return;
            }
        }
        sharesList.add(new CompanyShares(stockSymbol, numberOfShares, LocalDateTime.now()));
    }

    public void sell(String stockSymbol, int numberOfShares) {
        for (CompanyShares shares : sharesList) {
            if (shares.getStockSymbol().equals(stockSymbol)) {
                if (shares.getNumberOfShares() >= numberOfShares) {
                    shares.setNumberOfShares(shares.getNumberOfShares() - numberOfShares);
                    shares.setDateTime(LocalDateTime.now());
                    if (shares.getNumberOfShares() == 0) {
                        sharesList.remove(shares);
                    }
                } else {
                    System.out.println("Not enough shares to sell.");
                }
                return;
            }
        }
        System.out.println("No shares found for the stock symbol: " + stockSymbol);
    }

    @Override
    public String toString() {
        return "StockAccount{" + "customerName='" + customerName + '\'' + ", sharesList=" + sharesList + '}';
    }

    public static void main(String[] args) {
        StockAccount account = new StockAccount("Rohit Jadhav");
        account.buy("Relaience", 50);
        account.buy("GOOGLE", 20);
        account.sell("Relaience", 10);
        account.sell("GOOGLE", 25);
        account.sell("BMW", 5);

        System.out.println(account);
    }
}
