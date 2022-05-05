# 정렬알고리즘

### 버블 정렬(Bubble Sort)

: 이웃하는 숫자를 비교하여 작은 수를 앞쪽으로 이동시키는 과정을 반복하여 정렬하는 알고리즘.

``` java
import java.util.Arrays;

public class Bubble {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //실행전
		for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
			int[] a = new int[t];
			for (int i = 0; i < t; i++) {
				a[i] = (int) (Math.random() * t); // 랜덤배열
       	     // a[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
      	      // a[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
			}
		
			// System.out.println("<정렬 전>"+Arrays.toString(a));
		
			int b;
			for(int i = 0 ; i < a.length ; i ++) {
				for(int j = 0 ; j < a.length -i -1 ; j ++) {
					if(a[j]>a[j+1]) {
						b = a[j];
						a[j] = a[j+1];
						a[j+1] = b;
					}
				}
			}
			// System.out.println("<정렬 후>"+Arrays.toString(a));
			long end = System.currentTimeMillis();
			long sec= (end-start);
			System.out.println("시간(ms) : "+sec);
            System.out.println();
		}
	}
}
```

1. 랜덤 배열 (average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 2             | 2             | 2             | 4             | 6             | 9              | 21             | 54             | 164            | 651            | 2695           | 11112          | 45271          | 183547         | 749540         | 3043468        |
| 2    | 2             | 3             | 3             | 4             | 6             | 10             | 24             | 54             | 171            | 665            | 2760           | 11576          | 47316          | 186914         |                |                |
| 3    | 2             | 2             | 3             | 4             | 6             | 9              | 20             | 39             | 154            | 633            | 2649           | 11082          | 44771          | 178273         |                |                |
| 4    | 1             | 2             | 2             | 3             | 5             | 8              | 17             | 38             | 165            | 716            | 2951           | 11660          | 46724          |                |                |                |
| 5    | 2             | 2             | 3             | 4             | 6             | 9              | 19             | 44             | 162            | 727            | 2896           | 11579          | 47284          |                |                |                |
| 6    | 3             | 3             | 4             | 5             | 7             | 9              | 20             | 42             | 170            | 719            | 3037           | 12264          | 49715          |                |                |                |
| 7    | 1             | 2             | 2             | 3             | 5             | 8              | 21             | 42             | 160            | 667            | 2806           | 11867          | 45481          |                |                |                |
| 8    | 2             | 2             | 3             | 4             | 6             | 9              | 21             | 44             | 151            | 631            | 2665           | 11087          | 44949          |                |                |                |
| 9    | 2             | 2             | 3             | 4             | 7             | 9              | 21             | 50             | 158            | 639            | 2699           | 11088          | 45011          |                |                |                |
| 10   | 2             | 2             | 3             | 4             | 6             | 9              | 22             | 45             | 149            | 611            | 2691           | 11064          | 44981          |                |                |                |
| 평균 | 1.9           | 2.2           | 2.8           | 3.9           | 6             | 8.9            | 20.6           | 45.2           | 160.4          | 665.9          | 2784.9         | 11437.9        | 46150.3        |                |                |                |

2. 오름차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 1             | 2             | 3             | 5              | 35             | 47             | 97             | 289            | 1059           | 4067           | 16184          |                |                |                |

3. 내림차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 2             | 3             | 4             | 6             | 8              | 18             | 38             | 106            | 375            | 1446           | 5747           | 22928          |                |                |                |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Bubble.jpg?raw=true)

---

### 선택 정렬(Selection Sort)

: 입력 배열 전체에서 최솟값을 선택하여 배열의 0번 원소와 자리를 바꾸고, 다음에는 0번 원소를 제외한 나머지 원소에서 최솟값을 선택하여, 배열의 1번 원소와 자를 바꾼다. 이러한 방식으로 마지막에 2개의 원소중에서 작은 값을 선택하여 자리를 바꿈으로써 오름차순의 정렬을 마친다.

