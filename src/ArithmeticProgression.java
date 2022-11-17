import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArithmeticProgression implements Serializable {

    private int start;
    private int step;
    private int num;
    public String message1, message2, message3, message4;

    public ArithmeticProgression(){
        this.start = 1;
        this.step = 2;
        this.num = 5;
    }
    public ArithmeticProgression(int start, int step, int num){
        this.start = start;
        this.step = step;
        this.num = num;
    }
    public ArithmeticProgression(ArithmeticProgression givenObject){
        this.start = givenObject.getStart();
        this.step = givenObject.getStep();
        this.num = givenObject.getNum();
    }

    // Setters
    public void setStart(int start){
        this.start = start;
    }
    public void setStep(int step){
        this.step = step;
    }
    public void setNum(int num){
        this.num = num;
    }
    // Getters
    public int getStart(){
        return this.start;
    }
    public int getStep(){
        return this.step;
    }
    public int getNum(){ return this.num; }


    private ArrayList<Integer> ListCreator(int start, int step, int num){
        ArrayList<Integer> result = new ArrayList<>();
        int current = start;
        result.add(current);
        for (int i = 0; i<num; i++){
            current += step;
            result.add(current);
        }
        return result;
    }


    public void getResult1(){
        message1 = "Result of first solution:";
        ArrayList<Integer> progression = ListCreator(start, step, num);
        for (int i = 0; i<num; i++){
            message1 += String.format(" %d", progression.get(i));
        }

    }

    public void getResult2(){
        message2 = "Result of second solution:";
        ArrayList<Integer> progression = ListCreator(start, step, num);
        int sum = 0;
        for (int i = 0; i<num; i++){
            sum += progression.get(i);
        }
        message2 += String.format(" %d", sum);
    }

    public void getResult3(){
        message3 = "Result of third solution:";
        ArrayList<Integer> progression = ListCreator(start, step, num);
        for (int i = 1; i<num; i++){
            if ( i % 3 == 0){
                message3 += String.format(" %d", progression.get(i-1));
            }
        }
        if ((num) % 3 == 0){
            message3 += String.format(" %d", progression.get(num-1));

        }
    }

    public void getResult4(){
        message4 = ("Result of forth solution: ");
        ArrayList<Integer> progression = ListCreator(start, step, num);

        int mid = num / 2, sum = 0;
        for (int i = 0; i<num; i++){
            if (i > mid){
                sum += progression.get(i);
            }
        }
        message4 += String.format("%d", sum);
    }

    public String toString(){
        return String.format("%d, %d, %d:\n%s\n%s\n%s\n%s",
                            this.start, this.step, this.num,
                            this.message1, this.message2, this.message3, this.message4);
    }

}
