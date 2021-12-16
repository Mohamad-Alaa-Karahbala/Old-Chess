import java.util.ArrayList;
import java.util.Random;

public class test {
    public static ArrayList<Integer> arrayList;
    public static void main(String[] args){
    arrayList = new ArrayList();
    Random random = new Random();
        for (int i = 0; i < 100;i++){
            int rv = random.nextInt(100);
            arrayList.add(rv);
            System.out.println(i+"="+ rv);
        }
        getIndex();

    }
    public static void getIndex(){
        int value = 65;
        System.out.println(arrayList.indexOf(value));
        for (int i = 0;i < 100;i++){
            if(arrayList.get(i).equals(i))
                System.out.println("the value " + value +" is stored in the index -> " + i);
        }

    }
}
