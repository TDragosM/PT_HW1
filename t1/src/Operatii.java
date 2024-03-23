import java.util.HashSet;

public class Operatii {
    public static Polinom sumPolinom(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for (Double key : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key);
            if (p2.valori.containsKey(key)) {
                Double coef2 = p2.valori.get(key);
                result.valori.put(key, coef1 + coef2);
                p2.valori.remove(key);
            } else {
                result.valori.put(key, coef1);
            }
        }
        // Create a copy of p2.valori.keySet() to avoid ConcurrentModificationException
        for (Double key : new HashSet<>(p2.valori.keySet())) {
            result.valori.put(key, p2.valori.get(key));
        }
        return result;
    }


    public static Polinom scadPolinom(Polinom p1,Polinom p2)
    {
        Polinom result = new Polinom();
        for (Double key : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key);
            if (p2.valori.containsKey(key)) {
                Double coef2 = p2.valori.get(key);
                result.valori.put(key, coef1 - coef2);
                p2.valori.remove(key);
            } else {
                result.valori.put(key, coef1);
            }
        }
        // Create a copy of p2.valori.keySet() to avoid ConcurrentModificationException
        for (Double key : new HashSet<>(p2.valori.keySet())) {
            result.valori.put(key, -p2.valori.get(key));
        }
        return result;
    }

    public static Polinom inmultirePolinom(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();

        for (Double key1 : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key1);
            for (Double key2 : p2.valori.keySet()) {
                Double coef2 = p2.valori.get(key2);
                Double newKey = key1 + key2;
                Double newValue = coef1 * coef2;
                if (result.valori.containsKey(newKey)) {
                    result.valori.replace(newKey, result.valori.get(newKey) + newValue);
                } else {
                    result.valori.put(newKey, newValue);
                }
            }
        }
        return result;
    }

    public static Polinom impartirePolinom(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();

        for (Double key1 : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key1);
            for (Double key2 : p2.valori.keySet()) {
                Double coef2 = p2.valori.get(key2);
                Double newKey = key1 - key2;
                Double newValue = coef1 / coef2;
                if (result.valori.containsKey(newKey)) {
                    result.valori.replace(newKey, result.valori.get(newKey) + newValue);
                } else {
                    result.valori.put(newKey, newValue);
                }
            }
        }
        return result;
    }

    public static Polinom integrare(Polinom p1){
        Polinom result = new Polinom();
        for (Double key1 : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key1);
            Double newValue=coef1/(key1+1);
            Double newKey = key1+1 ;

            if (result.valori.containsKey(newKey)) {
                result.valori.replace(newKey, result.valori.get(newKey) + newValue);
            } else {
                result.valori.put(newKey, newValue);
            }
        }
        return result;
    }

    public static Polinom derivare(Polinom p1){
        Polinom result = new Polinom();
        for (Double key1 : p1.valori.keySet()) {
            Double coef1 = p1.valori.get(key1);
            Double newValue= key1 * coef1;
            Double newKey = key1-1;

            if (result.valori.containsKey(newKey)) {
                result.valori.replace(newKey, result.valori.get(newKey) + newValue);
            } else {
                result.valori.put(newKey, newValue);
            }
        }
        return result;
    }
}
