// CIS2168 Data Structures, 003, Nina Perone, tul44843@temple.edu
// Assign 3, SimpleLinkedList Class
// Description: contains all SimpleLinkedList Class methods for getting size, index, toString, whether 
// or not the list contains a value, and adding and removing items by index or value. etc.

package assign3_template;

import linkedlist_generic_demo.SingleLinkedList.Node;

public class SimpleLinkedList {

    
    //2.1.1 What Code to Add
    
    //Remove the first occurrence of the specified item from this linked list. 
    // If success, return true. Otherwise, return false.
    public boolean removeByValue(int item) {
    	
    	int index = indexOf(item);
    	Node current = head;
    	Node temp = current.next;
    	if(index == -1) {
    		return false;
    	}
    	if(index == 0 ) {
    		if(head != null ) {
    			head = head.next;
    		}
    		if(temp != null) {
    			size--;
    			return true;
    		}
    		return false;
    	}
        
    	
    	for (int i = 0; i < index-1; i++) {
            current = current.next;
            System.out.println(i);
        }
        temp = current.next;
        

        if(temp != null) {
            current.next = temp.next;
            size--;
            return true;
        }
        return false;
        
    }

    //add item to be at [index];
    // if index is [0, size-1], insert item between [index-1] and [index]
    // if index is size, append item to the end of this linked list.
    public void add(int index, int item) {  
    	
    	if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
        	head = new Node(item, head);
            size++;
        } else {
            Node current = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            Node predecessorNodeRef = current;
            predecessorNodeRef.next = new Node(item, predecessorNodeRef.next);
            size++;
        }
        
        
    }

    //Get the integer item at the specified position and return the integer value. 
    //If the index is not valid, throw an exception or print an error message 
    //  and return Integer.MIN_VALUE.
    public int get(int index) {

    	int count = 0;
    	Node current = head;
    	
    	while(current != null) {
    		if(count == index) {
    			return current.data;
    		}
    		current = current.next;
    		count++;
    	}
        
        throw new IndexOutOfBoundsException("Index is out of bounds");

    }

    //Search this linked list for the first occurrence of the specified integer: item. 
    //If the item is found, return its index. Otherwise return -1.
    public int indexOf(int item) {
    	
    	int index = -1;
    	Node current = head;
    	for(int i = 0; i < size(); i++) {
    		if(current.data == item) {
    			index = i;
    			break;
    		}
    		current = current.next;
    	}
        
        return index;
    }

    //Find out if the specified integer: item is in this linked list. 
    // Returns true if yes, false otherwise.
    public boolean contains(int item) {
    	
    	boolean contain = false;
    	Node current = head;
    	
    	while(current != null) {
    		if(current.data == item) {
    			contain = true;
    			break;
    		}
    		
    		current = current.next;
    	}

        return contain;
    }

    //return how many integers are in this linked list
    public int size() {
        
    	int count = 0;
        Node current = head;
        while(current != null) {
        	count++;
        	current = current.next;
        }
        
        return count;
    }

    //-----Bonus ---------------//
    //Remove the item at the specified position from this linked list and 
    //  return the removed item.
    //If the index is not valid, throw an exception or print an error message 
    //   and return Integer.MIN_VALUE.
    public int removeByIndex(int index) {

    	Node current = head;
    	Node temp = current.next;
    	if(index < 0 || index > size-1) {
    		throw new IndexOutOfBoundsException(index);
    	}
    	if(index == 0 ) {
    		if(head != null ) {
    			head = head.next;
    		}
    		if(temp != null) {
    			size--;
    			return current.data;
    		}
    	}
        
    	
    	for (int i = 0; i < index-1; i++) {
            current = current.next;
            System.out.println(i);
        }
        temp = current.next;
        

        if(temp != null) {
            current.next = temp.next;
            size--;
            return temp.data;
        }
        throw new IndexOutOfBoundsException(index);

    }

    //-------End of Assign 3 --------/ 
    
    //Following code were covered in Lec#6. 
    //Don't change them.
    //Nested class Node, enclosing class: SimpleLinkedList
    private static class Node {

        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            next = null;
        }
        
        //constructor used to create a Node that has a following neighbor
        private Node(int dataNew, Node nextNew) {
            data = dataNew;
            next = nextNew;
        }

        @Override
        public String toString() {
            return data + "";  //"10"
        }        
    }

    //the reference to the first Node in this linked list.
    private Node head;
    //the size of this linked list
    private int size;

    //create an empty linked list
    public SimpleLinkedList() {
        head = null;
        size = 0;
    }

    //append newItem
    public boolean add(int newItem) {
        Node temp = new Node(newItem);
        if (head == null) { //empty list
            head = temp;
        } else { //non-empty list
            //locate last node
            Node current = head;    //start with the first node
            while (current.next != null) {  //check if current node is not the last node
                current = current.next;     //move on to the next node on the list
            }
            current.next = temp;    //append the new node immediately following the current node
        }
        size++;
        return true;
    }

    //return a string that contains all integers (in the original sequence) in the linked list.
    @Override
    public String toString() {
        String result = "";     //result string
        Node current = head;        //start with first Node
        while (current != null) {   //check if there is still nodes remaining
            result += current.data; //add the integer in current Node to the result string
            result += "-->";
            current = current.next; //move on to the next Node
        }
        return result;
    }
}
