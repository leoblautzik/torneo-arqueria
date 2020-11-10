# torneo-arqueria
POO-repaso-full
Torneodearquería.Como todos sabemos, en los torneos de arquería se disparan flechas hacia un blanco queconsiste en varios círculos concéntricos y 
cada disparo es puntuado de acuerdo a sudistancia al centro. 

Se sabe que todos los blancos utilizados en la competencia tienen 1metro de diámetro. 

Se considera que el centro tiene coordenadas (0,0).

Se dispone de un archivo “tiros.csv” donde fueron registrados los tiros de todos losarqueros.

El archivo contiene por cada línea y separados por coma “,” :

N° de participante: entero de 3 dígitos no correlativo.
coordenada x del disparo: número real
coordenada y del disparo: número real.

Para que un disparo se considere válido, debe haber sido registrado a menor distancia delcentro que el radio del blanco.
+ Los disparos que se encuentren a menos de 10 cm del centro valen 1000 puntos.
+ Los disparos que se encuentren entre los 10 cm y los 20 cm del centro valen 500 puntos.
+ Los disparos que se encuentren entre los 20 cm y los 30 cm del centro valen 200 puntos.
+ Los disparos que se encuentren entre los 30 cm y los 40 cm del centro valen 100 puntos.
+ Los disparos que se encuentren entre los 40 cm y los 50 cm del centro valen 50 puntos.
+ Más de 50 cm del centro es tiro inválido y no obtiene puntaje.

De todos los disparos registrados por participante, se deben considerar los 5 mejores.
Si algún participante no alcanza los 5 tiros válidos, es descalificado.
El archivo se encuentra desordenado y no se conoce tampoco cuántos disparos seregistraron para cada participante, ni la cantidad de participantes.
Se te pide que ayudes a los organizadores para clasificar a los participantes e informes en un archivo “podio.out”
+ 1° puesto: nroParticipante puntajeObtenido
+ 2° puesto: nroParticipante puntajeObtenido
+ 3° puesto: nroParticipante puntajeObtenido
