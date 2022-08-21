
@SuppressWarnings({"all"})
public class Array<E> {
    private E []data;
    private int size;

    public Array(int capacity) {
        data=(E[])new Object[capacity];
        size=0;
    }

    public Array() {
        this(10);
    }
public Array(E []arr){
        data=(E[])new Object[arr.length];
    for (int i = 0; i < arr.length ; i++) {
        data[i]=arr[i];
    }
    size=arr.length;
    }
    public int getSize() {
        return size;
    }
    public  int getCapacity(){
        return  data.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //在最后元素后面添加一个新元素
    public void addLast(E e){  //时间复杂度位O（1）
//      if(size==data.length){
//          throw new IllegalArgumentException("AddLast failed");
//      }
//        data[size]=e;
//        size++;
        add(size,e);
    }
    //在所有元素的前加一个新元素
    public void addFirst(E e){  //O(n)
        add(0,e);
    }
    //再第index个位置插入一个新元素e
    public void add(int index,E e){   //O(n)
        if(size==data.length){
           resize(2*data.length);
            // throw new IllegalArgumentException("Add failed.Array is full");
        }
        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.Require index>0 and index<size");
        }
        for (int i = size-1; i >=index; i--) {
            data[i+1]=data[i];
        }
        data[index]=e;
        size++;
    }

    @Override
    public String toString() {
   StringBuilder res=new StringBuilder();
   res.append(String.format("Array:size=%d.capacity=%d\n",size,getCapacity()));
   res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i!=size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return true;
            }

        }
        return false;
    }
    public void swap(int i,int j){
        if(i<0||i>=size||j<0||j>=size){
            throw new IllegalArgumentException("index is illegal");

        }
        E t=data[i];
        data[i]=data[j];
        data[j]=t;
    }
    public  int find (E e){      //O(n)
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)){
                return i;
            }}
        return -1;
    }
    E get(int index){    //O(1)
        if(index<0||index>=size)
            throw new IllegalArgumentException("Gat failed.Index is illegal");
        return  data[index];
    }
    public void set(int index,E e){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Gat failed.Index is illegal");
        data[index]=e;
    }
    //从数组中删除元素 并且返回元素
    public E remove (int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Gat failed.Index is illegal");
        E ret =data[index];
        for (int i =index+1 ; i <size ; i++) {
        data[i-1]=data[i];
        }
        size--;
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }
    /*
    增  O(n)
    删  O(n)
    改   已知索引O(1) 未知索引O(n)
    查    已知索引O(1) 未知索引O(n)
     */
public  E removeFires(){
        return remove(0);
}
public  E removeLast(){
        return remove(size-1);
}
public  void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
}
public E getLast(){
return get(size-1);
}
public E getFirst(){
    return get(0);
}
//移除数组中所有相同的元素
public  void removeAllElement(E e){
    for (int i = 0; i < size; i++) {
        if(data[i].equals(e)){
            remove(i);
        }
    }
}
private void resize(int newCapacity){
    //capacity=n  n+1次addLast 触发resize（） 平均addLast操作 进行两次基本操作
    //均摊复杂度  resize O（n） addlast的均摊复杂度位O（1）
    //复杂度的震荡  【addLast O(n) removeLast  O(n)】重复两个操作
    //解决方案 使用 更加懒惰的方式 size==capacity/4 是才将capacity减半
   E[] newData=(E[])new Object[newCapacity];
    for (int i = 0; i < size; i++) {
        newData[i]=data[i];
    }
    data=newData;

}
}
