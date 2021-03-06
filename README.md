# Project

Java provides classes for working with several types of numbers, but it does not provide anything for working with fractions. My task is to implement a Fraction API (**A**pplication **P**rogrammer's **I**nterface). I am also to write a small program that uses it.

## Purposes of this assignment

The purposes of this assignment include the following:

*   To demonstrate working with classes.
*   To demonstrate reading the API.
*   To demonstrate string manipulation.
*   To demonstrate unit testing.

## General idea of the Project

To implement a Fraction API; in particular, implement a number of methods in the file FractionImpl.java.

Create a package named `fraction`. The interface `Fraction` and the class `FractionImpl` will be inside this package. (Source files from which you can start are provided.) I do not need to and should not edit the file Fraction.java at all; this file contains the interface. This interface can be conceived of as a contract between the designer/future user of the `FractionImpl` class (the course staff!) and the programmer implementing this class (me!).

Note: although I am asked to implement a number of methods, the implementations, for the most part, should be quite short.

## The API

The following lists some information about my new class. As regards implementing the methods, there is no strict requirement on how a method needs to behave wherever the behavior is not specified by the description below; however, in all cases it is suggested that I think about what _reasonable_ behavior would be, and attempt to implement it.

### Instance variables

The instance variables should consist of two `private` integers, known as the `numerator` and the `denominator`. **Do not** provide public accessors or mutators (getters or setters) for these instance variables; there is no reason for anything outside the `FractionImpl` class to know about them.

Note on access: Even though these instance variables are `private`, they are private to the _class_, not to an object. This means that any `FractionImpl` object can access the private variables of any other `FractionImpl` object; it's only outside this class that I cannot access them.

I should obey the following properties/invariants concerning the instance variables:

*   Zero should be represented as `0/1`.

*   The denominator should never be zero.

*   The denominator should never be negative. A negative number for the denominator may be given to the constructor to create a fraction, but a negative fraction should be represented _internally_ with a negative numerator.

*   The fraction should always be kept in reduced form, that is, the _greatest common divisor_ (GCD) of the numerator instance variable and the denominator instance variable should be `1`. (See the relevant note below.)

### Constructors

The following lists the constructors I should have. (Please note that Java does not allow constructors to be specified in an _interface_, hence the use of `FractionImpl`.)

<table>

<thead>

<tr>

<th>Constructor</th>

<th>How it uses its parameters</th>

</tr>

</thead>

<tbody>

<tr>

<td>`public FractionImpl(int numerator, int denominator)`</td>

<td>Parameters are the _numerator_ and the _denominator_. **Normalize** the fraction as I create it. For instance, if the parameters are `(8, -12)`, create a `Fraction` with numerator `-2` and denominator `3`. The constructor should throw an `ArithmeticException` if the denominator is zero.</td>

</tr>

<tr>

<td>`public FractionImpl(int wholeNumber)`</td>

<td>The parameter is the numerator and `1` is the implicit denominator.</td>

</tr>

<tr>

<td>`public FractionImpl(String fraction)`</td>

<td>The parameter is a `String` containing either a whole number, such as `"5"` or `"-3"`, or a fraction, such as `"8/-12"`. Allow blanks around (but not within) integers; thus, `"10 /-4"` should be handled, but `"1 0 / -4"` (where there is a space between the '1' and the '0') need not be.</td>

</tr>

</tbody>

</table>

The constructor should throw an `ArithmeticException` if given a string representing a fraction whose denominator is zero.  

I may find it helpful to look at the available [`String`](https://docs.oracle.com/javase/9/docs/api/java/lang/String.html) methods in the [Java API](https://docs.oracle.com/javase/9/docs/api/overview-summary.html).

##### Notes:

*   Java allows I to have more than one constructor, so long as they have different numbers or types of parameters. For example, if I call `new FractionImpl(3)` I will get the second constructor listed above. A `String` is a string, though, so the third constructor will have to distinguish between `"3"` and `"3/4"`.
*   To throw an `Exception`, write a statement such as:

    <div>

        throw new ArithmeticException("Divide by zero"); 

    </div>

    (The `String` parameter is optional.)

*   The java method `Integer(string).parseInt()` will return the `int` equivalent of the string (assuming that the string represents a legal integer). Malformed input will cause it to throw a `NumberFormatException`.

### Methods

The following lists the non-constructor methods that should be implemented.  
In what follows, `this` is sometimes denoted by `a/b`, and an argument `f` is sometimes denoted by `c/d`.

<table>

<thead>

<tr>

<th>Method signature</th>

<th>What it does</th>

</tr>

</thead>

<tbody>

<tr>

<td>`public Fraction add(Fraction f)`</td>

<td>Returns a new `Fraction` that is the **sum** of `this` and `f`:  

`a/b + c/d` is `(ad + bc)/bd`</td>

</tr>

<tr>

<td>`public Fraction subtract(Fraction f)`</td>

<td>Returns a new `Fraction` that is the **difference** of `this` minus `f`:  

`a/b - c/d` is `(ad - bc)/bd`</td>

</tr>

<tr>

<td>`public Fraction multiply(Fraction f)`</td>

<td>Returns a new `Fraction` that is the **product** of `this` and `f`:  

`(a/b) * (c/d)` is `(a*c)/(b*d)`</td>

</tr>

<tr>

<td>`public Fraction divide(Fraction f)`</td>

<td>Returns a new `Fraction` that is the **quotient** of dividing `this` by `f`:  

`(a/b) / (c/d)` is `(a*d)/(b*c)`</td>

</tr>

<tr>

<td>`public Fraction abs()`</td>

<td>Returns a new `Fraction` that is the _absolute value_ of `this` fraction.</td>

</tr>

<tr>

<td>`public Fraction negate()`</td>

<td>Returns a new `Fraction` that has the same numeric value of `this` fraction, but the opposite sign.</td>

</tr>

<tr>

<td>`public Fraction inverse()`</td>

<td>The inverse of `a/b` is `b/a`.</td>

</tr>

<tr>

<td>`@Override`  
`public boolean equals(Object o)`</td>

<td>Returns `true` if `o` is a `Fraction` equal to `this`, and `false` in all other cases.</td>

</tr>

<tr>

<td>`@Override`  
`public int compareTo(Fraction o)`</td>

<td>This method returns:

*   A negative `int` if `this` is less than `o`.
*   Zero if `this` is equal to `o`.
*   A positive `int` if `this` is greater than `o`.

</td>

</tr>

<tr>

<td>`@Override`  
`public String toString()`</td>

<td>Returns a `String` of the form `n/d`, where `n` is the _numerator_ and `d` is the _denominator_.  
However, if `d` is `1`, just return `n` (as a `String`).  
The returned `String` should not contain any blanks.  
If the fraction represents a negative number, a minus sign should precede `n`.  
This should be one of the first methods I write, because it will help I in debugging.  
Note that, for the purposes of this assignment, there is no need to implement the related clone() and hashCode() methods.</td>

</tr>

</tbody>

</table>

#### Notes:

*   All `Fraction`s should be _immutable_, that is, there should be no way to change their components after the numbers have been created. Many of the requested methods simply return a new fraction.
*   When I define `equals`, notice that it requires an `Object` as a parameter. This means that the first thing the method should do is make sure that its parameter is in fact a `Fraction`, and return `false` if it is not.
    *   I can test with `o instanceof Fraction`.
    *   I can use `o` as a `Fraction` by saying `((Fraction) o)`, or I can save it in a `Fraction` variable by saying `Fraction f = (Fraction) o;` and then using `f`.
*   I can create additional "helper" methods (for example, to compute the GCD, or to normalise a fraction), if I wish; indeed, _we recommend doing so_. If I do, **do not** make these methods `public`, but **do** test them.

*   To put a fraction into its lowest terms, divide both the numerator and the denominator by their Greatest Common Divisor (GCD); _Euclid's algorithm_ finds the GCD of two positive integers. Briefly, it works as follows (please refer to the web for more information if needed):

    *   As long as the two numbers are both nonzero, replace the larger number with the remainder of dividing the larger by the smaller (this can be done via code having the form `larger = larger % smaller`).
    *   As soon as one of the numbers is equal to zero, the other number is the GCD.

## Unit testing

I must include a JUnit file with unit tests; these should test each of the methods that I implement in the `FractionImpl` class. This includes ensuring that the correct exceptions are thrown, when appropriate.

## Comments

All methods in my `FractionImpl` class should have comments.

Where I implement a method from the interface given in Fraction.java (that is, where there is an @Override annotation in the implementation) I do not need to duplicate the method comments from the interface. If I choose to use Javadoc (which is optional), the @inheritDoc annotation in the comment block will ensure that the method comments are inherited from the interface. I may want to amend or add additional information in my method headers in FractionImpl.java, for example, information that is specific to my implementation.

Any additional methods (such as helper methods) in my implementation should be fully documented with a comment header which describes what the method achieves, the parameters (if any), the return value (if any), and which exceptions the method may throw and under what circumstances. (I may use Javadoc format if I wish, but again, this is not required.)

Inside methods, I should provide comments. In general, these should be high-level comments to aid the reading of my code by someone who is already familiar with Java.

