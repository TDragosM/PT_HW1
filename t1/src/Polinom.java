import java.util.HashMap;

public class Polinom {
     HashMap< Double , Double > valori=new HashMap<Double , Double>();///key=putere, al doilea e coef;

    Polinom ()
    {

    }

    public void addMonom(Double key , Double coef)
    {
        if(valori.containsKey(key))
        {
            valori.replace(key,coef+valori.get(key));
        }
        else {
            valori.put(key,coef);
        }

    }



}
