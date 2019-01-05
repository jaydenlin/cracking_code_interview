package array_n_string;

import java.util.Arrays;
/*
題目：檢查兩字串是否有同樣的字元
知識點：
1. 要確認編碼的長度
2. 將字元轉 int 會成為編碼的值，例如 A => 65
3. 計算每種字元的出現的計數
5. 透過雙針模型同時掃
複雜度：O(N)
 */
public class NO_1_2 {
    //檢查兩字串是否有同樣的字元
    private String sort(String str){
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
    boolean solution1(String str, String target){
        //sort
        if(str.length() != target.length()){
            return false;
        }
        return sort(str).equals(sort(target));
    }

    boolean solution2(String str, String target) {
        if(str.length() != target.length()) return false;
        int[] letters = new int[128];//假設是ASCII
        for(int i=0;i<str.length();i++){
            letters[str.charAt(i)]++;
        }

        for(int j=0;j<target.length();j++){
            letters[target.charAt(j)]--;
            //如果減過頭就直接 false
            if(letters[target.charAt(j)]<0){
                return false;
            }
        }
        return true;


    }

    public static void main(String[] args) {
        NO_1_2 no = new NO_1_2();
        System.out.println(no.solution1("ADFGE", "EGDFA"));//true
        System.out.println(no.solution1("BDFGE", "EGDFA"));//false
        System.out.println(no.solution2("ADFGE", "EGDFA"));//true
        System.out.println(no.solution2("BDFGE", "EGDFA"));//false
    }
}
