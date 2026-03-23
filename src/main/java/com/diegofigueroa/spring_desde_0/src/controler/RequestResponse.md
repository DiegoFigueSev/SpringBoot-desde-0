# HTTP 
HTTP - HYPERTEXT TRANSFER PROTOCOL
## QUE ES?
Es el protocolo que utilizan los navegadores y servidores web para comunicarse entre si.

Es un dialogo entre dos partes, cliente - servidor.

Tenemos:
* request: Solicitud de info/files
* response: Respuesta del servidor

## ESTRUCTURA DEL HTTP
Funciona como un sistema de peticiones y respuestas.

request y response 

## Que es una request? 
Es una solicitud que un cliente envia a un servidor

NO ES UNA RUTA.

El request es un SOBRE con la CARTA pidiendo lo que queremos

* Obtener datos
* Enviar/Crear datos 
* Modificar datos
* Eliminar datos 

### Estrustura de una peticion HTTP
#### METODO 
Es la accion que deseamos realizar:
* GET = Obtener datos 
* POST = Enviamos datos y creamos un recurso
* PUT = Editar un dato COMPLETAMENTE
* PATCH = Editar un dato parcialmente
* DELETE = Eliminar un dato 
#### URL 
Es la direccion del recurso al que se accede
#### HEADERS
Metadatos sobre la peticion 
#### BODY 
Contenido JSON que se envia al servidor

### Status Code
* 200 : Ok -> Todo salio bien
* 201 : Created -> Recurso creado
* 204 : No content -> Sin contenido
* 400 : Bad request -> Error del cliente
* 401 : Unauthorized -> No autorizado
* 404 : Not found -> Recurso no encontrado
* 500 : Internal server error -> Error del servidor