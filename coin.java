//find the max numbers of ajacentes
import java.lang.Math;

public class coin {
    // arreglo [0,1,1,0,0] longitud = 5

    static void solution(int[] A) {
        int n = A.length;
        int result = 0;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] == A[i + 1]) {
                    result = result + 1;
                }
            }

             int r = 0;
                for (int i = 0; i < n; i++) {
                    int count = 0;
                    if (i > 0) {
                        if (A[i - 1] != A[i])
                            count = count + 1;
                        else
                            count = count - 1;
                    }
                    if (i < n - 1) {
                        if (A[i + 1] != A[i])
                            count = count + 1;
                        else
                            count = count - 1;
                    }
                    r = Math.max(r, count);
                }
                int answer = result + r;
                System.out.println(answer);

    }

    public static void main(String args[]){
        int[] arr = {1, 1, 0, 1, 1, 0};
        solution(arr);
    }
}
