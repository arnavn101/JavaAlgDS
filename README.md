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

## License

MIT License Copyright (c) 2020, Arnav Nidumolu
