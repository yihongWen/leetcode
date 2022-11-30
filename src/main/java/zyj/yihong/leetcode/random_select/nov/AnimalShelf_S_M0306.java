package zyj.yihong.leetcode.random_select.nov;

import java.util.LinkedList;

public class AnimalShelf_S_M0306 {

    private LinkedList<int[]> linkedList = new LinkedList<>();

    public AnimalShelf_S_M0306() {

    }

    public void enqueue(int[] animal) {
        linkedList.add(animal);
    }

    public int[] dequeueAny() {
        return linkedList.removeFirst();
    }

    public int[] dequeueDog() {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i)[1] == 1) {
                return linkedList.remove(i);
            }
        }
        return new int[]{-1,-1};
    }

    public int[] dequeueCat() {
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i)[1] == 0) {
                return linkedList.remove(i);
            }
        }
        return new int[]{-1,-1};
    }
}
