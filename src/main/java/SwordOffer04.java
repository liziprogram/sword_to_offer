/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */

public class SwordOffer04 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int targetTrue = 5;
        int targetFalse = 20;
        //暴力遍历
        System.out.println(findNumberIn2DArrayDirect(matrix, targetTrue));
        System.out.println(findNumberIn2DArrayDirect(matrix, targetFalse));
        //二分算法
        System.out.println(findNumberIn2DArrayBinarySearch(matrix, targetTrue));
        System.out.println(findNumberIn2DArrayBinarySearch(matrix, targetFalse));
        //有序对比搜索
        System.out.println(findNumberIn2DArraySortedSearch(matrix, targetTrue));
        System.out.println(findNumberIn2DArraySortedSearch(matrix, targetFalse));
    }

    /**
     * 解法一：暴力遍历，时间复杂度n*m
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 目标值是否在二维数据中；true：是。false：否
     */
    public static boolean findNumberIn2DArrayDirect(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法二：每行二分查找，时间复杂度，N*logM
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 目标值是否在二维数据中；true：是。false：否
     */
    public static boolean findNumberIn2DArrayBinarySearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            int start = 0;
            int end = ints.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (ints[mid] > target) {
                    end = mid - 1;
                } else if (ints[mid] < target) {
                    start = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 解法三：利用二维数组从左到右，从上往下有序的特征，从数组左下角开始搜索。
     * 从左下角开始遍历，当值小于 target 值时，向右搜索；大于 target 值时，向上搜索。
     * 时间复杂度:O(m+n).
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 目标值是否在二维数据中；true：是。false：否
     */
    public static boolean findNumberIn2DArraySortedSearch(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length; //数组有m行
        int n = matrix[0].length; //数组有n列
        int rows = m - 1;
        int col = 0;
        while (rows >= 0 && col < n) {
            if (matrix[rows][col] < target) {
                col++;
            } else if (matrix[rows][col] > target) {
                rows--;
            } else {
                return true;
            }
        }
        return false;
    }

}
