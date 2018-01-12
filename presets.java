public class presets {
    public static void main(String[] args){;}
public static double[] alien(){
        return (MusicLibrary.simpleAdd(MusicLibrary.echo(MusicLibrary.HbeatGen(110, 8, 8, 60, (((double)2)/((double)3)),0.1),10000,0.3,0.05,0.5),MusicLibrary.HbeatGen(300, 8, 8, 50, (((double)1)/((double)4)),0.1)));
    }
    public static double[] electro(){
         return (MusicLibrary.simpleAdd(MusicLibrary.echo(MusicLibrary.HbeatGen(110, 8, 8, 60, (((double)2)/((double)3)),0.1),10000,0.3,0.05,0.5),MusicLibrary.randBeatFollow(0, 8, 120, (((double)2)/((double)3)),0.1)));//beatGen
    }
    public static double[] randomBeatSad(){
        double[] notes={440,493.883,277.183,329.628,369.994};
        double[] notes2=MusicLibrary.shuffleNotes(notes,8);
        double[] startNotes=notes2;
        double[] a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        double[] finalie=a;
        //start
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        //end
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        //--
        a =MusicLibrary.noteBeatFollow(startNotes, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        return (finalie);
    }

public static double[] randomBeatSadInput(){
        double[] notes={440,493.883,277.183,329.628,369.994};
        double[] notes2=MusicLibrary.shuffleNotes(notes,8);
        double[] startNotes=notes2;
        double[] a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        double[] finalie=a;
        //start
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        //end
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        a =MusicLibrary.noteBeatFollow(notes2, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        //--
        a =MusicLibrary.noteBeatFollow(startNotes, 120, 0.5,0.9);
        finalie=MusicLibrary.concatArray(finalie,a);
        return (finalie);
    }
}