import javax.swing.JOptionPane;

public class BonusProjectMain {
/*
 * StudentListing class which contained 2 structures had to be removed,
 * was getting error "No enclosing instance of type is accessible" when
 * trying to access inner HashTable class.  StudentListing was removed.
 */
   public static void main(String[] args) {
//    Student msr = new Student("Alice","Wonderland","98765432","English");
      // Student msg = new Student("Hagrid","Hogwartz","65498732","Chemistry");
  //     if(msr.equals(msg))
        //  System.out.println("id is same");
      
      //    System.out.println(msr.compareTo(msg));

          HashTable HT = new HashTable();
          //its a maxHeap, bigger size would take more memory
          maxHeap MH = new maxHeap(30);
          
          String userInput,firstName,lastName,iD, major;

          userInput = firstName = lastName = iD = major = " ";
          Student dummy = new Student(firstName,lastName,iD,major);
          while(true) {
          userInput = JOptionPane.showInputDialog(null,"Do you wish to add, remove, or search for Student: (quit = end program)");
          if(userInput.equalsIgnoreCase("quit"))
          System.exit(0);
          while(!userInput.equalsIgnoreCase("add") && !userInput.equalsIgnoreCase("remove") 
                && !userInput.equalsIgnoreCase("search") && !userInput.equalsIgnoreCase("quit")) {
             userInput = JOptionPane.showInputDialog(null, "Please enter a valid response. add, remove, search or quit to exit program");
             if(userInput.equalsIgnoreCase("quit"))
             System.exit(0);
          }
          
          if(userInput.equalsIgnoreCase("add")) {
             firstName = JOptionPane.showInputDialog(null, "Enter students first name: ");
             dummy.setFirstName(firstName);
             
             lastName = JOptionPane.showInputDialog(null, "Enter students last name: ");
             dummy.setLastName(lastName);
             
             iD = JOptionPane.showInputDialog(null,"Student iD (size 8): ");
             dummy.setId(iD);
             
             major = JOptionPane.showInputDialog(null, "Enter major of student: ");
             dummy.setMajor(major);
             
             userInput = JOptionPane.showInputDialog(null,"add student in HashTable or maxHeap? ");
             if(userInput.equalsIgnoreCase("HashTable")) {
              
                HT.addStudent(dummy);
                Student newStudent =(Student) HT.find(iD);

             }
             else if(userInput.equalsIgnoreCase("maxHeap"))
                MH.addStudent(dummy);
             
          }
          if(userInput.equalsIgnoreCase("remove")) {
             iD = JOptionPane.showInputDialog(null,"enter valid Student iD to remove (size 8): ");     
             userInput = JOptionPane.showInputDialog(null,"remove student in HashTable or maxHeap? ");
             if(userInput.equalsIgnoreCase("HashTable"))
                HT.removeID(iD);
             //below line creates duplicate iDs, its wrong atm
             else if(userInput.equalsIgnoreCase("maxHeap"))
                MH.deleteStudent(iD);  
          }
          if(userInput.equalsIgnoreCase("search"))
         {
             iD = JOptionPane.showInputDialog(null,"enter valid Student iD to search (size 8): ");
             userInput = JOptionPane.showInputDialog(null,"search student in HashTable or maxHeap? ");
             if(userInput.equalsIgnoreCase("HashTable")) {
                HT.find(iD).toString();        
             JOptionPane.showMessageDialog(null,"In HashTable, found student iD: " + iD);}
             else if(userInput.equalsIgnoreCase("maxHeap"))
                MH.findStudent(iD);
          }
        }
   }

}
