# Java Algorithms & DataStructures

Examples of various algorithms and datastructures


## Ordered Arrays 

Basic DataStructure for storing information in order

#### 	Based on Binary Search

```
1) O(logN) for searching
2) Computing average of upper and lower bounds 
3) Keep changing bounds until element found or upper < lower
```

## Sorting Algorithms 

Various algorithms to sort arrays

#### 	1) Bubble Sort

```
1) Keep swapping elements, pushing the greater ones to the right until last element reached
2) The last element would be correctly sorted so continue process for 2nd to last and so on... 
3) O(N^2) - very slow for large data
```

#### 	2) Selection Sort

```
1) Find the minimum in an array and switch it with the first index (left side sorted)
2) Then, find the minimum starting from the second index of the array and continue the same process
3) O(N^2) - but faster than BubbleSort due to lower swaps
```

#### 	3) Insertion Sort

```
1) Find first unsorted pair in the array and select the element which should be moved to left
2) Insert the selected element appropriately and continue to check subsequent pairs
3) O(N^2) - but faster than Bubble and Selection Sorts due to copying instead of swaps
```

#### 	4) Merge Sort

```
1) Continue to divide the list into two until a pair is found and sorted
2) Merge all pairs and all the parts of the list appropriately
3) O(N*logN) - efficient for larger data but requires larger space
```

## Advanced Sorting Algorithms 

More nuanced algorithms to sort arrays

#### 	1) Shell Sort

```
1) Compare elements that are distant apart and swap them if necessary
2) Start with a fixed width gap between 1st and other number to be compared
3) Then continue the process with 2nd and other number with same fixed gap
4) With each pass, reduce value of the gap until it becomes 1 
5) Width Gap Increase with each pass: h = 3*h+1, where h is initially 1
6) Width Gap reduction with each pass: h = (h-1)/3
7) O(N*(logN)^2) complexity - efficient for medium-sized arrays
```

#### 	2) Quick Sort

```
1) First, choose a pivot point (specific number from list)
2) Sort the array with smaller numbers to left of the pivot and larger numbers to right
3) Then choose other pivots for each segment of the array (one for left and right)
4) Pick the rightmost element in each array segment as the pivot
    - And swap the middle element in segment and rightmost after partitioning
5) Median of 3 Approach - pick pivot as median of the start, middle, & end elements
5) O(N*logN) - optimal for large arrays
```

#### 	3) Radix Sort

```
1) TODO
```


## Stack 

DataStructure that only allows access to the last element inserted.

```
1) Only Access the topmost element (LIFO storage - Last in first out)
2) Placing item -> pushing, Removing item -> popping
3) O(1) - Easy to push and pop elements from stack
```

## Queue 

DataStructure that allows the first element inserted to be removed.

```
1) Access the first element inserted (FIFO storage - First in first out)
2) Allows inserting element at rear and removing element at front
3) A DeQueue is a double ended queue (items can be inserted or deleted at both ends)
4) In a priority queue, items with higher priority are pushed to the front of the queue 
```

## Linked List 

List in which each element points to the next, in addition to storing data.

```
1) To find a particular element, the entire chain of elements must be analyzed
2) In a double-ended list, the first link has a reference to the last link
    - This allows for inserting elements at end of list more efficiently
3) Doubly Linked List: Elements with 2 references - to next link and to previous link
    - Allows for backward traversal as well as forward
```

## Binary Tree 

DataStructure that allows for quick searching and insertion of elements.

```
1) A tree consists of nodes connected by edges (instance of graph)
2) Generally, trees are small on the top and large on the bottom
3) In a binary tree, each node has max of two children
4) Tree Terms
    i) Sequence of Nodes - Path
    ii) Root node - node at top of tree (only 1 path from root to any other node)
    iii) Parent - node beneath which other nodes are situated
    iv) Child - nodes can have one of more lines connecting it to other nodes
    v) Leaf - nodes that do not have children
    vi) Subtree - node that contains a collection of other nodes and their children
5) Binary Search: Node's left child has key less than parent
    - And the right child has key greater than parent
6) Type of Traversals
    i) Inorder (Left, Root, Right) 
    ii) Preorder (Root, Left, Right) 
    iii) Postorder (Left, Right, Root)
7) O(logN) time for all operations
```

## Red Black Tree 

DataStructure that avoids unbalanced trees and ensures a reasonably symmetrical arrangements of nodes.

```
1) During insertion and deletion, rules are followed to ensure a balanced tree
2) Rules to be followed
    i) Every node is either black or red colored
    ii) The root is always black
    iii) If a node is red, its children must be black
    iv) Every path from root to a leaf (or null child) should contain same no. of black nodes
            - Number of black nodes on a path from root to leaf is called "black height"
3) Color flip when, in the insertion process, a black node with two red children is encountered
4) Rotations
    i) RoL - The node's right child takes it place and the node moves into position of left child
    ii)RoR - The node's left child takes it place and the node moves into position of right child
    iii) Inside grandchild always disconnects from parent and reconnects to former grandparent
5) Slightly Slower Insertion than ordinary binary tree (but still O(logN))
    - Optimized for sorted data insertion
```

