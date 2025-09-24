package trees.AVL;

public class Main {
    public static void main(String[] args) {
        AVL avl = new AVL();
        for(int i = 0; i < 1000; i++) {
            avl.insert(i);
        }

        //Time Complexity: O(log n)
        //Space Complexity: O(1)

        //For this, log(1000) = ~10
        System.out.println("AVL Tree Height: " + avl.height());
    }
}
