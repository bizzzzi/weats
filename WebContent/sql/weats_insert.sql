

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
insert into member values('M'||member_seq.nextval,'김혜빈','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
insert into member values('M'||member_seq.nextval,'김혜빈','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
insert into member values('M'||member_seq.nextval,'김혜빈','acornjava@gmail.com','javaacorn','dafkje;jkfaef',1,1);
--partner insert
create sequence partner_seq minvalue 1 start with 1 increment by 1;
insert into partner values('P'||partner_seq.nextval,'M2','서프하우스','240-175','강원도 양양군 서프하우스','1층','01099720803','123554645-78945321','license_docs');
insert into partner values('P'||partner_seq.nextval,'M4','서프하우스','240-175','강원도 양양군 서프하우스','1층','01099720803','123554645-78945321','license_docs');
insert into partner values('P'||partner_seq.nextval,'M3','서프하우스','240-175','강원도 양양군 서프하우스','1층','01099720803','123554645-78945321','license_docs');
--leport insert
create sequence leports_seq minvalue 1 start with 1 increment by 1;
insert into leports values('L'||leports_seq.nextval,'P2','양양으로 여행온 김에 우리도 들려ㅋ','항공','강원도',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
insert into leports values('L'||leports_seq.nextval,'P4','양양으로 여행온 김에 우리도 들려ㅋ','수상','경기도',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
insert into leports values('L'||leports_seq.nextval,'P6','양양으로 여행온 김에 우리도 들려ㅋ','지상','서울',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
insert into leports values('L'||leports_seq.nextval,'P2','양양으로 여행온 김에 우리도 들려ㅋ','실내','인천',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
insert into leports values('L'||leports_seq.nextval,'P4','양양으로 여행온 김에 우리도 들려ㅋ','기타','부산',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
insert into leports values('L'||leports_seq.nextval,'P4','양양으로 여행온 김에 우리도 들려ㅋ','지상','경기',sysdate,'mainimg','subimg','subimg2','subimg3','subimg4','안녕하세요, 저희는 이번에 오픈한 양양 서프하우스입니다. ');
--leport item insert
insert into leports_item values('L22','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L23','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L24','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L22','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L24','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L23','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
insert into leports_item values('L24','서핑 강습(2시간)','주중 9시~오후 2시 매 정각마다 강습',50000,10);
--reservation insert
create sequence reservation_seq minvalue 1 start with 1 increment by 1;
insert into reservation values('RS'||reservation_seq.nextval,'M2','L22','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M3','L23','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M3','L24','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M2','L23','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L23','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L22','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
insert into reservation values('RS'||reservation_seq.nextval,'M4','L22','김혜빈친구','01012345748','10','신용카드','2017/15/11',sysdate,80000);
--reservation_review insert
create sequence rs_review_seq minvalue 1 start with 1 increment by 1;
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS3','M2','생각보다 별로임, 사람이 너무 많아요',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS4','M2','생각보다 별로임, 사람이 너무 많아요',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L23','RS5','M3','생각보다 별로임, 사람이 너무 많아요',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS6','M3','생각보다 별로임, 사람이 너무 많아요',sysdate);
insert into reservation_review values('RS_R'||rs_review_seq.nextval,'L22','RS7','M4','생각보다 별로임, 사람이 너무 많아요',sysdate);
--trade insert
create sequence trade_seq minvalue 1 start with 1 increment by 1;
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','한번 사용한 아쿠아 슈즈 팔아요','급하게 여행가느라 신발을 두고왔던 여행에서 딱 한번 사용했습니다.','판매','강남','카카오ID: acorn','김혜빈','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M3','mainimg','subimg1','subimg2','subimg3','subimg4','한번 사용한 아쿠아 슈즈 팔아요','급하게 여행가느라 신발을 두고왔던 여행에서 딱 한번 사용했습니다.','판매','강남','카카오ID: acorn','김혜빈','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M4','mainimg','subimg1','subimg2','subimg3','subimg4','한번 사용한 아쿠아 슈즈 팔아요','급하게 여행가느라 신발을 두고왔던 여행에서 딱 한번 사용했습니다.','판매','강남','카카오ID: acorn','김혜빈','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','한번 사용한 아쿠아 슈즈 팔아요','급하게 여행가느라 신발을 두고왔던 여행에서 딱 한번 사용했습니다.','판매','강남','카카오ID: acorn','김혜빈','20000',sysdate,1);
insert into trade values('T'||trade_seq.nextval,'M2','mainimg','subimg1','subimg2','subimg3','subimg4','한번 사용한 아쿠아 슈즈 팔아요','급하게 여행가느라 신발을 두고왔던 여행에서 딱 한번 사용했습니다.','판매','강남','카카오ID: acorn','김혜빈','20000',sysdate,1);
--trade_comments insert
create sequence trade_comment_seq minvalue 1 start with 1 increment by 1;
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T2','M2','이 분 사기꾼임',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M3','이 분 사기꾼임',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T4','M2','이 분 사기꾼임',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M4','이 분 사기꾼임',sysdate);
insert into trade_comments values('TC'||trade_comment_seq.nextval,'T3','M2','이 분 사기꾼임',sysdate);
--customer_question insert
create sequence question_seq minvalue 1 start with 1 increment by 1;
insert into customer_question values('Q'||question_seq.nextval, 'M3','결제는 됐는데 이메일이 안와요','결제','결제하면 이메일이 발송된다했는데 아직도 못받았습니다. 결제 제대로 된 것 맞나요?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M2','결제는 됐는데 이메일이 안와요','결제','결제하면 이메일이 발송된다했는데 아직도 못받았습니다. 결제 제대로 된 것 맞나요?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','결제는 됐는데 이메일이 안와요','결제','결제하면 이메일이 발송된다했는데 아직도 못받았습니다. 결제 제대로 된 것 맞나요?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','결제는 됐는데 이메일이 안와요','결제','결제하면 이메일이 발송된다했는데 아직도 못받았습니다. 결제 제대로 된 것 맞나요?',null,'01099720803',sysdate);
insert into customer_question values('Q'||question_seq.nextval, 'M4','결제는 됐는데 이메일이 안와요','결제','결제하면 이메일이 발송된다했는데 아직도 못받았습니다. 결제 제대로 된 것 맞나요?',null,'01099720803',sysdate);
--customer_answer insert
create sequence answer_seq minvalue 1 start with 1 increment by 1;
insert into customer_answer values('A'||answer_seq.nextval, 'Q10','고객님, 죄송합니다.    서프하우스가 망했습니다.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q11','고객님, 죄송합니다.    서프하우스가 망했습니다.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q12','고객님, 죄송합니다.    서프하우스가 망했습니다.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q13','고객님, 죄송합니다.    서프하우스가 망했습니다.',sysdate);
insert into customer_answer values('A'||answer_seq.nextval, 'Q14','고객님, 죄송합니다.    서프하우스가 망했습니다.',sysdate);
commit;