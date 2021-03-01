--중분류 카테고리 뷰
create or replace view vwMCategory
as
select
    lc.seq as seqLCategory,
    lc.lCategory as lCategory,
    mc.seq as seqMCategory,
    mc.mCategory as mCategory
from tblLCategory lc
    inner join tblMCategory mc
        on lc.seq = mc.seqLCategory
order by seqMCategory asc;


--소분류 카테고리 뷰
create or replace view vwSCategory
as
select
    lc.seq as seqLCategory,
    lc.lCategory as lCategory,
    mc.seq as seqMCategory,
    mc.mCategory as mCategory,
    sc.seq as seqSCategory,
    sc.sCategory as sCategory
from tblLCategory lc
    inner join tblMCategory mc
        on lc.seq = mc.seqLCategory
            inner join tblSCategory sc
                on mc.seq = sc.seqMCategory
order by seqSCategory asc;

--도서 조회 뷰
create or replace view viewBook
as
select
    b.seq as seq,
    b.title as title,
    a.seq as seqAuthor,
    b.publisher as publisher,
    b.pubDate as pubDate,
    b.price as price,
    b.salePrice as salePrice,
    b.copy as copy,
    b.isbn as isbn,
    b.summary as summary,
    b.image as image,
    b.page as page,
    b.contents as contents,
    a.name as author,
    a.intro as authorIntro,
    lc.seq as seqLCategory,
    lc.lCategory as lCategory,
    mc.seq as seqMCategory,
    mc.mCategory as mCategory,
    sc.seq as seqSCategory,
    sc.sCategory as sCategory
from tblBook b
    inner join tblSCategory sc
        on b.seqSCategory = sc.seq
            inner join tblMCategory mc
                on sc.seqMCategory = mc.seq
                    inner join tblLCategory lc
                        on mc.seqLCategory = lc.seq
                            inner join tblAuthor a
                                on b.seqAuthor = a.seq;


--E-Book 조회 뷰
create or replace view viewEBook
as
select
    eb.seq as seq,
    eb.title as title,
    a.seq as seqAuthor,
    eb.publisher as publisher,
    eb.pubDate as pubDate,
    eb.price as price,
    eb.salePrice as salePrice,
    eb.copy as copy,
    eb.isbn as isbn,
    eb.intro as intro,
    eb.image as image,
    eb.eFile as eFile,
    eb.contents as contents,
    a.name as author,
    a.intro as authorIntro,
    lc.seq as seqLCategory,
    lc.lCategory as lCategory,
    mc.seq as seqMCategory,
    mc.mCategory as mCategory,
    sc.seq as seqSCategory,
    sc.sCategory as sCategory
from tblEBook eb
    inner join tblSCategory sc
        on eb.seqSCategory = sc.seq
            inner join tblMCategory mc
                on sc.seqMCategory = mc.seq
                    inner join tblLCategory lc
                        on mc.seqLCategory = lc.seq
                            inner join tblAuthor a
                                on eb.seqAuthor = a.seq;




