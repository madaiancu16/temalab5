import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import exercitiul3.PerecheNumere;
import exercitiul3.MainAppex1;

public class TestPerecheNumere {

    @Test
    void test1_suntInFibonacci() {
        PerecheNumere pereche = new PerecheNumere(3, 5);
        assertTrue(pereche.suntInFibonacci(), "3 și 5 ar trebui să fie consecutive în Fibonacci");
    }

    @Test
    void test2_cmmmc() {
        PerecheNumere pereche = new PerecheNumere(6, 8);
        assertEquals(24, pereche.cmmmc(), "CMMMC-ul lui 6 și 8 ar trebui să fie 24");
    }

    @Test
    void test3_sumaCifrelorEgala() {
        PerecheNumere pereche = new PerecheNumere(12, 21);
        assertTrue(pereche.sumaCifrelorEgala(), "Suma cifrelor lui 12 și 21 ar trebui să fie egală");
    }

    @Test
    void test4_acelasiNumarCifrePare() {
        PerecheNumere pereche = new PerecheNumere(22, 44);
        assertTrue(pereche.acelasiNumarCifrePare(), "22 și 44 ar trebui să aibă același număr de cifre pare");
    }

    @Test
    void test5_cmmmc_diferit() {
        PerecheNumere pereche = new PerecheNumere(7, 9);
        assertFalse(pereche.cmmmc() == 63, "CMMMC-ul lui 7 și 9 nu ar trebui să fie 63");
    }
}

