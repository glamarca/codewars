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
        return String.format("%d annees, %d jours, %d heures, %d minutes, %d secondes",annees, jours, heures, minutes, secondes_restantes);
    }
}
