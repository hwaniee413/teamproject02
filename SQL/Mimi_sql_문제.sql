1.������ 1�� 17�� ������ ������� ���ų����� ����ϼ���
select * from MEMBER where RDATE<'2023-01-17';

2.��� ���űݾ��� 7000�� �̻��� ������� ���ų����� ����ϼ��� 
select * from ORDERnPAY where 7000>=(select avg(P_AMOUNT) from ORDERnPAY);

3.���ϸ����� 200�� �̻��� ������� ���ų����� ����ϼ���
select * from ORDERnPAY o JOIN MEMBER m ON o.EMAIL= m.EMAIL where m.MILG>=200;

4.���� ���� �ȸ� ��¥�� ����ϼ���
select P_DATE, count(P_DATE) from ORDERnPAY group by P_DATE;

5.���� ���� �ȸ� ��ǰ�� ����ϼ���
select o.MENU_CODE, m.MENU_NAME, sum(o.P_AMOUNT) from MENU m JOIN ORDERnPAY o ON m.MENU_CODE = o.MENU_CODE group by o.MENU_CODE, m.MENU_NAME order by sum(o.P_AMOUNT) desc;

6.���� ���� ������ ���� �������� �� ��¥�� ����ϼ���
select sum(o.P_AMOUNT), f.F_NAME, o.P_DATE from FRANCHISE f JOIN ORDERnPAY o ON f.F_CODE = o.F_CODE group by o.p_date, f.F_name order by sum(o.P_AMOUNT) desc;

7.���� ���� ���Ÿ� �� ȸ���� ����ϼ���
select m.NNAME,o.EMAIL from ORDERnPAY o JOIN ORDERnPAY o ON m.EMAIL= o.EMAIL group by NNAME;

8.�ֱ� ������ ȸ�� 1���� ����ϼ���
select NNAME, EMAIL, RDATE from (select NNAME, EMAIL, RDATE, ROW_NUMBER() OVER( ORDER BY RDATE DESC) AS rn
from MEMBER) where rn = 1

9.�ֹ��� ȸ���� ���ϸ���, ��ǰ��, �ݾ��� ����Ͻÿ�
select x.MILG,y.P_AMOUNT,z.MENU_NAME from MEMBER x, ORDERnPAY y, MENU z where x.EMAIL = y.EMAIL and y.MENU_CODE = z.MENU_CODE;

10. 01/18 ���� ���� �ݾ��� ������ ����� ����ϼ��� 

11. 01/18 �������� ������ �Ǹűݾ��� ����ϼ��� 

12. 01/18 ���� ���� �Ǹ��� �������� ����ϼ��� 

13. ��������� ���� ���� �ȸ� �޴����� ����ϼ��� 
select avg(p_amount) from ordernpay where f_code=33001;

14. 01/18 �Ⱦ翪������ ���̹����̷� ������ Ƚ���� ����ϼ��� 
15. �������� ��� ������ ����ϼ��� 

16. ȸ�� �� '�ܶ���' �г����� ���� ȸ���� ���ų����� ����ϼ��� 
17. ��� ���⺸�� ���� ������ �������� ����ϼ���
18 . �ν�ƮġŲ ������ġ ��ǰ�� �ֹ��� ȸ���� ��� ����ϼ���
19. ������ ���� ���� �������� ���� ���� �������� ����ϼ��� 

20. '����'ȸ���� ���� ��հ��� ���ϼ���
 select avg(menu_cost) from menu natural join member where nname='����';
21. '¯��'ȸ���� ��������, �޴���, ���� ��ü�� ���ϼ��� 
 select p_datd, menu_name, menu_cost from menu natural join member where nname='¯��';
