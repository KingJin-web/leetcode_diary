package com.king.year_2021.M12;

import com.king.util.Helper;
import com.king.util.MyPrint;

/**
 * @program: leetcode
 * @description: 794. ��Ч�ľ�����Ϸ
 * https://leetcode-cn.com/problems/valid-tic-tac-toe-state/
 * @author: King
 * @create: 2021-12-09 23:19
 */
public class Test9 {

    //ִ����ʱ�� 13 ms , ������ Java �ύ�л����� 7.10% ���û� �ڴ����ģ� 36.9 MB , ������ Java �ύ�л����� 5.33% ���û�
    public boolean validTicTacToe(String[] board) {
        // �ж��ڹ����£�������������Ϸ�ܷ��γ�board
        int XCount = 0, OCount = 0;
        String[] all = new String[8]; // �洢8���ߵ����
        for(int i=0; i<3; i++){
            all[i] = board[i];
        }
        int idx = 3;
        for(int i=0; i<3; i++){
            String tmp = new String();
            for(int j=0; j<3; j++){
                if(board[i].charAt(j)=='X') XCount++;
                else if(board[i].charAt(j)=='O') OCount++;
                tmp += board[j].charAt(i);
            }
            all[idx++] = tmp;
        }
        all[idx++] = ""+board[0].charAt(0)+board[1].charAt(1)+board[2].charAt(2);
        all[idx] = ""+board[0].charAt(2)+board[1].charAt(1)+board[2].charAt(0);
        // Ϊ��Ҳ��
        if(OCount+XCount==0) return true;
            // O�ĸ������ᳬ��X����X�ĸ��������O������
        else if(OCount+2<=XCount || XCount<OCount) return false;
        else{
            int Count = XCount + OCount;
            if(Count%2==0){  // ż������˵��O��һ���߻���������������
                for(int i=0; i<8; i++){
                    if(all[i].equals("XXX")){
                        return false;
                    }
                }
            }else{  // ��������˵��X��һ���߻���������������
                for(int i=0; i<8; i++){
                    if(all[i].equals("OOO")){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test9 test9 = new Test9();
        //���룺board = ["XXX","   ","OOO"]
        //�����false
        MyPrint.print(test9.validTicTacToe(Helper.getArrays("XXX","   ","OOO")));
    }
}
