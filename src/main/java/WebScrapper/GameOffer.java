package WebScrapper;

public class GameOffer {
    private String link;
    private double price;
    private String shop;



    public GameOffer(String link, double price, String shop) {
        this.link = link;
        this.price = price;
        this.shop = shop;
    }



    public String getLink() {
        return link;
    }

    public double getPrice() {
        return price;
    }

    public String getShop() {
        return shop;
    }

    public String toString(){
        return "Shop: " + getShop() +  "| Price: " + getPrice() + "| Link: " + getLink() + "\n";
    }


}
