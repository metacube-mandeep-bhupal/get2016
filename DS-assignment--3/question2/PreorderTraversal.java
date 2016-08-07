public class PreorderTraversal<E> {

	public Node<E> insert(Node<E> root, int val)
	{
		Node<E> temp;
		if(root==null)
		{
			temp=new Node(val);
			root=temp;
			return root;
		}
		else if(val < root.value)
				root.left=insert(root.left, val);
		else
			root.right=insert(root.right,val);
		return root;
			
		
	}
	
	
	public void preorder(Node node)
	{
		Object val;
		if(node.left!=null)
			preorder(node.left);
		if(node.right!=null)
			preorder(node.right);
		System.out.println(" "+node.value+" ");
		return;
	}
	
}
