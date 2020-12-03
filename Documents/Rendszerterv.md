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

### Az adatbázist legeneráló sql script:

```sql
    create table IngredientDataModel (
       id bigint not null,
        amount bigint not null,
        name varchar(255) not null,
        unit varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table MealDataModel (
       id bigint not null,
        name varchar(255) not null,
        price bigint not null,
        menu_id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table MealOrderDataModel (
       amount bigint not null,
        order_id bigint not null,
        meal_id bigint not null,
        primary key (meal_id, order_id)
    ) engine=InnoDB

    create table MenuDataModel (
       id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table OrderDataModel (
       id bigint not null,
        address varchar(255) not null,
        comment varchar(255),
        method_of_payment varchar(255) not null,
        name varchar(255) not null,
        phone_number bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table RecipeDataModel (
       amount bigint not null,
        ingredient_id bigint not null,
        meal_id bigint not null,
        primary key (ingredient_id, meal_id)
    ) engine=InnoDB

    create table ReservationDataModel (
       id bigint not null,
        amount_of_people bigint,
        date datetime(6) not null,
        name varchar(255) not null,
        phone_number bigint not null,
        primary key (id)
    ) engine=InnoDB

    alter table MealDataModel 
       add constraint FKf5xyu3s2l9p9llw6knj3fnrrf 
       foreign key (menu_id) 
       references MenuDataModel (id)

    alter table MealOrderDataModel 
       add constraint FKkoqdi62c187fbgni46lp3bwv4 
       foreign key (order_id) 
       references OrderDataModel (id)

    alter table MealOrderDataModel 
       add constraint FKpoco7atmp072clnjbh4uvqvvo 
       foreign key (meal_id) 
       references MealDataModel (id)

    alter table RecipeDataModel 
       add constraint FKiyaf14yno7mbiw2aiiv72qyai 
       foreign key (ingredient_id) 
       references IngredientDataModel (id)

    alter table RecipeDataModel 
       add constraint FKjhbxnff6cwmu1v1bqwgluotl0 
       foreign key (meal_id) 
       references MealDataModel (id)
```

## Üzleti folyamatok modellje

![uzleti modell](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/uzleti1.jpg)

Az ábra az alkalmazottakra tartozó üzleti folyamatokat mutatja be, pontosabban a teljes folyamat listát, amelyet végrehajthatnak az alkalmazottak a számukra elkészített 
alkalmazásban.


![uzleti modell](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/uzleti2.jpg)

Az ábra a kliensekre, weblapot meglátogató felhasználókra vonatkozik.


![uzleti modell](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/uzleti3.jpg)

Az ábra a rendelési folyamatot mutatja be üzleti modell formályában.

### Megvalósítandó üzleti folyamatok
 - Az alkalmazottak a receptek listájában bármikor hajthassanak végre műveleteket
 - Az alkalmazottak hozzávalókat tudjanak hozzáadni
 - Megjegyzés hozzáadási lehetőség
 - Bejegyzés hozzáadási lehetőség
 - Módosítási lehetőség
 - A weblapon a felhasználó nézegethesse az étlapot/kínálatot
 - A felhasználó számára asztalfoglalási lehetőség
 - Asztalfoglaláshoz a felhasználó tudjon megadni adatokat, ami alapján hozzá társítható a foglalás
 - A felhasználó számára rendelésilehetőség
 - A rendelés leadásához a felhasználó tudjon megadni adatokat, ami alapján hozzá társítható a rendelés
 - Az adatbázzisban az adatok megfelelő kezelése

### Üzleti szereplők
 - Az alkalmazást kezelő alkalmazottak
 - Alkalmazottak: az étterem teljes személyzete
 - A kliensek/felhasználók, akik a weblapot látogatják és használják
 - Kliensek/felhasználók: mindenki, aki a weblapot használja
 
### Üzleti entitás(ok)
 - Userek
 - A userek jelen esetben a felhasználók és az alkalmazottak
 

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

