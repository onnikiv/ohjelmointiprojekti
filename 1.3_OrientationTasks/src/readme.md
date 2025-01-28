## Task 1

Jos piirtäisin __1000__ ikäarvoa samalla jakaumalla kuin opiskeluryhmäni:   
- Oman Ryhmän koko
- Kuinka monta eri ikää ryhmässä on
- Kuinka monta henkilöä sijoittuu jokaiselle iälle.
    - Laske todennäköisyys sijottua tiettyyn ikään koko ryhmän kokoon nähden.   
    - $P(ikä) = \frac{opiskelijoiden\space määrä\space kyseisessä\space iässä}{ryhmän\space koko}$
- Suorittaisin laskennallisesti __1000__ arvon simulaation käyttäen ryhmän ikäjakauman todennäköisyyksiä.

## Task 3
Singleton oliota ei voi luoda Singleton luokan ulkopuolella, juurikin koska Singleton olioita halutaan olevan vain
yksi instanssi. Esimerkiksi simuloinnissa käytetään yleisesti vain yhtä kelloa, näin voidaan varmistua että
simulaatiossa on vain yksittäinen kello, joka laskee aikaa. Tämä estää mahdollisten virheiden tapahtumista.

## Task 4

### 1. Normaalijakauma (Normal Distribution)
 - Symmetrinen jakauma, data keskittyy keskiarvon ympärille.
 - Esim, ihmisten painot ja pituudet
 - Simuloinnissa esim. asiakkaiden saapumisajat


### 2. Eksponenttijakauma (Exponential Distribution)
- Ajan mallintaminen -> kahden peräkkäisen tapahtuman välillä, kun tapahtumat ovat satunnaisia.
- Esim, saapuvien asiakkaiden väliset ajat, komponenttien vikaantumisajat.
- Käyttö simuloinnissa usein saapumis- tai odotusaikojen mallintamiseen.


### 3. Binomijakauma (Binomial Distribution)
- Toistuvien kokeiden mallintaminen, joissa on kaksi mahdollista lopputulosta (onnistuminen tai epäonnistuminen).
- Esim, Kolikonheitot (vaikka 10 heittoa ja kuinka monta kruunua saadaan).
- Simuloinnissa, esim tarkasteltaessa tietyn tapahtuman onnistumistodennäköisyyttä.

### 4. Poisson-jakauma (Poisson Distribution)
- Mallintaa tapahtumien määrää tietyllä aikavälillä, kun tapahtumat ovat satunnaisia ja itsenäisiä
- Esim, Asiakkaiden määrä, jotka saapuvat pankkiin tunnin aikana.
___