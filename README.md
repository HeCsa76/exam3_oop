### Farm szimulátor
Van egy farm ahol malacokat és marhákat tartanak. Etetéskor nő az állatok mérete és amikor elérik a vágósúlyt akkor a mészáros levágja az állatokat. Készítsd el az alábbi leírás szerinti java code-ot!

#### Animal osztály
- Helye: `com.codecool.farm.animal` package
- Tartalmazza a következő field-et:
  - méret `int size`
- Az állatok mérete nem állítható a constructor-al, alapértelmezetten az állat létrejöttekor 0.
- A méret field-hez tartozik egy getter.
- Minden állatot meg lehet etetni a `feed()`, ennek megvalósítása állat típusonként különböző.

#### Cattle osztály
- Helye: `com.codecool.farm.animal` package
- Amikor megetetik mérete 2-vel növekszik.

#### Pig osztály
- Helye: `com.codecool.farm.animal` package
- Amikor megetetik mérete 1-el növekszik.

#### Butcher osztály
- Helye: `com.codecool.farm` package
- Tartalmaz egy `boolean canButcher(Animal animal)` metódust ami visszaadja, hogy a paraméterben megadott állat levágható-e. Egy állatot akkor lehet levágni ha mérete nagyobb 4 egységnél.

#### Farm osztály
- Helye: `com.codecool.farm` package
- Egy állatokból álló listában tárolódnak a farmon található állatok. Ez a lista a constructorban megadható.
- `feedAnimals()` method:
  - feladata: A farmon lévő összes állat megetetése.
- `butcher(Butcher butcher)` method:
  - feladata: Az összes levágható állat eltávolítása a farmon lévő állatokat tartalmazó listából.
- `boolean isEmpty()` method:
  - feladata: Igazat ad vissza, ha a farmon nincsenek állatok, egyébként hamisat ad.
- `List<String> getStatus()` mehod:
  - feladata: Az állatok státuszait tartalmazó listát ad vissza, a farmon lévő összes állatra vonatkozóan. A lista elemei a következő formátumot követik: "There is a <állat mérete> sized <állat típusa (pig/cattle)> in the farm."
