public class Binomial
{
    double probability;
    double px;
    int Times;
    int count;
    //set value
    public Binomial(int Times, int count, double probability)
    {
        
        this.Times = validTime(Times);
        this.count = validCount(count);
        this.probability = validProb(probability);
        this.px = this.probability(this.Times, this.count, this.probability);   
    }
    
    //get value from each attribute
    //probability on 1 times
    public double gP()
    {
        return this.probability;
    }
    //Px
    public double gPx()
    {
        return this.px;
    }
    //number of sample
    public int gTimes()
    {
        return this.Times;
    }
    //number of event
    public int gCount()
    {
        return this.count;
    }
    //passed
    long factorial(int n)
    {
        //ex: 5 => 5*4*3*2*1
        if(n == 1 || n == 0)
        {
            return 1;
        }
        return n * factorial(n-1);
    }
    //trouble -> divided by 0
    long combine(int n1, int n2)
    {
        if(n2 > n1)
        {
            // int subs = n2 - n1;
            return factorial(n2)/(factorial(n1) * factorial(n2 - n1));
        }
        // int subs = n1 - n2;
        return factorial(n1)/(factorial(n2) * factorial(n1 - n2));
    }
    //fixed
    double probability(int Times, int count, double probability)
    {
        // type convertion
        double x1 = Times;
        double x2 = count;
        if(count > Times)
        {
            return (combine(count, Times)) * Math.pow(probability, Times) * Math.pow((1 - probability), (x2 - x1));
        }
        //if Times > count
        return (combine(Times, count)) * Math.pow(probability, count) * Math.pow((1 - probability), (x1 - x2));
    }
    //args validation
    //max time checker
   int validTime(int time)
   {
        if(time > 30)
        {
            return 30;
        } 
        else if(Math.abs(time) > 30)
        {
            return 30;
        } 
        else if (time < 0)
        {
            return Math.abs(time);
        }
        return time;
   }
   //max event checker
   int validCount(int count)
   {
    if(count > 30)
    {
        return 30;
    } 
    else if(Math.abs(count) > 30)
    {
        return 30;
    } 
    else if (count < 0)
    {
        return Math.abs(count);
    }
    return count;
   }

   double validProb(double probability)
   {
        //if p < 0 and abs: p >=1 ex:-2
        if (Math.abs(probability) >= 1)
        {
            return 1;
        }
        //if p>1 ex:2
        else if(probability >= 1)
        {
            return 1;
        }
        //if p < 0 and abs:p <1 ex: -0.5
        else if(Math.abs(probability) < 1)
        {
            return Math.abs(probability);
        }
        //if p>=0 and p<1
        return probability;    
   }
    //display value
    public void display()
    {
        System.out.println("sample: " + this.Times);
        System.out.println("Jumlah kejadian: " + this.count);
        System.out.println("peluang suatu kejadian: " + this.probability);
        System.out.println("peluang binomial: " + this.px);
    }
}