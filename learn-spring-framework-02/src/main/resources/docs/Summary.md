# 중간 정리 `용어 이해하기`

## @Component 
- 이 에너테이션을 추가할 때마다 특정 클래스가 컴포넌트 스캔에 감지된다면
해당 클래스의 인스턴스, 즉 Spring Bean이 생성(그 후 Spring Container에 의해 관리)
- 일반적으로 스프링이 자동으로 인스턴스를 생성하고 관리하는 클래스에 붙임

## Dependency (의존성)
- 한 컴포넌트가 다른 컴포넌트의 기능을 사용해야 할 때 발생하는 관계
- 즉, 하나의 컴포넌트가 기능을 수행하기 위해 다른 컴포넌트가 필요할 때
후자의 컴포넌트를 `의존성`이라고 함
- ex) Car 클래스가 Tire 클래스의 기능을 사용해야 할 때 `Car 클래스는 Tire 클래스에 의존한다라고 말할 수 있음`

## Component Scan (@ComponentScan("패키지명"))
- 스프링이 컴포넌트의 위치를 파악해야 하므로 해당 에너테이션을 붙여 특정 패키지에서 컴포넌트를 검색하게 지시
- 현재 패키지(같은 패키지)에 있을 경우 명시하지 않아도 되나, 다른 패키지에 있을 경우 패키지명 명시

## DI(Dependency Injection) (의존성 주입)
- 객체가 필요로 하는 의존성을 외부에서 주입하는 방법
- 객체 생성 및 의존성 관리 작업을 스프링이 대신 수행하여 코드를 간결하고 유연하게 만듦

## IoC(Inversion of Control) (제어의 역전)
- 이전엔 객체 생성과 의존성에 대한 코드를 개발자가 명시적으로 작성하여 의존성을 통해 객체를 생성했다면
-> 스프링에서는 객체를 생성하고 모두를 와이어링하는 실제 작업은 스프링FW가 수행
- 즉 제어권이 `개발자(명시적인 코드 작성)`에서 `SpringFramework`로 넘어감(제어의 역전)

### Spring Beans : 스프링이 관리하는 모든 객체

### Ioc Container : Bean의 생명 주기와 의존성을 관리하는 Spring의 컴포넌트
 - ApplicationContext
 - BeanFactory ...
 
### Autowiring : 스프링이 Bean의 의존성을 자동으로 해결하고 주입하는 과정
 - @Autowired 에너테이션을 사용하여 필드, 생성자, 메서드 등에 의존성을 주입할 수 있음


# @Component와 @Bean 비교하기
## @Component
- `Where` 모든 자바 클래스에서 사용 가능
- `Ease of use` 어노테이션 추가만으로 간편하게 빈을 정의할 수 있음
- `Auto-wiring` 필드, 세터 메서드, 생성자 주입을 통해 자동으로 의존성 주입
- `Who creates beans` 스프링 프레임워크가 빈 생성 및 관리
- `Recommended For` @Component가 더 권장(에너테이션으로 간편하게 빈 생성 및 해당 의존성을 자동으로 관리하기 때문)

## @Bean
- `Where` 특정 메서드에 적용(일반적으로 Spring Configuration 클래스 메서드)
- `Ease of use` 대비해 조금 더 복잡함(빈 생성 로직을 메서드에 작성해야 함)
- `Auto-wiring` 특정 메서드 호출 혹은 메서드 매개변수를 이용해 의존성 주입
- `Who creates beans` 개발자가 Bean 생성 코드를 작성해야 함
- `Recommended For` Component가 주로 사용되지만 Bean이 자주 사용되는 상황은 있음
1. 제 3자 라이브러리 Bean을 인스턴스화 할때 ex.SpringSecurity
2. Bean을 생성하기 전에 수행해야 하는 비즈니스 로직이 많을 경우