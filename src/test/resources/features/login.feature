#language: es

Característica: Login
dado estoy en la página de la tienda
y me logueo con mi usuario "XXX" y clave "YYY"
y agrego 2 unidades del primer producto al carrito
entonces valido en el popup la confirmación del producto agregado
y valido en el popup que el monto total sea calculado correctamente
cuando finalizo la compra
entonces valido el titulo de la pagina del carrito
y vuelvo a validar el calculo de precios en el carrito

  @test
  Escenario: Iniciando sesion en la pagina
    Dado que me encuentro en la página de login de MyStore
    Cuando inicio sesión con las credenciales usuario: "garcia.14.265@gmail.com" y contraseña: "G!anm4rco10."
    Entonces regresar al menú principal si falla el inicio de sesión
    Cuando navego a la categoría "Clothes" y subcategoría "Men"
    Y agrego 2 unidades del primer producto al carrito
    Entonces debería ver el producto en el carrito