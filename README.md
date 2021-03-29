# Springboot Security OAuth2.0

 - 기본 시큐리티 및 구글, 페이스북, 네이버 로그인 연동

## Spring Security란?

 - 스프링 기반의 어플리케이션 보안을 담당하는 프레임워크
 - Spring Security를 사용하면 사용자 인증, 권한, 보안처리를 간단하지만 강력하게 구현 할 수 있다.

### 1. Spring MVC Request Life Cycle

![lifecycle](https://user-images.githubusercontent.com/50781066/112780451-d397f980-9083-11eb-8847-7c87613a7fca.png)

### 2. Filter와 Interceptor는 실행 시점이 다르다.

 - Filter는 WebApplication에 등록 - web.xml
 - Interceptor는 Spring의 Context에 등록

### 3. Interceptor와 Filter의 차이

 - Interceptor는 시큐리티가 나오기전에 인증, 권한을 체크하는 훌륭한 도구로 사용되었다.
 - Interceptor는 AOP를 흉내낼 수 있다. handlerMethod를 제공하기 때문에 메서드의 전후 처리가 가능하다.

### 4. Security

 - Security의 인증 절차는 필터 체인을 거쳐 dispatcherservlet으로 가기전에 적용된다.
 - Security는 필터 체인을 통해서 걸러진 request 요청을 Interceptor를 이용해서 전후 처리할 수 있다.

### 5. Security 인증 절차

 - Security를 통한 로그인은 Authentication 객체의 모험이라고 생각하면 이해하기 쉽다.

![security](https://user-images.githubusercontent.com/50781066/112780475-e0b4e880-9083-11eb-9ce3-7e0667e50f93.png)


## OAuth 2.0 이란?

 - Open Authorization
 - 다양한 플랫폼에서 권한 부여를 위한 산업 표준 프로토콜

 인증 - Authentication : 사용자의 신원을 증명 하는 것
 인가 - Authorization : 특정 리소스에 접근할 수 있는 권한을 부여 하는 것

### 1. OAuth 역할

 - Client : Resource Server의 API를 사용하여 데이터를 가져오려고 하는 사이트ㅐ며소
 - Resource Owner(자원 소유자) : Resource Server의 계정을 소유하고 있는 사용자
 - Authorization Server (권한 서버) : Client가 Resource Server의 서비스를 사용할 수 있게 인증하고 토큰을 발행해주는 서버
 - Resource Server : OAuth2.0 서비스를 제공하고, 자원을 관리하는 서버

### 2. OAuth2.0 인증 흐름도

![oauth](https://user-images.githubusercontent.com/50781066/112781324-8b79d680-9085-11eb-8826-5653a7545720.png)

	A. Client 측에서 Resource Owner에게 인증방식 4가지 중 하나로 승인을 요청한다.
	B. Resource Owner 측에서 Client 측으로 인증 권한을 부여한다.
	C. Client는 부여받은 인증 권한으로 Authorization Server에 엑세스 토큰을 요청한다.
	D. Authorization Server에서 Client와 부여 받은 인증 권한에 대한 유효성을 검사 후 통과하면 엑세스 토큰을 부여한다.
	E. Client는 받아온 엑세스 토큰을 이용하여 Resource Owner의 Resource에 접근을 요청한다.
	F. Resource Server는 해당 엑세스 토큰의 유효성을 검사한 후 통과하면 요청에 대한 Resource를 Client에 넘겨준다.

### 3. OAuth2.0 인증 방식

 - Authorization Code - 코드를 이용한 인증 방식이며 다른 방식에 비해 보안성이 높아 주로 사용되는 방식
 - Implicit - Authorization Code 방식에서 코드를 통해 인증하는 부분을 뺀 방식
 - Resource Owner Password Credentials - Resource Owner에서 아이디 비번을 전달 받아 그걸로 Resource Server에 인증하는 방식 - 신뢰할 수 있는 Client여야지 가능한 방식
 - Client Credentials - Resource Owner가 사용자가 아닌 Client 자체일 때 사용되는 방식
