import java.util.Random;
public class RandomGenerate {
    public static void main(String args[]) {
      //  GenerateImage.generate(majorMinor(320));
        StdAudio.play(progression3(667));

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
 
    return final1;
}

public static double[] progression1(double hz, double tempo){
    double[] cMaj = MusicLibrary.majorChord(hz,tempo);
    double[] gMaj = MusicLibrary.majorChord(hz*Math.pow(2,7.0/12),tempo);
    double[] aMin = MusicLibrary.minorChord(hz*Math.pow(2,9.0/12),tempo);
    double[] fMaj = MusicLibrary.majorChord(hz*Math.pow(2,5.0/12),tempo);
    double[] final1 = MusicLibrary.repeatNote(MusicLibrary.concatArray(cMaj,MusicLibrary.concatArray(gMaj,MusicLibrary.concatArray(aMin,fMaj))),2,0);
return final1;
}


public static double[] progression2(double hz){
    double[] top = progression1(360,1);
    double[] base = MusicLibrary.majorChord(hz,top.length/StdAudio.SAMPLE_RATE);
    double[] final1 = ArrayTools.addArrays(top,base,.7,.3);
return final1;
}

public static double[] progression3(double hz){
    double[] top = MusicLibrary.repeatNote(progression1(550,1),4,0);
    double[] base = progression1(450,4);
    double[] final1 = ArrayTools.addArrays(top,base,.5,.5);
return final1;
}
}