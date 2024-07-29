package BalancedSearchTree;

public class RedBlackTreePOC {

    public static class Node{
        Integer data;
        Node right;
        Node left;

        public Node(int data){

        }
    }

    public Node root;

    public RedBlackTreePOC(){
        root = null;
    }
    public void insert(int data){
        if (root == null) {
            root = new Node(data);
            return;
        }else{
            //Node parent = null;
            Node current = root;
            while(true){
              //  parent = current;
                if(current.data > data){
                    if(current.left == null){
                        current.left = new Node(data);
                        return;
                    }else{
                     current = current.left;
                    }
                }else{
                    if(current.right == null){
                        current.right = new Node(data);
                        return;
                    }else{
                        current = current.right;
                    }
                }
            }
        }
    }

    public Node minmaxNode(Node root, String valType){
        if (root != null) {
            while(true){
                if(getNode(root,valType) == null){
                    return root;
                }else{
                    root = getNode(root,valType);
                }
            }

        }
        return null;
    }

    Node getNode(Node node, String valType){
        if("min".equals(valType)){
            return node.left;
        }else{
            return node.right;
        }
    }
    public Node maxNode(Node root){
        return null;
    }
    public Node deleteNode(Node startNode, int value){
        if(startNode == null){
            return null;
        }

        if(startNode.data > value)
            //value is LT startNode's data then search left tree
            deleteNode(startNode.left, value);
        else if(startNode.data < value)
            //value is GT startNode's data then search right tree
            deleteNode(startNode.right, value);
        else{
            //value is equal to startNode's data

            //if node to be deleted has no child
            if(startNode.left == null & startNode.right == null){
                startNode = null;
            }else if(startNode.left != null){
                startNode = startNode.left;
            }else if(startNode.right != null){
                startNode = startNode.right;
            }else{
                Node temp = minmaxNode(startNode.right, "min");
                startNode.data = temp.data;
                deleteNode(startNode.right, temp.data);
            }

        }
        return startNode;
    }

    public void inOrderTraversal(Node node){
            if(node == null){
                System.out.println("Tree is empty");
                return;
            }
    }

    public static void main(String[] args) {

    }
}
