
public class LLhash {
   private LLnode head, tail;
   private int size;
   
   public LLhash() {
      head = tail = null;
      size = 0;
   }
   
   //return the first student at index and delete its reference
   //similar to peek from stack class
   public LLnode peekFirst() 
   {
      //check if linked list is empty
  //    if(head == null)
    //     throw new IllegalArgumentException("no students in this index");
      //return the data value we are removing
      //cant we just return the head instead of making dummy node at all
      LLnode current = head;
      return current;
   }
   /*
   public LLnode peekData()
   {
         LLnode current, temp;
         current = head;
      while(current.getData() != null)
      {
         temp = current; 
         current = current.getNext();
         return temp;
      }
      return current;
      
   }*/
   
   public LLnode peekLast()
   {
      //check if linked list is empty
      if(tail == null)
         throw new IllegalArgumentException("no students in this index");
      else {
         LLnode current, previous;
         current = head;
      while(current.getData() != null && current.getNext() != null)
      {
         previous = current; 
         current = current.getNext();
      }
      return current;
      }
   }

   //enqueueQ from queue class
   public void enQ(Student newStud)
   {
      //make a new node, it is not part of linked list yet
      LLnode newNode = new LLnode(newStud);
      ++size;
      //if empty linked list, make this new node the first node
      if(tail == null)
         //first and last point to newNode
         head = tail = newNode;
      //if linked list exists
      else 
      {
         //point to our newNode, which is at the end of the list
         tail.setNext(newNode);
       //  tail.setData(newStud);
         tail = newNode;
      }
   }
   
   
   public void removeID(String iD)
   {
       if(head == null)
          throw new IllegalArgumentException("this is an empty index"); 
       else
       {
           LLnode current = head;
           while (current.getData() != null && current.getNext() != null) { 
              if (current.getNext().getData().getId().equalsIgnoreCase(iD)) 
              current.setNext(current.getNext().getNext());
           else current = current.getNext();
           } if (head != null && head.getData().getId().equalsIgnoreCase(iD))
              head = head.getNext();
       else {
           System.out.print("could not find ID to remove");
       }}
   }
}
