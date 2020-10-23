# Rendszerterv

## Rendszer céljai és nem céljai

### Célok:

- a rendszernek saját adatbázissal kell rendelkeznie, amelyhez hozzáférhet mind az asztali alkalmazás és az étterem weboldala is;
- az adatbázisban tárolva legyenek a raktáron levő alapanyagok;
- az adatbázisban tárolva lesz minden alapanyag raktáron levő mennyisége;
- az adatbázisban tárolva lesz az étterem menüsora;
- tárolni kell az ételekben szereplő alapnanyagokat;
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
- a weboldalon lehetőség kell, hogy legyen asztalfoglalásra;

### Nem célok:

- a weboldalon keresztül nem lehetséges online bankkártyás fizetés, tehát nem kezelünk érzékeny banki adatokat;
- az étterem nem használhatja fel a kliensek érzékeny személyes adatait a későbbiekben;
- az asztali alkalmazás nem kezeli az alapanyagok rendelését, csak egy listát szolgáltat a beszerzéssel foglalkozó személyzetnek a kifogyóban levő alapanyagokról;

## Projekt terv

A projekten négy programtervező informatikus hallgató dolgozik, ábécé sorrend szerint a következők:

- Ádám Petra
- Kun - Limberger Anett
- Orosz Máté
- Tóth Attila

### Mérföldkövek, ütemterv:

- A projekt kezdete: 2020. október 5.
- A projekt határideje: 2020. december 7.
- A dokumentáció elkészültének határideje: 2020. október 19.
- Demó bemutatása: 2020. november 2.

## Adatbázis terv

![db modell](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/dbmodel.png)

A fenti ábrán látható a rendszer adatbázisának relációs modellje, amely hét táblát tartalmaz, ezek leírása a következő:

INGREDIENT tábla: az alapanyagok táblája

- ID: automatikusan generált érték, elsődleges kulcs
- name: az alapanyag neve
- amount: az alapanyag mennyisége
- unit: az alapanyag mennyiségének mértékegysége

ORDER tábla: a rendeléseket tartalmazza

- ID: automatikusan generált elsődleges kulcs
- name: a kliens neve
- phone_number: a kliens telefonos elérhetősége
- address: szállítási cím
- methof_of_payment: fizetési mód 
- comment: opcionális megjegyzés

MEAL tábla:

- ID: automatikusan generált elsődleges kulcs
- name: az étel neve
- price: az étel ára

ORDER_MEAL tábla: a rendelések és az ételek közötti many-to-many kapcsolótábla

- ORDERID: a rendelés azonosítója
Ez egy külső kulcs az ORDER tábla elsődleges kulcsára
- MEALID: az étel azonosítója
Ez egy külső kulcs a MEAL tábla elsődleges kulcsára
A fenti két attribútum együtt alkotja a tábla elsődleges kulcsát.
- amount: az ételből rendelt mennyiség

MENU tábla: az étlapot tartalmazza
A MENU és a MEAL tábla között one-to-many kapcsolat áll fenn.

- ID: elsődleges kulcs
- MEALID: az étel azonosítója
Ez külső kulcs a MEAL tábla elsődleges kulcsára

RECIPES tábla: az alapanyagok és az ételek many-to-many kapcsolótáblája

- INGREDIENTID: az alapanyag azonosítója
Ez egy külső kulcs az INGREDIENT tábla elsődleges kulcsára
- MEALID: az étel azonosítója
Ez egy külső kulcs a MEAL tábla elsődleges kulcsára
- amount: az alapanyagból szükséges mennyiség

RESERVATION sziggetábla:

- ID: automatikusan generált elsődleges kulcs
- name: a foglaló kliens neve
- phone_number: a kliens telefonszáma
- date: a foglalás időpontja
- number_of_people: a személyek száma

## Követelmények

### Funkcionális követelmények

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
 
