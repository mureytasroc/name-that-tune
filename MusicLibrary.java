public class MusicLibrary {
    public static void main(String args[]) {
        ArrayTools.printArray(majorChord(440,2));
    } 
   /** public static double[] harmonic(double root, double duration) { 
        int N = duration*StdAudio.SAMPLE_RATE; 
        double[] smaller=new double[N]; 
        double[] bigger=new double[N]; 
        double[] norm=new double[N]; 
        double low = root / 2; 
        for (double i = 0; i < duration; i+=1/StdAudio.SAMPLE_RATE){
            
     //       (Math.sin((2*Math.pi/root)*i)+Math.sin((2*Math.pi/root)*i)+Math.sin((2*Math.pi/root)*i))/3 }
        
        
    }
}


    public static double[] trim(){
        
    }
**/
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
}