/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radsort;

/**
 *
 * @author gansc
 */
import java.util.ArrayList;
public class RadSort {

 public static void main(String[] args) {
     
  //declare variable
  int maxOrder = 1000000;
  
  //create array
  int[] list = new int[1000000];
  
  //for loop to randomize the variables in array
  for (int i = 0; i < list.length; i++) {
   list[i] = (int) (Math.random() * maxOrder);
  }
  long time = System.currentTimeMillis();
  radixSort(list, maxOrder);
  //print out time it took to sort array
  System.out.println("Time = " + (System.currentTimeMillis() - time));
 }

 static void radixSort(int[] list, int maxOrder) {
  for (int order = 1; order < maxOrder; order *= 10) {
   @SuppressWarnings("unchecked")
   ArrayList<Integer>[] bucket = new ArrayList[10];
   
   // distribute elements from list to bucket
   for (int i = 0; i < bucket.length; i++) {
    bucket[i] = new java.util.ArrayList<>();
   }
   
   for (int i = 0; i < list.length; i++) {
    bucket[(list[i] / order) % 10].add(list[i]);
   }
   
   // moves elements from bucket back to list
   int k = 0;
   for (int i = 0; i < bucket.length; i++) {
    if (bucket[i] != null) {
     for (int j = 0; j < bucket[i].size(); j++)
      list[k++] = bucket[i].get(j);
    }
   }
  }
 }
}
