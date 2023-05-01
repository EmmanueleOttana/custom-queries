# Esercizio - Spring Boot - Query personalizzate 1
* scrivere un'applicazione Spring Boot con le dipendenze necessarie che:
  * ha un'entità "Volo" con le seguenti colonne:
    * una chiave primaria
    * una stringa `descrizione`
    * una stringa `fromAirport`
    * una stringa `toAirport`
    * un enum `stato`
      * i valori possibili sono `ONTIME`, `DELAYED` e `CANCELLED`
  * ha un repository dedicato
  * ha un `FlightController`:
    * mappato su `voli`
    * per il approvvigionamento di 50 voli dove:
      * tutti i valori delle stringhe sono generati casualmente (usando `random.ints()`)
      * lo stato predefinito è "ON_TIME".
    * per il recupero di tutti i voli nel db
* testare i 2 endpoint con `Postman`
* **nota per i revisori**: visualizza `CustomQueries1.postman_collection.json` nella cartella principale per tutte le chiamate `Postman`

# Exercise - Spring Boot - Custom Queries 1
* write a Spring Boot application with the necessary dependencies that:
  * has an entity `Flight` with the following columns:
    * a primary key
    * a string `description`
    * a string `fromAirport`
    * a string `toAirport`
    * an enum `status`
      * the possible values are `ONTIME`, `DELAYED` and `CANCELLED`
  * has a dedicated repository
  * has a `FlightController`:
    * mapped on `flights`
    * for the provisioning of 50 flights where:
      * all the string values are randomly generated (using `random.ints()`)
      * the default status is `ON_TIME`
    * for retrieving all the flights in the db
* test the 2 endpoints with `Postman`
* **note for reviewers**: view `CustomQueries1.postman_collection.json` in the root folder for all the `Postman` calls
