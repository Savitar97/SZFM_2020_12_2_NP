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
Az étterem sok különböző alapanyagot használ. Mindemellett az ételek is választékosak: modern,hagyományos ételspecialitások ötvözve a hazai(magyar) és nemzetközi konyhát.
Emellett az étterem magába foglal egy pékséget és egy cukrászdát is. 
Tehát péksütemény és sütemény receptek is rendelkezésre állnak és az ezek elkészítéséhez szükséges alapanyagok.
Minden héten különböző menük érhetőek el, de vannak visszatérő ételek illetve a'la carte, amely a hét minden napján elérhető, emellett hetente van egy séf ajánlata is az adott hétre.

&nbsp;&nbsp;&nbsp;&nbsp;Az átláthatatlan leltárvezetés miatt azonban egyre többször fordult elő, hogy az alapanyag előbb fogyott el mint szükséges lett volna. 
Mivel a papír alapú leltáron még szerepelt az adott nyersanyag, emiatt nem rendeltek még belőle árut.
Ezen okokból kifolyólag egyre gyakrabban fordult elő az, hogy egy adott étel az adott nap hamarabb lekerült az étlapról, vagy rendelés érkezett, de sajnos már csak annyit tudtunk 
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

## 3. A rendszerre vonatkozó szabályok

Ide az úgynevezett "szabályokat" sorolhatjuk, amelyek, ha kifejtjük, akkor az aktuális törvényi megszorításokat és rendeleteket, a különböző ezzel foglalkozó szerezetek által
kiadott szabványokat és ajánlásokat jelentik, illetve az általunk megfogalmazott kikötések a program / alkalmazás szempontjából tekintve, amelyek befolyásolják a kapott
végkimenetelt.
Kicsit részletesebben kifejtve ezek a következők:

### 3.1 Az applikáció kidolgozásához a következőkre van szükség:
 - Java, ahol megkötés a verziószámban: minimum 13-as
 - JavaFX, ahol a használt verzió: 14-es
 - Adatbáziskezelés a háttérben: MySQL, Apache és XSAMPP
 



## 4. Jelenlegi üzleti folyamatokmodellje
### 4.1 Raktár kezelése:
4.1.1 Alkalmazott=>Alapanyagok megszámolása=>Feljegyzés papírra

4.1.2 Alkalmazott=>Receptek felírása=>Papírra,keményfedelű jegyzetfüzetbe

4.1.3 Alkalmazott=>Feljegyzett készletek=>Hiányzó készletek meghatározása=>Áru rendelése

### 4.2 Interakciók az ügyfelekkel
4.2.1 Étterem=>Televízió,rádió,hirdetőfelület=>Hirdetés

4.2.2 Ügyfél=>Asztalfoglalás=>Személyesen az étteremben

4.2.3 Ügyfél=>Étel rendelés=>Személyesen az étteremben=>Evitelre vagy helyben fogyasztva

4.2.4 Alkalmazott=>Ügyfél=>Asztalfoglalás bejegyzése

4.2.5 Alkalmazott=>Ügyfél=>Rendelés felvétele

## 5. Igényelt üzleti folyamatok modellje
### 5.1 Alkalmazott-Leltár-Recept
5.1.1 Alkalmazott=>Alkalmazás=>Leltár feltöltése

5.1.2 Alkalmazott=>Alkalmazás=>Elgépelt érték javítása

5.1.3 Alkalmazott=>Alkalmazás=>Alapanyag törlése

5.1.4 Alkalmazott=>Alkalmazás=>Alapanyagok listázása

5.1.5 Alkalmazott=>Alkalmazás=>Recept feltöltése

5.1.6 Alkalmazott=>Alkalmazás=>Recept módosítása

5.1.7 Alkalmazott=>Alkalmazás=>Recept törlése

5.1.8 Alkalmazott=>Alkalmazás=>Receptek lekérdezése

![Felhasználó,raktár,recept](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/elsodiagram.png)
## 6. Követelménylista
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
 - Weboldalon keresztül lehessen asztalt foglalni
 - A felmerülő hibák kezelése megállítással vagy figyelmeztetéssel
## 7. Használati esetek
## 8. Megfeleltetés, hogyan fedik le a használati esetek a követelményeket
## 9. Képernyő tervek
## 10. Forgatókönyvek
## 11. Funkció –követelmény megfeleltetés
## 12. Fogalomszótár


