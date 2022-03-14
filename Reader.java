import java.io.File;
import java.util.Arrays;
import java.io.*;

public class Reader {

    public static String location = "C:\\Users\\Alvaro\\Desktop\\example_inputfile.txt";
    public static int x0;
    public static int y0;
    public static int xt;
    public static int yt;
    public static double r;
    public static double muk;
    public static double mus;

    public static double x;
    public static double y;
    public static double heightProfile;

    public static double muks;
    public static double muss;

    public static void main(String[] args) throws Exception {

        int valuesIndex = 0;
        String[] values = new String[12];
        Arrays.fill(values, "");

        File file = new File(location);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int index = 0;

        while ((st = br.readLine()) != null) {
            index = 0;
            while (st.charAt(index) != '=') {
                index++;
            }
            if (st.charAt(index) == '=') {
                index += 2;
                while (index < st.length()) {
                    values[valuesIndex] += st.charAt(index);
                    index++;
                }

                valuesIndex++;
            }
        }

        for (int i = 0; i < values.length; i++) {
            // System.out.println(values[i]);
        }

        x0 = Integer.parseInt(values[0]);
        y0 = Integer.parseInt(values[1]);
        xt = Integer.parseInt(values[2]);
        yt = Integer.parseInt(values[3]);
        r = Double.parseDouble(values[4]);
        muk = Double.parseDouble(values[5]);
        mus = Double.parseDouble(values[6]);

        System.out.println(x0);

    }
}