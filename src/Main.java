import java.util.Random;
import java.util.Scanner;

public class Main {
    private static void Raznost (Integer[] mas1, Integer[] mas2 ) {
        Integer [] mas3 = new Integer[mas1.length];
        System.out.printf("Разность массивов: ");
        for (int i=0;i<mas1.length;i++){
            mas3[i] = mas2[i] - mas1[i];
            if (i == mas1.length-1){
                System.out.printf("%d; \n",mas3[i]);
            }else{
                System.out.printf("%d, ",mas3[i]);
            }
        }
        System.out.println("====================================");
    }
    private static Integer [] Hand_Ins(int size){
        Integer [] mas = new Integer[size];
        for (int i = 0; i < size;i++){
            System.out.printf("Введите %d элемент массива: ",i);
            mas[i] = Examination();
        }
        return mas;
    }
    private static Integer [] Insert_mas (int size, String answer){
        Random buff = new Random();
        Integer [] mas = new Integer[size];
        if (answer.equals("n") || answer.equals("no")){
            System.out.println("====================================");
            System.out.printf("Полученный массив: ");
            for (int i = 0; i < size;i++) {
                mas[i] = buff.nextInt(99);
                if (i == size - 1) {
                    System.out.printf("%d; \n", mas[i]);
                } else {
                    System.out.printf("%d, ", mas[i]);
                }
            }
        } else if (answer.equals("y") || answer.equals("yes")) {
            mas = Hand_Ins(size);
            System.out.println("====================================");
            System.out.printf("Полученный массив: ");
            for (int i = 0; i < size;i++){
                if (i == size - 1) {
                    System.out.printf("%d; \n", mas[i]);
                } else {
                    System.out.printf("%d, ", mas[i]);
                }
            }
        }
        System.out.println("====================================");
        return mas;
    }
    private static boolean isInt(String buff){
        try {
            Integer.parseInt(buff);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static Integer Examination(){
        Scanner read_line = new Scanner(System.in);
        boolean triger = true;
        while(triger){
            String chois = read_line.next();
            if (isInt(chois) == true){
                throw new RuntimeException("Введено не целочисленное значение.");
            }else {
                return Integer.parseInt(chois);
            }
        }
        return null;
    }
    private static void Chois_mas (String answer) {
        if (answer.equals("n") || answer.equals("no") || answer.equals("y") || answer.equals("yes")) {
            System.out.println("Введите размерность массива №1:");
            int size = Examination();
            Integer[] mas1 = Insert_mas(size, answer);
            System.out.println("Введите размерность массива №2:");
            size = Examination();
            if (mas1.length == size) {
                Integer[] mas2 = Insert_mas(mas1.length, answer);
                Raznost(mas1, mas2);
                ;
            } else {
                throw new RuntimeException("Размеры массивов не совпадают!!!");
            }
        }else{
            throw new RuntimeException("Введено неверное значение");
        }
    }

    public static void main(String[] args) {
        Scanner read_line = new Scanner(System.in);
        System.out.printf("Вводим массив сами или нет? (y/n) \n");
        Chois_mas(read_line.nextLine());
    }
}