package array_n_string;
/*
題目：判斷是否字串旋轉
知識點：
相加原有字串，判斷 subString
 */
public class NO_1_9 {
    boolean isRotation(String s1, String s2){
        if(s1.length() > 0 && s1.length() == s2.length()) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }
}
