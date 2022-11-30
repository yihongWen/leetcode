package zyj.yihong.leetcode.random_select.nov;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// 2353. 设计食物评分系统
public class FoodRatings_M_2353 {

    Map<String,Object[]> nameMap = new HashMap<>();
    Map<String, TreeSet<Object[]>> serialMap = new HashMap<>();
    public FoodRatings_M_2353(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];
            Object[] nameMapValue = new Object[]{cuisine,rating};
            Object[] serialMapValue = new Object[]{food,rating};
            nameMap.putIfAbsent(food,nameMapValue);
            if (serialMap.get(cuisine)==null) {
                TreeSet treeSet = getTreeSet();
                treeSet.add(serialMapValue);
                serialMap.put(cuisine,treeSet);
            }else {
                TreeSet<Object[]> treeSet = serialMap.get(cuisine);
                treeSet.add(serialMapValue);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Object[] objects = nameMap.get(food);
        Object[] key = new Object[]{food,objects[1]};
        objects[1] = newRating;
        nameMap.put(food,objects);

        String serial = (String) objects[0];
        TreeSet<Object[]> treeSet = serialMap.get(serial);
        treeSet.remove(key);
        key[1] = newRating;
        treeSet.add(key);

    }

    public String highestRated(String cuisine) {
        TreeSet<Object[]> treeSet = serialMap.get(cuisine);
        Object[] info = treeSet.first();
        return (String) info[0];
    }

    private TreeSet getTreeSet(){
        TreeSet treeSet = new TreeSet((o1, o2) -> {
            Object[] o1Arr = (Object[]) o1;
            Object[] o2Arr = (Object[]) o2;
            int rating1 = (int) o1Arr[1];
            int rating2 = (int) o2Arr[1];
            if (rating2-rating1>0){
                return 1;
            }else if (rating1==rating2){
                String name1 = (String) o1Arr[0];
                String name2 = (String) o2Arr[0];
                return name1.compareTo(name2);
            }else {
                return -1;
            }
        });
        return treeSet;
    }

    public static void main(String[] args) {
//        ["FoodRatings","highestRated","highestRated","changeRating","highestRated","changeRating","highestRated"]
        String[] food = {"kimchi","miso","sushi","moussaka","ramen","bulgogi"};
        String[] serial ={"korean","japanese","japanese","greek","japanese","korean"};
        int[] rating = {9,12,8,15,14,7};
        FoodRatings_M_2353 foodRatings_m_2353 = new FoodRatings_M_2353(food, serial, rating);
        String s1 = foodRatings_m_2353.highestRated("korean");
        String s2 = foodRatings_m_2353.highestRated("japanese");
        foodRatings_m_2353.changeRating("sushi",16);
        String s3 = foodRatings_m_2353.highestRated("japanese");
        foodRatings_m_2353.changeRating("ramen",16);
        String s4 = foodRatings_m_2353.highestRated("japanese");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

    }
}
