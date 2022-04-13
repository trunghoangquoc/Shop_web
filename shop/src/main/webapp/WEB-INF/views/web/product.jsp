<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Fruit</title>

  <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css' /> ">
  <link rel="stylesheet" href="<c:url value='/template/web/css/css/my_style.css' /> ">
</head>

<body>

  <!-- nav -->
  <nav class="navbar sticky-top navbar-expand-sm navbar-light  " style="background-color: #f0ecdd;"
    style="color: aqua ;">
    <div class="container">
      <a class="navbar-brand" href="index.html">
        <img src="./image/home.png" alt="" style="width: 40px;">
      </a>
      <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#mainmenu"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="mainmenu">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
          <li class="nav-item active"><a class="nav-link" href="index.html">HOME</span></a></li>
        
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="product.html" data-toggle="dropdown">Product</a>
            <div class="dropdown-menu">
              <a class="dropdown-item" href="product.html">Fresh Fruit</a>
              <a class="dropdown-item" href="product.html">Fresh Fruit</a>
              <a class="dropdown-item" href="product.html">Fresh Fruit</a>
              <a class="dropdown-item" href="product.html">Fresh Fruit</a>
            </div>
          </li>
          <li class="nav-item"><a class="nav-link" href="contact.html">CONTACT</a></li>
          <li class="nav-item"><a class="nav-link" href="cart.html">CART</a></li>

        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <form class="form-inline  login">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
            <a href="login.html">
              Login
            </a>
          </button>
        </form>
        <form class="form-inline my-2 my-lg-0 sign-up">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
            <a href="sign-up.html"> Sign-up</a>
          </button>
        </form>
      </div>
    </div>
  </nav>

  <!-- banner slide -->
 
  <!-- banner slide -->
  <div id="banner" class="carousel slide" data-ride="carousel">
    <img src="./image/Banner-2.jpg" alt="" style="width:100% ;   height: 500px;">
</div>

  <!-- chia lÆ°á»t 1-->
  <div class="container ">
    <div class="hot">
      <h2 class="mb-5">Sáº£n pháº©m má»i
        <img src="./image/sanpanhot.png" alt="">
      </h2>
    </div>

    <div class="row grid">
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-2.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_1" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-3.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_2" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-4.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_3" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-7.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_4" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="row grid">
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-2.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_1" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-3.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_2" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-4.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_3" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <img class="card-img-top" src="./image/feature-7.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_4" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- banner giua -->
  <div class="container">
    <div class="row banner_giua">
      <div class="col-md-6 col-sm-12">
        <img src="./image/bannergiua_1.jpg" alt="">
      </div>
      <div class="col-md-6 col-sm-12">
        <img src="./image/bannergiua_2).jpg" alt="">
      </div>
    </div>
  </div>
  <!-- luoi 2 -->
  <div class="container ">
    <div class="hot">
      <h2 class="mb-5">Sáº£n pháº©m Sale
        <img src="./image/sanpanhot.png" alt="">
      </h2>
    </div>

    <div class="row grid">
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-2.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_1" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-3.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_2" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-4.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_3" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-7.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_4" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
    </div>
    <div class="row grid">
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-2.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_1" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-3.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_2" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-4.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_3" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
      <div class="col-md-3 col-sm-6 feature">
        <div class="card text-center">
          <span class="sale">-30%</span>
          <img class="card-img-top" src="./image/feature-7.jpg" alt="">
          <div class="card-body card-body_1">
            <p class="card-text">
            <h5>GiÃ¡: 500.000 Ä</h5>
            <a data-toggle="modal" data-target="#modelId_4" class="btn btn-sm btn-info">Chi tiáº¿t</a>
            <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
 <!-- page -->
 <div class="container page">
  <nav aria-label="Page navigation example ">
    <ul class="pagination">
      <li class="page-item">
        <a class="page-link" href="product.html" aria-label="Previous">
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li class="page-item"><a class="page-link" href="product.html">1</a></li>
      <li class="page-item"><a class="page-link" href="product.html">2</a></li>
      <li class="page-item"><a class="page-link" href="product.html">3</a></li>
      <li class="page-item">
        <a class="page-link" href="product.html" aria-label="Next">
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
 </div>
  
  <!-- modal 1-->
  
  <div class="modal fade" id="modelId_1" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog modal-xl" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-5">
                        <img src="./image/feature-2.jpg" alt="" class="w-100">
                    </div>
                    <div class="col-md-7">
                        <h2>Frush Fruit</h2>
                        <h4>GiÃ¡: 500.000 Ä</h4>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                            aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                            quis dignissimos nemo aut autem fuga. Id, ipsa.
                        </p>
                        <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- modal2 -->

