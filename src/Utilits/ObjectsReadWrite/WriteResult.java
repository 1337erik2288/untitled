package Utilits.ObjectsReadWrite;

import Utilits.ArithmeticProgression;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteResult {
    public static void saveToFile(ArithmeticProgression obj){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testFile"))){
            oos.writeObject(obj);
            System.out.println(obj.toString());

        } catch (FileNotFoundException e){
            System.out.println("Плохое имя файла");
        } catch (IOException e){
            System.out.println("Ошибка записи");
        }
    }
}
