package org.example;
import org.example.Tree.Tree;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        File fileInput = new File("src/main/java/org/example/MOCK_DATA.csv");
        String stringInput = "Chickie;Hoggan;Madagascar;1989;47;IM/nChickie;Hoggan;Madagascar;1989;47;IM";
        ArrayList<Competitor> list = Competitor.inputFromFile(fileInput);
        Random random = new Random();
        Tree tree = new Tree();

        Collections.shuffle(list);
        int i = random.nextInt(51);
        Competitor competitor1 = new Competitor(list.get(i));
        System.out.println("\nLinear search");
        System.out.println("Expected time - O(n)");
        int j = SearchingAlgorithms.linear(competitor1,list);
        System.out.println("Searched competitor - " + competitor1);
        System.out.println("competitor we got - " + list.get(j));

        Collections.sort(list,(x,x2) -> x.getNumberInTable() - x2.getNumberInTable() );
        i = random.nextInt(51);
        competitor1 = list.get(i);
        System.out.println("\nBinary search");
        System.out.println("Expected time - O(n*log(n)");
        j = SearchingAlgorithms.binary(competitor1,list);
        System.out.println("Searched competitor - " + competitor1);
        System.out.println("competitor we got - " + list.get(j));

        i = random.nextInt(51);
        competitor1 = list.get(i);
        System.out.println("\nInterpolation search");
        System.out.println("Expected time - O(n*log(n)");
        j = SearchingAlgorithms.interpolation(list,competitor1);
        System.out.println("Searched competitor - " + competitor1);
        System.out.println("competitor we got - " + list.get(j));

        Collections.shuffle(list);
        for(Competitor competitor : list){
            tree.add(competitor);
        }
        i = random.nextInt(51);
        competitor1 = list.get(i);
        long before = System.nanoTime();
        boolean contains = tree.contains(competitor1);
        long after = System.nanoTime();
        System.out.println("\nSearching in my implementation of tree");
        System.out.println("Expected time - O(n*log(n)");
        System.out.println("Searched competitor - " + competitor1);
        System.out.println("Does is this competitor present in tree  - " + contains);
        System.out.println("Time of searching in nanos - " + (after - before));

    }
}