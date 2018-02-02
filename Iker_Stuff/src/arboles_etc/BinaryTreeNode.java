/**
 * BinaryTreeNode represents a node in a binary tree with a left and 
 * right child.
 * 
 * Added getters and setters to avoid the "protected" when using the method sameStructure
 * 
 */
package arboles_etc;

public class BinaryTreeNode<T> {
	protected T element;
	protected BinaryTreeNode<T> left;
	protected BinaryTreeNode<T> right;

	/**
	 * Creates a new tree node with the specified data.
	 * 
	 * @param obj
	 *            the element that will become a part of the new tree node
	 */
	BinaryTreeNode(T obj) {
		element = obj;
		setLeft(null);
		setRight(null);
	}

	/**
	 * Returns the number of non-null children of this node. This method may be
	 * able to be written more efficiently.
	 * 
	 * @return the integer number of non-null children of this node
	 */
	public int numChildren() {
		int children = 0;

		if (left != null)
			children = 1 + getLeft().numChildren();

		if (right != null)
			children = children + 1 + right.numChildren();

		return children;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	//CREADO POR IKER PARA PODER USAR DESDE OTROS PAQUETES, SINO QUITAR PROTECTED
	public T getElement(){
		return element;
	}
}
