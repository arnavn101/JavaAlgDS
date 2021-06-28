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
3) A Doubly Linked List has elements with two references - one to next link and other to previous link
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

## License

MIT License Copyright (c) 2021, Arnav Nidumolu
