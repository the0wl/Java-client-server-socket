package servidor;

public class Moeda {

    private final String code;
    private final String codein;
    private final String name;
    private final String high;
    private final String low;
    private final String varBid;
    private final String pctChange;
    private final String bid;
    private final String ask;
    private final String timestamp;
    private final String create_date;

    public Moeda(String code, String codein, String name, String high, String low, String varBid, String pctChange, String bid, String ask, String timestamp, String create_date) {
        this.code = code;
        this.codein = codein;
        this.name = name;
        this.high = high;
        this.low = low;
        this.varBid = varBid;
        this.pctChange = pctChange;
        this.bid = bid;
        this.ask = ask;
        this.timestamp = timestamp;
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "Cotação dolar USDBRL: code=" + code + ", codein=" + codein + ", name=" + name + ", high=" + high + ", low=" + low + ", varBid=" + varBid + ", pctChange=" + pctChange + ", bid=" + bid + ", ask=" + ask + ", timestamp=" + timestamp + ", create_date=" + create_date + '}';
    }
    
    // Retorno utilizado para cliente
    public String getDolarDia() {
        return "Dólar compra: "+bid+"¬Dólar venda: "+ask;
    }

}
