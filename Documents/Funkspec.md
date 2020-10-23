# Funkcionális specifikáció
## 1. Rendszer céljai és nem céljai

### A rendszer céljai a következők:

- megbízhatóság;
- átláthatóság;
- könnyű kezelhetőség;
- szemrevaló, letisztult felhasználói felület;

#### Asztali alkalmazás esetében:

- a rendszer saját adatbázissal kell, hogy rendelkezzen;
- a rendszernek tárolnia kell az egyes alapanayagokat és ezek raktáron levő mennyiségét. Ezeket a mennyiségeket egységekben kell mérni, ahol egy egységhez magyarázat kell tartozzon (például egy egység liszt jelenthet egy kilogrammot);
- a rendszerben szerepelnie kell az aktuális menüsornak és az árlistának;
- a rendszernek valamilyen módon jeleznie kell, ha az egyes alapnyagok készlethiányba fognak kerülni (például, ha tíz egység lisztnél kevesebb van, akkor ez felkerülhet egy figyelmeztető listára);

##### A weboldal esetében:

- a weboldalnak is hozzá kell férnie a központi adatbázishoz;
- a felhasználó számára elérhető kell, hogy legyen a teljes menüsor, valamint az árlista;
- a menüben fel kell tüntetni az egyes ételek alapanyagait, hogy a kliensek megbizonyosodjanak róla, nem kapnak olyan ételt, amelybe olyan alapanyag kerülhet, ami esetleges allergiás reakciót válthatna ki;
- a rendelés leadásakor a felhasználó kiválaszthatja, hogy átvételkor készpénzzel vagy kártyával szeretne fizetni;
- a weboldalon szerepelnie kell az étterem telefonszámának, abban az esetben, ha a kliens telefonon szeretné leadni rendelését;
- fel kell tűntetni, hogy kb. mennyi időbe telik a kiszállítás;
- fel kell tűntetni azt is, hogy mennyibe kerül a kiszállítás;


### A rendszernek nem céljai a következők:

#### Asztali alkalmazás esetében:

- készlethiány esetén az alkalmazás nem ad le automatikusan rendelést a szükséges alapanyagokra, csupán egy figyelmeztetést biztosít a beszerzéssel foglalkozó személyzetnek
- az alkalmazás nem foglalkozik a kasszagépben levő pénzmennyiségekkel;

##### A weboldal esetében:

- a rendszer nem tárolja a felhasználó által megadott személyes adatokat, pontosabban a kliens nevéről, telefonszámáról és lakcíméről van itt szó;
- házhoz rendeléskor készpénzes fizetés lehetséges, kártyás fizetés is csak helyben, mobil terminálon keresztül, tehát a weboldal nem kell, hogy biztosítsa az online fizetés lehetőségét. Innentől kezdve nem kezelünk érzékeny bankkártya adatokat;


## 2. [Jelenlegi helyzet leírása](Kovspec.md#1-jelenlegi-helyzet)

&nbsp;&nbsp;&nbsp;&nbsp;A jelenlegi helyzet az, hogy az étterem a gyors ütemű fejlődése miatt kinőtte az eddig megszokott papír alapú leltár készítését.
Tehát átláthatatlanok, visszanyomozhatatlanok lettek az alapanyag felhasználások és a raktári tevékenységek.
Az étterem sok különböző alapanyagot használ. Mindemellett az ételek is választékosak: modern,hagyományos ételspecialitások ötvözve a hazai(magyar) és nemzetközi 
konyhát.
Emellett az étterem magába foglal egy pékséget és egy cukrászdát is. 
Tehát péksütemény és sütemény receptek is rendelkezésre állnak és az ezek elkészítéséhez szükséges alapanyagok.
Minden héten különböző menük érhetőek el, de vannak visszatérő ételek illetve a'la carte, amely a hét minden napján elérhető, emellett hetente van egy séf 
ajánlata is az adott hétre.

