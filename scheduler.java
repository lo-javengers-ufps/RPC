
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class scheduler {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter pr= new PrintWriter(System.out);
        int n = Integer.parseInt(sc.next());
        int c =  Integer.parseInt(sc.next());
        int clientes[] = new int[c];
        for (int i = 0; i < c; i++) {
            clientes[i] =  Integer.parseInt(sc.next());
        }
        int cajeros[] = new int[n];
        for (int i = 0; i < n; i++) {
            cajeros[i] = clientes[i];
             if(i<n-1){
            pr.print((i + 1) + " ");
             }else{
                  pr.print((i + 1) );
             }
        }
       if(c>n){
           pr.print(" ");
       }else{
           pr.println("");
       }
        for (int i = n; i < c; i++) {
            int idxCajeroMenor = 0;
            int tiempo = cajeros[0];
            for (int a = 1; a < n; a++) {
                if (tiempo > cajeros[a]) {
                    idxCajeroMenor = a;
                    tiempo = cajeros[a];
                }
            }
            cajeros[idxCajeroMenor] += clientes[i];
            if(i<c-1){
                pr.print((idxCajeroMenor+1) + " ");
            }else{
                pr.println((idxCajeroMenor+1));
            }
          
            
        }
        pr.close();
    }
    
static class Scanner {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer("");
	int spaces = 0;

	public String nextLine() throws IOException {
		if (spaces-- > 0) return "";
		else if (st.hasMoreTokens()) return new StringBuilder(st.nextToken("\n")).toString();
		return br.readLine();
	}

	public String next() throws IOException {
		spaces = 0;
		while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public boolean hasNext() throws IOException {
		while (!st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null) return false;
			if (line.equals("")) spaces = Math.max(spaces, 0) + 1;
			st = new StringTokenizer(line);
		}
		return true;
	}
}
}
