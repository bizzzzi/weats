

--sequece delete
drop sequence answer_seq;
drop sequence leports_seq;
drop sequence member_seq;
drop sequence partner_seq;
drop sequence question_seq;
drop sequence rs_review_seq;
drop sequence trade_comment_seq;
drop sequence trade_seq;
drop sequence reservation_seq;

--member insert
create sequence member_seq minvalue 1 start with 1 increment by 1;
insert into member values('M'||member_seq.nextval,'������','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
insert into member values('M'||member_seq.nextval,'������','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
insert into member values('M'||member_seq.nextval,'������','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
--partner insert
create sequence partner_seq minvalue 1 start with 1 increment by 1;
insert into partner values('P'||partner_seq.nextval,'M2','�����Ͽ콺','240-175','������ ��籺 �����Ͽ콺','1��','01099720803','123554645-78945321','license_docs');
insert into partner values('P'||partner_seq.nextval,'M4','�����Ͽ콺','240-175','������ ��籺 �����Ͽ콺','1��','01099720803','123554645-78945321','license_docs');
insert into partner values('P'||partner_seq.nextval,'M3','�����Ͽ콺','240-175','������ ��籺 �����Ͽ콺','1��','01099720803','123554645-78945321','license_docs');
--leport insert
create sequence leports_seq minvalue 1 start with 1 increment by 1;
insert into leports values('L'||leports_seq.nextval,'P2','������� ����� �迡 �츮�� �����','�װ�','������',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
insert into leports values('L'||leports_seq.nextval,'P4','������� ����� �迡 �츮�� �����','����','��⵵',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
insert into leports values('L'||leports_seq.nextval,'P6','������� ����� �迡 �츮�� �����','����','����',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
insert into leports values('L'||leports_seq.nextval,'P2','������� ����� �迡 �츮�� �����','�ǳ�','��õ',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
insert into leports values('L'||leports_seq.nextval,'P4','������� ����� �迡 �츮�� �����','��Ÿ','�λ�',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
insert into leports values('L'||leports_seq.nextval,'P4','������� ����� �迡 �츮�� �����','����','���',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','�ȳ��ϼ���, ����� �̹��� ������ ��� �����Ͽ콺�Դϴ�. ');
--leport item insert
insert into leports_item values('L22','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L23','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L24','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L22','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L24','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L23','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
insert into leports_item values('L24','���� ����(2�ð�)','���� 9��~���� 2�� �� �������� ����',50000,10);
--reservation insert
create sequence reservation_seq minvalue 1 start with 1 increment by 1;
insert into reservation values('RS'||reservation_seq.nextval,'M2','L22','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M3','L23','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M3','L24','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M2','L23','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L23','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L22','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L22','������ģ��','01012345748','10','�ſ�ī��','2017/15/11',sysdate,80000);
--reservation_review insert
create sequence rs_review_seq minvalue 1 start with 1 increment by 1;
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS3','M2','�������� ������, ����� �ʹ� ���ƿ�',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS4','M2','�������� ������, ����� �ʹ� ���ƿ�',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L23','RS5','M3','�������� ������, ����� �ʹ� ���ƿ�',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS6','M3','�������� ������, ����� �ʹ� ���ƿ�',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS7','M4','�������� ������, ����� �ʹ� ���ƿ�',sysdate);
--trade insert
create sequence trade_seq minvalue 1 start with 1 increment by 1;
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','�ѹ� ����� ����� ���� �Ⱦƿ�','���ϰ� ���డ���� �Ź��� �ΰ�Դ� ���࿡�� �� �ѹ� ����߽��ϴ�.','�Ǹ�','����','īī��ID: acorn','������','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M3','mainimg','subimg1','subimg2','subimg3','subimg4','�ѹ� ����� ����� ���� �Ⱦƿ�','���ϰ� ���డ���� �Ź��� �ΰ�Դ� ���࿡�� �� �ѹ� ����߽��ϴ�.','�Ǹ�','����','īī��ID: acorn','������','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M4','mainimg','subimg1','subimg2','subimg3','subimg4','�ѹ� ����� ����� ���� �Ⱦƿ�','���ϰ� ���డ���� �Ź��� �ΰ�Դ� ���࿡�� �� �ѹ� ����߽��ϴ�.','�Ǹ�','����','īī��ID: acorn','������','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','�ѹ� ����� ����� ���� �Ⱦƿ�','���ϰ� ���డ���� �Ź��� �ΰ�Դ� ���࿡�� �� �ѹ� ����߽��ϴ�.','�Ǹ�','����','īī��ID: acorn','������','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','�ѹ� ����� ����� ���� �Ⱦƿ�','���ϰ� ���డ���� �Ź��� �ΰ�Դ� ���࿡�� �� �ѹ� ����߽��ϴ�.','�Ǹ�','����','īī��ID: acorn','������','20000',sysdate,1);
--trade_comments insert
create sequence trade_comment_seq minvalue 1 start with 1 increment by 1;
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T2','M2','�� �� ������',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M3','�� �� ������',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T4','M2','�� �� ������',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M4','�� �� ������',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M2','�� �� ������',sysdate);
--trade_recomments insert
create sequence trade_recomment_seq minvalue 1 start with 1 increment by 1;
insert into trade_recomments values('REC'||trade_recomment_seq.nextval, 'TC2','M5','고객님, 죄송합니다.서프하우스가 망했습니다.',1,sysdate);
--customer_question insert
create sequence question_seq minvalue 1 start with 1 increment by 1;
insert into customer_question values('Q'||question_seq.nextval, 'M3','������ �ƴµ� �̸����� �ȿͿ�','����','�����ϸ� �̸����� �߼۵ȴ��ߴµ� ������ ���޾ҽ��ϴ�. ���� ����� �� �� �³���?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M2','������ �ƴµ� �̸����� �ȿͿ�','����','�����ϸ� �̸����� �߼۵ȴ��ߴµ� ������ ���޾ҽ��ϴ�. ���� ����� �� �� �³���?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','������ �ƴµ� �̸����� �ȿͿ�','����','�����ϸ� �̸����� �߼۵ȴ��ߴµ� ������ ���޾ҽ��ϴ�. ���� ����� �� �� �³���?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','������ �ƴµ� �̸����� �ȿͿ�','����','�����ϸ� �̸����� �߼۵ȴ��ߴµ� ������ ���޾ҽ��ϴ�. ���� ����� �� �� �³���?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','������ �ƴµ� �̸����� �ȿͿ�','����','�����ϸ� �̸����� �߼۵ȴ��ߴµ� ������ ���޾ҽ��ϴ�. ���� ����� �� �� �³���?',null,'01099720803',sysdate);
--customer_answer insert
create sequence answer_seq minvalue 1 start with 1 increment by 1;
insert into customer_answer values('A'||answer_seq.nextval, 'Q10','����, �˼��մϴ�.    �����Ͽ콺�� ���߽��ϴ�.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q11','����, �˼��մϴ�.    �����Ͽ콺�� ���߽��ϴ�.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q12','����, �˼��մϴ�.    �����Ͽ콺�� ���߽��ϴ�.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q13','����, �˼��մϴ�.    �����Ͽ콺�� ���߽��ϴ�.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q14','����, �˼��մϴ�.    �����Ͽ콺�� ���߽��ϴ�.',sysdate);

commit;