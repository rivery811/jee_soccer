-- SQL_TEST_001
-- ��ü �౸�� ���. �̸� ��������
SELECT TEAM_NAME "��ü �౸�� ���"
FROM TEAM
ORDER BY TEAM_NAME
;
-- SQL_TEST_002
-- ������ ����(�ߺ�����,������ �����)
SELECT DISTINCT POSITION
FROM PLAYER
ORDER BY POSITION
;

-- SQL_TEST_003
-- ������ ����(�ߺ�����,������ �������� ����)
-- nvl2()���
SELECT DISTINCT (NVL2(POSITION ,POSITION,'����') )
FROM PLAYER
;

-- SQL_TEST_004
-- ������(ID: K02)��Ű��
SELECT *
FROM (SELECT PLAYER_NAME �̸� FROM PLAYER 
        WHERE TEAM_ID LIKE 'K02'
            AND POSITION LIKE 'GK'
            ORDER BY PLAYER_NAME);


-- SQL_TEST_005
-- ������(ID: K02)Ű�� 170 �̻� ����
-- �̸鼭 ���� ���� ����
SELECT P.POSITION ������, P.PLAYER_NAME �̸�
FROM (PLAYER) P
WHERE P.TEAM_ID LIKE 'K02'
    AND P.HEIGHT >= 170
    AND P.PLAYER_NAME LIKE '��%'
;
SELECT *
FROM (SELECT POSITION,PLAYER_NAME FROM PLAYER WHERE TEAM_ID LIKE 'K02'
    AND HEIGHT >= 170
    AND PLAYER_NAME LIKE '��%') P

;
-- SQL_TEST_006
-- ������(ID: K02) ������ �̸�,
-- Ű�� ������ ����Ʈ (���� cm �� kg ����)
-- Ű�� �����԰� ������ "0" ǥ��
-- Ű ��������
SELECT P.*,
    CONCAT((CASE WHEN P.HEIGHT IS NULL
        THEN 0
        ELSE P.HEIGHT
        END   ),'CM' )Ű,
    CONCAT((CASE WHEN P.WEIGHT IS NULL
        THEN 0
        ELSE P.WEIGHT 
        END),'KG' ) ������
FROM (SELECT PLAYER_NAME,HEIGHT,WEIGHT FROM PLAYER WHERE TEAM_ID LIKE 'K02') P

ORDER BY P.HEIGHT DESC
;

-- SQL_TEST_007
-- ������(ID: K02) ������ �̸�,
-- Ű�� ������ ����Ʈ (���� cm �� kg ����)
-- Ű�� �����԰� ������ "0" ǥ��
-- BMI���� 
-- Ű ��������
SELECT P.PLAYER_NAME �̸�, 
    CONCAT((CASE WHEN P.HEIGHT IS NULL
        THEN 0
        ELSE P.HEIGHT
        END   ),'CM') Ű,
    CONCAT((CASE WHEN P.WEIGHT IS NULL
        THEN 0
        ELSE P.WEIGHT 
        END),'KG')  ������,
    P.WEIGHT/((P.HEIGHT/100)*(P.HEIGHT/100)) BMI
    
FROM (SELECT PLAYER_NAME, HEIGHT , WEIGHT FROM PLAYER WHERE TEAM_ID LIKE 'K02') P

ORDER BY P.HEIGHT DESC
;

-- SQL_TEST_008
-- ������(ID: K02) �� ������(ID: K10)������ �� 
--  �������� GK ��  ����
-- ����, ����� ��������

SELECT T.TEAM_NAME ����, P.PLAYER_NAME ������
FROM (SELECT PLAYER_NAME, TEAM_ID FROM PLAYER 
       WHERE TEAM_ID IN('K02','K10')
         AND POSITION LIKE 'GK') P JOIN TEAM T
                USING(TEAM_ID)

ORDER BY 1,2
;

-- SQL_TEST_009
-- ������(ID: K02) �� ������(ID: K10)������ �� ��
-- Ű�� 180 �̻� 183 ������ ������
-- Ű, ����, ����� ��������

