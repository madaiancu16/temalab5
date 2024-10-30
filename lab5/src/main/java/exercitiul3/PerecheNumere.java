package exercitiul3;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    public PerecheNumere() {}

    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    @Override
    public String toString() {
        return "(" + numar1 + ", " + numar2 + ")";
    }

    public boolean suntInFibonacci() {
        return esteFibonacci(numar1) && esteFibonacci(numar2) && Math.abs(indexFibonacci(numar1) - indexFibonacci(numar2)) == 1;
    }

    private boolean esteFibonacci(int n) {
        int a = 0, b = 1;
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b == n || a == n;
    }

    private int indexFibonacci(int n) {
        int a = 0, b = 1, index = 1;
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
            index++;
        }
        return (b == n) ? index : -1;
    }

    public int cmmdc() {
        int a = numar1, b = numar2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int cmmmc() {
        return (numar1 * numar2) / cmmdc();
    }

    public boolean sumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    public boolean acelasiNumarCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int n) {
        int count = 0;
        while (n != 0) {
            if ((n % 10) % 2 == 0) count++;
            n /= 10;
        }
        return count;
    }
}
