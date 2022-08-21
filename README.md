二分搜索树的前序遍历、中序遍历、后序遍历
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
//中序遍历
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
//后序遍历
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
二分搜索树的前序遍历：
利用栈进行实现：
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
二分搜索树的层序遍历：利用到队列进行遍历
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
集合和映射（Set and map）：
可以达到去重的目的。
集合的时间复杂度分析：增add O(n)   查contains O(n)   删remove O(n)
堆和优先队列
普通队列：先进先出；后进后出
优先队列：出队顺序和入队顺序无关；和优先级相关
动态的选择优先级最高的任务执行；
优先队列：可以使用不同的底层实现  入队       出队（拿出最大的元素）
one：普通的线性结构                            O(1)      O(n)
two :  顺序线性结构				    O(n)	   O(1)
堆								    O(logn)  O(logn)
二叉堆 Binary Heap 是一棵完全二叉树：堆中某个节点的值总是不大于其父节点的值
parent(i)=i/2  left child(i)=2*i   right child(i)=2*i+1
java标准库中的优先队列
top K,select K问题：既可以用快排的思想解决，又可以用优先队列解决
快排：时间O(n) 空间O（1）
优先队列：时间 O(nlogK) 空间：O(k)  
优先队列的优势：不需要一次性的知道所有的数据 数据流 极大规模

