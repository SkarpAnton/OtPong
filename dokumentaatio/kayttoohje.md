# Käyttöohje

## Alustus

Aluksi lataa suoritettava tiedosto [FakePong_v1-1.jar](https://github.com/SkarpAnton/OtPong/releases);

## Konfiguraatio

Jos näyttösi virkistystaajuus (refresh rate) on korkeampi kuin 60hz, on suositeltavaa, että lasket näyttösi taajuuden mahdollsimman lähelle 60hz peliä varten.
Pelin animaattori on riippuvainen näytön virkisstystaajuudesta ja täten pelin nopeus on suoraan verrannollinen näytön virkistystaajuden kanssa. 

Jos virkistystaajuuden muuuttaminen ei ole tuttu prosessi niin netistä löytyy lukuisia ohjeita, jotka on suunnattu käyttämällesi käyttöjärjestelmälle esim. [Windows 10](https://www.windowscentral.com/how-change-monitor-refresh-rate-windows-10) ja [Ubuntu](https://askubuntu.com/questions/861416/changing-refresh-rate-for-specific-monitor)

## Suoritus

Tiedosto suoritetaan komennolla:
```
java -jar FakePong_v1-1.jar
```
## Aloitus valikko

![Aloitus valikko](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/Starting%20menu.png)

Aloitus valikossa liikutaan ylös ja alas nuolinäppäimillä. Kun teksti muuttuu valkoiseksi, se tarkoittaa, että tekstin kuvaava toiminto on suoritettavissa painamalla enter näppäintä.

## One player 

One player pelimuodossa on nimensä mukaisesti yksin pelattava pelimuoto, jossa käyttäjä pelaa AI:ta vastaan.  Käyttäjä ohjaa vasemman puoleista mailaa näppäimillä w ja s. 

## Two player

Two player pelimuodossa on käyttäjiä kaksi. Vasemman puoleista mailaa ohjataan edelleen w ja s näppäimillä,
mutta tällä kertaa oikea maila on ohjatavissa ylös ja alas nuolinäppäimillä.

## Nopeuden valinta

![Nopeuden valinta](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/Speeds.png)

One player ja two player pelimuodossa ennen peliä pitää valita pallon nopeus. Painamalla aloitus menussa kyseisiä nappeja vie nopeuden 
valinta valikkoon. 

## Ranked 

Ranked pelimuoto on kaksinpeli, jossa peliin liittyy elo rating. Elo rating menee alaspäin, jos häviää ja ylöspäin jos voittaa, lisätietoa:
[elo rating wikipedia](https://en.wikipedia.org/wiki/Elo_rating_system). Pelimuodossa pitää määrittää nimet pelaajille, jotta voidaan
pitää kirjaa käyttäjän ratingistä. Nimen pitää koostua amerikkalaisesta aakkostosta tai numeroista, lähinnä luettavuuden takia. 
Painamalla enter-näppäintä pystyy siirtymään peliin.

![Names](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/Usernames.png)

## Leaderboard

Leaderboard pitää kirjaa top 10 pelaajista ratingin mukaan.

![Rating](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/Leaderboard.png)

## Pelin pelaaminen

Taas kerran näppäimet ovat w ja s vasemalle pelaajalle ja ylös - ja alas nuolinäppäimet oikealle pelaajalle.

Pallo kimpoaa mailoista ja 
kentän ylä- ja alareunoista. Vasemman puoleinen pelaaja yrittää saada pallon kentän oikeaan reunaan ja oikea pelaaja vasempaan reunaan.
Pallo suunta määräytyy siitä mihin kohtaan mailaa pallo osuu, jos pallo osuu mailan yläkohtaan pallo lähtee yläviistoon, toisaalta
jos pallon osuu kohtuu alas mailaa niin se lähtee alaviistoon. 

Peli pelataan yhteentoista. 

Pelin voi pysäyttää painamalla escape-näppäintä. Escape-näppäin avaa valikon, josta voi jatkaa peliä tai palata aloitus menuun. 

![Game](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/game.png)

