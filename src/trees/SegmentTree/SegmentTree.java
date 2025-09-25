package trees.SegmentTree;

public class SegmentTree {
    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }
    }

    private Node root;

    public SegmentTree(int[] arr) {
        //create the segment tree using array
        //Time Complexity: O(n) to create a tree, this is only once. after that O(logN) for query and update
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            //leaf node
            Node leaf = new Node(start, end);
            leaf.data = arr[start];

            return leaf;
        }

        //create new node with index you are at
        Node node = new Node(start, end);

        int mid = (start + end) / 2;

        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        String str = "";

        if (node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        //for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if (node.left != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        //call recursion
        if (node.left != null) {
            display(node.left);
        }

        if (node.right != null) {
            display(node.right);
        }
    }

    //Query
    public int query(int qstart, int qend) {
        return this.query(this.root, qstart, qend);
    }

    private int query(Node node, int qstart, int qend) {
        if (node.startInterval >= qstart && node.endInterval <= qend) {
            //node is completely within the query range
            //total overlap
            return node.data;
        } else if (node.endInterval < qstart || node.startInterval > qend) {
            //completely outside the query range
            //no overlap
            return 0;
        } else {
            //partial overlap

            int leftData = query(node.left, qstart, qend);
            int rightData = query(node.right, qstart, qend);

            return leftData + rightData;
        }
    }

    //Update
    public void update(int index, int value) {
        update(this.root, index, value);
    }

    private int update(Node node, int index, int value) {
        if (index >= node.startInterval && index <= node.endInterval) {
            if (index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                //internal node
               int leftData = update(node.left, index, value);
               int rightData = update(node.right, index, value);

                node.data = leftData + rightData;
                return node.data;
            }
        }

        return node.data;
    }
}
