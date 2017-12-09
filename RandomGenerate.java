public class RandomGenerate {
    public static void main(String args[]) {
        StdAudio.play(majorMinor(440));
    } 

   public static double[] majorMinor(double hz){
    double[] reg = MusicLibrary.harmonic(hz,.5);
    double[] major = MusicLibrary.majorChord(hz,1);
    double[] minor = MusicLibrary.minorChord(hz,1);
    double[] regRepeat = MusicLibrary.repeatNote(reg,3,.2);
    double[] final1 = MusicLibrary.concatArray(regRepeat,major);
    double[] final2 = MusicLibrary.concatArray(final1,minor);
return final2;
}

}