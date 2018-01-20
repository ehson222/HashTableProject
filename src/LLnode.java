//node holds the data from student class
//node also holds what it points to next
//node can change what it points next
//node can change data to new data but only if valid data from student class

class LLnode
{
   //our nodes hold student data and pointer to next node
   protected Student data;
   protected LLnode next;
 
   //our 3 constructors, going for modularity
   public LLnode(){
      data = null;
      next = null;
   }
   
   //we could have use this.data = data
   public LLnode(Student d) {
      data = d;
      next = null;
   }
   
   public LLnode(Student d, LLnode n) {
      data = d; 
      next = n;
   }
   
   public Student getData() {
      return data;
   }
   public LLnode getNext() {
      return next;
   }
   public void setData(Student d) {
      data = d;
   }
   public void setNext(LLnode n) {
      next = n;
   } 
}