&nbsp;&nbsp;&nbsp;&nbsp;Az átláthatatlan leltárvezetés miatt azonban egyre többször fordult elő, hogy az alapanyag előbb fogyott el mint szükséges lett volna. 
Mivel a papír alapú leltáron még szerepelt az adott nyersanyag, emiatt nem rendeltek még belőle árut.
Ezen okokból kifolyólag egyre gyakrabban fordult elő az, hogy egy adott étel az adott nap hamarabb lekerült az étlapról, vagy rendelés érkezett, de sajnos már 
csak annyit tudtunk 
mondani, hogy sajnáljuk, de már nincs elég alapanyag az elkészítéséhez. 
Emiatt egyre több negatív értékelést kap az éttermünk, amit minél előbb orvosolni kell. 
Különben elveszítjük a vendégeinket. Ez kezdetben bevételkieséshez, de később akár az éttermünk bezárásához is vezethez. 
Tehát az optimális készeltszintünk felbecsüléséhez mindenképp fontos, a pontos elérhető készletekről lévő információ.

&nbsp;&nbsp;&nbsp;&nbsp;A járványhelyzet miatt megnőtt a kereslet a házhoz rendeléses éttermek iránt. 
Ez piaci rést jelent számunkra, amelyjel egy új vásárlói réteget. 
De ehhez szükségsünk van egy weboldalra, amelyjel naprakész információt szolgáltathatunk az elérhető menükről. 
Illetve ahol lehetőség van rendelés leadására és asztalfoglalásra. 
Ezzel is megkönnyítve az adminisztratív munkáját a pincéreinknek. 
Emellett a weboldalt telefonról is jó lenne elérni, mivel a mai rohanó világban többen preferálják a telefonokat. 
Illetve ha úton vannak akkor is a Google keresővel telefonon fogják keresni a közelben lévő éttermeket. 
És egy jól kinéző, megnyerő weboldallal egyfajta pozitívumot nyújthatunk a leendő vendégeinknek, hogy a mi éttermünket válasszák a többi elérhető étterem közül.

&nbsp;&nbsp;&nbsp;&nbsp;Mindezek felett szükségünk lenne a receptjeink digitális tárolására ugyanis a papír alapú receptek sérülékenyek. 
A digitalizálása a recepteknek meggyorsíthatja a konyhai dolgozóink munkáját. Könnyebben kereshetőek. 
A látási viszonyokhoz állíthatóak a monitoron történő megjelenítés miatt.

## 3. Vágyálomrendszer

## 4. A rendszerre vonatkozó szabályok

&nbsp;&nbsp;&nbsp;&nbsp;Ide az úgynevezett "szabályokat" sorolhatjuk, amelyek, ha kifejtjük, akkor az aktuális törvényi megszorításokat és rendeleteket, a különböző ezzel 
foglalkozó szerezetek által kiadott szabványokat és ajánlásokat jelentik, illetve az általunk megfogalmazott kikötések a program / alkalmazás szempontjából tekintve, amelyek 
befolyásolják a kapott végkimenetelt.

Kicsit részletesebben kifejtve ezek a következők:

### 4.1 Az applikáció kidolgozásához a következőkre van szükség:
 - Java, ahol megkötés a verziószámban: minimum 13-as
 - JavaFX, ahol a használt verzió: 14-es
 - Adatbáziskezelés a háttérben: MySQL, Apache és XAMPP
 
### 4.2 A weblap kidolgozásához minimum szükségesek az alábbiak:
 - HTML használata
 - CSS használata
 - PHP használata
 - Adatbáziskezeléshez szükséges: XAMPP
 
### 4.3 Jogi háttér:
&nbsp;&nbsp;&nbsp;&nbsp;Ahhoz, hogy elkészülhessen az alkalmazás és a weblap is, más követelmény nem lenne.
Azonban ahhoz, hogy ezek legálisan használhatóvá is váljanak, és megkaphassa az étterem, mindenképp figyelmet kell fordítani a jogi megkötésekre.
Tehát figyelni kell:

 - Az adatvédelemre
 - Az eddig kiadott szabványokra
 
Kicsit jobban részletezve:

Az adatvédelemre 2 okból is szükség van, hiszen egy weboldal kezelhet személyes adatokat, amit a felhasználó nem biztos, hogy ki szeretne adni például egy harmadik fél számára 
is, a másik pedig, az ehhez köthető süti (cookie) kezelés, ami alapjáraton tárolási és figyelmeztetési céllal szolgálna, ugyanis az előre kitöltött adatokat, amiket visszatérő 
látogatóként lát a felhasználó, azokat a sütik töltik ki, illetve fontos jogi követelmény szabályozás miatt, hogy a most már kötelezőként felugró süti használatra figyelmeztető 
ablakok megjelenjenek.
A mi esetünkben az adatvédelem fontos, hiszen egy étterem számára készítjük az alkalmazást, akik csak saját felhasználásra, pontosabban a rendelések elkészítéséhez és 
kiszállításához szeretnék az adatokat felhasználni. Emiatt pedig úgy döntöttünk, hogy az étterem felé kötelező adatvédelmet a nemrég kiadott EU-s adatvédelem határozza meg és a 
GDPR határozza meg.

