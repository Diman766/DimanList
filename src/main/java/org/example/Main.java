package org.example;

import org.example.model.DimanArrayList;
import org.example.model.DimanComparator;
import org.example.model.StringComp;

import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        List<Integer> list = new DimanArrayList<>();
        List<String> listStr = new DimanArrayList<>();

        listStr.add(0, "Lbvfy2");
        listStr.add(0, "Lbvf1");
        listStr.add(0, "Lbvfyj3");

        System.out.println(listStr);

        list.add(0, 3);
        list.add(1, 12);
        list.add(2,7);
        list.add(3, 3);
        list.add(4, 12);
        list.add(5,7);
        list.add(6, 3);
        list.add(7, 12);
        list.add(8,7);
        list.add(0, 3);
        list.add(0, 12);
        list.add(0,7);

        System.out.println(list);

        Comparator<String> dimanCompStr = new StringComp();
        listStr.sort(dimanCompStr);

        Comparator<Integer> dimanComp = new DimanComparator();
        list.sort(dimanComp);

        System.out.println(listStr);
        System.out.println(list);


    }


}