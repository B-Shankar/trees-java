package trees.SegmentTree;

public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};
        SegmentTree segmentTree = new SegmentTree(arr);
        segmentTree.display();
    }
}
