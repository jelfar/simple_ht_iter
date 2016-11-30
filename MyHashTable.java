import java.util.*;

public class MyHashTable<T> {
	
	private LinkedList[] table;

    private class Iter<T> implements Iterator<T> {
        private int i, j;
        
        public Iter() {
            if(isEmpty()) {
                this.i = 0;
                this.j = 0;
            } else { 
                this.j = 0;
                for(int x = 0; x < table.length; x++) {
                    if(table[x].size() > 0) {
                        this.i = x;
                        break;
                    }
                }
            }
        }

        public boolean hasNext() {
            if(this.i >= table.length)
                return false;
            return table[this.i].get(this.j) != null;
        }

        public T next() {
            if(!hasNext()) {
                throw new java.util.NoSuchElementException();
            }

            T temp = (T)table[i].get(j);
            
            if(j < (table[i].size()-1)) {
                j++;
            } else {
                i += 1;
                while(i < table.length) {
                   if(table[i].size() > 0) {
                       j = 0;
                       return temp;
                   } else { 
                       i++;
                   }
                }
            }
            return temp;
        }

		public void remove()
		{
			System.out.println("Method not supported.");
		}


    }

	public Iter<T> iterator()
	{
        Iter<T> i = new Iter<T>();
        return i;
	}
	
	public MyHashTable(int size){
		
		table = (LinkedList<T>[])(new LinkedList[size]);
		for(int i = 0; i < size; i++){
			table[i] = new LinkedList<T>();
		}
	}

    public void makeEmpty() {
		for(int i = 0; i < table.length; i++){
			table[i] = new LinkedList<T>();
		}
    }

    public int size() {
        int count = 0;
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].size(); j++) {
                count++;
            }
        }
        return count;
    }

	private int hash(T key){
		return ((Math.abs(key.hashCode()))%table.length);
	}
	
	public void insert(T item){
		int h = hash(item);
		table[h].addFirst(item);
	}
	
	public void delete(T item){
		int h = hash(item);
		if(table[h].contains(item))
			table[h].remove(item);
	}
	
	public boolean find(T item){
		int h = hash(item);
		return (table[h].contains(item));
	}
	
	public boolean isEmpty(){
		for(int i = 0; i < table.length; i++){
			if(table[i].size() > 0) return false;
		}
		return true;
	}
	
	public void print(){
		System.out.println();
		for(int i = 0; i < table.length; i++){
			System.out.print(i + ": ");
			for(int j = 0; j < table[i].size(); j++){
				System.out.print(table[i].get(j) + " ");
			}
			System.out.println();
		}
	}

    public void output() {
        if(isEmpty()) {
            System.out.println("Empty");
            return;
        }
        Iterator iter = this.iterator();
        System.out.print("Output: ");
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
    }
}