A korábban említett szabványok használata pedig szintén erősen ajánlott, hiszen ezeket sem véletlenül találták ki, hanem komoly céllal, mint például a hatékonyabb, gyorsabb és 
olcsóbb működés vagy üzeeltetés. A Követelmény specifikációban már megemlítettük ezeket, de itt is fel szeretnénk hívni a figyelmet a fontosságukra. A nagyobb, internetre 
szabványokat kiadó szervezetek példul:  W3C, ECMA, IETF, WHATWG.

## 5. Jelenlegi üzleti folyamatokmodellje
### 5.1 Raktár kezelése:
5.1.1 Alkalmazott=>Alapanyagok megszámolása=>Feljegyzés papírra

5.1.2 Alkalmazott=>Receptek felírása=>Papírra,keményfedelű jegyzetfüzetbe

5.1.3 Alkalmazott=>Feljegyzett készletek=>Hiányzó készletek meghatározása=>Áru rendelése

### 4.2 Interakciók az ügyfelekkel
5.2.1 Étterem=>Televízió,rádió,hirdetőfelület=>Hirdetés

5.2.2 Ügyfél=>Asztalfoglalás=>Személyesen az étteremben

5.2.3 Ügyfél=>Étel rendelés=>Személyesen az étteremben=>Evitelre vagy helyben fogyasztva

5.2.4 Alkalmazott=>Ügyfél=>Asztalfoglalás bejegyzése

5.2.5 Alkalmazott=>Ügyfél=>Rendelés felvétele

## 6. Igényelt üzleti folyamatok modellje
### 6.1 Alkalmazott-Leltár-Recept
6.1.1 Alkalmazott=>Alkalmazás=>Leltár feltöltése

6.1.2 Alkalmazott=>Alkalmazás=>Elgépelt érték javítása

6.1.3 Alkalmazott=>Alkalmazás=>Alapanyag törlése

6.1.4 Alkalmazott=>Alkalmazás=>Alapanyagok listázása

6.1.5 Alkalmazott=>Alkalmazás=>Recept feltöltése

6.1.6 Alkalmazott=>Alkalmazás=>Recept módosítása

6.1.7 Alkalmazott=>Alkalmazás=>Recept törlése

6.1.8 Alkalmazott=>Alkalmazás=>Receptek lekérdezése

![Felhasználó,raktár,recept](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/elsodiagram.png)
### 6.2 Weboldal-Applikáció
6.2.1 User=>Weboldal=>Étlap megtekintése

5.2.2 User=>Weboldal=>Rendelés

6.2.3 User=>Weboldal=>Asztalfoglalás

6.2.4 Weboldal=>User=>Étlap listázása

6.2.5 Weboldal=>Rendelés feltöltése=>Adatbázis

6.2.6 Weboldal=>Foglalás feltöltése=>Adatbázis

6.2.7 Adatbázis=>Rendelhető ételek listázása=>Weboldal

6.2.8 Adatbázis=>Rendelt ételek listázása=>Alkalmazás

6.2.9 Adatbázis=>Asztalfoglalás listázása=>Alkalmazás

6.2.10 Alkalmazás=>Foglalások megjlenítése=>Alkalmazott

6.2.11 Alkalmazás=>Rendelések megjlenítése=>Alkalmazott

6.2.12 Alkalmazott=>Foglalások megtekintése=>Alkalmazás

6.2.13 Alkalmazott=>Rendelések megtekintése=>Alkalmazás

