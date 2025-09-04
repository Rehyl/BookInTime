package main.java.com.bookintime.model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe che rappresenta un'appuntamento in un sistema di gestione dei programmi.
 * Contiene gli attributi e i metodi necessari per definire l'identità, la data e l'ora di un appuntamento,
 * nonché il nome e il cognome del cliente. Implementa l'interfaccia Serializable per essere serializzabile
 * in contesti di persistenza.
 *
 * @author Marco
 * @version 1.0
 */
public class Appuntamento implements Serializable {
    
    /**
     * Identificatore univoco della prenotazione.
     */
    private int id;
    /**
     * Data dell'appuntamento.
     */
    private LocalDate data;
    /**
     * Ora di inizio dell'appuntamento.
     */
    private LocalTime ora;
    /**
     * Nome del cliente.
     */
    private String nome;
    /**
     * Cognome del cliente.
     */
    private String cognome;

    /**
     * Costruttore per creare un nuovo appuntamento con tutti i dettagli.
     * @param id L'identificatore univoco dell'appuntamento.
     * @param data La data dell'appuntamento.
     * @param ora L'ora dell'appuntamento.
     * @param nome Il nome del cliente.
     * @param cognome Il cognome del cliente.
     */
    public Appuntamento(int id, LocalDate data, LocalTime ora, String nome, String cognome) {
        this.id = id;
        this.data = data;
        this.ora = ora;
        this.nome = nome;
        this.cognome = cognome;
    }

    /**
     * Costruttore di default.
     */
    public Appuntamento() {
    }

    /**
     * Restituisce l'ID dell'appuntamento.
     * @return L'ID dell'appuntamento.
     */
    public int getId() {
        return id;
    }

    /**
     * Restituisce la data dell'appuntamento.
     * @return La data dell'appuntamento.
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Restituisce l'ora dell'appuntamento.
     * @return L'ora dell'appuntamento.
     */
    public LocalTime getOra() {
        return ora;
    }

    /**
     * Restituisce il nome del cliente.
     * @return Il nome del cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il cognome del cliente.
     * @return Il cognome del cliente.
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta l'ID dell'appuntamento.
     * @param id Il nuovo ID dell'appuntamento.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Imposta la data dell'appuntamento.
     * @param data La nuova data dell'appuntamento.
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * Imposta l'ora dell'appuntamento.
     * @param ora La nuova ora dell'appuntamento.
     */
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    /**
     * Imposta il nome del cliente.
     * @param nome Il nuovo nome del cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Imposta il cognome del cliente.
     * @param cognome Il nuovo cognome del cliente.
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce una rappresentazione testuale dell'appuntamento.
     * @return Una stringa che descrive l'appuntamento.
     */
    @Override
    public String toString() {
        return "Appuntamento{"
                + "id=" + id + ", "
                + "data=" + data + ", "
                + "ora=" + ora + ", "
                + "nome='" + nome + "', "
                + "cognome='" + cognome + "'"
                + "}";
    }

}