<div class="modal fade" id="modelId_2" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-5">
                      <img src="./image/feature-3.jpg" alt="" class="w-100">
                  </div>
                  <div class="col-md-7">
                      <h2>Fresh Fruit</h2>
                      <h4>GiÃ¡: 500.000 Ä</h4>
                      <p class="card-text">
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                          aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                          quis dignissimos nemo aut autem fuga. Id, ipsa.
                      </p>
                      <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                  </div>
              </div>

          </div>
      </div>
  </div>
</div>
<!-- modal3 -->
<div class="modal fade" id="modelId_3" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-5">
                      <img src="./image/feature-4.jpg" alt="" class="w-100">
                  </div>
                  <div class="col-md-7">
                      <h2>Fresh Fruit</h2>
                      <h4>GiÃ¡: 500.000 Ä</h4>
                      <p class="card-text">
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                          aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                          quis dignissimos nemo aut autem fuga. Id, ipsa.
                      </p>
                      <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                  </div>
              </div>

          </div>
      </div>
  </div>
</div>

<!-- modal4 -->
<div class="modal fade" id="modelId_4" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-5">
                      <img src="./image/feature-7.jpg" alt="" class="w-100">
                  </div>
                  <div class="col-md-7">
                      <h2>Fresh Fruit</h2>
                      <h4>GiÃ¡: 500.000 Ä</h4>
                      <p class="card-text">
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                          aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                          quis dignissimos nemo aut autem fuga. Id, ipsa.
                      </p>
                      <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                  </div>
              </div>

          </div>
      </div>
  </div>
</div>

<!-- modal 5 -->

<div class="modal fade" id="modelId_5" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-4">
                      <img src="./image/lp-1.jpg" alt="" class="w-100">
                  </div>
                  <div class="col-md-8">
                      <h2>Fresh Vegetable</h2>
                      <h4>GiÃ¡: 500.000 Ä</h4>
                      <p class="card-text">
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                          aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                          quis dignissimos nemo aut autem fuga. Id, ipsa.
                      </p>
                      <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                  </div>
              </div>

          </div>
      </div>
  </div>
</div>
<!-- modal 6 -->
<div class="modal fade" id="modelId_6" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
  <div class="modal-dialog modal-xl" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title">Chi tiáº¿t sáº£n pháº©m</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="row">
                  <div class="col-md-4">
                      <img src="./image/lp-2.jpg" alt="" class="w-100">
                  </div>
                  <div class="col-md-8">
                      <h2>Fresh Vegetable</h2>
                      <h4>GiÃ¡: 500.000 Ä</h4>
                      <p class="card-text">
                          Lorem ipsum dolor sit amet consectetur adipisicing elit. Quidem, rerum error. Sequi
                          aliquid quidem voluptates doloribus tempora. Quasi repudiandae ad pariatur repellendus
                          quis dignissimos nemo aut autem fuga. Id, ipsa.
                      </p>
                      <a href="cart.html" class="btn btn-sm btn-success">Add Cart</a>
                  </div>
              </div>

          </div>
      </div>
  </div>
</div>
  <!-- footer -->
  <footer class="footer  text-black-50 py-5 footer-style">
    <div class="container footer-style">
        <div class="row">
            <div class="col-md-4">
               <img src="./image/logo.png" alt="">
            <ul class = "info">
              <li>Address :238 ,Hoang Quoc Viet</li>
              <li>Phone :+0123456789</li>
              <li>Email : bkap@gmail.com</li>
            </ul>
            </div>
            <div class="col-md-2 useful-link " >
                <h5>Useful Link</h5>
               <ul>
                    <li><a href="">Trang chủ</a></li>
                    <li><a href="">Giới thiệu</a></li>
                    <li><a href="">Đối Tác</a></li>
                    <li><a href="">Liên hệ</a></li>
                </ul>
            </div>
            <div class="col-md-6">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d59587.97785449821!2d105.80194400550647!3d21.02273601626801!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9bd9861ca1%3A0xe7887f7b72ca17a9!2zSMOgIE7hu5lpLCBIb8OgbiBLaeG6v20sIEjDoCBO4buZaSwgVmnhu4d0IE5hbQ!5e0!3m2!1svi!2s!4v1645101482752!5m2!1svi!2s"
                    style="border:0; width: 100%; height: 200px;" allowfullscreen="" loading="lazy"></iframe>
            </div>
        </div>
    </div>
</footer>

      <!-- Copyright -->
      <div class="footer-copyright text-center py-3" style="background-color: darkmagenta;">Â©238_HoangQuocViet:
        <a href="https://mdbootstrap.com/"> BkAptech.com</a>
      </div>
      <!-- Copyright -->
  


  <!-- Footer -->
  <!-- chá»nh sá»­a thá»i gian slide cháº¡y -->
  <script>
    $('#carouselExampleIndicators').carousel({
      interval: 1000 * 3
    });
  </script>
  <script src="<c:url value='/template/web/js/jquery.min.js' />"></script>
  <script src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
</body>

</html>