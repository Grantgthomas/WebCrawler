import java.io.Serializable;

/**
 * Created by Grant on 4/9/2017.
 */
    public class Result implements Comparable, Serializable{
        int    score = 1;
        static final long    serialVersionUID = -938761094876384658L;
        String url;
        int    urlID;
        //Constructor
        public Result(String url, int urlID){
            this.url = url;
            this.urlID = urlID;
        }
        public int compareTo(Page candidate) {
            if(candidate.getURLID() < this.urlID){
                return -1;
            }
            if(candidate.getURLID() == this.urlID){ return 0; }
            if(candidate.getURLID() > this.urlID){ return 1;}
            return 2;
        }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
        public boolean equals(Object obj){
            if(obj instanceof Result) {
                if (this.url == ((Result) obj).url || this.getURLID() == ((Result) obj).urlID) {
                    return true;
                } else {
                    return false;
                }
            }else{
                return false;
            }
        }
        int    getScore(){
            return score;
        }
        String getURL(){
            return url;
        }
        int    getURLID(){
            return urlID;
        }
        void incrementScore(){
            score++;
        }
        void updateScore(int score){
            this.score = this.score + score;
        }
    }
