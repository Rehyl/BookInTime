package main.java.com.bookintime;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Appuntamento implements Serializable {
    
    // Dichiarazione degli Attributi: Definisci gli attributi (campi) privati della classe:
    private long id;
    private String nomeCliente;
    private String descrizione;
    private LocalDateTime dataOraInizio;
    private LocalDateTime dataOraFine;

    // Costruttore
    public Appuntamento(long id, String nomeCliente, String descrizione, LocalDateTime dataOraInizio, LocalDateTime dataOraFine) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.descrizione = descrizione;
        this.dataOraInizio = dataOraInizio;
        this.dataOraFine = dataOraFine;
    }

    // Costruttore di default
    public Appuntamento() {
    }

    // Getter methods
    public long getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public LocalDateTime getDataOraInizio() {
        return dataOraInizio;
    }

    public LocalDateTime getDataOraFine() {
        return dataOraFine;
    }

    // Setter methods
    public void setId(long id) {
        this.id = id;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setDataOraInizio(LocalDateTime dataOraInizio) {
        this.dataOraInizio = dataOraInizio;
    }

    public void setDataOraFine(LocalDateTime dataOraFine) {
        this.dataOraFine = dataOraFine;
    }

    // toString method
    @Override
    public String toString() {
        return "Appuntamento{" +
                "id=" + id +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataOraInizio=" + dataOraInizio +
                ", dataOraFine=" + dataOraFine +
                '}';
    }

}
