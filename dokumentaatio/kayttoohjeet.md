# Käyttöohjeet

### Käynnistäminen

Lataa etusivulta hakemisto zip-tiedostona. Pura zip-tiedosto ja mene kirjanpito hakemistoon komentorivillä. 
Suorita komentorivillä komento mvn compile exec:java -Dexec.mainClass=com.mycompany.kirjanpito.mainClass

### Eriominaisuuksien valinta

Sovelluksen eriominaisuudet valitaan numeroilla. Kun sovelluksen käynnistää tulee näkyviin kaikki mahdolliset komennot. Aina numeron kirjoittamisen jälkeen paina rivinvaihto.

### Kuitin lisääminen

Valitse 1, kun sovellus pyytää syöttämään komentoa. Tämän jälkeen syötä summa ja paina rivinvaihto. Tämän jälkeen syötä kategoria ja paina rivinvaihto.

### Listaukset ja summa

Listaukset ja summat tulevat kaikki suoraan tulostettuna komentoriville ominaisuuden valitessa. Ainut poikkeus on kategoriat, joissa pitää aluksi syöttää kategoria ja painaa rivin vaihtoa.

### Uuden vuoden tullessa

Suorita kirjanpito hakemistossa komento rm database.db . Tämä poistaa tietokannan ja seuraavan kerran sovellusta käynnistettäessä luodaan uusi tietokanta.
