package Task_2;

import java.util.Scanner;

public class Task_2 {

    public static void Insert_number(){
        Scanner read_line = new Scanner(System.in);
        System.out.printf("Введите дробное число (тип float). Если ввести слово «null» товведёться пустое значение: \n");
        String answer = read_line.next();
        Check_float(answer);
    }

    private static void Check_float (String answer){
        if (answer.equals("null")){
            answer = null;
        }
            try {
                int i = Integer.parseInt(answer);
                System.out.printf("Введено значение типа Integer. Пожалуйста повторите попытку \n");
                Insert_number();
            }catch (NumberFormatException e){
                try {
                    System.out.println(Double.parseDouble(answer));
                } catch (NullPointerException exc) {
                    System.out.println("Введено пустое значение пожалуйста повторите попытку (" + exc.getClass().getSimpleName() +") \n");
                    Insert_number();
                }catch (NumberFormatException exc){
                    System.out.printf("Введено неверное значение. Пожалуйста повторите попытку (" + exc.getClass().getSimpleName() +") \n");
                    Insert_number();
                }
            }
    }
}
