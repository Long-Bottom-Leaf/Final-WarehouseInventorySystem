# Final-WarehouseInventorySystem

## Binary Search Tree

1. ### Why does an inorder traversal of a BST return sorted results? Explain in your own words.

   Inorder traversal of a binary search tree returns sorted results because of how the traversal iterates through the
   BST. For any given node in a BST, all values on the left subtree are smaller than the node's value,
   and all values on the right are greater. Inorder traversal goes to the furthest left node, then the root, then the
   right node, which naturally sorts the list.

2. ### What happens to the tree if you insert values in order (1,2,3,4,5)? How does this affect performance?

   If the values are added in order then the root node would become the first number, then the tree would continue to
   grow but always to the right, effectively making a linked list. Searching the list becomes affected as instead of
   0(log n) time, to 0(n) time, which means the list must now search through each value.

3. ### Where would you place duplicate priority values in your tree? Explain your choice.

   I would place duplicate priority levels on the same side, possibly even include a counter that can be ticked up
   or down, maintaining a simple data set and maintains BST structure rules.

## Sorting Algorithm

1. ### Explain how your sorting algorithm works step-by-step using a small example.

   I used Insertion Sort:
   - Start from the second element
   - Compare it with elements before it
   - Shift larger elements to the right
   - Insert the current element into its correct position

   Example:
   
   Input = [1000, 25, 75]

   25 moves before 1000, 75 moves between 25 and 1000

   Output = [25, 75, 1000]

2. ### What is the time complexity of your algorithm?

   The time complexity of Insertion Sort is O(n²) in the average and worst cases, and O(n) in the best case when the 
   list is already sorted.

3. ### When would your sorting algorithm perform well?

   My Insertion Sort algorithm performs well when: 

   - the list is already, or nearly, sorted
   - small datasets
   
   Because it minimizes unnecessary shifting of values in the dataset

4. ### Why is your sorting algorithm ideal or not ideal for very large datasets?

   My sorting algorithm is not ideal for large datasets because it uses nested comparisons which swiftly become slower
   as the volume of data grows.

## System Design

1. ### Why might you choose to sort data in your application instead of the database?

   Sorting in the application allows full control over the algorithm and flexibility for custom logic that can be
   implemented at any time. In real world systems, the database would handle sorting because it is optimized to do so.

2. ### What is one advantage of using a BST in this system?

   The advantages of using a BST in this system are:

   - highest priority is on the rightmost node
   - lowest priority is on the leftmost node
   - sorted using inorder traversal

   Essentially it makes priority-based operations simple, structured, and quick to sort.

3. ### What is one limitation of your current design?

   BST is inherently not self-balancing (without custom algorithms), which is the main limitation with the current
   design. Balance will become skewed which eventually degrades performance to O(n) (effectively a linked list).
   Additionally, BST is stored in memory so when the program is closed, the data does not persist and is reset when the
   program is restarted.

## Where and when did I use AI?

   I'll admit I do tend to use Internet Searches and AI a lot. It's not that I don't understand the concepts or how
   anything works, I simply lack the practice to remember "these words go in this sequence with a . or ! or whatever,
   to do this thing I want." So my use of AI/Internet was used when I needed to check if my code is correct (specifically
   the services and controllers), as well as to check that my overall logic and more specific thinking is correct. For
   example with other projects, checking my logic with database table relationships. For this project I used AI to check
   that I handled exceptions properly, suggestions for test cases, and double checking my BST logic.