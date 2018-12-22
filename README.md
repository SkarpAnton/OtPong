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

### Alustus

komennot olettavat, että olet maven projektin juuressa

### Testaus

Testit voi ajaa komennolla,

```
mvn test
```

### Testikattavuus

Testikattavuusraportin voi luoda komennolla, 
```
mvn jacoco:report
```
Raportti löytyy /target/site/jacoco/index.html

### Jarin generointi

Komento

```
mvn package
```
luo target kansioon suoritettavan tiedoston  Pong-1.0-SNAPSHOT-shaded.jar

### Checkstyle

Luo checkstyle raportin.

```
 mvn jxr:jxr checkstyle:checkstyle
```
Raportti löytyy /target/site/checkstyle.html

### JavaDoc

Luo javadocin

```
mvn javadoc:javadoc
```

javadoc löytyy /target/site/apidocs/index.html

