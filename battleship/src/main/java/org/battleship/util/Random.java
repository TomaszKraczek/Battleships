package org.battleship.util;
import java.util.*;

public class Random {
    Random rand = new Random();

    public List<Integer> generateRandomXandY(){
        Random rand = new Random();
        List<Integer> XandY = new ArrayList<>();
        XandY.add(nextInt(10));
        XandY.add(nextInt(10));
        return XandY;
    }

    private int nextInt(int i) {
        return rand.nextInt(i);
    }
}

