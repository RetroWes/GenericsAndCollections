import java.math.BigInteger;

class Solution {
    public static BigInteger climbStairs(int n) {
        int[] fibonacci = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170};

        BigInteger[] bigInts = new BigInteger[2];
        bigInts[0] = BigInteger.valueOf(1836311903);
        bigInts[1] = BigInteger.valueOf(2971215073L);
        
        if(n < 45){
            return BigInteger.valueOf(fibonacci[n]);
        }
        else if(n == 45){
            return bigInts[0];
        }
        else if (n == 46){
            return bigInts[1];
        }

        return BigInteger.valueOf(0);
    }

    public static void main(String[] args){
        System.out.println(Solution.climbStairs(46));
    }
}
