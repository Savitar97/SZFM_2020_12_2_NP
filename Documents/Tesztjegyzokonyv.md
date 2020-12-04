# Weboldal tesztelése
 
# Asztali alkalmazás tesztelése

## Alapanyagok raktár tesztelése

- alapanyagok gombra kattintva megjelenik a raktárablak => navigáció működik;
- hozzáadás gombbal alapanyag felvétele a raktárba => adatbázisba való felvétel működik;
- kattintással kiválasztható, adatbázisban levő alapanyag (név, mennyiség, mértékegység) módosítása => update működik
- kattintással kiválasztott alapanyag törlése => törlés gomb működik
- bármilyen módosítás esetén az alapanyagok táblázata frissül => refresh működik

## Hiánycikkek lista tesztelése

- ha valamely alapanyag mennyisége a hat alá csökken, bekerül a listára => sql lekérdezés működik
- mindig csak az aktuális hiánycikkek jelennek meg => nem szükséges a törlés

## Asztalfoglalások tesztelése
