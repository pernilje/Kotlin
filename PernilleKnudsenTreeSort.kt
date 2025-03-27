// Class with a key value and left and right child nodes.
class Node {
    var key: Int = 0
    var left: Node? = null
    var right: Node? = null

    constructor(key: Int) { 
        this.key = key
        left = null
        right = null
    }

    // Function that inserts a Node with a key value into the binary search tree
    fun insertNode(key: Int) {
        
        if(key < this.key) { // If the key is smaller than its parent.
            
            if(this.left == null){ // If there is no left node, create one
                this.left = Node(key)
            }
            
            
            else { // Or continue in the left subtree (recursion) 
                this.left?.insertNode(key)  
            }
        }
        else if(key > this.key){
            if(this.right == null){
                this.right = Node(key)
            }
           
            else { // Or continue in the right subtree (recursion) 
                this.right?.insertNode(key)
            }
        }
    }

    // function that makes inorder traversal of the tree and prints it
    fun inorder(){
        
        this.left?.inorder() // goes to the left subtree. Recursion. ? inorder is not run if left is null
        
        print("${this.key}, ")

        this.right?.inorder() // goes to the right subtree. Recursion. ? inorder is not run if right is null.
    }
}


/*  Builds a binary search tree from a list of integers. 
*   The first integer in the list becomes the root of the tree
*   The return type is a Node (the root of the tree) */
fun buildTree(numbers : List<Int>): Node {
    val root = Node(numbers[0])
    // starts from 1
    for (i in 1 until numbers.size) {
        root.insertNode(numbers[i])
    }
    return root
}


//Prints the elements of a binary tree in an in-order traversal.
fun printTree(tree: Node) {
    tree.inorder()
    println()
}

// Test the binary search tree by building it from a list of numbers and printing its in-order traversal
fun testTree(numbers : List<Int>){
    val tree = buildTree(numbers)
    printTree(tree)
}

fun main(){

    println("A test of the original list (but also a sorted list) 1,4,5,99,110,200:")
    testTree(listOf(1,4,5,99,110,200))
    println("A test of the original list but scrambled 200,5,99,1,110,4")
    testTree(listOf(200,5,99,1,110,4))
    println("A test of two of the same number 9, 7, 5, 0, 12, 7")
    testTree(listOf(9, 7, 5, 0, 12, 7))
    println("A test of a negative number 9, 7, 5, 0, 12, -5")
    testTree(listOf(9, 7, 5, 0, 12, -5))
}