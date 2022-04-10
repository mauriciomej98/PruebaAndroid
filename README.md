# PruebaAndroid
prueba realizada para puesto de desarrollador android

1-El requisito de visualización de videos no estaba del todo claro y verifique si podia tomar los trailers mediante la llamada a la api TMDB
pero muchas de esas peliculas no contienen video trailer por lo que opte por poner un video descargado capas de tambien reproducirse online.

2-no hice la funcionalidad offline pero a continuacion explicare como lo realizaria.

la funcionalidad offline se puede hacer tomando el JSON que recibe la aplicacion y almacenarla en una base de datos utilizando las librerias de Room que 
nos van a permitir poder almacenar el JSON y una vez almacenado este se podra consultar y asi poder volver a leer los datos del JSON sin necesidad de que 
la aplicacion tenga acceso a internet asi mostrar las peliculas.

para que todo eso tenga sentido se tiene que realizar un limpiado de la base de datos que nos proporciona Room cada que la aplicacion reciba datos de los 
servidores de TMBD.
