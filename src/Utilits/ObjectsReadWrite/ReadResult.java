package Utilits.ObjectsReadWrite;

import Utilits.ArithmeticProgression;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadResult {
    public static void getToFile(){
        ArithmeticProgression obj = new ArithmeticProgression();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testFile"))){
            obj = (ArithmeticProgression)ois.readObject();

        } catch (ClassNotFoundException e){
            System.out.println("Чтение постороннего класса");
        } catch (IOException e){
            System.out.println("Файл не найден");
        }

        System.out.println(obj.toString());
    }
}
