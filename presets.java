public class presets {
    public static void main(String[] args){;}
public static double[] alien(){
        return (MusicLibrary.addArrays(MusicLibrary.echo(MusicLibrary.HbeatGen(110, 8, 8, 60, (((double)2)/((double)3)),0.1),10000,0.3,0.05,0.5),MusicLibrary.HbeatGen(300, 8, 8, 50, (((double)1)/((double)4)),0.1)));
    }
    public static double[] electro(){
         return (MusicLibrary.addArrays(MusicLibrary.echo(MusicLibrary.HbeatGen(110, 8, 8, 60, (((double)2)/((double)3)),0.1),10000,0.3,0.05,0.5),MusicLibrary.randBeatFollow(0, 8, 120, (((double)2)/((double)3)),0.1)));//beatGen
    }
    public static double[][] randomBeatSad(double tempo){
        double[] z={440,493.883,277.183,329.628,369.994};
        double[] x={392.00,466.16,261.63,293.66,349.23};
        double[] c={349.23,392.00,415.30,466.16,261.63,277.18,311.13};
        double[] v={293.66,349.23,392.00,440.00,261.63};
        
        double[][] noties = {z,x,c,v};
        double[] notes = noties[MusicLibrary.randInt(0,3)];
        double[] notes2=MusicLibrary.shuffleNotes(notes,8);
        double[] startNotes=notes2;
        double[] a =MusicLibrary.noteBeatFollow(notes2, tempo, 0.5,0.8);
        double[] finalie=a;
        //start
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        double fnote=notes[0];
        double snote=notes[1];
        a =MusicLibrary.noteBeatFollow(notes2, tempo, 0.5,0.8);
        finalie=MusicLibrary.concatArrays(finalie,a);
        //end
        notes2[0]=notes[(int) Math.floor(Math.random() * notes.length)];
        notes2[1]=notes[(int) Math.floor(Math.random() * notes.length)];
        double repnote=notes2[notes2.length-1];
        notes2[notes2.length-1]=notes[(int) Math.floor(Math.random() * notes.length)];;
        a =MusicLibrary.noteBeatFollow(notes2, tempo, 0.5,0.8);
        finalie=MusicLibrary.concatArrays(finalie,a);
        //--
        notes2[0]=fnote;
        notes2[1]=snote;
        startNotes[startNotes.length-1]=repnote;
        a =MusicLibrary.noteBeatFollow(startNotes, tempo, 0.5,0.8);
        finalie=MusicLibrary.concatArrays(finalie,a);
        double[] ting = {notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)],notes[(int) Math.floor(Math.random() * notes.length)]};
        double[][] fin = {finalie,ting};
        return (fin);
    }


/*public static double[] randomBeatSadInput(){
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
*/
    public static double[] motorstrelski(){
        return ArrayTools.scaleArray(MusicLibrary.HbeatGen(10, 1, 1, 480, 0.5,0),30);
    }
    public static double[] motorstrelski90(){
        return ArrayTools.scaleArray(MusicLibrary.HbeatGen(10, 8, 8, 60, 0.5,0),30);

    }
}