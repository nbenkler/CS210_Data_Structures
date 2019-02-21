CS 201: Data Structures
Sorted people: a Java exercise
Hand in via Moodle as Person.java and PeopleSorter.java

Goals
Write a simple-but-not-trivial Java program.
Practice using ArrayList.
Practice organizing your code modularly.
Practice thinking about your program's essential data, and how to use classes to cleanly encapsulate the data.
What's the plan?
OK, did you learn everything there is to know about Java? Maybe not, but let's take it out for a spin anyway.

For this assignment, you will write a program that reads from a text file representing a sequence of people. Your program will need to convert the text file data into an ArrayList<Person>, sort the ArrayList, and print the list out in alphabetical order. This will give you practice working with ArrayList, String, File, Scanner, loops, and simple classes.

What to hand in
Use Moodle to submit a single zip file containing two Java files: Person.java containing the simple Person class, and PeopleSorter.java containing a main method and any supporting methods you find useful. See below for some suggestions

The input file format
Each line of the input file will represent a single person via a comma-delimited list, like so:

family-name,given-name,year-of-birth,month-of-birth,day-of-birth
or, for example:

Ondich,Jeff,1961,5,3
Obama,Barack,1961,8,4
Ocasio-Cortez,Alexandria,1989,10,13
Bush,George,1946,7,6
Bush,George,1924,6,12
Bush,Vannevar,1890,3,11
Hopper,Grace,1906,12,9
Turing,Alan,1912,6,23
Gaga,Lady,1986,3,28
Madonna,,1958,8,16
X,Malcolm,1925,5,19
Bunny,Bugs,1940,7,27
The command-line syntax
Your main method should be structured so that the program expects a single command-line argument specifying the path of the input file. Thus, I would be able to run your program like so:

java PeopleSorter people.txt
if I had a properly formatted text file called people.txt in the same directory as Person.java, or

java PeopleSorter data/morepeople.txt
if morepeople.txt was in a subdirectory called "data".

The expected output
Your program should print to standard output (i.e. System.out) one person per line, alphabetized by family name (then given name in case of identical family names, then year of birth in case of identical names). Each line of output should look like:

given-name family-name age
for example:

Bugs Bunny 78
George Bush 72
George Bush 94
Vannevar Bush 128
Lady Gaga 32
Grace Hopper 112
Madonna 60
Barack Obama 57
Alexandria Ocasio-Cortez 29
Jeff Ondich 57
Alan Turing 106
Malcolm X 93
For the purposes of this assignment, please consider a person's "age" to be their age on Dec 31, 2018. (This means you don't have to figure out how to get Java to tell you today's date, and the graders will be able to test your code easily.)

Code notes
Keep modularity in mind as you design your code, providing methods to encapsulate the main services you want from your Person objects. For example, you might organize your Person class like so:

public class Person {
    private String givenName;
    private String familyName;
    private int yearOfBirth;
    ...

    public Person(String givenName, String familyName, int year, int month, int day) {
       // Initialize the instance variables here.
       ...
    }

    public int getAge() {
       ...
    }

    public String getFullName() {
       ...
    }

    ...
}
A static-method-only approach to PeopleSorter might look like this. The point here is to put major self-contained operations into separate methods. This way, the main program reads like a high-level outline of

public class PeopleSorter {
    public static void main(String[] args) {
        // If there's no command-line argument, print a usage statement 
        // and exit. Otherwise, use args[0] as the input file path.
        if (args.length == 0) {
           // ...
        }

        // Call loadPersonList to build an ArrayList of Person objects 
        // from the input file.
        String filePath = args[0];
        ArrayList<Person> personList = loadPersonList(filePath);

        // Call sortPersonList

        // Call printPersonList
    }

    public static ArrayList<Person> loadPersonList(String personFilePath) {
        // Use File and Scanner to set up a Scanner for the input file

        // Iterate through the file, instantiating new Person objects and adding
        // them to personList.
    }

    public static void sortPersonList(??) {
        // ...
    }

    public static void printPersonList(??) {
        // ...
    }
}
There are more object-oriented approaches to PeopleSorter that don't depend on static methods. We'll discuss these in class after you've completed this assignment.

And of course...
Start early, ask questions, and have fun!