package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
        Integer[] arr3 = new Integer[]{2, 1, 1, 3, 4, 5};
        sort(arr);
    }

    public static Integer[] sort(Integer[] array) {
//        List<Integer> arr1 = new ArrayList();
//        List<Integer> arr2 = new ArrayList();
//
//        Arrays.sort(array);
//        int a = array.length / 2;
//        int mediana = array[a];
//        int count1 = 0;
//        int count2 = 0;
//        int count3 = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] > mediana) {
//                arr1.add(array[i]);
//                count1++;
//            }
//            else if (array[i] < mediana) {
//                arr2.add(array[i]);
//                count2++;
//            }
//            else if (array[i] == mediana) count3++;
//        }
//        System.out.println();
//        Collections.sort(arr1);
//        Collections.sort(arr2);
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < count3; i++) {
//            list.add(mediana);
//        }
//        for (int i = 0; i < arr1.size(); i++) {
//            list.add(arr1.get(i));
//        }
//        for (int i = arr2.size()- 1; i >= 0 ; i--) {
//            list.add(arr2.get(i));
//        }
//
//        array = list.stream().toArray(Integer[]::new);

//        for (Integer k : array) {
//            System.out.print(k + ", ");
//        }

        //return array;

        Arrays.sort(array);
        int len = array.length;

        int mediana = len % 2 != 0 ? array[len / 2] : (int)((array[len / 2] + array[len / 2 - 1]) / 2);

        Comparator<Integer> comp = (o1, o2) -> Math.abs(o1 - mediana) - Math.abs(o2 - mediana);

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(array));
        Collections.sort(list3, comp);
        Integer[] rez = list3.toArray(new Integer[list3.size()]);
        return rez;


    }
}