### Nem funkcionális követelmények

 - Letisztult grafikus felületet kell biztosítani.
 - Olyan személynek se jelentsen gondot a használat, aki informatikai alapismeretekkel nem igazán rendelkezik.
 - Felesleges adatokat ne kapjanak a felhasználók, tehát csak azok az adatok kerüljenek megjelenítésre, amelyekre ténylegesen szükségük is van a használathoz.
 - Csak az aktuális információk megjelenítése.
 - A törölt bejegyzések valóban tűnjenek el.
 - Amennyiben módosítanak egy bejegyzést, akkor az rögtön váljon elérhetőve.
 - Platformfüggetlennek kell lennie.
 - Reszponzív webdesing.
 
### Jogi követelmények

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
 
A licenccelést az előbb említettem, szóval áttérnék a másik két pontra. A felhasználók adatainak védelme nagyon fontos számunkra is, és az étterem számára is, mivel nem 
szeretnének elégedetlen vendégeket, akik, ha kikerültek adataik az étterem felhasználásán kívülre, jobb esetben csak idegesítő vagy zavaró körleveket kapnak, azonban rosszabb 
esetben vissza is élhetnek csalók ezekkel az adatokkal, aminek komoly következményei lehetnek mind a felhasználó, mind az étterem számára. Ugyanis a felhasználót ezáltal akár 
meg is lophatják, vagy illetéktelenül használhatják az adataikat, az étterem szempontjából viszont egy jogi pert kockáztathatnak meg, ami nem csak kliens vesztéssel járna, hanem 
akár az étterem bezárását is eredményezheti. Tehát a tét nem kicsi.

A következő lényeges dolog, amire még érdemes figyelni, az a szabványok használata, hiszen ezeket sem véletlenül találták ki, hanem fontos feladatot látnak el.

## Funkcionális terv

A készítendő weboldal könnyen átlátható, modern megoldásokkal biztosítsuk az átláthatóságot.A vendégek innen fogják elérni menüpontokon kereszült a napi menüt,
itt fognak tudni asztalt foglalni, illetve rendelni. Mindezek menüpontokon keresztül lesznek elérhetőek egy főmenün keresztül ami az oldal tetején fog megjelenni.
Emellett az oldal információkat fog közölni az éttermünkről. A felhasználóknak nem kell bejelentkezni az oldalunk megtekintéséhez illetve a rendelés sincs
regisztrációhoz kötve.

Az asztali alkalmazás az étterem dolgozóinak fog készülni, hogy meggyorsítsuk és megkönnyítsük a munkáikat. Ehhez könnyen kezelhetőnek, nagy szaktudást nem
igénylőnek kell lennie. Egy főmenüt fogunk tervezni, amelyből eltudunk navigálni a rendszer minden funkcionalitásához.A felhasználó nem bonyolult sql parancsokkal
hanem egyszerű, megszokott gombokkal szövegmezőkkel fog találkozni.

### Képernyőtervek
#### Weboldal
#### Applikáció

## Telepítési terv

### Felhasználói oldal

Szükséges:

- Internet kapcsolat
- Telepített operációs rendszer
- Telepített webböngésző
- Saját webtárhely bérlése
- Saját domain cím bérlése

### A cég részéről

- XAMPP feltelepítése
- Megfelelő java verzió feltelepítése
- Webtárhelyen a szükséges konfigurációk beállítása

XAMPP:
- Ingyenes webszerver csomag
- Tartalmazza a MySQL adatbázis szervert
- Apache webszervert tartalmaz
- Tartalmazza a PHP és Perl nyelvek végrehajtó rendszereit
- Nyílt forráskódú(Open source)
- Ideális kis és közepes vállalatoknak
- Integrált keretrendszer
- A csomag tartalmaz mindent, ami a webes alkalmazásokhoz szükséges lehet

Java verzió:
- 13 és afölött lévő verziókat támogat a programunk

Webtárhely:
- Ingyenes webtárhelynek az atw.hu-t és a 000webhostot ajánljuk.
- A 000webhostnál választható PHP-verziók vannak, köztük naprakészen a legfrissebbek is szerepelnek.
- Mindemellett a 000webhostnál alapból telepítve van a mysql adatbázis