![Felhasználó,raktár,recept](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/masodik.png)
## 7. Követelménylista
 - Legyen egyszerűen kezelhető az alkalmazottak és a vendégek számára egyaránt
 - Legyen könnyen áltáltható az alkalmazottak és a vendégek számára egyaránt
 - Az adatok tárolása adatbázisban törtéjen
 - Az alkalmazottak számára kerüljön megjelenítésre az alkalmazásban a leadott rendelések
 - Az alkalmazottak láthatják a berendelésre váró alapanyagok listáját az alkalmazásban
 - Mindemellett láthatják az étlapot
 - Az étlapon jelenjenek meg a ételekben szereplő alapanyagok
 - Az étlapon lehessen látni az egyes ételek árát
 - Az étlapon (a könnyebb rendelés érdekében) legyen látható sorszámozás az ételek mellett
 - Weboldalon keresztül követhető legyen
 - Welapon látható legyen az étlap
 - Weboldalon keresztül történő rendelések leadása
 - Akár több rendelést is lehessen egyszerre leadni
 - A rendelés mellett látható legyen a szállítási díj is, amennyiben van
 - Amennyiben nagyjából kalkulálható, akkor a szállítási idő megadása
 - Weboldalon keresztül lehessen asztalt foglalni
 - A felmerülő hibák kezelése megállítással vagy figyelmeztetéssel
 
## 8. Használati esetek

![Weboldal használati eset](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/usecase1.png)

## 9. Megfeleltetés, hogyan fedik le a használati esetek a követelményeket
## 10. Képernyő tervek
### Weboldal
![Kezdőoldal terv](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/New%20Wireframe%201.png)

A kezdőoldalt könnyen kezelhetőre próbáljuk meg tervezni a fent lévő menüből lehet majd elnavigálni az oldal egyes részeire, hogy a felhasználók könnyen
elérhessék, amit szeretnének. Mivel ha egy felhasználó fellép a weboldalunkra és nem tud célirányosan navigálni akkor nagy valószínűséggel elhagyja az oldalt.
A háttérben egy bootstrap hero fog működni, ami képeket fog megjeleníteni. Emellett az oldalon szerepelni fog egy rövid leírás az éttermünkről.
Illetve a kapcsolat, hogy hogyan képesek elérni az oldalunkat.
### Applikáció
![Launcher terv](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/New%20Wireframe%202.png)

A launcher letisztult lesz egy főmenüvel índítunk induláskor. Innen ellehet majd navigálni a lényeges menüpontokra.

![Alapanyag felvétel terv](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/New%20Wireframe%203.png)

Alapanyag felvétel egyszerűen fog történni a hozzáadra kattintva egy felugró menüben egy formot kell kitöltenünk majd, az adatbázisban szereplő oszlopok alapján.
Itt lehetőség lesz módosítani ha esetleg elírás történt, vagy esetleg törölni adott esetben. Illetve a gombok mellett az adatbázis jelenlegi tartalmát lehet majd
megtekinteni.


Receptek felvétele a következőképpen fog kinézni:

![Recept felvétel terv](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/New%20Wireframe%204.png)

Kiválasztjuk az ételt a legördülő listából, amihez megszeretnénk adni a receptet majd a hozzáad gombbal felvesszük a szükséges alapanyagokat hozzá.

Ételek felvétele a következőképp fog kinézni:

![Étel felvétel](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/New%20Wireframe%205.png)

Egyszerűen megadjuk majd az ételt és az árát.

## 11. Forgatókönyvek

### Raktár alkalmazás
Az étterem raktár alkalmazásához tartozó használati lehetőségek leírása, mely a rendelés adatbázissal áll összeköttetésben. Az alkalmazott megnyitja az alkalmazást a további 

használathoz. A lentebbi célok az alkalmazott lehetőségei

#### Cél: Rendelések megtekintése
 - Az alkalmazott a Rendelések gombra kattintva megtekinti a leadott rendeléseket

#### Cél: Foglalások megtekintése
 - Az alkalmazott a Rendelések gombra kattintva megtekinti a foglalásokat
 
#### Cél: Alapanyagok megtekintése, törlése
 - Az alkalmazott az egyik alapanyagra kattint
 - A raktár készletét módosíthatja és törölheti manuálisan
 
#### Cél: Receptek hozzáadaása, módosítása, törlése
- Az alkalmazott a 'receptek' gombra kattint
- Hozzáadhat, vagy receptet kijelölve módosíthat illetve törölhet létezó elemet
 
### Weboldal
A vásárló által a weboldal használatát leíró folyamatok. Minden folyamathoz először a vásárló a saját számítógépén egy webböngésző hasnználatával el kell hogy érje a 

weboldalt.  A weboldal a rendelés adatbázison keresztül rögzíti az adatokat a raktár alkalmazásba. Az alábbi célok a vásárló lehetőségei.

#### Cél: Étlap megtekintés
 - A vásárló a weboldal fő oldalán az étlap menüpontra kattintva elérheti az étlapot.
 
