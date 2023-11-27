package Tree;

public class Recursion {

    public static void recur(int n,int m){
        if(n==0 || m==0){
            return;
        }
        recur(n-1,m);
        recur(n,m-1);
        System.out.println(n+" "+m);

    }
    public static void main(String[] args){
        recur(2,2);
    }
}
