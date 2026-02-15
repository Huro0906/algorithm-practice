
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        BinaryTree bt = new BinaryTree();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            char pc = st.nextToken().charAt(0);
            char lc = st.nextToken().charAt(0);
            char rc = st.nextToken().charAt(0);

            Node p = bt.find(pc);
            if(p==null){
                bt.head = new Node(pc);
                p = bt.head;
            }
            if(lc!='.')
             p.l = new Node(lc);
            if(rc!='.') p.r = new Node(rc);
        }
        preOrder(bt.head);
        System.out.println();
        inOrder(bt.head);
        System.out.println();
        postOrder(bt.head);

    }

    public static class Node{
        char v;
        Node l;
        Node r;

        public Node(char v){
            this.v = v;
            l=null;
            r=null;
        }
    }

    public static class BinaryTree{
        Node head;

        public BinaryTree(){
            head = null;
        }
        public Node find(char v){
            if(head==null)return null;

            Queue<Node> q = new LinkedList<>();
            q.add(head);

            while(!q.isEmpty()){
                Node cur = q.poll();
                if(cur.v==v)return cur;

                if(cur.l!=null)q.add(cur.l);
                if(cur.r!=null)q.add(cur.r);
            }
            return null;
        }
    }

    public static void preOrder(Node n){
        if(n==null)return;
        System.out.print(n.v);
        preOrder(n.l);
        preOrder(n.r);
    }
    public static void inOrder(Node n){
        if(n==null)return;
        inOrder(n.l);
        System.out.print(n.v);
        inOrder(n.r);
    }
    public static void postOrder(Node n){
        if(n==null)return;
        postOrder(n.l);
        postOrder(n.r);
        System.out.print(n.v);
    }
}