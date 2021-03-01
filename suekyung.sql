-- 종이책 장바구니 뷰
create or replace view vwBookcart
as
select
    bc.seqmember as seqMember, -- 회원 번호
    b.seq as seqBook, -- 책 번호
    b.image as image,-- 책 이미지
    b.title as title,--책 제목
    bc.amount as amount, -- 책 수량
    b.price as price, --책 정가
    b.salePrice as salePrice, --책 판매가
    amount * salePrice as total -- 수량 포함 가격
from tblBookCart bc
    inner join tblmember m
    on bc.seqMember = m.seq
        inner join tblBook b
        on bc.seqbook = b.seq;
        

-- 종이책 상세 주문 뷰
create or replace view vwbookOrderList
as
select
    m.seq as seqMember, -- 회원번호
    m.id as id, --회원 아이디
    bo.seq as seqbookorder, --주문번호
    bo.orderdate as orderdate, --주문 일자
    bo.orderstate as orderstate,--주문상태
    m.name as ordername,--주문자 이름
    m.tel as ordertel, -- 주문자 연락처
    bd.name as deliveryname, --배송자 이름
    bd.address as deliveryaddress, --배송 주소
    bd.tel as deliverytel,--배송자 연락처
    bd.deliverycompany as deliveryCompany, --배송업체
    bd.deliverynumber as deliveryNumber, -- 운송장번호
    b.seq as seqBook, -- 종이책 번호
    b.isbn as isbn, --책 isbn
    b.image as image, -- 책 사진
    b.title as title,-- 책 제목
    b.salePrice as salePrice,--판매가
    bod.amount as amount,-- 수량
    salePrice * amount as total, -- 수량x판매가
    bp.payment as payment, -- 결제방법
    bp.totalpay as totalPay, --총결제액
    bp.usepoint as usePoint, --포인트사용액
    bp.actualpay as actualPay,--실결제액
    bp.savepoints as savePoints,--적립포인트
    bp.paydate as payDate--결제일
from tblBookOrder bo--종이책 주문
    inner join tblMember m--회원정보
    on bo.seqmember = m.seq
        inner join tblbookorderdetail bod--종이책 상세 주문
        on bod.seqbookorder = bo.seq
            inner join tblBook b -- 도서 정보
            on bod.seqbook = b.seq 
                inner join tblbookdelivery bd -- 종이책 배송
                on bd.seqbookorder = bo.seq
                    inner join tblbookpay bp --종이책 결제
                    on bp.seqbookorder = bo.seq;
                    

--종이책 주문내역 조회 프로시저
create or replace PROCEDURE procbookOrderList(
    pseqMember number, -- 회원번호
    pseqBookOrder number,
    pcursor out SYS_REFCURSOR
)
is
begin
    open pcursor
        for select * from vwbookOrderList
            where seqMember = pseqMember and seqBookOrder = pseqBookOrder
            order by orderdate, seqbookorder, title;
end;



-- 바로드림 상세 주문 뷰
create or replace view vwBaroOrderList
as
select
    m.seq as seqMember, -- 회원번호
    m.id as id, --회원 아이디
    bo.seq as seqbaroorder, --주문번호
    bo.orderdate as orderdate, --주문 일자
    bo.orderstate as orderstate,--주문상태
    m.name as ordername,--주문자 이름
    m.tel as ordertel, -- 주문자 연락처
    b.seq as seqBook, -- 종이책 번호
    b.isbn as isbn, --책 isbn
    b.image as image, -- 책 사진
    b.title as title,-- 책 제목
    b.salePrice as salePrice,--판매가
    bod.amount as amount,-- 수량
    salePrice * amount as total, -- 수량x판매가
    bp.payment as payment, -- 결제방법
    bp.totalpay as totalPay, --총결제액
    bp.usepoint as usePoint, --포인트사용액
    bp.actualpay as actualPay,--실결제액
    bp.savepoints as savePoints,--적립포인트
    bp.paydate as payDate--결제일
