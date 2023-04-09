import java.util.*;
public class Main{
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int result = 0;
        int [][][] tables = new int [n][m][a];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < a; k++){
                    tables[i][j][k] = in.nextInt();
                    System.out.print(tables[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < a; k++){
                    int nextI = (i + 1) % n;
                    int nextJ = (j + 1) % m;
                    if(tables[i][j][k] == tables[nextI][nextJ][k]){
                        result++;
                    }
                }
            }
        }
        System.out.print(result);
    }
}
