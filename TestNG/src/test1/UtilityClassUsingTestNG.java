package test1;

public class UtilityClassUsingTestNG extends UtilityClass2{
    int i;
    public UtilityClassUsingTestNG(int i) {
        super(i);
        this.i = i;
    }

    public int increment(){
        return i++;
    }

    public int decrement(){
        return i--;
    }

}
