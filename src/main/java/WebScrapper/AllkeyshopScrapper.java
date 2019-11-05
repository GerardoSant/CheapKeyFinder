package WebScrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class AllkeyshopScrapper {

    private static String emptySearch="https://www.allkeyshop.com/blog/catalogue/search-";
    private String gameName;

    public AllkeyshopScrapper(String gameName) {
        this.gameName = gameName;
    }

    public static void main(String[] args) throws IOException {

        AllkeyshopScrapper scrapper = new AllkeyshopScrapper("Left 4 Dead");
        List<GameResult> gameResults = scrapper.getGameResults();
        for (GameResult gameResult : gameResults){
            System.out.println(gameResult);
        }

    }


    public List<GameResult> getGameResults() throws IOException {
        String searchLink=emptySearch+parseGameName(this.gameName);
        List<GameResult> gameResults=getGameResultsFromLink(searchLink);
        for (GameResult gameResult: gameResults){
            gameResult.setGameOffers(this.getGameOffers(gameResult));
        }
        return gameResults;
    }

    private List<GameResult> getGameResultsFromLink(String searchLink) throws IOException {
        Document web = getWebData(searchLink);
        Elements elementsByClass = web.getElementsByClass("search-results-row-link");
        return getGameResultsListFromElements(elementsByClass);
    }

    private List<GameResult> getGameResultsListFromElements(Elements elementsByClass) {
        ArrayList<GameResult> gameResults= new ArrayList();
        for (Element elem: elementsByClass){
            Elements elem2 =elem.getElementsByClass("search-results-row-game-title");
            gameResults.add(new GameResult(elem2.text(),elem.attr("href"), null));;
        }
        return gameResults;
    }

    private List<GameOffer> getGameOffers(GameResult gameResult) throws IOException {
        List<GameOffer> gameOffers = new ArrayList<GameOffer>();
        Document web = getWebData(gameResult.getGameLink());
        return getGameOffersListFromElement(gameOffers, web);
    }

    private List<GameOffer> getGameOffersListFromElement(List<GameOffer> gameOffers, Document web2) {
        Elements elementsByClass2 = web2.getElementsByClass("offers-table-row");
        for (Element element2: elementsByClass2){
            gameOffers.add(getGameOffer(element2.html()));
        }
        return gameOffers;
    }

    private GameOffer getGameOffer(String offerTableRow) {
        return new GameOffer(getOfferLink(offerTableRow),getOfferPrice(offerTableRow),getOfferShop(offerTableRow));
    }

    private String getOfferLink(String offerTableRow) {
        return offerTableRow.substring(offerTableRow.indexOf("a href=\"//")+10,
                offerTableRow.indexOf("\"",offerTableRow.indexOf("a href=\"//")+10));
    }

    private double getOfferPrice(String offerTableRow) {
        return parseDouble(offerTableRow.substring(offerTableRow.indexOf("price-container")+16,
                offerTableRow.indexOf("price-container")+20));
    }

    private String getOfferShop(String offerTableRow) {
        return offerTableRow.substring(offerTableRow.indexOf("title")+7,offerTableRow.indexOf(">",offerTableRow.indexOf("title"))-1);
    }


    private static String parseGameName(String nextLine) {
        String[] s = nextLine.split(" ");
        String res="";
        for (String x: s){
            res = res + x+ "+";
        }
        return res.substring(0,res.length()-1);
    }

    private Document getWebData(String link){
        try{
            return Jsoup.connect(link).get();
        } catch(Exception e){
            System.out.println("Failed to connect to "+ link+ ", trying again...");
            return getWebData(link);
        }
    }



}
