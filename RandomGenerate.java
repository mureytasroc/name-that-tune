import java.util.Random;
public class RandomGenerate {
    public static void main(String args[]) {
      //  GenerateImage.generate(majorMinor(320));
        StdAudio.play(progression1(440));

    }

   public static double[] majorMinor(double hz){
    double[] cMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] dMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] eMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] fMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] gMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] aMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] final1 = MusicLibrary.repeatNote(MusicLibrary.concatArray(cMaj,MusicLibrary.concatArray(fMaj,MusicLibrary.concatArray(dMin,MusicLibrary.concatArray(aMin,MusicLibrary.concatArray(gMaj,cMaj))))),4,0);
 	double[] final2 = ArrayTools.addArrays(final1,MusicLibrary.harmonic(460,2),.5,.5);
return final2;
}

 public static double[] randomG(double hz){
    int numNotes =(int)((10*Math.random()));
    System.out.println(numNotes);
    double[][] notes = new double[numNotes][];
    for(int j=0; j<numNotes; j++){
        double cLength =Math.random();
        System.out.println(cLength);
        double n = (double)StdAudio.SAMPLE_RATE;
        int length =(int)Math.ceil(n*cLength);
        notes[j] = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),cLength);
    }
    double final1[] =new double[0];
    for(int s=0; s<numNotes; s++){
     final1 = MusicLibrary.concatArray(final1, notes[s]);
    }
    final1 = MusicLibrary.repeatNote(final1,3,0);
    final1 = ArrayTools.addArrays(final1,MusicLibrary.harmonic(hz,3),.3,.3);
    return final1;
}

public static double[] progression1(double hz){
    double[] cMaj = MusicLibrary.majorChord(hz,1);
    double[] gMaj = MusicLibrary.majorChord(hz*Math.pow(2,7.0/12),1);
    double[] aMin = MusicLibrary.minorChord(hz*Math.pow(2,9.0/12),1);
    double[] fMaj = MusicLibrary.majorChord(hz*Math.pow(2,5.0/12),1);
    double[] final1 = MusicLibrary.repeatNote(MusicLibrary.concatArray(cMaj,MusicLibrary.concatArray(gMaj,MusicLibrary.concatArray(aMin,fMaj))),2,0);
return final1;
}

}