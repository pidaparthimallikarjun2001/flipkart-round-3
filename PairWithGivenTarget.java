import java.lang.reflect.Array;
import java.util.*;

class BinarySearchTree {
    class Node  
    { 
        int key; 
        Node left, right; 
  
        public Node(int item) 
        { 
            key = item; 
            left = right = null; 
        } 
    } 
    Node root; 
  
    BinarySearchTree()  
    {  
         root = null;  
    } 
    Node insertRec(Node root, int key) 
    { 

        if (root == null)  
        { 
            root = new Node(key); 
            return root; 
        } 
  
        if (key < root.key) 
            root.left = insertRec(root.left, key); 
        else if (key > root.key) 
            root.right = insertRec(root.right, key); 
  
        return root; 
    } 
  
    void insert(int key)  
    {  
         root = insertRec(root, key);  
    } 



    void inorderRec(Node root, ArrayList<Integer> l) 
    { 
        if (root != null) { 
            inorderRec(root.left, l); 
            l.add(root.key); 
            inorderRec(root.right, l); 
        } 
    } 

    void inorder(ArrayList<Integer> l)  
    {  
         inorderRec(root, l);  
    } 

}

public class PairWithGivenTarget {

    public static boolean doesPairExist(ArrayList<Integer> l, int target) {
        int start = 0, end = l.size() - 1;
        while(start < end) {
            if(l.get(start) + l.get(end) == target) {
                return true;
            } 
            else if(l.get(start) + l.get(end) < target) {
                start += 1;
            }
            else {
                end -= 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree obj = new BinarySearchTree();
        obj.insert(50); 
        obj.insert(30); 
        obj.insert(20); 
        obj.insert(40); 
        obj.insert(70); 
        obj.insert(60); 
        obj.insert(80);
        ArrayList<Integer> l = new ArrayList<>();
        obj.inorder(l);
        System.out.println(l);
        int target = sc.nextInt();
        System.out.println(doesPairExist(l, target));
    }
}