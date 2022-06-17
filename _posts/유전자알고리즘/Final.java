import java.util.Scanner;

public class Final {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// x,y값 입력
		int [] value = new int[20];
		int max = value.length;
				for(int i=0; i<max/2;i++) {
					value[i]=i+1;
				}
				Scanner sc = new Scanner(System.in);
				System.out.println("가격을 입력하시오.");
				for(int i=max/2; i<max;i++) {
					value[i]=sc.nextInt();
				}
//				for(int i =0; i<max/2; i++) {
//					System.out.println(value[i]+","+value[i+max/2]);
//				}
				// 기울기와 y축값의 범위를 결정할 기준생성
				int average_a = (value[max-1]-value[max/2])/(value[max/2-1]-value[0]);
				int average_b = value[max/2]-value[0]*average_a;
//				System.out.println(average_a+","+average_b);
				
				// 최초의 랜덤한 a,b값을 가진 식 8개 만들기
				double[] candidates = new double[16];
				int c_max=candidates.length;
				
				for(int i=0; i< c_max/2;i++) {
					candidates[i]=(int)(Math.random()*average_a*2);
				}
				for(int i=c_max/2;i<c_max;i++) {
					candidates[i]=(int)(Math.random()*average_b*3)-average_b;
				}
//				for(int i=0; i<c_max/2;i++) {
	//				System.out.println(candidates[i]+","+candidates[i+c_max/2]);
//				}
				
				
				double [] selcandidates = new double [c_max];
				double[] fit =new double[c_max/2];
				
				
				// 유전알고리즘 시작, 10000번 반복
				for(int i=0;i<10000;i++) {
					
					
					for(int j=0;j<fit.length;j++) {
						fit[j]=0;
					}
					//오류수					
					for(int k=0; k<fit.length;k++) {
						for(int j=0;j<max/2;j++) {
							if(value[j+max/2]>(candidates[k]*value[j]+candidates[k+c_max/2])) {
								fit[k]=fit[k]+value[j+max/2]-(candidates[k]*value[j]+candidates[k+c_max/2]);
							}
							else {
								fit[k]=fit[k]+(candidates[k]*value[j]+candidates[k+c_max/2])-value[j+max/2];
							}
						}//	System.out.println("fit수"+fit[k]);
					}
					
					// 약육강식의 방법 사용
					for(int j=0; j<c_max/2;j++) {
						int x=(int)(Math.random()*c_max/2-1);
						int y=(int)(Math.random()*c_max/2-1);
						if(fit[x]>fit[y]) {
							selcandidates[j]=candidates[y];
							selcandidates[j+c_max/2-1]=candidates[y+c_max/2-1];
						}
						else {
							selcandidates[j]=candidates[x];
							selcandidates[j+c_max/2-1]=candidates[x+c_max/2-1];
						}
					}
					
					// 자손
					for(int j=0;j<c_max/4;j++) {
						candidates[j]=(selcandidates[j]+selcandidates[j+4])/2+3;
						if((selcandidates[j]+selcandidates[j+4])/2-3>0) {
							candidates[j+4]=(selcandidates[j]+selcandidates[j+4])/2-3;
						}
						else {
							candidates[j+4]=(selcandidates[j]+selcandidates[j+4])/2+1;
						}
						candidates[j+c_max/2]=(selcandidates[j+c_max/2]+selcandidates[j+c_max/2+4])/2+3;
						candidates[j+c_max/2+4]=(selcandidates[j+c_max/2]+selcandidates[j+c_max/2+4])/2-3;
	//					System.out.println("j,"+candidates[j]+",j+4,"+candidates[j+4]+",j+c_max/2,"+candidates[j+c_max/2]+",j+c_max/2+4,"+candidates[j+c_max/2+4]);
					}
					
					// 돌연변이
					int change= (int)(Math.random()*1);
					int select= (int)(Math.random()*8);
					if(change==0) {
						candidates[select]=candidates[select]+3;
						candidates[select+c_max/2]=candidates[select+c_max/2]+3;
					}
/*					for(int j=0; j<c_max/2;j++) {
						if(fit[j]<100) {
							System.out.println("기울기: "+candidates[j]+", y축: "+candidates[j+c_max/2]);
							System.out.println("오류수: "+fit[j]);
						}
						
					}*/
				}
/*				for(int i=0; i<fit.length;i++) {
				 fit[i]+=fit[i];
				}
				System.out.println(fit[fit.length-1]);*/
				for(int i=0;i<fit.length;i++) {
					System.out.println(i+1+"번째 기울기: "+candidates[i]+", y축: "+candidates[i+fit.length]);
					System.out.println("오류수: "+fit[i]);
				}
	}
}
						
						
	
