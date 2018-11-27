# Pong 

Nimen pitäisi olla aika itseselostava, mutta projektin tarkoituksena on tosiaan tehdä sovellus, joka olisi jonkinlainen jäljennös Pong pelistä; jos Pong ei ole tuttu niin lisätietoa: [wikipedia: Pong](https://en.wikipedia.org/wiki/Pong) ja [Pong video](https://www.youtube.com/watch?v=e4VRgY3tkh0). Käytännössä tulen ottamaan varmaan, joitain taiteellisia vapauksia ja luultavasti tulen lisäämään joitain toimintoja peliin.

Tämä on Helsingin yliopiston ohjelmistotekniikan harjoitusprojekti, joka on tällä 
hetkellä työn alla.

## Dokumentaatio
[Vaativuusmäärittely](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)


## Komentorivitoiminnotn (täysin kopitoitu referenssisovelluksesta)

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
Lisäsin halutun pluginin, mutta se rikkoi ainakin itselläni kattavuusraportin luomisen, joten jos on kattavuusraportin kanssa ongelmia niin voi yrittää poistaa surefire pluginin

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston


### Checkstyle


```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