from tblBaroOrder bo--종이책 주문
    inner join tblMember m--회원정보
    on bo.seqmember = m.seq
        inner join tblBaroorderdetail bod--종이책 상세 주문
        on bod.seqBaroorder = bo.seq
            inner join tblBook b -- 도서 정보
            on bod.seqbook = b.seq
                    inner join tblbaropay bp --종이책 결제
                    on bp.seqBaroorder = bo.seq;
                    

--바로드림 주문내역 조회 프로시저
create or replace PROCEDURE procBaroOrderList(
    pseqMember number, -- 회원번호
    pseqBaroOrder number,
    pcursor out SYS_REFCURSOR
)
is
begin
    open pcursor
        for select * from vwbaroOrderList
            where seqMember = pseqMember and seqBaroOrder = pseqBaroOrder
            order by orderdate, seqBaroorder, title;
end;

-- 이북 상세 주문 뷰
create or replace view vwEBookOrderList
as
select
    m.seq as seqMember, -- 회원번호
    m.id as id, --회원 아이디
    bo.seq as seqEBookorder, --주문번호
    bo.orderdate as orderdate, --주문 일자
    bo.orderstate as orderstate,--주문상태
    m.name as ordername,--주문자 이름
    m.tel as ordertel, -- 주문자 연락처
    b.seq as seqEBook, -- 종이책 번호
    b.isbn as isbn, --책 isbn
    b.image as image, -- 책 사진
    b.title as title,-- 책 제목
    b.salePrice as salePrice,--판매가
    bp.payment as payment, -- 결제방법
    bp.totalpay as totalPay, --총결제액
    bp.usepoint as usePoint, --포인트사용액
    bp.actualpay as actualPay,--실결제액
    bp.savepoints as savePoints,--적립포인트
    bp.paydate as payDate--결제일
from tblEOrder bo--종이책 주문
    inner join tblMember m--회원정보
    on bo.seqmember = m.seq
        inner join tblEorderdetail bod--종이책 상세 주문
        on bod.seqEorder = bo.seq
            inner join tblEBook b -- 도서 정보
            on bod.seqEbook = b.seq
                    inner join tblEpay bp --종이책 결제
                    on bp.seqEorder = bo.seq;
                    

--이북 주문내역 조회 프로시저
create or replace PROCEDURE procEBookOrderList(
    pseqMember number, -- 회원번호
    pseqEBookOrder number,
    pcursor out SYS_REFCURSOR
)
is
begin
    open pcursor
        for select * from vwEBookOrderList
            where seqMember = pseqMember and seqEBookOrder = pseqEBookOrder
            order by orderdate, seqEBookorder, title;
end;


-- 종이책 장바구니 뷰
-- 회원번호
-- 책 번호, 이미지, 제목, 가격, 수량, 수량 포함 가격
create or replace view vwBookcart
as
select
    bc.seqmember as seqMember, -- 회원 번호
    b.seq as seqBook, -- 책 번호
    b.image as image,-- 책 이미지
    b.title as title,--책 제목
    bc.amount as amount, -- 책 수량
    b.price as price, --책 정가
    b.salePrice as salePrice, --책 판매가
    amount * salePrice as total -- 수량 포함 가격
from tblBookCart bc
    inner join tblmember m
    on bc.seqMember = m.seq
        inner join tblBook b
        on bc.seqbook = b.seq;
        

create or replace view vwBookcart as select bc.seqmember as seqMember, b.seq as seqBook, b.image as image, b.title as title, bc.amount as amount,
    b.price as price, --책 가격
    amount * price as total -- 수량 포함 가격
from tblBookCart bc
    inner join tblmember m
    on bc.seqMember = m.seq
        inner join tblBook b
        on bc.seqbook = b.seq;



-- 장바구니 조회 프로시저
create or replace PROCEDURE procCartList(
    pseqMember number, -- 회원번호
    pcursor out SYS_REFCURSOR
)
is
begin
    open pcursor
        for select * from vwBookCart
            where seqMember = pseqMember;
end;
