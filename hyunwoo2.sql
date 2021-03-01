create or replace view vwbestseller --베스트셀러(바로드림+종이책) view
as
select     
    h.seq as seq, 
    z.name as author, 
    h.title as title, 
    h.publisher as publisher, 
    h.price as price, 
    h.pubdate as pubdate, 
    h.copy as copy, 
    h.image as image, 
    y.결제합계수량 as totalsale,
    m.mcategory as mcategory,
    dense_rank() over (order by y.결제합계수량 desc, y.seq desc) as salerank
    from tblbook h
        inner join 
        (select 
            s.seq, sum(s.total) as 결제합계수량 from 
        (select 
            a.seq,
            sum(b.amount) as total
            from tblBook a
            inner join tblBaroOrderDetail b
            on a.seq = b.seqBook
            inner join tblBaroOrder c
            on b.seqBaroOrder = c.seq
            inner join tblBaroPay d
            on c.seq = d.seqBaroOrder
            --where d.paydate between sysdate -90 and sysdate
    group by a.seq
                           
UNION ALL 

select 
        a.seq,
        sum(b.amount) as total
        from tblBook a
            inner join tblBookOrderDetail b
            on a.seq = b.seqBook
            inner join tblBookOrder c
            on b.seqBookOrder = c.seq
            inner join tblBookPay d
            on c.seq = d.seqBookOrder
            --where d.paydate between sysdate -90 and sysdate
        group by a.seq
) s
group by s.seq
order by sum(s.total))y
on h.seq = y.seq
inner join tblauthor z
on h.seqAuthor = z.seq
inner join tblscategory s
on h.seqSCategory = s.seq
inner join tblmcategory m
on s.seqMCategory = m.seq
inner join tbllcategory l
on m.seqLCategory = l.seq;


select * from vwbestseller where pubdate between trunc(sysdate, 'mm') and last_day(sysdate)
create or replace view vwnewbook --신간도서 view
as
select * from(
    select a.seq as seq, a.title as title, a.publisher as publisher, a.copy as copy,  a.price as price, a.pubdate as pubdate, a.image as image, b.name as author, m.mcategory as mcategory, row_number() over(order by pubdate desc, title asc) as rank
    from tblbook a  
    inner join tblauthor b
    on a.seqauthor = b.seq
    inner join tblscategory s
    on a.seqSCategory = s.seq
    inner join tblmcategory m
    on s.seqMCategory = m.seq
    inner join tbllcategory l
    on m.seqLCategory = l.seq);
    

create or replace view vwrealtimesearch --실시간 검색순위 view
as   
select * from (select searchword, count(searchword) as searchcount, row_number() over (order by count(searchword) desc) as rank from tblsearchrank where searchdate = to_date(sysdate, 'yyyy-mm-dd') group by searchword)
where rank between 1 and 10;


select * from vwbestseller
--select * from vwbestseller where pubdate between trunc(sysdate, 'mm') and last_day(sysdate) --월간베스트 select 


create or replace view vwrecommendbook --추천도서 view
as
select 
    a.seq, 
    a.id, 
    a.name, 
    d.title, 
    d.copy, 
    d.price, 
    d.publisher, 
    d.pubDate, 
    d.image, 
    rank 
from tblmember a
    left outer join tblFavorite b
    on a.seq = b.seqMember
    left outer join tblSCategory c
    on b.seqSCategory = c.seq
    left outer join (select seq, seqscategory, title, publisher, copy, pubdate, price, image, rank() over(order by pubdate desc, title asc) rank from tblbook) d 
    on c.seq = d.seqSCategory;


select * from vwrecommendbook



create or replace view vweBook -- 카테고리 포함 EBOOK view
as              
select
d.seq as seq,
d.title as title,
d.publisher as publisher,
d.price as price,
d.pubdate as pubdate,
d.copy as copy,
d.image as image,
d.contents as contents,
g.lcategory as lcategory,
h.name as name
from 
    tblebook d
    inner join tblSCategory e
    on d.seqSCategory = e.seq
    inner join tblMCategory f
    on e.seqMCategory = f.seq 
    inner join tblLCategory g
    on f.seqLCategory = g.seq
    inner join tblAuthor h
    on d.seqAuthor = h.seq;



create or replace view vwBook -- 카테고리 포함 BOOK view
as              
select
d.seq as seq,
d.title as title,
d.publisher as publisher,
d.price as price,
d.summary as summary,
d.pubdate as pubdate,
d.copy as copy,
d.image as image,
d.page as page,
d.contents as contents,
g.lcategory as lcategory,
h.name as name
from 
    tblbook d
    inner join tblSCategory e
    on d.seqSCategory = e.seq
    inner join tblMCategory f
    on e.seqMCategory = f.seq 
    inner join tblLCategory g
    on f.seqLCategory = g.seq
    inner join tblAuthor h
    on d.seqAuthor = h.seq;
 
 
 create or replace view vwbooksales--종이책 매출 (default) view
 as
 select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblbookpay group by totalpay));
 
 
 create or replace view VWBAROBOOKSALES -- 바로드림 매출(default) view
 as
 select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblbaropay group by totalpay));
 
 
 create or replace view VWEBOOKSALES --ebook 매출(default) view 
 as
 select sales from(select sum(sales) as sales from (select sum(totalpay) as sales from tblepay group by totalpay));
 
 


