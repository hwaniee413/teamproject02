1.가입일 1월 17일 이전인 사람들의 구매내역을 출력하세요
select * from MEMBER where RDATE<'2023-01-17';

2.평균 구매금액이 7000원 이상인 사람들의 구매내역을 출력하세요 
select * from ORDERnPAY where 7000>=(select avg(P_AMOUNT) from ORDERnPAY);

3.마일리지가 200점 이상인 사람들의 구매내역을 출력하세요
select * from ORDERnPAY o JOIN MEMBER m ON o.EMAIL= m.EMAIL where m.MILG>=200;

4.가장 많이 팔린 날짜를 출력하세요
select P_DATE, count(P_DATE) from ORDERnPAY group by P_DATE;

5.가장 많이 팔린 상품을 출력하세요
select o.MENU_CODE, m.MENU_NAME, sum(o.P_AMOUNT) from MENU m JOIN ORDERnPAY o ON m.MENU_CODE = o.MENU_CODE group by o.MENU_CODE, m.MENU_NAME order by sum(o.P_AMOUNT) desc;

6.가장 높은 매출을 가진 가맹점과 그 날짜를 출력하세요
select sum(o.P_AMOUNT), f.F_NAME, o.P_DATE from FRANCHISE f JOIN ORDERnPAY o ON f.F_CODE = o.F_CODE group by o.p_date, f.F_name order by sum(o.P_AMOUNT) desc;

7.가장 많은 구매를 한 회원을 출력하세요
select m.NNAME,o.EMAIL from ORDERnPAY o JOIN ORDERnPAY o ON m.EMAIL= o.EMAIL group by NNAME;

8.최근 가입한 회원 1명을 출력하세요
select NNAME, EMAIL, RDATE from (select NNAME, EMAIL, RDATE, ROW_NUMBER() OVER( ORDER BY RDATE DESC) AS rn
from MEMBER) where rn = 1

9.주문한 회원의 마일리지, 상품명, 금액을 출력하시오
select x.MILG,y.P_AMOUNT,z.MENU_NAME from MEMBER x, ORDERnPAY y, MENU z where x.EMAIL = y.EMAIL and y.MENU_CODE = z.MENU_CODE;

10. 01/18 가장 많은 금액을 지불한 사람을 출력하세요 

11. 01/18 대전역점 매장의 판매금액을 출력하세요 

12. 01/18 가장 적게 판매한 가맹점을 출력하세요 

13. 충북점에서 가장 많이 팔린 메뉴명을 출력하세요 
select avg(p_amount) from ordernpay where f_code=33001;

14. 01/18 안양역점에서 네이버페이로 결제한 횟수를 출력하세요 
15. 가디역점의 평균 매출을 출력하세요 

16. 회원 중 '꿀땅콩' 닉네임을 가진 회원의 구매내역을 출력하세요 
17. 평균 매출보다 높은 매출의 가맹점을 출력하세요
18 . 로스트치킨 샌드위치 단품을 주문한 회원을 모두 출력하세요
19. 매출이 가장 높은 가맹점과 가장 적은 가맹점을 출력하세요 

20. '젤리'회원의 구매 평균값을 구하세요
 select avg(menu_cost) from menu natural join member where nname='젤리';
21. '짱구'회원의 구매일자, 메뉴명, 가격 전체를 구하세요 
 select p_datd, menu_name, menu_cost from menu natural join member where nname='짱구';
