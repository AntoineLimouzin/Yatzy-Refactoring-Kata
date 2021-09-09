import java.util.Arrays;

public class Yatzy {
    
    private int[] dice = new int[5];
    
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
        
        Arrays.sort(dice);
    }

    public int chance(int d1, int d2, int d3, int d4, int d5)
    {
        int sum = 0;
        for (int i = 0; i < dice.length; i++)
        {
            sum += dice[i];
        }
    }

    public int yatzy()
    {
        return dice[0]==dice[4]?50:0;
    }
    
    private int n(int n)
    {
        int res = 0;
        for (int i = 0; i < dice.length; i++)
        {
            res += dice[i]==n?n:0;
        }
    }

    public int ones() {
        return n(1);
    }

    public int twos() {
        return n(2);
    }

    public int threes() {
        return n(3);
    }
    
    public int fours()
    {
        return n(4);
    }

    public int fives()
    {
       return n(5);
    }

    public int sixes()
    {
        return n(6);
    }
   
    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int four_of_a_kind()
    {
        if (dice[0] == dice[3]){
            return 4*dice[0];
        }
        else if (dice[1] == dice[4]){
            return 4*dice[1];
        }
        else{
            return 0;
        }
    }

    public int three_of_a_kind()
    {
        if (dice[0] == dice[2]){
            return 3*dice[0];
        }
        else if (dice[1] == dice[3]){
            return 3*dice[1];
        }
        else if (dice[2] == dice[4]){
            return 3*dice[2];
        }
        else{
            return 0;
        }
    }

    public int smallStraight()
    {
        if (dice[0] == 1 && dice[4] == 5 && chance() == 15){
            return 15;
        }
        else {
            return 0;
        }
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        if (dice[0] == 2 && dice[4] == 6 && chance() == 20){
            return 20;
        }
        else {
            return 0;
        }
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}



