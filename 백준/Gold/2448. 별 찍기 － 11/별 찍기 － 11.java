import java.util.*;
import java.io.*;

public class Main {
    static int maxWidth;
    static int n;
    static char[][] tree = new char[n][maxWidth];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        maxWidth = 2*n-1;
        tree = new char[n][maxWidth];
        int size = (int)(Math.log(n/3)/Math.log(2));
        draw(size,0,(maxWidth-1)/2);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<maxWidth; j++){
                if(tree[i][j]=='*')sb.append("*");
                else sb.append(" ");        
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void draw(int size, int r, int c){
        if(size==0){
            tree[r][c]='*';
            tree[r+1][c-1] = '*';
            tree[r+1][c+1] = '*';
            for(int i=-2; i<=2; i++){
                tree[r+2][c+i]='*';
            }
            return;
        }
        int width = 5*(int)Math.pow(2,size-1)+(int)Math.pow(2,size-1);
        int h = (int)Math.pow(2,size-1)*3;
        draw(size-1,r,c);
        draw(size-1,r+h,c-(width)/2);
        draw(size-1,r+h,c+(width)/2);
    }
}
