public class HouseRobber {
    /**
     * Calculates the maximum amount of money that can be robbed without robbing two consecutive houses.
     * It also tracks and prints which houses are robbed.
     *
     * @param houseMoney Array of integers representing the amount of money at each house.
     * @return The maximum amount of money that can be robbed.
     */
    public static int robMax(int[] houseMoney) {
        if (houseMoney == null || houseMoney.length == 0) {
            System.out.println("No houses to rob.");
            return 0;
        }
        if (houseMoney.length == 1) {
            System.out.println("Only one house to rob: House 0");
            return houseMoney[0];
        }

        int n = houseMoney.length;
        int[] dp = new int[n];
        dp[0] = houseMoney[0];
        dp[1] = Math.max(houseMoney[0], houseMoney[1]);

        // Array to track the optimal choices
        int[] choices = new int[n];
        choices[0] = 1; // Indicates house 0 is robbed
        choices[1] = houseMoney[1] > houseMoney[0] ? 1 : 0; // Choose between house 0 and house 1

        for (int i = 2; i < n; i++) {
            if (houseMoney[i] + dp[i - 2] > dp[i - 1]) {
                dp[i] = houseMoney[i] + dp[i - 2];
                choices[i] = 1;
            } else {
                dp[i] = dp[i - 1];
                choices[i] = 0;
            }
        }

        // Determine the actual houses robbed
        printRobbedHouses(choices, n);

        return dp[n - 1];
    }

    /**
     * Determines and prints the actual sequence of houses robbed.
     *
     * @param choices Array of decisions where 1 means the house is chosen to be robbed.
     * @param n Number of houses
     */
    private static void printRobbedHouses(int[] choices, int n) {
        System.out.print("Houses robbed: ");
        for (int i = n - 1; i >= 0; i--) {
            if (choices[i] == 1) {
                System.out.print(i + " ");
                // Skip the next house since we can't rob two consecutive houses
                i--;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] houseMoney = {2, 3, 2};
        System.out.println("Max money can rob from [2,3,2]: " + robMax(houseMoney));

        int[] houseMoney1 = {2, 3, 2, 4, 7, 2, 9, 1, 8, 0};
        System.out.println("Max money can rob from [2,3,2,4,7,2,9,1,8,0]: " + robMax(houseMoney1));

        int[] houseMoney2 = {};
        System.out.println("Max money can rob from []: " + robMax(houseMoney2)); // Test case with no houses
    }
}