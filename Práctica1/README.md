# Práctica 1: Lógica Computacional

El propósito de esta práctica es que alumno desarrolle un prototipo de sistema en Prolog para resolver un problema que se pueda representar de formanatural mediante reglas.

## Problema a resolver: Sudoku

El sudoku es un rompecabezas lógico con una estructura básica fija. El objetivo del sudoku es rellenar una cuadrícula siguiendo una serie de reglas principales.  

## Reglas del sistema en lenguaje natural

* La cuadricula se presenta normalmente como una tabla de 9 × 9, compuesta por subtablas de 3 × 3 denominadas "secciones".
* Algunas celdas ya contienen números, conocidos como "pistas".
* Se tienen que rellenar las celdas vacías, con un número en cada una de ellas, de tal forma que cada columna, fila y seccion contenga los números 1–9 solo una vez.

## Explicacion del programa

El programa recibe una matrice, esta matrice es una lista que contiene 9 listas conformadas por 9 espacios cada una; dentro de la analogia del juego corresponden a las filas, columnas y secciones que simulan la cuadricula del sudoku. Para facilitar la implementación del programa los espacios vacios son representados por un 0.

Lo que busca es sustituir, con fuerza bruta, estos ceros a medida se vaya encontrando con una solucion que satisfagan las reglas. Una vez encontrada, regresa la matrice de la solucion y **True**. En caso de no tener solucion indica **False**.

### Implementación

#### Input

Una matrice con la cantidad de pistas cualquiera:

``` bash
?- sudoku([
[0,0,6,0,3,1,0,0,2],
[5,1,0,0,0,0,0,4,8],
[0,0,2,7,0,5,0,0,0],
[9,0,8,0,0,3,0,0,0],
[0,0,0,1,0,8,0,0,0],
[0,0,0,5,0,0,9,0,7],
[0,0,0,8,0,6,1,0,0],
[6,2,0,0,0,0,0,5,4],
[1,0,0,2,5,0,3,0,0]
]).
```

#### Output

La solucion sudoku de esa matrice:

``` bash
[8,7,6,4,3,1,5,9,2]
[5,1,3,9,6,2,7,4,8]
[4,9,2,7,8,5,6,3,1]
[9,4,8,6,7,3,2,1,5]
[2,5,7,1,9,8,4,6,3]
[3,6,1,5,2,4,9,8,7]
[7,3,5,8,4,6,1,2,9]
[6,2,9,3,1,7,8,5,4]
[1,8,4,2,5,9,3,7,6]
true.
```

### Ejemplos

Ejemplo de una solución:

``` bash
?- sudoku([
[3,0,6,5,0,8,4,0,0],
[5,2,0,0,0,0,0,0,0],
[0,8,7,0,0,0,0,3,1],
[0,0,3,0,1,0,0,8,0],
[9,0,0,8,6,3,0,0,5],
[0,5,0,0,9,0,6,0,0], 
[1,3,0,0,0,0,2,5,0],
[0,0,0,0,0,0,0,7,4],
[0,0,5,2,0,6,3,0,0]
]).

[3,1,6,5,7,8,4,9,2]
[5,2,9,1,3,4,7,6,8]
[4,8,7,6,2,9,5,3,1]
[2,6,3,4,1,5,9,8,7]
[9,7,4,8,6,3,1,2,5]
[8,5,1,7,9,2,6,4,3]
[1,3,8,9,4,7,2,5,6]
[6,9,2,3,5,1,8,7,4]
[7,4,5,2,8,6,3,1,9]
true.
```

Ejemplo de un sudoku MUY dificil (puede tardar mas de 2 minutos para dar una solución):

``` bash
?- sudoku([
[0,0,0,0,5,0,0,0,0],
[0,0,0,0,9,1,0,4,0],
[0,4,0,3,0,0,6,0,5],
[0,0,4,0,0,0,5,0,0],
[6,0,0,9,0,5,0,0,1],
[0,0,1,0,0,0,7,0,0],
[9,0,5,0,0,2,0,8,0],
[0,2,0,6,3,0,0,0,0],
[0,0,0,0,7,0,0,0,0]
]).

[8,7,6,4,3,1,5,9,2]
[5,1,3,9,6,2,7,4,8]
[4,9,2,7,8,5,6,3,1]
[9,4,8,6,7,3,2,1,5]
[2,5,7,1,9,8,4,6,3]
[3,6,1,5,2,4,9,8,7]
[7,3,5,8,4,6,1,2,9]
[6,2,9,3,1,7,8,5,4]
[1,8,4,2,5,9,3,7,6]
true.
```

Ejemplo de una matrice sin solucion:

``` bash
?- sudoku([
[0,3,0,0,0,0,0,0,0],
[0,0,1,0,0,1,0,6,0],
[0,5,0,0,0,0,6,0,5],
[0,0,4,0,0,0,5,0,0],
[6,0,0,0,0,5,0,0,9],
[0,0,1,0,0,3,0,0,0],
[9,0,0,8,0,0,0,0,5],
[1,0,0,6,3,0,0,0,0],
[0,0,0,0,0,0,3,0,0]
]).
false.
```
