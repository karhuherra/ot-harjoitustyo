# Ohjelmistotekniikka

### Kirjanpito sovellus
Sovellus on loutu tarpeeseen. Allekirjoittaneella tulee, joka vuosi perheen vanhemman valtiomiehen kuitit läpikäytäväksi verotusta varten. Sovelluksella on siis tarkoitus helpottaa tätä kuittien kirjaamisis 
ja laskemisprosessia. Sovellusta voi käyttää vain komentorivillä. 

### Käynnistäminen 
Sovelluksen käynnistäminen onnistuu komentorivillä komennolla:

mvn compile exec:java -Dexec.mainClass=com.mycompany.kirjanpito.mainClass

### Dokumentaatio
[Käyttöohjeet]()

[Vaativuusmäärittely](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/vaativuusm%C3%A4%C3%A4rittely.md)

[Arkkitehtuurikuvaus]()

[Työaikakirjanpito](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/ty%C3%B6aikakirjanpito.md)

### Testaus 

Testikattavuusraportin saa luotua komennolla mvn test jacoco:report

Raportti löytyy osoitteesta target/site/jacoco/index.html
