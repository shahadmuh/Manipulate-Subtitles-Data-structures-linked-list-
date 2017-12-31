class TimeImp implements Time {
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
   public int calcToMS(TimeSt st){
int h1, h2, m1, m2, s1, s2, ms1, ms2;

h2=(st.getHH())*3600000;
m2=(st.getMM())*60000;
s2=(st.getSS())*1000;
ms2=st.getMS();
int tot1=h2+m2+s2+ms2;
return tot1;
}
public void calc(int offset){
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
        }}


// public int compareTo(TimeImp t){
// if(calcToMS(this)>calcToMS(t))
// return 1;
// else if(calcToMS(this)<(calcToMS(t))){
// return -1;}
// 
// return 0;}
}

class SubtitleImp implements Subtitle {
	private Time startTime;
	private Time endTime;
	private String text;

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
}

public class Perf {

	public static void main(String[] args) {
		int[] nbSubtitles = { 1 << 12, 1 << 13, 1 << 14, 1 << 15, 1 << 16 };
		int nbRuns = 100;
		int nbSearches = 1000;
		java.util.Random rnd = new java.util.Random(777);

		// A first run that should be ignored
		{
			int nbSts = 10;
			for (int k = 0; k < nbRuns; k++) {
				SubtitleSeq stSeq = SubtitleSeqFactory.getSubtitleSeq();
				// Fill the sequence randomly
				for (int s = 0; s < nbSts; s++) {
					int hh = rnd.nextInt();
					Time start = new TimeSt(hh, 0, 0, 0);
					Time end = new TimeSt(hh, 0, 1, 0);
					stSeq.addSubtitle(new SubtitleSt(start, end, ""));
				}
				// Run random searches
				long stTime = System.nanoTime();
				for (int q = 0; q < nbSearches; q++) {
					stSeq.getSubtitle(new TimeSt(rnd.nextInt(), 0, 0, 0));
				}
				long edTime = System.nanoTime();
			}
		}

		System.out.println("Size\tTime");
		for (int i = 0; i < 5; i++) {
			int nbSts = nbSubtitles[i];
			long time = 0;
			for (int k = 0; k < nbRuns; k++) {
				SubtitleSeq stSeq = SubtitleSeqFactory.getSubtitleSeq();
				// Fill the sequence randomly
				for (int s = 0; s < nbSts; s++) {
					int hh = rnd.nextInt();
					Time start = new TimeSt(hh, 0, 0, 0);
					Time end = new TimeSt(hh, 0, 1, 0);
					stSeq.addSubtitle(new SubtitleSt(start, end, ""));
				}
				// Run random searches
				long stTime = System.nanoTime();
				for (int q = 0; q < nbSearches; q++) {
					stSeq.getSubtitle(new TimeSt(rnd.nextInt(), 0, 0, 0));
				}
				long edTime = System.nanoTime();
				time += edTime - stTime;
			}
			System.out.println(nbSts + "\t" + time / (nbRuns * nbSearches));
		}

	}
   }
