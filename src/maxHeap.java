import javax.swing.JOptionPane;

//build maxHeap array from students from user input
//could have done find students by name but find by iD more manageable
/*
 * runtime: O(n) (build heap)
 */
public class maxHeap {
   //maxHeap array
   private int[] maxHeap;
   //size of array
   private int size;
   //count of students in heap
   private int count;
   //the first index of list
   private int origin;

   //constructor
   public maxHeap(int maxL) {
      count = maxL;
      maxHeap = new int[count + 1];
      maxHeap[0] = Integer.MAX_VALUE;
      size = 0;
   }
   //T[i/2] = parent.
   public int parent(int index) {
      return index / 2;
   }
   
   public int left(int index) {
      return (2 * index);
   }
   
   public int right(int index) {
      return (2 * index) + 1;
   }
   
   public boolean leaf(int index){   
   //if its an actual index and less than size of array
       if (index >= (size / 2) && index <= size)
           return true;
       return false;
   }
   
   public void addStudent(Student iD)
   {
      int i = Integer.parseInt(iD.getId());
       maxHeap[++size] = i;
       int temp = size;

       while(maxHeap[temp] > maxHeap[parent(temp)])
       {
           swap(temp,parent(temp));
           temp = parent(temp);
       }   
       JOptionPane.showMessageDialog(null, "In maxHeap, you have just added: " + iD);
   }
   //delete specific student from maxHeap
   //instead of just deleting the max
   //this method does not function properly
   public int deleteStudent(String iD)
   {
       int i = Integer.parseInt(iD);
       int y = 0;
       for (int x=0;x < maxHeap.length; ++x) {
          ++y;
          if(maxHeap[x] == i) {
          //   maxHeap[x]
             int deleteStudiD = maxHeap[x];
             maxHeap[x] = maxHeap[--size];
             maxiHeapMaker(y);
             JOptionPane.showMessageDialog(null, "In maxHeap you have just deleted: " + iD);  
             return deleteStudiD;
             }    
         
       }
       //deletes parent node
   //    int deletedID = maxHeap[origin];
     //  maxHeap[origin] = maxHeap[--size]; 
       //maxiHeapMaker(origin);
      // return deletedID;
      return -1;
   }
   
   public void maxiHeap()
   {
       for (int i=(size / 2);i >= 1; --i)
           maxiHeapMaker(i);
   }
   private void maxiHeapMaker(int index)
   {
       if (!leaf(index))
       { 
           if ( maxHeap[index] < maxHeap[left(index)]  || 
                 maxHeap[index] < maxHeap[right(index)])
           {
               if (maxHeap[left(index)] > maxHeap[right(index)]){
                   swap(index, left(index));
                   maxiHeapMaker(left(index));
               }else{
                   swap(index, right(index));
                   maxiHeapMaker(right(index));
               }
           }
       }
   }
   
   private void swap(int leftIndex,int rightIndex)
   {
       int temp;
       temp = maxHeap[leftIndex];
       maxHeap[leftIndex] = maxHeap[rightIndex];
       maxHeap[rightIndex] = temp;
   }
   
   public void findStudent(String iD)
   {    
      int z = Integer.parseInt(iD);
       for (int i = 1;i <=size; ++i) {
        if(maxHeap[i] == z)
           JOptionPane.showMessageDialog(null, "In maxHeap you have just searched: " + iD);
       }
   }
   
   
   public void print()
   {
       for (int i = 1;i <=(size/2); ++i)
       {
           System.out.print("Parent: " + maxHeap[i] + " left: " + maxHeap[2*i]
                 + " right:" + maxHeap[(2*i)+1] + "\n");
       }
   }
}

