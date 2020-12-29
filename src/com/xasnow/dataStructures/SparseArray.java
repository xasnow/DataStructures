package com.xasnow.dataStructures;

import java.util.Arrays;

/**
 * @author wucheng
 * @Date 2020/12/28
 */
public class SparseArray {
    public static void main(String[] args) {
        //原始的二维数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // 转为稀疏数组 先计算出不为0的值，构造数组的初始大小 int[sum+1][3], 首行是行，列，个数
        int sum = 0;
        for (int[] row : chessArr1) {
            System.out.println(Arrays.toString(row));
            for (int column : row) {
                if (column != 0) {
                    sum++;
                }
            }
        }
        System.out.println("有效值个数：" + sum);
        int[][] sparseArr = new int[sum + 1][3];

//        遍历二维数组，将非0的值存放到 sparseArr中
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //需要知道坐标，不适合用增强for循环
        int count = 1;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        // 还原稀疏数组为二维数据
        //1.根据首行初始化数组
        int[][] newArray = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2. 根据后面的行数对指定元素赋值
        for (int i = 1; i < sparseArr[0][2] + 1; i++) {
            newArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : newArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
