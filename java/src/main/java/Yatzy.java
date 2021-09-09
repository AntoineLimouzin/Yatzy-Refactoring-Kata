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

    public int chance()
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
    
    private int n(int number)
    {
        int res = 0;
        for (int i = 0; i < dice.length; i++)
        {
            res += dice[i]==number?number:0;
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
   
    public static int score_pair()
    {   
        for (int i = dice.length-1; i > 0; i--)
        {
            if (dice[i] == dice[i-1]){
                return 2*dice[i];
            }
        }
        
        return 0;
    }

    public static int two_pair()
    {
        boolean once = false;
        int first = 0;
        
        for (int i=6;i>0;i--){
            if (n(i) != 0 && once){
                return first + n(i);
            }
            else if (n(i) != 0){
                once = true;
                first = n(i);
            }
        }
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
        if (dice[0]==1)
        {
            for (int i = 1; i < dice.length; i++)
            {
                if (dice[i] != dice[i-1] + 1){
                    return 0;
                }
            }
            return 15;
        }
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        if (dice[0]==2)
        {
            for (int i = 1; i < dice.length; i++)
            {
                if (dice[i] != dice[i-1] + 1){
                    return 0;
                }
            }
            return 20;
        }
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        if (three_of_a_kind() != 0 && two_pair() != 0){
            return three_of_a_kind() + two_pair()-(2*three_of_a_kind()/3);
        }
        else{
            return 0;
        }
    }
}



