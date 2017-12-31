

	public class TimeImp implements Time{

	    private int hh;
	    private int mm;
	    private int ss;
	    private int ms;

	    public TimeImp(int hh, int mm, int ss, int ms) {
	        this.hh = hh;
	        this.mm = mm;
	        this.ss = ss;
	        this.ms = ms;
	    }

	    public TimeImp(String hh, String mm, String ss, String ms) {
	        this.hh = Integer.parseInt(hh);
	        this.mm = Integer.parseInt(mm);
	        this.ss = Integer.parseInt(ss);
	        this.ms = Integer.parseInt(ms);
	    }

	    
	    
	    public int getHH() {
	        return hh;
	    }

	    
	    public int getMM() {
	        return mm;
	    }

	    
	    public int getSS() {
	        return ss;
	    }

	   
	    public int getMS() {
	        return ms;
	    }

	    
	    public void setHH(int hh) {
	        this.hh = hh;
	    }

	    
	    public void setMM(int mm) {
	        this.mm = mm;
	    }

	    
	    public void setSS(int ss) {
	        this.ss = ss;
	    }

	    
	    public void setMS(int ms) {
	        this.ms = ms;
	    }
	    public void shift(int offset){
	    if (offset>=0){
	        int millsecond = offset % 1000;
	        int second = offset / 1000;
	        int minut = (offset / 1000) / 60;
	        int hours = ((offset / 1000) / 60) / 60;
	        
	            this.ms += millsecond;
	            this.ss += second;
	            this.mm += minut;
	            this.hh += hours;
	        }
	        else{
	            /*this.ms -= millsecond;
	            this.ss -= second;
	            this.mm -= minut;
	            this.hh -= hours;*/
	            
	        this.ms = 0;
	        this.ss = 0;
	         this.mm = 0;
	         this.hh = 0;
	            

	        }
	    }

	    
	   public boolean greaterThan(Time t) {
	        
	        if(this.hh > t.getHH()){
	            return true;
	        }
	        else{
	            if(this.mm > t.getMM()){
	                return true;
	            }
	            else{
	                if(this.ss > t.getSS()){
	                    return true;
	                }
	                else{
	                    if(this.ms > t.getMS()){
	                        return true;
	                    }
	                    return false;
	                }
	            }
	        }
	    }
	}


