public class CoinChange {
  /**
   * This function implements a bottom-up dynamic programming approach to find the minimum number of coins needed to make up a specific amount.
   * It uses an array dp where each index represents the minimum number of coins needed for that amount.
   * Additionally, it prints the types of coins used to achieve this minimum.
   *
   * @param coins Array of coin denominations available
   * @param amount Total amount for which we need the minimum number of coins
   * @return The minimum number of coins required to make the exact amount, or -1 if it is not possible
   */
  public static int minCoins(int[] coins, int amount) {
      int[] dp = new int[amount + 1];
      int[] coinCount = new int[amount + 1];  // To track the last coin used at each step
      java.util.Arrays.fill(dp, amount + 1);
      dp[0] = 0;

      for (int i = 1; i <= amount; i++) {
          for (int coin : coins) {
              if (i >= coin && dp[i - coin] + 1 < dp[i]) {
                  dp[i] = dp[i - coin] + 1;
                  coinCount[i] = coin;  // Track the coin used to reach this minimum
              }
          }
      }

      if (dp[amount] > amount) {
          System.out.println("It is not possible to form the amount with given coins.");
          return -1;
      } else {
          printCoinsUsed(coinCount, amount);
          return dp[amount];
      }
  }

  /**
   * This method prints out each coin used to make up the total amount from the tracking array.
   *
   * @param coinCount The array containing the last coin used to reach each amount up to the target
   * @param amount The target amount
   */
  private static void printCoinsUsed(int[] coinCount, int amount) {
      System.out.println("Coins used to form the amount " + amount + ":");
      if(amount == 0) {System.out.println("NONE"); return;}
      while (amount > 0) {
          int thisCoin = coinCount[amount];
          System.out.print(thisCoin + " ");
          amount -= thisCoin;
      }
      System.out.println(); // Print a newline at the end
  }

  public static void main(String[] args) {
      int[] coins = {1, 2, 5};
      int amount = 11;
      System.out.println("Minimum coins needed for amount $0.11: " + minCoins(coins, amount)+ "\n");

      int[] coins1 = {1, 2, 5, 10, 25, 50, 100};
      amount = 684;
      System.out.println("Minimum coins needed for amount $6.84: " + minCoins(coins1, amount) + "\n");

      int[] coins2 = {1, 5, 10, 25};
      amount = 0;
      System.out.println("Minimum coins needed for amount $0.00: " + minCoins(coins2, amount)+ "\n");

      int[] coins3 = {5, 10, 25};
      amount = 37;
      System.out.println("Minimum coins needed for amount $0.37: " + minCoins(coins3, amount)+ "\n");
  }
}