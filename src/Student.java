import javax.swing.JOptionPane;

public class Student {
   //lets just go by first name only
   //or we can fit first and last name in one variable
   private String firstName;
   private String lastName;
   //tried int id, no bueno when comparing its length and can't use .equals
   //there is a way to compare ints and it actually requires less code
   private String id;
   private String major;
   
   public Student(String fn, String ln, String i, String m) {
   //could use .equals(null) but null is reference to nothing
   //where as .equals("") is reference to a empty String
      firstName = fn;
      lastName = ln;
      id = i;
      major = m;
   }
   
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }

   public void setFirstName(String n) {
      if(n.equalsIgnoreCase("")  || n.length() > 50) 
         JOptionPane.showMessageDialog(null, "Invalid name entry: " + n);  
      for (int i=0;i<n.length();i++)
         if (!Character.isLetter(n.charAt(i))) { //|| !n.equals(" "))
            JOptionPane.showMessageDialog(null, "Invalid name entry: " + n);
            System.exit(0);}
      firstName = n;
   }

   public void setLastName(String n) {
      if(n.equalsIgnoreCase("")  || n.length() > 50) 
         System.out.println("Exception for name value");   
      for (int i=0;i<n.length();i++)
         if (!Character.isLetter(n.charAt(i))){ //|| !n.equals(" "))
            JOptionPane.showMessageDialog(null, "Invalid name entry: " + n);
            System.exit(0);}
      lastName = n;
   }

   public String getId() {
      return id;
   }


   public void setId(String d) {
      if(d.equalsIgnoreCase("") || d.length()!=8)
         System.out.println("Exception for id length or value");
      for (int i=0;i<d.length();i++)
         if (!Character.isDigit(d.charAt(i))){ //|| !n.equals(" "))
            JOptionPane.showMessageDialog(null, "Invalid iD entry: " + d);
            System.exit(0);}
      id = d;
   }


   public String getMajor() {
      return major;
   }


   public void setMajor(String m) {
      if(m.equalsIgnoreCase("")  || m.length() > 50) 
         System.out.println("Exception for major value");
      for (int i=0;i<m.length();i++)
         if (!Character.isLetter(m.charAt(i))){ //|| !n.equals(" "))
            JOptionPane.showMessageDialog(null, "Invalid major entry: " + m);
            System.exit(0);}
      major = m;
   }

   //Lexicographically compares strings, tried to compare with student id...
   //name is more significant than major,
   //first check if name is same, then lower significant field major
   public String compareTo(Student n) {
      
      int lexo;
      String msg;
      lexo = lastName.compareToIgnoreCase(n.lastName);
      
      // if names dont match then -1, 
      //actually lexo is > 1 or < 1 if names dont match.
      if(lexo != 0) {
         msg = "last names don't match.";
         return msg;
      }
         lexo = firstName.compareToIgnoreCase(n.firstName);
      if(lexo != 0) {
         msg = "first names don't match.";
         return msg;
   }   //names matched, now lets compare major
         lexo = major.compareToIgnoreCase(n.major);
      //majors don't match
      if(lexo != 0) {
         msg = "majors don't match.";
         return msg;
   }
      msg = "found matching full name of student and major.";
      return msg;
   }
   
   //we have to override, default equals method for hash
   //yes we could also return false, but this looks nicer
   //and it automatically returns false if not match
   public boolean equals(Student code) {
      return (id.equals(code.id));
   }

   //bootcamp
   public String toString()
   {
      String s = "full name: " + firstName + " " + lastName + " iD: " + id + " major: " + major;
      return s;
   }
}