create or replace view vwdefaultStatAgeCnt -- 고객연령통계 default view
as
select age, sum(agecnt) as agecnt from(
select age, agecnt from(
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)   
                    
union all

select age, agecnt from (
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblbaropay a
    inner join tblbaroOrder b
        on a.seqbaroOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)  
                    
union all                    

select age, agecnt from (
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblepay a
    inner join tblEOrder b
        on a.seqEOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)) group by age;
                  


 


 CREATE OR REPLACE PROCEDURE proc_StatAgeCnt --고객 연령통계 프로시저 (날짜입력 view)
(
   startdate IN NUMBER,
   enddate IN NUMBER, 
   pcursor OUT sys_refcursor
)
IS
BEGIN 
   OPEN pcursor FOR
    
select age, sum(agecnt) as agecnt from(
select age, agecnt from(
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    --where a.paydate between '20190101' and '20221230'
                    where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)   
                    
union all

select age, agecnt from (
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblbaropay a
    inner join tblbaroOrder b
        on a.seqbaroOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    --where a.paydate between '20170101' and '20221230'
                    where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)  
                    
union all                    

select age, agecnt from (
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblepay a
    inner join tblEOrder b
        on a.seqEOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    --where a.paydate between '20170101' and '20221230'
                    where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)) group by age;
                  
END proc_StatAgeCnt;    
 
 
create or replace view vwdefaultStatGenderCnt -- 고객성별통계(주문건수기준) default view
as
select gender, sum(gendercnt) as gendercnt from(
select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as 기간, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblepay a
    inner join tblEOrder b
        on a.seqEOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                 --where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender
 
 union all
 
select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as 기간, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                 --where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    --inner join tblBookOrderDetail d
                        -- b.seq = d.seqBookOrder                               
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender       
 
union all

select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblBaroPay a
    inner join tblbaroOrder b
        on a.seqBaroOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                --where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender) group by gender
 
 
 
 
 

CREATE OR REPLACE PROCEDURE proc_StatGenderCnt --고객 성별통계 프로시저(주문건수기준) (날짜입력 view)
(
   startdate IN NUMBER,
   enddate IN NUMBER, 
   pcursor OUT sys_refcursor
)
IS
BEGIN 
   OPEN pcursor FOR 
   
select gender, sum(gendercnt) as gendercnt from(
select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as 기간, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblepay a
    inner join tblEOrder b
        on a.seqEOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender
 
union all

select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as 기간, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    --inner join tblBookOrderDetail d
                        --on b.seq = d.seqBookOrder  
                            where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                            group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender       
 
union all

select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblBaroPay a
    inner join tblbaroOrder b
        on a.seqBaroOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender) group by gender;
 
 END proc_StatGenderCnt;    
 

create or replace view vwmainbestseller --메인페이지 월간베스트 view
as
select e.seq as seq, e.title as title, e.copy as copy, e.image as image, e.paydate as paydate, sum(e.amount) as amount  from
(select 
            a.seq,
            a.title,
            a.copy,
            a.image,
            b.amount as amount,
            d.paydate
            from tblBook a
            inner join tblBookOrderDetail b
            on a.seq = b.seqBook
            inner join tblBookOrder c
            on b.seqBookOrder = c.seq
            inner join tblBookPay d
            on c.seq = d.seqBookOrder
                   
union all
        
select 
            a.seq,
            a.title,
            a.copy,
            a.image,
            b.amount as amount,
            d.paydate
            from tblBook a
            inner join tblBaroOrderDetail b
            on a.seq = b.seqBook
            inner join tblBaroOrder c
            on b.seqBaroOrder = c.seq
            inner join tblBaroPay d
            on c.seq = d.seqBaroOrder)e
              where e.paydate between trunc(sysdate, 'mm') and last_day(sysdate) group by e.seq, e.paydate, e.amount, e.title, e.copy, e.image order by amount desc;
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 -- 테스트 (무시하시면됩니당)
 select * from tblbook a
    inner join tblsCategory b
        on a.seqSCategory = b.seq
            inner join tblMCategory c
                on b.seqMCategory = c.seq
                    where mcategory = '유아/어린이/청소년'
                    

--연령 - book
select age, agecnt from(
select age, sum(agecnt) as agecnt from(
select 
   to_char(a.paydate, 'yyyy-mm-dd') as paydate, 
   trunc((to_char(sysdate,'yyyy') + 1 -(substr(c.ssn,0,2)+
    (case
    when substr(c.ssn,8,1) < 3 then 1900
    when substr(c.ssn,8,1) >= 3 then 2000
    end)))/10*10, -1) as age,
    count(a.totalpay) as agecnt  
   from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by age)   



select gender, sum(gendercnt) as gendercnt from(
select 
    to_char(a.paydate, 'yyyy-mm-dd') as 기간, 
    case
        when substr(c.ssn, 8, 1) = '1' then '남자'
        when substr(c.ssn, 8, 1) = '2' then '여자'
    end as gender,
    count(a.totalpay) as gendercnt
    from tblbookpay a
    inner join tblbookOrder b
        on a.seqbookOrder = b.seq
            inner join tblMember c
                on b.seqMember = c.seq
                 --where to_char(a.paydate, 'yyyymmdd') between startdate and enddate
                    --inner join tblBookOrderDetail d
                        --on b.seq = d.seqBookOrder                               
                    group by to_char(a.paydate, 'yyyy-mm-dd'), c.ssn) group by gender       
 
 
 
select * from vwbestseller where seq between 1 and 10 and pubdate between '20190101' and '20221120' and mcategory = '소설' order by salerank asc
 

 
select * from vwdefaultStatGenderCnt
select * from vwdefaultStatAgeCnt


