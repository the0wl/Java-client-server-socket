
package servidor;

import java.util.List;

public class Dados {

    private List<Moeda> moeda;

    @Override
    public String toString() {
        return moeda.toString();
    }
    
    
    
    public Dados(List<Moeda> moeda) {
        this.moeda = moeda;
    }

}