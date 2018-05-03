package com.asiainfo.sale.util;

import java.util.List;
import java.util.ArrayList;

/**
 * String[]数组排列组合算法
 * User: robai
 * Date: 2009-7-23
 * Time: 17:43:39
 */
public class Combine {
    public ArrayList combine(String[] arrayString, int m) throws Exception {
        int n = arrayString.length;
        if (m > n) {
            throw new Exception("要获取的组合数大于数据本身长度");
        }
        ArrayList result = new ArrayList();

        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            bs[i] = 0;
        }
        //初始化
        for (int i = 0; i < m; i++) {
            bs[i] = 1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        //首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
        do {
            sum = 0;
            pos = 0;
            tempFlag = true;
            result.add(copyArray(bs, arrayString, m));

            for (int i = 0; i < n - 1; i++) {
                if (bs[i] == 1 && bs[i + 1] == 0) {
                    bs[i] = 0;
                    bs[i + 1] = 1;
                    pos = i;
                    break;
                }
            }
            //将左边的1全部移动到数组的最左边

            for (int i = 0; i < pos; i++) {
                if (bs[i] == 1) {
                    sum++;
                }
            }
            for (int i = 0; i < pos; i++) {
                if (i < sum) {
                    bs[i] = 1;
                } else {
                    bs[i] = 0;
                }
            }

            //检查是否所有的1都移动到了最右边
            for (int i = n - m; i < n; i++) {
                if (bs[i] == 0) {
                    tempFlag = false;
                    break;
                }
            }
            if (tempFlag == false) {
                flag = true;
            } else {
                flag = false;
            }

        } while (flag);
        result.add(copyArray(bs, arrayString, m));

        return result;
    }

    private String[] copyArray(int[] bs, String[] arrayString, int m) {
        String[] result = new String[m];
        int pos = 0;
        for (int i = 0; i < bs.length; i++) {
            if (bs[i] == 1) {
                result[pos] = arrayString[i];
                pos++;
            }
        }
        return result;
    }

    private void print(List l) {
        for (int i = 0; i < l.size(); i++) {
            String[] a = (String[]) l.get(i);
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j] + "\t");
            }
            System.out.println();
        }
    }

    public void printAnyThree() throws Exception {
        String[] num = new String[]{"1", "2", "3", "4", "5", "6"};
        print(combine(num, 1));
    }


    public static void main(String[] args) {
        try {
            Combine s = new Combine();
            s.printAnyThree();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