SELECT P.HEIGHT Ű, T.TEAM_NAME ����, P.PLAYER_NAME ������
FROM (SELECT HEIGHT, PLAYER_NAME, TEAM_ID FROM PLAYER
        WHERE TEAM_ID IN('K02','K10')
            AND HEIGHT>=180
            AND 183 >= HEIGHT) P 
                JOIN (SELECT TEAM_NAME,TEAM_ID FROM TEAM) T
                    ON P.TEAM_ID LIKE T.TEAM_ID

ORDER BY 1,2,3
;

-- SOCCER_SQL_010
-- ��� ������ ��
-- �������� �������� ���� �������� ���� �̸�
-- ����, ����� ��������

SELECT T.TEAM_NAME ����, P.PLAYER_NAME ������
FROM PLAYER P JOIN TEAM T
  USING(TEAM_ID)
WHERE P.POSITION IS NULL
ORDER BY 1,2
;

-- SOCCER_SQL_011
-- ���� ��Ÿ����� �����Ͽ�
-- ���̸�, ��Ÿ��� �̸� ���
SELECT T.TEAM_NAME ����, S.STADIUM_NAME ��Ÿ����
FROM TEAM T JOIN STADIUM S
    ON T.STADIUM_ID LIKE S.STADIUM_ID
;

-- SOCCER_SQL_012
-- ���� ��Ÿ���, �������� �����Ͽ�
-- 2012�� 3�� 17�Ͽ� ���� �� ����� 
-- ���̸�, ��Ÿ���, ������� �̸� ���
-- �������̺� join �� ã�Ƽ� �ذ��Ͻÿ�.
SELECT 
    CASE WHEN K.HOMETEAM_ID LIKE T.TEAM_ID
        THEN T.TEAM_NAME
        END ����, 
        S.STADIUM_NAME ��Ÿ���� ,  K.AWAYTEAM_ID �������,
        K.SCHE_DATE ������
       
FROM TEAM T JOIN STADIUM S
    ON T.STADIUM_ID LIKE S.STADIUM_ID
    JOIN SCHEDULE K
    ON S.STADIUM_ID = K.STADIUM_ID
WHERE K.SCHE_DATE LIKE 20120317

;

-- SOCCER_SQL_013
-- 2012�� 3�� 17�� ��⿡ 
-- ���� ��ƿ���� �Ҽ� ��Ű��(GK)
-- ����, ������,���� (����������), 
-- ��Ÿ���, ��⳯¥�� ���Ͻÿ�
-- �������� ���̸��� ������ ���ÿ�
SELECT P.PLAYER_NAME ������, P.POSITION ������, CONCAT(T.REGION_NAME||' ' , T.TEAM_NAME) ����, S.STADIUM_NAME ��Ÿ���, K.SCHE_DATE ������
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
    JOIN STADIUM S
    ON T.STADIUM_ID LIKE S.STADIUM_ID
    JOIN SCHEDULE K
    ON S.STADIUM_ID = K.STADIUM_ID
WHERE K.SCHE_DATE LIKE 20120317 
    AND T.TEAM_NAME LIKE '��ƿ����'
    AND P.POSITION LIKE 'GK'
;

-- SOCCER_SQL_014
-- Ȩ���� 3���̻� ���̷� �¸��� ����� 
-- ����� �̸�, ��� ����
-- Ȩ�� �̸��� ������ �̸���
-- ���Ͻÿ�

SELECT S.STADIUM_NAME �����, K.SCHE_DATE ��⳯¥, 
    CASE WHEN K.HOMETEAM_ID LIKE T.TEAM_ID
        THEN T.TEAM_NAME
        END ����,
        (SELECT T.TEAM_NAME FROM TEAM T  WHERE K.AWAYTEAM_ID LIKE T.TEAM_ID) ����� 
 
