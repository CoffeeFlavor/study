package chapter01.node1_1_1;


import algs4.In;
import algs4.StdIn;
import algs4.StdOut;

import java.util.Arrays;

/**
 * @author : jennie
 * @date: 2019/6/16
 * @Time: 14:59
 */
public class BinarySearch {

    public static int rank(int key,int[] a){
        int lo=0;
        int hi=a.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;
            if (key<a[mid]) hi=mid-1;
            else if (key>a[mid]) lo=mid+1;
            else return mid;
        }
        return -2;
    }

    public static  void main(String[] args){
        int[] whileList= In.readInts(args[0]);
        Arrays.sort(whileList);
        while (!StdIn.isEmpty()){
            int key=StdIn.readInt();
            if (rank(key,whileList)==-1){
                StdOut.println(key);
            }
        }
    }
}
