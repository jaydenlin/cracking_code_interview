package array_n_string;

public class NO_1_3 {
    char[] replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0;
        for(int i=0;i<trueLength;i++){
            if(str[i]==' ') {
                spaceCount++;
            }
        }

        int newLength = trueLength - spaceCount + spaceCount*3;//%20 共有三個字元
        int writeIndex = newLength -1;
//        if(trueLength < newLength) {
//            str[trueLength] = '\0';
//        }
        for(int j=trueLength-1;j>0;j--){
            if(str[j]==' '){
                str[writeIndex] = '0';
                str[writeIndex-1] = '2';
                str[writeIndex-2] = '%';
                writeIndex=writeIndex-3;
            }else{
                str[writeIndex] = str[j];
                writeIndex--;
            }

        }

        return str;

    }

    public static void main(String[] args) {
        NO_1_3 no =new NO_1_3();
        System.out.println(no.replaceSpaces("Mr John Smith    ".toCharArray(), 13));//Mr%20John%20Smith
    }
}
