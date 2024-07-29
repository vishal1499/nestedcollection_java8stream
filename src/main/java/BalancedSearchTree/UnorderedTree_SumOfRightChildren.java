package BalancedSearchTree;

import java.util.Scanner;

class Node {
    int data;
    Node left, right;
    Node(int value){
        data = value;
    }


}
class BT{

   public Node root ;
    void addNode(int parent, int child, char direction){
        if(root == null){
            root =  new Node(parent);
            addChildNode(root, child, direction);
        }else{
            Node n = search(parent, root);
            addChildNode(n, child, direction);
        }
    }

    private void addChildNode(Node node, int child, char direction) {
        if(direction == 'L'){
            node.left = new Node(child);
        }else if(direction == 'R'){
            node.right = new Node(child);
        }
    }

    public int calculateSum(Node temp){
        //write your code here
        int sum = 0;
        while(temp != null){
            sum += temp.data;
            temp=temp.right;
        }
        return sum;
    }

    public Node search(int n, Node node){

        if(node == null || node.data == n){
            return node;
        }

        Node rightNode = search(n, node.right);
        if(rightNode != null){
            return  rightNode;
        }

        return search(n, node.left);

    }

    public void printTree(Node root){
        //write your code here

        if (root != null) {
            System.out.println("   "+root.data);
            System.out.println("| :: |");
            System.out.print(root.left == null? "-": root.left.data);
            System.out.print(" :: ");
            System.out.print(root.right == null? "-": root.right.data);
            System.out.println("\n");
        }

        if(root.left != null){
            printTree(root.left);
        }

        if(root.right != null){
            printTree(root.right);
        }


    }
}

public class UnorderedTree_SumOfRightChildren {
    public static void main(String[] args) {
        BT bt = new BT();
        Scanner in = new Scanner(System.in);
        int edges, parent, child, pathSum, n;
        char direction;
        edges = in.nextInt();
        System.out.println("\n\nedges: "+ edges);

        for(int i=0; i<edges;i++){
            parent = in.nextInt();
            child = in.nextInt();
            direction = in.next().charAt(0);
            System.out.println("=====================");
            System.out.println("parent: "+ parent);
            System.out.println("child: "+ child);
            System.out.println("direction: "+ direction);
            System.out.println("=====================");
            bt.addNode(parent, child, direction);
        }
        bt.printTree(bt.root);
        n = in.nextInt();
        System.out.println("n: "+ n);

        Node nn = bt.search(n, bt.root);
        System.out.println("Sum of all right nodes: " + bt.calculateSum(nn));
    }

}
