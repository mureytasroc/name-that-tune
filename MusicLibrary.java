public class MusicLibrary {
    public static void main(String args[]) {
        StdAudio.play(repeatNote(harmonic(440,1),5,2.0));
    } 

    //Ethan's methods 


      /*

    Function: harmonic
    Finished?: Yes

    */


public static double[] harmonic(double hz, double duration){
        double highOctavehz = hz * 2.0;
        double lowOctavehz = hz/2.0;
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*duration);
        double[] root= new double[length];
        double[] highOctave = new double[length];
        double[] lowOctave = new double[length];
        for (int i = 0; i < length; i++) {
                root[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }
        for (int i = 0; i < length; i++) {
                highOctave[i] = Math.sin(2 * Math.PI * i * highOctavehz / StdAudio.SAMPLE_RATE);
            }
        for (int i = 0; i < length; i++) {
                lowOctave[i] = Math.sin(2 * Math.PI * i * lowOctavehz / StdAudio.SAMPLE_RATE);
            }
        return add3Arrays(root, highOctave, lowOctave);
    }


    /*

    Function: Major Chord
    Finished?: Yes

    */


    public static double[] majorChord(double hz, double duration){
        double majorThirdHz = hz * Math.pow(2,4.0/12);
        double perfectFifthHz =hz * Math.pow(2,7.0/12);
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
        return add3Arrays(root, majorThird, perfectFifth);
    }

    /*

    Function: Minor Chord
    Finished?: Yes

    */
    
    public static double[] minorChord(double hz, double duration){
        double minorThirdHz = hz * Math.pow(2,3.0/12);
        double perfectFifthHz =hz * Math.pow(2,7.0/12);
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*duration);
        double[] root= new double[length];
        double[] minorThird = new double[length];
        double[] perfectFifth = new double[length];
        for (int i = 0; i < length; i++) {
                root[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }
        for (int i = 0; i < length; i++) {
                minorThird[i] = Math.sin(2 * Math.PI * i * minorThirdHz / StdAudio.SAMPLE_RATE);
            }
        for (int i = 0; i < length; i++) {
                perfectFifth[i] = Math.sin(2 * Math.PI * i * perfectFifthHz / StdAudio.SAMPLE_RATE);
            }
        return add3Arrays(root, minorThird, perfectFifth);
    }
    

    /*

    Function: pitch
    Finished?: Yes
    
    */


    public static double[] pitch(double hz, double duration){
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*duration);
        double[] root= new double[length];
        for (int i = 0; i < length; i++) {
                root[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
            }
            return root;
    }
    

    /*

    Function: sum
    Finished?: Yes
    
    */

    
    public static double[] sum(double[] a, double[] b, double wA, double wB){
        return ArrayTools.addArrays(a, b, wA, wB);
    }

    
    /*

    Function: fadeIn
    Finished?: Yes
    ISSUE: IF THE LENGTH OF THE INPUTED FUNCTION IS DIFFERENT THAN THE SECONDS TO FADE, IT WILL CUT OFF PART OF THE INITIAL ARRAY
    
    */


    public static double[] fadeIn(double[] note, double secondsToFade){
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*secondsToFade);
        double[] finalA= new double[length];
        for(int i=0;i<length;i+=1){
            finalA[i]=note[i]*((double)i/(n*secondsToFade));
        }
        return finalA;
    }


       /*

    Function: fadeOut
    Finished?: No
    ISSUE:
    
    */


    public static double[] fadeout(double[] note, double secondsToFade){
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*secondsToFade);
        double[] finalA= new double[length];
        for(int i=length;i>0;i-=1){
            
        }
        return finalA;
    }


 /*
 
 ADDED FUNCTION
    Function: repeatNote
    Finished?:YES
    Purpose: Repeats a note over and over again; (Basically sets a beat)
    Params:
        Note: the note to be repeated
        numRepeated: the number of times to repeat the note
        breakSeconds: the amound of times in between each note
    
*/

    public static double[] repeatNote(double[] note, int numRepeated, double breakSeconds){
        int n = (int)StdAudio.SAMPLE_RATE;
        int bS =(int)Math.ceil(breakSeconds);
        double[] breakArray= new double[bS*n];
        double[] repeatArray = concatArray(note,breakArray);
        double[] finalA = new double[1];
        for(int i=0; i<numRepeated; i+=1){
            finalA=concatArray(finalA,repeatArray);
        }

        return finalA;
    }




public static double[] concatArray(double[] arrayA, double[] arrayB){
        int length = arrayA.length + arrayB.length;
        double[] finalA= new double[length];
         for(int i=0; i<arrayA.length; i+=1){
            finalA[i]=arrayA[i];
        }
        for(int j=0; j<arrayB.length; j+=1){
            finalA[j+arrayA.length]=arrayB[j];
        }
        return finalA;
    }

    //Charley's methods vv
    
    
    
    
    
    
    public static double[] add3Arrays(double[] a,double[] b,double[] c){
        double[] h  = ArrayTools.addArrays(a, b, 0.5, 0.5);
        return ArrayTools.addArrays(c, h, .334, .666);
    }
    
    public static double[] trim(double[] a){
        int startI=0;
        int endI=0;
        boolean lead=true;
        for(int i=0;i<a.length;i++){
            if((a[i]!=0)&&(lead==true)){
                lead=false;
                startI=i;
            }
        }
        boolean end=true;
        for(int i=a.length-1;i>=0;i--){
            if((a[i]!=0)&&(end==true)){
                end=false;
                endI=i+1;
            }
        }
        double[] b = ArrayTools.copyArray(a,startI,endI);
        return b;
    }

    public static double[] echo(double[] a,double offset){
        int numOff=(int)Math.round(offset*(double)StdAudio.SAMPLE_RATE);
        double[] b = new double[a.length];
        for(int i=0;i<a.length;i++){
            if(i<a.length-numOff){
            b[i]=a[i+numOff];}
            else{
                b[i]=a[i-a.length+numOff];
            }
            
        }
        for(int i=0;i<a.length;i++){
            b[i]=((a[i]+b[i])/2);
        }
        return b;
    }

    
}