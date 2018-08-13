package org.sarace.codewars;

public class TimeFormatter {
    public static String formatDuration(int seconds) {
        if (seconds == 0){
            return "now";
        }
        Integer annees = seconds/31536000;
        Integer secondes_restantes = seconds%31536000;
        Integer jours = secondes_restantes/86400;
        secondes_restantes = secondes_restantes%86400;
        Integer heures = secondes_restantes/3600;
        secondes_restantes = secondes_restantes%3600;
        Integer minutes = secondes_restantes/60;
        secondes_restantes = secondes_restantes%60;
        StringBuilder resultBuilder = new StringBuilder();
        if(annees != 0){
            if(annees > 1) resultBuilder.append(annees).append(" years, ");
            else resultBuilder.append(annees).append(" year, ");
        }
        if(jours != 0){
            if(jours > 1) resultBuilder.append(jours).append(" days, ");
            else resultBuilder.append(jours).append(" day, ");
        }
        if(heures != 0){
            if(heures > 1) resultBuilder.append(heures).append(" hours, ");
            else resultBuilder.append(heures).append(" hour, ");
        }
        if(minutes != 0){
            if(minutes > 1) resultBuilder.append(minutes).append(" minutes, ");
            else resultBuilder.append(minutes).append(" minute, ");
        }
        if(secondes_restantes != 0){
            if(secondes_restantes > 1) resultBuilder.append(secondes_restantes).append(" seconds, ");
            else resultBuilder.append(secondes_restantes).append(" second, ");
        }
        resultBuilder.deleteCharAt(resultBuilder.lastIndexOf(","));
        String[] splits = resultBuilder.toString().split(",");
        if(splits.length > 1){
            resultBuilder.replace(resultBuilder.lastIndexOf(","), resultBuilder.lastIndexOf(",") + 1, " and");
        }
        return resultBuilder.toString().trim();
    }
}
