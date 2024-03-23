
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testOperatii {
    @Test
    public void addTest(){
        Polinom p1=new Polinom();
        p1.addMonom(5.0,2.0);
        Polinom p2=new Polinom();
        p2.addMonom(5.0,2.0);
        Polinom p3=new Polinom();
        p3.addMonom(5.0,4.0);
        assertEquals(Operatii.sumPolinom(p1,p2).valori,p3.valori);//adevarat
        p1.addMonom(1.0,2.0);
        p3.addMonom(1.0,2.0);
        //assertEquals(Operatii.sumPolinom(p1,p2).valori,p3.valori);//adevarat
        p2.addMonom(0.0,2.0);
        p3.addMonom(0.0,2.0);
        //assertEquals(Operatii.sumPolinom(p1,p2).valori,p3.valori);//adevarat
        Polinom p4=Operatii.scadPolinom(p1,p2);
        //assertEquals(Operatii.sumPolinom(p1,p2).valori,p4.valori);
    }
    @Test
    public void scadTest(){
        Polinom p1=new Polinom();
        p1.addMonom(5.0,2.0);
        Polinom p2=new Polinom();
        p2.addMonom(5.0,2.0);
        Polinom p3=new Polinom();
        p3.addMonom(5.0,0.0);
        assertEquals(Operatii.scadPolinom(p1,p2).valori,p3.valori);//adevarat
        p1.addMonom(1.0,2.0);
        p3.addMonom(1.0,2.0);
        //assertEquals(Operatii.scadPolinom(p1,p2).valori,p3.valori);//adevarat
        p2.addMonom(0.0,2.0);
        p3.addMonom(0.0,-2.0);
        //assertEquals(Operatii.scadPolinom(p1,p2).valori,p3.valori);//adevarat
        Polinom p4=Operatii.sumPolinom(p1,p2);
        //assertEquals(Operatii.scadPolinom(p1,p2).valori,p4.valori);
    }

    @Test
    public void multiplyTest(){
        Polinom p1=new Polinom();
        p1.addMonom(5.0,2.0);
        Polinom p2=new Polinom();
        p2.addMonom(5.0,2.0);
        Polinom p3=new Polinom();
        p3.addMonom(10.0,4.0);
        assertEquals(Operatii.inmultirePolinom(p1,p2).valori,p3.valori);//adevarat
        p1.addMonom(1.0,1.0);
        p3.addMonom(6.0,2.0);
        //assertEquals(Operatii.inmultirePolinom(p1,p2).valori,p3.valori);//adevarat
        p2.addMonom(0.0,2.0);
        p3.addMonom(0.0,-2.0);
        //assertEquals(Operatii.inmultirePolinom(p1,p2).valori,p3.valori);

    }

    @Test
    public void divideTest(){
        Polinom p1=new Polinom();
        p1.addMonom(5.0,2.0);
        Polinom p2=new Polinom();
        p2.addMonom(5.0,2.0);
        Polinom p3=new Polinom();
        p3.addMonom(0.0,1.0);
        assertEquals(Operatii.impartirePolinom(p1,p2).valori,p3.valori);//adevarat
        p1.addMonom(10.0,4.0);
        p3.addMonom(5.0,2.0);
        //assertEquals(Operatii.impartirePolinom(p1,p2).valori,p3.valori);//adevarat
        p2.addMonom(0.0,2.0);
        p3.addMonom(0.0,17.0);
        //assertEquals(Operatii.impartirePolinom(p1,p2).valori,p3.valori);

    }

}
