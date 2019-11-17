import java.math.BigInteger;

public class Hashtable{
    private String[] key;
    private String[] table;
    private int size, maxSize, numEnteries;
    private final double LOAD = 0.5;
    private double capacity;

    public Hashtable(){
        this.size = 0;
        table = new String[11];
        key = new String[11];
        this.capacity = LOAD * 11;
        this.maxSize = 11;
    }

    public int hashing(String n){
        return (Integer.parseInt(n)) % table.length;
    }

    public int collision(String n){
        int temp = hashing(n);
        int calc = 1;
        numEnteries = 0;
        int traverse = 0;

        while(table[temp] != null){
            traverse++;
            temp = (int)((temp + (calc * calc)) % maxSize);
            calc++;
            numEnteries++;
        }

        if(traverse >= 11){
            System.out.println("Insert failed");
            return -1;
        }

        return temp;
    }

    public void resizeTable(){
        String[] tempTable = table;
        String[] tempKeys = key;



        if(table.length >= capacity){
            BigInteger b = new BigInteger(String.valueOf(tempTable.length * 2));
            int prime = b.nextProbablePrime();

            table = new String[prime];
            key = new String[prime];

            //copy data from old array to new array
            for(int i = 0; i < tempKeys.length; i++){
                if(tempKeys[i] != null){
                    key[i] = tempKeys[i];
                }
            }

            for(int i = 0; i < tempTable.length; i++){
                if(tempTable[i] != null){
                    table[i] = tempTable[i];
                }
            }
        }
    }

    public void insert(String n){
        int temp = collision(n);
        table[temp] = n;
        key[temp] = Integer.toString(temp);
        size++;

        if(size >= capacity)
            resizeTable();
    }

        public void print(){
            System.out.println("Key\tValue");

            for(int i = 0; i < table.length; i++){
                if(key[i] != null){
                    System.out.println(key[i] + "\t" + table[i]);
                }
            }
        }

}
//collision handling -> two keys can have the same value
//if there is a collision do (key+j^2) mod size and put that in the resulting index
//increment j everytime there is a collision