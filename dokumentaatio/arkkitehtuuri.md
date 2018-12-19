# Arkkitehtuuri

## Pakkausrakenne

### UI

#### Menu

Menu sisältää kaksi luokkaa ja viisi pakkausta. Luokat ovat nimeltään MenuController ja MenuELements, molemmat luokat ovat abstrakteja.
Kaikki viisi pakkausta siältävät vain kaksi luokkaa, jotka ovat nimeltään "pakkauksen nimi"Controller ja "pakkauksen nimi"Elements. Controller luokat perii MenuController:in ja elements luokat perii MenuElements:in. Jokainen pakkauksista on vastuussa yhdestä sivusta. 
Elements luokassa on tarvittavat JavaFX eklementit ja controller luokassa on niihin liittyvä logiikka.

![Menu pakkauskaavio](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/MenuKaavio.png)

Menu luokka keskustelee pong.ui.game - ja pong.database pakkauksen kanssa. Pakkauksen game alaisuuteen siirrytään RankedController:ista ja DifficultyConttroller:ista. Databasea käytetään leaderboardissa top kymmenen pelaajan hakuun.

![Menu suhteet](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/MenuRelations%20(1).png)

#### Game

Ui.game pakkaus on vastuussa pelin näyttämisestä ja sen ajamisesta. Game pakkaus sisältää kaksi luokkaa GameController ja GameElements. Elements sisältää tavittavat JavaFx objektit ja controller on vastuussa niihin liittyvästä logiikasta ja pelin pyörittämisestä.

Ui.game pakkaus keskustelee ui ulkopuolisen game pakkauksen kanssa ja yhdessä ne luovat pelin. Ui.game 'juttelee' peli luokan kanssa 
game pakkauksen Pong luokan kautta. Täten ui ja logiikka ei ole täysin eristettyjä sillä GameControllerin animation timer yhdessä oikeiden kutsujen kanssa päivittävät peliä, toisin sanoen pelissä ei tapahtuisi mitään ilman GamControlleria.l

![ui.game suhden Game.pong kanssa](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/UiGameGamePong.png)


### game

Game luokassa on kahdeksan luokkaa, neljä luokista ei sisällä logiikkaa, joten en käsittele niitä. Peliä käydään pong luokan kautta.
Pong:iin liittyy user luokka, AI luokka ja Ball luokka.

![game luokkakaavio](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/GameLuokkakaavio.png)

Pong luokkaan lisäksi liitty database luokkaan. Pong lähettää ranked pelin lopuksi tiedon voittajaista ja pelaajien nimistä.

![Pong rating](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/RatingPong.png)

### rating

Rating pakkaus laskee Elo ratingin vanhan ratingin ja pelin lopputuloksen perusteella ja tallentaa sen. Tiedon hakuun ja tallennukseen käytetään RatingDao toteuttavan luokan oliota. 

RatingDao:n toteutukseni käyttää tietokantaa, jossa on vain kolme saraketta: pääavain, pelaajan nimi ja rating.
Tilanteissa, jossa käytetään tietokantahakuun käyttäjien nimiä tehdään preparedstatement:in avulla SQL-injektion välttämiseksi. 

![Tietokanta](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/database.png)

![rating](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/rating.png)

## Päätoiminnallisuudet


#### Käy läpi pongin luomisen ja yhden kierroksen kahden pelaajan peliä

![Pong move](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/SekvenssiKaavioPongMove.png)



