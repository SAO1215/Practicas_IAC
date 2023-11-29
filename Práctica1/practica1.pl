% Práctica 1: Lógica Computacional
% Inteligencia Artificial e Ingeniería del Conocimiento

% Genera una solucion para el sudoku.
sudoku(Matrice) :-
    % Remplaza los 0 por los números 1-9 y
    % comprueba que la matrice hasta que
    % tenga una solucion correcta.
    matrice_tanteo(Matrice, NMatrice),
    matrice_valida(NMatrice),
    sudoku(NMatrice), !.

sudoku(Solucion) :-
    % Cuando la matrice de la solucion no contenga 0,
    % revisa si es una solucion correcta.
    matrice_sin_ceros(Solucion),
    matrice_valida(Solucion),
    % Imprime la solucion del sudoku.
    mostrar_sudoku(Solucion), !.


% Regresa True si cumple con las reglas del sudoku.
matrice_valida(Matrice) :-
    % Comprueba las filas.
    valida_filas(Matrice),
    % Comprueba las columnas.
    transpone(Matrice, Transpuesta),
    valida_filas(Transpuesta),
    % Comprueba las secciones.
    matrice_por_secciones(Matrice, Secciones),
    valida_filas(Secciones), !.


% Realiza la operacion de transpuesta, donde los elementos de
% la matrice en fila pasan a ser columa y viceversa.
transpone([Head|_], Transpuesta) :-
    Head = [],
    Transpuesta = [].

transpone(Matrice, [Columna|Transpuesta]) :-
    primera_columna(Matrice, Columna, NMatrice),
    transpone(NMatrice, Transpuesta).


% Genera las columnas del sudoku en base a las filas de la matrice.
primera_columna([], Columna, NMatrice) :-
    Columna = [],
    NMatrice = [].

primera_columna([H|T], [H2|Proxima], [T2|Resto]) :-
    [H2|T2] = H,
    primera_columna(T, Proxima, Resto).


% Comprueba si las filas de la matrice no tienen duplicados
% aparte de los 0.
valida_filas([]).
valida_filas([H|T]) :-
    fila_valida(H),
    valida_filas(T).

% Auxiliar para corroborar que una fila no tenga 0,
% ni numeros duplicados
fila_valida(Fila) :-
    % Predicado de prolog que filtra elementos en los que falla el objetivo.
    exclude(=(0), Fila, FilaSinCeros),
    % Revisa que no haya repeticiones en la FilaSinCeros.
    sin_duplicados(FilaSinCeros), !.


% Comprueba que no haya repeticiones.
sin_duplicados([]).
sin_duplicados(L) :-
    % Predicado de prolog para obtener una lista
    % ordenada de alternativas sin duplicados.
    setof(X, member(X, L), Set),

    % Cuando la longitud es la misma significa que
    % no hay duplicados.
    length(Set, Longitud),
    length(L, LongitudInicial),
    Longitud = LongitudInicial, !.


% Separa la matrice en cada una de las filas que la componen,
% esto facilita evaluar la seccion.
matrice_por_secciones([A,B,C,D,E,F,G,H,I], [[A1,A2,A3,B1,B2,B3,C1,C2,C3],[A4,A5,A6,B4,B5,B6,C4,C5,C6],[A7,A8,A9,B7,B8,B9,C7,C8,C9],[D1,D2,D3,E1,E2,E3,F1,F2,F3],[D4,D5,D6,E4,E5,E6,F4,F5,F6],[D7,D8,D9,E7,E8,E9,F7,F8,F9],[G1,G2,G3,H1,H2,H3,I1,I2,I3],[G4,G5,G6,H4,H5,H6,I4,I5,I6],[G7,G8,G9,H7,H8,H9,I7,I8,I9]]) :-
    [A1,A2,A3,A4,A5,A6,A7,A8,A9] = A,
    [B1,B2,B3,B4,B5,B6,B7,B8,B9] = B,
    [C1,C2,C3,C4,C5,C6,C7,C8,C9] = C,
    [D1,D2,D3,D4,D5,D6,D7,D8,D9] = D,
    [E1,E2,E3,E4,E5,E6,E7,E8,E9] = E,
    [F1,F2,F3,F4,F5,F6,F7,F8,F9] = F,
    [G1,G2,G3,G4,G5,G6,G7,G8,G9] = G,
    [H1,H2,H3,H4,H5,H6,H7,H8,H9] = H,
    [I1,I2,I3,I4,I5,I6,I7,I8,I9] = I.


% Remplaza el primer cero por un numero del 1 al 9.
matrice_tanteo(Matrice, NMatrice) :-
    remplaza_el_primer_cero(Matrice, NMatrice, 1);
    remplaza_el_primer_cero(Matrice, NMatrice, 2);
    remplaza_el_primer_cero(Matrice, NMatrice, 3);
    remplaza_el_primer_cero(Matrice, NMatrice, 4);
    remplaza_el_primer_cero(Matrice, NMatrice, 5);
    remplaza_el_primer_cero(Matrice, NMatrice, 6);
    remplaza_el_primer_cero(Matrice, NMatrice, 7);
    remplaza_el_primer_cero(Matrice, NMatrice, 8);
    remplaza_el_primer_cero(Matrice, NMatrice, 9), !.


% Toma el primer cero y lo remplaza por un numero.
remplaza_el_primer_cero([Fila|Resto], [NFila|Resto], N) :-
    remplaza_el_primer_cero_en_fila(Fila, NFila, N), !.

remplaza_el_primer_cero([Fila|Resto], [Fila|NFilas], N) :-
    remplaza_el_primer_cero(Resto, NFilas, N), !.


% Auxilia la funcion para sustituir el primer cero de la fila
% actual y lo remplaza por un numero.
remplaza_el_primer_cero_en_fila([0|T], [N|T], N).

remplaza_el_primer_cero_en_fila([H|T], [H|NTail], N) :-
    remplaza_el_primer_cero_en_fila(T, NTail, N), !.


% Imprime la matrice, tomando cada lista, escribiendo cada
% elemento de esta uno a uno.
mostrar_sudoku([]).
mostrar_sudoku([H|T]) :-
    write(H),
    nl,
    mostrar_sudoku(T).


% Valida que la matrice este completa con numeros diferentes al 0,
% si esta condicion se cumple regresa: True, de lo contrario: False.
matrice_sin_ceros([]).
matrice_sin_ceros([H|T]) :-
    not(member(0, H)),
    matrice_sin_ceros(T), !.


