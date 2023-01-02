# DSA_Assignment2_TicketReservationProgram
--- 

A simple airline ticket reservation program using linked list.

## Requirements
---

The program should display a menu with the following options:
-	Reserve a ticket
-	Cancel a reservation
-	Check whether a ticket is reserves for a particular person
-	Display the passengers

## Afterthought
---

It is a simple 2 week assignment thus the way of implementation of linked list was not complex at all. The type of linked list is unsorted and singular as 
sequencing was not the priority of the assignment. 

However, I feel like the linked list should be a sorted one because:
- the search operation outweighs the maintenance operations here as both creating and cancelling reservation make use of the searching operations
- searching operation has a O(n) complexity on unsorted lists while O(1) on sorted lists

## How to improve/Todo
---
- Create a GUI using JavaFX 
- Change it to a sorted linked list

...
