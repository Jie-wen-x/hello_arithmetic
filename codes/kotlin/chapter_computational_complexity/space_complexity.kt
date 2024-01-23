package chapter_computational_complexity

import utils.ListNode
import utils.TreeNode
import utils.printTree

class space_complexity {
    /* 函数 */
    fun function(): Int {
        // 执行某些操作
        return 0
    }

    /* 常数阶 */
    fun constant(n: Int) {
        // 常量、变量、对象占用 O(1) 空间
        val a = 0
        val b = 0
        val nums = arrayOfNulls<Int>(n)
        val node = ListNode(0)
        // 循环中的变量占用 O(1) 空间
        for (i in 0..<n) {
            val c = 0
        }
        // 循环中的函数占用 O(1) 空间
        for (i in 0..<n) {
            function()
        }
    }

    /* 线性阶 */
    fun linear(n: Int) {
        // 长度为 n 的数组占用 O(n) 空间
        val nums = arrayOfNulls<Int>(n)
        // 长度为 n 的列表占用 O(n) 空间
        val nodes = mutableListOf<ListNode>()
        for (i in 0..<n) {
            nodes.add(ListNode(i))
        }
        // 长度为 n 的哈希表占用 O(n) 空间
        val map = mutableMapOf<Int, String>()
        for (i in 0..<n) {
            map[i] = i.toString()
        }
    }

    /* 线性阶（递归实现） */
    fun linearRecur(n: Int) {
        println("递归 n = $n")
        if (n == 1)
            return
        linearRecur(n - 1)
    }

    /* 平方阶 */
    fun quadratic(n: Int) {
        // 矩阵占用 O(n^2) 空间
        val numMatrix: Array<Array<Int>?> = arrayOfNulls(n)
        // 二维列表占用 O(n^2) 空间
        val numList: MutableList<MutableList<Int>> = arrayListOf()
        for (i in 0..<n) {
            val tmp = mutableListOf<Int>()
            for (j in 0..<n) {
                tmp.add(0)
            }
            numList.add(tmp)
        }
    }

    /* 平方阶（递归实现） */
    tailrec fun quadraticRecur(n: Int): Int {
        if (n <= 0)
            return 0
        // 数组 nums 长度为 n, n-1, ..., 2, 1
        val nums = arrayOfNulls<Int>(n)
        println("递归 n = $n 中的 nums 长度 = ${nums.size}")
        return quadraticRecur(n - 1)
    }

    /* 指数阶（建立满二叉树） */
    fun buildTree(n: Int): TreeNode? {
        if (n == 0)
            return null
        val root = TreeNode(0)
        root.left = buildTree(n - 1)
        root.right = buildTree(n - 1)
        return root
    }

}

/* Driver Code */
fun main() {
    val n = 5
    val sc = space_complexity()
    // 常数阶
    sc.constant(n)
    // 线性阶
    sc.linear(n)
    sc.linearRecur(n)
    // 平方阶
    sc.quadratic(n)
    sc.quadraticRecur(n)
    // 指数阶
    val root: TreeNode? = sc.buildTree(n)
    printTree(root)
}
