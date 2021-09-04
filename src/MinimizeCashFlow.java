public class MinimizeCashFlow {
    private static final int N = 3;

    public static void main(String[] args) {
        int graph[][] = {{0, 1000, 2000},
                {0, 0, 5000},
                {0, 0, 0}};
        minCashFlow(graph);
    }

    private static void minCashFlow(int[][] graph) {
        int amount[] = new int[N];
        for (int p = 0; p < N; p++) {
            for (int i = 0; i < N; i++) {
                amount[p] += graph[i][p] - graph[p][i];
            }
        }
        minCashFlowRecur(amount);
    }

    private static void minCashFlowRecur(int[] amount) {
        int mxCredit = getMax(amount);
        int mxDebit = getMin(amount);

        if (amount[mxDebit] == 0 && amount[mxCredit] == 0)
            return;
        int min = Math.min(-amount[mxDebit], amount[mxCredit]);
        amount[mxDebit] += min;
        amount[mxCredit] -= min;
        System.out.println("Person " + mxDebit + " pays " + min
                + " to " + "Person " + mxCredit);
        minCashFlowRecur(amount);
    }

    private static int getMin(int[] amount) {
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (amount[i] < amount[min]) {
                min = i;
            }
        }
        return min;
    }

    private static int getMax(int[] amount) {
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (amount[i] > amount[max])
                max = i;
        }
        return max;
    }


}
