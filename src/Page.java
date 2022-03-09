/**
 * Created by Grant on 3/25/2017.
 */

import java.util.List;
import java.lang.Object;
import java.lang.Comparable;
import java.io.Serializable;
public class Page extends Object implements Serializable, Comparable<Page> {
 public static final long serialVersionUID = -1827677255104766839L;
   // public long serialVersionUID = -3696191086353573895L;
    private String url;   // URL as a string for this page
    private int urlId;   // ID for this specific page
    //Constructor
    public Page(String url, int urlId){
        this.url = url;
        this.urlId = urlId;
    }
    @Override
    public int compareTo(Page candidate) {
        if(candidate.urlId < this.urlId){
            return -1;
        }
        if(candidate.urlId == this.urlId){
            return 0;
        }
        if(candidate.urlId > this.urlId){
            return 1;
        }
        return 2;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Page) {
            if (this.url == ((Page) obj).url || this.urlId == ((Page) obj).urlId) {
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }
    String getURL(){
        return url;
    }
    int    getURLID(){
        return urlId;
    }
}