``` java
import java.util.Arrays;

public class Select {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //실행전
		for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
		int[] a = new int[t];
		for (int i = 0; i < t; i++) {
			a[i] = (int) (Math.random() * t); // 랜덤배열
	       	//	a[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
	        //  a[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
		}

		// System.out.println("<정렬 전>"+Arrays.toString(a));
		
		int b;
		for(int i = 0 ; i <  a.length -1 ; i ++) {
			for(int j = i+1 ; j < a.length ; j ++) {
				if(a[i] > a[j]) {
					b = a[j];
					a[j] = a[i];
					a[i] = b;
				}
			}
		}
		
		// System.out.println("<정렬 후>"+Arrays.toString(a));
		long end = System.currentTimeMillis();
		long sec= (end-start);
		System.out.println("시간(ms) : "+sec);
		System.out.println();
		}
	}
}
```

1. 랜덤배열(average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 1             | 2             | 2             | 3             | 5             | 8              | 40             | 74             | 204            | 744            | 2836           | 11325          | 45408          | 175533         | 705038         | 2831902        |
| 2    | 2             | 2             | 2             | 3             | 5             | 9              | 41             | 75             | 207            | 762            | 2843           | 11077          | 44299          |                |                |                |
| 3    | 2             | 2             | 2             | 3             | 5             | 8              | 41             | 74             | 215            | 742            | 2882           | 11130          | 43952          |                |                |                |
| 4    | 1             | 2             | 2             | 3             | 5             | 8              | 41             | 77             | 220            | 765            | 2909           | 11197          | 43876          |                |                |                |
| 5    | 2             | 2             | 3             | 5             | 7             | 11             | 26             | 64             | 196            | 723            | 2851           | 11180          | 44064          |                |                |                |
| 6    | 2             | 2             | 2             | 3             | 6             | 10             | 42             | 78             | 207            | 739            | 2800           | 11115          | 43713          |                |                |                |
| 7    | 2             | 2             | 2             | 3             | 6             | 10             | 43             | 77             | 216            | 747            | 2849           | 11171          | 44093          |                |                |                |
| 8    | 2             | 2             | 3             | 4             | 6             | 9              | 42             | 77             | 212            | 784            | 2883           | 11139          | 43764          |                |                |                |
| 9    | 2             | 3             | 3             | 4             | 6             | 11             | 23             | 56             | 190            | 720            | 2867           | 11139          | 43892          |                |                |                |
| 10   | 2             | 3             | 3             | 4             | 6             | 9              | 42             | 75             | 207            | 732            | 2872           | 11189          | 44081          |                |                |                |
| 평균 | 1.8           | 2.1           | 2.4           | 3.5           | 5.7           | 9.3            | 38.1           | 72.7           | 207.4          | 745.8          | 2859.2         | 11166.2        | 44114.2        |                |                |                |

2. 오름차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 1             | 1             | 3             | 6              | 37             | 45             | 74             | 189            | 644            | 2485           | 9913           |                |                |                |

3. 내림차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 2             | 2             | 3             | 5             | 8              | 18             | 35             | 100            | 342            | 1314           | 5292           | 20716          |                |                |                |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Selection.jpg?raw=true)

---

### 삽입 정렬(Insertion Sort)

: 배열의 정렬된 부분(앞부분)과 정렬이 안 된 부분(뒷 부분)으로 나누고, 정렬이 안 된 부분의 가장 왼쪽 원소를 정렬된 부분의 적절한 위치에 삽입하여 정렬되도록 하는 과정을 반복한다.


