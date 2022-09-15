import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MNT{
    String macroname;
    int mdidx;

    MNT(String s,int i){
        macroname=s;
        mdidx=i;
    }
}

public class MacroPass1{

    static List<MNT>  mnt = new LinkedList<>();
    static List<String> mdt = new ArrayList<>();
    static List<String> ala = new ArrayList<>();
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
            }

    }
    static void process_def() throws IOException {
            String l = br.readLine();
            String tk[] = l.split(" ");
            mnt.add(new MNT(tk[0],mdtc));
            mntc++;
            String arg[] = tk[1].split(",");

            for (int i=0)
    }
        }


