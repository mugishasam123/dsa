package exercises;

class countPrimes {
    public int countPrime(int n) {
        
        int count =0;
        boolean [] primes = new boolean[n];
        for(int i=2;i<n;i++)
            primes[i]=true;
        for(int i=2;i*i<n;i++){
            if(primes[i])
               for(int j=i*i;j<n;j+=i)
                    primes[j]=false;
        }

        for(int i=2;i<n;i++)
           if(primes[i])
              count++;
    

    return count;

        
      
    }
    

}