``` java
import java.util.Arrays;

public class Insertion {
	static int[] nums;

	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //실행전
		for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
		nums = new int[t];
		for (int i = 0; i < t; i++) {
				nums[i] = (int) (Math.random() * t); //랜덤 배열
		 	//	nums[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
			//   nums[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
		}

		// System.out.println("<정렬 전>"+Arrays.toString(nums));
		
		for(int i = 1; i < nums.length; i++) {
			// 현재 선택된 원소의 값을 임시 변수에 저장해준다.
			int temp = nums[i];
			// 현재 원소를 기준으로 이전 원소를 탐색하기 위한 index 변수.
			int prev = i - 1;
			// 현재 선택된 원소가 이전 원소보다 작은 경우까지만 반복. 단, 0번째 원소까지만 비교한다.
			while(prev >= 0 && nums[prev] > temp) {
				// 현재 선택된 원소가 현재 탐색중인 원소보다 작다면, 해당 원소는 다음 인덱스로 미뤄버린다.
				nums[prev + 1] = nums[prev];
				// 다음 대상 원소를 탐색한다.
				prev--;
			}
			// 탐색이 종료된 지점에 현재 선택되었던 변수의 값을 삽입해준다.
			nums[prev + 1] = temp;
		}
		
		// System.out.println("<정렬 후>"+Arrays.toString(nums));
		long end = System.currentTimeMillis();
		long sec= (end-start);
		System.out.println("시간(ms) : "+sec);
		System.out.println();
		}
	}
}

1. 랜덤배열(average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 2             | 2             | 3             | 3             | 5             | 6              | 11             | 25             | 54             | 168            | 617            | 2444           | 10202          | 38058          | 153240         | 619699         |
| 2    | 2             | 3             | 3             | 4             | 6             | 7              | 13             | 27             | 56             | 172            | 631            | 2526           | 9767           |                |                |                |
| 3    | 3             | 3             | 3             | 4             | 6             | 7              | 12             | 26             | 56             | 174            | 625            | 2453           | 9773           |                |                |                |
| 4    | 3             | 3             | 3             | 4             | 6             | 7              | 13             | 28             | 57             | 171            | 624            | 2501           | 9781           |                |                |                |
| 5    | 3             | 3             | 3             | 4             | 6             | 7              | 12             | 27             | 56             | 178            | 634            | 2496           | 9764           |                |                |                |
| 6    | 2             | 2             | 2             | 3             | 5             | 7              | 11             | 26             | 54             | 171            | 625            | 2526           | 9768           |                |                |                |
| 7    | 4             | 4             | 5             | 8             | 12            | 16             | 24             | 54             | 84             | 199            | 651            | 2513           | 9834           |                |                |                |
| 8    | 2             | 2             | 3             | 3             | 5             | 6              | 11             | 25             | 54             | 168            | 618            | 2479           | 9801           |                |                |                |
| 9    | 2             | 2             | 3             | 3             | 5             | 7              | 12             | 27             | 56             | 171            | 626            | 2503           | 9755           |                |                |                |
| 10   | 2             | 2             | 2             | 3             | 5             | 8              | 12             | 27             | 57             | 173            | 625            | 2449           | 9776           |                |                |                |
| 평균 | 2.5           | 2.6           | 3             | 3.9           | 6.1           | 7.8            | 13.1           | 29.2           | 58.4           | 174.5          | 627.6          | 2489           | 9822.1         |                |                |                |

2. 오름차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 1             | 1             | 1             | 1              | 1              | 2              | 2              | 4              | 4              | 5              | 7              | 10             | 17             | 28             |

3. 내림차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 2             | 2             | 4             | 7              | 13             | 61             | 117            | 343            | 1240           | 4915           | 19574          |                |                |                |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Insertion.jpg?raw=true)

---

### 쉘 정렬(Shell Sort)

: 버블 정렬이나 삽입 정렬의 단점을 보완하기 위해서 삽입 정렬을 이용하여 배열 뒷부분의 작은 숫자를 앞부분으로 빠르게 이동시키고, 동시에 앞부분의 큰 숫자는 뒷부분으로 이동시키며, 가장 마지막에는 삽입 정렬을 수행한다.

``` java
import java.util.Arrays;

