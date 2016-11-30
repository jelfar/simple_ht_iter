public class HTSCDemo
{
    public static void main(String[] args)
    {
        MyHashTable<Integer> ht = new MyHashTable<Integer>(13);
        int[] arr = {5, 10, 2, 12, 18, 25, 45, 80, -6, 0, 74, 103, 444, 901};
        System.out.println("Hash table empty? " + ht.isEmpty());
        
        for (int i = 0; i < arr.length; i++)
        {
            ht.insert(arr[i]);
        }
        
        System.out.println("Has table empty?? " + ht.isEmpty());
        
        ht.print();
        ht.output();
        System.out.println("Hash table size?" + ht.size());
        System.out.println("Hash table find successful?" + ht.find(12));
        ht.delete(12);
        ht.delete(0);
        ht.delete(444);
        System.out.println("Hash table find successful?" + ht.find(12));
        System.out.println("Hash table find successful?" + ht.find(0));
        System.out.println("Hash table find successful?" + ht.find(103));
        ht.print();
        ht.output();
        System.out.println("Hash table size?" + ht.size());
        ht.makeEmpty();
        System.out.println("Hash table size?" + ht.size());
        System.out.println("Hash table empty?" + ht.isEmpty());
        System.out.println("Hash table find successful?" + ht.find(12));
        ht.print();
    }
}
