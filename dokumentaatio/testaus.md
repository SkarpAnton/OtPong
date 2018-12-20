# Testausdokumentti

## Yksikkö- ja integraatiotestaus

### logiikka

#### game

pong.game-pakkausta testaa vastaavasti tests.game pakkaus. Jokaiselle logiikkaa sisältävälle luokalle on oma testi luokkansa nimettynä 
"luokan nimi"Test. BallTest, AITest ja PongTest kaikki sisältävät integraatio testejä, sillä luokat ovat luonnostaan riippuvaisia
toisistaan.

Ball luokka sisältää satunnaislukuja, joten luokkaa on hankala testata luotettavasti. Tästä syystä monissa testeissä testejä ajetaan 
useita kertoja, yleensä 10000 kertaa, jotta testeistä tulisi luotettavia. AI ja Pong luokkien tominnalisuus on riippuvainen Ball luokasta 
ja täten satunnaisuus ilmenee niissäkkin ja testeissä käytetään täten samaa periaatettam eli testejä toistetaan useita kertoja.





