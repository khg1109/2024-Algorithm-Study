import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))
        ){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            if (H < 1 || H > 100 || W < 1 || W > 100) return;

            int i,j;
            for(i = 0; i < H; i++){
                String s = reader.readLine();
                int distance = -1;
                for(j = 0; j < W; j++){
                    if(s.charAt(j) == 'c'){
                        distance = 0;
                    }
                    else if(distance != -1){
                        distance++;
                    }
                    writer.write(distance+" ");
                }
                writer.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
