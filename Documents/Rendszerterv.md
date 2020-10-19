# Rendszer céljai és nem céljai

## Célok:

- a rendszernek saját adatbázissal kell rendelkeznie, amelyhez hozzáférhet mind az asztali alkalmazás és az étterem weboldala is;
- az adatbázisban tárolva legyenek a raktáron levő alapanyagok;
- az adatbázisban tárolva lesz minden alapanyag raktáron levő mennyisége;
- az adatbázisban tárolva lesz az étterem menüsora;
- tárolni kell az ételekben szereplő alapnayagokat;
- tárolni kell a menü mellett az árlistát is;
- az alapanyagok mennyiségét egységekben kell kifejezni, ahol az egység minden termék esetében mást fog jelenteni (pl egy kg liszt egy egységnek számít), ehhez pedig magyarázat 
fog tartozni;
- amennyiben egy hozzávaló kifogyóban van, azaz az adatbázisban tárolt mennyisége egy bizonyos érték alá csökken, akkor ez fel kell kerüljön egy "Készlethiányban levő 
alapanyagok" listára;
- a weboldal felületén a felhasználó számára elérhető kell, hogy legyen a teljes aktuális menüsor az árlistával együtt (forintban értve);
- a menüben fel kell tüntetni az egyes ételek alapanyagait, hogy a kliensek megbizonyosodjanak róla, nem kapnak olyan ételt, amelybe olyan alapanyag kerülhet, ami esetleges 
allergiás reakciót válthatna ki;
- a felhasználónak lehetősége lehet kiválasztani készpénzes vagy kártyás fizetést, amikor leadja a rendelését;
- a weboldalon fel kell tűntetni a kiszállítás idejének egy időintervallumát;
- a weboldalon fel kell tűntetni a kiszállítás árárt;
- a weboldalon meg kell jelenjen a vendéglátóipari egység telefonos elérhetősége is;

## Nem célok:

# Projekt terv

A projekten négy programtervező informatikus hallgató dolgozik, ábécé sorrend szerint a következők:

- Ádám Petra
- Kun - Limberger Anett
- Orosz Máté
- Tóth Attila

## Mérföldkövek, ütemterv:

- A projekt kezdete: 2020. október 5.
- A projekt határideje: 2020. december 7.
- A dokumentáció elkészültének határideje: 2020. október 19.
- Demó bemutatása: 2020. november 2.

# Adatbázis terv

![db modell](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/dbmodel.png)

A fenti ábrán látható a rendszer adatbázisának relációs modellje, amely hét táblát tartalmaz, ezek leírása a következő:

INGREDIENT tábla:

ORDER tábla:

ORDER_MEAL tábla:

MEAL tábla:

MENU tábla:

ORDER tábla:

RESERVATION sziggetábla:

# Követelmények

## Funkcionális követelmények

 - A rendszerbe feltöltött adatok ponttos tárolása.
 - A felhasználó nem kaphat hamis adatot vagy eredményt.
 - Az adatok adatvédelem szerint történő tárolása.
 - Az inputok helyes kezelése.
 - Amennyiben egy művelet nem sikerül az alkalmazásban, arról az alkalmazott kapjon tájékoztatást.
 - Amennyiben egy művelet nem sikerül a weblapon, arról a felhasználó kapjon tájékoztatást.
 - Egyéb esetben az előző 2 pontot szegjük meg.
 - Az alkalmazás és weboldal adatbázisában szereplő adatok átfedőek legyenek.
 - Felhasználóbarát élmény nyújtása az alkalmazást használó alkalmazottak számára.
 - Az alkalmazottak számára elérhető legyen az étlap és a receptek.
 - Az alkalmazottaknak legyen lehetősége módosítani az étlapon és a recepteken.
 - Felhasználóbarát élmény nyújtása a weblapot meglátogató, és használó felhasználók számára.
 - A weblap felhasználói láthassák a weblapon az étlapot és a recepteket.
 - A weblap felhasználóinak legyen lehetősége rendelni.
 - A weblap felhasználóinak legyen lehetősége esetleges megjegyzést fűzni a rendelésükhöz.
 - A weblapon keresztül is legyen lehetőség asztalfoglalásra.
 
## Nem funkcionális követelmények

 - Letisztult grafikus felületet kell biztosítani.
 - Olyan személynek se jelentsen gondot a használat, aki informatikai alapismeretekkel nem igazán rendelkezik.
 - Felesleges adatokat ne kapjanak a felhasználók, tehát csak azok az adatok kerüljenek megjelenítésre, amelyekre ténylegesen szükségük is van a használathoz.
 - Csak az aktuális információk megjelenítése.
 - A törölt bejegyzések valóban tűnjenek el.
 - Amennyiben módosítanak egy bejegyzést, akkor az rögtön váljon elérhetőve.
 - Platformfüggetlennek kell lennie.
 - Reszponzív webdesing.
 
## Jogi követelmények

Ahhoz, hogy a projektünk valóban felhasználható legyen, és ne veszítse értelmét az egész, léteznek jogi követelmények, amelyeket be kell tartanunk. Ilyenek például a szerői 
jogok, amely arra szolgál, hogy a szerző eldönthesse, hogy az általa létrehozott (akár szellemi) termék hogyan legyen felhasználható. Ez általában úgy néz ki, hogy a termék vagy 
a szerző külön engedélyével használható, vagy ingyen használható, amennyiben meg van jelölve az eredeti szerző, vagy a szerző a terméket No Copyright lincenccel látja el, amely 
értelmében a termék szabadon felhasználható (de lehetne még sorolni). Összgezve: a szerző maga dönti el, hogy hogyan használhatják fel más felhasználók az általa létrehozott 
terméket.

Jelen esetben viszont a Bambusz Étterem számára készítjük az applikációt és a weblapot, amiért felelősséggel tartozik egy részről a fejlesztői csapat is, más részről pedig az 
étterem, és az alkalmazottjai is. Emiatt lényegessé váltak a következő lépések a projekt elkészítése során, hiszen a célunk egy jól alkalmazható, támogatott és igény esetében 
fejleszthető alkalmazás és weboldal elkészítése:

 - A projekt során felhasznált illusztrációk, képek vagy egyéb grafikai elemek a projekt készítői által lettek elkészítve, vagy No Copyright licenccel lettek ellátva, ami által 
szabadon felhasználhatóak.
 - A felhasználók adatainak védelme.
 - Az eddig kiadott szabványoknak történő megfelelés.
