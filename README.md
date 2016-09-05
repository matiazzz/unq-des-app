# TP Desarrollo de aplicaciones

#### [unq-des-app](https://unq-des-app.herokuapp.com/)

[![Build Status](https://travis-ci.org/matiazzz/unq-des-app.svg?branch=master)](https://travis-ci.org/matiazzz/unq-des-app)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3ae0dc47d4f243fcaa3bd6559f746f6c)](https://www.codacy.com/app/mz-matiazzz/unq-des-app?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=matiazzz/unq-des-app&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://api.codacy.com/project/badge/Coverage/3ae0dc47d4f243fcaa3bd6559f746f6c)](https://www.codacy.com/app/matiazzz/unq-des-app?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=matiazzz/unq-des-app&amp;utm_campaign=Badge_Coverage)  

Grupo H: Matias Zacarias, Martin Ramos.

---

#### ¿A donde vamos?
Se busca la construcción de un sitio que permita la planificación de salidas a partir de
sugerencias basadas en el perfil de sus usuarios.

El sitio deberá contar con información de eventos culturales, bares, restaurantes y diferentes
lugares que puedan formar parte de una salida con amigos, en pareja o simplemente solos.

Si bien no existe una limitación en cuanto a las ciudades en las que la aplicación tendrá
cobertura, si se busca cubrir la Ciudad Autónoma de Buenos Aires, motivo por el cual se
requiere consumir información de por lo menos una de las bases expuestas en
[data.buenosaires.gob.ar](http://data.buenosaires.gob.ar/)

A partir de que un usuario se registre, podrá comenzar a definir su perfil. El perfil de usuario
contendrá sus preferencias en cuanto géneros musicales, géneros de películas, estilos de
comida, monto límite de dinero a gastar en una salida “gasolera” y medio de transporte con el
que suele salir. El usuario también podrá definir su círculo de amistades, linkeando como
amigos a otros usuarios del sitio.

En base a la información contenida en el sitio y el perfil, la aplicación podrá realizar diversas
propuestas de salidas ante la solicitud de un usuario.
* Salida gasolera: Prioriza salidas gratis y lugares economicos para comer, teniendo
como límite de gasto el monto ingresado por el usuario en su perfil.
* Salida con amigos: Busca encontrar opciones de salida que coincidan no solo con las
preferencias del usuario sino tambien con las de sus amigos en la aplicación.
* Saturday Night Fever: Busca combinar una sucesión de eventos que garanticen una
salida de sol a sol.
* Media Naranja: Prioriza opciones de salida para ir en pareja.
* Sorprendeme: Se sugieren eventos que no necesariamente coinciden con las
preferencias del perfil de usuario pero que se estima que pueden ser de su agrado.

Dependiendo de la salida a planificar, el usuario podrá indicar el día para que busca
sugerencias o cantidad de personas que lo acompañan.

Para cada evento o actividad sugerida, el usuario podrá acceder al detalle de la misma para
información como fecha, hora, dirección, costo (si lo tuviere) y sugerencias relacionadas
basadas en “quienes optaron por esta opción, también optaron por”.

Cuando el usuario se decide por alguna de las sugerencias presentas, les deberá dar “Asistiré”.
De esta manera, se ayuda a la aplicación a mejorar sugerencias futuras.

Con el fin de incrementar la experiencia de usuario, se requiere que se integre a la aplicación
con al menos una de las siguientes API.
* GoogleMaps: Mostrar la localización de los eventos
* Imbd: Proveer informacion de las películas sugeridas
* Servicio Meteorológico Nacional: Información meteorológica para priorizar opciones de
salida indoor sobre outdoor (lluvias o temperaturas extremas)
* API Pública: Incorporar una api pública que aporte valor al sitio
 
La aplicación deberá ser completamente responsive ya que si bien ahora no vamos a contar
con una aplicación mobile, será importante que pueda mostrarse correctamente en celulares y
tablets.

Es requisito indispensable proveer la capacidad de acceder a la aplicación utilizando una
cuenta existente en alguna de las herramientas o redes sociales más utilizadas (gmail,
facebook, twitter, etc).

Adicionalmente los usuarios podrán publicar sus propios eventos (recital de su banda, obra de
teatro, ofertas de su restaurant, etc) y a su vez la aplicación expondrá estos eventos a través
de un servicio para ser consumido por otros sitios a los que les intereses sumar dicha
información a su agenda.