public class Shell {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //실행전
		for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
		int[] list = new int[t];
		for (int i = 0; i < t; i++) {
			list[i] = (int) (Math.random() * t); // 랜덤 배열
		 	//	list[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
			//  list[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
		}
		int size= list.length;
		shellSort(list,size);
		long end = System.currentTimeMillis();
		long sec= (end-start);
		System.out.println("시간(ms) : "+sec);
		System.out.println();
		}
		
	}
	public static void intervalSort(int a[], int begin, int end, int interval) {
		int j;
		for(int i=begin+interval;i<=end;i=i+interval) {
			int item = a[i];
			for(j=i-interval;j>=begin && item<a[j];j=j-interval){
				a[j+interval]=a[j];
			}
			a[j+interval]=item;
		}
	}
	public static void shellSort(int[] a, int size) {
		// System.out.println("<정렬 전>"+Arrays.toString(a));
		int interval = size/2;
		while(interval>=1) {
			for(int i=0;i<interval;i++) {
				intervalSort(a, i, size-1, interval);
			}
			// System.out.println("interval ="+interval);
			// System.out.print(Arrays.toString(a)+" ");
			// System.out.println();
			interval=interval/2;
			
		}
	}

			
}
```

1. 랜덤배열(average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 2             | 2             | 2             | 2             | 2             | 3              | 3              | 5              | 7              | 10             | 17             | 38             | 84             | 228            | 586            | 1736           |
| 2    | 2             | 2             | 3             | 3             | 4             | 4              | 5              | 6              | 8              | 12             | 20             | 42             | 102            | 252            | 653            | 1676           |
| 3    | 2             | 2             | 3             | 4             | 4             | 5              | 5              | 7              | 8              | 12             | 20             | 39             | 93             | 252            | 604            | 1561           |
| 4    | 2             | 3             | 3             | 3             | 4             | 5              | 5              | 7              | 9              | 12             | 21             | 40             | 86             | 245            | 724            | 1784           |
| 5    | 2             | 2             | 2             | 2             | 2             | 2              | 2              | 4              | 5              | 9              | 19             | 40             | 114            | 284            | 671            | 1679           |
| 6    | 2             | 2             | 3             | 4             | 4             | 5              | 5              | 7              | 8              | 12             | 21             | 41             | 90             | 243            | 644            | 1591           |
| 7    | 3             | 3             | 3             | 4             | 4             | 5              | 5              | 6              | 10             | 15             | 28             | 52             | 114            | 247            | 619            | 1850           |
| 8    | 2             | 2             | 2             | 3             | 3             | 3              | 4              | 5              | 7              | 11             | 19             | 41             | 94             | 246            | 609            | 1538           |
| 9    | 2             | 2             | 2             | 2             | 3             | 3              | 4              | 5              | 7              | 11             | 22             | 43             | 115            | 273            | 638            | 1883           |
| 10   | 2             | 2             | 2             | 3             | 3             | 3              | 4              | 5              | 7              | 11             | 19             | 42             | 106            | 269            | 637            | 1550           |
| 평균 | 2.1           | 2.2           | 2.5           | 3             | 3.3           | 3.8            | 4.2            | 5.7            | 7.6            | 11.5           | 20.6           | 41.8           | 99.8           | 253.9          | 638.5          | 1684.8         |

2. 오름차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 2             | 2             | 2             | 2             | 2              | 2              | 3              | 4              | 5              | 7              | 9              | 17             | 30             | 53             | 119            |

3. 내림차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 1             | 1             | 1             | 1              | 2              | 2              | 3              | 5              | 8              | 12             | 23             | 48             | 106            | 248            |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Shell.jpg?raw=true)

---

### 힙 정렬(Heap Sort)

: 오름차순의 정렬을 위해 입력 배열을 먼저 큰 숫자가 높은 우선순위를 가지는 최대힙을 만든다. 힙의 루트에는 가장 큰 수가 저장되므로, 루트의 숫자를 힙의 가장 마지막 노드에 있는 숫자와 바꾼다. 즉, 가장 큰 수를 배열의 가장 끝으로 이동시킨 것이다. 그리고 루트에 새로 저장된 숫자로 인해 위배된 힙 조건을 해결하여 힙 조건을 만족시키고, 힙 크기를 1개 줄인다. 이 과정을 반복하여 나머지 숫자를 정렬한다.

``` java
import java.util.Arrays;

public class Heap {
	public static void main(String[] args) {
		long start = System.currentTimeMillis(); //실행전
		for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
		int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = (int) (Math.random() * t); // 랜덤 배열
			//   arr[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
			//	arr[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
		}
		// System.out.println("정렬전"+Arrays.toString(arr));
		
		for(int i=arr.length/2-1;i>=0;i--) {
			heapify(arr, arr.length, i);
		}
		
