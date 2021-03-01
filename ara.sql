-- 나의독후감 작성하는 화면에서
-- 셀렉트박스에 독후감 작성이 가능한 책 목록을 나타낼 때 쓰는 프로시저
-- http://localhost:8090/bookjuck/member/review/add.do
-- 1. 주문이 모두 끝난 종이책이어야 하고, 2. 작성된 독후감이 없는 종이책이어야 한다.

create or replace procedure procShowPossibleBook
(
    pseq tblMember.seq%type,
    ocursor out sys_refcursor
)
is
begin
    open ocursor for
        select b.seq as seq, b.title as title from tblbookorderdetail od
            inner join tblbookorder o
                on o.seq=od.seqbookorder
                    inner join tblBook b
                        on b.seq=od.seqbook
                            inner join tblMember m
                                on m.seq=o.seqmember
                                    where m.seq=pseq
                                        and o.orderstate='배송완료'
        minus
        select b.seq as seq, b.title as title from tblReview r
            inner join tblMember m
                on r.seqmember=m.seq
                    inner join tblBook b
                        on r.seqbook=b.seq
                            where r.seqmember=pseq;
exception
    when others then
        dbms_output.put_line('SQL ERROR MESSAGE: '|| SQLERRM);
end;