import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Hashtable table = new Hashtable();
        String key = scan.next();
        if(Integer.parseInt(key) < 100 || Integer.parseInt(key) > 999){
            System.out.println("key has to be between 100-999 inclusive");
        }
        else{
            table.insert(key);
        }

        table.insert("200");
        table.insert("350");
        table.insert("999");
        table.insert("100");
        table.insert("283");

        table.print();

        scan.close();
    }
}