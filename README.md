# nhn_preproject
nhn엔터테인먼트 사전과제 - 박제현

개발 환경
클라이언트 : jQuery
서버 : JAVA 8, SpringMVC, Tomcat 8.0.36, JSP, MyBatis
데이터베이스 : MySql

구현 스펙
간단한 방명록형태의 웹사이트를 제작

1. Email, 비밀번호, 본문을 입력
2. 작성한 글 등록시에 현재 시각도 기록
3. DB에 있는 내용을 최신 내용이 상위에 오도록 페이징 없이 출력
4. 비밀번호 입력으로 글 수정 및 삭제 가능
5. 수정시 수정 시각을 기록
6. 이메일 형식 (xxxx@xxx.xx)가 올바른지 서버, 클라이언트 모두 체크
7. 위 각 항목에 대해 최소 1개의 JUnit TestCase 작성(옵션)