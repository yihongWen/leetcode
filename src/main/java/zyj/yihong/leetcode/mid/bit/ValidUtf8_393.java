package zyj.yihong.leetcode.mid.bit;

/**
 * 393. UTF-8 编码验证
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/utf-8-validation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidUtf8_393 {
    int cal1 = 1<<7;
    int cal2 = (1<<7)+(1<<6);
    public boolean validUtf8(int[] data) {
        int index = 0;
        while (index<data.length){
            int utf8Length = getUtf8Length(data[index]);
            if (utf8Length==-1||index+utf8Length>data.length){
                return false;
            }

            for (int j = 1; j < utf8Length; j++) {
                boolean b = checkNextNumPre10(data[index + j]);
                if (!b){
                    return false;
                }
            }
            index = index+utf8Length;
        }
        return true;
    }

    private int getUtf8Length(int num){
        // 如果首位为0那么 1个字节
        if ((num&cal1)==0){
            return 1;
        }
        int tempCal = cal1;
        int bitLength = 0;
        while ((num&tempCal)!=0){
            bitLength++;
            tempCal = tempCal>>1;

            // 超过4位，无效的utf
            if (bitLength>4){
                return -1;
            }
        }
        // 如果是10xxx的 返回-1
        if (bitLength==1){
            return -1;
        }
        return bitLength;
    }

    private boolean checkNextNumPre10(int num){
        return (num&cal2)==cal1;
    }

    public static void main(String[] args) {
        ValidUtf8_393 validUtf8_393 = new ValidUtf8_393();
//        11000101 10000010 00000001。
        int[] data = {145};
        boolean b = validUtf8_393.validUtf8(data);
        System.out.println(b);
    }
}
