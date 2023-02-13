# GrupalPokemon

#Estructura de datos
Clase Pokemon con todos los datos de la base de datos.

#Estructura de código
Nuestra aplicación contará con un icono propio y nombre personalizado.
Tendremos cinco actividades
Una clase modelo
Una clase para poder heredar un menú ya que va a ser común en varias actividades
Una clase para trabajar con el Json
Dos clases para trabajar con la base de datos

#interfaz (Dany)

#vistas

Splash (Main Activity) (Dany):
Una pantalla principal con un estilo propio para esa actividad que usaremos como Splash con una duración de 2500ms.
Contiene una imagen del Titulo de nuestra Aplicación.
-Imagen / (ImageView)

Pantalla principal (Dany):
Una pantalla intermedia entre el Splash (presentación de la aplicación) y la aplicación en sí.
Contiene dos botones
-El primer botón te lleva al listado de los datos
-El segundo te lleva a la pantalla que te permite crearte tu propio equipo

Listado (Sergio):
Pantalla que mostrará un listado de registros, en ella podrás clickar para poder visualizar sus datos en la siguiente activity.
-Recycler
-Adapter(*1)

Creación/Edición de tu equipo pokemon(Guille):
Pantalla que muestra el equipo que se cree el usuario
-6 labels que contendrán el nombre de los pokemon que elija el usuario
-6 radio buttons para poder seleccionar un pokemon en cuestión
-1 botón que abre un alert dialog (*2)

Datos pokemon (Diego):
Una pantalla donde se visualizan todos los datos del pokemon seleccionado, permite desplazarse entre los distintos pokemon registrados.
-TextViews para mostrar los datos
-Botón con una imagen para desplazarse al registro siguiente
-Botón con una imagen para desplazarse al registro anterior

Editor de tu equipo(AlertDialog) (Josemi) (*2):
Dialogo que nos permite añadir o eliminar un pokemon a tu equipo
-EditText para introducir el nombre del pokemon

Menú de la aplicación (Josemi):
Contiene 3 botones habilitados durante toda la aplicación.
-Boton que permite acceder al listado de datos
-Boton que permite acceder a la edición de tu equipo pokemon
-Boton que permite volver a la pantalla principal

#modelo
Clase Pokemon (Sergio)
Contiene variables que se corresponden con los datos que tiene el Json y que después se relacionarán con los datos de la Base de Datos

#controladores

Controlador Equipo (Guille)
Contiene todos los métodos relacionados con la clase Equipo

Controlador Datos (Diego)
Contiene todos los metodos relacionados con la clase Datos

Adaptador Listado (Sergio)
(*1) Creación de la clase adapter para poder mostrar los datos en el recycler y que al clickar en el registro
se puedan ver todos sus datos

#BBDD (Diego)
Contiene todos los métodos necesarios para crear la base de datos y luego trabajar con ella

#JSON (Sergio)
Todos los metodos necesarios para descargar el Json, guardarlo y trabajar con él

#Menú (Josemi)
Clase con los métodos necesarios del menú para poder heredarla ya que toda la aplicación comparte el mismo menú

# lógica de negocio
Toda la programación que organiza el funcionamiento de la aplicación (interface)

# Descripción del proyecto (que efecto va a tener cada error o cada acierto dentro de la aplicacion)
La aplicación comienza con una ventana a pantalla completa que contiene el nombre de nuestra aplicación,
después de esperar 2500ms pasará automáticamente a la siguiente ventana, la cual es una pantalla de inicio,
contiene dos botones para que puedas elegir si quieres ver el listado de todos los pokemons disponibles o
directamente entrar a crear o editar tu equipo pokemon.
Si eliges ver el listado de los pokemon se abrirá una ventana en la que se mostrará el nombre de los pokemon
y su tipo. Al clickar en un pokemon se abrirá la siguiente ventana, la cual permite visualizar los datos del pokemon clickado.
Si eliges ver tu equipo pokemon podrás tanto añadir pokemon a él como eliminarlos, si clickas en uno de tus pokemon
podrás ver sus estadísticas.
La aplicación contiene un menú con un botón para acceder al listado de los datos,
otro botón para acceder a tu equipo pokemon, y otro para volver a la pantalla de inicio.