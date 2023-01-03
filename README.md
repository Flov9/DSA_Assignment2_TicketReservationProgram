# linkedlist-ticket-reservation-program

A simple airline ticket reservation program using linked list.

## Requirements

The program should display a menu with the following options:
-	Reserve a ticket
-	Cancel a reservation
-	Check whether a ticket is reserves for a particular person
-	Display the passengers

## General Information

It is a simple 2 week assignment thus the way of implementation of linked list was not complex at all. The type of linked list is unsorted and singular as 
sequencing was not the priority of the assignment. 

## Room for Improvements

Improvement:
- Change it to a sorted linked list:
  - the search operation outweighs the maintenance operations here as both creating and cancelling reservation make use of the searching operations
  - searching operation has a O(n) complexity on unsorted lists while O(1) on sorted lists
- Try to create a linked list of flights with each node including a reference to a linked list of passengers. 

Todo:
- Create a GUI using JavaFX 

...
