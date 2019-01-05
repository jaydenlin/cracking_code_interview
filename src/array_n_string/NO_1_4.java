package array_n_string;
/*
題目：找迴文字串
知識點：
1. 將英文 26 字母轉成 bits 來計算
2. bits 做 & 以及 | 計算，若是最後只有一個 1 則代表是回文 e.g. 010101 => 000100
3. 判斷 Bits 中只有一個 1 的方法：減 1 後做 & 如果是 0 ，代表這串  bits 只有一個 1
4. 在 bits 中加入 mask 的技巧要理解
複雜度：O(N)

 */
public class NO_1_4 {
    boolean isPermutationOfPalidrome(String phrase){
        //先把字串都轉成 bit
        int bitVector = createBitVector(phrase);

        return checkOnlyOneBit(bitVector);
    }
    int createBitVector(String phrase){
        int bitVector = 0;
        for(char c: phrase.toCharArray()){
            int x = getCharNumber(c);
            bitVector = toogleBits(bitVector, x);
        }
        return bitVector;
    }
    int toogleBits(int bitVector, int index){
        if(index < 0) return bitVector;

        int mask = 1 << index;//把 1 推到對應的位置
        //小技巧：在 bits 中加入 mask 的技巧
        if((bitVector & mask) == 0) {//代表目前的bitVector中，還沒被放入mask
            bitVector |= mask; //放入mask ，把位在  index的 1 放進 bitVector
        } else {
            bitVector &=~mask; //移除 mask ，把位在  index的 1 移出 bitVector，~代表非的意思，把 index 位置的 1 變成 0 做 & 計算
        }
        return bitVector;
    }
    //a->0, b->1, ...
    int getCharNumber(Character c){
        int a =Character.getNumericValue('a');
        int z =Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(val >= a && val <=z){
            return val - a;
        }
        return -1;
    }
    boolean checkOnlyOneBit(int bitVector){
        //小技巧：減 1 後做 & 如果是 0 ，代表這串  bits 只有一個 1
        return ((bitVector - 1) & bitVector ) == 0;
    }
    public static void main(String[] args) {
        NO_1_4 no = new NO_1_4();
        System.out.println(no.isPermutationOfPalidrome("ABABCDCDF"));//true
        System.out.println(no.isPermutationOfPalidrome("ABABCDCGF"));//false
    }
}
