package array_n_string;
/*
題目：字串每個字元是否獨一無二
知識點：
1. 要確認編碼的長度
2. 將字元轉 int 會成為編碼的值，例如 A => 65
3. 計算每種字元的出現的計數
複雜度：O(N)
 */
public class NO_1_1 {
    boolean isUniqueChars(String str){
        if(str.length() > 128) return false;

        boolean[] char_set = new boolean[128];//假設是 ASCII
        for(int i=0;i<str.length();i++){
            int val = str.charAt(i);
            //如果有出現第二次就直接 false
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        NO_1_1 no = new NO_1_1();
        no.isUniqueChars("ABC");

        System.out.println(no.isUniqueChars("ABC"));//true
        System.out.println(no.isUniqueChars("AAA"));//false
    }
}
