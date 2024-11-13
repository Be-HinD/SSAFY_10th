### 이번 챕터의 목표
> 객체지향에 대한 기본적인 내용 정리
 
## 오해
<p> 객체지향을 처음 배울 때 아래와 같이 배웠다. </p>

> 객체지향이란 실세계를 직접적이고 직관적으로 모델링할 수 있는 패러다임

<p> 다시 말하면 객체란 현실 세계에 존재하는 사물에 대한 추상화(모방)라는 뜻 </p>

<p> 이는 철학적인 개념이며, 실무적인 관점에서는 부적합하다! </p>

<br>

## 역할 | 책임 | 협력 관점에서의 객체지향
<p> 책에서는 커피 주문 프로세스로 현실세계의 역할, 책임, 협력 관계를 설명하고 있다. </p>
<p> 손님은 커피를 주문한다. </p>

> 따듯한 아메리카노 한잔 주세요.

<p> 캐시어는 주문을 받는다. </p>

> 4500원 입니다.

<p> 바리스타는 캐시어에게 받은 메뉴를 제조한다. </p>

<p> 위 3명 사이에는 상호작용으로 인한 암묵적인 "협력" 관계가 존재하는 것을 알고 있다. </p>
<p> 또한 손님, 캐시어, 바리스타는 각자만의 "역할"이 존재한다. </p>
<p> 마찬가지로 협력이 원활하게 이루어지기 위해 3명은 맡은 바 "책임"을 다한다. </p>

> 커피 주문이라는 "협력"에 참여하는 인원들은 "역할과 책임"을 다하고 있는 것을 알 수 있다.

> 또한, 손님 <-> 캐시어 <-> 바리스타 사이에는 "요청"과 "응답"이 오고간다.

<br>

<p> 이 과정에서 우리는 3가지의 중요한 개념을 볼 수 있다. </p>

> 어떤 캐시어가 주문을 받아도 상관없다. 즉, 역할은 대체 가능하다.

> 원두의 선택은 바리스타가 때에 맞게 정한다. 즉, 책임을 수행하는 방법은 자율적으로 선택할 수 있다.

> 캐시어가 커피까지 제조할 수 있을 것이다. 즉, 한 사람이 동시에 여러 역할을 수행할 수 있다.

<br>

<p> 지금까지의 커피 주문 프로세스를 객체지향적으로 생각해보자. </p>
<p> 손님, 캐시어, 바리스타는 "객체"로</p>
<p> 협력에서 발생하는 요청은 "메시지"로 </p>
<p> 역할을 수행하는 부분은 "메서드"로 </p>

<p> 이렇게 될 경우 객체지향에 대한 설명이 명쾌하게 이루어진다. </p>

> 이것이 모방 및 추상화라는 은유를 사용하는 이유다.

<br>

<p> 객체지향 설계는 적절한 역할(업무)를 수행하는 객체(사람)에게 적절한 책임(수행)을 할당하는 것에서 시작된다. </p>
<p> <b>책임</b>은 객체지향 설계의 품질을 결정하는 가장 중요한 요소 </p>
<p> <b>역할</b>은 유연하고 재사용 가능한 협력 관계를 구축하는 데 중요한 요소 </p>

<br>

## 객체
> 흔히 객체를 "상태(State)"와 "행동(Behavior)을 함께 지닌 실체라고 정의
<p> 객체가 협력에 참여하기 위해 어떤 행동을 해야 한다면 행동에 필요한 상태도 함께 지니고 있어야 한다. </p>
<p> 커피를 제조하는 바리스타(객체)가 제조 방법(상태)을 모르는 것은 말이 되지 않는다. </p>
<p> 또한 협력 관계에서 다른 객체가 무엇(what)을 수행하는지는 알 수 있지만 어떻게(how) 수행하는지에 대해서는 알 수 없어야 한다. </p>

## 메시지
<p> 객체 사이에 협력이 이루어지기 위해선 객체간의 "요청"이 발생한다. </p>
<p> 요청은 "메시지"로 부르며, 메시지를 수신한 객체는 자신만의 방법에 따라 메시지를 처리한다. </p>
> 이처럼 객체가 수신된 메시지를 처리하는 방법을 "메서드"라고 부른다.

<p> 메시지에 대응되는 메서드는 실행 시간에 선택할 수 있는데, 이는 객체지향 언어와 다른 프로그래밍 언어(절차지향)를 구분 짓는 핵심적인 특징 중 하나다. </p>
<p> 요청을 표현하는 "메시지"와 요청을 처리하는 방법인 "메서드"를 분리하는 것은 객체의 자율성을 높이는 핵심 메커니즘이며, <b>캡슐화</b>라는 개념과도 연관된다. </p>

## 객체지향의 본질
<p> 위 내용을 통해 객체지향을 다시 정의해본다면 다음과 같다. </p>
> 상태와 행위를 지닌 객체들 간의 메시지를 통해 협력하여 시스템의 행위를 구현한다.

> 메시지를 처리하는데 적합한 메서드는 자율적으로 선택한다.

## 추가
<p> 책에서는 클래스 관점이 아닌 객체의 관점으로 사고의 중심을 전환하라고 한다. </p>
<p> 이 뜻을 이해하기 위해 다음과 같은 코드를 예시로 들 수 있을 것 같다. </p>

### 클래스 관점
```java
class Customer {
    private Barista barista;

    public Customer(Barista barista) {
        this.barista = barista;
    }

    public void orderCoffee() {
        System.out.println("커피를 주문합니다.");
        barista.receiveOrder();
    }
}

class Barista {
    public void receiveOrder() {
        System.out.println("주문을 받았습니다. 커피를 준비합니다.");
        makeCoffee();
    }

    private void makeCoffee() {
        System.out.println("커피를 만듭니다.");
    }
}

// 사용 예시
public class CoffeeShop {
    public static void main(String[] args) {
        Barista barista = new Barista();
        Customer customer = new Customer(barista);
        customer.orderCoffee();
    }
}
```
<p> 코드에서 볼 수 있듯, 손님은 바리스타의 상태와 행위를 알고 직접적으로 요청하고 있다.</p>
<p> 이제 메시지를 주고받는 객체의 관점으로 사고의 중심을 전환해보자. </p>

### 메시지를 주고받는 객체의 관점에서 설계
```java
interface Orderable {
    void receiveOrder();
}

class Customer {
    private Orderable orderable;

    public Customer(Orderable orderable) {
        this.orderable = orderable;
    }

    public void orderCoffee() {
        System.out.println("커피를 주문합니다.");
        orderable.receiveOrder();
    }
}

class Barista implements Orderable {
    @Override
    public void receiveOrder() {
        System.out.println("주문을 받았습니다. 커피를 준비합니다.");
        makeCoffee();
    }

    private void makeCoffee() {
        System.out.println("커피를 만듭니다.");
    }
}

// 사용 예시
public class CoffeeShop {
    public static void main(String[] args) {
        Orderable barista = new Barista();
        Customer customer = new Customer(barista);
        customer.orderCoffee();
    }
}
```
<p> 실행 시점에 customer 객체의 상태인 orderable이 결정된다. </p>
<p> 손님은 orderable 객체의 receiveOrder라는 역할은 알지만 어떻게 수행하는지 책임은 모른다. </p>
<p> 이렇게 관점을 바꿔 코드를 작성한 결과, 의존성을 낮추고 유연성(바리스타의 메서드는 변경 용이)을 높일 수 있다. </p>


