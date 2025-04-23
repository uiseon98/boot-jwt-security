
# JWT 및 Spring Security 기능 분석

이 프로젝트에는 다음과 같은 JWT(JSON Web Token) 기능이 포함되어 있습니다:

## JWT 기능
1. **토큰 생성 (JwtTokenProvider.java)**
    - 사용자 인증 정보를 기반으로 JWT 토큰 생성
    - 토큰에 사용자명(subject), 발행 시간, 만료 시간 포함
    - HS256 알고리즘으로 서명

2. **토큰 검증 (JwtTokenProvider.java)**
    - 토큰의 유효성 검사 (서명 확인, 만료 여부 등)
    - 예외 처리를 통한 안전한 토큰 검증

3. **사용자 정보 추출 (JwtTokenProvider.java)**
    - 토큰에서 사용자명(username) 추출
    - 토큰에서 인증(Authentication) 객체 생성

4. **JWT 필터 (JwtAuthenticationFilter.java)**
    - 모든 요청에 대해 Authorization 헤더에서 JWT 토큰 확인
    - 유효한 토큰이 있을 경우 SecurityContext에 인증 정보 설정

5. **JWT 설정 (application-dev.yml)**
    - 비밀 키(secret key) 설정
    - 토큰 만료 시간 설정 (3600000ms = 1시간)

## Spring Security 기능

1. **보안 필터 체인 구성 (SecurityConfig.java)**
    - CSRF 보호 비활성화 (REST API를 위한 설정)
    - 상태 비저장(Stateless) 세션 관리 설정
    - URL 기반 접근 제어 설정

2. **인증 및 권한 관리**
    - 특정 경로에 대한 접근 권한 설정:
        - Swagger UI 및 API 문서: 모두 접근 가능
        - `/api/auth/**` (로그인, 회원가입): 모두 접근 가능
        - 그 외 모든 요청: 인증된 사용자만 접근 가능

3. **인증 제공자 설정**
    - DaoAuthenticationProvider를 사용한 사용자 인증
    - 커스텀 UserDetailsService 통합
    - 비밀번호 인코더 설정

4. **JWT 필터 통합**
    - UsernamePasswordAuthenticationFilter 이전에 JWT 필터 추가
    - 토큰 기반 인증 처리

5. **비밀번호 암호화**
    - DelegatingPasswordEncoder를 사용한 비밀번호 암호화

이 프로젝트는 JWT를 사용하여 사용자 인증을 처리하고, Spring Security를 통해 API 엔드포인트에 대한 접근 제어를 구현하는 안전한 RESTful API 서비스를 제공합니다.