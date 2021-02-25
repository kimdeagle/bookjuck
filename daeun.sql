/*
	
 	1. 중고게시판 관련
 	2. 교환/취소/환불 (사용자) 관련
 	3. 교환/취소/환불 (관리자) 관련   
 	
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
    bo.orderstate
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
    eo.orderstate
from tblEOrder eo
inner join tblEOrderDetail eod
    on eo.seq = eod.seqEOrder
        inner join tblBook b
            on b.seq = eod.seqebook
                inner join tblERefund er
                    on eo.seq = er.seqEOrder
where er.refunddate is not null and eo.orderstate = '주문환불'
order by eo.seq asc;
-- #### Ebook 주문 (교환/취소/환불) 조회 리스트 뷰