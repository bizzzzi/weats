package com.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;

import com.encrypt.SHA256;

/**
 * Servlet implementation class MemberEmailCheckServlet
 */
@WebServlet("/SendMailServlet")
public class SendMailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//6자리 인증번호 생성
		String localhost = "http://localhost:8080/weats/";
		String host = "smtp.gmail.com"; //gmail이면 smtp.gmail.com으로 변경
		String subject="XXX 회원가입 이메일 인증";
		String from = "acornjava@gmail.com"; //보내는 메일
		String fromName = "XXX";
		String to = (String) session.getAttribute("user_email"); //받는 메일
		String code = SHA256.getEncrypt(to, "cos");
		String content = "다음 링크에 접속하여 이메일 인증  "
						+ "<a href='"+localhost+"EmailCheckServlet?code="+code+"'>이메일 인증하기</a>" ;
		
		
		 try{
		     //프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
		     Properties props = new Properties();
		     //네이버 SMTP 사용시
		     props.put("mail.smtp.starttls.enable","true");
		     props.put("mail.transport.protocol","smtp");
		     props.put("mail.smtp.host", host);
		     
		     props.put("mail.smtp.port","465");  // 보내는 메일 포트 설정
		     props.put("mail.smtp.user", from);
		     props.put("mail.smtp.auth","true");
		     props.put("mail.smtp.debug", "true");
		     props.put("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		     props.put("mail.smtp.socketFactory.fallback", "false");


		     Authenticator auth = new FromMail();
		     Session mailSession = Session.getDefaultInstance(props,auth);
		   
		     Message msg = new MimeMessage(mailSession);
		     msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
		     InternetAddress[] address = {new InternetAddress(to)};
		    
		     msg.setRecipients(Message.RecipientType.TO, address); //받는 사람설정
		   
		     msg.setSubject(subject); //제목설정
		     msg.setSentDate(new java.util.Date()); //보내는 날짜 설정
		     msg.setContent(content,"text/html; charset=UTF-8"); //내용 설정(MIME 지정-HTML 형식)
		    
		     Transport.send(msg); //메일 보내기
		     
		     response.sendRedirect("mailCheck.jsp");

		     }catch(MessagingException ex){
		      System.out.println("mail send error : "+ex.getMessage());
		       ex.printStackTrace();
		     }catch(Exception e){
		      PrintWriter out = response.getWriter();
		      out.println("<script>");	 
		      out.println("alert('Error')");	 
		      out.println("history.back()");
		      out.println("</script>");	
		      System.out.println("error : "+e.getMessage());
		       e.printStackTrace();
		     }
		
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
