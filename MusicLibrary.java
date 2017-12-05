public class MusicLibrary {
    public static void main(String args[]) {
        ArrayTools.printArray(majorChord(440,2));
    } 

    //Ethan's methods vv

    public static double[] harmonic(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a  = tone(hz, duration);
        double[] hi = tone(2*hz, duration);
        double[] lo = tone(hz/2, duration);
        double[] h  = sum(hi, lo, 0.5, 0.5);
        return ArrayTools.addArrays(a, h, 0.5, 0.5);
    }
    public static double[] majorChord(double hz, double duration){
        double majorThirdHz = hz * Math.pow(2,4/12);
        double perfectFifthHz =hz * Math.pow(2,7/12);
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*duration);
        double[] root= new double[length];
        double[] majorThird = new double[length];
        double[] perfectFifth = new double[length];
        for (int i = 0; i < length; i++) {
                root[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }
        for (int i = 0; i < length; i++) {
                majorThird[i] = Math.sin(2 * Math.PI * i * majorThirdHz / StdAudio.SAMPLE_RATE);
            }

        for (int i = 0; i < length; i++) {
                perfectFifth[i] = Math.sin(2 * Math.PI * i * perfectFifthHz / StdAudio.SAMPLE_RATE);
            }
        return ArrayTools.addArrays(ArrayTools.addArrays(root, majorThird,.5,.5),perfectFifth,2/3,1/3);
    }
    
    
    
    //Charley's methods vv
    
    /**public static double[] trim(){
        
    }**/
    
}