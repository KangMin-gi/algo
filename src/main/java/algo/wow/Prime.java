package algo.wow;

public class Prime {
  public boolean isPrime(int n){
    if(n==0 || n==1) return false;
    for(int i=3; i<=(int)Math.sqrt(n); i+=2){
      if(n%i==0) return false;
    }
    return true;
  }

   // 채를 이용해서 구한다.
}