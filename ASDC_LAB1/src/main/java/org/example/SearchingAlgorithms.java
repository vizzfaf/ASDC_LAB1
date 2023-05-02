package org.example;

import java.util.ArrayList;

public class SearchingAlgorithms {
        public static int linear(Competitor competitor, ArrayList<Competitor> list){
            int index = 0;
            long before = System.nanoTime();
            for(Competitor competitor1 : list){
                if(competitor1.equals(competitor)){
                    System.out.println("Время поиска = " + (System.nanoTime() - before));
                    return index;
                }else {
                    index++;
                }
            }
            System.out.println("Время поиска = " + (System.nanoTime() - before));
            return -1;
        }

        public static int binary(Competitor competitor,ArrayList<Competitor> list){
            long before = System.nanoTime();
            int first = 0;
            int last = list.size() - 1;
            int k = 0;
            int max = (int) (Math.log(list.size()) / Math.log(2));
            while (first < last){
                if(k > max){
                    System.out.println("Время поиска = " + (System.nanoTime() - before));
                    return -1;
                }
                k++;
                int middle = (last - first) / 2;
                if(competitor.equals(list.get(middle))){
                    System.out.println("Время поиска = " + (System.nanoTime() - before));
                    return middle;
                }else if(competitor.getNumberInTable()<list.get(middle).getNumberInTable()){
                    last = middle -1;
                }else{
                    first = middle + 1;
                }
            }
            System.out.println("Время поиска = " + (System.nanoTime() - before));
            return -1;
        }
    public static int interpolation(ArrayList<Competitor> list, Competitor searched) {
        long before = System.nanoTime();
        int first= 0;
        int last = list.size() - 1;
        int maxOfIterations = (int) (Math.log(list.size()) / Math.log(2));
        int l = 0;

        while (first<= last) {
            if (l > maxOfIterations) {
                System.out.println("Время поиска = " + (System.nanoTime() - before));
                return -1;
            }
            l++;
            int k = list.get(last).getNumberInTable() - list.get(first).getNumberInTable();
            int z = searched.getNumberInTable() - list.get(first).getNumberInTable();
            int pos = first+ (last - first) / k * z;
            if (list.get(pos).equals(searched)) {
                System.out.println("Время поиска = " + (System.nanoTime() - before));
                return pos;
            } else if (list.get(pos).getNumberInTable() < searched.getNumberInTable()) {
                first= pos + 1;
            } else if (list.get(pos).getNumberInTable() > searched.getNumberInTable()) {
                last = pos - 1;
            }
        }
        return -1;
    }
}
