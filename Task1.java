/*
Задание. Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
1. Умножьте два числа и верните произведение в виде связанного списка.
2. Сложите два числа и верните сумму в виде связанного списка. Одно или два числа могут быть отрицательными.
Даны два Deque, цифры в обратном порядке.
[3,2,1] - пример Deque
[5,4,3]- пример второго Deque
1) 123 * 345 = 42 435
Ответ всегда - связный список, в обычном порядке
[4,2,4,3,5] - пример ответа
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Deque<Integer> dq = createDq();
        System.out.println("Первый Deque список: " + dq);

        Deque<Integer> dq2 = createDq();
        System.out.println("Второй Deque список: " + dq2);

        int num1 = getNums(dq);
        System.out.println("Число из 1-го Deque списка: " + num1);

        int num2 = getNums(dq2);
        System.out.println("Число из 2-го Deque списка: " + num2);

        System.out.println("Произведение чисел в виде связанного списка: " + multipliedList(num1, num2));
        System.out.println("Сумма чисел в виде связанного списка: " + summarizedList(num1, num2));
    }

    public static Deque<Integer> createDq() {
        Deque<Integer> dq = new ArrayDeque<>();
        Random rnd = new Random();

        for (int i = 0; i < 3; i++) {
            dq.addFirst(rnd.nextInt(8));
        }

        return dq;
    }

    public static Integer getNums(Deque<Integer> dqList) {
        int num = 0;
        int multi = 1;

        while (!dqList.isEmpty()) {
            num += dqList.removeFirst() * multi;
            multi *= 10;
        }

        return num;
    }

    public static LinkedList<Integer> multipliedList(int number, int number2) {
        LinkedList<Integer> multiLl = new LinkedList<>();
        int multiNum = number * number2;

        while (multiNum > 0) {
            multiLl.addFirst(multiNum % 10);
            multiNum /= 10;
        }

        return multiLl;
    }

    public static LinkedList<Integer> summarizedList(int number, int number2) {
        LinkedList<Integer> sumLl = new LinkedList<>();
        int sumNum = number + number2;

        while (sumNum > 0) {
            sumLl.addFirst(sumNum % 10);
            sumNum /= 10;
        }

        return sumLl;
    }
}