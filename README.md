# GrupalPokemon

#Estructura de datos
Clase Pokemon con todos los datos de la base de datos.
Clase Usuario con su usuario, su contraseña, y su faccion.
Clase Equipo con todos los datos relacionados con el equipo pokemon.
Clase Ataques con su nombre y su tipo.
Clase Habilidades con el nombre de la habilidad.

#Estructura de código
Nuestra aplicación contará con un icono propio y nombre personalizado.
Tendremos ocho actividades
Cinco clases modelo
Una clase para poder heredar un menú ya que va a ser común en varias actividades
Tres clase para trabajar con tres Jsons
Cuatro clases para trabajar con la base de datos:
    - Un DBHelper para la creacion de las tablas
    - Tres clases para hacer consultas de las tablas y trabajar con ellas

#interfaz (Dany)

#vistas

Splash (Main Activity) (Dany):
Una pantalla principal con un estilo propio para esa actividad que usaremos como Splash con una duración de 2500ms.
Contiene una imagen del Titulo de nuestra Aplicación.
-Imagen / (ImageView)

Login (Sergio)
Pantalla que permite registrar un usuario nuevo o iniciar sesión si ya te has registrado previamente.

Pantalla principal (Dany):
Contiene cuatro botones
-Un botón que te lleva al listado de pokemon
-Un botón que te lleva a la pantalla que te permite crearte tu propio equipo
-Un botón que te permite ver los créditos de la aplicación
-Un botón que te permite ver los equipos registrados de los demás usuarios

Listado (Sergio):
Pantalla que mostrará un listado de pokemon, en ella podrás clickar para poder visualizar sus datos 
en la siguiente activity.
-Recycler
-Adapter(*1)

Creación/Edición de tu equipo pokemon(Guille):
Pantalla que muestra el equipo que se cree el usuario
-6 labels que contendrán el nombre de los pokemon que elija el usuario
-6 radio buttons para poder seleccionar el pokemon en cuestión
-12 imagenes:
    - 6 imagenes de los 6 pokemon seleccionados
    - 6 imagenes que muestran si los datos del pokemon están completos
-4 botones:
    -Un botón que abre un alert dialog (*2)
    -Un botón que te permite elegir los movimientos de tus pokemon
    -Un botón que te permite hacer random el pokemon seleccionado
    -Un botón que te permite guardar tu equipo pokemon en la base de datos

Datos pokemon (Diego):
Una pantalla donde se visualizan todos los datos del pokemon seleccionado, permite desplazarse entre 
los distintos pokemon registrados.
-ImageView para mostrar al pokemon seleccionado
-TextViews para mostrar los datos
-Botón para indicar si quieres al pokemon original o su versión shiny
-Botón que abre en una pestaña del navegador los datos de la pokedex del pokemon
-Botón con una imagen para desplazarse al registro siguiente
-Botón con una imagen para desplazarse al registro anterior

Listado_Equipos (Guille)
Pantalla que mostrará el listado de los equipos de todos los usuarios, al clickar en un equipo se
abrirá un AlertDialog en el que aparecerán los nombres de los pokemon
-Recycler
-Adapter(*3)

Creditos (Guille)
Una pantalla que te introduce un poco a la aplicación y te dice quienes la han desarrollado
-ImageView
-TextView

Editor de tu equipo(AlertDialog) (Josemi) (*2):
Dialogo que nos permite añadir o editar un pokemon a tu equipo
-EditText para introducir el nombre del pokemon 
-2 Spinners:
    -Uno para seleccionar la habilidad del pokemon
    -Uno para seleccionar la naturaleza del pokemon
-Positive Button para guardar los cambios
-Negative Button para cancelar

Menú de la aplicación (Josemi):
Contiene 2 botones habilitados durante toda la aplicación.
-Botón que te lleva a la pantalla principal
-Botón que te permite filtrar tanto por nombre de pokemon como por tipo, o los dos a la vez

#modelo
Clase Pokemon (Sergio)
Contiene variables que se corresponden con los datos que tiene el Json y que después se relacionarán
con la tabla Pokemon de la base de datos

Clase Usuario (Sergio)
Contiene variables que se relacionan con la tabla Usuarios de la base de datos

Clase Equipo (Sergio)
Contien variables que se relacionan con la tabla Equipos de la base de datos

Clase Habilidades (Sergio)
Contiene las variables necesarias para implementar las habilidades a los pokemon

Clase Ataques (Sergio)
Contiene las variables necesarias para implementar los ataques a los pokemon

#controladores

Controlador Equipo (Guille)
Contiene todos los métodos relacionados con la clase Equipo

Controlador Datos (Diego)
Contiene todos los metodos relacionados con la clase Datos

Adaptador Listado (Sergio)
(*1) Creación de la clase adapter para poder mostrar los datos en el recycler y que al clickar en el registro
se puedan ver todos sus datos

Adaptador Lista_Equipos (Sergio)
(*3) Creación de la clase adaptar para poder mostrar los datos en el recycler

Comunes (Guille)
Métodos que se utilizan en más de una actividad

#BBDD (Diego)
Contiene todos los métodos necesarios para crear la base de datos y luego trabajar con ella

#JSON Pokemon (Sergio) (Editado a mano por Sergio, Diego y Guille)
Todos los metodos necesarios para descargar el Json, guardarlo y trabajar con él

#JSON ataques (Sergio)
Todos los metodos necesarios para descargar el Json, guardarlo y trabajar con él

#JSON Habilidades (Sergio) (Creado/Editado por Sergio)
Todos los metodos necesarios para descargar el Json, guardarlo y trabajar con él

#Menú (Josemi)
Clase con los métodos necesarios del menú para poder heredarla ya que toda la aplicación comparte el mismo menú

#Imágenes (Sergio)
Clase con los métodos necesarios para poder acceder a la imagen de internet del Json y utilizarla

#Sonidos (Guille)
Clase con los métodos necesarios para la implementación de sonidos a lo largo de la aplicación

# lógica de negocio
Toda la programación que organiza el funcionamiento de la aplicación (interface)

# Descripción del proyecto (que efecto va a tener cada error o cada acierto dentro de la aplicacion)
La aplicación comienza con una ventana a pantalla completa que contiene el nombre de nuestra aplicación,
después de esperar 2500ms pasará automáticamente a la siguiente ventana, la cual es un login, ésta permite
al usuario registrarse si es la primera vez que accede a la aplicación, o iniciar sesión con su usuario.
Una vez verificado el login pasará a la pantalla principal de la aplicación, consta de cuatro botones,
los cuales te dan a elegir entre ver todo el listado de los pokemon disponibles, empezar a crearte/editar
tu equipo pokemon, ver los equipos de los demás usuarios registrados, o ver los créditos de la aplicación.
Si eliges ver el listado de pokemon se abrirá una ventana en la que se mostrará el nombre del pokemon y
su tipo. Al clickar en un pokemon se abrirá una ventana en la que podrás ver los datos del pokemon
seleccionado. Si eliges ver tu equipo podrás tanto añadir pokemon como editar los que ya hayas añadido
previamente, y clickando en uno de ellos podrás ver sus datos.
La aplicación contiene un menú habilitado en todo momento con un botón que te permite acceder a la
pantalla principal y otro para filtrar por nombre o tipo entre todos los pokemon.