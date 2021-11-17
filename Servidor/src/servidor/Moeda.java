package servidor;

public class Moeda {

    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private String ask;
    private String timestamp;
    private String create_date;

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
    
    public String getDolarDia() {
        return "Dólar compra: "+bid+" e Dólar venda: "+ask;
    }

}