A szabványok segítségével mindenki azonos szabályokat követ, amivel pedig elérhetjük, hogy az oldalak fenntartása olcsóbb legyen, hatékonyabban, megbízhatóbb és gyorsabban 
működjön. A nagyobb, internetre szabványokat kiadó szervezetek példul: W3C, ECMA, IETF, WHATWG.

A weboldal elkészítésénél nézhetjük az egyik legaktuálisabb szabványt is, a HTTPS protokollt. Alapja a jól ismert HTTP protokoll, ami ki lett egészítve egy SSL vagy TLS 
réteggel, amely titkosítási célt szolgál, pontosabban kommunikáció titkosításit.

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

![Weboldal](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/Képernyőterv1.png)

A weboldal terve egy letisztult, de mégis elegánsabb design. Bootstrappel megvalósítva, hogy mind a számítógép, mind a mobiltelefon kijelzőjéhez illeszkedjen.

#### Applikáció

Az applikáció indulásakor a következő képernyő fogad minket ez a főképernyő innen vagyunk képesek elnavigálni a különböző view-okra:

![Weboldal](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/Képernyőterv2.png)

A gombok hover animációt kaptak. 

Az információk minden nézetben hasonlóan jelennek meg a következő ablakban fogadnak minket egy táblázatban:

![Weboldal](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/Képernyőterv3.png)

A hozzáadás a következőképpen lett megvalósítva:

![Weboldal](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/Képernyőterv4.png)

A módosításnál az értékek a kiválasztott elem értékeivel töltődnek fel alapértelmezetten:

![Weboldal](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/Képernyőterv5.png)

A hozzáadás és módosítás viewenként eltérő. Viszont a törlés mindig hasonlóképp van megvalósítva. 

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
- Tehát az ingyenesek közül inkább a 000webhostot javasoljuk

## Implementációs terv
![Implementációs terv](https://github.com/Savitar97/SZFM_2020_12_2_NP/blob/main/Documents/Resources/ImplementationPlan.png)

# Fogalomszótár

## Adatbázis fogalmai nagyvonalakban

- relációs modell: olyan adatmodell, amely egy logikai adatbázis kereteit határozza meg; definiálja az adatbázis adatszerkezeteit és az azok között fennálló kapcsolatokat, 
relációkat;
- adatbázis tábla: egy valós világbeli entitás absztrakcióval;
- attribútum: egy modellezett objektum olyan tulajdonsága,a mely jelentőséggel bír az adatbázisban;
- elsődleges kulcs: egyedileg azonosítja  atáblában található rekordokat;
- külső kulcs: olyan mező, amely egy másik tábla elsődleges kulcsára hivatkozik, ezzel összekapcsolva  akét táblát;
- szigettábla: olyan tábla, amelynek nincs kapcsolata más táblákkal, tehát nem függ más tábláktól;

## Üzleti folyamatok modelljéhez és a követelményekhez tartozó fogalmak
- Kliens: 2 jelentése van:
  - A kliens lehet egy ügyfél megnevezése, aki egy szolgáltatás igénybe vevője, vagy valakinek / valaminek a megbízója.
  - A kliens lehet egy számítógép, vagy egy azon futó program, amely hozzáfér egy másik hozzáférést nyújtó számítógép hálózat, vagy egy másik számítógép (más néven: szerver) 
 által nyújtott (akár távoli) szolgáltatáshoz.
- Rendszer: A rendszer fogalma a mai napig nincs pontosan meghatározva. Azonban a rendszer tartalmának meghatározásához meg kell mondanunk, hogy a rendszernek mit kell elérnie, 
és azt, hogy a folyamat sorrán milyen eszközöket és eljárásokat használ annak érdekében, hogy elérje a kívánt célt.
- Szabvány: A szabvány egy elismert szervezet által alkotott vagy jóváhagyott, közmegegyezéssel elfogadott dokumentum.
- GDPR: A GDPR az Európai Unió és a Tanács által elfogadott rendelet, amely a személyes adatok védelmét és szabad áramlását szabályozza.
- Input: Adatbemenet, vagy beviteli adatnak is nevezhetjük másképp.
- HTTP: HyperText Transfer Protocol, amely egy információáviteli protokoll elosztott információs rendszerekhez.
