**PROGRAMA CONVERTIDOR DE DIVISAS (MONEDAS)**
# INTRODUCCCION
El programa "convertidorMonedas" es el resultado del estudio  de la primera etapa del  programa de Especialización en Back-End, donde Alura-Latam y OracleOne presentaron las bases de Java y de Programación Orientada a Objetos (OOP). 
Para los que por muchos años hemos venido trabajando con el modelo de Programación Estructurada (PE),  ha sido bastante complicado hacer el cambio de paradigma porque  OOP hace cambiar cómo se piensan  los conceptos de arquitectura, diseño y generacion de los sistemas de información. Es un cambio mental bien importante.
En nuestro caso, creemos que hemos aprendido algunas bases de OOP y que el resultado obvio es este programa, programa que creamos  de manera similar a como el doctor Frankenstein creó su famoso monstruo. El de nosotros es un programa creado con retazos de OOP y PE, que de alguna manera logramos que funcionara y cumpliera los objetivos propuestos. Nos gustaría saber qué anotaría uno de los gurús de Java.
![image](https://github.com/user-attachments/assets/7e3d6486-a8e1-40c6-9202-59d6e83eb457)

# FUNCIONAMIENTO DEL PROGRAMA (EJECUCION DEL PROGRAMA POR EL USUARIO)

El objetivo del programa es que, dado el código de la divisa y el valor a convertir, el sistema genere la conversión a la moneda escogida por el usuario, con base al dolar. Puede convertir del dolar a la moneda y viceversa. Como resultado, el programa guarda las diferentes conversaciones que ha tenido con el sistema, en el archivo TrazaMonedas.json, para su posterior uso en analítica de datos y trazabilidad.

Los siguientes son los pasos a seguir por el usuario.
1.  La siguiente tabla presenta las divisas del mundo,de acuerdo a cada pais. De aqui, el usuario puede tomar los códigos de moneda que el programa le pedirá a continuación:

![image](https://github.com/rumanag/convertidorMonedas/blob/main/tools/codigosDivisas.png)

2. El programa pide el código de la moneda del país:
![image](https://github.com/rumanag/convertidorMonedas/blob/main/tools/1%20definirMoneda.png?raw=true)

3. Con base en el código de la moneda, el programa devuelve la tasa de cambio con relacón al dolar.
![image](https://github.com/user-attachments/assets/842c8f31-334a-4528-9c46-d6a5a3d4a73c)

4. El programa solicita el tipo de conversión ( 1 si es de dolar a moneda o 2  V.V.) y el valor a convertir
![image](https://github.com/user-attachments/assets/42b4e51a-03d7-4fe1-964b-95a30df68ece)

5. El programa entrega el resultado de la conversión  y solicita otra moneda o "salir"
![image](https://github.com/user-attachments/assets/3bb068c6-f683-4d6e-92d1-380c9baaf2e7)

6. Cuando se sale, el programa genera el archivo trazaMonedas.json, el cual tiene la siguiente estructura:
![image](https://github.com/user-attachments/assets/8953d61c-6136-437c-96f3-2cf8413aa981)

# FUNCIONAMIENTO GENERAL DEL PROGRAMA:

1. CLASES:
   - JsonFile:
     * Contiene la estructura y los métodos que va a tomar el archivo trazaMonedas.json.
     *  Los getters no se usaron pero se dejaron a propósito para, en una versión posterior, adicionar las funcionalidades de trazabilidad y analítica de datos.

    - Principal:
     * Como columna vertebral, contiene la parte estructural del programa, de acuerdo con el siguiente esquema:
![image](https://github.com/user-attachments/assets/56bf3e62-3c7f-4d94-be3b-e7e86d666b08)


2. ESTRUCTURA DEL PROYECTO:

   En la siguiente imagen se presenta la estructura del proyecto en Intelllij IDEA.
  ![image](https://github.com/user-attachments/assets/d2f14c34-26e0-407c-9fd1-43204cfb97cd)


                                                                                                                                                 ver 1. 14/10/2024
