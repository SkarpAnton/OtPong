# Pong 

Java:lla toteutettu versio Pong-pelistä. Toteutuksen käyttöliittymä on tehty JavaFX:n avulla. Peli sisältää yksinkertaisen tekoälyn ja ranked pelimuodon. Jos Pong ei ole tuttu niin lisätietoa löytyy esimerkiksi: [wikipedia: Pong](https://en.wikipedia.org/wiki/Pong) ja [Pong video](https://www.youtube.com/watch?v=e4VRgY3tkh0). 

Tämä on Helsingin yliopiston ohjelmistotekniikan harjoitusprojekti.

## Dokumentaatio

[Käyttöohje](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/kayttoohje.md)

[Vaativuusmäärittely](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/maarittelydokumentti.md)

[Työaikakirjanpito](https://github.com/SkarpAnton/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testaus](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/testaus.md)

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

