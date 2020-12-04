# Weboldal tesztelése
 
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
