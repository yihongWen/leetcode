package zyj.yihong.leetcode.random_select;

import lombok.Data;

import java.util.*;

public class GetImportance_M_690 {
    public int getImportance(List<Employee> employees, int id) {
        employees.sort((Comparator.comparingInt(o -> o.id)));
        int ans = 0;
        Employee cur;
        Queue<Integer> idQueue = new LinkedList<>();
        while ((cur = binarySearch(employees,id))!=null){
            ans+=cur.importance;
            if (cur.subordinates!=null){
                idQueue.addAll(cur.subordinates);
            }
            if (idQueue.isEmpty()){
                return ans;
            }
            id  = idQueue.poll();
        }
        return ans;
    }

    public Employee binarySearch(List<Employee> employees,int id){
        int left = 0;
        int right = employees.size()-1;
        while (left<=right){
            int mid = left+((right-left)>>1);
            if (employees.get(mid).id>id){
                right = mid-1;
            }else if (employees.get(mid).id==id){
                return employees.get(mid);
            }else {
                left = mid+1;
            }
        }
        return null;
    }


    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    public static void main(String[] args) {
        GetImportance_M_690 getImportance_m_690 = new GetImportance_M_690();
//        [[1,10,[2,3,4]],[2,-1,[]],[3,-2,[]],[4,-3,[]]]
        Employee employee = new Employee();
        employee.id = 1;
        employee.importance =10;
        employee.subordinates = Arrays.asList(2,3,4);

        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.importance =-1;
        employee1.subordinates = new ArrayList<>();

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.importance =-2;
        employee2.subordinates = new ArrayList<>();


        Employee employee3 = new Employee();
        employee3.id = 4;
        employee3.importance =-3;
        employee3.subordinates = new ArrayList<>();

        List<Employee> employees = Arrays.asList(employee,employee1,employee2,employee3);
        int importance = getImportance_m_690.getImportance(employees, 1);
        System.out.println(importance);
    }
}
