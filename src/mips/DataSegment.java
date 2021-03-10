
package mips;

public class DataSegment {
   
    private static DataSegment datasegment;
    public String[] data;

    public DataSegment() {
        data = new String[1024];
         for (int i = 0; i < data.length; i++)
            data[i] = Parser.toBitString(0,1);
       
    }
   
    public static synchronized DataSegment getInstance() {
        if (datasegment == null)
            datasegment = new DataSegment();
        return datasegment;
    }
   
    public int read(int Num) {
        return Integer.parseInt(data[Num]);
    }
    
    public void write(int Num, int value) {
        data[Num] = Integer.toString(value);
    }
    
    public static int getdata(String data) {
       
         return Integer.parseInt(data);
    }
   
    public String toString () {
        String str = "";

        for (int i = 0; i < data.length; i++) {
            if (i > 0)
                str += "\n";

            str += ((i < 10) ? "0" : "") + i + " : " + data[i];
        }
        return str;
    }
    
}

