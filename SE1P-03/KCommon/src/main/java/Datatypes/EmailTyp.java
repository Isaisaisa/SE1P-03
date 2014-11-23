package Datatypes;


import java.util.regex.Pattern;


public class EmailTyp {

    //Attribut
    private String email;

   //getter and setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Constructor
    private EmailTyp(String email){
        this.email = email;
    }

    public static EmailTyp valueOf(String email){
        //Regex for emailadresses http://www.regular-expressions.info/email.html
        boolean stringMatch = Pattern.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
               + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", email);

        if (stringMatch){
            return new EmailTyp(email);
        }

        throw new IllegalArgumentException("the emailadress  is illegal");
    }

    // basic functions
    public int compareTo(EmailTyp other) {
        return this.toString().compareTo(other.toString());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) { return true; }
        if (!(other instanceof EmailTyp)) { return false; }
        return this.compareTo((EmailTyp) other) == 0;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    //Fuction to test if regex is working probaly
   public static boolean test(String email){
        boolean stringMatch = Pattern.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
                + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", email);

        if (stringMatch){
           return true;
        }
        return false;
    }
}
