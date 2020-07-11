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
        System.out.println(findNumberIn2DArrayA(matrix, targetTrue));
        System.out.println(findNumberIn2DArrayA(matrix, targetFalse));
        //二分算法

    }

    /**
     * 暴力遍历，时间复杂度n*m
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 目标值是否在二维数据中；true：是。false：否
     */
    public static boolean findNumberIn2DArrayA(int[][] matrix, int target) {
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

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        
        return false;
    }

}
