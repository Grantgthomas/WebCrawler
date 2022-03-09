import java.io.File;
import java.util.List;
import java.util.Collections;

/**
 * Created by Grant on 4/9/2017.
 */
public class Search {
    static List<Page> pageList;
    private String pageListFile;
    static List<Result> resultList;
    static List<Word> wordList;
    private String wordListFile;

    Search(String wordListFile, String pageListFile) throws Exception {
        this.wordListFile = wordListFile;
        this.pageListFile = pageListFile;
    }


    public List<Result> executeQuery(String querey){

        nullCheck();
        int listSize = wordList.size()/5;
        String search = querey;
             //Split querey into an array of Items
        String [] terms = new String[querey.length()-querey.trim().length()+1];

        terms[0] = querey;

        querey = querey.substring(querey.indexOf(" "));

        for(int i = 1; i < terms.length; i++){
           terms[i] = querey.substring(0,querey.indexOf(" "));
           querey = querey.substring(querey.indexOf(" ")+1);
        }

            Thread[] threads = new Thread[5];
            threads[0] = new SearchThread(0,listSize,terms);
            threads[1] = new SearchThread(listSize+1,2*listSize,terms);
            threads[2] = new SearchThread(2*listSize+1,3*listSize,terms);
            threads[3] = new SearchThread(3*listSize+1,4*listSize,terms);
            threads[4] = new SearchThread(4*listSize+1,5*listSize,terms);

            for(Thread t: threads){
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



        return resultList;
    }

    public void nullCheck(){
            if(wordList==null||pageList==null) {
                try {
                    setup(this.wordListFile, this.pageListFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }

    public void setup(String wordListFile, String pageListFile)throws Exception{
            wordList = FileUtils.getWordList(wordListFile);
            pageList = FileUtils.getPageList(pageListFile);



    }

    public static void sort(List<Result> results){

    }

}
