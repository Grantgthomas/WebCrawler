import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;


/**
 * Created by Grant on 3/26/2017.
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;


public class Parser extends Object{

    //Constructor
    public Parser(){

    }

    String getBody(Document doc)throws ParseException{
        if(doc == null){
            throw new ParseException("getBody() failed. Document parameter is null.");
        }
        Element body = doc.body();
        String content = body.text();
        return content;

    }

    public Document getDocument(String url) throws ParseException {
        if(url == null){
            throw new ParseException("getDocument() failed. String url is null.");
        }

        if(url == ""){
            throw new ParseException("getDocument() failed. String url is empty.");
        }

        Document d = null;
        try {
            d = Jsoup.connect(url).timeout(3000).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(d == null){
            throw new ParseException("getDocument()failed: Document is null.");
        }
        return d;

    }

    Elements getLinks(Document doc) throws ParseException{
        if(doc == null){
            throw new ParseException("getLinks() failed. Document parameter is null.");
        }
        Elements links = doc.select("a[href]");
        return links;
    }
}
