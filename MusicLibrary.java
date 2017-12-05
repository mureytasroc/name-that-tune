public class MusicLibrary { 
    public static void main(String args[]) {;} 
    public static double[] harmonic(double root, double duration) { 
        int N = duration*StdAudio.SAMPLE_RATE; 
        double[] smaller=new double[N]; 
        double[] bigger=new double[N]; 
        double[] norm=new double[N]; 
        double low = root / 2; 
        for (double i = 0; i < duration; i+=1/StdAudio.SAMPLE_RATE){
            
            (Math.sin((2*Math.pi/root)*i)+Math.sin((2*Math.pi/root)*i)+Math.sin((2*Math.pi/root)*i))/3 }
        
        
    }
    public static double[] trim(){
        
    }
}