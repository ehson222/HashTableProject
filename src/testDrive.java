
public class testDrive {

   public static void main(String[] args) {
      HashTable HT = new HashTable();
      //its a maxHeap, bigger size would take more memory
      maxHeap MH = new maxHeap(30);
      Student msa = new Student("Alice","Wonderland","98765432","English");
      Student mse = new Student("Hagrid","Hogwartz","65498732","Chemistry");
      Student msi = new Student("Hagrid","Hogwartz","65498732","Chemistry");
      Student mso = new Student("Steve","Rogers","06041918","History");
      Student msu = new Student("Des","Troyer","99999999","Math");
      Student msy = new Student("Daigo","Umehara","05191981","Physics");
      Student msz = new Student("Anna","Banana","01010101","Psychology");
      //   if(mse.equals(msi))
      //      System.out.println("id is same");
        //   System.out.println(mse.compareTo(msi));
      HT.addStudent(msa);
      MH.addStudent(msa);
      MH.addStudent(mse);
     // MH.addStudent(msi); this is duplicate student for testing only
      MH.addStudent(mso);
      MH.addStudent(msu);
      MH.addStudent(msy);
      MH.addStudent(msz);
      MH.deleteStudent("98765432");
      MH.print();
      
   }

}
