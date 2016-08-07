import java.util.Scanner;



public class PostorderTraversal{

		public Node insert(Node root, int val)
		{
			Node temp;
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
		
		
		public void postorder(Node node)
		{
			System.out.println(" "+node.value+" ");
			if(node.left!=null)
				postorder(node.left);
			if(node.right!=null)
				postorder(node.right);
			
			return;
		}
		
		public static void main(String args[])
		{
			int n=0, m=0;
			Node root=null;
			PostorderTraversal pt=new PostorderTraversal();
			System.out.println("enter the no. of elements of Binary Tree:");
			Scanner sc=new Scanner(System.in);
			
			n = sc.nextInt();
			
			for(int i=1;i<=n;i++)
			{
				System.out.println("Enter node "+i+": ");
				m=sc.nextInt();
				root=pt.insert(root, m);
			}
			System.out.println("Postorder Traversal: ");
			pt.postorder(root);
			sc.close();
			
		}
}

