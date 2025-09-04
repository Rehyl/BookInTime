package main.java.com.bookintime.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CsvManager {

    private static final String NOME_FILE = "appuntamenti.csv";
    private static final String INTESTAZIONE = "id,data,ora,nome,cognome";

    /**
     * Carica tutti gli appuntamenti dal file CSV.
     *
     * @return Una lista di oggetti Appuntamento. Restituisce una lista vuota se il file non esiste o è vuoto.
     */
    public List<Appuntamento> caricaAppuntamenti() {
        List<Appuntamento> appuntamenti = new ArrayList<>();
        File file = new File(NOME_FILE);

        if (!file.exists()) {
            return appuntamenti; // Il file non esiste, restituisce lista vuota
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String riga;
            boolean ePrimaRiga = true;
            while ((riga = br.readLine()) != null) {
                if (ePrimaRiga) {
                    ePrimaRiga = false;
                    if (riga.equals(INTESTAZIONE)) { // Salta l'intestazione solo se corrisponde
                        continue;
                    }
                }

                String[] parti = riga.split(",");
                if (parti.length == 5) {
                    try {
                        int id = Integer.parseInt(parti[0].trim());
                        LocalDate data = LocalDate.parse(parti[1].trim());
                        LocalTime ora = LocalTime.parse(parti[2].trim());
                        String nome = parti[3].trim();
                        String cognome = parti[4].trim();

                        Appuntamento appuntamento = new Appuntamento(id, data, ora, nome, cognome);
                        appuntamenti.add(appuntamento);
                    } catch (NumberFormatException | DateTimeParseException e) {
                        System.err.println("Errore durante il parsing della riga CSV: " + riga + " - " + e.getMessage());
                        // Continua a leggere le altre righe anche in caso di errore su una riga
                    }
                } else {
                    System.err.println("Riga CSV malformata (numero di colonne errato): " + riga);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file " + NOME_FILE + ": " + e.getMessage());
        }
        return appuntamenti;
    }

    /**
     * Salva un nuovo appuntamento nel file CSV. Se il file non esiste, lo crea automaticamente e aggiunge l'intestazione.
     *
     * @param appuntamento L'oggetto Appuntamento da salvare.
     */
    public void salvaAppuntamento(Appuntamento appuntamento) {
        File file = new File(NOME_FILE);
        boolean ilFileEsiste = file.exists();

        // Crea il file e le directory padre se non esistono
        if (!ilFileEsiste) {
            try {
                // Crea le directory padre se necessario
                File dirPadre = file.getParentFile();
                if (dirPadre != null && !dirPadre.exists()) {
                    dirPadre.mkdirs();
                }
                // Crea il file
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Errore durante la creazione del file " + NOME_FILE + ": " + e.getMessage());
                return;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) { // true per modalità append
            if (!ilFileEsiste) {
                bw.write(INTESTAZIONE);
                bw.newLine();
            }
            // Formatta l'appuntamento in una stringa CSV
            String rigaCsv = String.format("%d,%s,%s,%s,%s",
                    appuntamento.getId(),
                    appuntamento.getData().toString(),
                    appuntamento.getOra().toString(),
                    appuntamento.getNome(),
                    appuntamento.getCognome());
            bw.write(rigaCsv);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura sul file " + NOME_FILE + ": " + e.getMessage());
        }
    }
}