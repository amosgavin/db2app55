package com.asiainfo.sale.util;

import java.util.List;
import java.util.ArrayList;

/**
 * String[]������������㷨
 * User: robai
 * Date: 2009-7-23
 * Time: 17:43:39
 */
public class Combine {
    public ArrayList combine(String[] arrayString, int m) throws Exception {
        int n = arrayString.length;
        if (m > n) {
            throw new Exception("Ҫ��ȡ��������������ݱ�����");
        }
        ArrayList result = new ArrayList();

        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            bs[i] = 0;
        }
        //��ʼ��
        for (int i = 0; i < m; i++) {
            bs[i] = 1;
        }
        boolean flag = true;
        boolean tempFlag = false;
        int pos = 0;
        int sum = 0;
        //�����ҵ���һ��10��ϣ�Ȼ����01��ͬʱ��������е�1�ƶ�������������
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
            //����ߵ�1ȫ���ƶ�������������

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

            //����Ƿ����е�1���ƶ��������ұ�
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
