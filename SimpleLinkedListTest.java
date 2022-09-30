// CIS2168 Data Structures, 003, Nina Perone, tul44843@temple.edu
// Assign 3, SimpleLinkedListTest Class
// Description: creates an empty list and adds values to it, calls all methods implemented in SimpleLinkedList class
// with successful and unsuccessful attempts (good and bad values)

package assign3_template;

/**
 * Assign 3 Template.
 * Testing different methods (successful and failed calls)
 * 
 */
public class SimpleLinkedListTest {

    public static void main(String[] args) {
        
        //2.2 Revise SimpleLinkedListTest       
        
        //create and populate list of ints
        SimpleLinkedList numbers = new SimpleLinkedList();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println(numbers);
        
        //print size method
        System.out.println("Size: " + numbers.size());
        System.out.println();
        
        //test indexOf method
        int num = 20;
        int badNum = 300;
        System.out.printf("Index of %d: %d\n", num, numbers.indexOf(num));
        System.out.printf("Index of %d: %d\n", badNum, numbers.indexOf(badNum));
        System.out.println();
        
        //test contains method
        System.out.printf("Contains %d: %b\n", num, numbers.contains(num));
        System.out.printf("Contains %d: %b\n", badNum, numbers.contains(badNum));
        System.out.println();
        
        //test get method
        int index = 2;
        int badIndex = 40;
        System.out.printf("Get int at index %d: %d\n", index, numbers.get(index));
        //invalid index below (throws error)
        //System.out.printf("Get int at index %d: %d\n", badIndex, numbers.get(badIndex));
        System.out.println();
        
        //test add method
        numbers.add(1, 40);
        System.out.println("List after add method: " + numbers);
        //invalid index below (throws error)
        //numbers.add(5, 40);
        System.out.println();
        
        //test removeByValue method
        System.out.printf("Remove %d: %b\n", num, numbers.removeByValue(num));
        System.out.println("List after removeByValue method: " + numbers);
        System.out.printf("Remove %d: %b\n", badNum, numbers.removeByValue(badNum));
        System.out.println("List after removeByValue method: " + numbers);
        System.out.println();
        
      //test removeByIndex method
        System.out.printf("Remove at index %d: %b\n", index, numbers.removeByIndex(index));
        System.out.println("List after removeByIndex method: " + numbers);
        //invalid index below (throws error)
        //System.out.printf("Remove at index %d: %b\n", badIndex, numbers.removeByIndex(badIndex));
        

    }   
    
}
