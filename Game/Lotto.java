package Game;

import java.util.Random;
import java.util.Scanner;

public class Lotto  {
    public static void main(String[] args) {
        int[] winningNumber = new int[6];
        int[] inputNumber = new int[6];
        /*
        规则，五个红球，一个蓝球，红球在0-33之间，蓝球在0-16之间
        五红一蓝 特等奖
        五红 一等奖
        四红一蓝 特等奖
        四红 二等奖
        三红一蓝 一等奖
        三红 三等奖
        二红一蓝 二等奖
        二红 四等奖
        一红一蓝 三等奖
        一红 五等奖
        零红一蓝 四等奖
        零 感谢参与
        */
        CreatWinningNumbers(winningNumber);//创建随机中奖数
        for (int i = 0; i < winningNumber.length; i++) {
            System.out.print(winningNumber[i] + " ");
        }
        PeopleInputNumber(inputNumber);//输入要买得彩票数字
//        for (int i = 0; i < inputNumber.length - 1; i++) {
//            System.out.println(inputNumber[i]);
//        }
        JudgeNumber(winningNumber,inputNumber);//判断对应球的个数
    }

    public static void JudgeNumber(int[] winningNumber,int[] inputNumber) {
        int red_count = 0;//计算得奖球红球的个数
        //红球
        for(int i = 0; i < winningNumber.length - 1; i++){
            if(winningNumber[i] == inputNumber[i]){
                red_count++;
            }
        }
        int blue_count = 0;//蓝球的个数
        if(winningNumber[winningNumber.length - 1] == inputNumber[inputNumber.length - 1]){
            blue_count++;
        }
        switch(red_count){
            case 0 : if(blue_count == 0){
                        System.out.println("感谢参与");
                    }else{
                        System.out.println("恭喜你，四等奖");
                    }
                    break;
            case 1 : if(blue_count == 0){
                     System.out.println("恭喜你，五等奖");
                   }else{
                     System.out.println("恭喜你，三等奖");
                   }
                   break;
            case 2 : if(blue_count == 0){
                        System.out.println("恭喜你，四等奖");
                    }else{
                        System.out.println("恭喜你，二等奖");
                    }
                    break;
            case 3 : if(blue_count == 0){
                        System.out.println("恭喜你，三等奖");
                    }else{
                      System.out.println("恭喜你，一等奖");
                    }
                    break;
            case 4 : if(blue_count == 0){
                        System.out.println("恭喜你，四等奖");
                     }else{
                        System.out.println("恭喜你，特等奖");
                    }
                    break;
            case 5 : if(blue_count == 0){
                        System.out.println("恭喜你，一等奖");
                    }else{
                        System.out.println("恭喜你，特等奖");
                    }
                    break;
        }
    }
    public static void PeopleInputNumber(int[] inputNumber) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < inputNumber.length - 1; ) {
            System.out.print("请输入第" + (i + 1) + "个数：");
            int number = input.nextInt();
            if (number >= 0 && number <= 33) {
                inputNumber[i] = number;
                i++;
            } else {
                System.out.println("输入错误，请重新输入:");
            }
        }//红球
        while (true) {
            System.out.print("请输入第" + inputNumber.length + "个数：");
            int number = input.nextInt();
            if (number < 17 && number >= 0) {
                inputNumber[inputNumber.length - 1] = number;
                break;
            }
            else {
                System.out.println("输入错误，请重新输入:");
            }//蓝球
        }
    }

    public static void CreatWinningNumbers(int[] winningNumber) {
        Random randNumber = new Random();
        for (int i = 0; i < winningNumber.length - 1; i++) {
            winningNumber[i] = randNumber.nextInt(33);
        }//红球
        winningNumber[winningNumber.length - 1] = randNumber.nextInt(16);//蓝球

    }
}