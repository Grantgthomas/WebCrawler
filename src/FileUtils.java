/**
 * Created by Grant on 4/6/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils  {

    public FileUtils(){}

   public static List<Page> getPageList(String filePath)throws Exception{
       String read;
       List <Page> pageList = new ArrayList<Page>();
       int listIndex = 0;
       if(filePath == null)
           return null;
       File f = new File(filePath);
       try {
           FileInputStream fis = new FileInputStream(f);
           ObjectInputStream ois = new ObjectInputStream(fis);
           pageList = (List)ois.readObject();
       }catch(FileNotFoundException e){
           System.out.println("File does not exist!");
           return null;
       }
       return pageList;

   }

   public static List<Word> getWordList(String filePath)throws Exception{
     //  String read;
       List <Word> wordList;
   //    int listIndex = 0;
       if(filePath == null)
           return null;
       File f = new File(filePath);
       try {
           FileInputStream fis = new FileInputStream(f);
           ObjectInputStream ois = new ObjectInputStream(fis);
           wordList = (List)ois.readObject();
       }catch(FileNotFoundException e){
           System.out.println("File does not exist!");
           return null;
       }
       return wordList;

   }

   public boolean savePageTable(List<Page> pageTable, String filePath)throws Exception{
     Object url;

       if(filePath == null||pageTable == null)
           return false;
       File f = new File(filePath);
       FileOutputStream fos = new FileOutputStream(f);
       ObjectOutputStream oos = new ObjectOutputStream(fos);



       try {
                oos.writeObject(pageTable);

           oos.close();
       }catch(IOException e){
           return false;
       }
        return true;
   }

   public boolean saveWordTable(List<Word> wordTable, String filePath)throws Exception{
       Object url = new Object();
        if(filePath == null)
           return false;


       try {
       File f = new File(filePath);
       FileOutputStream fos = new FileOutputStream(f);
       ObjectOutputStream oos = new ObjectOutputStream(fos);

       if(wordTable == null)
           return false;

           oos.writeObject(wordTable);
           oos.close();
       }catch(IOException e) {
           return false;

       }

       return true;
   }
}
