import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PetShop {

    ///////////////////////////
    private Pet[] inventory;
    private int count;
    public PetShop(int capacity){
        count = 0;
        inventory = new Pet[capacity];
    }

    ///////////////////////////
    public int writePets(String filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        for (int i = 0; i < count; i++) {
            out.println(inventory[i].toText());
        }
        out.close();
        return count;
    }

    ///////////////////////////
    public boolean add(Pet a){
        if(inventory.length == count)
            return false;
        inventory[count] = a;
        count++;
        return true;
    }

    ///////////////////////////
    public boolean contains(Pet a){
        for (int i = 0; i < count; i++) {
            if(inventory[i].equals(a))
                return true;
        }
        return false;
    }

    ///////////////////////////
    public int indexOf(Pet a){
        for (int i = 0; i < count; i++) {
            if(inventory[i].equals(a))
                return i;
        }
        return -1;
    }

    ///////////////////////////
    public Pet find(String name){
        for (int i = 0; i < count; i++) {
            if(inventory[i].getName() == name)
                return inventory[i];
        }
        return null;
    }

    ///////////////////////////
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++){
            sb.append(inventory[i].toString() + "\n");
        }
        return sb.toString();
    }

    ///////////////////////////
    public int getCount(){
        return count;
    }

}

