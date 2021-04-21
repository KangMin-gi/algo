1. 일일야채

----
> 선형
- Stack
   - LIFO
- Queue
   - FIFO
- Binary Tree
- Linked List
- Deque
- Array 
----
>비선형
- Tree
- Graph
   
----
> Plus
- Heap
  - 최대, 최소 값을 찾아내기 위해 만들어진 자료구
  - 완전 이진 트리의 일종 (Full Binary Tree)
  - 반정렬 상태를 유지한다
    - 반 정렬 상태란 느슨한 정렬로, 큰 값이 상위레벨, 작조은값이 하위레벨에 있다는 의미.(max heap, min heap 은 반대)
  - 힙 트리는 중복된 값을 허용한다.
  - 삽입 로직은 다음과 같다. (배열 예제 + max heap)
    - 배열의 맨 끝에 값을 삽입
    - 부모의 값과 비교해서 조건에 맞게 교환 (max heap을 기준으로, 삽입된 값이 부모보다 크면 교환)
    - 조건이 만족하지 않거나, 부모까지 가게되면 멈춘다.
  - 삭제 로직은 다음과 같다. (배열 예제 + max heap)
    - 최대값인 root node를 삭제 (max heap 에서의 삭제는, 항상 최대값을 삭제한다.)
    - 
- Priority Queue
  - 우선순위 큐는 가장 우선순위가 높은 데이터가 나간다.
  - 네트워크 트래픽 등에서 사용된다.
  - 배열 , 연결리스트, 힙으로 구현 가능
    - 속도적인 측면 떄문에 힙을 주로 사용한다.
    - 배열, 연결리스트는 삽입(log(n)), 삭제(log(1))을 worst로 가진다.
    - 힙은 둘다 (logN) 의 속도를 가진다.
  
- BST (Binary Search Tree)
- Matrix