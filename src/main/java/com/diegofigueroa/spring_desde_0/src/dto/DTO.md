# Que es un DTO? 

**DATA TRANSFER OBJECT**

Diferente a DAO -> **DATA ACCESS OBJECT**

Es una caja de datos para enviar o recibir informacion entre distintas partes de nuestra aplicacion

Porque usamos DTO? 

Es no exponer directamente las entidades del dominio o base de datos

Con los DTO solo expondremos lo que queramos q el usuario final veea 

# OJO!!! 

Nuesta entidad/modelo TIENE LA RESPONSABILIDAD DE REPRESENTAR LA TABAL DE NUESTRA BASE DE DATOS! 

DTO es el contrato de la API tiene la responsabilidad de decir que datos se transfiere

**CUANDO USAMOS DTO, LAS VALIDACION SE REALIZAN EN EL PUNTO DE ENTRADA DE LA APLICACION, EN EL CONTROLADOR**
