# Pong 

Nimen pitäisi olla aika itseselostava, mutta projektin tarkoituksena on tosiaan tehdä sovellus, joka olisi jonkinlainen jäljennös Pong pelistä; jos Pong ei ole tuttu niin lisätietoa: [wikipedia: Pong](https://en.wikipedia.org/wiki/Pong) ja [Pong video](https://www.youtube.com/watch?v=e4VRgY3tkh0). Käytännössä tulen ottamaan varmaan, joitain taiteellisia vapauksia ja luultavasti tulen lisäämään joitain toimintoja peliin.

Tämä on Helsingin yliopiston ohjelmistotekniikan harjoitusprojekti, joka on tällä 
hetkellä työn alla.

## Dokumentaatio
[Vaativuusmäärittely](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/arkkitehtuuri.md)

[Käyttöohje](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/kayttoohje.md)


## Komentorivikomennot

### Testaus

```
mvn test
```

### Testikattavuus

```
mvn jacoco:report
```

### Jarin generointi

```
mvn package
```


### Checkstyle

```
 mvn jxr:jxr checkstyle:checkstyle
```

### JavaDoc

```
mvn javadoc:javadoc
```

