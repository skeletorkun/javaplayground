package com.company.leetcode;

public class AmazonMockInterviewOverlappingRectangles {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Rectangle {
        Point topRight;
        Point bottomLeft;

        public Rectangle(int x1, int y1, int x2, int y2) {
            topRight = new Point(x2, y2);
            bottomLeft = new Point(x1, y1);
        }

        boolean overlaps(Rectangle other) {
            if (topRight.y < other.bottomLeft.y || bottomLeft.y > other.topRight.y) {
                println("due to case 1");
                return false;
            }

            if (topRight.x < other.bottomLeft.x || bottomLeft.x > other.topRight.x) {
                println("due to case 2");
                return false;
            }

            if (topRight.x == bottomLeft.x || other.topRight.x == other.bottomLeft.x || topRight.y == bottomLeft.y || other.topRight.y == other.bottomLeft.y) {
                return false;
            }

            return true;
        }
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        Rectangle r1 = new Rectangle(rec1[0], rec1[1], rec1[2], rec1[3]);
        Rectangle r2 = new Rectangle(rec2[0], rec2[1], rec2[2], rec2[3]);

        return r1.overlaps(r2);

    }

    public static void println(Object s) {
        System.out.println(String.valueOf(s));
    }

    public static void main(String[] args) {

        AmazonMockInterviewOverlappingRectangles solution = new AmazonMockInterviewOverlappingRectangles();
//        println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        println(solution.isRectangleOverlap(new int[]{7, 8, 13, 15}, new int[]{10, 8, 12, 20}));

    }
}
