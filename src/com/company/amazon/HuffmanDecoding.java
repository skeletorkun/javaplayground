package com.company.amazon;

public class HuffmanDecoding {


    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String s, Node root) {

        StringBuilder decodedString = new StringBuilder();
        Node current = root;

        int i = 0;
        do{

            if (Integer.parseInt(String.valueOf(s.charAt(i))) == 0) {
                current = current.left;
            } else {
                current = current.right;
            }
            i++;

            // is leaf
            if (current.right == null && current.left == null) {
                decodedString.append(current.data);
                current = root;
            }
        }while (i < s.length());

        System.out.println(decodedString.toString());

    }


    public static void main(String[] args) {

        HuffmanDecoding solution = new HuffmanDecoding();

        String s = "1001011";
        solution.decode(s, null);

    }
}
