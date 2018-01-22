import java.applet.*;
import java.net.*;
import java.io.*;
import javax.sound.sampled.*;
import java.util.*;


public class MusicLibrary {

    
    
    public static void main(String args[]) {
        
        /*try(  PrintWriter out = new PrintWriter( "filename.txt" )  ){
            byte[] catb=readByte("cat.wav");
    String sa = new String(catb.decode("utf-8") );
    out.println(sa);
}
        catch (FileNotFoundException ex)  
    {
        // insert code to run when exception occurs
    }*/

        int songTheme = randInt(1,2);
        
        //StdAudio.play(echo(concatArrays(concatArrays(majorChord(410,1),pitch(0,1)),minorChord(400,1)),10000,0.3,0.05,0.5));//echo
        //StdAudio.play(changeVol(pitch(440,1),0.01));//changeVol
        //StdAudio.play(fadeOut(pitch(440,2),1));//fadeOut
        //alien();
        //StdAudio.play(presets.motorstrelski90());
        //double[] a =randBeatFollow(0, 4, 120, 0.5,0.1);//below
        //StdAudio.play(addArrays(concatArrays(a,a),concatArrays(HbeatGen(100, 4, 4, 120, 0.5,0.1),HbeatGen(100, 4, 4, 120, 0.5,0.1))));//beatGen
        //StdAudio.play(ArrayTools.scaleArray(trim(shepardRisset(100, 1000, 50)),4)); //shepard risset glissando
        //HbeatGen(double hz, double ts1, double ts2, double bpm, double beatLenMod, double fadeRatio)

        //double[] b = concatArrays(beatGen(60, 8, 8, 60, (((double)2)/((double)3)),0.4),beatGen(110, 8, 8, 60, (((double)2)/((double)3)),0.4));
        //StdAudio.play(realBeat(60,1));
        double[] kick = concatArrays(StdAudio.read("Samplz/Kick/3new.wav"),rest(1,60));
        //StdAudio.play(fit(kick,60,0.125));//fit(kick,60,0.125)
        
        //StdAudio.play(fadeOut(majorChord(440,2),2));
        double[][] d = presets.randomBeatSad(60);
        double[] b = ArrayTools.scaleArray(d[0],0.2);
        double[] tones = d[1];
        double downval=2.0;
        
        double[] a = ArrayTools.scaleArray(concatArrays(realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme),realBeat(120,songTheme)),1);
        StdAudio.play(addArrays(b,a));//addArrays(b,a)
        //StdAudio.play(realBeat(100,fr,fr2));
        //StdAudio.play(realBeat(100,fr,fr2));
        //StdAudio.play(realBeat(100,fr,fr2));
        //StdAudio.play(riseInc(100, 5, 10));
        //StdAudio.play(readWav("wavtest.wav"));
        //StdAudio.play(read("catlow.wav"));
        //StdAudio.save("catplayed.wav",read("cat.wav"));
        //StdAudio.play(presets.motorstrelski());
    }
    
   /* public static double[] sampleBeatGen(String sample, double ts1, double ts2, double bpm, double beatLenMod, double fadeRatio) { //beatLenMod is length of actual sound in that beat (1 is lowest value for this)
        double barLen = (240 / ts2 / bpm) * ts1;
        int arrayLen = (int) Math.ceil(barLen * (double) StdAudio.SAMPLE_RATE);
        double noteLen = (240 / ts2 / bpm);
        int aNoteLen = (int) Math.floor(240 / ts2 / bpm * (double) StdAudio.SAMPLE_RATE);
        double[] b = new double[arrayLen];
        int posToFade = (int) Math.floor((double) 240 / ts2 / bpm * beatLenMod * fadeRatio * (double) StdAudio.SAMPLE_RATE);

        for (int noteNum = 0; noteNum < ts1; noteNum++) {
            for (int i = aNoteLen * noteNum; i < aNoteLen * (noteNum + 1); i++) {
                int poses = aNoteLen * (noteNum) + (int) Math.ceil((double) aNoteLen * beatLenMod) - i;
                if (i < poses + i) { //beat part
                    if (i < poses + i - posToFade) {
                        b[i] = Math.sin(2 * Math.PI * (i - aNoteLen * noteNum) * hz / StdAudio.SAMPLE_RATE);
                    } else {
                        b[i] = Math.sin(2 * Math.PI * (i - aNoteLen * noteNum) * hz / StdAudio.SAMPLE_RATE) * (1 - (((double)((i - aNoteLen * noteNum + poses - posToFade) - (posToFade))) / ((double) posToFade)));
                    }
                } else { //rest part
                    b[i] = 0;
                }
            }
        }
        return b;
    }*/
    
    
    public static double[] fit(double[] a,double tempo, double frac){
        double len=((double)240.0 / tempo*frac);
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * len);
        double[] b = new double[length];
        for(int i=0;i<length;i++){
            b[i]=a[i];
        }
        return b;
    }
    public static double[] rest(double barPortion,double bpm){
        double barLen=((double)240.0 / bpm);
        double restLen=barLen*barPortion;
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * restLen);
        double[] a= new double[length];
        for(int i=0;i<length;i++){
            a[i]=0;
        }
        return a;
    }
    
    public static double[] harmonic(double hz, double ts1,double ts2,double duration) {
        double highOctavehz = hz * 2.0;
        double lowOctavehz = hz / 2.0;
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * duration);
        double[] root = new double[length];
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
        return addArrays(root, highOctave, lowOctave);
    }



    public static double[] majorChord(double hz, double duration) {
        double majorThirdHz = hz * Math.pow(2, 4.0 / 12);
        double perfectFifthHz = hz * Math.pow(2, 7.0 / 12);
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * duration);
        double[] root = new double[length];
        double[] majorThird = new double[length];
        double[] perfectFifth = new double[length];
        for (int i = 0; i < length; i++) {
            root[i] = Math.pow(Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE),1);
        }
        for (int i = 0; i < length; i++) {
            majorThird[i] = Math.pow(Math.sin(2 * Math.PI * i * majorThirdHz / StdAudio.SAMPLE_RATE),1);
        }
        for (int i = 0; i < length; i++) {
            perfectFifth[i] = Math.pow(Math.sin(2 * Math.PI * i * perfectFifthHz / StdAudio.SAMPLE_RATE),1);
        }
        return addArrays(root, majorThird, perfectFifth);
    }

    

    public static double[] minorChord(double hz, double duration) {
        double minorThirdHz = hz * Math.pow(2, 3.0 / 12);
        double perfectFifthHz = hz * Math.pow(2, 7.0 / 12);
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * duration);
        double[] root = new double[length];
        double[] minorThird = new double[length];
        double[] perfectFifth = new double[length];
        for (int i = 0; i < length; i++) {
            root[i] = Math.pow(Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE),1);
        }
        for (int i = 0; i < length; i++) {
            minorThird[i] = Math.pow(Math.sin(2 * Math.PI * i * minorThirdHz / StdAudio.SAMPLE_RATE),1);
        }
        for (int i = 0; i < length; i++) {
            perfectFifth[i] = Math.pow(Math.sin(2 * Math.PI * i * perfectFifthHz / StdAudio.SAMPLE_RATE),1);
        }
        return addArrays(root, minorThird, perfectFifth);
    }



    public static double[] pitch(double hz, double duration) {
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * duration);
        double[] root = new double[length];
        for (int i = 0; i < length; i++) {
            root[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return root;
    }



    public static double[] sum(double[] a, double[] b, double wA, double wB) {
        return ArrayTools.addArrays(a, b, wA, wB);
    }




    public static double[] fadeIn(double[] note, double secondsToFade) {
        double n = (double) StdAudio.SAMPLE_RATE;
        int length = (int) Math.ceil(n * secondsToFade);
        double[] finalA = new double[length];
        for (int i = 0; i < length; i += 1) {
            finalA[i] = note[i] * ((double) i / (n * secondsToFade));
        }
        return finalA;
    }



    public static double[] repeatNote(double[] note, int numRepeated, double breakSeconds) {
        int n = (int) StdAudio.SAMPLE_RATE;
        int bS = (int) Math.ceil(breakSeconds);
        double[] breakArray = new double[bS * n];
        double[] repeatArray = concatArrays(note, breakArray);
        double[] finalA = new double[1];
        for (int i = 0; i < numRepeated; i += 1) {
            finalA = concatArrays(finalA, repeatArray);
        }

        return finalA;
    }



    public static double[] concatArrays(double[]...values) {
        int len = 0;
        int[] lens = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            len += values[i].length;
            lens[i] = values[i].length;
        }
        
        double[] b = new double[len];

        for (int i = 0; i < values.length; i++) {
            for (int e = 0; e < values[i].length; e++) {
                b[totalPositionsBefore(lens,i) + e] = values[i][e];
            }
        }
        return b;
    }
    
    public static int totalPositionsBefore(int[] a,int e){//adds total number of array positions before the given index value in an int array
        int val=0;
        for(int i=0;i<e;i++){
            val+=a[i];
        }
        return val;
    }



    public static void setArray(double[] a, double[] b) { //setted,setter
        if (a.length > b.length) {
            for (int i = 0; i < a.length; i++) {
                if (i < b.length) {
                    a[i] = b[i];
                } else {
                    a[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < a.length; i++) {
                a[i] = b[i];
            }
        }

    }



    public static double[] addArrays(double[]...values) {
        int len = 0;
        int[] lens = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            len += values[i].length;
            lens[i] = values[i].length;
        }
        double[] b = new double[len];

        int maxVal = 0;
        for (int i = 0; i < values.length; i++) {
            if (maxVal < values[i].length) {
                maxVal = values[i].length;
            }
        }
        double[][] newValues = new double[values.length][maxVal];
        for (int i = 0; i < values.length; i++) {
            if (values[i].length < maxVal) {
                for (int e = 0; e < maxVal; e++) {
                    if (e < values[i].length) {
                        newValues[i][e] = values[i][e];
                    } else {
                        newValues[i][e] = 0;
                    }
                }
            } else {
                for (int e = 0; e < maxVal; e++) {
                    newValues[i][e] = values[i][e];
                }
            }
        }
        double[] a = new double[maxVal];
        for (int i = 0; i < maxVal; i++) {
            for (int e = 0; e < newValues.length; e++) {
                a[i] += newValues[e][i];
            }
            a[i] /= newValues.length;
        }
        return a;
    }


    
    public static double[] trim(double[] a) {
        int startI = 0;
        int endI = 0;
        boolean lead = true;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] != 0) && (lead == true)) {
                lead = false;
                startI = i;
            }
        }
        boolean end = true;
        for (int i = a.length - 1; i >= 0; i--) {
            if ((a[i] != 0) && (end == true)) {
                end = false;
                endI = i + 1;
            }
        }
        double[] b = ArrayTools.copyArray(a, startI, endI);
        return b;
    }

    

    //StdAudio.play(echo(concatArrays(concatArrays(majorChord(441,1),pitch(0,1)),minorChord(400,1)),10000,0.3,0.05,0.5));
    public static double[] echo(double[] a, int offset, double decay, double endThreshold, double glideTime) {
        int extra = (int) Math.ceil(glideTime * (double) StdAudio.SAMPLE_RATE);
        double[] b = new double[a.length + offset + extra];
        for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        System.out.println(a.length + "    " + b.length + "\n\n\n");
        int e = 1;
        while (Math.pow(decay, e) > endThreshold) {
            if (a.length + offset * (e) > b.length) {
                break;
            } else {
                System.out.println(e * offset);
                for (int i = e * offset; i < (a.length + e * offset); i++) {
                    b[i] += a[i - e * offset] * Math.pow(decay, e);
                }
            }
            e++;
        }


        for (int i = 0; i < a.length; i++) {
            b[i] = ((a[i] + b[i]));
        }
        return b;
    }



    public static double[] fadeOut(double[] a, double secondsToFade) {
        int extra = (int) Math.ceil(secondsToFade * (double) StdAudio.SAMPLE_RATE);
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i < a.length - extra) {
                b[i] = a[i];
            } else {
                b[i] = a[i] * (1 - (((double)(i - (a.length - extra))) / ((double) extra)));
            }
        }
        return b;
    }


    
    public static double[] changeVol(double[] a, double volMod) {
        double[] b = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * volMod;
        }
        return b;
    }

    
    
    public static double[] beatGen(double hz, double ts1, double ts2, double bpm, double beatLenMod, double fadeRatio) { //beatLenMod is length of actual sound in that beat (1 is lowest value for this)
        double barLen = (240 / ts2 / bpm) * ts1;
        int arrayLen = (int) Math.ceil(barLen * (double) StdAudio.SAMPLE_RATE);
        double noteLen = (240 / ts2 / bpm);
        int aNoteLen = (int) Math.floor(240 / ts2 / bpm * (double) StdAudio.SAMPLE_RATE);
        double[] b = new double[arrayLen];
        int posToFade = (int) Math.floor((double) 240 / ts2 / bpm * beatLenMod * fadeRatio * (double) StdAudio.SAMPLE_RATE);

        for (int noteNum = 0; noteNum < ts1; noteNum++) {
            for (int i = aNoteLen * noteNum; i < aNoteLen * (noteNum + 1); i++) {
                int poses = aNoteLen * (noteNum) + (int) Math.ceil((double) aNoteLen * beatLenMod) - i;
                if (i < poses + i) { //beat part
                    if (i < poses + i - posToFade) {
                        b[i] = Math.pow(Math.sin(-2 * Math.PI * (i - aNoteLen * noteNum)*hz / StdAudio.SAMPLE_RATE),7);
                    } else {
                        b[i] = (Math.pow(Math.sin(-2 * Math.PI * (i - aNoteLen * noteNum)*hz / StdAudio.SAMPLE_RATE),7)) * (1 - (((double)((i - aNoteLen * noteNum + poses - posToFade) - (posToFade))) / ((double) posToFade)));
                    }
                } else { //rest part
                    b[i] = 0;
                }
            }
        }
        return b;
    }
    
        public static double[] beatGenSimple(double hz, double ts1, double ts2, double bpm, double beatLenMod, double fadeRatio) { //beatLenMod is length of actual sound in that beat (1 is lowest value for this)
        double barLen = (240 / ts2 / bpm) * ts1;
        int arrayLen = (int) Math.ceil(barLen * (double) StdAudio.SAMPLE_RATE);
        double noteLen = (240 / ts2 / bpm);
        int aNoteLen = (int) Math.floor(240 / ts2 / bpm * (double) StdAudio.SAMPLE_RATE);
        double[] b = new double[arrayLen];
        int posToFade = (int) Math.floor((double) 240 / ts2 / bpm * beatLenMod * fadeRatio * (double) StdAudio.SAMPLE_RATE);

        for (int noteNum = 0; noteNum < ts1; noteNum++) {
            for (int i = aNoteLen * noteNum; i < aNoteLen * (noteNum + 1); i++) {
                int poses = aNoteLen * (noteNum) + (int) Math.ceil((double) aNoteLen * beatLenMod) - i;
                if (i < poses + i) { //beat part
                    if (i < poses + i - posToFade) {
                        b[i] = Math.pow(Math.sin(2 * Math.PI * (i - aNoteLen * noteNum) * hz / StdAudio.SAMPLE_RATE),1);
                    } else {
                        b[i] = (Math.pow(Math.sin(2 * Math.PI * (i - aNoteLen * noteNum) * hz / StdAudio.SAMPLE_RATE),1)) * (1 - (((double)((i - aNoteLen * noteNum + poses - posToFade) - (posToFade))) / ((double) posToFade)));
                    }
                } else { //rest part
                    b[i] = 0;
                }
            }
        }
        return b;
    }

    
    
    /*public static double[] changeSpeed(double[] a,double speedMod){
        return speedMod;
    }
    public static double[] changeSpeedSamePitch(double[] a,double speedMod){
        return speedMod;
    }*/

    public static double[] HbeatGen(double hz, double ts1, double ts2, double bpm, double beatLenMod, double fadeRatio) {
        return addArrays(beatGen(hz, ts1, ts2, bpm, beatLenMod, fadeRatio), beatGen(hz, ts1, ts2, bpm, beatLenMod, fadeRatio), beatGen(hz, ts1, ts2, bpm, beatLenMod, fadeRatio));
    }


    
    public static double[] randBeatFollow(double hz, double noteNum, double bpm, double beatLenMod, double fadeRatio) { //beatLenMod is length of 
        //double[] notes={440,493.883,277.183,329.628,369.994};//penta
        double[] notes = {
            392,
            440,
            493.883,
            261.63,
            329.3,
            369.99
        };
        int aNoteLen = (int) Math.floor(240 / noteNum / bpm * (double) StdAudio.SAMPLE_RATE);
        double[] a = new double[(int) noteNum * aNoteLen];
        for (int i = 0; i < noteNum; i++) {
            double[] thisNote = HbeatGen(notes[(int) Math.floor(Math.random() * notes.length)], 1, 1, bpm * noteNum, (((double) 2) / ((double) 3)), fadeRatio);
            for (int e = aNoteLen * i; e < aNoteLen * (i + 1); e++) {
                a[e] = thisNote[e - aNoteLen * i];
            }

        }
        return a;
    }
    
    
    
    public static double[] noteBeatFollow(double[] freqs, double bpm, double beatLenMod, double fadeRatio) { //beatLenMod is length of 
        //double[] notes={440,493.883,277.183,329.628,369.994};//penta
        int noteNum = freqs.length;
        int aNoteLen = (int) Math.floor(240 / (double) noteNum / bpm * (double) StdAudio.SAMPLE_RATE);
        double[] a = new double[(int) noteNum * aNoteLen];
        for (int i = 0; i < noteNum; i++) {
            double[] thisNote = HbeatGen(freqs[i], 1, 1, bpm * (double) noteNum, (((double) 2) / ((double) 3)), fadeRatio);
            for (int e = aNoteLen * i; e < aNoteLen * (i + 1); e++) {
                a[e] = thisNote[e - aNoteLen * i];
            }

        }
        return a;
    }
    
    
    
    public static double[] riseInc(double startHz, double len, double inc) {
        int arrayLen = (int) Math.ceil(len * (double) StdAudio.SAMPLE_RATE);
        System.out.println(arrayLen);
        double[] a = new double[arrayLen];
        int incPosHigh = (int) Math.ceil(inc * (double) StdAudio.SAMPLE_RATE);
        System.out.println(incPosHigh);
        int incPos = (int) Math.floor(inc * (double) StdAudio.SAMPLE_RATE);
        int array1 = (int) Math.floor((double) arrayLen / (double) incPosHigh);
        System.out.println(array1);

        for (int i = 0; i < array1; i++) {
            for (int e = 0; e < incPos; e++) {
                a[incPos * i + e] = Math.sin(((double) 2.0) * ((double) Math.PI) * ((double)(incPos * i + e)) * (startHz + ((double)((double) i * (double) incPos) / (double) arrayLen) * startHz) / StdAudio.SAMPLE_RATE);
            }
        }
        return a;
    }
    
    
    
    public static double[] riseCont(double startHz, double len) {
        int arrayLen = (int) Math.ceil(len * (double) StdAudio.SAMPLE_RATE);
        double[] a = new double[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            a[i] = Math.sin(((double) 2.0) * ((double) Math.PI) * ((double)(i)) * (startHz + (((double) i) / ((double) arrayLen)) * startHz / 2) / StdAudio.SAMPLE_RATE);
        }
        return a;
    }
    
    
    
    public static double[] shepard(double startHz, double len) {
        int arrayLen = (int) Math.ceil(len * (double) StdAudio.SAMPLE_RATE);
        double[] a1 = new double[arrayLen];
        double[] a2 = new double[arrayLen];
        double[] a3 = new double[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            a1[i] = Math.sin(((double) 2.0) * ((double) Math.PI) * ((double)(i)) * (startHz + (((double) i) / ((double) arrayLen)) * startHz / 2) / StdAudio.SAMPLE_RATE);
        }
        for (int i = 0; i < arrayLen; i++) {
            a2[i] = Math.sin(((double) 2.0) * ((double) Math.PI) * ((double)(i)) * ((startHz * 2) + (((double) i) / ((double) arrayLen)) * startHz) / StdAudio.SAMPLE_RATE) * (arrayLen - i) / arrayLen;;
        }
        for (int i = 0; i < arrayLen; i++) {
            a3[i] = Math.sin(((double) 2.0) * ((double) Math.PI) * ((double)(i)) * (startHz / 2 + (((double) i) / ((double) arrayLen)) * startHz / 4) / StdAudio.SAMPLE_RATE) * (i) / arrayLen;
        }
        double[] a = addArrays(a1, a2, a3);
        /*for(int i=0;i<a.length;i++){
            a[i]/=3;
        }*/
        return a;
    }
    
    
    
    public static double[] shepardRisset(double startHz, double len, int shepards) {
        int arrayLen = (int) Math.ceil(len * (double) StdAudio.SAMPLE_RATE);
        double[] a = new double[arrayLen];
        double t = (double)(((double) len) / (double) shepards);
        int tint = (int) Math.floor(arrayLen / (double) shepards);
        for (int i = 0; i < shepards; i++) {
            double[] b = shepard(startHz, t);
            for (int e = 0; e < tint; e++) {
                a[i * tint + e] = b[e];
            }
        }
        return a;
    }
    
    
    
    public static double[] shuffleNotes(double[] freqs, int num) {
        double[] b = new double[num];
        for (int i = 0; i < num; i++) {
            b[i] = freqs[(int) Math.floor(Math.random() * freqs.length)];
        }
        return b;

    }
    
    
    
    public static double[] repeatBar(double[] bar, int num) {
        double[] a = new double[bar.length * num];
        for (int i = 0; i < num; i++) {
            for (int e = 0; e < bar.length; e++) {
                a[i * e] = bar[e];
            }
        }
        return a;
    }
    
    
    
    
    public static double[] read(String filename) {
        byte[] data = readByte(filename);
        int n = data.length;
        double[] d = new double[n/2];
        for (int i = 0; i < n/2; i++) {
            d[i] = ((short) (((data[2*i+1] & 0xFF) << 8) + (data[2*i] & 0xFF))) / ((double) Short.MAX_VALUE);
        }
        return d;
    }

    // return data as a byte array
    private static byte[] readByte(String filename) {
        byte[] data = null;
        AudioInputStream ais = null;
        try {

            // try to read from file
            File file = new File(filename);
            if (file.exists()) {
                ais = AudioSystem.getAudioInputStream(file);
                int bytesToRead = ais.available();
                data = new byte[bytesToRead];
                int bytesRead = ais.read(data);
                if (bytesToRead != bytesRead)
                    throw new IllegalStateException("read only " + bytesRead + " of " + bytesToRead + " bytes"); 
            }

            // try to read from URL
            else {
                URL url = StdAudio.class.getResource(filename);
                ais = AudioSystem.getAudioInputStream(url);
                int bytesToRead = ais.available();
                data = new byte[bytesToRead];
                int bytesRead = ais.read(data);
                if (bytesToRead != bytesRead)
                    throw new IllegalStateException("read only " + bytesRead + " of " + bytesToRead + " bytes"); 
            }
        }
        catch (IOException e) {
            throw new IllegalArgumentException("could not read '" + filename + "'", e);
        }

        catch (UnsupportedAudioFileException e) {
            throw new IllegalArgumentException("unsupported audio format: '" + filename + "'", e);
        }

        return data;
    }
    
   
   public static double[] realBeat(double tempo, int type){
       double randomSelector=Math.round(Math.random()*1);
       
       if(type==1){
       double[] a = ArrayTools.scaleArray(MusicLibrary.beatGenSimple(Math.random()*8, 1, 1, 480, 0.5,0),30);
       return concatArrays(a,a,a,a);}
       

       else if(type==2){
           double randomSelector2=randInt(1,3);
       if(randomSelector2==1){
       double[] a = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz, 1, 1, tempo*8, 0.7,0.8);
       double[] d = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz2, 1, 1, tempo*8, 0.7,0.8);
       double[] e = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.0625);//MusicLibrary.HbeatGen(hz, 1, 1, tempo*8*2, 0.7,0.8);
       double[] f = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.0625);//MusicLibrary.HbeatGen(hz2, 1, 1, tempo*8*2, 0.7,0.8);
       double[] b = concatArrays(a,a,d,a,rest(0.125,tempo),a,rest(0.25,tempo));
       double[] r = addArrays(b,concatArrays(rest(0.74,tempo),f,e,f));
       return r;
       }
       else if(randomSelector2==2){
           //double[] kick = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),60,0.125);
           double[] a = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz, 1, 1, tempo*8, 0.7,0.8);
       double[] d = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz2, 1, 1, tempo*8, 0.7,0.8);
       double[] b = concatArrays(a,a,d,a,rest(0.125,tempo),a,d,rest(0.125,tempo));
       return b;
       }
       
       else if(randomSelector2==3){
           double[] a = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz, 1, 1, tempo*8, 0.7,0.8);
       double[] d = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.125);//MusicLibrary.HbeatGen(hz2, 1, 1, tempo*8, 0.7,0.8);
       double[] e = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.03125);//MusicLibrary.HbeatGen(hz, 1, 1, tempo*8*4, 0.7,0.8);
       double[] f = fit(concatArrays(StdAudio.read("Samplz/Kick/"+randInt(1,4)+"new.wav"),rest(1,60)),tempo,0.03125);//MusicLibrary.HbeatGen(hz2, 1, 1, tempo*8*4, 0.7,0.8);
       double[] b = concatArrays(a,a,rest(0.375,tempo),a,d,rest(0.125,tempo));
        double[] r = addArrays(b,concatArrays(rest(0.25,tempo),f,f,f,a));
           return r;
       }
           else{
               return null;
           }
       }
       
       else{
           return rest(1,tempo);
       }
       
       
       
   }
    
        
    public static int randInt(int min, int max) {

    Random random = new Random();
return random.nextInt(max - min + 1) + min;
        
}
    
    
    
     /* private final int BUFFER_SIZE = 128000;
    private File soundFile;
    private AudioInputStream audioStream;
    private AudioFormat audioFormat;
    private SourceDataLine sourceLine;
    public static void play(String filename){
        try{
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(filename)));
            clip.start();
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);
            clip.close();
        }
        catch (Exception exc){
            exc.printStackTrace(System.out);
        }
    }*/
    
    
    
    
}