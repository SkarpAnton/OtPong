# Testausdokumentti

## Yksikkö- ja integraatiotestaus

### logiikka ja dao

#### game

pong.game-pakkausta testaa vastaavasti tests.game pakkaus. Jokaiselle logiikkaa sisältävälle luokalle on oma testi luokkansa nimettynä 
"luokan nimi"Test. BallTest, AITest ja PongTest kaikki sisältävät integraatio testejä, sillä luokat ovat luonnostaan riippuvaisia
toisistaan.

Ball luokka sisältää satunnaislukuja, joten luokkaa on hankala testata luotettavasti. Tästä syystä monissa testeissä testejä ajetaan 
useita kertoja, yleensä 10000 kertaa, jotta testeistä tulisi luotettavia. AI ja Pong luokkien tominnalisuus on riippuvainen Ball luokasta 
ja täten satunnaisuus ilmenee niissäkin ja testeissä käytetään täten samaa periaatetta eli testejä toistetaan useita kertoja.

Testi luokat myös tietenkin sisältävät yksikkötestejä. Yksikkötesteillä testataan esimerkiksi, että pallot ja mailat pysyvät kentän sisällä.

#### rating

pong.rating testaa tests.rating pakkaus. Ratinghandler luokan logiikka on riippuvainen ratingdao:sta, joten luokka testaa hiukan sitäkin toteutusta. Dao testit käyttää omaa test.db tietokantaa, joka alustetaan jokaista testiä ennen. 

### ui

En testannut automaattisesti käyttöliittymää, vaikka olisi sellainenkin ollut varmaan hyvä toteuttaa.

### Testikattavuus

Jos käyttöliittymää ei huomioi niin testikattavuus on hyvä. Rivikattavuus on 97% ja haaraumakattavuus on 100%.

![Testikattavuus](https://github.com/SkarpAnton/OtPong/blob/master/dokumentaatio/Kuvat/Testikattavuus.png)

### Puutteet

Rating pakkauksen ja game pakkauksen integraatio testejä ei ole olemassa. Pakkaukset ovat tosin melko eristettyjä toisistaan, joten ongelma ei ole kovin suuri,

## Järjestelmätestaus

Toteutettu manuaaalisesti

### välineistö

Testit toteutettiin seuraavanlaisella koneella:

Käyttöjärjestelmä: Windows 10 Home

CPU: i5-4690k

GPU: NVIDIA GeForce GTX 980

Ram: 16 gb

### Asennus ja konfigurointi

Sovellus ei sisällä oikeastaan konfigurointia, jar:in pitäisi sisältää kaikki tarvittava tieto. Tietokannan on testattu toimivan ladatulla jar tiedostolla.

### Toiminnalisuudet

Spovelluksen pitäisi testaukseni mukaan toimia määrittelydokumentin mukaisesti. Käyttäjän syötteisiin on varauduttu sovelluksessa ja olen testannut sitä manuaaliesti.

## Laatuongelmat

Tietokannallani ei elo varmuuskopiota, joten jos jotain hassua tapahtuisi kirjoitus vaiheessa voisi käyttäjän tieto kadota lopullisesti.

## Lähteet

Esimerkki proktista otettu vahvasti mallia, toivottavasti ei lasketa plagionniksi.














