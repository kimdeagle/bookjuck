-- 회원 리스트 View
CREATE OR REPLACE VIEW vwCustMng
    AS
SELECT 
        rownum as rnum,
        mb.seq as seq,
        mb.id as id,
        mb.pw as pw,
        mb.tel as tel,
        mb.address as address,
        mb.ssn as ssn,
        mb.email as email,
        mb.points as points,
        mb.privacy as privacy,
        mb.name as name,
        to_char(mb.regdate, 'YYYY-MM-DD') as regdate,
        to_char(mb.lastdate, 'YYYY-MM-DD') as lastdate,
        mb.login as login,
        case
            when lcr.seqmember is null then '비구독' else '구독' 
        end as curation
        
        FROM tblMember mb
            LEFT JOIN tblLetterRecipient lcr
            ON mb.seq = lcr.seqmember
                LEFT JOIN tblghostmember gst
                ON mb.seq = gst.seqmember
                    WHERE gst.state is null;
    
                    
                    
-- 휴면 리스트   View
CREATE OR REPLACE VIEW vwDormency    
    AS
SELECT
        rownum as rnum,
        mb.seq as seq,
        mb.id as id,
        mb.pw as pw,
        mb.tel as tel,
        mb.address as address,
        mb.ssn as ssn,
        mb.email as email,
        mb.points as points,
        mb.privacy as privacy,
        mb.name as name,
        to_char(mb.regdate, 'YYYY-MM-DD') as regdate, -- 회원가입일
        to_char(mb.lastdate, 'YYYY-MM-DD') as lastDate, --최종 접속일
        mb.login as login,
        TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(gst.regdate) as regdate_d, -- 휴면 경과일 
        gst.regdate as trsdate, --휴면 등록일
        case
            when lcr.seqmember is null then '비구독' else '구독' 
        end as curation
FROM tblGhostMember gst
    INNER JOIN tblMember mb
    ON gst.seqmember = mb.seq
        LEFT JOIN tblLetterRecipient lcr
        ON mb.seq = lcr.seqmember;
    