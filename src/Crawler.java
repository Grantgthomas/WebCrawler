
/**
 * Created by Makayla on 4/5/17.
 */

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Crawler {
    public static int currentID;
    public static String domain;
    public static int limit;
    public static List<Page> parsed = new ArrayList<>();
    public static Parser parser;
    public MyQueue toParse;
    static int totalURLs;
    static List<String>    visited = new ArrayList<>();
    static List<Word> words = new ArrayList<>();

    //Constructor
    public Crawler(String seed, String domain, int limit){
        toParse = new MyQueue();
        parser = new Parser();
        this.domain = domain;
        this.limit = limit;
        this.currentID = 0;
        this.totalURLs = 0;
        toParse.add(seed);

    }

    public void crawl(){
        while(!toParse.isEmpty() && currentID < limit){
            Page page = new Page((String) toParse.remove().getData(), currentID);
            if(page == null || visited.contains(page.getURL())){
                continue;
            }
            String url = page.getURL();
            if(url == null){
                continue;
            }
            Document doc = null;
            try{
                doc =  parser.getDocument(url);
                parse(doc, currentID);
                currentID++;
                parsed.add(page);
                visited.add(page.getURL());
            }catch(ParseException e){
                continue;
            }
        }
//calls parse
    }

    public boolean parse(Document doc, int id){
//calls parse Links and parse Text
        parseLinks(doc);
        parseText(doc, id);
        return true;
    }

    public void parseLinks(Document doc){
//calls addWordToList
        Elements links = null;
        try{
            links = parser.getLinks(doc);
        }catch(Exception e){
            return;
        }


        for(Element l: links){
            String l2 = l.attr("abs:href");
            if(isValidURL(l2) && isInDomain(l2)){
                addToQueue(l2);
            }
        }

    }

    public void parseText(Document doc, int id){
//calls addWordToQueue

        String s = null;
        try{
            s = parser.getBody(doc);
        }catch(Exception e){
            return;
        }
        if(s==null){
            return;
        }

        String[] array = s.split(" ");
        for(String i : array){
            addWordToList(i.replaceAll(" ", ""), id);
        }


    }

    public void addWordToList(String word, int id){
        word = word.toLowerCase();
        Word name = new Word(word, id);
        if(words.contains(name) == false){
            words.add(name);
        }else{
            Word name2 = words.remove(words.indexOf(name));
            name2.addURLID(id);
            words.add(name2);
        }

    }

    public void addToQueue(String url){
        if(visited.contains(url) == false){
            toParse.add(url);
            totalURLs++;
        }
    }

    public void addPageToList(Page p){
        if(parsed.get(p.getURLID()) == null){
            parsed.add(p);
        }
    }

    public boolean isInDomain(String url){
        if(url.contains(domain)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isValidURL(String url){
        if(url.startsWith("http://") || url.startsWith("https://")){
            return true;
        }else{
            return false;
        }
    }

}
