# Para que nos ayudan las pruebas 

Nos ayudan a detectar errores de forma temprana
antes de q lleguen a produccion.

Pero sobretodo para la refactorizacion SEGURA 
cuando hagamos cambios en nuestro codigo 
podemos ejecutar las pruebas para validar que nuestra 
refactorizacion salio bien 

## Tipos de pruebas 

### Pruebas unitarias 
* Definicion: Prueban la unidad mas pequena del codigo (clase o metodo) de manera aislada
* Alvance: Muy especifico (No interactua con DB ni con servicios externos)
* Velocidad: Rapida 
* **Proposito:** validas la logica individual de un componente

#### Ventajas:
* Confianza en la logica del negocio
* Segurdad sobre metodos y clases

### Pruebas de integracion
* Definicion: evaluan como interactuan los componentes entre si 
* Alcance: Mas amplio 
* Velocidad: Mas lento
* Proposito: Garantizar que las comunicaciones y configuraciones son correctas

#### Ventajas: 
* Confianza en el flujo al validar la interaccion entre componentes
* Detectan errores de configuracion

## Ventajas Generales 

**CAMBIAR CODIGO SIN ROMPER OTRAS PARTES**