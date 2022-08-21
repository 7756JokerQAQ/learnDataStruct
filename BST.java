import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }
    private Node root;
    private int size;

    public BST() {
        root=null;
        size=0;
    }
public boolean contains(E e){
    return contains(root,e);
}
public E minimum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
       return minimum(root).e;
}
private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
}
    public E maximum(){
        if(size==0)
            throw new IllegalArgumentException("BST is empty");
        return maximum(root).e;
    }
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return maximum(node.right);
    }
    //删除二分搜索树的最小值和最大值
    //从二分搜索树中删除最小值然后进行返回
    public E removeMin(){
        E ret=minimum();
        root=removeMin(root);
        return ret;
    }
    private Node removeMin(Node node){
        if(node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
      node.left= removeMin(node.left);
        return node;
    }
    //从二分搜索树中删除最大值然后进行返回
    public E removeMax(){
        E ret=maximum();
        root=removeMax(root);
        return ret;
    }
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode=node.left;
            node.left=null;
            size--;
            return leftNode;
        }
        node.right= removeMax(node.right);
        return node;
    }
private boolean contains(Node node,E e){
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e)==0){
            return true;
        }
        else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }
        else
            return contains(node.right,e);
}
    public int getSize() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

    public void add(E e){
        root=add(root,e);
    }
    private Node add(Node node,E e){
        if(node==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0)
            node.left=add(node.left,e);
        else if(e.compareTo(node.e)>0){
            node.right=add(node.right,e);
        }
        return node;
    }
    //第二种方法为：
//    public void add(E e){
//        if(root==null){
//            root=new Node(e);
//            size++;
//        }
//        else
//            add(root,e);
//    }
   /* private void add(Node node,E e){
        if(e.equals(node.e)){
            return;
        }
        else if(e.compareTo(node.e)<0&&node.left==null){
            node.left=new Node(e);
            size++;
        }
        else if(e.compareTo(node.e)>0&&node.right==null){
            node.right=new Node(e);
            size++;
        }
        if(e.compareTo(node.e)<0){
            add(node.left,e);
        }
        else
            add(node.right,e);
    }

    */

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
    if(node==null) {
        return;
    }
        System.out.print(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    //二分搜索树的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur=stack.pop();
            System.out.print(cur.e);
            if(cur.right!=null)
                stack.push(cur.right);
            if(cur.left!=null)
                stack.push(cur.left);
        }
    }
public void levelOrder(){
    Queue<Node> q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        Node cur=q.remove();
        System.out.print(cur.e);
        if(cur.left!=null)
            q.add(cur.left);
        if(cur.right!=null){
            q.add(cur.right);
        }
    }
}
    public void nextOrder(){
        nextOrder(root);
    }
    private void nextOrder(Node node){
        if(node==null){
            return;
        }
        nextOrder(node.left);
        nextOrder(node.right);
        System.out.print(node.e);
    }

public void inOrder(){
        inOrder(root);
}
private void inOrder(Node node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e);
        inOrder(node.right);
}
//二分搜索树的层序遍历广度优先遍历 使用到队列


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }
    //生成以node 为根节点 深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if(node==null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);
    }
    private String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++){
            res.append("--");
        }
        return res.toString();
    }
    public void remove(E e){
        root=remove(root,e);
    }
    private Node remove(Node node,E e){
        if(node==null)
            return null;
        if(e.compareTo(node.e)<0){
           node.left =remove(node.left,e);
           return node;
        }
        else if(e.compareTo(node.e)>0){
            node.right=remove(node.right,e);
            return node;
        }
        else{
            if(node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;
            node.left=node.right=null;
            return successor;
        }
    }
    public void remove2(E e){
        root=remove2(root,e);
    }
    private Node remove2(Node node, E e){
        if(node==null){
            return null;
        }
       if(e.compareTo(node.e)<0){
           node.left=remove(node.left,e);
           return node;
       }
       else if(e.compareTo(node.e)>0){
           node.right=remove(node.right,e);
           return node;
       }
       else{

           if(node.right==null){
               Node leftNode=node.left;
               node.left=null;
               size--;
               return leftNode;
           }
           if(node.left==null){
               Node rightNode=node.right;
               node.right=null;
               size--;
               return rightNode;
           }
           Node preNode=maximum(node.left);
           preNode.left=removeMax(node.left);
           preNode.right=node.right;
           node.right=node.left=null;
           return preNode;
       }
    }
}
