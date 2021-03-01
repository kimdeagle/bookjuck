<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
   
<section class="mainsection" style="width:1250px; position:relative; top:-35px; left:-30px;">
  <!--  <section class="mainsection"> -->
   <!--  <h3 id="bestmonthtitle" style="text-align:center;">월간베스트</h3> -->
   <h3 id="bestmonthtitle">월간베스트</h3>
    <c:forEach items="${list}" var="dto" begin="0" end="4" step="1">
   <table id="bestmonth" style="display:inline-block; margin:20px; width:200px; height:200px;">
        <tr>
            <td>
                <div class="monthitem">
                    <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><img src="/bookjuck/image/${dto.image}" class="book-sm" style="width:150px; height:172px; display: block; margin: 0px auto;"></a>                
                    <a href="http://localhost:8090/bookjuck/member/book/bookdetail.do?seq=${dto.seq}"><h6>${dto.title}</h6></a>
                    <p>${dto.copy}</p>
                </div>
            </td>
        </tr>
    </table>
    </c:forEach>
</section>
