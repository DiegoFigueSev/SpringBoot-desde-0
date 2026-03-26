# Que es un @Component? 

Es la pieza y fundamental de SpringBoot 

Todo en spring es un Componente 

@Service -> Componente

@RestController -> Componente

@Repository -> Componente

Son componentes, pero componentes especializados

Con componente le decimos a spring ESTO ES UNA INSTANCIA Y
NECESITO GUARDARLA EN ALGUN LUGAR

Le cedemos al framework la creacion de objetos 

# Que es un @Bean? 
Es un objeto que Spring crea, guarda y gestiona por nosotros 

# Que es @Configuration?
Es uan clase donde nosotros le decimos a spring que tendremos objetos que los tiene q crear el

# DIFERENCIA ENTRE @Bean Y @Component
Component:
* Spring crea el objeto automaticamente
* Se usa en clases
* Scaneo automatico

Bean:
* Nosotros definimos como se crea
* Se usa en metodos
* Configuracion manual 

# NOTA:
* Ver q es lazzy  
* Ver que es cacheable
