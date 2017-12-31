import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class SubtitleSeqFactory {
   private static SubtitleSeq seq;
   // Return an empty subtitles sequence
   public static SubtitleSeq getSubtitleSeq() {
   seq=new SubtitleSeqImp();
      return seq;
   }
   
   public SubtitleSeqFactory() {
      seq = new SubtitleSeqImp();
   }
   
   // Load a subtitle sequence from an SRT file. If the file does not exist or
   // is corrupted (incorrect format), null is returned.
   public static SubtitleSeq loadSubtitleSeq(String fileName) {
      File file = new File(fileName);
      BufferedReader br = null;
      FileReader fr = null;
      
      try {
         fr = new FileReader(fileName);
         br = new BufferedReader(fr);
      
         String stringfile = "";
         String sCurrentLine;
      
         while ((sCurrentLine = br.readLine()) != null) {
            stringfile += sCurrentLine + "\n";
         }
         String[] arr =stringfile.split("\\r?\\n\\n"); // split string to subtitle
         for(int i = 0; i < arr.length; i++){
            String[] content =arr[i].split("\\r?\\n"); // split subtitle to time, and str
            int id = Integer.parseInt(content[0]);
            String time = content[1];
            String time1=time.substring(time.indexOf('>'));
            time=time.substring(0,time.indexOf('-'));
            TimeImp startTime = new TimeImp(time.substring(0,time.indexOf(':')), time.substring(time.indexOf(':')+1,time.lastIndexOf(':')), time.substring(time.lastIndexOf(':')+1,time.indexOf(',')), time.substring(time.indexOf(',')+1));
            TimeImp endTime = new TimeImp(time1.substring(0,time1.indexOf(':')), time1.substring(time1.indexOf(':')+1,time1.lastIndexOf(':')), time1.substring(time1.lastIndexOf(':')+1,time1.indexOf(',')), time1.substring(time1.indexOf(',')+1));
            String subtitleStr = "";
            for(int j = 2; j < content.length; j++) {
               subtitleStr += content[j] + "\n";
            }
            SubtitleImp sub = new SubtitleImp(startTime, endTime, time);
            seq.addSubtitle(sub);
         }
         return seq;
      } 
      catch (FileNotFoundException ex) {
         Logger.getLogger(SubtitleSeqFactory.class.getName()).log(Level.SEVERE, null, ex);
      } 
      catch (IOException ex) {
         Logger.getLogger(SubtitleSeqFactory.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
   } 
     
}
