package array_n_string;
/*
題目：把有 0 的 row 跟 column 都設成 0
知識點：
先把有 0 的 row 跟 column 記起來，之後再整條 set 0
 */
public class NO_1_8 {
    void setZeros(int[][] matrix){
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==0){
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        for(int i=0;i<row.length;i++){
            if(row[i]){
                setRowToZero(matrix, i);
            }

        }
        for(int j=0;j<column.length;j++){
            if(column[j]){
                setRowToZero(matrix, j);
            }
        }
    }
    void setRowToZero(int[][] matrix, int row){
        for(int i=0;i<matrix.length;i++){
            matrix[row][i] = 0;

        }
    }
    void setColumnToZero(int[][] matrix, int column){
        for(int j=0;j<matrix.length;j++){
            matrix[j][column] = 0;
        }
    }
}