FROM (SELECT * FROM SCHEDULE WHERE HOME_SCORE- AWAY_SCORE>=3)K JOIN STADIUM S
    ON K.STADIUM_ID LIKE S.STADIUM_ID
    JOIN TEAM T
    ON T.STADIUM_ID LIKE S.STADIUM_ID
;

-- SOCCER_SQL_015
-- STADIUM �� ��ϵ� ��� �߿���
-- Ȩ���� ���� �������� ���� ��������
-- ī��Ʈ ���� 20
SELECT S.STADIUM_NAME, S.STADIUM_ID, S.SEAT_COUNT, S.HOMETEAM_ID, T.E_TEAM_NAME
FROM STADIUM S LEFT JOIN TEAM T
     ON S.STADIUM_ID LIKE T.STADIUM_ID
;

SELECT STADIUM_ID, S.STADIUM_NAME, T.E_TEAM_NAME
FROM STADIUM S  LEFT JOIN TEAM T
     USING(STADIUM_ID)
;

-- SOCCER_SQL_016
-- ���Ű�� ��õ ������Ƽ������ ���Ű ���� ���� ���� 
-- ��ID, ����, ���Ű ����
SELECT T.TEAM_ID �����̵�, T.TEAM_NAME ����, ROUND(AVG(P.HEIGHT),2)���Ű
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
 GROUP BY T.TEAM_ID, T.TEAM_NAME
 HAVING AVG(P.HEIGHT)<(SELECT AVG(P1.HEIGHT)
                        FROM PLAYER P1 JOIN TEAM T1
                        ON P1.TEAM_ID LIKE T1.TEAM_ID
                        WHERE T1.TEAM_NAME LIKE '������Ƽ��')
ORDER BY 3,1,2
 ;
 
-- SOCCER_SQL_017
-- �������� MF �� ��������  �Ҽ����� �� ������, ��ѹ� ���
SELECT T.TEAM_NAME ����, P.PLAYER_NAME ������, P.BACK_NO ��ѹ�
FROM (SELECT * FROM PLAYER WHERE POSITION LIKE 'MF')JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID

;

-- SOCCER_SQL_018
-- ���� Űū ���� 5 ����, ����Ŭ, �� Ű ���� ������ ����
SELECT A.PLAYER_NAME ������ 
FROM (SELECT P.* FROM PLAYER P WHERE HEIGHT IS NOT NULL ORDER BY P.HEIGHT DESC)A
WHERE ROWNUM<=5
;

-- SOCCER_SQL_019
-- ���� �ڽ��� ���� ���� ���Ű���� ���� ���� ���� ���

SELECT P.*
FROM PLAYER P
WHERE P.HEIGHT <(SELECT AVG(P1.HEIGHT) FROM PLAYER P1 GROUP BY P1.TEAM_ID HAVING P.TEAM_ID LIKE P1.TEAM_ID)
    AND P.HEIGHT IS NOT NULL
ORDER BY P.PLAYER_NAME
;
SELECT P.*
FROM PLAYER P
WHERE P.HEIGHT <(SELECT AVG(P1.HEIGHT) FROM PLAYER P1 
                    WHERE P1.TEAM_ID LIKE P.TEAM_ID 
                    AND P.HEIGHT IS NOT NULL
                    GROUP BY P1.TEAM_ID)
                        
ORDER BY P.PLAYER_NAME
;

-- SOCCER_SQL_020
-- 2012�� 5�� �Ѵް� ��Ⱑ �ִ� ����� ��ȸ
-- EXISTS ������ �׻� ���������� ����Ѵ�.
-- ���� �ƹ��� ������ �����ϴ� ���� ���� ���̶�
-- ������ �����ϴ� 1�Ǹ� ã���� �߰����� �˻��� �������� �ʴ´�
SELECT DISTINCT S.STADIUM_NAME
FROM STADIUM S JOIN SCHEDULE K
    ON S.STADIUM_ID LIKE K.STADIUM_ID
