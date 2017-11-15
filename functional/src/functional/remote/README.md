Il codice nel package `functional` prende il command pattern dell'esercitazione 3 o lo riscrive in un'ottica funzionale.

Come esercizio, provate ad implementare seguendo queste specifiche:

 * il comando ha N file di 3 pulsanti ciascuna: ON, OFF e UNDO;
 * ogni fila di pulsanti corrisponde logicamente ad un oggetto della casa;
 * ogni fila può essere riconfigurata per controllare un oggetto diverso.

Vi consiglio di fornire un'implementazione standard e, successivamente, in stile funzionale.

Si noti che, nella soluzione, le classi che rappresentano gli oggetti della casa (Light e GarageDoor) non devono
essere modificate.

Una possibile soluzione è contenuta nel package `proposed_exercise`.
