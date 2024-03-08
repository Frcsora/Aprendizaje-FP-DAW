Un conocido equipo de basket a nivel europeo ha decidido automatizar el proceso de
preparación y envío de los artículos comprados de la tienda online. Actualmente tienen
enormes problemas de gestión de los pedidos y errores en el stock de sus productos, causando
muchas pérdidas económicas al club.

Este equipo de basket ha dado acceso tanto al modelo como a la base de datos y solicita las
siguientes automatizaciones:

1- Al crear un Order deben copiarse los campos de la dirección de envío (Calle, Ciudad y
País) de Client a Order.

2- Cuando se inserta un OrderLineItems o se elimina un OrderLineItems, es necesario
calcular el importe total de su Order.

3- Cuando se inserta un OrderLineItem o se modifica el producto de un
OrderLineItems es necesario poner el precio del producto en el campo “Unit Price”.

4- Creación de WorkOrder cada vez que un pedido pasa a estado “Accepted”. La
información de WorkOrder hay que recuperarla del pedido. Es necesario crear tantas
WorkOrderItems como OrderLineItems tenga el pedido y deben rellenarse con la información
que haya en cada OrderLineItems.

5- Creación de Shipment cada vez que una WorkOrder pase a estado “Completed”. La
información de Shipment debe recuperarse del Order y del WorkOrder. Al igual que en el
punto anterior es necesario crear tantas ShipmentItems como WorkOrderItems y deben
rellenarse con la información de cada WorkOrderItems.

6- Cuando se crea un registro Shipment es necesario actualizar el estado del pedido
asociado a “Sent”.

7- Cuando un registro Shipment tiene el estado “Delivered” es necesario actualizar el
estado del Order a “Completed” siempre y cuando todos sus Shipment estén en “Delivered”.

8- Al modificarse un precio de un producto se deben actualizar los OrderLineItems que
tengan ese producto, siempre y cuando el Order esté en estado “Draft”.

Puntos que solicita el club y que deben tenerse en cuenta en las automatizaciones.

1- Los estados de un pedido son: “Draft”, “Created”, “Accepted”, “Sent”, “Completed”.

2- Los estados de un pedido son secuenciales, por ejemplo, no es posible mover un
estado “Created” a un estado “Sent” sin antes haber pasado por “Accepted”.

3- Los estados de un WorkOrder son: “New” y “Completed”.

4- Los estados de un Shipment son:”New”, “Sent” y “Delivered”.

5- No es posible que un pedido sin líneas de pedido actualice su estado a “Created” ni
posteriores.

6- No es posible volver atrás en los estados de ninguna tabla. Por ejemplo, no es posible
volver a poner un estado “Created” o “Accepted” a un Order cuyo estado es “Sent”.

7- No es posible insertar nuevos Products en Orders con estado diferente a “Draft”