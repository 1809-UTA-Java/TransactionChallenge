# TransactionChallenge
Monday Week 2 coding challenge

Using Files, I/O, Collections, and Threads, create a program that will read a text file containing an inventory list of items. It should then create two or more threads, each one using a separate Collection object to take and store items from the list, then save the changes to the initial file, before allowing another thread its turn to take items. Then print the items of each thread. The total number should equal the initial number in the original file.

Example input file:
```
Bread
Carrots
Orange Juice
Cheese
Milk
Eggs
Apples
```

Example output:
```
Thread 1: [Carrots, Cheese, Apples]
Thread 2: [Bread, Orange Juice, Milk, Eggs]
```

The algorithm for choosing is up to you. You may work in pairs but your pull request branch should have both your names.
