package sample;

import java.util.Random;

public class Game extends Thread{

    public static int level = 0;

    public int position;

    private Random r = new Random();

    public int v[] = new int[level + 4];

    public Game() {

        position = 0;

        for (int i = 0; i < level + 4; i++) {

            v[i] = r.nextInt(4);
        }

        for(int i:v) System.out.print(i+" ");
        System.out.println();
    }

    public int stopGame(int x){

        if(v[position] != x) return 0; // stop game
        if(position != level+3) {
            position++;
            return 1; //continue game
        }
        return 2; //stop game; player wins
    }

}
