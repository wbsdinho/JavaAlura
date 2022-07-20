
public class BuildStar {
    public static String star(Float classificacao){
        String stars;
        Integer i = Math.round(classificacao);
        if(i <=2){
            stars = "\u2b50";
        }else if(i <= 4){
            stars = "\u2b50 \u2b50 ";
        }else if(i <= 6){
            stars = "\u2b50 \u2b50 \u2b50";
        }else if(i <= 8){
            stars = "\u2b50 \u2605 \u2b50 \u2b50";
        }else {
            stars = "\u2b50 \u2605 \u2b50 \u2b50 \u2b50";    
        }
        
        return stars;
    }
}
