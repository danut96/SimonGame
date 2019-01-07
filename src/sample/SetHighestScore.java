package sample;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SetHighestScore implements AutoCloseable{

    static int highestScore;

   public static void SetHighestScore(int x){

       try(PrintWriter p = new PrintWriter("Output.txt");
           FileReader fin = new FileReader("HighestScore.txt")
       ){

           Scanner scanner = new Scanner(fin);

           int a = scanner.nextInt();

           if(x > a){

               highestScore = x;
               p.print(x);

           }

       }catch(Exception e){
           e.printStackTrace();
       }finally {

           try {
               if (new File("HighestScore.txt").delete()) {
                   if (new File("Output.txt").renameTo(new File("HighestScore.txt"))) ;
               }
           }catch(Exception e){
               //System.out.println("Not working");
           }

       }

   }

   public static void resetHighestScore(){

       try(PrintWriter p = new PrintWriter("Output.txt")){

           p.print(0);

       }catch(Exception e){
           e.printStackTrace();
       }finally {
           if (new File("HighestScore.txt").delete()) {
               if (new File("Output.txt").renameTo(new File("HighestScore.txt"))) ;
           }
       }
   }

   public void close(){
       //resources closed
   }
}
