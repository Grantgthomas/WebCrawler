import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.io.Serializable;

public class Word extends Object  implements Serializable{
    private String word;
    private List<Integer> postings;
 public static final long serialVersionUID = -3696191086353573895L;
 //public long serialVersionUID = -1152115616319500202L;
    //Constructor
    public Word(String word, int urlID){
        this.word = word;
        this.postings = new ArrayList<>();
        postings.add(urlID);
    }

    public void addURLID(int urlID){
        postings.add(urlID);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            if (this.word.equals(((Word)obj).word)) {
                return true;
            }

        }

        return false;
    }

    public List<Integer> getList(){
        return postings;
    }

    public String getWord(){
        return word;
    }

}


