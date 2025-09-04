package main.java.com.bookintime.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Classe di test per verificare il funzionamento di CsvManager.
 */
public class TestManager {

    public static void main(String[] args) {
        System.out.println("--- Inizio del Test per CsvManager ---");

        // 1. Creazione istanza del manager
        CsvManager manager = new CsvManager();

        // 2. Creazione di un nuovo appuntamento di prova
        System.out.println("\nStep 1: Creazione di un nuovo appuntamento di prova...");
        Appuntamento nuovoAppuntamento = new Appuntamento(1, LocalDate.now(), LocalTime.of(10, 30), "Mario", "Rossi");
        System.out.println("Appuntamento creato: " + nuovoAppuntamento);

        // 3. Test del salvataggio su file
        System.out.println("\nStep 2: Salvataggio dell'appuntamento su file 'appuntamenti.csv'...");
        manager.salvaAppuntamento(nuovoAppuntamento);
        System.out.println("Salvataggio completato. Controlla la cartella del progetto per il file 'appuntamenti.csv'.");

        // 4. Test della lettura da file
        System.out.println("\nStep 3: Lettura di tutti gli appuntamenti dal file...");
        List<Appuntamento> appuntamentiDalFile = manager.caricaAppuntamenti();

        if (appuntamentiDalFile.isEmpty()) {
            System.out.println("ERRORE: Nessun appuntamento è stato caricato dal file.");
        } else {
            System.out.println("Lettura completata. Appuntamenti trovati nel file: " + appuntamentiDalFile.size());
            // Stampa i dettagli di ogni appuntamento caricato
            for (Appuntamento app : appuntamentiDalFile) {
                System.out.println(" -> " + app);
            }
        }

        System.out.println("\n--- Fine del Test ---");
    }
}