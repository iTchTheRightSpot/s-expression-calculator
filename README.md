# S-Expression Calculator

This is a simple calculator that takes a single argument as an expression and prints out the integer result of evaluating it

Some examples are:
Integers:
 * INPUT: 123
 * OUTPUT: 123

Add:
* INPUT: (add 1 1)
* OUTPUT: 2

* INPUT: (add 0 (add 3 4))
* OUTPUT: 7

* INPUT: (add 3 (add (add 3 3) 3))
* OUTPUT: 12

Multiply: 
* INPUT: (multiply 1 1)
* OUTPUT: 1

* INPUT: (multiply 0 (multiply 3 4))
* OUTPUT: 1

* INPUT: (multiply 2 (multiply 3 4))
* OUTPUT: 24

* INPUT: (multiply 3 (multiply (multiply 3 3) 3))
* OUTPUT: 81

Exponent:
* INPUT: (exponent 2 5)
* OUTPUT: 32

Mix and Match:
* INPUT: (add 1 (multiply 2 3))
* OUTPUT: 7

* INPUT: (multiply 2 (add (multiply 2 3) 8))
* OUTPUT: 28

* (add 1 2 3 4 (multiply 2 3 5))
* OUTPUT: 40