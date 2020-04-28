# Ohjelmistotekniikka

## Harjoitustyö - kirjanpitosovellus
Tässä sovelluksessa tarkoituksena on, että käyttäjä voi tallentaa omia kuittejaan ja tarkastella niitä erilaisin jäsentelyin.

-------

### Harjoitustyö tällä hetkellä
Tekstikäyttöjärjestelmässä on paljon enemmän toimintoja kuin graafisessa. Testien toteuttaminen onnistuu nyt hiukan.

### Suoritettavan jarin generointi
Komento mvn package generoi tiedoston kirjanpito-1.0-SNAPSHOT.jar  hakemistoon target.

### Käynnistäminen 
Sovelluksen käynnistäminen onnistuu komentorivillä komennolla:

teksti - mvn compile exec:java -Dexec.mainClass=com.mycompany.kirjanpito.mainClass

graafinen - mvn compile exec:java -Dexec.mainClass=com.mycompany.kirjanpito.graphicMain


### Testaus 
Testikattavuus raportin saa luotua komentorivillä komennolla: mvn test jacoco:report

Sen saa näkyviin komennolla: chromium-browser target/site/jacoco/index.html


### Dokumentaatio
[Vaativuusmäärittely](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/vaativuusm%C3%A4%C3%A4rittely.md)

[Työaikakirjanpito](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)
