import java.io.*;
import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.Scanner;
import MyExceptions.*;

public class Menu{

    private static ArithmeticProgression solution = new ArithmeticProgression();

    public  static  void start(){
        mainMenu();
    }
    public static int readChoice(){
        Scanner scanner = new Scanner(System.in);
        int readed = -1;
        try {
            readed = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException ex){
            System.out.println("Вводите только значение меню, пожалуйста.");
            readed = readChoice();
        }
        return  readed;
    }

    private static void handleZeroStep() throws StepZeroException {
        if (solution.getStep() == 0){
            throw new StepZeroException("Step can't be zero");
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
                    solution.setStart(Integer.parseInt(scan1.nextLine()));
                    //Scanner scan2 = new Scanner(System.in);
                    solution.setStep(Integer.parseInt(scan1.nextLine()));
                    //Scanner scan3 = new Scanner(System.in);
                    solution.setNum(Integer.parseInt(scan1.nextLine()));

                    try{
                        handleZeroStep();
                    }
                    catch (StepZeroException e){
                        System.out.println("Шаг не может быть равен нулю (заменено на 1)");
                        solution.setStep(1);
                    }

                    break;

                case 2:
                    inputMenu();
                    break;
                case 3:
                    System.out.println("Запись в файл");
                    saveToFile();
                    break;
                case 4:
                    System.out.println("Чтение предыдущего рзультата");
                    getToFile();
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
    private static void saveToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testFile"))){
            oos.writeObject(solution);
            System.out.println(solution.toString());
        }catch (FileNotFoundException e){
            System.out.println("Плохое имя файла");
        }catch (IOException e){
            System.out.println("Ошибка записи");
        }
    }
    private static void getToFile(){
        ArithmeticProgression obj = new ArithmeticProgression();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testFile"))){
            obj = (ArithmeticProgression)ois.readObject();
        } catch (ClassNotFoundException e){
            System.out.println("Чтение постороннего класса");
        } catch (IOException ignored){}

        System.out.println(obj.toString());
    }
    private static void inputMenu(){
        int choice = -1;
        do {
            System.out.println("Меню выполнения задания");
            System.out.println("1 - Выполнить первое задание");
            System.out.println("2 - Выполнить второе задание");
            System.out.println("3 - Выполнить третье задание");
            System.out.println("4 - Выполнить четвертое задание");
            System.out.println("5 - Выход");
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