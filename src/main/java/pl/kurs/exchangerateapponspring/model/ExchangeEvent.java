package pl.kurs.exchangerateapponspring.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeEvent)) return false;
        ExchangeEvent event = (ExchangeEvent) o;
        return Objects.equals(id, event.id) && Objects.equals(date, event.date) && Objects.equals(currencyFrom, event.currencyFrom) && Objects.equals(amountFrom, event.amountFrom) && Objects.equals(currencyTo, event.currencyTo) && Objects.equals(amountTo, event.amountTo) && Objects.equals(exchangeRate, event.exchangeRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, currencyFrom, amountFrom, currencyTo, amountTo, exchangeRate);
    }

    @Override
    public String toString() {
        return "ExchangeEvent{" +
                "id=" + id +
                ", date=" + date +
                ", currencyFrom='" + currencyFrom + '\'' +
                ", amountFrom=" + amountFrom +
                ", currencyTo='" + currencyTo + '\'' +
                ", amountTo=" + amountTo +
                ", exchangeRate=" + exchangeRate +
                '}';
    }
}
