/*
	
 	1. 중고게시판 관련
 	2. 교환/취소/환불 (사용자) 관련
 	3. 주문/배송 + 교환/취소/환불 (관리자) 관련 
 	
 	2021.03.01추가
 	4. (사용자) 주문 타입을 알아보는 뷰
 	
*/


-- 1. 
-- ########### 중고게시판 뷰
create or replace view vwUsedBoard
as
select
    seq,
    title,
    content,
    regdate,
    seqMember,
    (select id from tblMember where seq = tblUsedBoard.seqMember) as id,
    readcnt,
    dealstate,
    (sysdate - regdate)  * 24 as gap,
    image,
    orgimage,
    (select count(*) from tblComment where seqUsedBoard = tblUsedBoard.seq) as ccount
from tblUsedBoard;
-- ########### 중고게시판 뷰




-- 2. 
-- #### 자사배송 주문 (교환/취소/환불) 조회 리스트 뷰
create or replace view vwBookRefundList
as
select distinct
    bo.seq,
    case
        when br.refunddate is not null then br.refunddate
        when bc.canceldate is not null then bc.canceldate
        when bch.changedate is not null then bch.changedate
    end as applydate,
    b.title,
    (select 
    sum(a.amount)
from tblbookorderdetail a
    inner join tblBookOrder b
        on a.seqbookorder = b.seq
            group by b.seq
                having b.seq = bo.seq) as totalamount,
    bo.orderstate,
    m.seq as seqMember,
    m.id as id,
    bo.orderdate,
        case
        when br.refundstate is not null then br.refundstate
        when bc.cancelstate is not null then bc.cancelstate
        when bch.changestate is not null then bch.changestate
    end as process
from tblBookOrder bo
inner join tblBookOrderDetail bod
    on bo.seq = bod.seqBookOrder
        inner join tblBook b
            on b.seq = bod.seqBook
                left outer join tblBookRefund br
                    on bo.seq = br.seqBookOrder
                        left outer join tblBookCancel bc
                            on bo.seq = bc.seqBookOrder
                                left outer join tblBookChange bch
                                    on bo.seq = bch.seqBookOrder
                                        inner join tblMember m
                                            on bo.seqMember = m.seq
where bo.orderstate in ('주문취소', '주문환불', '주문교환')
order by bo.seq asc;
-- #### 자사배송 주문 (교환/취소/환불) 조회 리스트 뷰



-- #### Ebook 주문 (교환/취소/환불) 조회 리스트 뷰
create or replace view vwERefundList
as
select distinct
    eo.seq,
    er.refunddate as applydate,
    b.title,
    1 as totalAmount,
    eo.orderstate,
    m.seq as seqMember,
    m.id as id,
    eo.orderdate,
    er.refundstate as process
from tblEOrder eo
inner join tblEOrderDetail eod
    on eo.seq = eod.seqEOrder
        inner join tblEBook b
            on b.seq = eod.seqebook
                inner join tblERefund er
                    on eo.seq = er.seqEOrder
                        inner join tblMember m
                            on eo.seqMember = m.seq
where eo.orderstate = '주문환불'
order by eo.seq asc;
-- #### Ebook 주문 (교환/취소/환불) 조회 리스트 뷰



-- #### 바로드림 주문 (교환/취소/환불) 조회 리스트 뷰
create or replace view vwBaroRefundList
as
select distinct
    bo.seq,
    bc.canceldate as applydate,
    b.title,
    (select 
    sum(a.amount)
from tblBaroorderdetail a
    inner join tblBaroOrder b
        on a.seqBaroorder = b.seq
            group by b.seq
                having b.seq = bo.seq) as totalamount,
    bo.orderstate,
    m.seq as seqMember,
    m.id as id,
    bo.orderdate,
    bc.cancelstate as process
from tblBaroOrder bo
inner join tblBaroOrderDetail bod
    on bo.seq = bod.seqBaroOrder
        inner join tblBook b
            on b.seq = bod.seqbook
                inner join tblBaroCancel bc
                    on bo.seq = bc.seqBaroOrder
                        inner join tblMember m
                            on bo.seqMember = m.seq
where bo.orderstate = '주문취소'
order by bo.seq asc;
-- #### 바로드림 주문 (교환/취소/환불) 조회 리스트 뷰




-- 3.
-- #### 관리자 일반배송 주문조회 리스트 뷰
create or replace view vwAdminBookOrder
as
select distinct
    bo.seq,
    m.id as id,
    b.title,
    bo.orderdate,
    (select 
    sum(a.amount)
from tblbookorderdetail a
    inner join tblBookOrder b
        on a.seqbookorder = b.seq
            group by b.seq
                having b.seq = bo.seq) as totalamount,
    bo.orderstate
from tblBookOrder bo
    inner join tblBookOrderDetail bod
        on bo.seq = bod.seqbookorder
            inner join tblBook b
                on b.seq = bod.seqBook
                    inner join tblMember m
                        on bo.seqMember = m.seq
order by bo.seq asc;
-- #### 관리자 일반배송 주문조회 리스트 뷰



-- #### 관리자 바로드림 주문조회 리스트 뷰
create or replace view vwAdminBaroOrder
as
select distinct
    bo.seq,
    m.seq as seqMember,
    m.id as id,
    b.title,
    bo.orderdate,
    (select 
    sum(a.amount)
from tblBaroorderdetail a
    inner join tblBaroOrder b
        on a.seqBaroorder = b.seq
            group by b.seq
                having b.seq = bo.seq) as totalamount,
    bo.orderstate
from tblBaroOrder bo
    inner join tblBaroOrderDetail bod
        on bo.seq = bod.seqBaroorder
            inner join tblBook b
                on b.seq = bod.seqBook
                    inner join tblMember m
                        on bo.seqMember = m.seq
order by bo.seq asc;
-- #### 관리자 바로드림 주문조회 리스트 뷰


-- #### 관리자 Ebook 주문조회 리스트 뷰
create or replace view vwAdminEOrder
as
select distinct
    eo.seq,
    m.seq as seqMember,
    m.id as id,
    b.title,
    eo.orderdate,
    1 as totalamount,
    eo.orderstate
from tblEOrder eo
    inner join tbleOrderDetail eod
        on eo.seq = eod.seqeorder
            inner join tbleBook b
                on b.seq = eod.seqeBook
                    inner join tblMember m
                        on eo.seqMember = m.seq
order by eo.seq asc;
-- #### 관리자 Ebook 주문조회 리스트 뷰



-- 4.
-- ##### 주문이 일반주문인지 취소, 교환, 환불인지를 알아내는 뷰
create or replace view vwOrderType
as
select
    bo.seq as seqOrder,
    case
        when bc.seq is not null then 'cancel'
        when bch.seq is not null then 'return'
        when br.seq is not null then 'refund'
        when bc.seq is null and bch.seq is null and br.seq is null then 'other'
    end as ordertype
from tblBookOrder bo
    left outer join tblBookCancel bc
        on bo.seq = bc.seqbookorder
            left outer join tblBookChange bch
                on bo.seq = bch.seqbookorder
                    left outer join tblbookrefund br
                        on bo.seq = br.seqbookorder;
-- ##### 주문이 일반주문인지 취소, 교환, 환불인지를 알아내는 뷰