#### Cél: Étel rendelés
 - Az étlapról kiválasztja a rendelni kívánt ételt
 - Megadja a lakcímét, a fizetési módot és egyéb kívánságait.
 - A Rendelés véglegesítésével, az étterem megkapja a rendelési értesítést.
 
#### Cél: Asztalfoglalás
 - A vásárló a 'Foglalás' gombra kattint
 - Kijelöli a foglalni kívánt asztalt
 - Megadja a fogalás időpontját
 - Véglegesíti a foglalást, amiről az étterem az alkalmazáson értesítést kap
## 12. Funkció –követelmény megfeleltetés
## 13. Fogalomszótár

**1. Adatbázis:** Az adatbázis más néven Database, számítógépen tárolt adatok összessége, amelyet egy tárolására, lekérdezésére és szerkesztésére alkalmas adatbázis kezelő 
rendszer, más néven DBMS : Database Management System kezel.

**2. Rendszer:** A rendszer fogalma a mai napig nincs pontosan meghatározva. Azonban a rendszer tartalmának meghatározásához meg kell mondanunk, hogy a rendszernek mit kell 
elérnie, és azt, hogy a folyamat sorrán milyen eszközöket és eljárásokat használ annak érdekében, hogy elérje a kívánt célt.

**3. Kliens:** 2 jelentése van: 
 - A kliens lehet egy ügyfél megnevezése, aki egy szolgáltatás igénybe vevője, vagy valakinek / valaminek a megbízója.
 - A kliens lehet egy számítógép, vagy egy azon futó program, amely hozzáfér egy másik hozzáférést nyújtó számítógép hálózat, vagy egy másik számítógép (más néven: szerver) 
 által nyújtott (akár távoli) szolgáltatáshoz.
 
 **4. Specialitás:** A specialitás más néven sajátosság.
 
 **5. Piaci rés:** A piaci rés abban az esetben fordul elő, amennyiben nagyobb a kereslet mint a kínálat, tehát a a kínálat egyáltalán nem, vagy csak részben áll rendelkezésre, 
 de akkor sem annyira, mint amennyire szükség lenne rá. A cégek ezt igyekeznek kihasználni.
 
 **6. Szabvány:** A szabvány egy elismert szervezet által alkotott vagy jóváhagyott, közmegegyezéssel elfogadott dokumentum.
 
 **7. Java fogalma:** A Java általános célú, objektumorientált programozási nyelv, amelyet a Sun Microsystems fejlesztett a 90-es évektől egészen 2009-ig, amikor a céget 
 felvásárolta az Oracle. Azóta az Oracle neve alatt adják ki az újításokat.

 **8. JavaFX fogalma:** A JavaFX egy szkriptnyelv, amelyet 2006-ban adtak ki egy Java változatként. Egyszerűnek szánták, amellyel könnyen lehet aasztali alkalmazást készíteni, 
 és alkalmas grafika, videó, animáció audió és különböző szövegfunkciók elkészítésére.

 **9. JDK fogalma:** A JDK a Java Development Kit rövidítése, amely a Java fordítót, futtató környezetét és fejlesztői eszközeit tartalmazza. 2019. áprilisa óta megszűnt a nyílt 
 letöltése, azonban ennek kiküszöbölésére OpenJDK-ként azóta is teljesen ingyenes.

 **10. MySQL:** A MySQL egy többfelhasználós, többszálú, SQL-alapú relációs adatbázis-kezelő szerver.

 **11. XAMPP:** A XAMPP egy szabad és nyílt forrású platformfüggetlen webszerver-szoftvercsomag.
 
 **12. HTML:** A HTML a HyperText Markup Language rövidítése, amely a weboldalak fejlesztéséhez készült leíró nyelv. Mára már szabvánnyá vált az internet világában, és a W3C 
 támogatja. Aktuális verziója: 5.
 
 **13. CSS:** A CSS a Cascading Style Sheets rövidítése, stílusleíró nyelv, amely HTML vagy XHTML dokumentumok megjelenítéséért felel.
 
 **14. PHP:** A PHP egy szerveroldali szkriptnyelv, amely weblapok elkészítésére szolgál.

 **15. GDPR:** A GDPR az Európai Unió és a Tanács által elfogadott rendelet, amely a személyes adatok védelmét és szabad áramlását szabályozza.


