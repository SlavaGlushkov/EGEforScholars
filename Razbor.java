package Task1921;

public class Razbor {
    public static void main(String[] args) {
        System.out.println("Задача 19");
        for (int i = 1; i < 129; i++) {
            if (gameplay(i,0))
                System.out.println(i);
        }
        System.out.println("Задача 20");
        for (int i = 1; i < 52; i++) {
            if (gameplay20(i,0))
                System.out.println(i);
        }
        System.out.println("Задача 21");
        for (int i = 1; i < 62; i++) {
            if (gameplay21(i,0))
                System.out.println(i);
        }
    }
    static boolean gameplay(int heap, int move){
        //Значение heap Петя не может выиграть за один ход, но Ваня побеждает ПРИ ЛЮБОМ ходе Петя
        if (heap >= 129 || move > 2)
            //Проверяем, что это был первый ход Вани. Если в куче 29, то должен быть Ваня!!!, т.е. move == 2
            return  move == 2;
        //Проверяем, что ход Пети
        if (move % 2 == 0)
            //Противник (Петя) умный. Поэтому Ваня должен победить как бы ни пошел Петя
            return gameplay(heap + 1, move + 1) && gameplay( heap * 2, move + 1);
        //А Ваня ходит так, чтобы выиграть. Как хочет.
        return gameplay(heap + 1, move + 1) || gameplay( heap * 2, move + 1);
    }
    static boolean gameplay20(int heap, int move){
        //Значение heap Петя может выиграть вторым ходом, не зависимо от Вани.
        if (heap >= 52 || move > 2)
            //Проверяем, что условия, что это был первый ход Вани. Если в куче 29, то должен быть Ваня!!!, т.е. move == 2
            return  move == 2;
        //Проверяем, что ход Вани
        if (move % 2 == 0)
            //Противник (Ваня) умный. Поэтому Петя должен победить как бы ни пошел Ваня
            return gameplay20(heap + 1, move + 1) ||     gameplay20( heap * 2, move + 1);
        //А Петя ходит так, чтобы выиграть. Как хочет.
        return gameplay20(heap + 1, move + 1) || gameplay20( heap * 2, move + 1);
    }
    static boolean gameplay21(int heap, int move){
        //У Вани есть выигрышная стратегия, позволяющая выиграть первым или вторым ходом при любой игре Пети И!
        //одновременно с первым условием у Вани нет стратегии, которая позволит ему гарантированно выиграть первым ходом.
        // move > 2, а не move > 4 говорит нам, что Ваня не гарантированно выигрывает первым ходом
        if (heap >= 62 || move > 4)
            //Проверяем, что усло вия, что это был первый или второй ход Вани. Если в куче 29, то должен быть Ваня!!!, т.е. move == 2,4
            return  move == 2 || move == 4;
        if (move % 2 == 0)
            //Противник (Петя) умный. Поэтому Ваня должен победить как бы ни пошел Петя
            return gameplay21(heap + 1, move + 1) && gameplay21( heap * 2, move + 1);
        //А Ваня ходит так, чтобы выиграть. Как хочет.
        return gameplay21(heap + 1, move + 1) || gameplay21( heap * 2, move + 1);
    }
}
