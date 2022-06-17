<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@page import="java.util.*"%>
<%@page import="Chef.*"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>OnlyChefs</title>
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="//cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />
    <!-- Google Fonts -->
    <link rel="preconnect" href="//fonts.gstatic.com" />
    <link
      href="//fonts.googleapis.com/css2?family=Montserrat:wght@100;400;700;900&display=swap"
      rel="stylesheet"
    />
    <link
      href="//fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;700&display=swap"
      rel="stylesheet"
    />
    <!-- CSS Files -->
    <link rel="stylesheet" href="resources/css/styleHome.css" type="text/css"/>
    
  </head>

  <body>
    <section class="colored-section" id="title">
      <div class="container-fluid">
        <!-- Nav Bar -->

        <nav class="navbar navbar-expand-lg navbar-dark">
          <a class="navbar-brand" href="">OnlyChefs</a>
        </nav>

        <!-- Title -->

        <div class="row">
          <div class="col-lg-6">
            <h1 class="big-heading">Descubre nuevos sabores y a sus creadores</h1>
            <button type="button" onclick="window.location.href='opcionesChef.jsp'" class="btn btn-dark btn-lg download-button">
              Entrar como chef
            </button>            
            <button
                
              type="button"
              class="btn btn-outline-light btn-lg download-button"

              onclick="window.location.href='perfilchef.jsp'"
              >
              Ver perfil de chef
            </button>
          </div>
          <div class="col-lg-6">
            <img
              class="title-image"
              src="resources/images/chef.png"
              alt="iphone-mockup"
            />
          </div>
        </div>
      </div>
    </section>
            
    <!-- Features -->

    <section class="white-section" id="features">
      <div class="container-fluid">
        <div class="row">
          <div class="feature-box col-lg-4">
            <h3 class="feature-title">Descubre</h3>
            <p>Contamos con variedad de chefs que complacen paladares alrededor del mundo</p>
          </div>
          <div class="feature-box col-lg-4">
            <img src="">
            <h3 class="feature-title">Saborea</h3>
            <p>Contempla los platos estrella de cada representante culinario</p>
          </div>
          <div class="feature-box col-lg-4">
            <img src="" alt="">
            <h3 class="feature-title">Suscríbete</h3>
            <p>Recibe actualizaciones con las últimas y más populares recetas de nuestros chefs</p>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
