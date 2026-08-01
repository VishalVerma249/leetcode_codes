class Solution {
   public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;

        // Original restrictions + building 1 + building n
        int[][] limits = new int[m + 2][2];

        for (int i = 0; i < m; i++) {
            limits[i][0] = restrictions[i][0];
            limits[i][1] = restrictions[i][1];
        }

        // Building 1 must have height 0
        limits[m][0] = 1;
        limits[m][1] = 0;

        // Without other restrictions, building n can be at most n - 1
        limits[m + 1][0] = n;
        limits[m + 1][1] = n - 1;

        // Sort according to building number
        Arrays.sort(limits, Comparator.comparingInt(a -> a[0]));

        // Left-to-right:
        // left restriction may reduce the current restriction
        for (int i = 1; i < limits.length; i++) {
            int distance = limits[i][0] - limits[i - 1][0];

            int maximumFromLeft = limits[i - 1][1] + distance;

            limits[i][1] = Math.min(
                limits[i][1],
                maximumFromLeft
            );
        }

        // Right-to-left:
        // right restriction may reduce the current restriction
        for (int i = limits.length - 2; i >= 0; i--) {
            int distance = limits[i + 1][0] - limits[i][0];

            int maximumFromRight = limits[i + 1][1] + distance;

            limits[i][1] = Math.min(
                limits[i][1],
                maximumFromRight
            );
        }

        int answer = 0;

        // Find the maximum possible peak between every pair
        for (int i = 1; i < limits.length; i++) {
            int leftPosition = limits[i - 1][0];
            int leftHeight = limits[i - 1][1];

            int rightPosition = limits[i][0];
            int rightHeight = limits[i][1];

            int distance = rightPosition - leftPosition;
            int heightDifference = Math.abs(leftHeight - rightHeight);

            int peak =
                Math.max(leftHeight, rightHeight)
                + (distance - heightDifference) / 2;

            answer = Math.max(answer, peak);
        }

        return answer;
    }
}