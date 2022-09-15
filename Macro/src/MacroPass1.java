import java.io.*;
import java.util.*;

class MNT{
    String macroname;
    int mdidx;

    MNT(String s,int i){
        macroname=s;
        mdidx=i;
    }
}

public class MacroPass1{

    static List<MNT>  mnt = new LinkedList<MNT>();
    static List<String> mdt = new ArrayList<String>();
    static List<String> ala = new ArrayList<String>();
    static int mdtc=0;
    static int mntc=0;
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {

            br = new BufferedReader(new FileReader("ip.txt"));
            bw = new BufferedWriter(new FileWriter("op.txt"));
            String line;

            while((line = br.readLine()) != null){
                if(line.equalsIgnoreCase("MACRO"))
                    process_def();
                else
                    bw.write(line+"\n");
            }
        System.out.println("ALA");
            showALA();
        System.out.println("MDT");
            showMDT();
        System.out.println("MNT");
            showMNT();
    }
    static void process_def() throws IOException {
            String l = br.readLine();
            String tk[] = l.split(" ");
            mnt.add(new MNT(tk[0],mdtc));
            mntc++;
            String arg[] = tk[1].split(",");

            for (int i=0;i < arg.length;i++){
                ala.add(arg[i]);
            }
            mdt.add(l);
            mdtc++;

            while (!l.equalsIgnoreCase("MEND")){
                int j=0,idx;
                String opLine = "";
                l = br.readLine();;

                if((idx = l.indexOf("&"))>0){
                    String word[] = l.split(" ");
                    opLine = opLine+" "+word[0];
                    String arg1[]=word[1].split(",");
                    opLine = opLine +" "+arg1[0];

                    while (j<arg1.length){
                        if(arg1[j].startsWith("&")){
                            idx = ala.indexOf(arg1[j]);
                            opLine = opLine+" #"+idx;
                        }
                        j++;
                    }
                }
                else
                    opLine=l;
                mdt.add(opLine);
                mdtc++;
            }
    }
    static void showALA() throws IOException {
        int i=0;
        BufferedWriter FWrite = new BufferedWriter(new FileWriter("ALA.txt"));
        for (String l:ala){
            System.out.println(i+" "+l);
            FWrite.write(i+" "+l+"\n");
            i++;
        }
        FWrite.close();
        System.out.println();
    } static void showMNT() throws IOException {
        int i=0;
        BufferedWriter FWrite = new BufferedWriter(new FileWriter("MNT.txt"));
        for (MNT l:mnt){
            System.out.println(i+" "+l.macroname+" "+l.mdidx);
            FWrite.write(i+" "+l.macroname+" "+l.mdidx+"\n");
            i++;
        }
        FWrite.close();
        System.out.println();
    } static void showMDT() throws IOException {
        int i=0;
        BufferedWriter FWrite = new BufferedWriter(new FileWriter("MDT.txt"));
        for (String l:mdt){
            System.out.println(i+" "+l);
            FWrite.write(i+" "+l+"\n");
            i++;
        }
        FWrite.close();
        System.out.println();
    }
}


