# Arkkitehtuuri

## UI

### Menu

Menu sisältää kaksi luokkaa ja viisi pakkausta. Luokat ovate nimeltään MenuController ja MenuELements, molemmat luokat ovat abstrakteja.
Kaikki viisi pakkausta siältävät vain kaksi luokkaa, jotka ovat nimeltään "pakkauksen nimi"Controller ja "pakkauksen nimi"Elements. Controller luokat perii MenuController:in ja elements luokat perii MenuElements:in. Jokainen pakkauksista on vastuussa yhdestä sivusta. 
Elements luokassa on tarvittavat JavaFX eklementit ja controller luokassa on niihin liittyvä logiikka.

![Menu pakkauskaavio](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/MenuKaavio.png)

Menu luokka keskustelee pong.ui.game - ja pong.database pakkauksen kanssa. Pakkauksen game alaisuuteen siirrytään RankedController:ista ja DifficultyConttroller:ista. Databasea käytetään leaderboardissa top kymmenen pelaajan hakuun.

![Menu dependency](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/MenuDependency.png)

### Game

Ui.game pakkaus on vastuussa pelin näyttämisestä ja sen ajamisesta. Game pakkaus sisältää kaksi luokkaa GameController ja GameElements. Elements sisältää tavittavat JavaFx objektit ja controller on vastuussa niihin liittyvästä logiikasta ja pelin pyörittämisestä.

Ui.game pakkaus keskustelee ui ulkopuolisen game pakkauksen kanssa ja yhdessä ne luovat pelin. Ui.game 'juteelee' peli luokan kanssa 
game pakkauksen Pong luokan kautta.

![ui.gameDependecy](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/UiGameDependency.png)


## game

Game luokassa on kahdeksan luokkaa, neljä luokista eii sisällä logiikkaa, joten en käsittele niitä. Peliä käydään pong luokan kautta.
Pong:iin liittyy user luokka, AI luokka ja Ball luokka.

![game luokkakaavio](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/GameLuokkakaavio.png)

Pong luokkaan lisäksi liitty database luokkaan. Pong lähettää ranked pelin lopuksi tiedon voittajaista ja pelaajien nimistä.

![Pong database](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/DatabasePong.png)

Sekvenssikaavio käy läpi pongin luomisen ja yhden kierroksen kahden pelaajan peliä
![Sekvenssikaavio](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/SekvenssiKaavioPongMove.png)
