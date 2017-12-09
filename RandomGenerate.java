import java.util.Random;
public class RandomGenerate {
    public static void main(String args[]) {
        GenerateImage.generate(majorMinor(440));

    }

   public static double[] majorMinor(double hz){
    double[] root1 = MusicLibrary.harmonic(300.25,3);
    double[] root2 = MusicLibrary.harmonic(500.99,3);
    double[] root3 = MusicLibrary.minorChord(200,3);
    double[] final1 = MusicLibrary.concatArray(root1,root2);
    double[] final2 = MusicLibrary.concatArray(final1,root3);
    double[] final3 = MusicLibrary.repeatNote(final2,5,0);

return final3;
}


}