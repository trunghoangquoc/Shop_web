<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Fresh Fruit Cart</title>
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
            <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">Product</a>
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
  <div id="banner" class="carousel slide" data-ride="carousel">
    <img src="./image/banner_cáº£t.jpg" alt="" style="width:100% ;   height: 300px;">
</div>

  <!-- chia lÆ°á»t 1-->
  <div class="container py-5">
    <h2 class="mb-5">Giá» hÃ ng cá»§a báº¡n</h2>
    <table class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>STT</th>
                <th>HÃ¬nh áº¢nh</th>
                <th>TÃªn Sáº£n pháº©m</th>
                <th>Sá» LÆ°á»£ng</th>
                <th>GiÃ¡</th>
                <th>ThÃ nh tiÃªn</th>
                <th>Lá»±a</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td>
                    <img src="./image/feature-5.jpg" alt="" width="60">
                </td>
                <td>Nho Má»¹ Tho</td>
                <td>
                    <input type="number" style="width:60px; text-align: center;" value="5">
                </td>
                <td>100000</td>
                <td>500000</td>
                <td>
                    <a href="" class="btn btn-sm btn-danger">XÃ³a</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>
                    <img src="./image/feature-2.jpg" alt="" width="60">
                </td>
                <td>Chuá»i Má»¹</td>
                <td>
                    <input type="number" style="width:60px; text-align: center;" value="5">
                </td>
                <td>100000</td>
                <td>500000</td>
                <td>
                    <a href="" class="btn btn-sm btn-danger">XÃ³a</a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>
                    <img src="./image/feature-8.jpg" alt="" width="60">
                </td>
                <td>TÃ¡o Äá»</td>
                <td>
                    <input type="number" style="width:60px; text-align: center;" value="5">
                </td>
                <td>100000</td>
                <td>500000</td>
                <td>
                    <a href="" class="btn btn-sm btn-danger">XÃ³a</a>
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>
                    <img src="./image/lp-2.jpg" alt="" width="60">
                </td>
                <td>á»t Äá» Cam</td>
                <td>
                    <input type="number" style="width:60px; text-align: center;" value="5">
                </td>
                <td>100000</td>
                <td>500000</td>
                <td>
                    <a href="" class="btn btn-sm btn-danger">XÃ³a</a>
                </td>
            </tr>
            <tr>
                <td>5</td>
                <td>
                    <img src="./image/lp-1.jpg" alt="" width="60">
                </td>
                <td>Rau Xanh</td>
                <td>
                    <input type="number" style="width:60px; text-align: center;" value="5">
                </td>
                <td>100000</td>
                <td>500000</td>
                <td>
                    <a href="" class="btn btn-sm btn-danger">XÃ³a</a>
                </td>
            </tr>
        </tbody>
    </table>
    <hr>
    <div class="row">
        <div class="col-md-7">
            <form class="form-inline">
                <div class="form-group">
                    <input type="text" name="" style="width:250px" class="form-control" placeholder="MÃ£ giáº£m giÃ¡"">
                </div>
                <button class=" btn btn-success">Ãp dá»¥ng </button>
            </form>
        </div>
        <div class="col-md-5">
            <h4>Tá»ng tiá»n: 50000000 Ä</h4>
            <p>
                Shipper: 50000Ä
            </p>
            <h3>Thanh toÃ¡n: 505000 Ä</h3>
            <button class=" btn btn-success">Äi Äáº¿n thanh toÃ¡n</button>
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