/**
 * Created by Grant on 4/9/2017.
 */
public class SearchThread extends Thread implements Runnable{

    int finish;
    int start;
    String[] terms;

    SearchThread(int start, int finish, String[] terms){
        this.start =  start;
        this.finish = finish;
        this.terms = terms;
    }

    public Word findTerm(String term) {

        for(int i = start; i <= finish; i++){
            if(term.equals(Search.wordList.get(i).getWord())){
                return Search.wordList.get(i);
            }
        }

        return null;

    }

    @Override
    public void run() {
        for(String a : terms){
            if(findTerm(a)!=null){
            }
        }

    }
}
