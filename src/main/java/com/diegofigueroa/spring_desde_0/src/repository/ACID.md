# QUE ES ACID?
Son reglas para garantizar que las trasacciones en base de datos 
sean seguras y confiables.
* Atomicity: Si una transaccion falla se deshace todo (transacciones)
* Consistency: La base de datos siempre queda en un estado valido
* Isolation: Las transacciones durante operaciones concurrenets no se interfieren entre si
* Durability: Una vez confirmado el commit el dato no se pierde

| Letra | Significado | Idea             |
| ----- | ----------- | ---------------- |
| A     | Atomicity   | Todo o nada      |
| C     | Consistency | Datos válidos    |
| I     | Isolation   | No interferencia |
| D     | Durability  | Persistencia     |


# QUE SON LAS TRANSACCIONES? 
Son un conjunto de operacioens de base de datos que se ejecutan como una unidad.

Si alguna falla la transaccion se revierte y se hace un rollback y los cambios se revierten.

Si todo sale bien finaliza y hacer un commit.

