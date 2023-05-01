# Esercizio - Spring Boot - Query personalizzate 2
* scrivere un'applicazione Spring Boot con le dipendenze necessarie che:
  * utilizza la stessa entità e repository dell'esercizio `Custom Queries 1`
  * ha un `FlightController`:
    * mappato su `voli`
    * per il provisioning di `n` voli (dove `n` è un parametro di ricerca facoltativo; se assente, `n=100`):
      * tutti i valori delle stringhe sono generati casualmente (usando `random.ints()`)
      * lo `stato` è generato in modo casuale
    * per recuperare tutti i voli nel db utilizzando l'impaginazione e restituirli in ordine crescente da `fromAirport`
    * per recuperare tutti i voli che sono `ONTIME` senza utilizzare una query personalizzata
    * per recuperare - utilizzando una query personalizzata - tutti i voli che sono in stato `p1` o `p2`
      * considera che l'utente deve passare `p1` e `p2` come parametri alla richiesta `GET`
* testare gli endpoint con `Postman`:
  * per il provisioning senza il parametro di query "n".
  * per il provisioning con il parametro di query `n`, con valore `49`
  * per ottenere i voli utilizzando l'impaginazione
  * per ottenere i voli che sono `ONTIME`
  * per ottenere i voli in ritardo o cancellati
  * per ottenere voli in orario o in ritardo
* **nota per i revisori**: visualizza "CustomQueries2.postman_collection.json" nella cartella principale per tutte le chiamate "Postman"

# Exercise - Spring Boot - Custom Queries 2
* write a Spring Boot application with the necessary dependencies that:
  * uses the same entity and repository as `Custom Queries 1` exercise
  * has a `FlightController`:
    * mapped on `flights`
    * for the provisioning of `n` flights (where `n` is an optional query param; if absent, `n=100`):
      * all the string values are randomly generated (using `random.ints()`)
      * the `status` is generated randomly
    * for retrieving all the flights in the db using pagination and returning them in ascending order by `fromAirport`
    * for retrieving all the flights that are `ONTIME` without using a custom query 
    * for retrieving - using a custom query - all the flights that are in `p1` or in `p2` status
      * consider that the user has to pass `p1` and `p2` as parameters to the `GET` request
* test the endpoints with `Postman`:
  * for provisioning without the `n` query parameter
  * for provisioning with the `n` query parameter, with value `49`
  * for getting the flights using pagination
  * for getting the flights that are `ONTIME`
  * for getting the delayed or cancelled flights
  * for getting the on time or delayed flights
* **note for reviewers**: view `CustomQueries2.postman_collection.json` in the root folder for all the `Postman` calls
