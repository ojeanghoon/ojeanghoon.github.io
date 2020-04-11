---
layout: single
title:  "Strassen Algorithm"
date:   2020-04-11 14:37:00 +0900
categories: posts
---

## **Strassen Algorithm(스트라센 알고리즘)**

##### 스트라센 알고리즘은 두 행렬의 곱인 행렬을 덧셈만으로 찾아 기존의 알고리즘에는 O(n^3) 시간이 소요되지만 이를 O(n^2.807)의 시간이 소요되게 개발한 곱셈 알고리즘이다.

A와 B를 정사각행렬이라고 했을 때, 두 해열의 곱 C을 주어줬을 때

![{\displaystyle \mathbf {A} ={\begin{bmatrix}\mathbf {A} _{1,1}&\mathbf {A} _{1,2}\\\mathbf {A} _{2,1}&\mathbf {A} _{2,2}\end{bmatrix}}{\mbox{ , }}\mathbf {B} ={\begin{bmatrix}\mathbf {B} _{1,1}&\mathbf {B} _{1,2}\\\mathbf {B} _{2,1}&\mathbf {B} _{2,2}\end{bmatrix}}{\mbox{ , }}\mathbf {C} ={\begin{bmatrix}\mathbf {C} _{1,1}&\mathbf {C} _{1,2}\\\mathbf {C} _{2,1}&\mathbf {C} _{2,2}\end{bmatrix}}}](https://wikimedia.org/api/rest_v1/media/math/render/svg/41c6337190684aff7b69f124226d6e62d79ebca5)



![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgmttx5uq6pap.jpg%22&type=w2)



![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgmve7rpku5qa.jpg%22&type=w2)

위의 계산식에서는 곱셈이 사용되지 않기에 전체 곱셈을 일곱번의 곱셈과 18번의 덧셈으로 처리할 수 있다.

![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgn49i0ovefhs.jpg%22&type=w2)

![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgn4t6hcsos40.jpg%22&type=w2)

![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgmntt48gttax.jpg%22&type=w2)

![img](https://dthumb-phinf.pstatic.net/?src=%22https%3A%2F%2Fssl.pstatic.net%2Fimages.se2%2Fsmedit%2F2015%2F10%2F7%2Fifgn5g6l0g03ie.jpg%22&type=w2)

즉 O(n^2.807)의 성능을 가지게 된다.

스트라센 알고리즘은 O-Notation 상의 속도는 더 빠르나

재귀적으로 돌려 시간이 오래걸리며, 반복적으로 알고리즘을 바꾸는데 어렵다.

P,Q,R,S,T,U,V를 담아줄 자리를 기억장치 안에 마련해야 하므로, 행렬이 너무 클 경우 자리를 많이 차지한다.