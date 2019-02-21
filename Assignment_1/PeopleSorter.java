import java.util.*;
import java.io.*;


public class PeopleSorter {
    public static void main(String[] args) {
        String fileName = "people.txt";
        // If there's no command-line argument, print a usage statement 
        // and exit. Otherwise, use args[0] as the input file path.
        if (args.length == 0) {
           // ...
        }

        // Call loadPersonList to build an ArrayList of Person objects 
        // from the input file.
        //String filePath = args[0];
        ArrayList<Person> personList = loadPersonList(fileName);       
        sortPersonList(personList);     // Call sortPersonList
        printPersonList(personList);  // Call printPersonList
        

       
    }

    public static ArrayList<Person> loadPersonList(String personFileName) {
        ArrayList<Person> personList = new ArrayList <Person>();
        // Use File and Scanner to set up a Scanner for the input file
        File file = new File(personFileName);
        Scanner scan;
        try{
        scan = new Scanner(file);
        // Iterate through the file, instantiating new Person objects and adding
        // them to personList.
            while(scan.hasNextLine()){
            String personString = scan.nextLine();
            String[] attributeArray = personString.split(",");
            String lastName = attributeArray[0];
            String firstName = attributeArray[1];
            int birthYear = Integer.parseInt(attributeArray[2]);
            int birthMonth = Integer.parseInt(attributeArray[3]);
            int birthDay = Integer.parseInt(attributeArray[4]);
            Person person = new Person(firstName, lastName, birthYear, birthMonth, birthDay);
            personList.add(person);

            }       
        } catch(FileNotFoundException ex) { 
            System.out.println("File Not Found");    
        }
        return personList;
    }

    public static void sortPersonList(ArrayList<Person>personList) {
        for (int i=0; i< personList.size(); i++) {
        Person alphaName = personList.get(i);
        int alphaIndex = i;
            for(int j=i+1; j< personList.size(); j++) {
            Person currName = personList.get(j);
                if(currName.getLastName().compareTo(alphaName.getLastName())<0){
                    alphaName = currName;
                    alphaIndex = j;
                }
            }
            Person temp = personList.get(i);
            personList.set(i, alphaName);
            personList.set(alphaIndex, temp);
        }
    }

    public static void printPersonList(ArrayList<Person>personList) {
        for (int i = 0; i < personList.size(); i++) {
            Person currPerson = personList.get(i);
            System.out.println(currPerson.toString());
        }
    }
}