# JavaOOP_HW9

import java.util.*;

public class Eggs {
    public static void main(String[] args) {
        List<Integer> eggs = new ArrayList<>();
        Set<Integer> diffEggs = new HashSet<>();
        double sum = 0;
        int tries = 0;
        Random random = new Random();
        boolean tryCollecting = true;
        while(tryCollecting){
            while (diffEggs.size() < 10) {
                int currEgg = random.nextInt(10);
                eggs.add(currEgg);
                diffEggs.add(currEgg);
            }
            tries++;
            sum+=eggs.size()/2;
            if(eggs.size()<15){
                tryCollecting=false;
            }
            eggs= new ArrayList<>();
            diffEggs = new HashSet<>();
        }
        System.out.println("Money spent on average : "+ sum/tries);
    }
}