		// System.out.print("정렬후"+Arrays.toString(arr)+" ");
		long end = System.currentTimeMillis();
		long sec= (end-start);
		System.out.println("시간(ms) : "+sec);
		System.out.println();
		}
	}
	
	public static void heapify(int[] arr, int size, int pNode) {
		int parent = pNode;
		int leftNode = pNode*2+1;
		int rightNode = pNode*2+2;
		int childNode=0;
		
		if(size> leftNode && size> rightNode) {
			childNode = arr[leftNode]> arr[rightNode] ? leftNode : rightNode;
		} else if(size> leftNode &&size<= rightNode) {
			childNode = leftNode;
		}else if(size<=leftNode && size> rightNode) {
			childNode = rightNode;
		} else {
			return;
		}
		
		if(arr[parent] < arr[childNode]) {
			parent = childNode;
		}
		
		if(parent != pNode) {
			swap(arr, pNode, parent);
			heapify(arr, size, parent);
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j]= arr[i];
		arr[i]= tmp;
	}
}

```

1. 랜덤배열(average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 3              | 4              | 5              | 8              | 11             | 16             | 26             | 45             | 81             |
| 2    | 1             | 1             | 2             | 2             | 2             | 2              | 3              | 3              | 4              | 5              | 7              | 9              | 15             | 26             | 46             | 82             |
| 3    | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 4              | 5              | 6              | 8              | 11             | 17             | 28             | 46             | 81             |
| 4    | 2             | 2             | 2             | 2             | 2             | 3              | 3              | 3              | 4              | 5              | 7              | 10             | 16             | 26             | 45             | 82             |
| 5    | 2             | 3             | 3             | 3             | 3             | 3              | 4              | 4              | 5              | 6              | 9              | 12             | 17             | 28             | 46             | 82             |
| 6    | 2             | 2             | 2             | 3             | 3             | 4              | 4              | 5              | 6              | 7              | 9              | 12             | 17             | 29             | 47             | 83             |
| 7    | 2             | 2             | 2             | 2             | 2             | 3              | 3              | 3              | 4              | 5              | 8              | 10             | 16             | 26             | 46             | 87             |
| 8    | 5             | 5             | 5             | 5             | 7             | 8              | 9              | 10             | 10             | 12             | 15             | 20             | 28             | 45             | 67             | 102            |
| 9    | 1             | 1             | 2             | 2             | 2             | 2              | 3              | 3              | 4              | 5              | 8              | 10             | 15             | 26             | 45             | 83             |
| 10   | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 4              | 4              | 6              | 8              | 11             | 17             | 28             | 48             | 86             |
| 평균 | 2.1           | 2.2           | 2.4           | 2.5           | 3             | 3.4            | 3.8            | 4.2            | 5              | 6.2            | 8.7            | 11.6           | 17.4           | 28.8           | 48.1           | 84.9           |

2. 오름차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 1             | 1             | 1             | 1              | 2              | 2              | 2              | 3              | 4              | 5              | 6              | 10             | 16             | 28             |

3. 내림차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 2             | 2             | 2             | 2              | 2              | 2              | 2              | 3              | 4              | 4              | 6              | 7              | 11             | 21             |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Heap.jpg?raw=true)

---

### 퀵 정렬(Quick Sort)

하나의 리스트를 피벗(pivot)을 기준으로 두 개의 비균등한 크기로 분할하고 분할된 부분 리스트를 정렬한 다음, 두 개의 정렬된 부분 리스트를 합하여 전체가 정렬된 리스트가 되게 하는 방법

``` java
import java.util.Arrays;

public class Quick {
    private static void quickSort(int[] arr,int start, int end) {
        int part=partition(arr,start,end);
        if(start<part-1) quickSort(arr,start,part-1);
        if(end>part) quickSort(arr,part,end);
    }

    private static int partition(int[] arr,int start,int end) {
        int pivot=arr[(start+end)/2];
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr,int start,int end) {
        int tmp=arr[start];
        arr[start]=arr[end];
        arr[end]=tmp;
        return;
    }


