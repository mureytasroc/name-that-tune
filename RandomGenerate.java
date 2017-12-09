import java.util.Random;
public class RandomGenerate {
    public static void main(String args[]) {
        GenerateImage.generate(majorMinor(320));
        //StdAudio.play(majorMinor(320));

    }

   public static double[] majorMinor(double hz){
    double[] cMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] dMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] eMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] fMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] gMaj = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] aMin = MusicLibrary.majorChord(hz*Math.pow(2,(12*Math.random())/12),Math.random());
    double[] final1 = MusicLibrary.repeatNote(MusicLibrary.concatArray(cMaj,MusicLibrary.concatArray(fMaj,MusicLibrary.concatArray(dMin,MusicLibrary.concatArray(aMin,MusicLibrary.concatArray(gMaj,cMaj))))),4,0);

return final1;
}


}