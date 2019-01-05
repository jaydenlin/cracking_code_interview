package array_n_string;
/*
題目：將矩陣轉 90 度 in place
知識點：
1.將矩陣內的值兩兩 swap 可以達到效果
2.從 2x2 陣列開始做
3.把要 Swap 的座標列一列，代入 layer 跟 last 項的 index 跟 n

0 1
2 3
https://www.youtube.com/watch?v=Jtu6dJ0Cb94
Swap([0,0],[0,1])
Swap([0,0],[1,1]) //對角線換
Swap([0,0],[1,0])

複雜度：n平方
 */
public class NO_1_7 {
    void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer =0 ;layer<n/2;layer++){
            int first = layer;
            int last = n-1-layer;
            for(int i=first; i<last;i++){
                int offset = i-first;
                int top = matrix[first][i];//暫存項
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last-offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;

            }
        }
    }
}

