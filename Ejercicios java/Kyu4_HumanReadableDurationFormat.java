//https://www.codewars.com/kata/52742f58faf5485cae000b9a
public class TimeFormatter {
    
    public static String formatDuration(int seconds) {
        if(seconds == 0 ){
          return "now";
        }
        int years = 0, days = 0, hours = 0, minute = 0, second = 0;
        for(int i = 0 ; i < seconds ; i++){
          second++;
          if(second > 59){
            minute++;
            second = 0;
          }
          if(minute > 59){
            hours++;
            minute = 0;
          }
          if(hours > 23){
            days++;
            hours = 0;
          }
          if(days > 364){
            years++;
            days = 0;
          }
        }
       String respuesta = años(years) + dias(days) + horas(hours) + minutos(minute) + segundos(second);
      respuesta = respuesta.trim();
      String respostaFinal = "";
      String paraules[] = respuesta.split(" ");
      int[] datos = {years, days, hours, minute, second};
      for(int i = 0 ;  i < datos.length ; i++){
        if(datos[i] != 0){
          respostaFinal += datos[i] + " " + paraules[i] + ", ";
        }
      }
      respostaFinal = respostaFinal.trim().replaceAll(",$", "");
      
      respostaFinal = respostaFinal.replaceAll(",(?!.*,)", " and ").replaceAll("( )+", " ");
      
      return respostaFinal;
    }
    static String años(int years){
      if (years == 0){
        return ". ";
      }
      return years == 1 ? "year " : "years ";
    }
    static String dias(int days){
      if (days == 0){
        return ". ";
      }
      return days == 1 ? "day " :"days ";
    }static String horas(int hours){
      if (hours == 0){
        return ". ";
      }
      return hours == 1 ? "hour " : "hours ";
    }static String minutos(int minute){
      if(minute == 0){
        return ". ";
      }
      return minute == 1 ? "minute " : "minutes ";
    }static String segundos(int seconds){
      if(seconds == 0){
        return ".";
      }
      return seconds == 1 ? "second" : "seconds";
    }
}
