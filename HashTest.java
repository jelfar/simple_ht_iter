import java.util.*;

public class HashTest {
	
	public static void main(String[] args){
		MyHashTable<Integer> hash = new MyHashTable<Integer>(10);
		Scanner in = new Scanner(System.in);

        hash.insert(71);
        hash.insert(91);
        hash.insert(21);
        hash.insert(32);
        hash.insert(84);
        hash.insert(24);
        hash.insert(4);
        hash.insert(14);

        Iterator iter = hash.iterator();
	
		System.out.println("Choose one of the following operations:\n"
			+ "- next (enter the letter n)\n"
			+ "- hasNext (enter the letter h)\n"
			+ "- makeEmpty (enter the letter m)\n"
			+ "- size (enter the letter s)\n"
			+ "- output(enter the letter o)\n"
			+ "- Quit (enter the letter q)\n");

		String answer = in.next();
		char answer2 = answer.charAt(0);
		while(answer2 != 'q' || answer2 != 'Q'){
			if(answer2 == 'n' || answer2 == 'N'){
                try {
                    System.out.println(iter.next());			
                } catch (NoSuchElementException e) {
                    System.out.println("Hit the end of table.");
                }
			} else if(answer2 == 'h' || answer2 == 'H'){
                System.out.println(iter.hasNext());
			} else if(answer2 == 'm' || answer2 == 'M'){
                hash.makeEmpty();
			} else if(answer2 == 's' || answer2 == 'S'){
				System.out.println(hash.size());	
			} else if(answer2 == 'o' || answer2 == 'O'){
                hash.output();
			} else if(answer2 == 'q' || answer2 == 'Q'){
				break;
			} else {
				System.out.println("Invalid choice");
			}
			System.out.println("Choose another operation: ");
			answer = in.next();
			answer2 = answer.charAt(0);
		}
	}
}
