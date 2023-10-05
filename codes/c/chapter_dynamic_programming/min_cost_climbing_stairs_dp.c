/**
 * File: min_cost_climbing_stairs_dp.c
 * Created Time: 2023-10-02
 * Author: Zuoxun (845242523@qq.com)
 */

#include "../utils/common.h"

/* 求最小值 */
int min(int a, int b) {
    return a < b ? a : b;
}

/* 爬楼梯最小代价：动态规划 */
int minCostClimbingStairsDP(int cost[], int cost_size) {
    int n = cost_size - 1;
    if (n == 1 || n == 2)
        return cost[n];
    // 初始化 dp 表，用于存储子问题的解
    int dp[n + 1];
    // 初始状态：预设最小子问题的解
    dp[1] = cost[1];
    dp[2] = cost[2];
    // 状态转移：从较小子问题逐步求解较大子问题
    for (int i = 3; i <= n; i++) {
        dp[i] = min(dp[i - 1], dp[i - 2]) + cost[i];
    }
    return dp[n];
}

/* 爬楼梯最小代价：空间优化后的动态规划 */
int minCostClimbingStairsDPComp(int cost[], int cost_size) {
    int n = cost_size - 1;
    if (n == 1 || n == 2)
        return cost[n];
    int a = cost[1], b = cost[2];
    for (int i = 3; i <= n; i++) {
        int tmp = b;
        b = min(a, tmp) + cost[i];
        a = tmp;
    }
    return b;
}

/* Driver Code */
int main() {
    int cost[] = {0, 1, 10, 1, 1, 1, 10, 1, 1, 10, 1};
    int cost_size = sizeof(cost) / sizeof(cost[0]);
    printf("输入楼梯的代价列表为 [");
    for (int i = 0; i < cost_size; i++) {
        if (i != cost_size - 1) printf("%d, ", cost[i]);
        else printf("%d", cost[i]);
    }
    printf("]\n");

    int res = minCostClimbingStairsDP(cost, cost_size);
    printf("爬完楼梯的最低代价为 %d\n", res);

    res = minCostClimbingStairsDPComp(cost, cost_size);
    printf("爬完楼梯的最低代价为 %d\n", res);

    return 0;
}
