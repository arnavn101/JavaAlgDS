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

## License

MIT License Copyright (c) 2021, Arnav Nidumolu
