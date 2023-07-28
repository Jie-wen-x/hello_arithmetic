# 小结

- 栈是一种遵循先入后出原则的数据结构，可通过数组或链表来实现。
- 从时间效率角度看，栈的数组实现具有较高的平均效率，但在扩容过程中，单次入栈操作的时间复杂度会降低至 $O(n)$ 。相比之下，基于链表实现的栈具有更为稳定的效率表现。
- 在空间效率方面，栈的数组实现可能导致一定程度的空间浪费。但需要注意的是，链表节点所占用的内存空间比数组元素更大。
- 队列是一种遵循先入先出原则的数据结构，同样可以通过数组或链表来实现。在时间效率和空间效率的对比上，队列的结论与前述栈的结论相似。
- 双向队列是一种具有更高自由度的队列，它允许在两端进行元素的添加和删除操作。

## Q & A

!!! question "浏览器的前进后退是否是双向链表实现？"

    浏览器的前进后退功能本质上是“栈”的体现。当用户访问一个新页面时，该页面会被添加到栈顶；当用户点击后退按钮时，该页面会从栈顶弹出。使用双向队列可以方便实现一些额外操作，这个在双向队列章节有提到。

!!! question "在出栈后，是否需要释放出栈节点的内存？"

    如果后续仍需要使用弹出节点，则不需要释放内存。若之后不需要用到，`Java` 和 `Python` 等语言拥有自动垃圾回收机制，因此不需要手动释放内存；在 `C` 和 `C++` 中需要手动释放内存。

!!! question "双向队列像是两个栈拼接在了一起，它的用途是什么？"

    双向队列就像是栈和队列的组合，或者是两个栈拼在了一起。它表现的是栈 + 队列的逻辑，因此可以实现栈与队列的所有应用，并且更加灵活。