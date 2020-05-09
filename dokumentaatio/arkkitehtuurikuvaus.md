# Arkkitehtuurikuvaus

## Rakenne

Ohjelman rakenne mukailee kolmitasoista kerrosarkkitehtuuria. Ylin taso käynnistää käyttöjärjestelmän, keskimmäisessä on käyttöjärjestelmä ja itse sovelluslogiikka on alimmalla tasolla.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/paketit.png)

## Käyttöliittymä

Käyttöliittymä on tekstikäyttöliittymä ja se toimii numerokomennoin käyttäjän kanssa. Käyttöjärjestelmä on melkein täysin irroitettu sovelluslogiikasta. Ainoastaan tietokanta virheet ja tieto kuitin
lisäämisestä tulostuvat suoraan sovelluslogiikasta. Käyttöjärjestelmä kutsuu sovelluslogikaan toiminto erinäisin parametrein ja saa sieltä takaisin listoja kuiteista tai summia. Vaihtoehtoisesti 
se voi myös antaa sovelluslogiikalle parametrit uuteen kuittiin. 

## Sovelluslogiikka

Sovelluslogiikan datamallin muodostavat luokat database ja receipt.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/luokat.png)

Database on luokka joka käsittelee kaikkia tietokannan kanssa toimivia toiminnallisuuksia ja receipt on kuittien muodostamista varten. Tietokantaa tallennetaan kuitteja, mutta niitä ei tallenneta kuitti olioina
vaan summa-kategoria pareina. Sitten niitä tietokannasta haettaessa ne muodestetaan taas kuitti-olioiksi. 


## Tietojen tallennus 

Tiedot tallennetaan paikallisesti tietokoneelle tietokantaan. Ensimmäisellä sovelluksen avaus kerralla, sovellus luo database.db tiedoston kirjanpito hakemistoon. Seuraavilla kerroilla sovellus ottaa käynnistettäessä.
yhteyden tietokantaan ja niin tiedot säilyvät, vaikka sovelluksen sulkeekin välissä. Testit käyttävät vastaavaa tietokantaa fakedatabase.db. Tietokantaan tallennetaan tietoa summat Numeric-muodossa ja kategoriat
String-muodossa.

## Toiminnallisuudet

Seuraavaksi kuvataan sovelluksen toiminnallisuuksia sekvenssikaavioina.



#### Kuitin lisääminen 

Kun sovelluksesta valitaan toiminto 1, on toiminta seuraavanlainen.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/kuittilisaus.png)

Käyttäjärjestelmä kysyy tämän jälkeen käyttäjältä summan ja kategorian. Sitten se kutsuu database-luokan metodia addReceipt() parametreilla, jotka se on juuri saannut. Tämän jälkeen database luokassa metodi
lisää tiedot sql-kielellä tietokantaan ja tulostaa käyttäjälle tiedon, että kuitti on lisätty.



#### Kaikkien kuittien tulostaminen

Kun sovelluksessa valitaan toiminto 2, on toiminta seuraavanlainen.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/listaa.png)

Käyttöjärjestelmä kutsuu database luokan metodia listAll(), joka sitten hakee tietokannasta kaikki summa-kategoria parit. Tämän jälkeen se muuttaa summa-kategoria parit kuiteiksi, jotka se lisää listalle, jonka se 
palauttaa käyttöjärjestelmälle. Käyttöjärjestelmä sitten tulostaa käyttäjälle kaikki kuitit.



#### Kaikkien kuittien tulostaminen kategoriasta

Kun sovelluksessa valitaan toiminto 3, on toiminta seuraavanlainen.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/kategorialista.png)

Käyttöjärjestelmä selvittää käyttäjältä kategorian jonka jälkeen käyttöjärjestelmä kutsuu database luokan metodia listAllFrom(String catergory),käyttäjän antamalla parametrilla, joka sitten hakee 
tietokannasta kaikki kyseisen kategorian summa-kategoria parit. Tämän jälkeen se muuttaa summa-kategoria parit kuiteiksi, jotka se lisää listalle, jonka se 
palauttaa käyttöjärjestelmälle. Käyttöjärjestelmä sitten tulostaa käyttäjälle kaikki kuitit.



#### Kaikkien kuittien summan tulostaminen

Kun sovelluksessa valitaan toiminto 4, on toiminta seuraavanlainen.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/summa.png)

Käyttöjärjestelmä kutsuu database luokan metodia listAllReceiptsSum(), joka laskee tietokannasta kaikkien kuittien yhteissumman. Sen summan se sitten palauttaa käyttöjärjestelmälle, joka tulostaa sen 
nähtäväksi käyttäjälle.

#### Kaikkien kuittien summan tulostaminen kategoriasta            

Kun sovelluksessa valitaan toiminto 5, on toiminta seuraavanlainen.

![alt text](https://github.com/karhuherra/ot-harjoitustyo/blob/master/dokumentaatio/summakategoria.png)

Käyttöjärjestelmä selvittää aluksi käyttäjältä kategorian. Tämän jälkeen käyttöjärjestelmä kutsuu database luokan metodia listAllReceiptsSumFrom(String category), joka laskee tietokannasta kaikkien 
kyseisen kategorian  kuittien yhteissumman. Sen summan se sitten palauttaa käyttöjärjestelmälle, joka tulostaa sen nähtäväksi käyttäjälle.


## Ohjelman rakenteeseen jääneet heikkoudet

Käyttöjärjestelmä ei ole täysin itsenäinen vaan tietokantaluokka keskustelee myös käyttäjän kanssa. Tämä ei toteutu periaatetta yksiluokka yksitehtävä. 
