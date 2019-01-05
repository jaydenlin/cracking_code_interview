package array_n_string;

/*
題目：看字串是被插入，刪除還是替換一次
 */
public class NO_1_5 {

    boolean solution(String str1, String str2){
        if(str1.length() == str2.length()){
            System.out.println("---Replace");
            return oneReplace(str1, str2);
        } else if(str1.length() < str2.length()){
            System.out.println("---Insert");
            return oneInsert(str1, str2);
        } else {
            System.out.println("---Delete");
            return oneDelete(str1, str2);
        }
    }
    boolean oneInsert(String str1, String str2){
        int pos1=0;
        int pos2=0;
        boolean foundDifferences = false;
        while (pos1 < str1.length() && pos2 < str2.length()){
            if(foundDifferences) {
                return false;
            }
            if(str1.charAt(pos1) != str2.charAt(pos2)){
                foundDifferences = true;
                pos2 ++;
            } else {
                pos1++;
                pos2++;
            }
        }

        return true;
    }
    boolean oneReplace(String str1, String str2){
        int pos1=0;
        int pos2=0;
        boolean foundDifferences = false;
        while (pos1 < str1.length() && pos2 < str2.length()){

            if(str1.charAt(pos1) != str2.charAt(pos2)){
                if(foundDifferences) {
                    return false;
                }
                foundDifferences = true;
            }
            pos1++;
            pos2++;

        }
        return true;
    }
    boolean oneDelete(String str1, String str2){
        int pos1=0;
        int pos2=0;
        boolean foundDifferences = false;
        while (pos1 < str1.length() && pos2 < str2.length()){

            if(str1.charAt(pos1) != str2.charAt(pos2)){
                if(foundDifferences) {
                    return false;
                }
                foundDifferences = true;
                pos1++;
            } else {
                pos1++;
                pos2++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NO_1_5 no = new NO_1_5();
        System.out.println(no.solution("pale", "ple"));
        System.out.println(no.solution("pales", "pale"));
        System.out.println(no.solution("pale", "bale"));
        System.out.println(no.solution("pale", "bake"));
    }


}
