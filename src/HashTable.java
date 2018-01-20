import javax.swing.JOptionPane;
   /*
    * a basic array class with linked list at each index
    * it sounds intimidating at first, then easy once you
    * draw diagram.
    * 
    */

   public class HashTable
   {
       private LLhash[] table;
       private final int tableSize = 3000;
    
       //constructor
       //initialize the hash array of linked lists
       public HashTable()
       {
          table = new LLhash[tableSize];
          for (int i = 0; i < tableSize; ++i)
             table[i] = new LLhash();
       }
       /*
       public void printHash() {
          for(int i = 0; i < tableSize; ++i)
           //  if(table[i].peekData())
             System.out.println(table[i].peekData());
       }*/
       
       //this code is similar to wikipedia on hashMaps
       public void addStudent(Student theStudent) {
          //parse id to int from string
       //   int i = theStudent
          int i = Integer.parseInt(theStudent.getId()) % 3000;
          //at the index, int i (hash) % sizeOfArray, add to end of LL
          table[i % 3000].enQ(theStudent);
          JOptionPane.showMessageDialog(null, "In HashTable you have just added: " + theStudent);
      }
      
      public void removeID(String studentID) {
         int i = Integer.parseInt(studentID) % 3000;
         table[i % 3000].removeID(studentID);
         JOptionPane.showMessageDialog(null,"In HashTable, removed student iD: " + studentID);
         //this could return name of student that we deleted from id  Student.setID();
         
      }
       
      public Student find(String studentID) {
         int i = Integer.parseInt(studentID) % 3000;
         
         LLnode temp = table[i % 3000].peekFirst();
         
         while(temp != null) {
            if(temp.getData().getId().equalsIgnoreCase(studentID)) {
               return temp.getData();}
            temp = temp.getNext();
         }
         //we have to return something if not found
         return null;
      }
        
   }