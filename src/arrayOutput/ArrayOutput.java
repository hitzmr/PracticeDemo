package arrayOutput;

public class ArrayOutput {
    boolean hFlag = true;
    boolean vFlag = true;
    int startIndex=0;
    public static void main(String[] args){
        ArrayOutput arrayOutput = new ArrayOutput();
        arrayOutput.startIndex = 1;
        int dimensions = 2;
        for(int k=0; k<2*dimensions-1; k++){
            arrayOutput.startIndex = arrayOutput.horizonOut(arrayOutput.startIndex, dimensions - (k)/2, arrayOutput.hFlag);
            arrayOutput.startIndex =arrayOutput.vertivalOutput(arrayOutput.startIndex, dimensions - (k+1)/2, arrayOutput.vFlag, dimensions);
        }

    }

    public int horizonOut(int startIndex, int loopTimes, boolean plus){
        int res=0;
        for(int i=0; i<loopTimes; i++){
            System.out.println(startIndex + i*(plus?1:-1));
            res = startIndex + i*(plus?1:-1);
        }
        hFlag = !hFlag;
        return res;
    }

    public int vertivalOutput(int startIndex, int loopTimes, boolean plus, int dimensions){
        int res=0;
        for(int j=0; j<loopTimes; j++){
            System.out.println(startIndex + j*(plus?1:-1)*dimensions);
            res = startIndex + j*(plus?1:-1)*dimensions;
        }
        vFlag = !vFlag;
        return res;
    }

}
