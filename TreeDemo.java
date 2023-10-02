class Node{
   int value;
   Node left, right;
   
   public Node(int value){
      this.value = value;
      left = null;
      right = null;
   }

}

class BinarySearchTree{

   Node root;
   
   public void insert(int value){
      //tree is empty
      if(root == null){
         root = new Node(value);
         return;
      }else{
         Node current = root;
         Node parent = null;
         
         while(true){
            parent = current;
            
            if(value < current.value){
               current = current.left;
               if(current == null){
                  parent.left = new Node(value);
                  return;
               }
            }else{
               current = current.right;
               if(current == null){
                  parent.right = new Node(value);
                  return;
               }
            }
           
         }//clossing while
      
      }//clossing main if-else 
   }
   
   /*
   recursive insert method
   */
   public Node insert(Node root, int value){
      //base case
      if(root == null){
         root = new Node(value);
         return root;
      }
      
      //recursive step
      if(value < root.value){
         root.left = insert(root.left, value); 
      }else{
         root.right = insert(root.right, value);
      }
      
      return root;
   }
   
   
   
   /*
   pre-order traversal
   */
   public void preOrderTraversal(Node root){
      //implement me
      //base case
      if(root == null){
         return;
      }
      
      System.out.print(root.value+" ");
      //go left recursively
      preOrderTraversal(root.left);
      //go right recursively
      preOrderTraversal(root.right);
   }

   
   
   /*
   in-order traversal
   */
   public void inOrderTraversal(Node root){
      //implement me
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      inOrderTraversal(root.left);
      //process the root
      System.out.print(root.value+" ");
      //go right recursively
      inOrderTraversal(root.right);
   
   }
   
   
   
   /*
   post-order traversal
   */
   public void postOrderTraversal(Node root){
      //implement me
      //base case
      if(root == null){
         return;
      }
      
      //go left recursively
      postOrderTraversal(root.left);
      //go right recursively
      postOrderTraversal(root.right);
      //process the root
      System.out.print(root.value+" ");
   }
   
   
   
   /*
   a method to find the node in the tree
   with a specific value
   */
   public boolean find(Node root, int key){
	  //implement me
      if(root == null){
         return false;
      }
      
      if(root.value == key){
         return true;      
      }else if(key < root.value){
         return find(root.left, key);
      }else{
         return find(root.right, key);
      }         
   }
   
   
   
   /*
   a method to find the node in the tree
   with a smallest key
   */
   public int getMin(Node root){
      //implement me
      if (root == null) {
            throw new IllegalArgumentException("The tree is empty.");
        }

        while (root.left != null) {
            root = root.left;
        }

        return root.value;
   }
  
  
  
   /*
   a method to find the node in the tree
   with a largest key
   */
   public int getMax(Node root){
	  //implement me
     if (root == null) {
            return Integer.MIN_VALUE; // Return a sentinel value for an empty tree
        }

        while (root.right != null) {
            root = root.right;
        }

        return root.value;
   }
   
   
   
   /*
   this method will not compile until getMax
   is implemented
   */
   public Node delete(Node root, int key){
      
      if(root == null){
         return root;
      }else if(key < root.value){
         root.left = delete(root.left, key);
      }else if(key > root.value){
         root.right = delete(root.right, key);
      }else{
         //node has been found
         if(root.left==null && root.right==null){
            //case #1: leaf node
            root = null;
         }else if(root.right == null){
            //case #2 : only left child
            root = root.left;
         }else if(root.left == null){
            //case #2 : only right child
            root = root.right;
         }else{
            //case #3 : 2 children
            root.value = getMax(root.left);
            root.left = delete(root.left, root.value);
         }
      }
      return root;  
   }
   
   }
   




public class TreeDemo{
   public static void main(String[] args){
      BinarySearchTree t1  = new BinarySearchTree();
      t1.insert(24);
      t1.insert(80);
      t1.insert(18);
      t1.insert(9);
      t1.insert(90);
      t1.insert(22);
            
      System.out.print("in-order :   ");
      t1.inOrderTraversal(t1.root);
      System.out.println();
           
      
   }  
}
