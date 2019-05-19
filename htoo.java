
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class htoo {

    static int mult(int idx, String mol) {
        String num = "";
        boolean nonum = false;
        for (int a = idx + 1; !nonum && a < mol.length(); a++) {
            char o = mol.charAt(a);
            if (o >= '0' && o <= '9') {
                num += o;
            } else {
                nonum = true;
            }
        }
        if (num == "") {
            num = "1";
        }
        return Integer.parseInt(num);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner();
        PrintWriter pr = new PrintWriter(System.out);
        String mol = sc.next();
        int numeroMol = Integer.parseInt(sc.next());
        String molO = sc.next();
        TreeMap<Character, Integer> multiplicaciones = new TreeMap<>();
        for (int i = 0; i < mol.length(); i++) {
            char c = mol.charAt(i);
            if (c >= 'A' && c <= 'Z') {

                if (!multiplicaciones.containsKey(c)) {
                    multiplicaciones.put(c, mult(i, mol) * numeroMol);
                } else {
                    int llevo = multiplicaciones.get(c);
                    multiplicaciones.remove(c);
                    multiplicaciones.put(c, llevo +( mult(i, mol) * numeroMol));
                }

            }
        }

        TreeMap<Character, Integer> arbol = new TreeMap<>();
        for (int i = 0; i < molO.length(); i++) {
            char c = molO.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                if (!arbol.containsKey(c)) {
                    arbol.put(c, mult(i, molO));
                } else {
                    int llevo = arbol.get(c);
                    arbol.remove(c);
                    arbol.put(c, llevo + mult(i, molO));
                }

            }
        }
        int rta = Integer.MAX_VALUE;
        for (Character c : arbol.keySet()) {
            if (multiplicaciones.containsKey(c)) {
                int tmp = multiplicaciones.get(c) / arbol.get(c);
                if (tmp < rta) {
                    rta = tmp;
                }
            } else {
                rta = 0;
                break;
            }
        }

        pr.println(rta);
        pr.close();

    }

    static class Scanner {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        int spaces = 0;

        public String nextLine() throws IOException {
            if (spaces-- > 0) {
                return "";
            } else if (st.hasMoreTokens()) {
                return new StringBuilder(st.nextToken("\n")).toString();
            }
            return br.readLine();
        }

        public String next() throws IOException {
            spaces = 0;
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        public boolean hasNext() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return false;
                }
                if (line.equals("")) {
                    spaces = Math.max(spaces, 0) + 1;
                }
                st = new StringTokenizer(line);
            }
            return true;
        }
    }
}
