
	public class SubtitleImp implements Subtitle{
	    private Time startTime;
	    private Time endTime;
	    private String text;

	    public SubtitleImp(){
	    }

	    public SubtitleImp(Time startTime, Time endTime, String text) {
	        this.startTime = startTime;
	        this.endTime = endTime;
	        this.text = text;
	    }

	    
	    public Time getStartTime() {
	        return startTime;
	    }

	    
	    public Time getEndTime() {
	        return endTime;
	    }

	    
	    public String getText() {
	        return text;
	    }

	    
	    public void setStartTime(Time startTime) {
	        this.startTime = startTime;
	    }

	    
	    public void setEndTime(Time endTime) {
	        this.endTime = endTime;
	    }

	    
	    public void setText(String text) {
	        this.text = text;
	    }
	    
	/*public void shift(int offset){
	        startTime.shift(offset);
	        endTime.shift(offset);
	    }
	    public void shift(int offset){
	        int absoffset = Math.abs(offset);
	        int millsecond = absoffset % 1000;
	        int second = absoffset / 1000;
	        int minut = (absoffset / 1000) / 60;
	        int hours = ((absoffset / 1000) / 60) / 60;
	        if(offset >= 0){
	            getMS() += millsecond;
	            getSS() += second;
	            getMM() += minut;
	            getHH() += hours;
	        }
	        else{
	            getMS() -= millsecond;
	            getSS() -= second;
	            getMM() -= minut;
	            getHH() -= hours;
	        }
	    }*/
	    
	}


