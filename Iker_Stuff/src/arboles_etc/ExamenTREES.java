package arboles_etc;
import jss2.*;

public class ExamenTREES<T> {
	public ExamenTREES(){
		
	}
	
	public boolean childSum(BinaryTreeNode<T> root){
		if(root != null){
			return worker(root);
		}
		else { return true;}
	}
	
	public boolean worker (BinaryTreeNode<T> node){
		if( ((Integer)node.getLeft().element + (Integer)node.getRight().element ) == (Integer)node.element)		
			return worker(node.left) && worker(node.right);
		else{return false;}
	}
	
}
