package com.mistake.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        // 先创建一个原始的二维数组 11*11

        // 0:表示没有棋子,1:表示 黑子 2:表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;
        // 输出原始的二维数据
        System.out.println("原始的二维数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // 将二维数组 转 系数数组的思路
        // 1.先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        // 给稀疏数组复制
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        // 遍历二维数组 将非零的值存放到 稀疏数组中去
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];

                }
            }
        }
        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",
                    sparseArr[i][0],
                    sparseArr[i][1],
                    sparseArr[i][2]);


        }
        System.out.println();
        // 将稀疏数组 => 恢复成原始的二维数组
        // 1.读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        // 2.读取稀疏数组后几行的数据(从第二行开始),并赋给 原始的二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2 [sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }


}
