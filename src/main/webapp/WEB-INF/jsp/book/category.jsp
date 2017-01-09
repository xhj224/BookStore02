<%--
  Created by IntelliJ IDEA.
  User: xhj224
  Date: 2016/12/27
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<%--<html xmlns="http://www.w3.org/1999/xhtml">--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Book Store</title>
    <link rel="stylesheet" type="text/css" href="${base}/style/style.css"/>

</head>
<body>
<div id="wrap">

    <div class="header">
        <div class="logo"><a href="${base}/book/IndexAction"><img src="${base}/images/logo.gif" alt="" title=""
                                                                  border="0"/></a></div>
        <div id="menu">
            <ul>
                <li class="selected"><a href="${base}/book/IndexAction">首页</a></li>

                <li><a href="${base}/category/showCategory">图书</a></li>
                <li><a href="${base}/book/viewBookByCate">特价图书</a></li>
                <c:if test="${empty userInfo}" var="userCheck">
                    <li><a href="${base}/user/login">登陆</a></li>
                    <li><a href="${base}/user/register">注册</a></li>
                </c:if>
                <c:if test="${!userCheck}">
                    <li><a href="${base}/user/exit">注销</a></li>
                </c:if>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <li><a href="${base}/order/orderList">我的订单</a></li>
                </c:if>
                <li><a href="${base}/about/aboutAction">关于我们</a></li>
                <li><a href="${base}/contact/contactAction">联系我们</a></li>
            </ul>
        </div>


    </div>


    <div class="center_content">
        <div class="left_content">
            <div class="crumb_nav">
                <a href="${base}/book/IndexAction">首页</a> &gt;&gt; 分类图书
            </div>
            <div class="title"><span class="title_icon"><img src="${base}/images/bullet1.gif" alt="" title=""/></span>分类图书
            </div>

            <div class="new_products">
                <%--@elvariable id="bookPageing" type="com.tz.online.entity.Pageing"--%>
                <c:forEach items="${bookPageing.books}" var="book">
                    <div class="new_prod_box">
                        <a href="${base}/book/detailBook?bookId=${book.bookId}">${book.bookName}</a>
                        <div class="new_prod_bg">
                            <a href="${base}/book/detailBook?bookId=${book.bookId}">
                                <img src="${base}/images/${book.imgUrl}" width="60" height="90" alt="" title=""
                                     class="thumb" border="0"/></a>
                        </div>
                    </div>
                </c:forEach>

                <div class="pagination">
                    <c:set var="url" value="${base}/category/showCategory"/>
                    <c:if test="${bookPageing.pageNow>1}">
                        <a href="${url}?pageNow=${bookPageing.pageNow-1}&pageSize=${bookPageing.pageSize}">&lt;&lt;</a>
                    </c:if>
                    <c:choose>
                        <c:when test="${(bookPageing.pageCount-3)>=0 && bookPageing.pageNow>1}">
                            <c:set var="begin" value="${bookPageing.pageNow-1}"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="begin" value="1"/>
                        </c:otherwise>
                    </c:choose>
                    <c:forEach var="p" begin="${begin}" end="${begin+2}">
                        <c:if test="${p <= bookPageing.pageCount}">
                            <a href="${url}?pageNow=${p}&pageSize=${bookPageing.pageSize}">${p}</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${bookPageing.pageNow != bookPageing.pageCount && bookPageing.pageCount !=0 }">
                        <a href="${url}?pageNow=${bookPageing.pageNow+1}&pageSize=${bookPageing.pageSize}">&gt;&gt;</a>
                    </c:if>
                </div>

            </div>


            <div class="clear"></div>
        </div><!--end of left content-->

        <div class="right_content">
            <div class="languages_box">
                <span class="red">Languages:</span>
                <a href="#"><img src="${base}/images/gb.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/fr.gif" alt="" title="" border="0"/></a>
                <a href="#"><img src="${base}/images/de.gif" alt="" title="" border="0"/></a>
            </div>
            <div class="currency">
                <span class="red">Currency: </span>
                <a href="#">GBP</a>
                <a href="#">EUR</a>
                <a href="#"><strong>USD</strong></a>
            </div>

            <%--@elvariable id="cart" type="com.tz.online.entity.Cart"--%>
            <div class="cart">
                <div class="title">
                  <span class="title_icon">
                    <img src="${base}/images/cart.gif" alt="" title=""/>
                  </span>我的购物车
                </div>
                <c:if test="${!empty userInfo}" var="userCheck">
                    <div class="home_cart_content">
                        <span id="itemCount">${cart.allcount==null?'0':cart.allcount}件商品</span> |
                        <span id="allPrice" class="red">总价:${cart.allPrice==null?'0.0':cart.allPrice}￥</span>
                    </div>
                    <a href="${base}/cart/viewCart" class="view_cart">查看购物车</a>
                </c:if>
            </div>

            <div class="title"><span class="title_icon"><img src="${base}/images/bullet3.gif" alt="" title=""/></span>关于我们店
            </div>
            <div class="about">
                <p>
                    <img src="${base}/images/about.gif" alt="" title="" class="right"/>
                    本书店是天创集团旗下的天智教育经营的书店，开业十年来，一直与国内外五百家出版社，近千家发行单位保持着良好的合作关系。以其集文化传播、艺术鉴赏、休闲为一体的崭新经营方式、一流的购书环境及优质的服务，赢得了众多的荣誉，成为华东地区最大的集图书、音像制品、文化用品、快餐、软件开发、广告策划于一体的图书零售企业。
                </p>

            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet4.gif" alt=""
                                                                 title=""/></span>推荐图书
                </div>
                <c:forEach items="${tuijianBook.books}" var="book">
                    <div class="new_prod_box">
                        <a href="${base}/book/detailBook?bookId=${book.bookId}">${book.bookName}</a>
                        <div class="new_prod_bg">
                            <span class="new_icon">
                                <img src="${base}/images/promo_icon.gif" alt="" title=""/>
                            </span>
                            <a href="${base}/book/detailBook?bookId=${book.bookId}">
                                <img src="${base}/images/${book.imgUrl}" width="60" height="90" alt="" title=""
                                     class="thumb" border="0"/>
                            </a>
                        </div>
                    </div>
                </c:forEach>

            </div>

            <div class="right_box">

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet5.gif" alt=""
                                                                 title=""/></span>图书分类
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                </ul>

                <div class="title"><span class="title_icon"><img src="${base}/images/bullet6.gif" alt=""
                                                                 title=""/></span>合作伙伴
                </div>

                <ul class="list">
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                    <li><a href="#">books gifts</a></li>
                    <li><a href="#">specials</a></li>
                    <li><a href="#">hollidays gifts</a></li>
                    <li><a href="#">accesories</a></li>
                </ul>

            </div>


        </div><!--end of right content-->


        <div class="clear"></div>
    </div><!--end of center content-->


    <div class="footer">
        <div class="left_footer"><img src="${base}/images/footer_logo.gif" alt="" title=""/><br/> <a
                href="http://csscreme.com"><img src="${base}/images/csscreme.gif" alt="by csscreme.com"
                                                title="by csscreme.com" border="0"/></a></div>
        <div class="right_footer">
            <a href="${base}/book/IndexAction">home</a>
            <a href="${base}/about/aboutAction">about us</a>
            <a href="#">services</a>
            <a href="#">privacy policy</a>
            <a href="${base}/contact/contactAction">contact us</a>
        </div>


    </div>


</div>

</body>
</html>