## 2-3-4 tree 

DataStructure that allows for larger number of children nodes and data items.

```
1) 3 Possible arrangements for nodes --> 2, 3, or 4 children with 1 less data items
    - Child Links = Data Items + 1
2) Nodes with single links are not permitted
    - Ex: A node with 1 data item should have 2 links or no links if it is a leaf
3) Tree Structure Rules
    i) All children in subtree rooted at child 0 have key values < than key 0
    ii) All children in subtree rooted at child 1 have key values > than key 0 and < key 1
    iii) All children in subtree rooted at child 2 have key values > key 1 and < key 2
    iv) All children in subtree rooted at child 3 have key values > key 2
4) Data items are ordered in an ascending manner within nodes
5) Data items can only be inserted in leaves to avoid chainging links in other nodes
    - If no full nodes are encountered, the item can simply be inserted into a leaf
    - If a full node is found in the path, it should be split into 2 before inserting the item
    - If the root is full, it is divided into 3 parts before inserting the item
6) O(logN) search time
```

## Hash Table 

DataStructure that offers fast insertion and searching.

```
1) A range of key values is transformed into a range of array index values
    - A hash function converts numbers in large range to numbers in small range (using %)
2) Turns a key into an array index and returns the content of the array at that index
3) Data is inserted using a hash function into an array, known as hash table
4) Open Addressing - data that cant be placed at index specified by HF is placed elsewhere
    i) Linear Probing: search sequentially for vacant cells
    ii) Quadratic probing: probe widely seperated cells (increase step size with each step)
        - Ensure that array size is a prime number to prevent endless sequence of steps
    iii) Double hashing: hash the key with another hash function, and use result as the step size
        - Ex: stepSize = constant - (key % constant), where constant is prime
        - Size of hash table should be a prime number (forces the probe to check every cell)
5) Separate Chaining - install a linked list at each index to account for more data with same hash
6) Around O(1) time for searching and insertion depending on size of clusters
```

## Heap 

A Datastructure similar to a binary tree.

```
1) A heap is a binary tree with the following characteristics
    i) Complete - every parent node, apart from those in last node, have 2 children
    ii) Implemented as an array
    iii) Each node satisfied the heap condition - every node's key is > keys of children 
2) In every path from the root to a leaf, the nodes are arranged in descending order
3) Removal and Insertion is based on swapping elements until it is in the right place
4) O(logN) time for insertions and deletions
5) HeapSorts can be implemented using insert and removal operations of heaps
    - O(N*logN) time regardless of distribution of data
```

## Graphs 

A Datastructure that is used to represent complex relationships between objects.

```
1) It consists of vertices (nodes) connected by edges
    - Two vertices are considered adjacent if connected by a single edge
    - A path refers to sequence of edges
2) Connected Graph: there is at least one path from every vertex to another
3) Directed graphs: edges have a direction associated with them
4) Ways to model graphs
    i) Adjacency Matrix - 2D array specifying whether a edge exists between 2 vertices
    ii) Adjancency List - each index contains a list of vertices adjacent to the given vertex
```

#### Depth-First Search

Uses a stack to traverse through a graph, remembering previous vertices in a path

```
1) It first visits the given vertex, pushes it onto a stack and then travels to an adjacent vertex
    - The process is repeated for all adjacent vertices until it finds a "dead-end" (no adj vertices)
2) Then, it pops the recent vertex from the stack and visits the previous vertex
    - It traverses through other adjacent vertices that were not visited before and pops at deadend
3) The algorithm ends when stack becomes empty
```

#### Breadth-First Search

Uses a queue to traverse a graph instead of a stack

```
1) Visits all unvisited adjacent vertices from starting vertex, inserting them into a queue
2) If no more unvisited vertices, remove a vertex from queue, making it current vertex
3) Execute the same process for all other vertices 
```

#### Minimum spanning tree

Ensures a minimum number of edges that connect vertices in a graph

```
1) Number of edges E in a minimum spanning tree is one less than the number of vertices V
    i) E = V - 1
2) Records the edges traveled in a depth first search 
    i) The path of DFS algorithm through a graph is a minimum spanning tree
```

#### Topological sorting

Allows for a linear ordering of graph vertices depending on the direction of the edges

```
1) It first involves finding vertex that has no successors (no downstream vertices)
    i) The vertex is then deleted from graph, with its label inserted at beginning of a list
2) The steps above are repeated until all vertices are gone 
    i) The final list would show the vertices arranged in topological order
3) Unable to handle cyclic graphs (graph with a path that ends up where it started)
    - only works on directed acyclic graphs
```

#### Warshall's Algorithm (Transitive Closure)

Used for determining if a vertex is reachable from another vertex (Transitive Closure)

```
1) Constructs a connectivity table that works on the basis of:
    - If a path exists from vertex L to M and from M to N, there is a path from L to N
2) Iterates through each row and column, noting down possible paths
```

## License

MIT License Copyright (c) 2021, Arnav Nidumolu
