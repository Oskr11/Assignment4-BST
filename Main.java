
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();

        bst.put(9,54);//1

        bst.put(2,65);//2

        bst.put(7,387);//3

        bst.put(88,944);//4

        bst.put(45,616);// 5

        for(Integer i : bst) { System.out.println(i);}
    }
}
