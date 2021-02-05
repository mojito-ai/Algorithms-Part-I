# Algorithms-Part-I
![Algorithms-Part-I](https://s3.amazonaws.com/coursera_assets/meta_images/generated/XDP/XDP~COURSE!~algorithms-part1/XDP~COURSE!~algorithms-part1.jpeg)

### An ensemble of Data Structures &amp; Algorithms used in computational science. Designed in accordance with Princeton University MOOC (Coursera) &amp; programmed in Java.

[Link to the course](https://online.princeton.edu/node/201)

#### The git-repo includes algorithms used widely in computational science, computational biology and in all IT sectors. The algorithms are divided into the following categories:

1. **Union Find**: Basic approach to developing and analyzing algorithms by considering the dynamic connectivity problem. We introduce the union–find data type and consider several implementations (quick find, quick union, weighted quick union, and weighted quick union with path compression). Finally, we apply the union–find data type to the percolation problem from physical chemistry.

2. **Analysis of Algorithms**: The basis of our approach for analyzing the performance of algorithms is the scientific method. We begin by performing computational experiments to measure the running times of our programs. We use these measurements to develop hypotheses about performance. Next, we create mathematical models to explain their behavior. Finally, we consider analyzing the memory usage of our Java programs.

3. **Stacks and Queues**: We consider two fundamental data types for storing collections of objects: the stack and the queue. We implement each using either a singly-linked list or a resizing array. We introduce two advanced Java features—generics and iterators—that simplify client code. Finally, we consider various applications of stacks and queues ranging from parsing arithmetic expressions to simulating queueing systems.

4. **Elementary Sorts**: We introduce the sorting problem and Java's Comparable interface. We study two elementary sorting methods (selection sort andinsertion sort) and a variation of one of them (shellsort). We also consider two algorithms for uniformly shuffling an array. We conclude with an application of sorting to computing the convex hull via the Graham scan algorithm.

5. **Merge Sort**: We study the mergesort algorithm and show that it guarantees to sort any array of nn items with at most n \lg nnlgn compares. We also consider a nonrecursive, bottom-up version. We prove that any compare-based sorting algorithm must make at least ∼n \lg n∼nlgn compares in the worst case. We discuss using different orderings for the objects that we are sorting and the related concept of stability.

6. **Quick Sort**: We introduce and implement the randomized quicksort algorithm and analyze its performance. We also consider randomized quickselect, a quicksort variant which finds the kth smallest item in linear time. Finally, consider 3-way quicksort, a variant of quicksort that works especially well in the presence of duplicate keys.

7. **Priority Queues**: We introduce the priority queue data type and an efficient implementation using the binary heap data structure. This implementation also leads to an efficient sorting algorithm known as heapsort. We conclude with an applications of priority queues where we simulate the motion of NN particles subject to the laws of elastic collision.

8. **Elementary Symbol Tables**: We define an API for symbol tables (also known as associative arrays) and describe two elementary implementations using a sorted array (binary search) and an unordered list (sequential search). When the keys are Comparable, we define an extended API that includes the additional methods min, max floor, ceiling, rank, and select. To develop an efficient implementation of this API, we study the binary search tree data structure and analyze its performance.

9. **Balanced Search Trees**: Our goal is to develop a symbol table with guaranteed logarithmic performance for search and insert (and many other operations). We begin with 2-3 trees, which are easy to analyze but hard to implement. Next, we consider red-black binary search trees, which we view as a novel way to implement 2-3 trees as binary search trees. Finally, we introduce B-trees, a generalization of 2-3 trees that are widely used to implement file systems.

10. **Geometric Applications of BSTs**: We start with 1d and 2d range searching, where the goal is to find all points in a given 1d or 2d interval. To accomplish this, we consider kd-trees, a natural generalization of BSTs when the keys are points in the plane (or higher dimensions). We also consider intersection problems, where the goal is to find all intersections among a set of line segments or rectangles.

11. **Hash Tables**: We begin by describing the desirable properties of hash function and how to implement them in Java, including a fundamental tenet known as the uniform hashing assumption that underlies the potential success of a hashing application. Then, we consider two strategies for implementing hash tables—separate chaining and linear probing. Both strategies yield constant-time performance for search and insert under the uniform hashing assumption. 

12. **Symbol Table Applications**: We conclude with applications of symbol tables including sets, dictionary clients, indexing clients, and sparse vectors.

## **Author: Mohit Sharma**
## **Email: msharma3@me.iitr.ac.in**

#### Proper care has been taken to ensure that the speed analysis and the space analysis is done. There is a classic space/time tradeoff and the author has ensured to ensure fast processing algorithms in accordance with Moore's Law. Still there might be several errors or performance bugs at some places. Users are welcomed to create PR's or fork the repository to create better performing algorithms.

#### > An algorithm must be seen to be believed. - Sir Donald Knuth

#### >For me, great algorithms are the poetry of computation. Just like verse, they can be terse, allusive, dense, and even mysterious. But once unlocked, they cast a brilliant new light on some aspect of computing. - Francis Sullivan
