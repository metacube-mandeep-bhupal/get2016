public class TreeNode<E> {

	E data;
	TreeNode<E> left,right;
	
	public TreeNode(E root)
	{
		this.data=root;
		this.left=null;
		this.right=null;
	}

	public boolean mirrorTree(TreeNode<E> tree1, TreeNode<E> tree2)
	{
		boolean temp=false;
		if(tree1==null && tree2==null)
			temp=true;
		else if((tree1!=null && tree2!=null) && (tree1.data.equals(tree2.data)))
		{
			temp=mirrorTree(tree1.left,tree2.right) && mirrorTree(tree1.right,tree2.left);
		}
		else
			temp=false;
		return temp;		
	}
	
	public static void main(String args[])
	{
		TreeNode<String> tree1=new TreeNode("A");	//root node

		tree1.left=new TreeNode<String>("B");
		tree1.right=new TreeNode<String>("C");

		tree1.left.left=new TreeNode<String>("D");
		tree1.left.right=new TreeNode<String>("E");

		tree1.right.left=new TreeNode<String>("F");
		tree1.right.right=new TreeNode<String>("G");
		
		TreeNode<String> tree2=new TreeNode("A");	//root node

		tree2.left=new TreeNode<String>("C");
		tree2.right=new TreeNode<String>("B");

		tree2.left.left=new TreeNode<String>("G");
		tree2.left.right=new TreeNode<String>("F");

		tree2.right.left=new TreeNode<String>("E");
		tree2.right.right=new TreeNode<String>("D");
		
		TreeNode<String> tree3=new TreeNode("A");
		boolean mirror=tree3.mirrorTree(tree1, tree2);
		if(mirror==true)
			System.out.println("Both trees are mirror similar trees");
		else
			System.out.println("Both trees are not mirror similar trees");
		
	}
}
