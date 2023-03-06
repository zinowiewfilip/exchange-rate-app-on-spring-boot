package pl.kurs.exchangerateapponspring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "exchange_events")
public class ExchangeEvent implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exchange_event")
    private Long id;

    @Column(name = "exchange_date", nullable = false, unique = true)
    private Timestamp date;
    @Column(length = 3)
    private String currencyFrom;
    private BigDecimal amountFrom;
    @Column(length = 3)
    private String currencyTo;
    private BigDecimal amountTo;
    @Column(precision = 19, scale = 6)
    private BigDecimal exchangeRate;

    public ExchangeEvent() {
    }

    public ExchangeEvent(Timestamp date, String currencyFrom, BigDecimal amountFrom, String currencyTo, BigDecimal amountTo, BigDecimal exchangeRate) {
        this.date = date;
        this.currencyFrom = currencyFrom;
        this.amountFrom = amountFrom;
        this.currencyTo = currencyTo;
        this.amountTo = amountTo;
        this.exchangeRate = exchangeRate;
    }


}
