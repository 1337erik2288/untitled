package Utilits;

import java.util.Scanner;
import MyExceptions.*;
import Utilits.ObjectsReadWrite.*;

public class Menu{

    private static ArithmeticProgression solution = new ArithmeticProgression();

    public static void start(){
        mainMenu();
    }

    public static int readChoice(){
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;
        }
        catch (NumberFormatException e){
            return -1;
        }
    }

    private static void handleStep() throws StepZeroException {
        if (solution.getStep() == 0){
            throw new StepZeroException("Step can't be zero");
        }
    }
    private static void handleNum() throws LessZeroNumException {
        if (solution.getNum() <= 0){
            throw new LessZeroNumException("Num can't be less than zero");
        }
    }

    private static void mainMenu(){

        int choice = -1;
        do {
            System.out.println("Главное меню");
            System.out.println("1 - Задать новую прогрессию");
            System.out.println("2 - Выполнить задания");
            System.out.println("3 - Сохранить результаты программы в файл");
            System.out.println("4 - Прочитать из файла");
            System.out.println("5 - Выход");
            System.out.println("Введите номер выбраной комманды");

            choice = readChoice();
            switch (choice){
                case 1:
                    Scanner scan1 = new Scanner(System.in);
                    System.out.println("Введите стартовую точку, шаг  и количество шагов прогрессии");
                    try{
                        solution.setStart(Integer.parseInt(scan1.nextLine()));
                        solution.setStep(Integer.parseInt(scan1.nextLine()));
                        solution.setNum(Integer.parseInt(scan1.nextLine()));

                        handleStep();
                        handleNum();
                    }
                    catch (NumberFormatException e){
                        System.out.println("Значения вводятся по одному и должны быть целыми числами");
                    }
                    catch (StepZeroException e){
                        System.out.println("Шаг не может быть равен нулю (заменено на 1)");
                        solution.setStep(1);
                    }
                    catch(LessZeroNumException e){
                        System.out.println("Количество шагов не может меньше или равно нулю (заменено на 1)");
                        solution.setNum(1);
                    }
                    break;

                case 2:
                    inputMenu();
                    break;

                case 3:
                    System.out.println("Запись в файл");
                    WriteResult.saveToFile(solution);
                    break;

                case 4:
                    System.out.println("Чтение предыдущего результата");
                    ReadResult.getToFile();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }while (true);
    }

    private static void inputMenu(){

        int choice = -1;
        do {
            System.out.println("Меню выполнения задания");
            System.out.println("1 - Выполнить первое задание");
            System.out.println("2 - Выполнить второе задание");
            System.out.println("3 - Выполнить третье задание");
            System.out.println("4 - Выполнить четвертое задание");
            System.out.println("5 - Назад");
            System.out.println("Введите номер выбраной комманды");
            choice = readChoice();

            switch (choice){
                case 1:
                    solution.getResult1();
                    System.out.println(solution.message1);
                    break;
                case 2:
                    solution.getResult2();
                    System.out.println(solution.message2);
                    break;
                case 3:
                    solution.getResult3();
                    System.out.println(solution.message3);
                    break;
                case 4:
                    solution.getResult4();
                    System.out.println(solution.message4);
                    break;
                case 5:
                    choice = 0;
                    break;
                default:
                    System.out.println("Нет такого пункта меню");
                    break;
            }
        }while (choice != 0);
    }
}