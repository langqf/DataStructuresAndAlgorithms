package lang.string;

// 字符串匹配 bf算法
public class MyStringTest001 {

    public static void main(String[] args) {
        /*String s1 = "0123456789";
        String s2 = "89";
        int index = bfFind(s1, s2, 0);
        if(index != -1){
            System.out.println("找到位置：" + index);
        }else{
            System.out.println("没找到！");
        }*/

       /* // 病毒检测 virus=baa  bbaabbba aaabbbba
        // 病毒检测 virus=aabb  abceaabb abaabcea
        // 病毒检测 virus=abcd  cdabbbab cabbbbab
        String virus1 = "baa", dna1_1 = "bbaabbba", dna1_2 = "aaabbbba";
        System.out.println(virus1 + " in " + dna1_1 + " is " + virusCheck(virus1, dna1_1));
        System.out.println(virus1 + " in " + dna1_2 + " is " + virusCheck(virus1, dna1_2));

        String virus2 = "aabb", dna2_1 = "abceaabb", dna2_2 = "abaabcea";
        System.out.println(virus2 + " in " + dna2_1 + " is " + virusCheck(virus2, dna2_1));
        System.out.println(virus2 + " in " + dna2_2 + " is " + virusCheck(virus2, dna2_2));

        String virus3 = "abcd", dna3_1 = "cdabbbab", dna3_2 = "cabbbbab";
        System.out.println(virus3 + " in " + dna3_1 + " is " + virusCheck(virus3, dna3_1));
        System.out.println(virus3 + " in " + dna3_2 + " is " + virusCheck(virus3, dna3_2));
        System.out.println("================分割线==============");
        System.out.println(virusCheck("abcde", "bcdedbda"));
        System.out.println(virusCheck("acc", "bdedbcda"));
        System.out.println(virusCheck("cde", "cdcdcdec"));
        System.out.println(virusCheck("cced", "cdccdcce"));*/

        /*String s1 = "0189456789";
        String s2 = "89";
        System.out.println(bfFind(s1, s2, 0));
        System.out.println(bfFind(s1, s2, 3));*/

        String s1 = "0189456777889";
        String s2 = "78";
        System.out.println(kmpFindByNextJ(s1, s2, 0));
        System.out.println(kmpFindByNextVal(s1, s2, 0));

        System.out.println("\n abcaabbcabcaabdab 的nextJ=====================分割线====================");
        int[] abcaabbcabcaabdabs = getNextJ("abcaabbcabcaabdab");
        for(int i = 0 ; i < abcaabbcabcaabdabs.length; i++){
            System.out.print(abcaabbcabcaabdabs[i] + "、");// -1、0、0、0、1、1、2、0、0、1、2、3、4、5、6、0、1
        }

        System.out.println("\n abaabcac 的nextJ=====================分割线====================");
        int[] abaabcac = getNextJ("abaabcac");
        for(int i = 0 ; i < abaabcac.length; i++){
            System.out.print(abaabcac[i] + "、");      // -1、0、0、 1、1、2、0、1
        }
        System.out.println("\n abaabcac 的nextVal=====================分割线====================");
        int[] abaabcac_nextV = getNextVal("abaabcac");
        for(int i = 0 ; i < abaabcac_nextV.length; i++){
            System.out.print(abaabcac_nextV[i] + "、");// -1、0、-1、1、0、2、-1、1
        }

        System.out.println("\n aaaaaab  的nextJ=====================分割线====================");
        int[] aaaaaab = getNextJ("aaaaaab");
        for(int i = 0 ; i < aaaaaab.length; i++){
            System.out.print(aaaaaab[i] + "、");           // -1、0、 1、 2、 3、 4、 5
        }
        System.out.println("\n aaaaaab 的nextVal=====================分割线====================");
        int[] aaaaaaaaab_nextVal = getNextVal("aaaaaab");
        for(int i = 0 ; i < aaaaaaaaab_nextVal.length; i++){
            System.out.print(aaaaaaaaab_nextVal[i] + "、");// -1、-1、-1、-1、-1、-1、5
        }
        System.out.println("\n bereraaaaaacaaaaaaberrjekjer nextVal 测试=====================分割线====================");
        String s3 = "bereraaaaaacaaaaaaberrjekjer";
        String s4 = "aaaaaab";
        System.out.println(kmpFindByNextJ(s3, s4, 0));
        System.out.println(kmpFindByNextVal(s3, s4, 0));

    }

