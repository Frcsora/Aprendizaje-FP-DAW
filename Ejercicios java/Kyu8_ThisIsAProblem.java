//https://www.codewars.com/kata/547c71fdc5b2b38db1000098
public class NameMe {
    public String firstName;
    public String lastName;
    public String fullName;
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public NameMe(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        this.fullName = getFullName();
   }    
 }
