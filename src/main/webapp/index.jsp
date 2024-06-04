<%-- 
    Document   : index
    Created on : 3 nov. 2023, 20:28:28
    Author     : deyvi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
          <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Principal</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Dosis:400,500|Poppins:400,700&display=swap" rel="stylesheet" />
  <link href="css/font-awesome.min.css" rel="stylesheet">
  <link href="css/prettyPhoto.css" rel="stylesheet">
  <link href="css/price-range.css" rel="stylesheet">
  <link href="css/animate.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
  <link href="css/responsive.css" rel="stylesheet" type="text/css"/>
  <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
<div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container">
          <a class="navbar-brand" href="index.html">
            <!--img src="images/home/logo.png" alt=""/><span> AQUI VA LA IMAGEN LOGO DEL HOME-->
              <span>Boutique Store
            </span>
          </a>

          <div class="navbar-collapse" id="">
            <div class="container">
              <div class=" mr-auto flex-column flex-lg-row align-items-center">
                <ul class="navbar-nav justify-content-between ">
                  <div class="d-none d-lg-flex">
                  </div>
                  <div class=" d-none d-lg-flex">
                    <!--li class="nav-item">
                      <a class="nav-link" href="contact.jsp">
                        <h3> Demo@gmail.com</h3>
                      </a>
                    </li-->
                    <form class="form-inline my-2 ml-5 mb-3 mb-lg-0">
                      <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
                    </form>
                  </div>
                </ul>
              </div>
            </div>

            <div class="custom_menu-btn">
                <button onclick="openNav()"><span><h1 style="color: white">☰</h1></span></button>
            </div>
            <div id="myNav" class="overlay">
              <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
              <div class="overlay-content">
                <a href="shop.jsp">HOME-Tienda</a>
                <a href="administracion.jsp">REGISTRO DE PRODUCTOS(en desarrollo)</a>
              </div>
            </div>
          </div>
        </nav>
      </div>
    </header>
    <!-- end header section -->
    <!-- slider section -->
    <section class=" slider_section position-relative">
      <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="slider_item-box">
              <div class="slider_item-container">
                <div class="container-fluid">
                  <div class="row">
                    <div class="offset-md-2 col-md-4">
                      <div class="slider_item-detail">
                        <div>
                          <h2 class="slider_heading">
                            50% Descuento en tu primera compra!
                          </h2><br>
                          <h4>
                              ¡Descubre tu estilo único en BoutiqueStore! Explora nuestras colecciones de moda cuidadosamente seleccionadas y viste con elegancia y distinción. Encuentra la combinación perfecta para cada ocasión y déjanos ser tu destino favorito para el mejor estilo en línea. ¡Haz una declaración de moda con BoutiqueStore, donde tu estilo cobra vida!
                          </h4><br><br>
                          <div class="d-flex">
                              <a href="shop.jsp" class="slider_btn" style="font-size: 15px">
                              Explorar productos
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="hero_img-box">
                        <img src="images/home/hero.png" alt="" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="slider_item-box">
              <div class="slider_item-container">
                <div class="container-fluid">
                  <div class="row">
                    <div class="offset-md-2 col-md-4">
                      <div class="slider_item-detail">
                        <div>
                          <h2 class="slider_heading">
                            50% OFF <br />
                            First order
                          </h2>
                          <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing
                            elit, sed do eiusmod tempor incididunt ut labore
                            et dolore magna aliqua. Ut enim ad minim veniam,
                            quis nostrud exercitation ullamco laboris nis
                          </p>
                          <div class="d-flex">
                            <a href="shop.jsp" class="slider_btn">
                              Explorar productos
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="hero_img-box">
                        <img src="images/home/hero.png" alt="" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="slider_item-box">
              <div class="slider_item-container">
                <div class="container-fluid">
                  <div class="row">
                    <div class="offset-md-2 col-md-4">
                      <div class="slider_item-detail">
                        <div>
                          <h2 class="slider_heading">
                            50% OFF <br />
                            First order
                          </h2>
                          <p>
                            Lorem ipsum dolor sit amet, consectetur adipiscing
                            elit, sed do eiusmod tempor incididunt ut labore
                            et dolore magna aliqua. Ut enim ad minim veniam,
                            quis nostrud exercitation ullamco laboris nis
                          </p>
                          <div class="d-flex">
                            <a href="shop.jsp" class="slider_btn">
                              Explorar productos
                            </a>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="hero_img-box">
                        <img src="images/home/hero.png" alt="" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
          <span class="sr-only">Next</span>
        </a-->
      </div>
    </section>
    <!-- end slider section -->
  </div>

  <section class="info_section layout_padding">
    <div class="container links_container">
      <div class="row ">
        <div class="col-md-3">
          <h3>
            SERVICIO AL CLIENTE
          </h3>
          <ul>
            <li>
              <a href="">
                International Help
              </a>
            </li>
            <li>
              <a href="">
                Contact Customer Care
              </a>
            </li>
            <li>
              <a href="">
                Return Policy
              </a>
            </li>
            <li>
              <a href="">
                Privacy Policy
              </a>
            </li>
            <li>
              <a href="">
                Shipping Information
              </a>
            </li>
            <li>
              <a href="">
                Promotion Terms
              </a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>
            DEJANOS AYUDARTE
          </h3>
          <ul>
            <li>
              <a href="">
                Your Account
              </a>
            </li>
            <li>
              <a href="">
                Your Orders
              </a>
            </li>
            <li>
              <a href="">
                Shipping Rates & Policies
              </a>
            </li>
            <li>
              <a href="">
                Amazon Prime
              </a>
            </li>
            <li>
              <a href="">
                Returns & Replacements
              </a>
            </li>
            <li>
              <a href="">
                Help
              </a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>
            INFORMACION
          </h3>
          <ul>
            <li>
              <a href="">
                About Us
              </a>
            </li>
            <li>
              <a href="">
                Careers
              </a>
            </li>
            <li>
              <a href="">
                Sell on shop
              </a>
            </li>
            <li>
              <a href="">
                Press & News
              </a>
            </li>
            <li>
              <a href="">
                Competitions
              </a>
            </li>
            <li>
              <a href="">
                Terms & Conditions
              </a>
            </li>
          </ul>
        </div>
        <div class="col-md-3">
          <h3>
            NUESTRA TIENDA
          </h3>
          <ul>
            <li>
              <a href="">
                Daily Deals
              </a>
            </li>
            <li>
              <a href="">
                App Only Deals
              </a>
            </li>
            <li>
              <a href="">
                Our Hottest Products
              </a>
            </li>
            <li>
              <a href="">
                Gift Vouchers
              </a>
            </li>
            <li>
              <a href="">
                Trending Product
              </a>
            </li>
            <li>
              <a href="">
                Hot Flash Sale
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="follow_container">
        <div class="row">
          <div class="col-md-9">
            <div class="app_container">
              <h3>
                DOWNLOAD OUR APPS

              </h3>
              <div>
                <img src="images/home/google-play.png" alt=""/>
                <img src="images/home/apple-store.png" alt=""/>
              </div>
            </div>
          </div>
          <div class="col-md-3 ">
            <div class="info_social">
              <div>
                <a href="">
                  <img src="images/home/fb.png" alt=""/>
                </a>
              </div>
              <div>
                <a href="">
                  <img src="images/home/twitter.png" alt=""/>
                </a>
              </div>
              <div>
                <a href="">
                    <img src="images/home/linkedin.png" alt=""/>
                </a>
              </div>
              <div>
                <a href="">
                    <img src="images/home/instagram.png" alt=""/>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end info section -->

  <!-- footer section -->
  <section class="container-fluid footer_section">
    <p>
      Copyright &copy; 2019 All Rights Reserved By
      <a href="https://html.design/">Free Html Templates</a>
    </p>
  </section>
  <!-- footer section -->
  <script src="js/bootstrap.js" type="text/javascript"></script>
  <script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
  <script>
    function openNav() {
      document.getElementById("myNav").style.width = "100%";
    }

    function closeNav() {
      document.getElementById("myNav").style.width = "0%";
    }
  </script>
        
        
        <input href="http://localhost:8084/SistemaVentasRopa/shop.jsp" type="button" value="Ir a HOme">
        <a href="http://localhost:8084/SistemaVentasRopa/shop.jsp">Tienda</a>
        <hr>
        <a href="http://localhost:8084/SistemaVentasRopa/administracion.jsp">Registro de Productos</a>
        <script src="js/autofadeDeyvis.js" type="text/javascript"></script>
    </body>
</html>
