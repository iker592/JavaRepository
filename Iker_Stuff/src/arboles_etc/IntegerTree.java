package arboles_etc;


/**
 * ExpressionTree represents an expression tree of operators and operands.
 * 
 * @author DSA
 */

public class IntegerTree extends LinkedBinaryTree<Integer> {
	/**
	 * Creates an empty Integer tree.
	 */
	public IntegerTree() {
		super();
	}

	/**
	 * Constructs an integer tree from the two specified integer trees.
	 * 
	 * @param element
	 *            the integer tree for the center
	 * @param leftSubtree
	 *            the integer tree for the left subtree
	 * @param rightSubtree
	 *            the integer tree for the right subtree
	 */
	public IntegerTree(Integer element, IntegerTree leftSubtree,
			IntegerTree rightSubtree) {
		root = new BinaryTreeNode<Integer>(element);
		count = 1;

		if (leftSubtree != null) {
			count = count + leftSubtree.size();
			root.left = leftSubtree.root;
		} else
			root.left = null;

		if (rightSubtree != null) {
			count = count + rightSubtree.size();
			root.right = rightSubtree.root;
		} else
			root.right = null;
	}


	public BinaryTreeNode<Integer> getLeft() {
		return (root.getLeft()) ;
	}

	public BinaryTreeNode<Integer> getRight() {
		return root.getRight();
	}
	
	public BinaryTreeNode<Integer> getRootExp() {
		return root;
	}

}