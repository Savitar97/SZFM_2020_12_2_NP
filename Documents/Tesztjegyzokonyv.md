# Weboldal tesztelése

## Asztalfoglalás

- Foglalás gombra kattintva (név mezőt üresen hagyva) megjelenik,hogy töltse ki a név mezőt => üresen hagyott mező kezelés működik
- Foglalás gombra kattintva (email mezőt üresen hagyva) megjelenik,hogy töltse ki az email mezőt => üresen hagyott mező kezelés működik
- Foglalás gombra kattintva (email mezőt hibásan kitöltve) megjelenik,hogy adjon meg egy email címet => hibásan beírt mező kezelése működik
- Foglalás gombra kattintva (telefonszámot üresen hagyva) megjelenik,hogy töltse ki a telefonszám mezőt => üresen hagyott mező kezelés működik
- Foglalás gombra kattintva (dátum üresen hagyva) megjelenik,hogy töltse ki a dátum mezőt => üresen hagyott mező kezelés működik
- Foglalás gombra kattintva (időpontot nem kiválasztva) megjelenik,hogy jelöljön ki egy elemet a listából => nem kiválasztott mező kezelés működik
- Foglalás gombra kattintva (főt üresen hagyva) megjelenik,hogy töltse ki a mezőt => üresen hagyott mező kezelés működik
- Foglalás gombra kattintva (kevesebb mint 4 karakter hosszú nevet megadva) megjelenik, hogy "A név legalább 4 karakterből álljon!" => név validáció működik
- Foglalás gombra kattintva (telefonszám kevesebb mint 9 karakter) megjelenik, hogy "Legalább 9 karakternek kell lennie a telefonszámnak!" => telefonszám 
  validáció működik
- Foglalás gombra kattintva (hibás dátum értéket megadva) megjelenik, hogy "YYYY.MM.DD formátumban add meg a dátumot!" => dátum validáció működik
- Foglalás gombra kattintva (adatokat helyesen megadva) megjelenik egy loading gomb => loading animáció működik
- Foglalás gombra kattintva (az adatokat helyesen kitöltve) az adat megjelenik az adatbázisban => adatbázis feltöltés sikeres

# Asztali alkalmazás tesztelése

## Alapanyagok raktár tesztelése

- alapanyagok gombra kattintva megjelenik a raktárablak => navigáció működik;
- hozzáadás gombbal alapanyag felvétele a raktárba => adatbázisba való felvétel működik;
- alapanyag felvétele és módosítása ablakokban vissza gomb működik => helyes navigáció;
- kattintással kiválasztható, adatbázisban levő alapanyag (név, mennyiség, mértékegység) módosítása => update működik;
- kattintással kiválasztott alapanyag törlése => törlés gomb működik;
- bármilyen módosítás esetén az alapanyagok táblázata frissül => refresh működik;

## Hiánycikkek lista tesztelése

- Hiánycikkek gombra kattintva megjelenik a megfelelő ablak => navigáció működik;
- ha valamely alapanyag mennyisége a hat alá csökken, bekerül a listára => sql lekérdezés működik
- mindig csak az aktuális hiánycikkek jelennek meg => nem szükséges a törlés

## Asztalfoglalások tesztelése

- Foglalások gombra kattintva megjelenik a megfelelő ablak => navigáció működik;
- hozzáadás gombbal asztalfoglalás felvétele a raktárba => adatbázisba való felvétel működik;
- asztalfoglalás felvétele és módosítása ablakokban vissza gomb működik => helyes navigáció;
- kattintással kiválasztott asztalfoglalás módosítása működik => helyes az adatbázis update;
- kattintással kiválasztott asztalfoglalás törlése működik => helyes a delete;
- módosításkor a TextFieldek tartalmazzás a korábbi információkat (pl név, telefonszám, időpont), így egyszerűbb az update, például olyan esetben, ha valaki csak egy mezőt 
szeretne módosítani
- Foglalás időpontjának kiválasztása legördülő listákkal működik => javaFX comboBox működik;
- Asztalfoglalás időpontja sztringként jelenik meg a táblázatban => date formatting működik;
