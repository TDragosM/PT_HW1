public class Monom {
    int coef;
    int putere;
    public Monom()
    {

    }
    public Monom (int coefs, int puters )
    {
        coef=coefs;
        putere=puters;
    }
    public Monom sum(Monom m2)
    {
        Monom rez=new Monom();
        if(m2.putere==this.putere) {
            rez.putere = this.putere;
            rez.coef=this.coef+m2.coef;
            return rez;
        }
        return rez;
    }
    public Monom scad(Monom m2)
    {
        Monom rez=new Monom();
        if(m2.putere==this.putere) {
            rez.putere = this.putere;
            rez.coef=this.coef-m2.coef;
            return rez;
        }
        return rez;
    }


}