WHERE EXISTS(SELECT * FROM SCHEDULE  WHERE K.SCHE_DATE BETWEEN 20120501 AND 20120530)
;


-- SOCCER_SQL_021
-- ���� ���� �Ҽ����� ������� ���
SELECT P.*
FROM PLAYER P
WHERE P.TEAM_ID LIKE (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME LIKE '����')
;
SELECT *
FROM (SELECT * 
        FROM PLAYER
        WHERE TEAM_ID LIKE (SELECT TEAM_ID FROM PLAYER WHERE PLAYER_NAME LIKE '����'))
;

-- SOCCER_SQL_022
-- NULL ó���� �־�
-- SUM(NVL(SAL,0)) �� ��������
-- NVL(SUM(SAL),0) ���� �ؾ� �ڿ����� �پ���
 
-- ���� �����Ǻ� �ο����� ���� ��ü �ο��� ���
 
-- Oracle, Simple Case Expr 

SELECT P.TEAM_ID �����̵�,
    NVL(SUM(CASE WHEN POSITION LIKE 'FW' THEN 1 ELSE 0 END),0) FW,
    NVL(SUM(CASE WHEN POSITION LIKE 'MF' THEN 1 ELSE 0 END),0) MF,
    NVL(SUM(CASE WHEN POSITION LIKE 'DF' THEN 1 ELSE 0 END),0) DF,
    NVL(SUM(CASE WHEN POSITION LIKE 'GK' THEN 1 ELSE 0 END),0) GK,
    COUNT(*)
FROM PLAYER P
GROUP BY P.TEAM_ID
;

-- SOCCER_SQL_023
-- GROUP BY �� ���� ��ü �������� �����Ǻ� ��� Ű �� ��ü ��� Ű ���
SELECT DISTINCT(SELECT AVG(HEIGHT) FROM PLAYER WHERE POSITION LIKE 'FW') ������,
    (SELECT AVG(HEIGHT) FROM PLAYER WHERE POSITION LIKE 'MF') �̵��ʴ�,
    (SELECT AVG(HEIGHT) FROM PLAYER WHERE POSITION LIKE 'DF') �����,
    (SELECT AVG(HEIGHT) FROM PLAYER WHERE POSITION LIKE 'GK') ��Ű��,
    (SELECT AVG(HEIGHT) FROM PLAYER ) ��ü���
FROM PLAYER
;

-- SOCCER_SQL_024 
-- �Ҽ����� Ű�� ���� ���� ������� ����

SELECT T.TEAM_ID �����̵�, T.TEAM_NAME ����, P.PLAYER_NAME ������, P.POSITION ������, P.BACK_NO ��ѹ�, P.HEIGHT Ű
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE (P.TEAM_ID, P.HEIGHT) IN(SELECT TEAM_ID, MIN(HEIGHT) FROM PLAYER GROUP BY TEAM_ID)

ORDER BY 1
;




SELECT TEAM_ID �����̵�,TEAM_NAME ����, PLAYER_NAME ������,POSITION ������, BACK_NO ��ѹ�, HEIGHT Ű
FROM (SELECT TEAM_ID, POSITION, BACK_NO, HEIGHT, PLAYER_NAME
        FROM PLAYER 
            WHERE HEIGHT IN (SELECT MIN(HEIGHT) FROM PLAYER GROUP BY TEAM_ID)
            GROUP BY TEAM_ID,POSITION,BACK_NO,HEIGHT,PLAYER_NAME)  
                JOIN TEAM 
                    USING (TEAM_ID)

ORDER BY 1
;


SELECT MIN(HEIGHT) FROM PLAYER GROUP BY TEAM_ID;
SELECT TEAM_ID,POSITION,BACK_NO,HEIGHT
        FROM PLAYER 
            WHERE HEIGHT IN (SELECT MIN(HEIGHT) FROM PLAYER GROUP BY TEAM_ID)
            GROUP BY TEAM_ID,POSITION,BACK_NO,HEIGHT
            ORDER BY 1;

