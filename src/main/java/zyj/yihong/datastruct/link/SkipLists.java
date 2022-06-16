package zyj.yihong.datastruct.link;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class SkipLists {
    public static void main(String[] args) {
        SkipLists skipLists = new SkipLists();
        skipList list = new skipList();
        skipLists.insert(list,1,new Random());
        skipLists.insert(list,2,new Random());
        skipLists.insert(list,3,new Random());
        skipLists.insert(list,4,new Random());
        skipLists.insert(list,5,new Random());
        skipLists.insert(list,6,new Random());
        skipLists.insert(list,7,new Random());
        skipLists.insert(list,8,new Random());
        skipLists.insert(list,9,new Random());
        skipLists.insert(list,10,new Random());
        skipLists.insert(list,11,new Random());
        skipLists.insert(list,12,new Random());
        Node search = skipLists.search(list, 13);
        System.out.println(search);
//        skipLists.printList(list);

    }


    // ---------------------------------------- //
    // Node class used for bulding the skiplist //
    public static class Node {

        public String key;
        public long value;

        public Node left;
        public Node right;
        public Node up;
        public Node down;

        // Initializing Node values
        public Node(long value) {
            this.left = null;
            this.right = null;
            this.up = null;
            this.down = null;
            this.value = value;
        }
    }


    // ------------------------------------------------------- //
    // Class creates default skiplist, with infinity endpoints //
    // and functionality for adding levels                     //
    public static class skipList {
        public long posInf = 100000000;
        public long negInf = -100000000;

        public Node head, tail;
        public int size, maxLevel;
        public long flip;

        // Initializing SkipList
        public skipList() {
            Node nInf = new Node(negInf);
            Node pInf = new Node(posInf);

            nInf.right = pInf;
            pInf.left = nInf;

            this.head = nInf;
            this.tail = pInf;
            this.maxLevel = 1;
            this.size = 0;

        }

        // Creates empty level
        public void addLevel() {
            Node newnInf = new Node(this.negInf);
            Node newpInf = new Node(this.posInf);

            // Linking to lower level
            newnInf.down = head;
            newnInf.right = newpInf;
            newpInf.down = tail;
            newpInf.left = newnInf;
            head.up = newnInf;
            tail.up = newpInf;

            // Update logic markers
            head = newnInf;
            tail = newpInf;
            maxLevel++;
        }

    }



    // ---------------------------------------------------- //
    // Finds the node with the value <= key at lowest level //
    public Node search(skipList list, int key) {
        Node x = list.head;

        // Traverse Levels, top to bottom
        for (int y = list.maxLevel; y > 0; y--) {

            // Traverse Level
            while (x.right.value != list.posInf && x.right.value <= key) {
                x = x.right;
            }

            // Attempt to go down the levels
            if (x.down != null) {
                x = x.down;
            } else {
                break; // Reached bottom level
            }
        }
        return x;
    }


    // -------------------------------------------------------------------- //
    // Inserts new value into skiplist, will discard any duplicate attempts //
    public void insert(skipList list, int value, Random randomizer) {

        Node newEntry = new Node(value);
        Node current = search(list, value);
        int stackHeight;

        // Already in skipList, discard. Add otherwise
        if (current.value != value) {

            newEntry.left = current;
            newEntry.right = current.right;
            current.right = newEntry;
            newEntry.right.left = newEntry;

            // Promote node randomly
            stackHeight = 1;
            while ((randomizer.nextInt() % 2) == 1) {

                // Add level if necessary
                if (stackHeight >= list.maxLevel) {
                    list.addLevel();
                }

                // From current position, climb up
                while (current.up == null) {
                    current = current.left;
                }
                current = current.up;

                // New level Linkeage
                Node levelUp = new Node(value);
                levelUp.left = current;
                levelUp.right = current.right;
                current.right.left = levelUp;
                current.right = levelUp;
                levelUp.down = newEntry;
                newEntry.up = levelUp;

                // Link in case value gets promoted again
                newEntry = levelUp;

                stackHeight++;
            }

            // Update logic markers
            list.size++;
            if (stackHeight > list.maxLevel) {
                list.maxLevel = stackHeight;
            }
        }
    }


    // ------------------------------------- //
    // Prints all vaules in current skiplist //
    public void printList(skipList list) {
        Node current = list.head;

        // Level 1 contains all values in list, level down
        while (current.down != null) {
            current = current.down;
        }

        // At level 1, traverse level and print each node stack
        System.out.println("the current Skip List is shown below:");
        System.out.println("---infinity");
        while (current.value != list.tail.value) {
            current = current.right;
            if (current.value != list.posInf) {
                printStack(current);
            }
        }
        System.out.println("+++infinity");
        System.out.println("---End of Skip List---");
    }


    // ---------------------------------------------- //
    // Helps print the skiplist, print only one stack //
    public void printStack(Node stackBottom) {
        System.out.print(" " + stackBottom.value + "; ");
        if (stackBottom.up == null) {
            System.out.print("\n");
        }
        while (stackBottom.up != null) {
            stackBottom = stackBottom.up;
            System.out.print(" " + stackBottom.value + "; ");
            if (stackBottom.up == null) {
                System.out.print("\n");
                break;
            }
        }
    }

    // -------------------------------------------//
    // Deletes value from all levels if it exists //
    public void delete(skipList list, int key) {
        Node current = search(list, key);
        if (current.value == key) {
            while (current != null) {
                current.left.right = current.right;
                current.right.left = current.left;
                current = current.up;
            }
            System.out.println(key + " deleted");
            list.size--;
        } else {
            System.out.println(key + " integer not found - delete not successful");
        }
    }
}
