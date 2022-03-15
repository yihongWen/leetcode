package zyj.yihong.leetcode.mid.queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 950. 按递增顺序显示卡牌
 * 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
 *
 * 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
 *
 * 现在，重复执行以下步骤，直到显示所有卡牌为止：
 *
 * 从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
 * 如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
 * 如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
 * 返回能以递增顺序显示卡牌的牌组顺序。
 *
 * 答案中的第一张牌被认为处于牌堆顶部。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reveal-cards-in-increasing-order
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeckRevealedIncreasing950 {
    // 使用队列，插空
    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < deck.length; i++) {
            deque.add(i);
        }
        Arrays.sort(deck);

        for (int i = 0; i < deck.length; i++) {
            result[deque.pollFirst()] = deck[i];
            if (deque.size()>0){
                Integer pollFirst = deque.pollFirst();
                deque.offerLast(pollFirst);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {17,13,11,2,3,5,7};
        int[] ints = deckRevealedIncreasing(arr);
        System.out.println(Arrays.toString(ints));
    }
}
