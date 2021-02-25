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
    orgimage
from tblUsedBoard;
-- ########### 중고게시판 뷰