    public static void main(String[] args) {
    	long start = System.currentTimeMillis(); //실행전
    	for (int t=32; t < 1048577 ; t*=2) {
			System.out.println("입력 개수 : "+t);
    	int[] arr = new int[t];
		for (int i = 0; i < t; i++) {
			arr[i] = (int) (Math.random() * t); // 랜덤 배열
			//   arr[i] = i; // 오름차순 [0, 1, 2, 3, 4, ... t-1]
			//	arr[i] = t-1-i; //내림차순 [t-1, t-2, t-3, ... 0]
		}
		// System.out.println("정렬 전"+Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
     // System.out.println("정렬 후"+Arrays.toString(arr));
        long end = System.currentTimeMillis();
		long sec= (end-start);
		System.out.println("시간(ms) : "+sec);
		System.out.println();
    	}
    }

}
```

1. 랜덤배열(average) 시도횟수&#92;입력개수 걸리는 시간을 나타내는 표이다. (시간 : ms)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
| 1    | 1             | 2             | 2             | 2             | 2             | 3              | 3              | 4              | 5              | 9              | 13             | 21             | 41             | 78             | 154            | 314            |
| 2    | 2             | 2             | 3             | 3             | 3             | 4              | 4              | 5              | 7              | 10             | 14             | 23             | 43             | 80             | 157            | 322            |
| 3    | 2             | 2             | 2             | 2             | 3             | 3              | 4              | 4              | 6              | 8              | 13             | 22             | 41             | 78             | 155            | 310            |
| 4    | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 6              | 7              | 10             | 14             | 24             | 44             | 81             | 156            | 316            |
| 5    | 2             | 2             | 2             | 3             | 3             | 3              | 4              | 5              | 6              | 8              | 13             | 22             | 43             | 81             | 160            | 324            |
| 6    | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 4              | 6              | 8              | 13             | 22             | 45             | 85             | 164            | 362            |
| 7    | 2             | 3             | 3             | 3             | 5             | 5              | 6              | 7              | 10             | 12             | 16             | 28             | 48             | 91             | 170            | 332            |
| 8    | 1             | 2             | 2             | 2             | 3             | 3              | 3              | 4              | 6              | 8              | 14             | 22             | 43             | 83             | 159            | 321            |
| 9    | 2             | 2             | 2             | 2             | 3             | 3              | 3              | 4              | 6              | 8              | 13             | 23             | 44             | 81             | 157            | 314            |
| 10   | 2             | 2             | 2             | 2             | 3             | 3              | 4              | 4              | 6              | 9              | 13             | 22             | 41             | 80             | 156            | 314            |
| 평균 | 1.8           | 2.1           | 2.2           | 2.3           | 3.1           | 3.3            | 3.7            | 4.7            | 6.5            | 9              | 13.6           | 22.9           | 43.3           | 81.8           | 158.8          | 322.9          |

2. 오름차순(best)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 2             | 2             | 2             | 2              | 2              | 3              | 3              | 4              | 7              | 8              | 12             | 18             | 30             | 52             |

3. 내림차순(worst)

| .    | 2<sup>5</sup> | 2<sup>6</sup> | 2<sup>7</sup> | 2<sup>8</sup> | 2<sup>9</sup> | 2<sup>10</sup> | 2<sup>11</sup> | 2<sup>12</sup> | 2<sup>13</sup> | 2<sup>14</sup> | 2<sup>15</sup> | 2<sup>16</sup> | 2<sup>17</sup> | 2<sup>18</sup> | 2<sup>19</sup> | 2<sup>20</sup> |
| ---- | ------------- | ------------- | ------------- | ------------- | ------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- | -------------- |
|      | 1             | 1             | 2             | 2             | 2             | 2              | 2              | 3              | 3              | 5              | 8              | 9              | 12             | 18             | 31             | 56             |

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/Quick.jpg?raw=true)



#### 비교

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/%EB%9E%9C%EB%8D%A4%20%EB%B0%B0%EC%97%B4.jpg?raw=true)

랜덤 배열 성능(좋은 순서) : Heap, Quick, Shell, Insertion, Selection, Bubble

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/%EC%A0%95%EB%A0%AC%EB%90%9C%20%EB%8D%B0%EC%9D%B4%ED%84%B0.jpg?raw=true)

정렬된 데이터(좋은 순서) :  Heap, Insertion, Quick, Shell, Selection, Bubble

![](https://github.com/ojeanghoon/ojeanghoon.github.io/blob/main/_posts/%EC%A0%95%EB%A0%AC%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98/Sort%20Graph/%EC%97%AD%20%EC%A0%95%EB%A0%AC%20%EB%8D%B0%EC%9D%B4%ED%84%B0.jpg?raw=true)

역 정렬된 데이터(좋은 순서) : Heap, Quick, Shell, Insertion, Selection, Bubble
