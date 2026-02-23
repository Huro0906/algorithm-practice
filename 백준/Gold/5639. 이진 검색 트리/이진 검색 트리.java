import java.util.*;
import java.io.*;

public class Main {
    
    static class Node{
        int v;
        Node left;
        Node right;

        public Node(int v){
            this.v = v;
        }
    }

    static class BinaryTree{
        public Node head;
        public BinaryTree(){
            this.head = null;
        }
        public void add(int v){
            if(this.head==null)head = new Node(v);
            Node p = find(head,v);
            
            if(p.v<v)p.right = new Node(v);
            if(p.v>v)p.left = new Node(v);
        }

        public Node find(Node n, int v){
            //부모 노드 반환
            if((n.left == null && n.v > v) || (n.right == null && n.v < v)){
                return n;
            }

            if(n.left!=null && n.v>v)return find(n.left,v);
            if(n.right!=null && n.v<v)return find(n.right,v);

            return head;
        }

    }
    static StringBuilder sb = new StringBuilder();
    public static void postOrder(Node n){
        
        if(n.left!=null)postOrder(n.left);
        if(n.right!=null)postOrder(n.right);
        sb.append(n.v).append("\n");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BinaryTree bt = new BinaryTree();
        String line;
        
        while((line = br.readLine())!=null){
            bt.add(Integer.parseInt(line));
            
        }
        
        postOrder(bt.head);
        System.out.println(sb);
        
    }
}
