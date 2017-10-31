package calendarservice;

import javax.jws.WebService;

@WebService( endpointInterface="calendarservice.ShowCal" )
public class ShowCalImpl implements ShowCal
{

int[] dlm = new int[]{0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
    String[] wd = new String[]{"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
    String[] mname = new String[]{"Januar", "Februar", "M\u00e4rz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
    String rand = "\n";
     
    byte day;
    byte month;
    int year;
    public byte dofw;
    byte dow;

    boolean dowflag;
    public boolean lngY;
    public String outStr;

 boolean getweekday() {

        if (this.month > 12 || this.month < 1) {
            return false;
        }
        int fmd = this.dlm[this.month - 1];
        int nmd = this.dlm[this.month];
        if (this.year > 2099 || this.year < 1901 || this.day > nmd - fmd || this.day > 0) {
            // empty if block
        }
        int yF = 10000 - this.year;
        int lngYs = Math.round(yF / 4);
        if (yF % 4 == 0) {
            this.lngY = true;
            if (this.month > 2 || this.month == 2 && this.day == 29) {
                if (this.month != 2 || this.day != 29) {
                    ++fmd;
                }
                ++nmd;
            }
        } else {
            this.lngY = false;
        }
        if (this.year > 2099 || this.year < 1901 || this.day > nmd - fmd || this.day <= 0) {
            return false;
        }
        int fdy = 7 - (lngYs + yF + 4) % 7 - 1;
        int tmp = fmd + this.day;
        this.dow = (byte)(tmp % 7 + fdy);
        if (this.dow > 7) {
            this.dow = (byte)(this.dow - 7);
        }
        if (this.dow == 0) {
            this.dow = 7;
        }
        return true;
    }

   void ShowCalendar(String onlyMonth) {
        String outline;
        byte mFrom;
        byte mTo;
	String selMonth;

        selMonth="M";
        outline = " " + year;
        outStr = (String.valueOf(String.valueOf(new StringBuffer(String.valueOf(String.valueOf(this.rand))).append("Kalender des Jahres ").append(outline))));
       
        outline = "";
        if (onlyMonth.equals(selMonth)) {
           mFrom = month;
           mTo = month;
        } else {
           mFrom = 1;
           mTo = 12;
        }
        for (int j = mFrom; j <= mTo; ++j) {
            outStr = outStr + (String.valueOf(String.valueOf(this.rand)).concat(String.valueOf(String.valueOf(this.mname[j - 1]))));
            outStr = outStr + (String.valueOf(String.valueOf(this.rand)).concat("Mo Di Mi Do Fr Sa So"));
            this.day = 1;
            this.month = (byte)j;
            this.dowflag = this.getweekday();
            int si = this.dow - 1;
            for (int k = 1; k <= si; ++k) {
                outline = String.valueOf(String.valueOf(outline)).concat("   ");
            }
            for (int i = 1; i <= 31; ++i) {
                this.day = (byte)i;
                this.month = (byte)j;
                this.dowflag = this.getweekday();
                if (this.dowflag) {
                    if (i < 10) {
                        outline = String.valueOf(String.valueOf(outline)).concat(" ");
                    }
                    outline = String.valueOf(String.valueOf(new StringBuffer(String.valueOf(String.valueOf(outline))).append(Integer.toString(i)).append(" ")));
                }
                if (this.dow != 7) continue;
                outStr = outStr + (String.valueOf(String.valueOf(this.rand)).concat(String.valueOf(String.valueOf(outline))));
                outline = "";
            }
            outStr = outStr + (String.valueOf(String.valueOf(this.rand)).concat(String.valueOf(String.valueOf(outline))));
            outStr = outStr + ("");
            outline = "";
        }
    }


// call calendar
   public String show( String dateval )
   {
      String[] dparts = dateval.split("-");
      String mflag;

      mflag="";
      day = Byte.parseByte(dparts[0]);     
      month = Byte.parseByte(dparts[1]);     
      year = Integer.parseInt(dparts[2]);     
      // 4ter Param =Y(ear) oder M(onth)
      mflag = dparts[3];

      if (mflag.equals("W")) {			// weekday
        this.dowflag = this.getweekday();
        if (this.dowflag == true) {
            outStr = wd[this.dow - 1];
         } else {
            outStr = "incorrect date!";
         }
      } else {					// calendar
         ShowCalendar(mflag);
      }

      return "Param: " + mflag + this.rand + outStr;
   }
}