    // bf算法  添加一个pos参数，从指定位置开始找
    public static int bfFind(String s1, String s2, int pos){
        int index = -1;
        int i = pos, j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i = i-j+1;// kmp算法改进  i不退
                j = 0; // kmp算法改进 j=next[j]
            }
        }
        if(j >= s2.length()){
            index =  i  - j;
        }
        return index;
    }

    // kmp算法 关键 获取next[j]数组
    // bf算法  添加一个pos参数，从指定位置开始找
    public static int kmpFindByNextJ(String s1, String s2, int pos){
        int index = -1;
        int i = pos, j = 0;
        int[] nextJ = getNextJ(s2);
        System.out.println(" kmpFindByNextJ is start ");
        for(int n = 0; n< nextJ.length; n++){
            System.out.print(nextJ[n] + "、");
        }
        System.out.println("\n kmpFindByNextJ is end");
        int cnta = 0; // 计数器，比较次数
        int cntb = 0; // 计数器，比较次数
        int cntc = 0; // 计数器，比较次数
        while(i < s1.length() && j < s2.length()){
            if(j == -1){
                // j == -1 表示s2.chatAt(0)就不匹配了，j = next[0] = -1,这时候s1要往前移1位，j从0开始，-1+1 = 0;
                i++;
                j++;
                cnta++;
            }else if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                cntb++;
            }else{
                j = nextJ[j];
                cntc++;
            }
        }
        System.out.println("kmpFindByNextJ计数器显示a：" + cnta);
        System.out.println("kmpFindByNextJ计数器显示b：" + cntb);
        System.out.println("kmpFindByNextJ计数器显示c：" + cntc);
        if(j >= s2.length()){
            index =  i  - j;
        }
        return index;
    }

    public static int kmpFindByNextVal(String s1, String s2, int pos){
        int index = -1;
        int i = pos, j = 0;
        int[] nextJ = getNextVal(s2);
        System.out.println(" kmpFindByNextVal is start ");
        for(int n = 0; n< nextJ.length; n++){
            System.out.print(nextJ[n] + "、");
        }
        System.out.println("\n kmpFindByNextVal is end");
        int cnta = 0; // 计数器，比较次数
        int cntb = 0; // 计数器，比较次数
        int cntc = 0; // 计数器，比较次数
        while(i < s1.length() && j < s2.length()){
            if(j == -1){
                // j == -1 表示s2.chatAt(0)就不匹配了，j = next[0] = -1,这时候s1要往前移1位，j从0开始，-1+1 = 0;
                i++;
                j++;
                cnta++;
            }else if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
                cntb++;
            }else{
                j = nextJ[j];
                cntc++;
            }
        }
        System.out.println("kmpFindByNextVal计数器显示a：" + cnta);
        System.out.println("kmpFindByNextVal计数器显示b：" + cntb);
        System.out.println("kmpFindByNextVal计数器显示c：" + cntc);
        if(j >= s2.length()){
            index =  i  - j;
        }
        return index;
    }

    /**
     *
     * @param str 模式串 abcaabbcabcaabdab   如果是aaaaaab呢？ -1、0、1、2、3、4、5， 能不能优化成 -1、 0、 0、 0、 0、 0、 1  求nextVal
     * @return 求next[j] 0 1 1 1 2 2 3 1 1 2 3 4 5 6 7 1 2  从0开始，全部减1
     */
    public static int[] getNextJ(String str){
        int length = str.length();
        int[]  nextJ = new int[length];
        int j = 0, i = -1;
        nextJ[0] = -1;
        int cnta = 0;
        int cntb = 0;
        while(j < length){
            if(i == -1 || str.charAt(j) == str.charAt(i)){
                cnta++;
                i++;
                j++;
                if(j < length){
                    nextJ[j] = i;
                }
            }else{
                cntb++;
                i = nextJ[i];
            }
        }
        System.out.println("get NextJ cnta=" + cnta);
        System.out.println("get NextJ cntb=" + cntb);
        return nextJ;
    }

    /**
     *  nextJ数组优化 如果是aaaaaab呢？ nextJ = {-1、0、1、2、3、4、5}  nextVal={-1、 0、 0、 0、 0、 0、 1 }
     *  例如 abaabcac nextJ={-1、0、0、1、1、2、0、1} nextVal={-1、 0、 -1、 1、 0、 2、 -1、 1 }
     * @param str 模式串
     * @return NextVal数组
     */
    public static int[] getNextVal(String str){
        int length = str.length();
        int[]  nextJ = new int[length];
        int j = 0, i = -1;
        nextJ[0] = -1;
        int cnta = 0;
        int cntb = 0;
        while(j < length){
            if(i == -1 || str.charAt(j) == str.charAt(i)){
                cnta++;
                i++;
                j++;
                if(j < length){
                    if(str.charAt(j) != str.charAt(i)){
                        nextJ[j] = i;
                    }else{
                        nextJ[j] = nextJ[i];
                    }
                }
            }else{
                cntb++;
                i = nextJ[i];
            }
        }
        System.out.println("get  NextVal cnta=" + cnta);
        System.out.println("get  NextVal cntb=" + cntb);
        return nextJ;
    }

    /**
     *
     * @param str 模式串 abcaabbcabcaabdab
     * @return 求next[j] 0 1 1 1 2 2 3 1 1 2 3 4 5 6 7 1 2  从0开始，全部减1
     */
    public static int[] getBadNextJ(String str){
        int[]  nextJ= new int[str.length()];
        nextJ[0] = -1;//
        nextJ[1] = 0;
        int j = 2;
        for(; j < nextJ.length; j++){
            int n = 0;
            int p = n + 1;
            int m = p;
            // 这里匹配前缀，从第二个元素开始匹配，
            // 比如abcabcg  求g的next，先比较abcab && bcabc  abca&& cabc  abc&& abc
            // 求next时间复杂度变成了 O(n*n)了 n=str.length
            // 求next[j]也算是暴力破解了。。。。。。
            while(p < j && m < j) {//
                if(str.charAt(n) == str.charAt(m)){
                    n++;
                    m++;
                }else{
                    p++;
                    m = p;
                    n = 0;
                }
            }
            if(m == j){
                nextJ[j] = n;
            }else{
                nextJ[j] = 0;
            }
        }
        return nextJ;
    }

    // 病毒检测 baa -> baabaa  aabb -> aabbaabb  abcd -> abcdabcd
    public static Boolean virusCheck(String virus, String dnaString){
        boolean flag = false;
        int length = virus.length();
        String doubbleVirus = virus + virus;
        for(int i = 0; i < length; i++){
            String checkStr = doubbleVirus.substring(i, i + length);
            int index = bfFind(dnaString, checkStr, 0);
            if(index != -1){
                System.out.println("找到了 " + checkStr + " in " + dnaString + " is true");
                flag = true;
                break;
            }
        }
        return flag;
    }

}
