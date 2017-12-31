public class SubtitleSeqImp implements SubtitleSeq{
    private List <Subtitle> list;
    TimeImp t;
    public SubtitleSeqImp() {
        list = new LinkedList<Subtitle>();
    }
    
    
    public void addSubtitle(Subtitle st) {
        list.insert(st);
    }

    
    public List<Subtitle> getSubtitles() {
    	

    	DoubleLinkedList<Subtitle> list2= new DoubleLinkedList<Subtitle>();
    	Subtitle S1;
    	Subtitle S2;
    	int size=0;
    	if(!list.empty())
    	size=1;
    	else
    	return null;
    	list.findFirst();
    	while(!list.last()){
    	size++;
    	list.findNext(); }

    	if(size==1)
    	return list;


    	list.findFirst();
    	for(int i=0;i<size;i++){
    	list2.insert(list.retrieve());
    	list.findNext();}




    	for (int i=0 ; i<size-1; i++) {
    	list2.findFirst();
    	for (int j=0; j<size-1-i ; j++) {
    	list2.findNext();
    	S1=list.retrieve();
    	list2.findPrevious();
    	S2=list2.retrieve();

    	
    	
    	
    	
    	double h1, h2, m1, m2, s1, s2, ms1, ms2;
    	
    	 Time st=S2.getStartTime();
        h2=(st.getHH())*3600000;
          m2=(st.getMM())*60000;
         s2=(st.getSS())*1000;
        ms2=st.getMS();
        double tot1=h2+m2+s2+ms2;

    	        Time m=S1.getStartTime();
    	          h1=(m.getHH())*3600000;
    	          m1=(m.getMM())*60000;
    	          s1=(m.getSS())*1000;
    	          ms1=m.getMS();
    	          double tot2=h1+m1+s1+ms1;
    	         
    	         
    	         
    	         if(tot2 > tot1)
    	         {
    	list2.update(S2);
    	list2.findNext();
    	list2.update(S1);
    	list2.findPrevious();
    	list2.findNext();
    	}
    	else
    	list2.findNext(); }
    	}

    	list2.findFirst();
    	list.findFirst();
    	for(int i=0;i<size;i++){
    	list.insert(list2.retrieve());
    	list2.findNext();}

    	return list;    
    	  
    	   
    	   }

    
    public Subtitle getSubtitle(Time time) {
    list.findFirst();
    while (!list.last()){
                   if((list.retrieve().getStartTime().equals(time)==true) && (list.retrieve().getEndTime().equals(time)==true))
                                return list.retrieve();
                                list.findNext();

            }
            if((list.retrieve().getStartTime().equals(time)==true) && (list.retrieve().getEndTime().equals(time)==true))
                                return list.retrieve();
 return null;
        }
        
    

    
    public List<Subtitle> getSubtitles(Time startTime, Time endTime) {
        List newList = new LinkedList<Subtitle>();
        list.findFirst();
       
        while(!list.last()){
            
            if((list.retrieve().getStartTime().equals(startTime)) && (endTime.equals(list.retrieve().getEndTime()))){
                newList.insert(list.retrieve());
                 return newList;}
            
            list.findNext();
            
        }
        if((list.retrieve().getStartTime().equals(startTime)) && (endTime.equals(list.retrieve().getEndTime()))){
                newList.insert(list.retrieve());
                return newList;}

        return null;
    }

    
    public List<Subtitle> getSubtitles(String str) {
    	LinkedList<Subtitle> newList = new LinkedList<Subtitle>();
        list.findFirst();
        
        while(!list.last() ){
            
            if(list.retrieve().getText().contains(str)){
                newList.insert(list.retrieve());
                
          
                }
            list.findNext();
        }
        if(list.retrieve().getText().contains(str))
                newList.insert(list.retrieve());
                

        return newList;
    
   }

    
    public void remove(String str) {
    list.findFirst();
        
        while(!list.empty() && str!=null){
            
            if(list.retrieve().getText().contains(str)){
                list.remove();
            }
            list.findNext();
            
        }
    }

    
    public void replace(String str1, String str2) {
    list.findFirst();
        
        while(!list.empty() && str1!=null){
            
            if(list.retrieve().getText().contains(str1)){
                list.retrieve().setText(str2);
            }
            list.findNext();
            
        }
    }

    
    public void shift(int offset) {
    list.findFirst();
       
        while(!list.last()){
            
           t.calc(offset);
            list.findNext();
                    }
    }
    /*public void shift(int offset){
        int absoffset = Math.abs(offset);
        int millsecond = absoffset % 1000;
        int second = absoffset / 1000;
        int minut = (absoffset / 1000) / 60;
        int hours = ((absoffset / 1000) / 60) / 60;
        if(offset >= 0){
            this.ms += millsecond;
            this.ss += second;
            this.mm += minut;
            this.hh += hours;
        }
        else{
            this.ms -= millsecond;
            this.ss -= second;
            this.mm -= minut;
            this.hh -= hours;
        }
    }used*/

    
    public void cut(Time startTime, Time endTime) {
    list.findFirst();
     
        while(!list.empty() && !list.last()){
            
            if(greaterThan(list.retrieve().getStartTime(),startTime) && greaterThan(list.retrieve().getEndTime(), endTime)){
                list.remove();
            }
            list.findNext();
            
        }
    }
       /* public void shift(int offset){
        startTime.shift(offset);
        endTime.shift(offset);
    }used it*/
        public boolean greaterThan(Time t, Time t1) {
        
        if(t.getHH() > t1.getHH()){
            return true;
        }
        else{
            if(t.getMM()> t1.getMM()){
                return true;
            }
            else{
                if(t.getSS() > t1.getSS()){
                    return true;
                }
                else{
                    if(t.getMS() > t1.getMS()){
                        return true;
                    }
                    return false;
                }
            }
        }
    }
}