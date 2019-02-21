public class Person {
    private String givenName;
    private String familyName;
    private int yearOfBirth;
    private int monthofBirth;
    private int dayofBirth;

    

    public Person(String givenName, String familyName, int year, int month, int day) {
       this.givenName = givenName;
       this.familyName = familyName;
       this.yearOfBirth = year;
       this.monthofBirth = month;
       this.dayofBirth = day;

           }

    public String getFullName() {
        if (familyName != ""){
            String fullName = givenName + " "  + familyName;
            System.out.print(fullName);
            return fullName;
        } 
        else {
            String fullName = givenName;
            return fullName;
        
        }
    }
    
     public String getLastName() {
        String LastName = familyName;
            return LastName;
        
        }
    
    public String getAge() {
        int age = 2018 - yearOfBirth;
        String ageStr = Integer.toString(age);
        return ageStr;
    }
    
    public String toString(){
        return givenName + " " + familyName + ", Age: " + getAge();
    }
}