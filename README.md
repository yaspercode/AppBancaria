# AppBancaria

Este proyecto en java es una implementación simplificada de un sistema de transferencias bancarias entre cuentas y no representa un sistema de banco real. Permite realizar transferencias entre diferentes cuentas, teniendo en cuenta la tasa de cambio.

## Funcionalidades

- Iniciar sesión: Los usuarios pueden ingresar a la aplicación ingresando su número de cuenta y su clave.
- Consultar saldo: Los usuarios pueden verificar su saldo disponible.
- Realizar transferencias: Las cuentas bancarias pueden realizar transferencias de fondos a otras cuentas del mismo banco. Se tiene en cuenta la tasa de cambio si las monedas de las cuentas son diferentes.
- Historial de transacciones: Permite al usuario realizar un seguimiento de todas las transacciones y actividades realizadas en la cuenta.

## Tecnologías utilizadas

- Java
- MySQL

## Créditos

Este proyecto fue creado por Miguel Mallqui Diaz como un proyecto de programación orientada a objetos, y se inspiró en el funcionamiento del banco BCP.

## Capturas de pantallas

A continuación, se muestran las interfaces que ilustran las funcionalidades de la aplicación.
### Base de datos de Cuentas y cliente
Listado de clientes y sus cuentas.
![Imagen de tabla cliente](https://i.imgur.com/0thbZ3W.png)
![Imagen de tabla cuenta](https://i.imgur.com/3W0N5KC.png)

### Login
Se ingresa el número de cuenta y su clave.
![Imagen de Login](https://i.imgur.com/AFweTWy.png)

### Menú
Se visualizan todas las cuentas. Para ver movimientos, se debe seleccionar en la tabla la fila donde deseas visualizar  
![Imagen de Menu](https://i.imgur.com/Fqv06FK.png)

### Movimientos
Se visualizan todas las transacciones realizadas.
![Imagen de Movimientos](https://i.imgur.com/QyQUaYe.png)

### Menú Transferencia
Cuenta con 2 opciones: una para transferencias entre sus propias cuentas de usuario y otra para transferir a terceras cuentas del mismo banco.
![Imagen de Transferencia](https://i.imgur.com/7tD7eeT.png)

### Transferencias entre tus cuentas
Puedes seleccionar una cuenta de origen y en el combobox de cuenta de destino se muestran todas las cuentas disponibles excepto la cuenta que has seleccionado como origen. Luego, puedes ingresar el monto a transferir.
![Imagen de Transferencias entre cuenta](https://i.imgur.com/jVDevcg.png)

### Constancia
Se muestra el pago realizado y se aplicará una tasa de cambio si las cuentas involucradas tienen diferentes monedas. En caso de que las cuentas tengan la misma moneda, no se aplicará ninguna tasa de cambio.
![Imagen de Contancia](https://i.imgur.com/w0qmzYF.png)

### Transferencias a terceros
Puedes seleccionar una cuenta de origen, ingresar la cuenta de destino, una descripción y el monto a transferir.
![Imagen de Transferencias a terceros](https://i.imgur.com/txYN4rr.png)

### Constancia
Se muestra el pago realizado y se aplicará una tasa de cambio si las cuentas involucradas tienen diferentes monedas. En caso de que las cuentas tengan la misma moneda, no se aplicará ninguna tasa de cambio.
![Imagen de Constancia](https://i.imgur.com/Qi84EAb.png)


