# Testausdokumentti 

Sovellusta on testattu JUnit yksikkö testeillä. Tämän lisäksi järjestelmätasoa on testattu manuaalisesti.

## Yksikkötestaus 

#### Toiminnaliset luokat

Automaattista testausta on suoritettu [tietokantaa](https://github.com/karhuherra/ot-harjoitustyo/blob/master/kirjanpito/src/main/java/kirjanpito/dao/database.java) käsittelevälle luokalle ja sitä [kuitteja](https://github.com/karhuherra/ot-harjoitustyo/blob/master/kirjanpito/src/main/java/kirjanpito/dao/receipt.java) luovalle luokalle. Testikattavuusraportin saa näkymiin etusivulla olevin ohjein. Testien rivikattavuus on 86% ja 
haaraumakattavuus on 100%. Ainoat rivit, jotka eivät testeissä pääse linjalle ovat. Mahdollisia tietokantavirheitä käsitteleviä rivejä. Testauksessa käytetään apuna toista tietokantaa fakedatabase.db. 
Tämä tietokanta tyhjennetään aina, jokaisen testin jälkeen, jotta testit voivat toimia tyhjältä pöydältä. Toisen tietokannan käyttäminen testaukessa on tärkeää, että oikeassa tietokannassa oleva tieto pysyy
turvassa ja oikeana.

#### Käyttäjärjestelmän testaus

Käyttöjärjestelmiä on testattu manuaalisesti.