-- SOCCER_SQL_025 
-- K-���� 2012�� 8�� ������� �� ������ �������� ABS �Լ��� ����Ͽ�
-- ���밪���� ����ϱ�



SELECT K.SCHE_DATE,
      CONCAT(CONCAT((SELECT TEAM_NAME 
                FROM TEAM 
                WHERE TEAM_ID LIKE K.HOMETEAM_ID),'-')
                ,(SELECT TEAM_NAME 
                FROM TEAM
                WHERE TEAM_ID LIKE K.AWAYTEAM_ID)) ��,
                CONCAT(CONCAT(K.HOME_SCORE,':'),K.AWAY_SCORE) ����    
     ,ABS(K.HOME_SCORE-K.AWAY_SCORE) ������
    
FROM (SELECT K1.* FROM SCHEDULE K1 WHERE K1.SCHE_DATE BETWEEN 20120801 AND 20120831) K 

ORDER BY 1
;

-- SOCCER_SQL_026 
-- 20120501 ���� 20120602 ���̿� ��Ⱑ �ִ� ����� ��ȸ
SELECT  K.STADIUM_ID ��Ÿ����ڵ�, S.STADIUM_NAME ������
FROM (SELECT STADIUM_ID FROM SCHEDULE WHERE SCHE_DATE BETWEEN 20120501 AND 20120602) K 
    JOIN (SELECT STADIUM_ID, STADIUM_NAME FROM STADIUM )S
    ON K.STADIUM_ID = S.STADIUM_ID
;
SELECT  STADIUM_ID ��Ÿ����ڵ�, STADIUM_NAME ������
FROM (SELECT STADIUM_ID FROM SCHEDULE WHERE SCHE_DATE BETWEEN 20120501 AND 20120602) 
    JOIN (SELECT STADIUM_ID, STADIUM_NAME FROM STADIUM )
    USING(STADIUM_ID)
;
-- SOCCER_SQL_027 
-- ���������� �ش� ������ ����  ���� ���Ű ��ȸ
-- ��, ���Ľ� ���Ű ��������

SELECT T.TEAM_NAME ����, P.PLAYER_NAME ������, P.HEIGHT Ű
        , (SELECT AVG(P1.HEIGHT)FROM PLAYER P1 WHERE P1.TEAM_ID LIKE T.TEAM_ID) ���Ű
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
ORDER BY 4 DESC
;

-- SOCCER_SQL_028 
-- ���Ű�� �Ｚ ������� ���� ���Ű���� ���� ���� 
-- �̸��� �ش� ���� ���Ű

SELECT T.TEAM_ID �����̵�, T.TEAM_NAME ����, AVG(P.HEIGHT) ���Ű
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
GROUP BY T.TEAM_ID, T.TEAM_NAME
HAVING AVG(P.HEIGHT)<(SELECT AVG(P1.HEIGHT) FROM PLAYER P1 JOIN TEAM T1 ON P1.TEAM_ID = T1.TEAM_ID
                        WHERE T1.TEAM_NAME LIKE '�Ｚ�������')
;

-- SOCCER_SQL_029 
-- �巡����,FC����,��ȭõ�� ������ �� �Ҽ��� GK, MF ���� ����
SELECT T.TEAM_NAME �Ҽ���, P.POSITION ������, P.BACK_NO ��ѹ�, P.PLAYER_NAME ������, P.HEIGHT Ű
FROM PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE T.TEAM_NAME IN ('�巡����','FC����','��ȭõ��')
    AND P.POSITION IN ('GK','MF')
ORDER BY 1,2
;

-- SOCCER_SQL_030 
-- 29������ ������ ���� �������� �ƴ� �������� ��

SELECT COUNT(P.PLAYER_ID)
FROM  PLAYER P JOIN TEAM T
    ON P.TEAM_ID LIKE T.TEAM_ID
WHERE T.TEAM_NAME NOT IN ('�巡����','FC����','��ȭõ��')
    AND P.POSITION NOT IN ('GK','MF')
;
