
public class SLL {
		
		private Node head1;
		private Node head2;
		
		public SLL() {
			head1 = null;
			head2 = null;
		}					
		public void addsort(Integer dataToAdd,Integer data2) {       
	        
	        if(head1 == null && head2 == null) {    
	        	Node newNode = new Node(dataToAdd); 
	        	Node newNode2 = new Node(data2); 
	            head1 = newNode; 
	            head2=newNode2;
	               
	        } 
	        else if (dataToAdd > (int)head1.getData()) {
	        	Node newnode = new Node(dataToAdd);
	        	Node newnode2 = new Node(data2);
	        	newnode.setLink(head1);
	        	newnode2.setLink(head2);
	        	head1=newnode;
	        	head2=newnode2;
	        	}
	        else if (dataToAdd == (int)head1.getData()) {
	        	Node newnode = new Node(dataToAdd);
	        	Node newnode2 = new Node(data2+1);
	        	newnode.setLink(head1);
	        	newnode2.setLink(head2);
	        	head1=newnode;
	        	head2=newnode2;
	        	}
	        else {
	        	 Node temp1=head1;
	 	        Node previous1=null;
	 	       Node temp2=head2;
		        Node previous2=null;
	 	        
	 	        while(temp1!=null  && temp2 != null && (Integer)dataToAdd < (Integer)temp1.getData()) 
	 	        {
	 	        	previous1=temp1;
	 	        	temp1=temp1.getLink();
	 	        	previous2=temp2;
	 	        	temp2=temp2.getLink();
	 	        }
	 	        if(temp1==null  && temp2 == null) {
	 	        	Node newnode =new Node(dataToAdd);
	 	        	Node newnode2 =new Node(data2);
	 	        	previous1.setLink(newnode);
	 	        	previous2.setLink(newnode2);
	 	        	
	 	        }
	 	        else {
	 	        	Node newnode =new Node(dataToAdd);
	 	        	Node newnode2 =new Node(data2);
	 	        	 if(previous1!=null) {
		        	 newnode.setLink(temp1);
		        	 previous1.setLink(newnode);
		        	 newnode2.setLink(temp2);
		        	 previous2.setLink(newnode2);
	        	 	}
	        	 	else {
	        		 newnode.setLink(head1);
	                 	head1 = newnode;
	                 newnode2.setLink(head2);
	                 	head2 = newnode2;
	        	 	}
	 	        }
	        }
	        
	     
	    }    
	        
		//hadi bunu deneyelim
		public void addHash(String txt,Integer value) {
			Node newNode = new Node(txt);//txt1 aldýk
			Node newNode2 = new Node(value);
	        if (head1 == null && head2==null) {
	            head1 = newNode;
	            head2=newNode2;
	        }
	        else{          
	            Node temp = head1;
	            while (temp.getLink() != null) {
	                temp = temp.getLink();
	            }
	              
	            temp.setLink(newNode);
	        }
	   
		}   
		
		public void addFront(Object dataToAdd) {
			Node newNode = new Node(dataToAdd);
			newNode.setLink(head1);
			head1=newNode;
			
		}
		
		public void addIndex(Object dataToAdd) {
			
			Node previous = null;
			Node newNode = new Node(dataToAdd);
			if (head1 == null) {
				newNode.setLink(head1);
	            head1 = newNode;
	        }
			else {
				Node temp = head1;
				while (temp != null&&(int)dataToAdd > (int)temp.getData()) {
					 previous = temp;
		             temp = temp.getLink();
		         }
		           
		         if(temp == null) {	 
		        	 temp = head1;
		             while (temp.getLink() != null) {
		                 temp = temp.getLink();
		             }
		               
		             temp.setLink(newNode);
		         }
		         
		         else {
		        	 if(previous!=null) {
			        	 newNode.setLink(temp);
			        	 previous.setLink(newNode);
		        	 }
		        	 else {
		        		 newNode.setLink(head1);
		                 head1 = newNode;
		        	 }
		         }
	        
			}
		}
		
		
		public void delete(Object dataToDelete) {
			if(head1 == null) {
				System.out.println("Linked list is empty!!");
			}
			else {
				while ((int)dataToDelete == (int)head1.getData()) {
					head1=head1.getLink();
				}
				Node temp = head1;
				Node previous = null;
				while (temp!=null) {
					if ((int)dataToDelete == (int)temp.getData()) {
						
			        	previous.setLink(temp.getLink());
			        	temp=previous;
					}
					previous = temp;
					temp=temp.getLink();
				}
			}
		}
		public void deletelast(Object dataToDelete) {
			if(head1 == null) {
				System.out.println("Linked list is empty!!");
			}
			else {
				while ((int)dataToDelete == (int)head1.getData()) {
					head1=head1.getLink();
				}
				Node temp = head1;
				Node previous = null;
				while (temp!=null) {
					if ((int)dataToDelete == (int)temp.getData()) {
						
			        	previous.setLink(temp.getLink());
			        	temp=null;
			        	break;
					}
					previous = temp;
					temp=temp.getLink();
				}
			}
		}
		public boolean search(Object item) {
			boolean flag = false;
			  
			if (head1 == null) {
				System.out.println("linked list is empty");
			}
			else {
				Node temp = head1;
			while (temp != null) {
				if (item == temp.getData()) {
					flag = true;
					
				}			
				temp = temp.getLink();
				}
			}
			
			return flag;
		}
		
		
		public void display() {		
			Node temp = head1;	
			Node temp2 = head2;	
			while(temp != null && temp2 != null) {
				System.out.println(temp2.getData()+ "  " + temp.getData());
				temp = temp.getLink();
				temp2 = temp2.getLink();
			}			
		}
		
		
		public int size() {
			int count = 0;
			
			if(head1 == null) {
				System.out.println("Linked list is empty!!");
			}
			else {
				Node temp = head1;
				while(temp != null) {
					count++;
					temp = temp.getLink();
				}			
			}
			return count;				
			
		}
		
		public int counter(int item) {
			int k=0;
			if(head1 == null) {
				
			}
			else {
			Node temp = head1;
			while(temp != null) {
				if((int)temp.getData()==item) {
					k++;
				}
				temp = temp.getLink();
			}
			}
			
			
			return k;
		}

		
		

		
		
	
}
